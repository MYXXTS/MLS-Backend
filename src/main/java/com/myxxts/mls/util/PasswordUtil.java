package com.myxxts.mls.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class PasswordUtil {
    private static final Argon2PasswordEncoder argon2Encoder = new Argon2PasswordEncoder(32, 32, 4, 4096, 4);
    private static final Base64 base64 = new Base64();

    /**
     * decode password with Base64
     *
     * @param encodedPassword encoded password
     * @return String decoded password
     */
    private static String decode(String encodedPassword) {
        return new String(base64.decode(encodedPassword));
    }

    /**
     * matches password and encodedPassword
     *
     * @param password plaintext password
     * @param encodedPassword encoded password in database
     * @return Boolean result of matching
     */
    public static Boolean matches(String password, String encodedPassword) {
        return argon2Encoder.matches(password, decode(encodedPassword));
    }

    /**
     * encode password with Argon2PasswordEncoder and Base64
     *
     * @param password plaintext password
     * @return String encoded password
     */
    public static String encode(String password) {
        return base64.encodeToString(argon2Encoder.encode(password).getBytes());
    }

}
