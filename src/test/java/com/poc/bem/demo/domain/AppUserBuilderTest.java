package com.poc.bem.demo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class AppUserBuilderTest {
    private static final AppUser APP_USER = new AppUser().builder()
            .id(1)
            .firstName("TEST")
            .lastName("USER")
            .email("test@email.com")
            .phone("123-456-7890")
            .ipAddress("000.000.0.0")
            .createUserId("TEST")
            .modifyProgramId("")
            .createProgramId("TEST")
            .modifyUserId("")
            .createTimestamp(Timestamp.from(Instant.now()))
            .modifyTimestamp(Timestamp.from(Instant.now().plusSeconds(5)))
            .version(0)
            .build();

    private static final AppUserBuilder BUILDER = new AppUserBuilder(APP_USER);

    @Test
    void test() {
        AppUserBuilder builder = new AppUserBuilder();
        assertNotNull(builder);
    }

    @Test
    void testAlt() {
        assertNotNull(BUILDER);
    }

    @Test
    void testBuildFromAppUser() {
        assertNotNull(BUILDER.build(new AppUser()));
    }

    @Test
    void testBuildFromAppUserDTO() {
        assertNotNull(BUILDER.build(new AppUserDTO()));
    }
}
