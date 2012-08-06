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

import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Supplier.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class SupplierDAO {
	
	public final static String FIELD__ID = getField(Supplier.class, "id");
	public final static String FIELD__NAME = getField(Supplier.class, "name");
	public final static String FIELD__WAREHOUSE = getField(Supplier.class, "warehouse");
	
	/**
	 * Creates a Supplier using all read-only properties.
	 */
	public Supplier create(Session session, java.lang.String name) {
		Supplier newEntity = new Supplier(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier get(Session session, int id) {
		Supplier entity = (Supplier) session.get(Supplier.class, id);
		return entity;
	}
	
	/**
	 * Returns the Suppliers with the given warehouse.
	 */
	public List<Supplier> getByWarehouse(Session session, Warehouse warehouse) {
		Criteria criteria = session.createCriteria(Supplier.class);
		criteria = criteria.add(Restrictions.eq(FIELD__WAREHOUSE, warehouse));
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Supplier.
	 */
	public List<Supplier> getAll(Session session) {
		Criteria criteria = session.createCriteria(Supplier.class);
		@SuppressWarnings("unchecked")
		List<Supplier> entities = (List<Supplier>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Supplier.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Supplier> entities = (List<Supplier>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchWithWarehouse(Session _session, Warehouse warehouse, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Supplier.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__WAREHOUSE, warehouse));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Supplier> entities = (List<Supplier>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Session session, Supplier entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Supplier").uniqueResult()).intValue();
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
