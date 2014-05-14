package ch.chinit.controller;

import javax.faces.bean.ManagedProperty;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;

public abstract class AbstractConverter implements Converter {

	@ManagedProperty(value = "#{entityManagerBean}")
	private EntityManagerBean entityManagerBean;

	public AbstractConverter() {
		super();
	}

	public EntityManagerBean getEntityManagerBean() {
		return entityManagerBean;
	}

	public void setEntityManagerBean(EntityManagerBean entityManagerBean) {
		this.entityManagerBean = entityManagerBean;
	}

	public void setEntityManager(EntityManagerBean entityManagerBean) {
		this.entityManagerBean = entityManagerBean;
	}
	
	public EntityManager getEntityManager() {
		return entityManagerBean.getEntityManager();
	}
}