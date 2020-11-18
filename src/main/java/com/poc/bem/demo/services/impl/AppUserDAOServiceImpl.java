package com.poc.bem.demo.services.impl;

import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.exceptions.AppUserNotFoundException;
import com.poc.bem.demo.repositories.AppUserRepository;
import com.poc.bem.demo.services.AppUserDAOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of the core CRUD methods for the AppUser table.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserDAOServiceImpl implements AppUserDAOService {
    private final AppUserRepository repository;
    private final Environment env;

    @Override
    public List<AppUser> listAll() {
        try {
            return new ArrayList<>((Collection<? extends AppUser>) repository.findAll());
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred: ", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred: ", e);
            throw e;
        }
    }

    @Override
    public AppUser getBy(int id) {
        try {
            return verifyBy(id);
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred: ", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred: ", e);
            throw e;
        }
    }

    @Override
    public AppUser create(AppUser user) {
        try {
            AppUser realUser = Objects.requireNonNull(user);
            realUser.builder()
                    .createTimestamp(Timestamp.from(Instant.now()))
                    .createProgramId(env.getRequiredProperty("spring.application.name"))
                    .build();

            AppUser saved = repository.save(realUser);
            log.debug("Inserted user with ID: {}", saved.getId());
            return saved;
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred: ", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred: ", e);
            throw e;
        }
    }

    @Override
    public Iterable<AppUser> createList(Iterable<AppUser> list) {
        try {
            var result = repository.saveAll(list);
            var iterableAsList = (Collection<? extends AppUser>) result;
            log.debug("Inserted {} users", iterableAsList.size());
            return result;
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred: ", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred: ", e);
            throw e;
        }
    }

    @Override
    public AppUser update(AppUser user) {
        try {
            AppUser realUser = Objects.requireNonNull(user);
            AppUser updated = verifyBy(realUser.getId()).builder()
                    .firstName(realUser.getFirstName())
                    .lastName(realUser.getLastName())
                    .email(realUser.getEmail())
                    .phone(realUser.getPhone())
                    .ipAddress(realUser.getIpAddress())
                    .modifyTimestamp(Timestamp.from(Instant.now()))
                    .modifyProgramId(env.getRequiredProperty("spring.application.name"))
                    .build();

            log.debug("Updated user with ID: {}", updated.getId());
            return updated;
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred: ", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred: ", e);
            throw e;
        }
    }

    @Override
    public void deleteBy(int id) {
        try {
            AppUser found = verifyBy(id);
            repository.deleteById(found.getId());
        } catch (DataAccessException e) {
            log.error("A DataAccessException occurred -", e);
            throw e;
        } catch (Exception e) {
            log.error("An Exception occurred - ", e);
            throw e;
        }
    }

    private AppUser verifyBy(int id) {
        assert id > Integer.MIN_VALUE;
        if (id > 0 && id < Integer.MAX_VALUE) {
            var user = repository.findById(id).orElseThrow(AppUserNotFoundException::new);
            log.debug("Found user with ID #{}", user.getId());
            return user;
        } else
            throw new IllegalArgumentException("'" + id + "' is not a valid ID for user retrieval.");
    }
}
