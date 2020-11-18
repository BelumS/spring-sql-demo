package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.services.AppUserDAOService;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.basePath}/${api.version.v1}/user")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    @NonNull
    private final AppUserDAOService service;

    @GetMapping
    @ApiOperation(value = "Get Users", notes = "Retrieves a list Users")
    public List<AppUser> getUsers() {
        var users = service.listAll();
        log.debug("Retrieved {} users.", users.size());
        return users;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User", notes = "Retrieves a User")
    public AppUser getUserBy(@PathVariable int id) {
        AppUser user = service.getBy(id);
        log.debug("Getting user #{}", user.getId());
        return user;
    }
}
