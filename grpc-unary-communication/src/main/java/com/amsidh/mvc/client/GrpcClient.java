package com.amsidh.mvc.client;

import com.amsidh.mvc.model.AccountBalanceRequest;
import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.service.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        final ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        final BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

        AccountBalanceRequest accountBalanceRequest = AccountBalanceRequest.newBuilder().setAccountNumber(1).build();
        final AccountBalanceResponse accountBalanceResponse = bankServiceBlockingStub.getAccountBalance(accountBalanceRequest);
        final int balance = accountBalanceResponse.getBalance();
        System.out.printf("Account Balancer %d%n", balance);
    }
}

