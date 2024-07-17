package com.amsidh.mvc.service;

import com.amsidh.mvc.common.ResponseStreamObserver;
import com.amsidh.mvc.model.FundTransferRequest;
import com.amsidh.mvc.model.FundTransferResponse;
import com.amsidh.mvc.model.TransferStatus;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FundTransferServiceTest extends AbstractTest {

    @Test
    void transferFund() {
        final ResponseStreamObserver<FundTransferResponse> responseStreamObserver = ResponseStreamObserver.create();
        final StreamObserver<FundTransferRequest> requestStreamObserver = bankServiceStub.transferFund(responseStreamObserver);
        requestStreamObserver.onNext(FundTransferRequest.newBuilder().setFromAccountNumber(1).setToAccountNumber(2).setAmount(20).build());
        requestStreamObserver.onNext(FundTransferRequest.newBuilder().setFromAccountNumber(3).setToAccountNumber(4).setAmount(20).build());
        requestStreamObserver.onNext(FundTransferRequest.newBuilder().setFromAccountNumber(5).setToAccountNumber(6).setAmount(20).build());
        requestStreamObserver.onNext(FundTransferRequest.newBuilder().setFromAccountNumber(8).setToAccountNumber(8).setAmount(20).build());
        requestStreamObserver.onCompleted();
        responseStreamObserver.await();
        Assertions.assertEquals(4, responseStreamObserver.getList().size());
        validateResponse(responseStreamObserver.getList().get(0), TransferStatus.COMPLETED, 80, 120);
        validateResponse(responseStreamObserver.getList().get(1), TransferStatus.COMPLETED, 80, 120);
        validateResponse(responseStreamObserver.getList().get(2), TransferStatus.COMPLETED, 80, 120);
        validateResponse(responseStreamObserver.getList().get(3), TransferStatus.REJECTED, 100, 100);

    }

    private void validateResponse(FundTransferResponse fundTransferResponse, TransferStatus transferStatus, int fromAccountBalance, int toAccountBalance){

        Assertions.assertEquals(transferStatus, fundTransferResponse.getTransferStatus());
        Assertions.assertEquals(fromAccountBalance, fundTransferResponse.getFromAccountBalance().getBalance());
        Assertions.assertEquals(toAccountBalance, fundTransferResponse.getToAccountBalance().getBalance());

    }
}