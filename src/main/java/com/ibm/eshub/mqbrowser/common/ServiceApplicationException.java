package  com.ibm.eshub.mqbrowser.common;
 

public class ServiceApplicationException extends RuntimeException
{
  private static final long serialVersionUID = -3220311947908225524L;
 

  public ServiceApplicationException()
  {
  }

  public ServiceApplicationException(String message) {
    super(message);
  }

  public ServiceApplicationException(Throwable cause) {
    super(cause);
  }

  public ServiceApplicationException(String message, Throwable cause) {
    super(message, cause);
  }

}