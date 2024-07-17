package com.amsidh.mvc.service;

import com.amsidh.mvc.model.FundTransferRequest;
import com.amsidh.mvc.model.FundTransferResponse;
import io.grpc.stub.StreamObserver;

public class FundTransferService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public StreamObserver<FundTransferRequest> transferFund(StreamObserver<FundTransferResponse> responseObserver) {

        return new FundTransferRequestHandler(responseObserver);
    }
}
