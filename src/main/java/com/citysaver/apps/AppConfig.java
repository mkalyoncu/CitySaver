package com.citysaver.apps;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@PropertySource(value = {
        "classpath:application.properties",
        "classpath:message.properties"})
public class AppConfig {
}
