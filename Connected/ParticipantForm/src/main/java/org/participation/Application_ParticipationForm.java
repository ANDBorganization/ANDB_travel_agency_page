package org.participation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.participation.base")
@EnableJpaRepositories(basePackages = "org.participation.repository")
public class Application_ParticipationForm {
    public static void main(String[] args) {
        SpringApplication.run(Application_ParticipationForm.class, args);
    }
}