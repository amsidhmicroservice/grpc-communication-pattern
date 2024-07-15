package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankServiceTest extends AbstractTest {
    @Test
    public void getBalanceTest() {
        var request = AccountBalanceRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var balance = this.bankBlockingStub.getAccountBalance(request);
        System.out.printf("unary balance received: %d%n", balance.getBalance());
        Assertions.assertEquals(100, balance.getBalance());
    }

}