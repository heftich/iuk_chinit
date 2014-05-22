package ch.chinit.controller.start;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Artikel;

@ManagedBean(name = "startController")
@ViewScoped
public class StartController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Collection<Artikel> artikelliststart;
	
	public Collection<Artikel> getartikelliststart() {
		return artikelliststart;
	}


	@PostConstruct
	protected void postConstruct() {
		getEntityManager().getTransaction().begin();
		TypedQuery<Artikel> queryStart = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE status=1", Artikel.class);

		artikelliststart = queryStart.getResultList();
		
//		logger.info("size of artikellistgames:  "+artikellistgames.size());
//		getEntityManager().getTransaction().commit();
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
