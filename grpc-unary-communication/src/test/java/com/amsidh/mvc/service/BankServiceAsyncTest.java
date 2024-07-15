package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.AllAccountsResponse;
import com.amsidh.mvc.model.NoParam;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class BankServiceAsyncTest extends AbstractTest {

    @Test
    public void getBalanceAsyncTest() throws InterruptedException {
        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest.newBuilder().setAccountNumber(1).build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.bankServiceStub.getAccountBalance(accountBalanceRequest, new StreamObserver<>() {
            @Override
            public void onNext(AccountBalanceResponse accountBalanceResponse) {
                System.out.printf("Unary async balance received %d%n", accountBalanceResponse.getBalance());
                Assertions.assertNotNull(accountBalanceResponse);
                Assertions.assertEquals(99, accountBalanceResponse.getBalance());
                countDownLatch.countDown();
            }

            @Override
            public void onError(Throwable throwable) {
                // System.out.printf("Got some error %s%n", throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                // System.out.println("getAccountBalance is completed");
            }
        });

        countDownLatch.await();
    }

    @Test
    public void allAccountsAsyncTest() throws InterruptedException {
        NoParam noParam = NoParam.newBuilder().build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.bankServiceStub.getAllAccounts(noParam, new StreamObserver<>() {
            @Override
            public void onNext(AllAccountsResponse allAccountsResponse) {
                final List<AccountBalanceResponse> accountBalanceResponseList = allAccountsResponse.getAccountBalanceResponseList();
                System.out.printf("Total account retrieved are %d%n", accountBalanceResponseList.size());
                Assertions.assertFalse(accountBalanceResponseList.isEmpty());
                countDownLatch.countDown();
            }

            @Override
            public void onError(Throwable throwable) {
                // System.out.printf("Got some error in allAccounts method %s%n", throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                //System.out.println("allAccountsTest is completed");
            }
        });
        countDownLatch.await();
    }
}
