package com.ibm.eshub.mqbrowser.service;

import static swat.cwa.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ibm.eshub.mqbrowser.cache.CacheService;
import com.ibm.eshub.mqbrowser.exception.AuthenticateServerFailException;
import com.ibm.eshub.mqbrowser.exception.InvalidAuthenticateException;
import com.ibm.eshub.mqbrowser.exception.NoAuthorityException;
import com.ibm.eshub.mqbrowser.logic.data.LoginData;
import com.ibm.eshub.mqbrowser.req.data.LoginRequest;
import com.ibm.eshub.mqbrowser.res.data.ResponseData;
import com.ibm.eshub.mqbrowser.util.JWT;

import swat.ReturnCode;

@Service
public class LoginServiceImpl implements LoginService {

	private static final String BLUEPAGE_SERVER = "bluepages.ibm.com";

	private static final int STATE_SUCCESS = 0;

	private static final int STATE_INVALID_USER = 6;

	private static final int STATE_INVALID_PASSWORD = 9;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private CacheService cacheService;

	@Override
	public ResponseData login(LoginRequest user) {
		ResponseData responseData = ResponseData.ok();

		String email = user.getEmail();
		String password = user.getPassword();
		// TODO 1. validate
		/*
		 * userValidator.validate(user, bindingResult); if
		 * (bindingResult.hasErrors()) { return responseData; }
		 */

		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new InvalidAuthenticateException(user.getEmail());
		}
		// 2. Check if it is authorized user
		if (securityService.findByEmail(email) != null) {
			throw new NoAuthorityException(email);
		}

		// 3. bluepage validation
		ReturnCode code = authenticate(BLUEPAGE_SERVER, email, password);
		if (code.getCode() == STATE_SUCCESS) {
			// generate token
			String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
			if (token != null) {
				responseData.putDataValue("token", token);
			}
			responseData.putDataValue("email", email);
			// TODO trace user
			// this.traceService.trace(name, ip);
			// 4. put token to cache
			LoginData loginData = new LoginData(token, email);
			 cacheService.putObject(token, responseData);
			

			return responseData;

		}

		if (code.getCode() == STATE_INVALID_USER || code.getCode() == STATE_INVALID_PASSWORD) {
			throw new InvalidAuthenticateException(email);
		}

		throw new AuthenticateServerFailException();

	}

	@Override
	public boolean isAlive(String token) {
		 return cacheService.hasValue(token);
	}

	@Override
	public ResponseData loadLoginData(String token) {
		if (!isAlive(token)) {
			return null;
		}
		 return (ResponseData) cacheService.loadObject(token);

	}

	@Override
	public void remove(String token) {
		 cacheService.remove(token);
	}

}
