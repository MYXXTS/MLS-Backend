package com.myxxts.mls.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordUtilTests {

    @Test
    void testEncryption() {
        String password = "password";
        String encode = PasswordUtil.encode(password);
        System.out.println(encode);
        Boolean matches = PasswordUtil.matches(password, encode);
        assert matches;
    }
}
