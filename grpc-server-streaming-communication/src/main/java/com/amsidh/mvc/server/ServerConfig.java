package com.amsidh.mvc.server;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Arrays;

public class ServerConfig {

    private final Server server;

    private ServerConfig(Server server) {
        this.server = server;
    }

    public static ServerConfig createServer(int port, BindableService... bindableService) {
        final ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        Arrays.asList(bindableService).forEach(serverBuilder::addService);
        return new ServerConfig(serverBuilder.build());
    }

    // with default port
    public static ServerConfig createServer(BindableService... bindableService) {
        return createServer(6565, bindableService);
    }

    public ServerConfig start() {
        try {
            this.server.start();
            System.out.printf("Server started on port %d%n", this.server.getPort());
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void await() {
        try {
            this.server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        this.server.shutdownNow();
        System.out.println("Server stopped");
    }
}
