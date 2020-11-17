package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppUserControllerTest {
    private AppUserController controller;
    private ResponseEntity<AppUser> responseEntity;

    @BeforeEach
    void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        controller = new AppUserController();
        responseEntity = controller.getUser("0");
    }

    @Test
    void test() {
        assertNotNull(controller);
    }

    @Test
    void testGetResourcesStatusCode() {
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetResourcesRequestBody() {
        assertThat(responseEntity.getBody()).isInstanceOf(AppUser.class);
    }
}
