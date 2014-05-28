package ajaxServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.chinit.controller.EntityManagerBean;
import ch.chinit.controller.EntityManagerFactoryBean;
import ch.chinit.model.Artikel;
import ch.chinit.model.Los;

public class BuyLosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(getClass().getName());

	private EntityManagerFactoryBean entityManagerFactoryBean;
	private EntityManagerBean entityManagerBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		initializeEntityManager();

		String losID = req.getParameter("losID");
		String resp = updateLos(losID);

		response.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();

		response.getWriter().write(mapper.writeValueAsString(resp));
	}

	private void initializeEntityManager() {
		entityManagerFactoryBean = (EntityManagerFactoryBean) getServletContext()
				.getAttribute("entityManagerFactoryBean");

		// if it is null, instantiate it. It will then be used by JSF
		if (entityManagerFactoryBean == null) {
			logger.log(Level.WARNING,
					"Creating a new entityManagerFactoryBean in Ajax Servlet!");
			entityManagerFactoryBean = new EntityManagerFactoryBean();
			getServletContext().setAttribute("entityManagerFactoryBean",
					entityManagerFactoryBean);
		}
		entityManagerBean = new EntityManagerBean();
		entityManagerBean.setEntityManagerFactoryBean(entityManagerFactoryBean);
		entityManagerBean.setEntityManager(entityManagerFactoryBean
				.createEntityManager());

	}

	protected String updateLos(String losID) {
		String resp;
		boolean kackwurst = false;
		int id = Integer.parseInt(losID);
		
		
		Los los = new Los();
		los = entityManagerBean.getEntityManager().find(Los.class, id);
		
		System.out.println("Isch des verkauft=" +los.getVerkauft());
		System.out.println("ID=" +los.getId());
		System.out.println("Nummer=" +los.getLosnr());

		kackwurst = los.getVerkauft();
		
		System.out.println("Wurst=" +kackwurst);
		
		if (kackwurst==false)
		{
			System.out.println("SQL GO");
			
			los.setVerkauft(true);
			
			System.out.println("Isch des verkauft2 =" +los.getVerkauft());
			
			entityManagerBean.getEntityManager().getTransaction().begin();
			entityManagerBean.getEntityManager().persist(los);
			entityManagerBean.getEntityManager().getTransaction().commit();
			
			resp = "ok";
			
		}
		else {
			resp =  "not";
		}

		return resp;
		
	}
	

}
