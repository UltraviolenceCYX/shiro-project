package com.southwind.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountService a;

    @Test
    void name() {
        System.out.println(a.findName("ls"));
    }
}