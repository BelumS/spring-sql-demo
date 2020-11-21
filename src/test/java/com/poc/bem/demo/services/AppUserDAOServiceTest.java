package com.poc.bem.demo.services;

import com.poc.bem.demo.constants.ApiConstants;
import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.repositories.AppUserRepository;
import com.poc.bem.demo.services.impl.AppUserDAOServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.mock.env.MockEnvironment;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class AppUserDAOServiceTest {
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

    private static final List<AppUser> APP_USER_LIST = Collections.singletonList(APP_USER);

    @Mock
    private AppUserRepository mockRepository;

    @InjectMocks
    private AppUserDAOServiceImpl service;

    @BeforeEach
    void setup() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty(ApiConstants.APP_NAME, "TEST");
        service = new AppUserDAOServiceImpl(mockRepository, mockEnvironment);
    }

    @Test
    void testConstructor() {
        assertNotNull(service);
    }

    @Test
    void testListAll() {
        Mockito.when(mockRepository.findAll()).thenReturn(APP_USER_LIST);
        assertNotNull(service.listAll());
    }

    @Test
    void testListAllThrowsDataException() {
        Mockito.when(mockRepository.findAll()).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.listAll());
    }

    @Test
    void testListAllThrowsException() {
        Mockito.when(mockRepository.findAll()).thenThrow(new IllegalArgumentException());
        assertThrows(Exception.class, () -> service.listAll());
    }

    @Test
    @DisplayName("getByID() where ID = 1")
    void testGetByIdEquals1() {
        Mockito.when(mockRepository.findById(anyInt())).thenReturn(Optional.of(APP_USER));
        assertNotNull(service.getBy(1));
    }

    @Test
    void testGetByThrowsDataException() {
        Mockito.when(mockRepository.findById(anyInt())).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.getBy(1));
    }

    @Test
    void testGetByThrowsException() {
        Mockito.when(mockRepository.findById(anyInt())).thenThrow(new NullPointerException());
        assertThrows(Exception.class, () -> service.getBy(1));
    }

    @Test
    @DisplayName("getByID() where ID = 0")
    void testGetByThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.getBy(0));
    }

    @Test
    void testCreate() {
        Mockito.when(mockRepository.save(any(AppUser.class))).thenReturn(APP_USER);
        assertNotNull(service.create(APP_USER));
    }

    @Test
    void testCreateThrowsDataException() {
        Mockito.when(mockRepository.save(any(AppUser.class))).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.create(APP_USER));
    }

    @Test
    void testCreateThrowsException() {
        assertThrows(Exception.class, () -> service.create(null));
    }

    @Test
    void testCreateList() {
        Mockito.when(mockRepository.saveAll(any())).thenReturn(APP_USER_LIST);
        assertNotNull(service.createList(APP_USER_LIST));
    }

    @Test
    void testCreateListThrowsDataException() {
        Mockito.when(mockRepository.saveAll(any())).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.createList(APP_USER_LIST));
    }

    @Test
    void testCreateListThrowsException() {
        Mockito.when(mockRepository.saveAll(any())).thenThrow(new NullPointerException("TEST"));
        assertThrows(Exception.class, () -> service.createList(null));
    }

    @Test
    void testUpdate() {
        Mockito.when(mockRepository.findById(anyInt())).thenReturn(Optional.of(APP_USER));
        Mockito.when(mockRepository.save(any(AppUser.class))).thenReturn(APP_USER);
        assertNotNull(service.update(APP_USER));
    }

    @Test
    void testUpdateThrowsDataException() {
        Mockito.when(mockRepository.findById(anyInt())).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.update(APP_USER));
    }

    @Test
    void testUpdateThrowsException() {
        assertThrows(Exception.class, () -> service.update(null));
    }

    @Test
    void testDeleteBy() {
        Mockito.doNothing().when(mockRepository).deleteById(1);
        Mockito.when(mockRepository.findById(anyInt())).thenReturn(Optional.of(APP_USER));
        assertDoesNotThrow(() -> service.deleteBy(1));
    }

    @Test
    void testDeleteByThrowsDataException() {
        Mockito.when(mockRepository.findById(anyInt())).thenThrow(new RecoverableDataAccessException("TEST"));
        assertThrows(DataAccessException.class, () -> service.deleteBy(1));
    }

    @Test
    void testDeleteByThrowsException() {
        assertThrows(Exception.class, () -> service.deleteBy(0));
    }

}
