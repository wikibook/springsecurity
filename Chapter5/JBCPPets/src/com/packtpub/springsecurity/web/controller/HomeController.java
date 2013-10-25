/**
 * 
 */
package com.packtpub.springsecurity.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springsecurity.dao.IProductDao;
import com.packtpub.springsecurity.data.Category;
import com.packtpub.springsecurity.service.IProductService;

/**
 * This controller is used to provide functionality for the home page.
 * 
 * @author Mularien
 *
 */
@Controller
public class HomeController extends BaseController {
	@Autowired
	private IProductService productService;

	@ModelAttribute("categories")
	public Collection<Category> getCategories() {
		return productService.getCategories();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/home.do")
	public void home() {
	}
}
