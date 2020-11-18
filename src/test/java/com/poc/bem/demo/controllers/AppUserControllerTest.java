package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.services.AppUserDAOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class AppUserControllerTest {
    private static final int ID = 1;
    private static final AppUser user = new AppUser().builder().id(ID).build();

    @Mock
    private AppUserDAOService mockDaoService;

    @InjectMocks
    private AppUserController controller;

    private ResponseEntity<AppUser> responseEntity;

    @BeforeEach
    void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void test() {
        assertNotNull(controller);
    }

    @Test
    void testGetResourcesStatusCode() {
        Mockito.when(mockDaoService.getBy(anyInt())).thenReturn(user);
        responseEntity = ResponseEntity.of(Optional.of(controller.getUserBy(ID)));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetResourcesRequestBody() {
        Mockito.when(mockDaoService.getBy(anyInt())).thenReturn(user);
        responseEntity = ResponseEntity.of(Optional.of(controller.getUserBy(ID)));
        assertThat(responseEntity.getBody()).isInstanceOf(AppUser.class);
    }
}
