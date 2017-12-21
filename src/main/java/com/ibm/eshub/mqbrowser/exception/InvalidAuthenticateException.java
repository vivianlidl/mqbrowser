package com.ibm.eshub.mqbrowser.exception;

public class InvalidAuthenticateException extends LogicException
{
  public InvalidAuthenticateException()
  {
  }

  public InvalidAuthenticateException(String message)
  {
    super(message);
  }

  public InvalidAuthenticateException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidAuthenticateException(Throwable cause) {
    super(cause);
  }

  public InvalidAuthenticateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}