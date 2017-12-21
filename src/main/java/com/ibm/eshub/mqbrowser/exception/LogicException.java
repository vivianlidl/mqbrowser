package com.ibm.eshub.mqbrowser.exception;

public class LogicException extends RuntimeException
{
  public LogicException()
  {
  }

  public LogicException(String message)
  {
    super(message);
  }

  public LogicException(String message, Throwable cause) {
    super(message, cause);
  }

  public LogicException(Throwable cause) {
    super(cause);
  }

  public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public String getErrorCode() {
    return getClass().getName();
  }
}