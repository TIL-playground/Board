package module.board.common;

import module.board.common.exception.BadRequestException;
import module.board.common.exception.ServerException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.UUID;

public final class HashUtil {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = UUID.randomUUID().toString().substring(0, 16);
    private static final SecretKeySpec SECRET_KEY_SPEC = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

    private static final Cipher CIPHER;

    static {
        try {
            CIPHER = Cipher.getInstance(ALGORITHM);

        } catch (final Exception e) {
            throw new ServerException("알고리즘이 잘못됐어요.");
        }
    }

    public static String encode(final long id) {
        try {
            CIPHER.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC);

            final var encrypted = CIPHER.doFinal(String.valueOf(id).getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(encrypted);
        } catch (final Exception e) {
            throw new ServerException("암호화 실패");
        }
    }

    public static long decode(final String hash) {
        try {
            CIPHER.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC);

            final var decoded = Base64.getUrlDecoder().decode(hash);
            final var decrypted = CIPHER.doFinal(decoded);

            return Long.parseLong(new String(decrypted));
        } catch (final Exception e) {
            throw new BadRequestException("잘못된 해시값입니다.");
        }
    }
}