package com.amsidh.mvc;

import com.amsidh.mvc.server.CustomGrpcServer;
import com.amsidh.mvc.service.DepositService;

public class ClientStreamingApp {
    public static void main(String[] args) {
        CustomGrpcServer.createCustomGrpcServer(new DepositService()).start().await();
    }
}
