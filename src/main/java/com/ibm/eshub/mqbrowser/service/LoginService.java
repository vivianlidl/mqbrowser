package com.ibm.eshub.mqbrowser.service;

import com.ibm.eshub.mqbrowser.req.data.LoginRequest;
import com.ibm.eshub.mqbrowser.res.data.ResponseData;

public interface LoginService {

	//public User findByEmail(String email);

	//public boolean checkUserAuth(LoginRequest user);

	public ResponseData login(LoginRequest user);

	public abstract boolean isAlive(String paramString);

	public abstract ResponseData loadLoginData(String paramString);

	public abstract void remove(String paramString);

}
