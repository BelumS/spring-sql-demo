package com.poc.bem.demo.controllers;

import com.poc.bem.demo.domain.AppDetails;
import com.poc.bem.demo.domain.HeartBeat;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping("/heartbeat")
@RequiredArgsConstructor
public class HeartBeatController {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @NonNull
    private final HeartBeat heartBeat;

    @GetMapping
    public AppDetails getApplicationDetails() {
        AppDetails details = new AppDetails(
                heartBeat.getApplicationName(),
                heartBeat.getApplicationVersion(),
                heartBeat.getApplicationTimestamp(),
                heartBeat.getApplicationEnvironment(),
                heartBeat.getApplicationBranch());
        log.info(" --~-~-~-- HEARTBEAT --~-~-~-- \n{}", details);
        return details;
    }
}
