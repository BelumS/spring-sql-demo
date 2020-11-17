package com.poc.bem.demo.domain;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppUserTest {
    private static AppUser appUser = new AppUser(
            "0",
            "TEST",
            "USER",
            "test@email.com",
            "123-456-7890",
            "000.000.0.0",
            "TEST",
            "TEST",
            new Timestamp(0),
            new Timestamp(1),
            "TEST",
            "TEST",
            0
    );

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
        String unExpected = appUser.getId();
        String actual = "1";
        appUser.setId(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testFirstName() {
        String unExpected = appUser.getFirstName();
        String actual = "New Value";
        appUser.setFirstName(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testLastName() {
        String unExpected = appUser.getLastName();
        String actual = "New Value";
        appUser.setLastName(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testEmail() {
        String unExpected = appUser.getEmail();
        String actual = "New Value";
        appUser.setEmail(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testPhone() {
        String unExpected = appUser.getPhone();
        String actual = "New Value";
        appUser.setPhone(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testIpAddress() {
        String unExpected = appUser.getIpAddress();
        String actual = "New Value";
        appUser.setIpAddress(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateProgramId() {
        String unExpected = appUser.getCreateProgramId();
        String actual = "New Value";
        appUser.setCreateProgramId(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyProgramId() {
        String unExpected = appUser.getModifyProgramId();
        String actual = "New Value";
        appUser.setModifyProgramId(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateTimestamp() {
        Timestamp unExpected = appUser.getCreateTimeStamp();
        Timestamp actual = new Timestamp(1);
        appUser.setCreateTimeStamp(new Timestamp(0));
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyTimestamp() {
        Timestamp unExpected = appUser.getModifyTimeStamp();
        Timestamp actual = new Timestamp(2);
        appUser.setModifyTimeStamp(new Timestamp(0));
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testCreateUserId() {
        String unExpected = appUser.getCreateUserId();
        String actual = "New Value";
        appUser.setCreateUserId(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testModifyUserId() {
        String unExpected = appUser.getModifyUserId();
        String actual = "New Value";
        appUser.setModifyUserId(actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testVersion() {
        int unExpected = appUser.getVersion();
        int actual = 1;
        appUser.setVersion(0);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void testToString() {
        assertNotNull(appUser.toString());
    }
}
