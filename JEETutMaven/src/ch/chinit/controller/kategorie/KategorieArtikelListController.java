package ch.chinit.controller.kategorie;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Artikel;

@ManagedBean(name = "kategorieArtikelListController")
@ViewScoped
public class KategorieArtikelListController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Collection<Artikel> artikellistapps;
	private Collection<Artikel> artikellistbooks;
	private Collection<Artikel> artikellistgames;
	private Collection<Artikel> artikellistmovies;
	private Collection<Artikel> artikellistnewspaper;
	
	public Collection<Artikel> getartikellistgames() {
		return artikellistgames;
	}
	public Collection<Artikel> getartikellistbooks() {
		return artikellistbooks;
	}
	public Collection<Artikel> getArtikellistapps() {
		return artikellistapps;
	}
	public Collection<Artikel> getartikellistmovies() {
		return artikellistmovies;
	}
	public Collection<Artikel> getartikellistnewspaper() {
		return artikellistnewspaper;
	}

	@PostConstruct
	protected void postConstruct() {
		getEntityManager().getTransaction().begin();
		TypedQuery<Artikel> queryGames = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE kategorie=1 AND status=0", Artikel.class);
		TypedQuery<Artikel> queryBooks = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE kategorie=2 AND status=0", Artikel.class);
		TypedQuery<Artikel> queryApps = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE kategorie=3 AND status=0", Artikel.class);
		TypedQuery<Artikel> queryMovies = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE kategorie=4 AND status=0", Artikel.class);
		TypedQuery<Artikel> queryNewspaper = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE kategorie=5 AND status=0", Artikel.class);

		artikellistgames = queryGames.getResultList();
		artikellistbooks = queryBooks.getResultList();
		artikellistapps = queryApps.getResultList();
		artikellistmovies = queryMovies.getResultList();
		artikellistnewspaper = queryNewspaper.getResultList();
		
//		logger.info("size of artikellistgames:  "+artikellistgames.size());
		getEntityManager().getTransaction().commit();
	}
	
//	public String createAction() {
//		return "create";
//	}
//
//	public String deleteAction(int id) {
//		getEntityManager().getTransaction().begin();
//		Artikel artikel = getEntityManager().find(Artikel.class, id);
//		getEntityManager().remove(artikel);
//		getEntityManager().getTransaction().commit();
//		artikellist.remove(artikel);
//		return "list";
//	}
	

}
