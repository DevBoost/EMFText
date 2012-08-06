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

import org.emftext.language.hedl.example.entities.Producer;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Producer.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ProducerDAO {
	
	public final static String FIELD__ID = getField(Producer.class, "id");
	public final static String FIELD__NAME = getField(Producer.class, "name");
	
	/**
	 * Creates a Producer using all read-only properties.
	 */
	public Producer create(Session session) {
		Producer newEntity = new Producer();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer get(Session session, int id) {
		Producer entity = (Producer) session.get(Producer.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Producer.
	 */
	public List<Producer> getAll(Session session) {
		Criteria criteria = session.createCriteria(Producer.class);
		@SuppressWarnings("unchecked")
		List<Producer> entities = (List<Producer>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Producer.
	 */
	public List<Producer> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Producer.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Producer> entities = (List<Producer>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Session session, Producer entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Producer").uniqueResult()).intValue();
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
