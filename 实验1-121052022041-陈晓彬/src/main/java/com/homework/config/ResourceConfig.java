package com.homework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 23:30
 */

@Configuration
@PropertySource("classpath:db.properties")
@Slf4j
public class ResourceConfig {
    @Value("${jdbc.driver}")
    private String driver ;
    @Value("jdbc:mysql://localhost:3306/new_schema")
    private String url ;
    @Value("${jdbc.username}")
    private String username ;
    @Value("123456")
    private String password ;

    @Bean
    public Connection getConnection() {
        try{
            Class.forName(driver) ;
            return DriverManager.getConnection(
                    url, username, password
            ) ;
        } catch (Exception e) {
            log.error(e.getMessage()) ;
        }
        return null ;
    }

}
