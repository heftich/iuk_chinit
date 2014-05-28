package ch.chinit.controller.kategorie;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;

import ch.chinit.controller.AbstractController;
import ch.chinit.model.Artikel;
import ch.chinit.model.Los;

@ManagedBean(name = "winnerArtikelListController")
@ViewScoped
public class WinnerArtikelListController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Collection<Artikel> winnerartikel;
	
	
	public Collection<Artikel> getwinnerartikel() {
		return winnerartikel;
	}
	


	@PostConstruct
	protected void postConstruct() {
		getEntityManager().getTransaction().begin();

		TypedQuery<Artikel> queryWinners = getEntityManager().createQuery(
				"SELECT a FROM Artikel a WHERE status=2", Artikel.class);	


		winnerartikel = queryWinners.getResultList();
		getEntityManager().getTransaction().commit();
		
	}
	
	public String getwinner() {
			String losnr = "none";
		for(Artikel a : winnerartikel) {
			List<Los> lose = a.getLos();
				for(Los l : lose) {
					if(l.getGewonnen()==true) {
						losnr = ""+l.getLosnr();
					}
					else {
					}
				}
		}
		return losnr;
	}

	

	

}
