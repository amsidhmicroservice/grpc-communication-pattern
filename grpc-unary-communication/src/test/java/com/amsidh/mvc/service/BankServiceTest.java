package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankServiceTest extends AbstractTest {

    @Test
    public void getBalanceTest() {
        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest
                .newBuilder()
                .setAccountNumber(1)
                .build();
        final AccountBalanceResponse accountBalanceResponse = this.bankServiceBlockingStub.getAccountBalance(accountBalanceRequest);
        System.out.printf("Unary balance received %d%n", accountBalanceResponse.getBalance());
        Assertions.assertNotNull(accountBalanceResponse);
        Assertions.assertEquals(100, accountBalanceResponse.getBalance());
    }
}
