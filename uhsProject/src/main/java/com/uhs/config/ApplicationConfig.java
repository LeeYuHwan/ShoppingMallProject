package com.uhs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {"com.uhs.dao", "com.uhs.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
