package com.ibm.eshub.mqbrowser.entity.service;

import com.ibm.eshub.mqbrowser.entity.data.User;

public interface AuthUserEntity {
	User findByEmail(String email);
}
