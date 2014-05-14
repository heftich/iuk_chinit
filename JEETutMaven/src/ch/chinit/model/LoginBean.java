package ch.chinit.model;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
/**
 * 
 * @author Norman Suesstrunk
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	
	Logger logger = Logger.getLogger(getClass().getName()); 
	
	private String username;
	
	private String password;

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.login(this.username, this.password);
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage("Login failed."));
			return "login.xhtml";
		}
		logger.info("login successfull!");
		return "admin/index.xhtml?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.logout();
			
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage("Logout failed."));
		}
		return "../index.xhtml?faces-redirect=true";
	}
}
