package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalanceResponse;
import com.amsidh.mvc.model.DepositRequest;
import com.amsidh.mvc.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

public class DepositRequestHandler implements StreamObserver<DepositRequest> {
    private Integer accountNumber;
    private final StreamObserver<AccountBalanceResponse> responseObserver;

    public DepositRequestHandler(StreamObserver<AccountBalanceResponse> responseObserver){
        this.responseObserver = responseObserver;
    }
    @Override
    public void onNext(DepositRequest depositRequest) {
        switch (depositRequest.getRequestCase()) {
            case ACCOUNT_NUMBER -> this.accountNumber = depositRequest.getAccountNumber();
            case MONEY ->
                    AccountRepository.depositAmount(this.accountNumber, depositRequest.getMoney().getDepositMoney());

        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Client Error " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        final AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.newBuilder().setAccountNumber(this.accountNumber).setBalance(AccountRepository.getAccountBalance(this.accountNumber)).build();
        this.responseObserver.onNext(accountBalanceResponse);
        this.responseObserver.onCompleted();
    }
}
