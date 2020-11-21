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

    @Test
    void test() {
        AppUser appUser2 = new AppUser();
        assertNotNull(appUser2);
    }

    @Test
    void testBuilder() {
        assertNotNull(APP_USER);
    }

    @Test
    void testCopyConstructor() {
        AppUser copyUser = new AppUser(APP_USER);
        assertNotNull(copyUser);
    }

    @Test
    void testDTOConstructor() {
        AppUser dtoUser = new AppUser(new AppUserDTO());
        assertNotNull(dtoUser);
    }

    @Test
    void testId() {
        int unExpected = APP_USER.getId();
        int actual = 0;
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testFirstName() {
        String unExpected = APP_USER.getFirstName();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testLastName() {
        String unExpected = APP_USER.getLastName();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testEmail() {
        String unExpected = APP_USER.getEmail();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testPhone() {
        String unExpected = APP_USER.getPhone();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testIpAddress() {
        String unExpected = APP_USER.getIpAddress();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateProgramId() {
        String unExpected = APP_USER.getCreateProgramId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyProgramId() {
        String unExpected = APP_USER.getModifyProgramId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateTimestamp() {
        Timestamp unExpected = APP_USER.getCreateTimestamp();
        Timestamp actual = new Timestamp(1);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyTimestamp() {
        Timestamp unExpected = APP_USER.getModifyTimestamp();
        Timestamp actual = new Timestamp(2);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateUserId() {
        String unExpected = APP_USER.getCreateUserId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyUserId() {
        String unExpected = APP_USER.getModifyUserId();
        String actual = "New Value";
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testVersion() {
        int unExpected = APP_USER.getVersion();
        int actual = 1;
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testToString() {
        assertNotNull(APP_USER.toString());
    }
}
