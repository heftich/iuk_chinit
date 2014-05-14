package ch.chinit.controller.nutzer;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Nutzer;


@ManagedBean(name = "nutzerCreateController")
@ViewScoped
public class NutzerCreateController extends AbstractController {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Nutzer nutzer;
	protected Collection<Nutzer> nutzerlist;
	
	@PostConstruct
	protected void postConstruct() 
	{
		nutzer = new Nutzer();
		nutzer.setUsername("<enter username>");
		nutzer.setVorname("<enter vorname>");
		nutzer.setNachname("<enter nachname>");
		nutzer.setPasswort("<enter passwort>");
		nutzer.setEmail("<enter email>");
		nutzer.setStrasse("<enter street>");
		nutzer.setHausnummer("<enter hausnummer>");
		nutzer.setOrt("<enter ort>");
		nutzer.setPostleitzahl("<enter plz>");
		nutzer.setLand("<enter land>");
		
	}
	
	protected boolean isNewUsername(Nutzer nutzer) 
	{
		boolean state = true;
		getEntityManager().getTransaction().begin();
		TypedQuery<Nutzer> query = getEntityManager().createQuery(
				"SELECT n FROM Nutzer n", Nutzer.class);
		nutzerlist = query.getResultList();		
		
		for ( Nutzer n : nutzerlist)
		{
			if(n.getUsername().equals(nutzer.getUsername())) 
			{
			state = false;	
			}	
		}
		getEntityManager().getTransaction().commit();
		return state;
	}
	
	public Nutzer getNutzer() 
	{
		return nutzer;
	}
	
	public void setNutzer(Nutzer nutzer) 
	{
		this.nutzer = nutzer;
	}
	
	public String saveNutzer() 
	{
		if(isNewUsername(nutzer)) 
		{
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(nutzer);
		getEntityManager().getTransaction().commit();
		return "save";
		}
		
		else 
		{
		return "nonsave";
		}
		
	}
	
}