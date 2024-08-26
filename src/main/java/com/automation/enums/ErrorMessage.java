package com.automation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum for having error messages in the application. */
@Getter
@AllArgsConstructor
public enum ErrorMessage {
  LOCKED_ERROR("Epic sadface: Sorry, this user has been locked out."),
  WRONG_USER("Epic sadface: Username and password do not match any user in this service");

  private String message;
}
