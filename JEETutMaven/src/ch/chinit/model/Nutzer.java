package ch.chinit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nutzer database table.
 * 
 */
@Entity
@NamedQuery(name="Nutzer.findAll", query="SELECT n FROM Nutzer n")
public class Nutzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;

	private String avatar;

	private String email;

	private String hausnummer;

	private String land;

	private String nachname;

	private String ort;

	private String postleitzahl;

	private String strasse;

	private String username;

	private String vorname;

	//bi-directional many-to-one association to Lo
	@OneToMany(mappedBy="nutzer")
	private List<Los> los;

	public Nutzer() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHausnummer() {
		return this.hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getLand() {
		return this.land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPostleitzahl() {
		return this.postleitzahl;
	}

	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public List<Los> getLos() {
		return this.los;
	}

	public void setLos(List<Los> los) {
		this.los = los;
	}

	public Los addLo(Los lo) {
		getLos().add(lo);
		lo.setNutzer(this);

		return lo;
	}

	public Los removeLo(Los lo) {
		getLos().remove(lo);
		lo.setNutzer(null);

		return lo;
	}

}