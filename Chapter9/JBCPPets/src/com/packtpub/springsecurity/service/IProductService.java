package com.packtpub.springsecurity.service;

import java.util.Collection;

import javax.annotation.security.PermitAll;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import com.packtpub.springsecurity.data.Category;
import com.packtpub.springsecurity.data.Item;

public interface IProductService {
	/**
	 * Get all categories the user has access to.
	 * 
	 * @return the list of available categories
	 */
	// Ch 5 @PostFilter
	//@PostFilter("(!filterObject.customersOnly) or (filterObject.customersOnly and hasRole('ROLE_ADMIN'))")
	// Ch 7 @PostFilter example
	//@PostFilter("hasPermission(filterObject, 'READ') or hasPermission(filterObject, 'ADMIN_READ')")
	Collection<Category> getCategories();

	/**
	 * Finds the category with the given name.
	 * @param name the name of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryByName(String name);

	// Ch 7 ACL
//	@Secured("VOTE_CATEGORY_READ")
	// Ch 7 Custom Permission
	@Secured({"VOTE_CATEGORY_READ","VOTE_ADMIN_READ"})
	public Collection<Item> getItemsByCategory(Category cat);
}
