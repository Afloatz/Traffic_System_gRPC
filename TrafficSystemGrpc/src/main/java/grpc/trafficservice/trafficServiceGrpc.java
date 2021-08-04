package grpc.trafficservice;

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
 *This service provides real-time information about the foot/pedestrian traffic situation in popular areas
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: trafficService.proto")
public final class trafficServiceGrpc {

  private trafficServiceGrpc() {}

  public static final String SERVICE_NAME = "trafficservice.trafficService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.trafficservice.RequestEmergency,
      grpc.trafficservice.EmergencyResponse> getSendEmergencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendEmergency",
      requestType = grpc.trafficservice.RequestEmergency.class,
      responseType = grpc.trafficservice.EmergencyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.trafficservice.RequestEmergency,
      grpc.trafficservice.EmergencyResponse> getSendEmergencyMethod() {
    io.grpc.MethodDescriptor<grpc.trafficservice.RequestEmergency, grpc.trafficservice.EmergencyResponse> getSendEmergencyMethod;
    if ((getSendEmergencyMethod = trafficServiceGrpc.getSendEmergencyMethod) == null) {
      synchronized (trafficServiceGrpc.class) {
        if ((getSendEmergencyMethod = trafficServiceGrpc.getSendEmergencyMethod) == null) {
          trafficServiceGrpc.getSendEmergencyMethod = getSendEmergencyMethod = 
              io.grpc.MethodDescriptor.<grpc.trafficservice.RequestEmergency, grpc.trafficservice.EmergencyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "trafficservice.trafficService", "sendEmergency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.RequestEmergency.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.EmergencyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new trafficServiceMethodDescriptorSupplier("sendEmergency"))
                  .build();
          }
        }
     }
     return getSendEmergencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.trafficservice.Area,
      grpc.trafficservice.StreetSituation> getLiveFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LiveFeed",
      requestType = grpc.trafficservice.Area.class,
      responseType = grpc.trafficservice.StreetSituation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.trafficservice.Area,
      grpc.trafficservice.StreetSituation> getLiveFeedMethod() {
    io.grpc.MethodDescriptor<grpc.trafficservice.Area, grpc.trafficservice.StreetSituation> getLiveFeedMethod;
    if ((getLiveFeedMethod = trafficServiceGrpc.getLiveFeedMethod) == null) {
      synchronized (trafficServiceGrpc.class) {
        if ((getLiveFeedMethod = trafficServiceGrpc.getLiveFeedMethod) == null) {
          trafficServiceGrpc.getLiveFeedMethod = getLiveFeedMethod = 
              io.grpc.MethodDescriptor.<grpc.trafficservice.Area, grpc.trafficservice.StreetSituation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "trafficservice.trafficService", "LiveFeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.Area.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.StreetSituation.getDefaultInstance()))
                  .setSchemaDescriptor(new trafficServiceMethodDescriptorSupplier("LiveFeed"))
                  .build();
          }
        }
     }
     return getLiveFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.trafficservice.Video,
      grpc.trafficservice.WarningResponse> getCalculatePedestrianNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculatePedestrianNumber",
      requestType = grpc.trafficservice.Video.class,
      responseType = grpc.trafficservice.WarningResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.trafficservice.Video,
      grpc.trafficservice.WarningResponse> getCalculatePedestrianNumberMethod() {
    io.grpc.MethodDescriptor<grpc.trafficservice.Video, grpc.trafficservice.WarningResponse> getCalculatePedestrianNumberMethod;
    if ((getCalculatePedestrianNumberMethod = trafficServiceGrpc.getCalculatePedestrianNumberMethod) == null) {
      synchronized (trafficServiceGrpc.class) {
        if ((getCalculatePedestrianNumberMethod = trafficServiceGrpc.getCalculatePedestrianNumberMethod) == null) {
          trafficServiceGrpc.getCalculatePedestrianNumberMethod = getCalculatePedestrianNumberMethod = 
              io.grpc.MethodDescriptor.<grpc.trafficservice.Video, grpc.trafficservice.WarningResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "trafficservice.trafficService", "CalculatePedestrianNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.Video.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.WarningResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new trafficServiceMethodDescriptorSupplier("CalculatePedestrianNumber"))
                  .build();
          }
        }
     }
     return getCalculatePedestrianNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.trafficservice.UserAlertRequest,
      grpc.trafficservice.UserAlertResponse> getStreetAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreetAlert",
      requestType = grpc.trafficservice.UserAlertRequest.class,
      responseType = grpc.trafficservice.UserAlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.trafficservice.UserAlertRequest,
      grpc.trafficservice.UserAlertResponse> getStreetAlertMethod() {
    io.grpc.MethodDescriptor<grpc.trafficservice.UserAlertRequest, grpc.trafficservice.UserAlertResponse> getStreetAlertMethod;
    if ((getStreetAlertMethod = trafficServiceGrpc.getStreetAlertMethod) == null) {
      synchronized (trafficServiceGrpc.class) {
        if ((getStreetAlertMethod = trafficServiceGrpc.getStreetAlertMethod) == null) {
          trafficServiceGrpc.getStreetAlertMethod = getStreetAlertMethod = 
              io.grpc.MethodDescriptor.<grpc.trafficservice.UserAlertRequest, grpc.trafficservice.UserAlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "trafficservice.trafficService", "StreetAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.UserAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.trafficservice.UserAlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new trafficServiceMethodDescriptorSupplier("StreetAlert"))
                  .build();
          }
        }
     }
     return getStreetAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static trafficServiceStub newStub(io.grpc.Channel channel) {
    return new trafficServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static trafficServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new trafficServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static trafficServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new trafficServiceFutureStub(channel);
  }

  /**
   * <pre>
   *This service provides real-time information about the foot/pedestrian traffic situation in popular areas
   * </pre>
   */
  public static abstract class trafficServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary: user send a message for emergency
     * </pre>
     */
    public void sendEmergency(grpc.trafficservice.RequestEmergency request,
        io.grpc.stub.StreamObserver<grpc.trafficservice.EmergencyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendEmergencyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server streaming: provide a live feed to the user on the current pedestrian traffic situation in a particular area.
     * example of area: Dublin 1 to Dublin 22
     * </pre>
     */
    public void liveFeed(grpc.trafficservice.Area request,
        io.grpc.stub.StreamObserver<grpc.trafficservice.StreetSituation> responseObserver) {
      asyncUnimplementedUnaryCall(getLiveFeedMethod(), responseObserver);
    }

    /**
     * <pre>
     * Send information from the street camera at William Street to the server
     * client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.trafficservice.Video> calculatePedestrianNumber(
        io.grpc.stub.StreamObserver<grpc.trafficservice.WarningResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCalculatePedestrianNumberMethod(), responseObserver);
    }

    /**
     * <pre>
     * Allow users to alert fellow users about the current traffic situation in popular areas
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.trafficservice.UserAlertRequest> streetAlert(
        io.grpc.stub.StreamObserver<grpc.trafficservice.UserAlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreetAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendEmergencyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.trafficservice.RequestEmergency,
                grpc.trafficservice.EmergencyResponse>(
                  this, METHODID_SEND_EMERGENCY)))
          .addMethod(
            getLiveFeedMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.trafficservice.Area,
                grpc.trafficservice.StreetSituation>(
                  this, METHODID_LIVE_FEED)))
          .addMethod(
            getCalculatePedestrianNumberMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.trafficservice.Video,
                grpc.trafficservice.WarningResponse>(
                  this, METHODID_CALCULATE_PEDESTRIAN_NUMBER)))
          .addMethod(
            getStreetAlertMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.trafficservice.UserAlertRequest,
                grpc.trafficservice.UserAlertResponse>(
                  this, METHODID_STREET_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   *This service provides real-time information about the foot/pedestrian traffic situation in popular areas
   * </pre>
   */
  public static final class trafficServiceStub extends io.grpc.stub.AbstractStub<trafficServiceStub> {
    private trafficServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private trafficServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected trafficServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new trafficServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary: user send a message for emergency
     * </pre>
     */
    public void sendEmergency(grpc.trafficservice.RequestEmergency request,
        io.grpc.stub.StreamObserver<grpc.trafficservice.EmergencyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendEmergencyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server streaming: provide a live feed to the user on the current pedestrian traffic situation in a particular area.
     * example of area: Dublin 1 to Dublin 22
     * </pre>
     */
    public void liveFeed(grpc.trafficservice.Area request,
        io.grpc.stub.StreamObserver<grpc.trafficservice.StreetSituation> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLiveFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Send information from the street camera at William Street to the server
     * client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.trafficservice.Video> calculatePedestrianNumber(
        io.grpc.stub.StreamObserver<grpc.trafficservice.WarningResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCalculatePedestrianNumberMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Allow users to alert fellow users about the current traffic situation in popular areas
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.trafficservice.UserAlertRequest> streetAlert(
        io.grpc.stub.StreamObserver<grpc.trafficservice.UserAlertResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreetAlertMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *This service provides real-time information about the foot/pedestrian traffic situation in popular areas
   * </pre>
   */
  public static final class trafficServiceBlockingStub extends io.grpc.stub.AbstractStub<trafficServiceBlockingStub> {
    private trafficServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private trafficServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected trafficServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new trafficServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary: user send a message for emergency
     * </pre>
     */
    public grpc.trafficservice.EmergencyResponse sendEmergency(grpc.trafficservice.RequestEmergency request) {
      return blockingUnaryCall(
          getChannel(), getSendEmergencyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server streaming: provide a live feed to the user on the current pedestrian traffic situation in a particular area.
     * example of area: Dublin 1 to Dublin 22
     * </pre>
     */
    public java.util.Iterator<grpc.trafficservice.StreetSituation> liveFeed(
        grpc.trafficservice.Area request) {
      return blockingServerStreamingCall(
          getChannel(), getLiveFeedMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *This service provides real-time information about the foot/pedestrian traffic situation in popular areas
   * </pre>
   */
  public static final class trafficServiceFutureStub extends io.grpc.stub.AbstractStub<trafficServiceFutureStub> {
    private trafficServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private trafficServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected trafficServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new trafficServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary: user send a message for emergency
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.trafficservice.EmergencyResponse> sendEmergency(
        grpc.trafficservice.RequestEmergency request) {
      return futureUnaryCall(
          getChannel().newCall(getSendEmergencyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_EMERGENCY = 0;
  private static final int METHODID_LIVE_FEED = 1;
  private static final int METHODID_CALCULATE_PEDESTRIAN_NUMBER = 2;
  private static final int METHODID_STREET_ALERT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final trafficServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(trafficServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_EMERGENCY:
          serviceImpl.sendEmergency((grpc.trafficservice.RequestEmergency) request,
              (io.grpc.stub.StreamObserver<grpc.trafficservice.EmergencyResponse>) responseObserver);
          break;
        case METHODID_LIVE_FEED:
          serviceImpl.liveFeed((grpc.trafficservice.Area) request,
              (io.grpc.stub.StreamObserver<grpc.trafficservice.StreetSituation>) responseObserver);
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
        case METHODID_CALCULATE_PEDESTRIAN_NUMBER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.calculatePedestrianNumber(
              (io.grpc.stub.StreamObserver<grpc.trafficservice.WarningResponse>) responseObserver);
        case METHODID_STREET_ALERT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streetAlert(
              (io.grpc.stub.StreamObserver<grpc.trafficservice.UserAlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class trafficServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    trafficServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.trafficservice.TrafficServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("trafficService");
    }
  }

  private static final class trafficServiceFileDescriptorSupplier
      extends trafficServiceBaseDescriptorSupplier {
    trafficServiceFileDescriptorSupplier() {}
  }

  private static final class trafficServiceMethodDescriptorSupplier
      extends trafficServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    trafficServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (trafficServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new trafficServiceFileDescriptorSupplier())
              .addMethod(getSendEmergencyMethod())
              .addMethod(getLiveFeedMethod())
              .addMethod(getCalculatePedestrianNumberMethod())
              .addMethod(getStreetAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
