package com.cg.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.service.client.ServiceForms;

public class ServiceFormsDAO 
{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vehicle");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void addService(ServiceForms sf)
	{
		et.begin();
		em.persist(sf);
		et.commit();
	}
	
	public ServiceForms findUserById(int UId){
		Query query = em.createQuery("Select sf from ServiceForms sf where sf.UId=?1");
		query.setParameter(1, UId);
		ServiceForms serviceform = (ServiceForms) query.getSingleResult();
		return serviceform;
	}
	
	public ServiceForms findUserByEmail(String email){
		Query query = em.createQuery("Select sf from ServiceForms sf where sf.emailid=?1");
		query.setParameter(1, email);
		ServiceForms serviceform = (ServiceForms) query.getSingleResult();
		return serviceform;
	}
	
	public ServiceForms findUserByPhone(String mobile){
		Query query = em.createQuery("Select sf from ServiceForms sf where sf.mobile=?1");
		query.setParameter(1, mobile);
		ServiceForms serviceform = (ServiceForms) query.getSingleResult();
		return serviceform;
	}
	
	public List<ServiceForms> fetchServices(String status)
	{
		Query query = em.createQuery("Select sf from ServiceForms sf where sf.status=?1");
		query.setParameter(1, status);
		List<ServiceForms> list = query.getResultList();
		return list;
	}
	
	public ServiceForms addAmount(int eID,float amount) 
	{
	    et.begin();		
		ServiceForms serviceform  = em.find(ServiceForms.class,eID);
		serviceform.setAmount(amount);
		em.merge(serviceform);
		et.commit();
		return serviceform;
	}
	
	public ServiceForms updateStatus(int eID,String status) 
	{
	    et.begin();	
		ServiceForms serviceform = em.find(ServiceForms.class,eID);
		serviceform.setStatus(status);
		em.merge(serviceform);
		et.commit();
		return serviceform ;
	}
	
	
	
}
