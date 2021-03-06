package ch.chinit.controller.nutzer;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Nutzer;


@ManagedBean(name = "nutzerLoginController")
@ViewScoped
public class NutzerLoginController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Nutzer nutzer;
	protected Collection<Nutzer> nutzerlist;
	
	
	
	@PostConstruct
	protected void postConstruct() 
	{
		nutzer = new Nutzer();
		nutzer.setUsername("<enter username>");
		nutzer.setPassword("<enter passwort>");
		
	}
	
	public String loginNutzer() 
	{
		String status = "not ok";
		
		getEntityManager().getTransaction().begin();
		TypedQuery<Nutzer> query = getEntityManager().createQuery(
				"SELECT n FROM Nutzer n", Nutzer.class);
		nutzerlist = query.getResultList();
		
		logger.info("size of nutzerlist:  "+nutzerlist.size());
		
		getEntityManager().getTransaction().commit();
		
		for ( Nutzer n : nutzerlist)
		{
			if(n.getUsername().equals(nutzer.getUsername())&& n.getPassword().equals(nutzer.getPassword())) 
			{
			status = "ok";
			System.out.println(status);
			
			}
			
		}
		
		return "admin/";
	}
	
	public Nutzer getNutzer() 
	{
		return nutzer;
	}
	
	public void setNutzer(Nutzer nutzer) 
	{
		this.nutzer = nutzer;
	}
}
