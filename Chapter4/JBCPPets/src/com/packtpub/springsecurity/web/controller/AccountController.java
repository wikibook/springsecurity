package com.packtpub.springsecurity.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packtpub.springsecurity.security.IChangePassword;

/**
 * Used to service account requests.
 * 
 * @author Mularien
 */
@Controller
public class AccountController extends BaseController {
	// Ch 4 start and end
	@Autowired
	private IChangePassword changePasswordDao;
	// Ch 4 UserDetailsManager exercise
	//@Autowired
	//private UserDetailsManager userDetailsManager;
	
	@RequestMapping("/account/home.do")
	public void accountHome() {		
	}
	@RequestMapping(value="/account/changePassword.do",method=RequestMethod.GET)
	public void showChangePasswordPage() {		
	}
	@RequestMapping(value="/account/changePassword.do",method=RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("password") String newPassword) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = principal.toString();
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		}
		
		changePasswordDao.changePassword(username, newPassword);
		SecurityContextHolder.clearContext();
		
		return "redirect:home.do";
	}

	/* Ch 4 UserDetailsManager version
	@RequestMapping(value="/account/changePassword.do",method=RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("oldpassword") String oldPassword, 
			@RequestParam("password") String newPassword) {
		userDetailsManager.changePassword(oldPassword, newPassword);
		SecurityContextHolder.clearContext();
		
		return "redirect:home.do";
	}
	*/
}
