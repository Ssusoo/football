package com.football.core.test.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan("com.football.core.test.config.processor")
public class TestConfig {
}
