package ch.chinit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the los database table.
 * 
 */
@Entity
@Table(name="los")
@NamedQuery(name="Los.findAll", query="SELECT l FROM Los l")
public class Los implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean gewonnen;

	private Integer losnr;

	private Timestamp zeitstempel;

	//bi-directional many-to-one association to Artikel
	@ManyToOne
	@JoinColumn(name="artikel_id")
	private Artikel artikel;

	//bi-directional many-to-one association to Nutzer
	@ManyToOne
	@JoinColumn(name="user_id")
	private Nutzer nutzer;

	public Los() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getGewonnen() {
		return this.gewonnen;
	}

	public void setGewonnen(Boolean gewonnen) {
		this.gewonnen = gewonnen;
	}

	public Integer getLosnr() {
		return this.losnr;
	}

	public void setLosnr(Integer losnr) {
		this.losnr = losnr;
	}

	public Timestamp getZeitstempel() {
		return this.zeitstempel;
	}

	public void setZeitstempel(Timestamp zeitstempel) {
		this.zeitstempel = zeitstempel;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public Nutzer getNutzer() {
		return this.nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

}