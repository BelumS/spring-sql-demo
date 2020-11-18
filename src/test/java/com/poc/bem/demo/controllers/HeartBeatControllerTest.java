package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.HeartBeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static com.poc.bem.demo.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class HeartBeatControllerTest {
    private HeartBeatController controller;

    @BeforeEach
    public void setup() {
        HeartBeat heartBeat = new HeartBeat();
        ReflectionTestUtils.setField(heartBeat, "applicationName", NAME);
        ReflectionTestUtils.setField(heartBeat, "applicationVersion", VERSION);
        ReflectionTestUtils.setField(heartBeat, "applicationTimestamp", BUILD_TIMESTAMP);
        ReflectionTestUtils.setField(heartBeat, "applicationEnvironment", ENV);
        ReflectionTestUtils.setField(heartBeat, "applicationBranch", BRANCH);

        controller = new HeartBeatController(heartBeat);
    }

    @Test
    void testConstructor() {
        assertNotNull(controller);
    }

    @Test
    void testAppDetails() {
        assertNotNull(controller.getApplicationDetails());
    }
}
