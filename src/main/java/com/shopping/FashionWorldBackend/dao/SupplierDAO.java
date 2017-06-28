package com.shopping.FashionWorldBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	
	public Supplier getSupplier(int suppid)
	{
		Session session=sessionFactory.openSession();
		Supplier category=(Supplier)session.get(Supplier.class,suppid);
		session.close();
		return category;
	}
	
	@Transactional
	public void deleteCategory(Supplier supplier)
	{
		sessionFactory.getCurrentSession().delete(supplier);
	}
	
	public List<Supplier> getSupplierDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list=query.list();
		session.close();
		return list;
	}

}
