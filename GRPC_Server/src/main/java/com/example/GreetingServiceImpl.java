package com.example;


import com.example.grpc.GeneratorServiceGrpc;
import com.example.grpc.GeneratorServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GeneratorServiceGrpc.GeneratorServiceImplBase {

    private final static int SECOND = 1000;

    @Override
    public void generate(GeneratorServiceOuterClass.GeneratorRequest request, StreamObserver<GeneratorServiceOuterClass.GeneratorResponse> responseObserver)  {
        int firstValue = request.getFirstValue();
        int lastValue = request.getLastValue();
        for (int i = firstValue; i <= lastValue; ++i) {
            try {
                Thread.sleep(SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GeneratorServiceOuterClass.GeneratorResponse response = GeneratorServiceOuterClass
                    .GeneratorResponse.newBuilder()
                    .setGeneratedValue(i)
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
