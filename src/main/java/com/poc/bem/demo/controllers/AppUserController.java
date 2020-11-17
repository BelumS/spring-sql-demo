package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppUser;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.basePath}/${api.version.v1}/user")
@Slf4j
public class AppUserController {

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User", notes = "Retrieves a User")
    public ResponseEntity<AppUser> getUser(@PathVariable String id) {
        AppUser user = new AppUser();
        log.debug("Getting user #{}", user.getId());
        return ResponseEntity.ok(user);
    }
}
