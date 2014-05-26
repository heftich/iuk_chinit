package ch.chinit.controller.kaufen;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Artikel;

@ManagedBean(name = "kaufenController")
@ViewScoped
public class KaufenController extends AbstractController {
	
	public String kaufenAction(Artikel artikel) {
		artikel.setStatus(1);
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(artikel);
		getEntityManager().getTransaction().commit();
		//System.out.println(artikel.getStatus());
		return "kaufen";
	}
	
}
