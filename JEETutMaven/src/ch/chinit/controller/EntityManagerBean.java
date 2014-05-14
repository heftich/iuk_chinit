package ch.chinit.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

@ManagedBean(name = "entityManagerBean")
@ViewScoped()
public class EntityManagerBean {

	@ManagedProperty(value = "#{entityManagerFactoryBean}")
	private EntityManagerFactoryBean entityManagerFactoryBean;

	public EntityManagerFactoryBean getEntityManagerFactoryBean() {
		return entityManagerFactoryBean;
	}

	public void setEntityManagerFactoryBean(
			EntityManagerFactoryBean entityManagerFactoryBean) {
		this.entityManagerFactoryBean = entityManagerFactoryBean;
	}

	private EntityManager entityManager;
	
	@PostConstruct
	protected void postConstruct() {
		entityManager = entityManagerFactoryBean.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public EntityManager createEntityManager() {
		return entityManagerFactoryBean.createEntityManager();
	}
	
    @PreDestroy
    public void preDestroy() {
    	entityManager.close();
    }
}
