package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.domain.AppUserDTO;
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

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class AppUserControllerTest {
    private static final int ID = 1;
    private static final AppUser APP_USER = new AppUser().builder()
            .id(ID)
            .firstName("TEST")
            .lastName("USER")
            .phone("123-456-7890")
            .email("test@email.com")
            .ipAddress("123.454.3.2").build();

    private static final AppUserDTO APP_USER_DTO = new AppUserDTO(APP_USER);
    private static final List<AppUser> APP_USER_LIST = Collections.singletonList(APP_USER);

    @Mock
    private AppUserDAOService mockDaoService;

    @InjectMocks
    private AppUserController controller;

    private ResponseEntity<AppUserDTO> responseEntity;
    private ResponseEntity<List<AppUserDTO>> responseEntities;

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
    void testGetUserByStatusCode() {
        Mockito.when(mockDaoService.getBy(anyInt())).thenReturn(APP_USER);
        responseEntity = ResponseEntity.of(Optional.of(controller.getUserBy(ID)));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetUserByRequestBody() {
        Mockito.when(mockDaoService.getBy(anyInt())).thenReturn(APP_USER);
        responseEntity = ResponseEntity.of(Optional.of(controller.getUserBy(ID)));
        assertThat(responseEntity.getBody()).isInstanceOf(AppUserDTO.class);
    }

    @Test
    void testGetUsersStatusCode() {
        Mockito.when(mockDaoService.listAll()).thenReturn(APP_USER_LIST);
        responseEntities = ResponseEntity.of(Optional.of(controller.getUsers()));
        assertThat(responseEntities.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetUsersRequestBody() {
        Mockito.when(mockDaoService.listAll()).thenReturn(APP_USER_LIST);
        responseEntities = ResponseEntity.of(Optional.of(controller.getUsers()));
        assertThat(responseEntities.getBody()).isInstanceOf(List.class);
    }

    @Test
    void testCreateUserStatusCode() {
        Mockito.when(mockDaoService.create(any(AppUser.class))).thenReturn(APP_USER);
        responseEntity = ResponseEntity.created(URI.create("/")).body(controller.createUser(APP_USER_DTO));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void testCreateUserRequestBody() {
        Mockito.when(mockDaoService.create(any(AppUser.class))).thenReturn(APP_USER);
        responseEntity = ResponseEntity.created(URI.create("/")).body(controller.createUser(APP_USER_DTO));
        assertThat(responseEntity.getBody()).isInstanceOf(AppUserDTO.class);
    }

    @Test
    void testUpdateUserStatusCode() {
        Mockito.when(mockDaoService.update(any(AppUser.class))).thenReturn(APP_USER);
        responseEntity = ResponseEntity.of(Optional.of(controller.updateUser(APP_USER_DTO)));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testUpdateUserRequestBody() {
        Mockito.when(mockDaoService.update(any(AppUser.class))).thenReturn(APP_USER);
        responseEntity = ResponseEntity.of(Optional.of(controller.updateUser(APP_USER_DTO)));
        assertThat(responseEntity.getBody()).isInstanceOf(AppUserDTO.class);
    }

    @Test
    void testDeleteUserStatusCode() {
        Mockito.doNothing().when(mockDaoService).deleteBy(anyInt());
        assertThat(controller.deleteUser(ID).getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void testDeleteUserRequestBodyWithValidID() {
        Mockito.doNothing().when(mockDaoService).deleteBy(anyInt());
        assertNotNull(controller.deleteUser(ID));
    }

    @Test
    void testDeleteUserRequestBodyWithInvalidID() {
        assertNotNull(controller.deleteUser(0));
    }
}
