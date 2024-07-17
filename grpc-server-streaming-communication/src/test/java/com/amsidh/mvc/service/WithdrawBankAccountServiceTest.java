package com.amsidh.mvc.service;

import com.amsidh.mvc.common.ResponseStreamObserver;
import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class WithdrawBankAccountServiceTest extends AbstractTest {


    @Test
    void withdrawByAsyncClient() {
        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest
                .newBuilder()
                .setAccountNumber(1)
                .setWithdrawAmount(50)
                .build();

        final ResponseStreamObserver<Money> objectResponseStreamObserver = ResponseStreamObserver.create(1);
        bankServiceStub.withdraw(accountBalanceRequest, objectResponseStreamObserver);
        objectResponseStreamObserver.await();
        Assertions.assertNotNull(objectResponseStreamObserver);

    }

    @Test
    void withdrawByBlockingClient() {
        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest
                .newBuilder()
                .setAccountNumber(2)
                .setWithdrawAmount(50)
                .build();

        final Iterator<Money> iterator = bankServiceBlockingStub.withdraw(accountBalanceRequest);
        int count = 0;
        while (iterator.hasNext()) {
            Money money = (Money)iterator.next();
            System.out.printf("received money %s%n", money);
            count++;

        }
        Assertions.assertEquals(6, count);

    }



}