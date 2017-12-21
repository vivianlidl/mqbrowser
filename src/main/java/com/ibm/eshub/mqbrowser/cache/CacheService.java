package com.ibm.eshub.mqbrowser.cache;

import com.ibm.eshub.mqbrowser.res.data.ResponseData;

public interface CacheService
{ 
	public boolean hasValue(String key);
	
	public void putObject(String key, ResponseData res);
    
    public void remove(String key);
    
    public ResponseData loadObject(String key);
 

}