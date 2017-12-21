package com.ibm.eshub.mqbrowser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ibm.eshub.mqbrowser.entity.data.User;
import com.ibm.eshub.mqbrowser.entity.service.AuthUserEntity;

@Service
public class SecurityServiceImpl implements SecurityService {

	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Autowired
	AuthUserEntity authUserEntity;

	public User findByEmail(String email) {
		logger.debug("find by email: {}", email);
		return authUserEntity.findByEmail(email);
	}

}
