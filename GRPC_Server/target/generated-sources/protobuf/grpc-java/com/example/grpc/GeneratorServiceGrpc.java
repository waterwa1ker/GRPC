package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: GeneratorService.proto")
public final class GeneratorServiceGrpc {

  private GeneratorServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.GeneratorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest,
      com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> getGenerateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generate",
      requestType = com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest.class,
      responseType = com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest,
      com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> getGenerateMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest, com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> getGenerateMethod;
    if ((getGenerateMethod = GeneratorServiceGrpc.getGenerateMethod) == null) {
      synchronized (GeneratorServiceGrpc.class) {
        if ((getGenerateMethod = GeneratorServiceGrpc.getGenerateMethod) == null) {
          GeneratorServiceGrpc.getGenerateMethod = getGenerateMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest, com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "generate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GeneratorServiceMethodDescriptorSupplier("generate"))
              .build();
        }
      }
    }
    return getGenerateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GeneratorServiceStub newStub(io.grpc.Channel channel) {
    return new GeneratorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeneratorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GeneratorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GeneratorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GeneratorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GeneratorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void generate(com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest,
                com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse>(
                  this, METHODID_GENERATE)))
          .build();
    }
  }

  /**
   */
  public static final class GeneratorServiceStub extends io.grpc.stub.AbstractStub<GeneratorServiceStub> {
    private GeneratorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeneratorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeneratorServiceStub(channel, callOptions);
    }

    /**
     */
    public void generate(com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGenerateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GeneratorServiceBlockingStub extends io.grpc.stub.AbstractStub<GeneratorServiceBlockingStub> {
    private GeneratorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeneratorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeneratorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse> generate(
        com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGenerateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GeneratorServiceFutureStub extends io.grpc.stub.AbstractStub<GeneratorServiceFutureStub> {
    private GeneratorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeneratorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneratorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeneratorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GENERATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GeneratorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GeneratorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE:
          serviceImpl.generate((com.example.grpc.GeneratorServiceOuterClass.GeneratorRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GeneratorServiceOuterClass.GeneratorResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeneratorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.GeneratorServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GeneratorService");
    }
  }

  private static final class GeneratorServiceFileDescriptorSupplier
      extends GeneratorServiceBaseDescriptorSupplier {
    GeneratorServiceFileDescriptorSupplier() {}
  }

  private static final class GeneratorServiceMethodDescriptorSupplier
      extends GeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GeneratorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GeneratorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GeneratorServiceFileDescriptorSupplier())
              .addMethod(getGenerateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
