package com.ibm.eshub.mqbrowser.exception;

public class AuthenticateServerFailException extends LogicException
{
  public AuthenticateServerFailException()
  {
  }

  public AuthenticateServerFailException(String message)
  {
    super(message);
  }

  public AuthenticateServerFailException(String message, Throwable cause) {
    super(message, cause);
  }

  public AuthenticateServerFailException(Throwable cause) {
    super(cause);
  }

  public AuthenticateServerFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}