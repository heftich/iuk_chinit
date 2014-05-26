package ch.chinit.controller.kaufen;

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
	private Nutzer nutzer;

		
	public String kaufenAction(Artikel artikel) 
	{
		nutzer = new Nutzer();
		nutzer.setUserId(2);
		los = new Los();
		los.setGewonnen(false);
		los.setLosnr(1);
		los.setZeitstempel(null);
		los.setArtikel(artikel);
		los.setNutzer(nutzer);
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(los);
		getEntityManager().getTransaction().commit();
		
		artikel.setStatus(1);
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(artikel);
		getEntityManager().getTransaction().commit();
		//System.out.println(artikel.getStatus());
		return "kaufen";
	}
	
}
