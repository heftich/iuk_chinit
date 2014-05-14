package ch.chinit.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;


/**
 * 
 * @author Norman Suesstrunk
 */

@ManagedBean
@SessionScoped
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
