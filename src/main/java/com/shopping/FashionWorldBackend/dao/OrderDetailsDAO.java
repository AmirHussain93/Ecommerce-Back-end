package com.shopping.FashionWorldBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.OrderDetails;

@Repository("orderDetailsDAO")
public class OrderDetailsDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDetailsDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetails(OrderDetails orderDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderDetails);
		session.flush();
	}
	
	public OrderDetails getOrderDetails(int orderid)
	{
		Session session=sessionFactory.openSession();
		OrderDetails orderDetails=(OrderDetails)session.get(OrderDetails.class,orderid);
		System.out.println(orderDetails.getUsername());
		session.close();
		return orderDetails;
	}
	
	public List<OrderDetails> getOrderDetailsDetail()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from OrderDetails");
		List<OrderDetails> list=query.list();
		session.close();
		return list;
		
	}

}
