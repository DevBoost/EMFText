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

import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.emftext.language.hedl.example.entities.Producer;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Item.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ItemDAO {
	
	public final static String FIELD__ID = getField(Item.class, "id");
	public final static String FIELD__NAME = getField(Item.class, "name");
	public final static String FIELD__PRICESET = getField(Item.class, "priceSet");
	public final static String FIELD__PRODUCER = getField(Item.class, "producer");
	
	/**
	 * Creates a Item using all read-only properties.
	 */
	public Item create(Session session, PriceSet priceSet) {
		Item newEntity = new Item(priceSet);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item get(Session session, int id) {
		Item entity = (Item) session.get(Item.class, id);
		return entity;
	}
	
	/**
	 * Returns the Items with the given priceSet.
	 */
	public List<Item> getByPriceSet(Session session, PriceSet priceSet) {
		Criteria criteria = session.createCriteria(Item.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PRICESET, priceSet));
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the Items with the given producer.
	 */
	public List<Item> getByProducer(Session session, Producer producer) {
		Criteria criteria = session.createCriteria(Item.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCER, producer));
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Item.
	 */
	public List<Item> getAll(Session session) {
		Criteria criteria = session.createCriteria(Item.class);
		@SuppressWarnings("unchecked")
		List<Item> entities = (List<Item>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Item.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Item> entities = (List<Item>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchWithPriceSet(Session _session, PriceSet priceSet, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Item.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PRICESET, priceSet));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Item> entities = (List<Item>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchWithProducer(Session _session, Producer producer, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Item.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCER, producer));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Item> entities = (List<Item>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Session session, Item entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Item").uniqueResult()).intValue();
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
