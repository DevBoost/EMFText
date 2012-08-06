/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.hedl.example.dao;

import java.util.List;

import org.emftext.language.hedl.example.entities.Customer;
import org.emftext.language.hedl.example.entities.CustomerOrder;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type CustomerOrder.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class CustomerOrderDAO {
	
	public final static String FIELD__ID = getField(CustomerOrder.class, "id");
	public final static String FIELD__ITEMS = getField(CustomerOrder.class, "items");
	public final static String FIELD__CUSTOMER = getField(CustomerOrder.class, "customer");
	
	/**
	 * Creates a CustomerOrder using all read-only properties.
	 */
	public CustomerOrder create(Session session) {
		CustomerOrder newEntity = new CustomerOrder();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder get(Session session, int id) {
		CustomerOrder entity = (CustomerOrder) session.get(CustomerOrder.class, id);
		return entity;
	}
	
	/**
	 * Returns the CustomerOrders with the given customer.
	 */
	public List<CustomerOrder> getByCustomer(Session session, Customer customer) {
		Criteria criteria = session.createCriteria(CustomerOrder.class);
		criteria = criteria.add(Restrictions.eq(FIELD__CUSTOMER, customer));
		@SuppressWarnings("unchecked")
		List<CustomerOrder> list = (List<CustomerOrder>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type CustomerOrder.
	 */
	public List<CustomerOrder> getAll(Session session) {
		Criteria criteria = session.createCriteria(CustomerOrder.class);
		@SuppressWarnings("unchecked")
		List<CustomerOrder> entities = (List<CustomerOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(CustomerOrder.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<CustomerOrder> entities = (List<CustomerOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchWithCustomer(Session _session, Customer customer, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(CustomerOrder.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__CUSTOMER, customer));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<CustomerOrder> entities = (List<CustomerOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(Session session, CustomerOrder entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from CustomerOrder").uniqueResult()).intValue();
	}
		
	private static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}
