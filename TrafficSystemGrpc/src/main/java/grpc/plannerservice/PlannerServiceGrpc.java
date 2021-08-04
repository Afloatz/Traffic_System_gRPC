package grpc.plannerservice;

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
 * <pre>
 * This service provides information to the drivers for planning their trips.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: plannerService.proto")
public final class PlannerServiceGrpc {

  private PlannerServiceGrpc() {}

  public static final String SERVICE_NAME = "plannerservice.PlannerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.plannerservice.DayRequest,
      grpc.plannerservice.StreetResponse> getGetPedestrianStreetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPedestrianStreets",
      requestType = grpc.plannerservice.DayRequest.class,
      responseType = grpc.plannerservice.StreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.plannerservice.DayRequest,
      grpc.plannerservice.StreetResponse> getGetPedestrianStreetsMethod() {
    io.grpc.MethodDescriptor<grpc.plannerservice.DayRequest, grpc.plannerservice.StreetResponse> getGetPedestrianStreetsMethod;
    if ((getGetPedestrianStreetsMethod = PlannerServiceGrpc.getGetPedestrianStreetsMethod) == null) {
      synchronized (PlannerServiceGrpc.class) {
        if ((getGetPedestrianStreetsMethod = PlannerServiceGrpc.getGetPedestrianStreetsMethod) == null) {
          PlannerServiceGrpc.getGetPedestrianStreetsMethod = getGetPedestrianStreetsMethod = 
              io.grpc.MethodDescriptor.<grpc.plannerservice.DayRequest, grpc.plannerservice.StreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "plannerservice.PlannerService", "GetPedestrianStreets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.plannerservice.DayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.plannerservice.StreetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PlannerServiceMethodDescriptorSupplier("GetPedestrianStreets"))
                  .build();
          }
        }
     }
     return getGetPedestrianStreetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.plannerservice.TimeRequest,
      grpc.plannerservice.DiningStreetResponse> getGetDiningStreetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiningStreets",
      requestType = grpc.plannerservice.TimeRequest.class,
      responseType = grpc.plannerservice.DiningStreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.plannerservice.TimeRequest,
      grpc.plannerservice.DiningStreetResponse> getGetDiningStreetsMethod() {
    io.grpc.MethodDescriptor<grpc.plannerservice.TimeRequest, grpc.plannerservice.DiningStreetResponse> getGetDiningStreetsMethod;
    if ((getGetDiningStreetsMethod = PlannerServiceGrpc.getGetDiningStreetsMethod) == null) {
      synchronized (PlannerServiceGrpc.class) {
        if ((getGetDiningStreetsMethod = PlannerServiceGrpc.getGetDiningStreetsMethod) == null) {
          PlannerServiceGrpc.getGetDiningStreetsMethod = getGetDiningStreetsMethod = 
              io.grpc.MethodDescriptor.<grpc.plannerservice.TimeRequest, grpc.plannerservice.DiningStreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "plannerservice.PlannerService", "GetDiningStreets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.plannerservice.TimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.plannerservice.DiningStreetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PlannerServiceMethodDescriptorSupplier("GetDiningStreets"))
                  .build();
          }
        }
     }
     return getGetDiningStreetsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlannerServiceStub newStub(io.grpc.Channel channel) {
    return new PlannerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlannerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PlannerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlannerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PlannerServiceFutureStub(channel);
  }

  /**
   * <pre>
   * This service provides information to the drivers for planning their trips.
   * </pre>
   */
  public static abstract class PlannerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server streaming
     * Alert users of changes in street situations, such as pedestrian-only on certain days
     * several responses (ex: Monday -&gt; street1 closed, street2 closed)
     * </pre>
     */
    public void getPedestrianStreets(grpc.plannerservice.DayRequest request,
        io.grpc.stub.StreamObserver<grpc.plannerservice.StreetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPedestrianStreetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * Send information to users about streets that are repurposed for outdoor dining depending on the time of the day.
     * response example: street1 outdoor dining true, street2 outdoor dining false, street3 outdoor dining true
     * </pre>
     */
    public void getDiningStreets(grpc.plannerservice.TimeRequest request,
        io.grpc.stub.StreamObserver<grpc.plannerservice.DiningStreetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDiningStreetsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPedestrianStreetsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.plannerservice.DayRequest,
                grpc.plannerservice.StreetResponse>(
                  this, METHODID_GET_PEDESTRIAN_STREETS)))
          .addMethod(
            getGetDiningStreetsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.plannerservice.TimeRequest,
                grpc.plannerservice.DiningStreetResponse>(
                  this, METHODID_GET_DINING_STREETS)))
          .build();
    }
  }

  /**
   * <pre>
   * This service provides information to the drivers for planning their trips.
   * </pre>
   */
  public static final class PlannerServiceStub extends io.grpc.stub.AbstractStub<PlannerServiceStub> {
    private PlannerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlannerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlannerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlannerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming
     * Alert users of changes in street situations, such as pedestrian-only on certain days
     * several responses (ex: Monday -&gt; street1 closed, street2 closed)
     * </pre>
     */
    public void getPedestrianStreets(grpc.plannerservice.DayRequest request,
        io.grpc.stub.StreamObserver<grpc.plannerservice.StreetResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPedestrianStreetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * Send information to users about streets that are repurposed for outdoor dining depending on the time of the day.
     * response example: street1 outdoor dining true, street2 outdoor dining false, street3 outdoor dining true
     * </pre>
     */
    public void getDiningStreets(grpc.plannerservice.TimeRequest request,
        io.grpc.stub.StreamObserver<grpc.plannerservice.DiningStreetResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetDiningStreetsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This service provides information to the drivers for planning their trips.
   * </pre>
   */
  public static final class PlannerServiceBlockingStub extends io.grpc.stub.AbstractStub<PlannerServiceBlockingStub> {
    private PlannerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlannerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlannerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlannerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming
     * Alert users of changes in street situations, such as pedestrian-only on certain days
     * several responses (ex: Monday -&gt; street1 closed, street2 closed)
     * </pre>
     */
    public java.util.Iterator<grpc.plannerservice.StreetResponse> getPedestrianStreets(
        grpc.plannerservice.DayRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPedestrianStreetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming
     * Send information to users about streets that are repurposed for outdoor dining depending on the time of the day.
     * response example: street1 outdoor dining true, street2 outdoor dining false, street3 outdoor dining true
     * </pre>
     */
    public java.util.Iterator<grpc.plannerservice.DiningStreetResponse> getDiningStreets(
        grpc.plannerservice.TimeRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetDiningStreetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This service provides information to the drivers for planning their trips.
   * </pre>
   */
  public static final class PlannerServiceFutureStub extends io.grpc.stub.AbstractStub<PlannerServiceFutureStub> {
    private PlannerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PlannerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlannerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PlannerServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_PEDESTRIAN_STREETS = 0;
  private static final int METHODID_GET_DINING_STREETS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlannerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlannerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PEDESTRIAN_STREETS:
          serviceImpl.getPedestrianStreets((grpc.plannerservice.DayRequest) request,
              (io.grpc.stub.StreamObserver<grpc.plannerservice.StreetResponse>) responseObserver);
          break;
        case METHODID_GET_DINING_STREETS:
          serviceImpl.getDiningStreets((grpc.plannerservice.TimeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.plannerservice.DiningStreetResponse>) responseObserver);
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

  private static abstract class PlannerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlannerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.plannerservice.PlannerServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlannerService");
    }
  }

  private static final class PlannerServiceFileDescriptorSupplier
      extends PlannerServiceBaseDescriptorSupplier {
    PlannerServiceFileDescriptorSupplier() {}
  }

  private static final class PlannerServiceMethodDescriptorSupplier
      extends PlannerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlannerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PlannerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlannerServiceFileDescriptorSupplier())
              .addMethod(getGetPedestrianStreetsMethod())
              .addMethod(getGetDiningStreetsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
