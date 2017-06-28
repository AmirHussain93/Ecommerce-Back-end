package com.shopping.FashionWorldBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.UserDetail;

@Repository("userDetailDAO")
public class UserDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDetailDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateUserDetail(UserDetail supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	
	public UserDetail getUserDetail(String username)
	{
		Session session=sessionFactory.openSession();
		UserDetail category=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return category;
	}
	
	@Transactional
	public void deleteCategory(UserDetail supplier)
	{
		sessionFactory.getCurrentSession().delete(supplier);
	}
	
	public List<UserDetail> getUserDetailDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> list=query.list();
		session.close();
		return list;
	}


}
