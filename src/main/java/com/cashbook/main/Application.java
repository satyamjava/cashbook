package com.cashbook.main;

import com.cashbook.persistence.Account;
import com.cashbook.persistence.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJpaRepositories("com.cashbook.persistence")
@ComponentScan(basePackages = { "com.cashbook"})
@EntityScan("com.cashbook.persistence")
public class Application {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner init(final AccountRepository accountRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                accountRepository.save(new Account("user", "pass"));

            }

        };

    }

}