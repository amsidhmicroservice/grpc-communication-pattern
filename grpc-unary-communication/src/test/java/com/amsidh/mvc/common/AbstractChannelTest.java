package com.amsidh.mvc.common;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractChannelTest {

    protected ManagedChannel managedChannel;

    @BeforeAll
    public void setupChannel() {
        this.managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                                            .usePlaintext()
                                            .build();
    }

    @AfterAll
    public void stopChannel() throws InterruptedException {
        this.managedChannel.shutdownNow()
                    .awaitTermination(5, TimeUnit.SECONDS);
    }
}
