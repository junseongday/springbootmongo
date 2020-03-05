package com.js.springbootmongo;

import com.js.springbootmongo.account.Account;
import com.js.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootmongoApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmongoApplication.class, args);
    }

    @Bean
    public ApplicationRunner mongoRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("junseongday@gmail.com");
            account.setUserName("kim jun seong");

//            mongoTemplate.insert(account);
            accountRepository.save(account);
            System.out.println("finished");
        };
    }

}
