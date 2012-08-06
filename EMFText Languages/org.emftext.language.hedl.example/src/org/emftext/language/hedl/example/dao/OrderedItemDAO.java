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
import org.emftext.language.hedl.example.entities.OrderedItem;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type OrderedItem.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class OrderedItemDAO {
	
	public final static String FIELD__ID = getField(OrderedItem.class, "id");
	public final static String FIELD__ITEM = getField(OrderedItem.class, "item");
	
	/**
	 * Creates a OrderedItem using all read-only properties.
	 */
	public OrderedItem create(Session session) {
		OrderedItem newEntity = new OrderedItem();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem get(Session session, int id) {
		OrderedItem entity = (OrderedItem) session.get(OrderedItem.class, id);
		return entity;
	}
	
	/**
	 * Returns the OrderedItems with the given item.
	 */
	public List<OrderedItem> getByItem(Session session, Item item) {
		Criteria criteria = session.createCriteria(OrderedItem.class);
		criteria = criteria.add(Restrictions.eq(FIELD__ITEM, item));
		@SuppressWarnings("unchecked")
		List<OrderedItem> list = (List<OrderedItem>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type OrderedItem.
	 */
	public List<OrderedItem> getAll(Session session) {
		Criteria criteria = session.createCriteria(OrderedItem.class);
		@SuppressWarnings("unchecked")
		List<OrderedItem> entities = (List<OrderedItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(OrderedItem.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<OrderedItem> entities = (List<OrderedItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchWithItem(Session _session, Item item, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(OrderedItem.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__ITEM, item));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<OrderedItem> entities = (List<OrderedItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(Session session, OrderedItem entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from OrderedItem").uniqueResult()).intValue();
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
