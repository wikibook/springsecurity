package com.packtpub.springsecurity.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packtpub.springsecurity.service.IUserService;

/**
 * Used to service account requests.
 * 
 * @author Mularien
 */
@Controller
public class AccountController extends BaseController {
	// Ch 5 Update to add service tier
	@Autowired
	private IUserService userService;
	
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
		
		userService.changePassword(username, newPassword);
		SecurityContextHolder.clearContext();
		
		return "redirect:home.do";
	}
/*
	@RequestMapping("/account/listActiveUsers.do")
	public void listActiveUsers(Model model) {
		Map<Object,Date> lastActivityDates = new HashMap<Object, Date>();
		for(Object principal: sessionRegistry.getAllPrincipals()) {
			// a principal may have multiple active sessions
			for(SessionInformation session : 
					sessionRegistry.getAllSessions(principal, false))
			{
				// no last activity stored
				if(lastActivityDates.get(principal) == null) {
					lastActivityDates.put(principal, session.getLastRequest());
				} else {
					// check to see if this session is newer than the last stored
					Date prevLastRequest = lastActivityDates.get(principal);
					if(session.getLastRequest().after(prevLastRequest)) {
						// update if so
						lastActivityDates.put(principal, session.getLastRequest());						
					}
				}
			}
		}
		model.addAttribute("activeUsers", lastActivityDates);
	}
	*/
}
