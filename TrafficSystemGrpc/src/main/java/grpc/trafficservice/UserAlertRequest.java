// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trafficService.proto

package grpc.trafficservice;

/**
 * Protobuf type {@code trafficservice.UserAlertRequest}
 */
public  final class UserAlertRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:trafficservice.UserAlertRequest)
    UserAlertRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserAlertRequest.newBuilder() to construct.
  private UserAlertRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserAlertRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserAlertRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            grpc.trafficservice.Alert.Builder subBuilder = null;
            if (alert_ != null) {
              subBuilder = alert_.toBuilder();
            }
            alert_ = input.readMessage(grpc.trafficservice.Alert.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(alert_);
              alert_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.trafficservice.TrafficServiceImpl.internal_static_trafficservice_UserAlertRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.trafficservice.TrafficServiceImpl.internal_static_trafficservice_UserAlertRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.trafficservice.UserAlertRequest.class, grpc.trafficservice.UserAlertRequest.Builder.class);
  }

  public static final int ALERT_FIELD_NUMBER = 1;
  private grpc.trafficservice.Alert alert_;
  /**
   * <code>.trafficservice.Alert alert = 1;</code>
   */
  public boolean hasAlert() {
    return alert_ != null;
  }
  /**
   * <code>.trafficservice.Alert alert = 1;</code>
   */
  public grpc.trafficservice.Alert getAlert() {
    return alert_ == null ? grpc.trafficservice.Alert.getDefaultInstance() : alert_;
  }
  /**
   * <code>.trafficservice.Alert alert = 1;</code>
   */
  public grpc.trafficservice.AlertOrBuilder getAlertOrBuilder() {
    return getAlert();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (alert_ != null) {
      output.writeMessage(1, getAlert());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (alert_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAlert());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.trafficservice.UserAlertRequest)) {
      return super.equals(obj);
    }
    grpc.trafficservice.UserAlertRequest other = (grpc.trafficservice.UserAlertRequest) obj;

    boolean result = true;
    result = result && (hasAlert() == other.hasAlert());
    if (hasAlert()) {
      result = result && getAlert()
          .equals(other.getAlert());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAlert()) {
      hash = (37 * hash) + ALERT_FIELD_NUMBER;
      hash = (53 * hash) + getAlert().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.trafficservice.UserAlertRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.trafficservice.UserAlertRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.trafficservice.UserAlertRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.trafficservice.UserAlertRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.trafficservice.UserAlertRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code trafficservice.UserAlertRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:trafficservice.UserAlertRequest)
      grpc.trafficservice.UserAlertRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.trafficservice.TrafficServiceImpl.internal_static_trafficservice_UserAlertRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.trafficservice.TrafficServiceImpl.internal_static_trafficservice_UserAlertRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.trafficservice.UserAlertRequest.class, grpc.trafficservice.UserAlertRequest.Builder.class);
    }

    // Construct using grpc.trafficservice.UserAlertRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (alertBuilder_ == null) {
        alert_ = null;
      } else {
        alert_ = null;
        alertBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.trafficservice.TrafficServiceImpl.internal_static_trafficservice_UserAlertRequest_descriptor;
    }

    @java.lang.Override
    public grpc.trafficservice.UserAlertRequest getDefaultInstanceForType() {
      return grpc.trafficservice.UserAlertRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.trafficservice.UserAlertRequest build() {
      grpc.trafficservice.UserAlertRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.trafficservice.UserAlertRequest buildPartial() {
      grpc.trafficservice.UserAlertRequest result = new grpc.trafficservice.UserAlertRequest(this);
      if (alertBuilder_ == null) {
        result.alert_ = alert_;
      } else {
        result.alert_ = alertBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.trafficservice.UserAlertRequest) {
        return mergeFrom((grpc.trafficservice.UserAlertRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.trafficservice.UserAlertRequest other) {
      if (other == grpc.trafficservice.UserAlertRequest.getDefaultInstance()) return this;
      if (other.hasAlert()) {
        mergeAlert(other.getAlert());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.trafficservice.UserAlertRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.trafficservice.UserAlertRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private grpc.trafficservice.Alert alert_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        grpc.trafficservice.Alert, grpc.trafficservice.Alert.Builder, grpc.trafficservice.AlertOrBuilder> alertBuilder_;
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public boolean hasAlert() {
      return alertBuilder_ != null || alert_ != null;
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public grpc.trafficservice.Alert getAlert() {
      if (alertBuilder_ == null) {
        return alert_ == null ? grpc.trafficservice.Alert.getDefaultInstance() : alert_;
      } else {
        return alertBuilder_.getMessage();
      }
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public Builder setAlert(grpc.trafficservice.Alert value) {
      if (alertBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        alert_ = value;
        onChanged();
      } else {
        alertBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public Builder setAlert(
        grpc.trafficservice.Alert.Builder builderForValue) {
      if (alertBuilder_ == null) {
        alert_ = builderForValue.build();
        onChanged();
      } else {
        alertBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public Builder mergeAlert(grpc.trafficservice.Alert value) {
      if (alertBuilder_ == null) {
        if (alert_ != null) {
          alert_ =
            grpc.trafficservice.Alert.newBuilder(alert_).mergeFrom(value).buildPartial();
        } else {
          alert_ = value;
        }
        onChanged();
      } else {
        alertBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public Builder clearAlert() {
      if (alertBuilder_ == null) {
        alert_ = null;
        onChanged();
      } else {
        alert_ = null;
        alertBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public grpc.trafficservice.Alert.Builder getAlertBuilder() {
      
      onChanged();
      return getAlertFieldBuilder().getBuilder();
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    public grpc.trafficservice.AlertOrBuilder getAlertOrBuilder() {
      if (alertBuilder_ != null) {
        return alertBuilder_.getMessageOrBuilder();
      } else {
        return alert_ == null ?
            grpc.trafficservice.Alert.getDefaultInstance() : alert_;
      }
    }
    /**
     * <code>.trafficservice.Alert alert = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        grpc.trafficservice.Alert, grpc.trafficservice.Alert.Builder, grpc.trafficservice.AlertOrBuilder> 
        getAlertFieldBuilder() {
      if (alertBuilder_ == null) {
        alertBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            grpc.trafficservice.Alert, grpc.trafficservice.Alert.Builder, grpc.trafficservice.AlertOrBuilder>(
                getAlert(),
                getParentForChildren(),
                isClean());
        alert_ = null;
      }
      return alertBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:trafficservice.UserAlertRequest)
  }

  // @@protoc_insertion_point(class_scope:trafficservice.UserAlertRequest)
  private static final grpc.trafficservice.UserAlertRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.trafficservice.UserAlertRequest();
  }

  public static grpc.trafficservice.UserAlertRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserAlertRequest>
      PARSER = new com.google.protobuf.AbstractParser<UserAlertRequest>() {
    @java.lang.Override
    public UserAlertRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserAlertRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserAlertRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserAlertRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.trafficservice.UserAlertRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

