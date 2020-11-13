package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.Example;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

/**
 * Created by bel-sahn on 7/29/19
 */
@RestController
@RequestMapping("${api.basePath}/${api.version.v1}")
public class ExampleController {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/resource")
    @ApiOperation(value = "Get Resource", notes = "Returns an example resource")
    public ResponseEntity<Example> getResource() {
        log.info("Getting resource...");
        return ResponseEntity.ok(new Example());
    }
}
