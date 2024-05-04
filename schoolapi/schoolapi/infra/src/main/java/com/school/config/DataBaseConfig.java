package com.school.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    @Bean
    @FlywayDataSource
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        return DataSourceBuilder.create()
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSourceProperties dataSourceProperties) {
        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource(dataSourceProperties))
                .load();
        return flyway;
    }

}
