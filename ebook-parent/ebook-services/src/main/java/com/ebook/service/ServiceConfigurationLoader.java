package com.ebook.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.ebook")
@ImportResource("classpath:application-context-services.xml")
public class ServiceConfigurationLoader {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceConfigurationLoader.class, args);
    }
}