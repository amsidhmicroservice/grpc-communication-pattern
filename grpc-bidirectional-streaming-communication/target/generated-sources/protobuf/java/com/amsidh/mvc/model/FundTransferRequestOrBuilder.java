// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/module.proto

package com.amsidh.mvc.model;

public interface FundTransferRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FundTransferRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 from_account_number = 1;</code>
   * @return The fromAccountNumber.
   */
  int getFromAccountNumber();

  /**
   * <code>int32 to_account_number = 2;</code>
   * @return The toAccountNumber.
   */
  int getToAccountNumber();

  /**
   * <code>int32 amount = 3;</code>
   * @return The amount.
   */
  int getAmount();
}
