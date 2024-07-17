package com.amsidh.mvc.server;

import io.grpc.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CustomGrpcServer {

    private final Server server;

    private CustomGrpcServer(Server server) {
        this.server = server;
    }

    public static CustomGrpcServer createCustomGrpcServer(BindableService... bindableServices) {
        return createCustomGrpcServer(6565, bindableServices);
    }

    public static CustomGrpcServer createCustomGrpcServer(int port, BindableService... bindableServices) {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        Arrays.asList(bindableServices).forEach(serverBuilder::addService);
        return new CustomGrpcServer(serverBuilder.build());
    }

    public CustomGrpcServer start() {
        try {
            final List<String> services = server.getServices().stream().map(ServerServiceDefinition::getServiceDescriptor)
                    .map(ServiceDescriptor::getName).collect(Collectors.toList());
            server.start();
            System.out.printf("Server started on port %d and services %s%n", server.getPort(), services);
            return this;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void await() {
        try {
            server.awaitTermination();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void stop() {
        try {
            server.shutdownNow();
            System.out.println("Server stopped");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
