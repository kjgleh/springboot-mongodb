package com.example.springbootmongodb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void save_correctly() {
        // Arrange
        Account account = new Account();
        account.setUsername("tester");
        account.setEmail("tester@test.com");

        // Actual
        accountRepository.save(account);
        Optional<Account> actual = accountRepository.findById(account.getId());

        // Assert
        assertThat(actual).isNotEmpty();
        Account savedAccount = actual.get();
        assertThat(savedAccount.getUsername()).isEqualTo(account.getUsername());
        assertThat(savedAccount.getEmail()).isEqualTo(account.getEmail());
    }
}