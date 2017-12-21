package com.ibm.eshub.mqbrowser.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.eshub.mqbrowser.exception.InvalidTokenException;
import com.ibm.eshub.mqbrowser.req.data.LoginRequest;
import com.ibm.eshub.mqbrowser.res.data.ResponseData;
import com.ibm.eshub.mqbrowser.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LoginService userService;

	 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseData login(@RequestBody LoginRequest user, HttpServletRequest requestt) {
		logger.debug("login data: {}", user);
		ResponseData responseData = userService.login(user);
		return responseData;
	}

 
	@RequestMapping(value = "/isValid/{token}", method = RequestMethod.GET)
	public ResponseData isValid(@PathVariable("token") String token) {
		logger.debug("token is {}", token);

		if (!userService.isAlive(token)) {
			throw new InvalidTokenException(token);
		}
		return userService.loadLoginData(token);
	}

	@RequestMapping(value = "/logout/{token}", method = RequestMethod.POST)
	public ResponseData logout(@PathVariable("token") String token) {
		ResponseData responseData = ResponseData.ok();
		userService.remove(token);
		return responseData;
	}
}