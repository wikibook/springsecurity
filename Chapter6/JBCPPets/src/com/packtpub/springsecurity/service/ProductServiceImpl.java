package com.packtpub.springsecurity.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import com.packtpub.springsecurity.dao.IProductDao;
import com.packtpub.springsecurity.data.Category;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao productDao;
	
	@Override
	public Collection<Category> getCategories() {
		// Ch 5 @PostFilter
		return productDao.getCategories();
		// Ch 5 @PreFilter
//		Collection<Category> unfilteredCategories = productDao.getCategories();
//		return productDao.filterCategories(unfilteredCategories);
	}

	@Override
	public Category getCategoryByName(String name) {
		return productDao.getCategoryByName(name);
	}

}
