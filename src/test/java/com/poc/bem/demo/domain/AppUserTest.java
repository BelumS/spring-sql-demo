package com.poc.bem.demo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class AppUserTest {
    private static AppUser appUser = new AppUser().builder()
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

    @Test
    void test() {
        appUser = new AppUser();
        assertNotNull(appUser);
    }

    @Test
    void testAlt() {
        assertNotNull(appUser);
    }

    @Test
    void testId() {
        int unExpected = appUser.getId();
        int actual = 0;
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testFirstName() {
        String unExpected = appUser.getFirstName();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testLastName() {
        String unExpected = appUser.getLastName();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testEmail() {
        String unExpected = appUser.getEmail();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testPhone() {
        String unExpected = appUser.getPhone();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testIpAddress() {
        String unExpected = appUser.getIpAddress();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateProgramId() {
        String unExpected = appUser.getCreateProgramId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyProgramId() {
        String unExpected = appUser.getModifyProgramId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateTimestamp() {
        Timestamp unExpected = appUser.getCreateTimestamp();
        Timestamp actual = new Timestamp(1);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyTimestamp() {
        Timestamp unExpected = appUser.getModifyTimestamp();
        Timestamp actual = new Timestamp(2);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateUserId() {
        String unExpected = appUser.getCreateUserId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyUserId() {
        String unExpected = appUser.getModifyUserId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testVersion() {
        int unExpected = appUser.getVersion();
        int actual = 1;
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testToString() {
        assertNotNull(appUser.toString());
    }
}
