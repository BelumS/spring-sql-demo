package com.poc.bem.demo.bootstrap;

import com.poc.bem.demo.constants.ApiConstants;
import com.poc.bem.demo.domain.AppUser;
import com.poc.bem.demo.services.AppUserDAOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {
    private final AppUserDAOService service;
    private final Environment env;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("In SeedData.onApplicationEvent()");
        generateAppUsers();
    }

    protected void generateAppUsers() {
        int num = 5;
        log.debug("Generating {} users.", num);
        service.createList(
                IntStream.rangeClosed(1, num)
                        .mapToObj(e -> new AppUser().builder()
                                .createProgramId(env.getRequiredProperty(ApiConstants.APP_NAME))
                                .createTimestamp(Timestamp.from(Instant.now()))
                                .firstName("TEST")
                                .lastName("USER" + e)
                                .email("test" + e + "@email.com")
                                .phone("123-456-789" + e)
                                .ipAddress("111.111.1." + e)
                                .build())
                        .collect(Collectors.toList())
        );
    }
}
