package com.ibm.txhub.tools.service.data;

import java.io.Serializable;
import java.util.Calendar;

import com.ibm.txhub.tools.service.common.ServiceApplicationException;

public abstract interface ServiceDataWrapper extends Serializable
{
  public abstract String getHostname();

  public abstract int getPort();

  public abstract String getServiceName();

  public abstract String getUserId();

  public abstract String getPassword();

  public abstract String getServiceType();

  public abstract String getDescription();

  public abstract String getFileName();

  public abstract String getCategory();

  public abstract Calendar getCreateTime();

  public abstract void setSequence(int paramInt);

  public abstract int getSequence();

  public abstract boolean isLocal();

  public abstract <T> T getPropValue(String paramString, Class<T> paramClass);

  public abstract void putPropValue(String paramString, Serializable paramSerializable);

  public abstract void serialize(String paramString)
    throws ServiceApplicationException;

  public abstract void remove(String paramString)
    throws ServiceApplicationException;

  public abstract void clean();

  public abstract String getAliasName();
}