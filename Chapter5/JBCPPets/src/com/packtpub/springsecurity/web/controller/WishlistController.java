/**
 * 
 */
package com.packtpub.springsecurity.web.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springsecurity.data.Item;

/**
 * @author Mularien
 *
 */
@Controller
@RequestMapping("/wishlist/home.do")
public class WishlistController extends BaseController {
	@RequestMapping(method=RequestMethod.GET)
	public void show() {
		
	}
	
	@ModelAttribute("wishlistItems")
	public Collection<Item> getWishlistItems() {
		return new ArrayList<Item>();
	}
}
