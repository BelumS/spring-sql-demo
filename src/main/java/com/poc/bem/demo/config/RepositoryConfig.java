package com.poc.bem.demo.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.poc.bem.demo.repositories")
@EntityScan("com.poc.dem.demo.domain")
@EnableTransactionManagement
@NoArgsConstructor
public class RepositoryConfig {
}
