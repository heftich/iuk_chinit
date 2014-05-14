package org.company;

/**
 * 
 * @author Norman Suesstrunk
 */
public class User {
	
	private String name;
	
	/**
	 * a constructor with no arguments is needed 
	 * when we plainly reference the bean field "name"
	 */
	public User() {
		this.name = "Peter";
	}
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
