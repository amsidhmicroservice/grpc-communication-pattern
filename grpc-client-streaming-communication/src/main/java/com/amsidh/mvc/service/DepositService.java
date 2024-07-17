package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.DepositRequest;
import io.grpc.stub.StreamObserver;

public class DepositService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public StreamObserver<DepositRequest> deposit(StreamObserver<AccountBalanceResponse> responseObserver) {

        return new DepositRequestHandler(responseObserver);
    }
}
