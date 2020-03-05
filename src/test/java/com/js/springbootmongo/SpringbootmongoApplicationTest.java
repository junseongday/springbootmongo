package com.js.springbootmongo;

import com.js.springbootmongo.account.Account;
import com.js.springbootmongo.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class SpringbootmongoApplicationTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setUserName("whiteship");
        account.setEmail("wooseong@naver.com");

        accountRepository.save(account);
        Optional<Account> byId = accountRepository.findById(account.getId());
        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());

        assertThat(byId).isNotEmpty();
        assertThat(byEmail).isNotEmpty();

    }
}