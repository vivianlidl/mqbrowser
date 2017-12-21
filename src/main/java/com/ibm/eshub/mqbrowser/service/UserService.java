package com.ibm.eshub.mqbrowser.service;

import com.ibm.eshub.mqbrowser.entity.data.User;
import com.ibm.eshub.mqbrowser.req.data.LoginRequest;
import com.ibm.eshub.mqbrowser.req.data.UserRequest;

public interface UserService {

	public void deleteByEmail(String email);

	public void save(UserRequest request);

	public User findByValue(String value);

	public String[] findMails();

	 
}
