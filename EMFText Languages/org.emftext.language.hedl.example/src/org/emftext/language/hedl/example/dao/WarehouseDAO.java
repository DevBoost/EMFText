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

import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Warehouse.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class WarehouseDAO {
	
	public final static String FIELD__ID = getField(Warehouse.class, "id");
	public final static String FIELD__NAME = getField(Warehouse.class, "name");
	
	/**
	 * Creates a Warehouse using all read-only properties.
	 */
	public Warehouse create(Session session, java.lang.String name) {
		Warehouse newEntity = new Warehouse(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse get(Session session, int id) {
		Warehouse entity = (Warehouse) session.get(Warehouse.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Warehouse.
	 */
	public List<Warehouse> getAll(Session session) {
		Criteria criteria = session.createCriteria(Warehouse.class);
		@SuppressWarnings("unchecked")
		List<Warehouse> entities = (List<Warehouse>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Warehouse.
	 */
	public List<Warehouse> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Warehouse.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Warehouse> entities = (List<Warehouse>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Session session, Warehouse entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Warehouse").uniqueResult()).intValue();
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
