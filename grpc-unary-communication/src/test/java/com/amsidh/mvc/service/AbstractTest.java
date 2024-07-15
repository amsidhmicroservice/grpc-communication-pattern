package com.amsidh.mvc.service;


import com.amsidh.mvc.common.AbstractChannelTest;
import com.amsidh.mvc.server.CustomGrpcServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {

    private final CustomGrpcServer grpcServer = CustomGrpcServer.createCustomGrpcServer(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;

    @BeforeAll
    public void setup() {
        this.grpcServer.start();
        this.bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
    }

    @AfterAll
    public void stop() {
        this.grpcServer.stop();
    }

}