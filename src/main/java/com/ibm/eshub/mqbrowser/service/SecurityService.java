package com.ibm.eshub.mqbrowser.service;

import com.ibm.eshub.mqbrowser.entity.data.User;

public interface SecurityService {
     
    User findByEmail(String email); 
     
}
