package module.board.security;

public interface Tokenizer {
    String generateToken(String userId);
    boolean validateToken(String authToken);
    String extractUsername(String token);
}
