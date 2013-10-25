package com.packtpub.springsecurity.dao;

import java.util.Collection;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import com.packtpub.springsecurity.data.Category;

public interface IProductDao {

	/**
	 * Get all categories the user has access to.
	 * 
	 * @return the list of available categories
	 */
	Collection<Category> getCategories();

	/**
	 * Finds the category with the given name.
	 * @param name the name of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryByName(String name);

	/**
	 * Filter the categories by security constraints.
	 * @param categories the categories to filter
	 * @return the filtered collection
	 */
	// Ch 5 @PreFilter
//	@PreFilter("(!filterObject.customersOnly) or (filterObject.customersOnly and hasRole('ROLE_ADMIN'))")
	public Collection<Category> filterCategories(Collection<Category> categories);
}