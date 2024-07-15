package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.AllAccountsResponse;
import com.amsidh.mvc.model.NoParam;
import com.amsidh.mvc.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

import java.util.List;


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

    @Override
    public void getAllAccounts(NoParam request, StreamObserver<AllAccountsResponse> responseObserver) {
        System.out.println("Fetching all accounts from database");
        final List<AccountBalanceResponse> accountBalanceResponses = AccountRepository.getAccounts().entrySet().stream().map(entry -> AccountBalanceResponse.newBuilder().setAccountNumber(entry.getKey()).setBalance(entry.getValue()).build())
                .toList();
        AllAccountsResponse allAccountsResponse = AllAccountsResponse.newBuilder().addAllAccountBalanceResponse(accountBalanceResponses).build();
        responseObserver.onNext(allAccountsResponse);
        responseObserver.onCompleted();
    }
}
