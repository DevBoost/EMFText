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
import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type SupplierItem.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class SupplierItemDAO {
	
	public final static String FIELD__ID = getField(SupplierItem.class, "id");
	public final static String FIELD__SUPPLIERITEMNUMBER = getField(SupplierItem.class, "supplierItemNumber");
	public final static String FIELD__SUPPLIER = getField(SupplierItem.class, "supplier");
	public final static String FIELD__ITEM = getField(SupplierItem.class, "item");
	public final static String FIELD__SUPPLIERPRICE = getField(SupplierItem.class, "supplierPrice");
	public final static String FIELD__LASTUPDATE = getField(SupplierItem.class, "lastUpdate");
	
	/**
	 * Creates a SupplierItem using all read-only properties.
	 */
	public SupplierItem create(Session session, java.lang.String supplierItemNumber, Supplier supplier) {
		SupplierItem newEntity = new SupplierItem(supplierItemNumber, supplier);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem get(Session session, int id) {
		SupplierItem entity = (SupplierItem) session.get(SupplierItem.class, id);
		return entity;
	}
	
	/**
	 * Returns the SupplierItems with the given supplier.
	 */
	public List<SupplierItem> getBySupplier(Session session, Supplier supplier) {
		Criteria criteria = session.createCriteria(SupplierItem.class);
		criteria = criteria.add(Restrictions.eq(FIELD__SUPPLIER, supplier));
		@SuppressWarnings("unchecked")
		List<SupplierItem> list = (List<SupplierItem>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the SupplierItems with the given item.
	 */
	public List<SupplierItem> getByItem(Session session, Item item) {
		Criteria criteria = session.createCriteria(SupplierItem.class);
		criteria = criteria.add(Restrictions.eq(FIELD__ITEM, item));
		@SuppressWarnings("unchecked")
		List<SupplierItem> list = (List<SupplierItem>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type SupplierItem.
	 */
	public List<SupplierItem> getAll(Session session) {
		Criteria criteria = session.createCriteria(SupplierItem.class);
		@SuppressWarnings("unchecked")
		List<SupplierItem> entities = (List<SupplierItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(SupplierItem.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__SUPPLIERITEMNUMBER, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<SupplierItem> entities = (List<SupplierItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchWithSupplier(Session _session, Supplier supplier, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(SupplierItem.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__SUPPLIER, supplier));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__SUPPLIERITEMNUMBER, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<SupplierItem> entities = (List<SupplierItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchWithItem(Session _session, Item item, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(SupplierItem.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__ITEM, item));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__SUPPLIERITEMNUMBER, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<SupplierItem> entities = (List<SupplierItem>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(Session session, SupplierItem entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from SupplierItem").uniqueResult()).intValue();
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
