package com.amsidh.mvc;

import com.amsidh.mvc.server.GrpcServer;
import com.amsidh.mvc.service.BackPressureFlowControllerService;

public class ServerBackPressureApp {
    public static void main(String[] args) {
       GrpcServer.createCustomGrpcServer(new BackPressureFlowControllerService()).start().await();
    }
}
