package com.amsidh.mvc.service;

import com.amsidh.mvc.BankServiceGrpc;
import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.Money;
import com.amsidh.mvc.repository.AccountRepository;
import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class WithdrawBankAccountService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void withdraw(AccountBalanceRequest request, StreamObserver<Money> responseObserver) {
        final int accountNumber = request.getAccountNumber();
        final Integer accountBalance = AccountRepository.getAccountBalance(accountNumber);
        final int withdrawAmount = request.getWithdrawAmount();
        if (accountBalance > withdrawAmount) {
            for (int i = 0; i <= (withdrawAmount / 10); i++) {
                AccountRepository.withdrawMoney(accountNumber, 10);
                Money money = Money.newBuilder().setAccountNumber(accountNumber).setAmount(10).build();
                responseObserver.onNext(money);
                System.out.printf("Money sent %s%n", money);
            }
        } else {
            System.out.println("Account balance is less than withdrawal amount so no withdrawal possible");
            responseObserver.onCompleted();
            return;
        }

        responseObserver.onCompleted();

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }
}
