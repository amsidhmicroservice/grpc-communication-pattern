package com.amsidh.mvc;

import com.amsidh.mvc.service.BankService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServerApp {
    public static void main(String[] args) throws Exception {
        final Server server = ServerBuilder
                .forPort(6565)
                .addService(new BankService())
                .build();

        server.start();
        server.awaitTermination();
    }
}
