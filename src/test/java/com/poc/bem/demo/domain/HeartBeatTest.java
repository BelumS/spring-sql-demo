package com.poc.bem.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static com.poc.bem.demo.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class HeartBeatTest {
    private HeartBeat heartBeat;

    @BeforeEach
    void setup() {
        heartBeat = new HeartBeat();
        ReflectionTestUtils.setField(heartBeat, "applicationName", NAME);
        ReflectionTestUtils.setField(heartBeat, "applicationVersion", VERSION);
        ReflectionTestUtils.setField(heartBeat, "applicationTimestamp", BUILD_TIMESTAMP);
        ReflectionTestUtils.setField(heartBeat, "applicationEnvironment", ENV);
        ReflectionTestUtils.setField(heartBeat, "applicationBranch", BRANCH);
    }

    @Test
    void testConstructor() {
        assertNotNull(heartBeat);
    }

    @Test
    void testGetName() {
        assertEquals(NAME, heartBeat.getApplicationName());
    }

    @Test
    void testGetVersion() {
        assertEquals(VERSION, heartBeat.getApplicationVersion());
    }

    @Test
    void testGetBuildTimestamp() {
        assertNotNull(heartBeat.getApplicationTimestamp());
    }

    @Test
    void testGetEnv() {
        assertEquals(ENV, heartBeat.getApplicationEnvironment());
    }

    @Test
    void testGetBranch() {
        assertEquals(BRANCH, heartBeat.getApplicationBranch());
    }
}
