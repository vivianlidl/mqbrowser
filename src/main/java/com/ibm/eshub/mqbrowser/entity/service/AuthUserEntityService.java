package com.ibm.eshub.mqbrowser.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.eshub.mqbrowser.entity.data.User;
import com.ibm.eshub.mqbrowser.entity.repository.UserRepository;

@Service
public class AuthUserEntityService implements AuthUserEntity {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

}
