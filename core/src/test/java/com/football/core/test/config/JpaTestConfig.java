package com.football.core.test.config;

import com.football.core.test.setup.DatabaseCleaner;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class JpaTestConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public DatabaseCleaner databaseCleaner() {
        return new DatabaseCleaner();
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
