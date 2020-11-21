package com.poc.bem.demo.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class RepositoryConfigTest {

    @Test
    void test() {
        RepositoryConfig config = new RepositoryConfig();
        assertNotNull(config);
    }
}
