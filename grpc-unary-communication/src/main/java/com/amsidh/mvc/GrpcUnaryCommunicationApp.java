package com.amsidh.mvc;

import com.amsidh.mvc.server.CustomGrpcServer;
import com.amsidh.mvc.service.BankService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcUnaryCommunicationApp {
    public static void main(String[] args) throws Exception {
        CustomGrpcServer.createCustomGrpcServer(new BankService())
                .start()
                .await();
    }
}
