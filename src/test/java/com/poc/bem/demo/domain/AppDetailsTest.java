package com.poc.bem.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.poc.bem.demo.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class AppDetailsTest {
    private AppDetails details;

    @BeforeEach
    void setup() {
        details = new AppDetails(NAME, VERSION, BUILD_TIMESTAMP, ENV, BRANCH);
    }

    @Test
    void testConstructor() {
        assertNotNull(details);
    }

    @Test
    void testGetName() {
        assertEquals(NAME, details.getName());
    }

    @Test
    void testGetVersion() {
        assertEquals(VERSION, details.getVersion());
    }

    @Test
    void testGetBuildTimestamp() {
        assertNotNull(details.getBuildTimestamp());
    }

    @Test
    void testGetEnv() {
        assertEquals(ENV, details.getEnv());
    }

    @Test
    void testGetBranch() {
        assertEquals(BRANCH, details.getBranch());
    }

    @Test
    void testToString() {
        assertNotNull(details.toString());
    }
}
