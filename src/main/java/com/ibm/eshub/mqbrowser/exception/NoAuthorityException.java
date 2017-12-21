package com.ibm.eshub.mqbrowser.exception;

public class NoAuthorityException extends LogicException
{
  public NoAuthorityException()
  {
  }

  public NoAuthorityException(String message)
  {
    super(message);
  }

  public NoAuthorityException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoAuthorityException(Throwable cause) {
    super(cause);
  }

  public NoAuthorityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}