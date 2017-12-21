package com.ibm.txhub.tools.service.data;

import java.io.File;
import java.text.MessageFormat;
import java.util.Calendar;

import com.ibm.txhub.tools.service.common.ServiceApplicationException;
import com.ibm.txhub.tools.service.util.ServiceUtil;

public abstract class AbstractServiceDataWrapper
  implements ServiceDataWrapper
{
  protected static final transient String NAME_FORMAT = "{0}#{1}#{2}";
  private static final long serialVersionUID = 7844032627913708848L;
  private String category;
  private String serviceType;
  private String hostname;
  private int port;
  private String serviceName;
  private String aliasName;
  private String userId;
  private String password;
  private String description;
  private Calendar createTime;
  private int sequence;

  public String getDescription()
  {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHostname() {
    if (ServiceUtil.isNullorEmpty(this.hostname)) {
      return "localhost";
    }
    return this.hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public int getPort() {
    return this.port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getServiceName() {
    return this.serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
    this.createTime = Calendar.getInstance();
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCategory()
  {
    if (ServiceUtil.isNullorEmpty(this.category)) {
      return this.serviceName;
    }
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getServiceType()
  {
    return this.serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public Calendar getCreateTime()
  {
    return this.createTime;
  }

  public boolean isLocal()
  {
    return ServiceUtil.isNullorEmpty(this.hostname);
  }

  public String getFileName()
  {
    String s = MessageFormat.format("{0}#{1}#{2}", new Object[] { getHostname(), getServiceName(), getUserId() });
    s = s.replace('.', '_');
    return s;
  }

  public int getSequence()
  {
    return this.sequence;
  }

  public void setSequence(int sequence)
  {
    this.sequence = sequence;
  }

  public String getAliasName()
  {
    if (ServiceUtil.isNullorEmpty(this.aliasName)) {
      return this.serviceName;
    }
    return this.aliasName;
  }

  public void setAliasName(String aliasName) {
    this.aliasName = aliasName;
  }

  public void serialize(String root)
    throws ServiceApplicationException
  {
    ServiceUtil.writeObject(root, getFileName(), this);
  }

  public void remove(String root) throws ServiceApplicationException
  {
    File file = new File(root, getFileName());
    if (file.exists())
      file.delete();
  }

  public void clean()
  {
    this.category = null;
    this.serviceType = null;
    this.hostname = null;
    this.port = 0;
    this.serviceName = null;
    this.userId = null;
    this.password = null;
    this.description = null;
  }
}