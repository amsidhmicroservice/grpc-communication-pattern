package com.amsidh.mvc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: service/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BackPressureGrpc {

  private BackPressureGrpc() {}

  public static final java.lang.String SERVICE_NAME = "BackPressure";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amsidh.mvc.model.RequestSize,
      com.amsidh.mvc.model.Output> getGetMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessages",
      requestType = com.amsidh.mvc.model.RequestSize.class,
      responseType = com.amsidh.mvc.model.Output.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.amsidh.mvc.model.RequestSize,
      com.amsidh.mvc.model.Output> getGetMessagesMethod() {
    io.grpc.MethodDescriptor<com.amsidh.mvc.model.RequestSize, com.amsidh.mvc.model.Output> getGetMessagesMethod;
    if ((getGetMessagesMethod = BackPressureGrpc.getGetMessagesMethod) == null) {
      synchronized (BackPressureGrpc.class) {
        if ((getGetMessagesMethod = BackPressureGrpc.getGetMessagesMethod) == null) {
          BackPressureGrpc.getGetMessagesMethod = getGetMessagesMethod =
              io.grpc.MethodDescriptor.<com.amsidh.mvc.model.RequestSize, com.amsidh.mvc.model.Output>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amsidh.mvc.model.RequestSize.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amsidh.mvc.model.Output.getDefaultInstance()))
              .setSchemaDescriptor(new BackPressureMethodDescriptorSupplier("getMessages"))
              .build();
        }
      }
    }
    return getGetMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BackPressureStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackPressureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackPressureStub>() {
        @java.lang.Override
        public BackPressureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackPressureStub(channel, callOptions);
        }
      };
    return BackPressureStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackPressureBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackPressureBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackPressureBlockingStub>() {
        @java.lang.Override
        public BackPressureBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackPressureBlockingStub(channel, callOptions);
        }
      };
    return BackPressureBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BackPressureFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackPressureFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackPressureFutureStub>() {
        @java.lang.Override
        public BackPressureFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackPressureFutureStub(channel, callOptions);
        }
      };
    return BackPressureFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.amsidh.mvc.model.RequestSize> getMessages(
        io.grpc.stub.StreamObserver<com.amsidh.mvc.model.Output> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetMessagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BackPressure.
   */
  public static abstract class BackPressureImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BackPressureGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BackPressure.
   */
  public static final class BackPressureStub
      extends io.grpc.stub.AbstractAsyncStub<BackPressureStub> {
    private BackPressureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackPressureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackPressureStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.amsidh.mvc.model.RequestSize> getMessages(
        io.grpc.stub.StreamObserver<com.amsidh.mvc.model.Output> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetMessagesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BackPressure.
   */
  public static final class BackPressureBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BackPressureBlockingStub> {
    private BackPressureBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackPressureBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackPressureBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BackPressure.
   */
  public static final class BackPressureFutureStub
      extends io.grpc.stub.AbstractFutureStub<BackPressureFutureStub> {
    private BackPressureFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackPressureFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackPressureFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MESSAGES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getMessages(
              (io.grpc.stub.StreamObserver<com.amsidh.mvc.model.Output>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.amsidh.mvc.model.RequestSize,
              com.amsidh.mvc.model.Output>(
                service, METHODID_GET_MESSAGES)))
        .build();
  }

  private static abstract class BackPressureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackPressureBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amsidh.mvc.service.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackPressure");
    }
  }

  private static final class BackPressureFileDescriptorSupplier
      extends BackPressureBaseDescriptorSupplier {
    BackPressureFileDescriptorSupplier() {}
  }

  private static final class BackPressureMethodDescriptorSupplier
      extends BackPressureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BackPressureMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BackPressureGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BackPressureFileDescriptorSupplier())
              .addMethod(getGetMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
