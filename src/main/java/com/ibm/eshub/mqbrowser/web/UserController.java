package com.ibm.eshub.mqbrowser.web;

 
 
 
import swat.ReturnCode;

import static swat.cwa.authenticate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.eshub.mqbrowser.auth.validator.UserValidator;
import com.ibm.eshub.mqbrowser.entity.data.User;
import com.ibm.eshub.mqbrowser.exception.InvalidAuthenticateException;
import com.ibm.eshub.mqbrowser.req.data.LoginRequest;
import com.ibm.eshub.mqbrowser.res.data.ResponseData;
import com.ibm.eshub.mqbrowser.service.LoginService;
import com.ibm.eshub.mqbrowser.service.SecurityService;
 
import com.ibm.eshub.mqbrowser.util.JWT;

@Controller
@RequestMapping("/usermanager")  
public class UserController {
    @Autowired
    private LoginService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

     
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@RequestBody User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        //userService.save(userForm);

        //securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    	/*@PostMapping("/login")  
        @ResponseBody  
        public ResponseData login(@RequestParam String username, @RequestParam String password) {  
            if ("imjack".equals(username) && "123456".equals(password)) {  
                ResponseData responseData = ResponseData.ok();  
                User user = new User();  
                user.setId(1);  
                user.setUsername(username);  
                user.setPassword(password);  
                responseData.putDataValue("user", user);  
                String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);  
                if (token != null) {  
                    responseData.putDataValue("token", token);  
                }  
                return responseData;  
            }  
            return ResponseData.customerError().putDataValue(ResponseData.ERRORS_KEY, new String[] { "用户名或者密码错误" });  
        }  */
    
   @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseData login1(@RequestBody LoginRequest user, HttpServletRequest request) {
	   ResponseData reqponseData = userService.login(user);
	   return reqponseData;
    }
  
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody User user, HttpServletRequest request) {//@ModelAttribute("userForm") User userForm
    	//userService.save(user);
    	return "save";
    }

    
}
