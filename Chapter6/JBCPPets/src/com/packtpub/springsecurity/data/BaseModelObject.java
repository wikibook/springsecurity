package com.packtpub.springsecurity.data;

/**
 * Base model object class, tracks primary key.
 * 
 * @author Mularien
 */
public class BaseModelObject {
	private int id;

	private static int NEXT_ID=1;
	private static Object NEXT_ID_LOCK = new Object();

	/**
	 * Constructor assigns "primary key".
	 */
	protected BaseModelObject() {
		super();
		synchronized(NEXT_ID_LOCK) {
			this.id = NEXT_ID++;
		}
	}

	/**
	 * Gets the primary key of the object.
	 * 
	 * @return object PK
	 */
	public int getId() {
		return id;
	}		
}
