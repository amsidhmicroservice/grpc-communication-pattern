package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.repository.AccountRepository;
import io.grpc.stub.StreamObserver;


public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(AccountBalanceRequest request, StreamObserver<AccountBalanceResponse> responseObserver) {
        final int accountNumber = request.getAccountNumber();
        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse
                .newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepository.getAccountBalance(accountNumber))
                .build();
        responseObserver.onNext(accountBalanceResponse);
        responseObserver.onCompleted();

    }
}
