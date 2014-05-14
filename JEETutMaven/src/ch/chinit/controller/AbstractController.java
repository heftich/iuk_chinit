package ch.chinit.controller;

import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

public abstract class AbstractController {

	@ManagedProperty(value = "#{entityManagerBean}")
	private EntityManagerBean entityManagerBean;

	public AbstractController() {
		super();
	}

	public EntityManagerBean getEntityManagerBean() {
		return entityManagerBean;
	}

	public void setEntityManagerBean(EntityManagerBean entityManagerBean) {
		this.entityManagerBean = entityManagerBean;
	}
	
	public EntityManager getEntityManager() {
		return entityManagerBean.getEntityManager();
	}

}