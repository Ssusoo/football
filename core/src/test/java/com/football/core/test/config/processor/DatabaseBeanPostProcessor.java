package com.football.core.test.config.processor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseBeanPostProcessor implements BeanPostProcessor {
    private static final DataSource dataSource;

    static {
        final HikariDataSource hikariDataSource = new HikariDataSource();
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.copyStateTo(hikariDataSource);

        hikariDataSource.setJdbcUrl("jdbc:h2:mem:zaritalk;MODE=MySQL");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setDriverClassName("org.h2.Driver");

        dataSource = hikariDataSource;
    }

    @SuppressWarnings("all")
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof DataSource) {
            return dataSource;
        }
        return bean;
    }

    @SuppressWarnings("all")
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
}
