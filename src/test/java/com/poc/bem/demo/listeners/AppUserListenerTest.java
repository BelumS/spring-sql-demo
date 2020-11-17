package com.poc.bem.demo.listeners;

import com.poc.bem.demo.domain.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppUserListenerTest {
    private static final AppUser APP_USER = new AppUser();
    private AppUserListener listener;

    @BeforeEach
    void setup() {
        listener = new AppUserListener();
        ReflectionTestUtils.setField(listener, "appName", "TEST");
    }

    @Test
    void test() {
        assertNotNull(listener);
    }

    @Test
    void testPrePersist() {
        assertDoesNotThrow(() -> listener.prePersist(APP_USER));
    }

    @Test
    void testPreUpdate() {
        assertDoesNotThrow(() -> listener.preUpdate(APP_USER));
    }

}
