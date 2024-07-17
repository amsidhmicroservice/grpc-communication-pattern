package com.amsidh.mvc.service;

import com.amsidh.mvc.model.Output;
import com.amsidh.mvc.model.RequestSize;
import io.grpc.stub.StreamObserver;

import java.util.stream.IntStream;

public class BackPressureRequestHandler implements StreamObserver<RequestSize> {

    private final StreamObserver<Output> responseObserver;

    private Integer emitted;

    public BackPressureRequestHandler(StreamObserver<Output> responseObserver) {
        this.responseObserver = responseObserver;
        this.emitted = 0;
    }


    @Override
    public void onNext(RequestSize requestSize) {
        IntStream.range((emitted + 1), 100)
                .limit(requestSize.getSize())
                .forEach(value -> {
                    System.out.printf("Emitted Value %d%n", value);
                    responseObserver.onNext(Output.newBuilder().setValue(value).build());
                });
        emitted = emitted + requestSize.getSize();
        if (emitted >= 100) {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Client Error " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println("Client request stream completed");
        responseObserver.onCompleted();
    }
}
