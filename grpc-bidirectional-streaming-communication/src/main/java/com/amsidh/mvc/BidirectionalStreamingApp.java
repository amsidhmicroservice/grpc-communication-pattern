package com.amsidh.mvc;

import com.amsidh.mvc.server.CustomGrpcServer;
import com.amsidh.mvc.service.FundTransferService;

public class BidirectionalStreamingApp {
    public static void main(String[] args) {
        CustomGrpcServer.createCustomGrpcServer(new FundTransferService()).start().await();
    }
}
