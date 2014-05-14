package ch.chinit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the artikel database table.
 * 
 */
@Entity
@NamedQuery(name="Artikel.findAll", query="SELECT a FROM Artikel a")
public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="artikel_id")
	private Integer artikelId;

	@Column(name="art_name")
	private String artName;

	private String beschreibung;

	private String bild;

	private BigDecimal preis;

	private String slots;

	private Boolean verkauft;

	//bi-directional many-to-one association to Kategorien
	@ManyToOne
	@JoinColumn(name="kategorie")
	private Kategorien kategorien;

	//bi-directional many-to-one association to Lo
	@OneToMany(mappedBy="artikel")
	private List<Los> los;

	public Artikel() {
	}

	public Integer getArtikelId() {
		return this.artikelId;
	}

	public void setArtikelId(Integer artikelId) {
		this.artikelId = artikelId;
	}

	public String getArtName() {
		return this.artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getBild() {
		return this.bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}

	public BigDecimal getPreis() {
		return this.preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	public String getSlots() {
		return this.slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public Boolean getVerkauft() {
		return this.verkauft;
	}

	public void setVerkauft(Boolean verkauft) {
		this.verkauft = verkauft;
	}

	public Kategorien getKategorien() {
		return this.kategorien;
	}

	public void setKategorien(Kategorien kategorien) {
		this.kategorien = kategorien;
	}

	public List<Los> getLos() {
		return this.los;
	}

	public void setLos(List<Los> los) {
		this.los = los;
	}

	public Los addLo(Los lo) {
		getLos().add(lo);
		lo.setArtikel(this);

		return lo;
	}

	public Los removeLo(Los lo) {
		getLos().remove(lo);
		lo.setArtikel(null);

		return lo;
	}

}