package module.board.security;

import dev.paseto.jpaseto.*;
import dev.paseto.jpaseto.lang.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.function.Function;

@Component
class TokenizerImpl implements Tokenizer {
    private final SecretKey secretKey;

    private final KeyPair keyPair;

    private TokenizerImpl() {
        secretKey = Keys.secretKey();
        keyPair = Keys.keyPairFor(Version.V2);
    }

    public String generateToken(String userId) {
        var now = Instant.now();

        return Pasetos.V2.LOCAL.builder()
                .setSharedSecret(secretKey)
                .setIssuer("UsadaPekora")
                .setIssuedAt(now)
                .setSubject(userId)
                .setExpiration(now.plus(2, ChronoUnit.HOURS))
                .setKeyId(UUID.randomUUID().toString())
                .compact();
    }

    public boolean validateToken(String authToken) {
        try {
            parseToken(authToken);
            return !isTokenExpired(authToken);
        } catch (PasetoException e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).isBefore(Instant.now());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final var claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Instant extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims getClaims(String token) {
        return parseToken(token).getClaims();
    }

    private Paseto parseToken(String token) {
        var parser = Pasetos.parserBuilder()
                .setSharedSecret(secretKey)
                .setPublicKey(keyPair.getPublic())
                .build();

        return parser.parse(token);
    }
}
