package com.nexos.app;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("org.postgresql.Driver")
          .url("jdbc:postgresql://ec2-34-193-112-164.compute-1.amazonaws.com:5432/dejb92cqunl8bi")
          .username("uybibdwkpwwbjd")
          .password("ebc929caa235090839a7a61b3346e4ad9518cf6cd35faabfe70770728e3dd2a4")
          .build();	
    }
}
