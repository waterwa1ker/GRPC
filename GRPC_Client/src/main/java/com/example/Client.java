package com.example;

import com.example.grpc.GeneratorServiceGrpc;
import com.example.grpc.GeneratorServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class Client {

    private static final int FIRST_VALUE = 0;
    private static final int LAST_VALUE = 30;
    private static final int ITERATION_COUNT = 50;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GeneratorServiceGrpc.GeneratorServiceBlockingStub stub = GeneratorServiceGrpc.newBlockingStub(channel);
        GeneratorServiceOuterClass.GeneratorRequest request = GeneratorServiceOuterClass.GeneratorRequest
                .newBuilder()
                .setFirstValue(FIRST_VALUE)
                .setLastValue(LAST_VALUE)
                .build();
        int currentValue = 0;
        for (int i = 0; i < ITERATION_COUNT; ++i) {
            Iterator<GeneratorServiceOuterClass.GeneratorResponse> response = stub.generate(request);
            while (response.hasNext()) {
                currentValue += response.next().getGeneratedValue() + 1;
                System.out.println(currentValue);
            }
        }
        channel.shutdown();
    }

}
