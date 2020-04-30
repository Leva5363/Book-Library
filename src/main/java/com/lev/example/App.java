package com.lev.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
//@EnableConfigurationProperties
//@Configuration
//@EnableAutoConfiguration

public class App{
        public static void main( String[] args ){
//            ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
            SpringApplication.run (App.class, args);
    }

    //Show spring in configuration classes what packages look for(scan), datasource bean, entity manager
}
