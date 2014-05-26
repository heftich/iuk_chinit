package ch.chinit.controller.kaufen;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Artikel;
import ch.chinit.model.Los;
import ch.chinit.model.Nutzer;

@ManagedBean(name = "kaufenController")
@ViewScoped
public class KaufenController extends AbstractController {
	
	private Los los;
	
		
	public String kaufenAction(Artikel artikel) 
	{


		Collection<Los> lose = artikel.getLos();
		los = lose.iterator().next();
		los.setVerkauft(true);
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(los);
		getEntityManager().getTransaction().commit();
		
		artikel.setStatus(1);
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(artikel);
		getEntityManager().getTransaction().commit();
		return "kaufen";
	}
	
}
