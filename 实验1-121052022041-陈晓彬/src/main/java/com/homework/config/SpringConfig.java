package com.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 23:28
 */
@Configuration
@Import(ResourceConfig.class)
@ComponentScan("com.homework")
public class SpringConfig {
}
