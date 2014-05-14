package ch.chinit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorien database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorien.findAll", query="SELECT k FROM Kategorien k")
public class Kategorien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="kateg_id")
	private Integer kategId;

	private String icon;

	@Column(name="kat_name")
	private String katName;

	//bi-directional many-to-one association to Artikel
	@OneToMany(mappedBy="kategorien")
	private List<Artikel> artikels;

	public Kategorien() {
	}

	public Integer getKategId() {
		return this.kategId;
	}

	public void setKategId(Integer kategId) {
		this.kategId = kategId;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getKatName() {
		return this.katName;
	}

	public void setKatName(String katName) {
		this.katName = katName;
	}

	public List<Artikel> getArtikels() {
		return this.artikels;
	}

	public void setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
	}

	public Artikel addArtikel(Artikel artikel) {
		getArtikels().add(artikel);
		artikel.setKategorien(this);

		return artikel;
	}

	public Artikel removeArtikel(Artikel artikel) {
		getArtikels().remove(artikel);
		artikel.setKategorien(null);

		return artikel;
	}

}