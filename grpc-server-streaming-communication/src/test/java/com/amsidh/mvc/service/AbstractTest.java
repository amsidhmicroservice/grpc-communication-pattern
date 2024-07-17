package com.amsidh.mvc.service;


import com.amsidh.mvc.BankServiceGrpc;
import com.amsidh.mvc.common.AbstractChannelTest;
import com.amsidh.mvc.server.ServerConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {

    private final ServerConfig grpcServer = ServerConfig.createServer(new WithdrawBankAccountService());
    protected BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;
    protected BankServiceGrpc.BankServiceStub bankServiceStub;

    @BeforeAll
    public void setup() {
        this.grpcServer.start();
        this.bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
        this.bankServiceStub = BankServiceGrpc.newStub(managedChannel);
    }

    @AfterAll
    public void stop() {
        this.grpcServer.stop();
    }

}