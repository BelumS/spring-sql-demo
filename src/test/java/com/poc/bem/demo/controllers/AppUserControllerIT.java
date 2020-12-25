package com.poc.bem.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.services.AppUserDAOService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@SpringJUnitWebConfig(classes = {AppUserController.class, AppUserDAOService.class})
@ExtendWith(MockitoExtension.class)
class AppUserControllerIT {
    private static final int ID = 1;
    private static final AppUser APP_USER = new AppUser().builder()
            .id(ID)
            .firstName("TEST")
            .lastName("USER")
            .phone("123-456-7890")
            .email("test@email.com")
            .ipAddress("123.454.3.2").build();

    private static final List<AppUser> APP_USER_LIST = Collections.singletonList(APP_USER);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserDAOService mockService;

    @Test
    void testGetUserListSuccess() throws Exception {
        Mockito.when(mockService.listAll()).thenReturn(APP_USER_LIST);
        mockMvc.perform(get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(ID)))
                .andExpect(jsonPath("$[0].firstName").exists())
                .andExpect(jsonPath("$[0].lastName").exists())
                .andExpect(jsonPath("$[0].phone").exists())
                .andExpect(jsonPath("$[0].email").exists())
                .andExpect(jsonPath("$[0].ipAddress").exists());
    }

    @Test
    void testGetUserListReturns400() throws Exception {
        Mockito.when(mockService.listAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/api/v1/users/fail"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetUserListReturns404() throws Exception {
        Mockito.when(mockService.listAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/api/v1/fail")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetUserById() throws Exception {
        Mockito.when(mockService.getBy(anyInt())).thenReturn(APP_USER);
        mockMvc.perform(get("/api/v1/users/{id}", APP_USER.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(is(ID)))
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.phone").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.ipAddress").exists());
    }

    @Test
    void testGetUserByIdReturns400() throws Exception {
        Mockito.when(mockService.getBy(anyInt())).thenReturn(APP_USER);
        mockMvc.perform(get("/api/v1/users/fail"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetUserByIdReturns404() throws Exception {
        Mockito.when(mockService.getBy(anyInt())).thenReturn(APP_USER);
        mockMvc.perform(get("/api/v1/fail"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateUser() throws Exception {
        Mockito.when(mockService.create(any())).thenReturn(APP_USER);
        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(APP_USER)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void testCreateUserReturns400() throws Exception {
        Mockito.when(mockService.create(any())).thenReturn(APP_USER);
        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void testCreateUserReturns404() throws Exception {
        Mockito.when(mockService.create(any())).thenReturn(APP_USER);
        mockMvc.perform(post("/api/v1/fail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(APP_USER)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateUser() throws Exception {
        var updatedUser = new AppUser().builder()
                .id(APP_USER.getId())
                .firstName("UPDATED")
                .lastName(APP_USER.getLastName())
                .email(APP_USER.getEmail())
                .phone(APP_USER.getPhone())
                .ipAddress(APP_USER.getIpAddress())
                .build();

        Mockito.when(mockService.update(any())).thenReturn(updatedUser);
        mockMvc.perform(put("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedUser)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(is("UPDATED")));
    }

    @Test
    void testUpdateUserReturns400() throws Exception {
        Mockito.when(mockService.update(any())).thenReturn(APP_USER);
        mockMvc.perform(put("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void testUpdateUserReturns404() throws Exception {
        Mockito.when(mockService.update(any())).thenReturn(APP_USER);
        mockMvc.perform(put("/api/v1/fail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(APP_USER)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteUser() throws Exception {
        Mockito.doNothing().when(mockService).deleteBy(anyInt());
        mockMvc.perform(delete("/api/v1/users/{id}", APP_USER.getId()))
                .andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void testDeleteUserReturns422() throws Exception {
        Mockito.doNothing().when(mockService).deleteBy(anyInt());
        mockMvc.perform(delete("/api/v1/users/0"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$").doesNotExist());
    }

    /*
     * converts a Java object into JSON representation
     */
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
