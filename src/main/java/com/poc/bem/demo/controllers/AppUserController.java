package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.domain.AppUserDTO;
import com.poc.bem.demo.services.AppUserDAOService;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.basePath}/${api.version.v1}/users")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    @NonNull
    private final AppUserDAOService service;

    @GetMapping
    @ApiOperation(value = "Get Users", notes = "Retrieves a list Users")
    public List<AppUserDTO> getUsers() {
        var users = service.listAll();
        log.debug("Retrieved {} users.", users.size());
        return users.stream().map(AppUserDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User", notes = "Retrieves a User")
    public AppUserDTO getUserBy(@PathVariable int id) {
        AppUser user = service.getBy(id);
        log.debug("Getting user #{}", user.getId());
        return new AppUserDTO(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create User", notes = "Creates a new User")
    public AppUserDTO createUser(@RequestBody @NonNull AppUserDTO user) {
        final AppUser saved = service.create(new AppUser(user));
        log.debug("Inserting a new User{}", saved);
        return user;
    }

    @PutMapping
    @ApiOperation(value = "Update User", notes = "Updates an existing User")
    public AppUserDTO updateUser(@RequestBody @NonNull AppUserDTO user) {
        final AppUser updated = service.update(new AppUser(user));
        log.debug("Updating User #{}", updated.getId());
        return user;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete User", notes = "Deleters an existing User")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        log.debug("Received ID #{}", id);
        if (id > 0) {
            service.deleteBy(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
