package ch.chinit.controller;

import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name = "entityManagerFactoryBean")
@ApplicationScoped()
public class EntityManagerFactoryBean {
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManagerFactoryBean(){
		entityManagerFactory = Persistence.createEntityManagerFactory("heftich-persistence");
	}

	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
    @PreDestroy
    public void preDestroy() {
		entityManagerFactory.close();
    }
}
