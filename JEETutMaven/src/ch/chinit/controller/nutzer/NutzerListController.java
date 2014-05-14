package ch.chinit.controller.nutzer;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Nutzer;

@ManagedBean(name = "nutzerListController")
@ViewScoped
public class NutzerListController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Collection<Nutzer> nutzerlist;
	
	public Collection<Nutzer> getNutzerlist() {
		return nutzerlist;
	}
	@PostConstruct
	protected void postConstruct() {
		getEntityManager().getTransaction().begin();
		TypedQuery<Nutzer> query = getEntityManager().createQuery(
				"SELECT n FROM Nutzer n", Nutzer.class);
		nutzerlist = query.getResultList();
		
		logger.info("size of nutzerlist:  "+nutzerlist.size());
		
		getEntityManager().getTransaction().commit();
	}
	
	public String createAction() {
		return "create";
	}
	
	public String deleteAction(int id) {
		getEntityManager().getTransaction().begin();
		Nutzer nutzer = getEntityManager().find(Nutzer.class, id);
		getEntityManager().remove(nutzer);
		getEntityManager().getTransaction().commit();
		nutzerlist.remove(nutzer);
		return "list";
	}
	

}
