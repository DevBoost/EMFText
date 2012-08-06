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
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Customer.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class CustomerDAO {
	
	public final static String FIELD__ID = getField(Customer.class, "id");
	public final static String FIELD__FIRSTNAME = getField(Customer.class, "firstName");
	public final static String FIELD__LASTNAME = getField(Customer.class, "lastName");
	
	/**
	 * Creates a Customer using all read-only properties.
	 */
	public Customer create(Session session) {
		Customer newEntity = new Customer();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer get(Session session, int id) {
		Customer entity = (Customer) session.get(Customer.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Customer.
	 */
	public List<Customer> getAll(Session session) {
		Criteria criteria = session.createCriteria(Customer.class);
		@SuppressWarnings("unchecked")
		List<Customer> entities = (List<Customer>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Customer.
	 */
	public List<Customer> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Customer.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__FIRSTNAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__LASTNAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Customer> entities = (List<Customer>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Session session, Customer entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Customer").uniqueResult()).intValue();
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
