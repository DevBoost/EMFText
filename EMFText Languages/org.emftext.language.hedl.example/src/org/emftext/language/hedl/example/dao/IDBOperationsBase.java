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


// this class is generated. any change will be overridden.
public interface IDBOperationsBase {
	
	/**
	 * Creates a new Producer using all read-only properties.
	 */
	public Producer createProducer();
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(int id);
		
	/**
	 * Returns all entities of type Producer.
	 */
	public List<Producer> getAllProducers();
		
	/**
	 * Searches for entities of type Producer.
	 */
	public List<Producer> searchProducers(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(Producer entity);
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers();
	
	/**
	 * Creates a new PriceSet using all read-only properties.
	 */
	public PriceSet createPriceSet();
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(int id);
		
	/**
	 * Returns all entities of type PriceSet.
	 */
	public List<PriceSet> getAllPriceSets();
		
	/**
	 * Searches for entities of type PriceSet.
	 */
	public List<PriceSet> searchPriceSets(String _searchString, int _maxResults);
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(PriceSet entity);
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets();
	
	/**
	 * Creates a new Item using all read-only properties.
	 */
	public Item createItem(PriceSet priceSet);
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(int id);
		
	/**
	 * Returns the Items with the given priceSet.
	 */
	public List<Item> getItemsByPriceSet(PriceSet priceSet);
	
	/**
	 * Returns the Items with the given producer.
	 */
	public List<Item> getItemsByProducer(Producer producer);
	
	/**
	 * Returns all entities of type Item.
	 */
	public List<Item> getAllItems();
		
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItems(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithPriceSet(final PriceSet priceSet, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithProducer(final Producer producer, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Item.
	 */
	public void delete(Item entity);
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems();
	
	/**
	 * Creates a new SupplierItem using all read-only properties.
	 */
	public SupplierItem createSupplierItem(java.lang.String supplierItemNumber, Supplier supplier);
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(int id);
		
	/**
	 * Returns the SupplierItems with the given supplier.
	 */
	public List<SupplierItem> getSupplierItemsBySupplier(Supplier supplier);
	
	/**
	 * Returns the SupplierItems with the given item.
	 */
	public List<SupplierItem> getSupplierItemsByItem(Item item);
	
	/**
	 * Returns all entities of type SupplierItem.
	 */
	public List<SupplierItem> getAllSupplierItems();
		
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItems(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithSupplier(final Supplier supplier, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithItem(final Item item, String _searchString, int _maxResults);
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(SupplierItem entity);
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems();
	
	/**
	 * Creates a new Supplier using all read-only properties.
	 */
	public Supplier createSupplier(java.lang.String name);
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(int id);
		
	/**
	 * Returns the Suppliers with the given warehouse.
	 */
	public List<Supplier> getSuppliersByWarehouse(Warehouse warehouse);
	
	/**
	 * Returns all entities of type Supplier.
	 */
	public List<Supplier> getAllSuppliers();
		
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSuppliers(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSupplierWithWarehouse(final Warehouse warehouse, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(Supplier entity);
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers();
	
	/**
	 * Creates a new Warehouse using all read-only properties.
	 */
	public Warehouse createWarehouse(java.lang.String name);
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(int id);
		
	/**
	 * Returns all entities of type Warehouse.
	 */
	public List<Warehouse> getAllWarehouses();
		
	/**
	 * Searches for entities of type Warehouse.
	 */
	public List<Warehouse> searchWarehouses(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(Warehouse entity);
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses();
	
	/**
	 * Creates a new CustomerOrder using all read-only properties.
	 */
	public CustomerOrder createCustomerOrder();
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(int id);
		
	/**
	 * Returns the CustomerOrders with the given customer.
	 */
	public List<CustomerOrder> getCustomerOrdersByCustomer(Customer customer);
	
	/**
	 * Returns all entities of type CustomerOrder.
	 */
	public List<CustomerOrder> getAllCustomerOrders();
		
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrders(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrderWithCustomer(final Customer customer, String _searchString, int _maxResults);
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(CustomerOrder entity);
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders();
	
	/**
	 * Creates a new OrderedItem using all read-only properties.
	 */
	public OrderedItem createOrderedItem();
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(int id);
		
	/**
	 * Returns the OrderedItems with the given item.
	 */
	public List<OrderedItem> getOrderedItemsByItem(Item item);
	
	/**
	 * Returns all entities of type OrderedItem.
	 */
	public List<OrderedItem> getAllOrderedItems();
		
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItems(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItemWithItem(final Item item, String _searchString, int _maxResults);
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(OrderedItem entity);
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems();
	
	/**
	 * Creates a new Customer using all read-only properties.
	 */
	public Customer createCustomer();
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(int id);
		
	/**
	 * Returns all entities of type Customer.
	 */
	public List<Customer> getAllCustomers();
		
	/**
	 * Searches for entities of type Customer.
	 */
	public List<Customer> searchCustomers(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(Customer entity);
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers();
	
}
