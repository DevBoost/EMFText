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
import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.OrderedItem;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.emftext.language.hedl.example.entities.Producer;
import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.classic.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

/**
 * This class provides all default operations that are derived from the HEDL entity model.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
		
	private Session session;
	
	private ProducerDAO producerDAO = new ProducerDAO();
	private PriceSetDAO priceSetDAO = new PriceSetDAO();
	private ItemDAO itemDAO = new ItemDAO();
	private SupplierItemDAO supplierItemDAO = new SupplierItemDAO();
	private SupplierDAO supplierDAO = new SupplierDAO();
	private WarehouseDAO warehouseDAO = new WarehouseDAO();
	private CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
	private OrderedItemDAO orderedItemDAO = new OrderedItemDAO();
	private CustomerDAO customerDAO = new CustomerDAO();

	public OperationProviderBase(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	/** 
	 * Create an instance of type Producer using all read-only properties.
	 */
	public Producer createProducer() {
		return producerDAO.create(session);
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(int id) {
		Producer entity = producerDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Producer.
	 */
	public List<Producer> getAllProducers() {
		final List<Producer> entities = producerDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Producer.
	 */
	public List<Producer> searchProducers(String _searchString, int _maxResults) {
		return producerDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Producer entity) {
		producerDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers() {
		return producerDAO.count(session);
	}
	
	/** 
	 * Create an instance of type PriceSet using all read-only properties.
	 */
	public PriceSet createPriceSet() {
		return priceSetDAO.create(session);
	}
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(int id) {
		PriceSet entity = priceSetDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type PriceSet.
	 */
	public List<PriceSet> getAllPriceSets() {
		final List<PriceSet> entities = priceSetDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type PriceSet.
	 */
	public List<PriceSet> searchPriceSets(String _searchString, int _maxResults) {
		return priceSetDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(PriceSet entity) {
		priceSetDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets() {
		return priceSetDAO.count(session);
	}
	
	/** 
	 * Create an instance of type Item using all read-only properties.
	 */
	public Item createItem(PriceSet priceSet) {
		return itemDAO.create(session, priceSet);
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(int id) {
		Item entity = itemDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Items with the given priceSet. */
	public List<Item> getItemsByPriceSet(PriceSet priceSet) {
		List<Item> entities = itemDAO.getByPriceSet(session, priceSet);
		return entities;
	}
		
	/** Returns the Items with the given producer. */
	public List<Item> getItemsByProducer(Producer producer) {
		List<Item> entities = itemDAO.getByProducer(session, producer);
		return entities;
	}
		
	/**
	 * Returns all entities of type Item.
	 */
	public List<Item> getAllItems() {
		final List<Item> entities = itemDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItems(String _searchString, int _maxResults) {
		return itemDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithPriceSet(PriceSet priceSet, String _searchString, int _maxResults) {
		return itemDAO.searchWithPriceSet(session, priceSet, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithProducer(Producer producer, String _searchString, int _maxResults) {
		return itemDAO.searchWithProducer(session, producer, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Item entity) {
		itemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems() {
		return itemDAO.count(session);
	}
	
	/** 
	 * Create an instance of type SupplierItem using all read-only properties.
	 */
	public SupplierItem createSupplierItem(java.lang.String supplierItemNumber, Supplier supplier) {
		return supplierItemDAO.create(session, supplierItemNumber, supplier);
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(int id) {
		SupplierItem entity = supplierItemDAO.get(session, id);
		return entity;
	}
	
	/** Returns the SupplierItems with the given supplier. */
	public List<SupplierItem> getSupplierItemsBySupplier(Supplier supplier) {
		List<SupplierItem> entities = supplierItemDAO.getBySupplier(session, supplier);
		return entities;
	}
		
	/** Returns the SupplierItems with the given item. */
	public List<SupplierItem> getSupplierItemsByItem(Item item) {
		List<SupplierItem> entities = supplierItemDAO.getByItem(session, item);
		return entities;
	}
		
	/**
	 * Returns all entities of type SupplierItem.
	 */
	public List<SupplierItem> getAllSupplierItems() {
		final List<SupplierItem> entities = supplierItemDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItems(String _searchString, int _maxResults) {
		return supplierItemDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithSupplier(Supplier supplier, String _searchString, int _maxResults) {
		return supplierItemDAO.searchWithSupplier(session, supplier, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithItem(Item item, String _searchString, int _maxResults) {
		return supplierItemDAO.searchWithItem(session, item, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(SupplierItem entity) {
		supplierItemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems() {
		return supplierItemDAO.count(session);
	}
	
	/** 
	 * Create an instance of type Supplier using all read-only properties.
	 */
	public Supplier createSupplier(java.lang.String name) {
		return supplierDAO.create(session, name);
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(int id) {
		Supplier entity = supplierDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Suppliers with the given warehouse. */
	public List<Supplier> getSuppliersByWarehouse(Warehouse warehouse) {
		List<Supplier> entities = supplierDAO.getByWarehouse(session, warehouse);
		return entities;
	}
		
	/**
	 * Returns all entities of type Supplier.
	 */
	public List<Supplier> getAllSuppliers() {
		final List<Supplier> entities = supplierDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSuppliers(String _searchString, int _maxResults) {
		return supplierDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSupplierWithWarehouse(Warehouse warehouse, String _searchString, int _maxResults) {
		return supplierDAO.searchWithWarehouse(session, warehouse, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Supplier entity) {
		supplierDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers() {
		return supplierDAO.count(session);
	}
	
	/** 
	 * Create an instance of type Warehouse using all read-only properties.
	 */
	public Warehouse createWarehouse(java.lang.String name) {
		return warehouseDAO.create(session, name);
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(int id) {
		Warehouse entity = warehouseDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Warehouse.
	 */
	public List<Warehouse> getAllWarehouses() {
		final List<Warehouse> entities = warehouseDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Warehouse.
	 */
	public List<Warehouse> searchWarehouses(String _searchString, int _maxResults) {
		return warehouseDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Warehouse entity) {
		warehouseDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses() {
		return warehouseDAO.count(session);
	}
	
	/** 
	 * Create an instance of type CustomerOrder using all read-only properties.
	 */
	public CustomerOrder createCustomerOrder() {
		return customerOrderDAO.create(session);
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(int id) {
		CustomerOrder entity = customerOrderDAO.get(session, id);
		return entity;
	}
	
	/** Returns the CustomerOrders with the given customer. */
	public List<CustomerOrder> getCustomerOrdersByCustomer(Customer customer) {
		List<CustomerOrder> entities = customerOrderDAO.getByCustomer(session, customer);
		return entities;
	}
		
	/**
	 * Returns all entities of type CustomerOrder.
	 */
	public List<CustomerOrder> getAllCustomerOrders() {
		final List<CustomerOrder> entities = customerOrderDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrders(String _searchString, int _maxResults) {
		return customerOrderDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrderWithCustomer(Customer customer, String _searchString, int _maxResults) {
		return customerOrderDAO.searchWithCustomer(session, customer, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(CustomerOrder entity) {
		customerOrderDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders() {
		return customerOrderDAO.count(session);
	}
	
	/** 
	 * Create an instance of type OrderedItem using all read-only properties.
	 */
	public OrderedItem createOrderedItem() {
		return orderedItemDAO.create(session);
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(int id) {
		OrderedItem entity = orderedItemDAO.get(session, id);
		return entity;
	}
	
	/** Returns the OrderedItems with the given item. */
	public List<OrderedItem> getOrderedItemsByItem(Item item) {
		List<OrderedItem> entities = orderedItemDAO.getByItem(session, item);
		return entities;
	}
		
	/**
	 * Returns all entities of type OrderedItem.
	 */
	public List<OrderedItem> getAllOrderedItems() {
		final List<OrderedItem> entities = orderedItemDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItems(String _searchString, int _maxResults) {
		return orderedItemDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItemWithItem(Item item, String _searchString, int _maxResults) {
		return orderedItemDAO.searchWithItem(session, item, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(OrderedItem entity) {
		orderedItemDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems() {
		return orderedItemDAO.count(session);
	}
	
	/** 
	 * Create an instance of type Customer using all read-only properties.
	 */
	public Customer createCustomer() {
		return customerDAO.create(session);
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(int id) {
		Customer entity = customerDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Customer.
	 */
	public List<Customer> getAllCustomers() {
		final List<Customer> entities = customerDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Customer.
	 */
	public List<Customer> searchCustomers(String _searchString, int _maxResults) {
		return customerDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Customer entity) {
		customerDAO.delete(session, entity);
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers() {
		return customerDAO.count(session);
	}
	
	/**
	 * Returns the name of the table that contains entities of the given type.
	 */
	public String getTableName(Class<?> clazz) {
		ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);
		if (hibernateMetadata == null) {
		    return null;
		}
		if (hibernateMetadata instanceof AbstractEntityPersister) {
		     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
		     return persister.getTableName();
		}
		return null;
	}
}
