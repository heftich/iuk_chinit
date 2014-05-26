package ch.chinit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the nutzerrechte database table.
 * 
 */
@Entity
@NamedQuery(name="Nutzerrechte.findAll", query="SELECT n FROM Nutzerrechte n")
public class Nutzerrechte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	
	@Column(name="username")
	private String userName;

	@Column(name="role_name")
	private String roleName;
	
	public Nutzerrechte() {
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Nutzerrechte)) {
			return false;
		}
		Nutzerrechte castOther = (Nutzerrechte)other;
		return 
			this.userName.equals(castOther.userName)
			&& this.roleName.equals(castOther.roleName);
	}
}