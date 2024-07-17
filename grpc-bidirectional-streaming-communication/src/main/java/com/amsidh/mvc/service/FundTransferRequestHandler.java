package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountBalance;
import com.amsidh.mvc.model.FundTransferRequest;
import com.amsidh.mvc.model.FundTransferResponse;
import com.amsidh.mvc.model.TransferStatus;
import com.amsidh.mvc.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

import java.util.Objects;

public class FundTransferRequestHandler implements StreamObserver<FundTransferRequest> {

    private final StreamObserver<FundTransferResponse> responseObserver;

    public FundTransferRequestHandler(StreamObserver<FundTransferResponse> responseObserver) {
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(FundTransferRequest fundTransferRequest) {
        var fromAccountNumber = fundTransferRequest.getFromAccountNumber();
        var toAccountNumber = fundTransferRequest.getToAccountNumber();
        var transferAmount = fundTransferRequest.getAmount();
        TransferStatus transferStatus = TransferStatus.REJECTED;
        if (AccountRepository.getAccountBalance(fromAccountNumber) > transferAmount && (!Objects.equals(fromAccountNumber, toAccountNumber))) {
            AccountRepository.withdrawAmount(fromAccountNumber, transferAmount);
            AccountRepository.depositAmount(toAccountNumber, transferAmount);
            transferStatus = TransferStatus.COMPLETED;
        } else {
            System.out.println("Insufficient balance in account number " + fromAccountNumber);
        }

        FundTransferResponse fundTransferResponse = FundTransferResponse.newBuilder()
                .setTransferStatus(transferStatus)
                .setFromAccountBalance(AccountBalance.newBuilder().setAccountNumber(fromAccountNumber).setBalance(AccountRepository.getAccountBalance(fromAccountNumber)).build())
                .setToAccountBalance(AccountBalance.newBuilder().setAccountNumber(toAccountNumber).setBalance(AccountRepository.getAccountBalance(toAccountNumber)).build())
                .build();
        responseObserver.onNext(fundTransferResponse);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Client Error " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println("transfer stream request is completed");
        responseObserver.onCompleted();
    }
}
