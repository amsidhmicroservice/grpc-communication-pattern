// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/module.proto

package com.amsidh.mvc.model;

public final class Module {
  private Module() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AccountBalanceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AccountBalanceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Money_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Money_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022model/module.proto\"H\n\025AccountBalanceRe" +
      "quest\022\026\n\016account_number\030\001 \001(\005\022\027\n\017withdra" +
      "w_amount\030\002 \001(\005\"/\n\005Money\022\026\n\016account_numbe" +
      "r\030\001 \001(\005\022\016\n\006amount\030\002 \001(\005B\030\n\024com.amsidh.mv" +
      "c.modelP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_AccountBalanceRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AccountBalanceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AccountBalanceRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "WithdrawAmount", });
    internal_static_Money_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Money_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Money_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
