package com.amsidh.mvc.service;

import com.amsidh.mvc.model.Output;
import com.amsidh.mvc.model.RequestSize;
import io.grpc.stub.StreamObserver;

public class BackPressureFlowControllerService extends BackPressureGrpc.BackPressureImplBase {
    @Override
    public StreamObserver<RequestSize> getMessages(StreamObserver<Output> responseObserver) {

        return new BackPressureRequestHandler(responseObserver);

    }
}
