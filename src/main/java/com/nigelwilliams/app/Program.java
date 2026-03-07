package com.nigelwilliams.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing // Required for @CreatedDate to work
public class Program {
    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }
}
