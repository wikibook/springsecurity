package com.packtpub.springsecurity.web.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packtpub.springsecurity.service.IUserService;

/**
 * This controller is used to provide functionality for the login page.
 * 
 * @author Mularien
 */
@Controller
public class LoginLogoutController extends BaseController{
	// Ch 8 User Registration
	@Autowired
	private IUserService userService;

	@RequestMapping(method=RequestMethod.GET,value="/login.do")
	public void home() {
	}

	// Ch 8 User Registration
	@RequestMapping(method=RequestMethod.GET,value="/registration.do")
	public void registration() {		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/registrationOpenid.do")
	public String registrationOpenId(HttpServletRequest request) {
		String userId = (String) request.getSession().getAttribute("USER_OPENID_CREDENTIAL");
		if(userId != null) {
			userService.createUser(userId, "unused", null);
			setMessage(request, "Your account has been created. Please log in using your OpenID.");
			return "redirect:login.do";
		} else {
			setMessage(request, "Please register using your OpenID.");
			return "redirect:registration.do";			
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registration.do")
	public String submitRegistration(@RequestParam("userid") String userId,
			@RequestParam("password") String password,
			@RequestParam("email") String email, HttpServletRequest request) {
		userService.createUser(userId, password, email);
		setMessage(request, "Your account has been created. Please log in.");
		return "redirect:login.do";		
	}
	
	// Ch 6 Access Denied
	@RequestMapping(method=RequestMethod.GET, value="/accessDenied.do")
	public void accessDenied(ModelMap model, HttpServletRequest request) {
		AccessDeniedException ex = (AccessDeniedException) request.getAttribute(AccessDeniedHandlerImpl.SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY);
		StringWriter sw = new StringWriter();
		model.addAttribute("errorDetails", ex.getMessage());
		ex.printStackTrace(new PrintWriter(sw));
		model.addAttribute("errorTrace", sw.toString());
	}
}
