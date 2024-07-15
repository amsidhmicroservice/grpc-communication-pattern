package com.amsidh.mvc.common;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ResponseStreamObserver<T> implements StreamObserver<T> {

    private final List<T> list = Collections.synchronizedList(new ArrayList<T>());
    private Throwable throwable;

    private final CountDownLatch latch;

    private ResponseStreamObserver(Integer countDown) {
        latch = new CountDownLatch(countDown);
    }

    public static <T> ResponseStreamObserver<T> create() {
        return new ResponseStreamObserver<>(1);
    }

    public static <T> ResponseStreamObserver<T> create(int countDown) {
        return new ResponseStreamObserver<>(countDown);
    }

    @Override
    public void onNext(T t) {
        System.out.printf("Received item %s", t);
        this.list.add(t);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.printf("Exception Received %s", throwable.getMessage());
        this.throwable = throwable;
        this.latch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Completed");
        this.latch.countDown();
    }

    public void await() {
        try {
            this.latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> getList() {
        return list;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
