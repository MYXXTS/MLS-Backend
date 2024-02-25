package com.myxxts.mls.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PasswordUtilTests {
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void testEncryption() {
        String password = "password";
        String encode = PasswordUtil.encode(password);
        System.out.println(encode);
        Boolean matches = PasswordUtil.matches(password, encode);
        assert matches;
    }
}
