package com.example.privatesns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PrivateSnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrivateSnsApplication.class, args);
    }

}
