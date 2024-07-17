package com.amsidh.mvc;

import com.amsidh.mvc.server.ServerConfig;
import com.amsidh.mvc.service.WithdrawBankAccountService;

public class ServerStreamingApp {
    public static void main(String[] args) {
        ServerConfig
                .createServer(new WithdrawBankAccountService())
                .start().await();
    }
}
