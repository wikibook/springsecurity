package com.packtpub.springsecurity.service;

import java.util.Collection;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;

import com.packtpub.springsecurity.data.Category;

public interface IProductService {
	/**
	 * Get all categories the user has access to.
	 * 
	 * @return the list of available categories
	 */
	// Ch 5 @PostFilter
	@PostFilter("(!filterObject.customersOnly) or (filterObject.customersOnly and hasRole('ROLE_ADMIN'))")
	Collection<Category> getCategories();

	/**
	 * Finds the category with the given name.
	 * @param name the name of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryByName(String name);
}
