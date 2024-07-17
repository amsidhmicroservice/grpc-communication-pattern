package com.amsidh.mvc.service;

import com.amsidh.mvc.common.ResponseStreamObserver;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.DepositRequest;
import com.amsidh.mvc.model.Money;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepositServiceTest extends AbstractTest {

    @Test
    public void depositTest() {
        final ResponseStreamObserver<AccountBalanceResponse> balanceResponseStreamObserver = ResponseStreamObserver.create();
        final StreamObserver<DepositRequest> depositRequestStreamObserver = bankServiceStub.deposit(balanceResponseStreamObserver);
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setAccountNumber(1).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onCompleted();

        balanceResponseStreamObserver.await();

        final AccountBalanceResponse accountBalanceResponse = balanceResponseStreamObserver.getList().get(0);
        Assertions.assertEquals(500, accountBalanceResponse.getBalance());
        Assertions.assertNull(balanceResponseStreamObserver.getThrowable());
    }

    @Test
    public void depositCancelStreamTest() {
        final ResponseStreamObserver<AccountBalanceResponse> balanceResponseStreamObserver = ResponseStreamObserver.create();
        final StreamObserver<DepositRequest> depositRequestStreamObserver = bankServiceStub.deposit(balanceResponseStreamObserver);
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setAccountNumber(1).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setDepositMoney(100).build()).build());
        depositRequestStreamObserver.onError(new RuntimeException("Manually stream ending"));

        balanceResponseStreamObserver.await();

        Assertions.assertEquals(0, balanceResponseStreamObserver.getList().size());
        Assertions.assertNotNull(balanceResponseStreamObserver.getThrowable());
    }
}
