package com.ibm.eshub.mqbrowser.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ibm.eshub.mqbrowser.logic.data.LoginData;
import com.ibm.eshub.mqbrowser.res.data.ResponseData;
@Service
public class LoginDataCacheService implements CacheService{

	@Override
	public boolean hasValue(String key) {
		 
		if (loadObject(key) != null) {
			return true;
		}
		return false;
	}
 
	@Override
	@CacheEvict(value = "user", key = "#p0")//
	public void remove(String key) {
		// TODO Auto-generated method stub
		
	}

	 

	@Override
	@CachePut(value = "user", key = "#p0")
	public void putObject(String key, ResponseData res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Cacheable(value = "user", key = "#p0")
	public ResponseData loadObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
