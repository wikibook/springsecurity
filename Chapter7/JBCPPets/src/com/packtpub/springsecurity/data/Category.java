package com.packtpub.springsecurity.data;

public class Category extends BaseModelObject {
	private String name;
	private boolean customersOnly;
	
	public Category(String name, boolean customersOnly) {
		super();

		this.name = name;
		this.customersOnly = customersOnly;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the customersOnly
	 */
	public boolean isCustomersOnly() {
		return customersOnly;
	}	
}
