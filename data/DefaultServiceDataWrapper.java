package com.ibm.txhub.tools.service.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DefaultServiceDataWrapper extends AbstractServiceDataWrapper
{
  private static final long serialVersionUID = -7153936596084534342L;
  private Map<String, Serializable> datas = new HashMap();

  public <T> T getPropValue(String key, Class<T> c)
  {
    if (this.datas.containsKey(key)) {
      return (T) this.datas.get(key);
    }
    return null;
  }

  public void putPropValue(String key, Serializable v)
  {
    this.datas.put(key, v);
  }

  public void clean()
  {
    super.clean();
    this.datas.clear();
  }
}