package com.lev.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class App{
        public static void main( String[] args ){
            SpringApplication.run (App.class, args);
            String s =UUID.randomUUID().toString();
            System.out.println(s);

    }


}