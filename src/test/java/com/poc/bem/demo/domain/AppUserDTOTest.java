package com.poc.bem.demo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class AppUserDTOTest {
    private static final AppUserDTO APP_USER_DTO = new AppUserDTO();

    @Test
    void test() {
        assertNotNull(APP_USER_DTO);
    }

    @Test
    void testToString() {
        assertNotNull(APP_USER_DTO.toString());
    }

}
