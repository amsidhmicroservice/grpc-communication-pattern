package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.AllAccountsResponse;
import com.amsidh.mvc.model.NoParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void allAccounts() {
        NoParam noParam = NoParam.newBuilder().build();
        final AllAccountsResponse allAccounts = this.bankServiceBlockingStub.getAllAccounts(noParam);
        final List<AccountBalanceResponse> accountBalanceResponseList = allAccounts.getAccountBalanceResponseList();
        System.out.printf("Total account retrieved are %d%n", accountBalanceResponseList.size());
        Assertions.assertFalse(accountBalanceResponseList.isEmpty());
    }
}
