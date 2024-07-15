package com.amsidh.mvc.service;

import com.amsidh.mvc.common.ResponseStreamObserver;
import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.AllAccountsResponse;
import com.amsidh.mvc.model.NoParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankServiceAsyncRefactorTest extends AbstractTest {

    @Test
    public void getBalanceAsyncTest() throws InterruptedException {
        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest.newBuilder().setAccountNumber(1).build();
        final ResponseStreamObserver<AccountBalanceResponse> accountBalanceResponseResponseStreamObserver = ResponseStreamObserver.create();
        this.bankServiceStub.getAccountBalance(accountBalanceRequest, accountBalanceResponseResponseStreamObserver);
        accountBalanceResponseResponseStreamObserver.await();
        System.out.printf("Unary balance received %d%n", accountBalanceResponseResponseStreamObserver.getList().get(0).getBalance());
        Assertions.assertNotNull(accountBalanceResponseResponseStreamObserver.getList().get(0));
        Assertions.assertEquals(100, accountBalanceResponseResponseStreamObserver.getList().get(0).getBalance());
        Assertions.assertNull(accountBalanceResponseResponseStreamObserver.getThrowable());

    }

    @Test
    public void allAccountsAsyncTest() throws InterruptedException {
        NoParam noParam = NoParam.newBuilder().build();
        final ResponseStreamObserver<AllAccountsResponse> allAccountsResponseResponseStreamObserver = ResponseStreamObserver.create();
        this.bankServiceStub.getAllAccounts(noParam, allAccountsResponseResponseStreamObserver);
        System.out.printf("Total account retrieved are %d%n", allAccountsResponseResponseStreamObserver.getList().size());
        allAccountsResponseResponseStreamObserver.await();
        Assertions.assertFalse(allAccountsResponseResponseStreamObserver.getList().isEmpty());
        Assertions.assertNull(allAccountsResponseResponseStreamObserver.getThrowable());
    }
}
