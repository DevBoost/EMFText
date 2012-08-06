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

import java.util.ArrayList;
import java.util.List;

import org.emftext.language.hedl.example.custom.IDBOperations;
import org.emftext.language.hedl.example.custom.OperationProvider;
import org.emftext.language.hedl.example.entities.Customer;
import org.emftext.language.hedl.example.entities.CustomerOrder;
import org.emftext.language.hedl.example.entities.Item;
import org.emftext.language.hedl.example.entities.OrderedItem;
import org.emftext.language.hedl.example.entities.PriceSet;
import org.emftext.language.hedl.example.entities.Producer;
import org.emftext.language.hedl.example.entities.Supplier;
import org.emftext.language.hedl.example.entities.SupplierItem;
import org.emftext.language.hedl.example.entities.Warehouse;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;


// this class is generated. any change will be overridden.
public abstract class ERPDAOBase implements IDBOperationsBase {
	
	private SessionFactory sessionFactory;

	public ERPDAOBase() {
		configure();
	}

	private void configure() throws HibernateException {
		Configuration configuration = getConfiguration();
		//configuration.setProperty("hibernate.show_sql", "true");
		this.sessionFactory = configuration.buildSessionFactory();
	}

	private Configuration getConfiguration() {
		Configuration configuration = new Configuration();
		configuration = configuration.addAnnotatedClass(Producer.class);
		configuration = configuration.addAnnotatedClass(PriceSet.class);
		configuration = configuration.addAnnotatedClass(Item.class);
		configuration = configuration.addAnnotatedClass(SupplierItem.class);
		configuration = configuration.addAnnotatedClass(Supplier.class);
		configuration = configuration.addAnnotatedClass(Warehouse.class);
		configuration = configuration.addAnnotatedClass(CustomerOrder.class);
		configuration = configuration.addAnnotatedClass(OrderedItem.class);
		configuration = configuration.addAnnotatedClass(Customer.class);
		return configuration;
	}
	
	public void createSchema() throws HibernateException {
		SchemaExport schemaExport = new SchemaExport(getConfiguration());
		schemaExport.setFormat(true);
		schemaExport.create(false, false);
	}

	public void updateSchema() {
		SchemaUpdate update = new SchemaUpdate(getConfiguration());
		update.execute(true, true);
		List<?> exceptions = update.getExceptions();
		for (Object object : exceptions) {
			System.err.println("Exception while updating schema " + object);
		}
	}
	
	public void executeInTransaction(ICommand command) {
		executeInTransaction(command, true);
	}
	
	private void executeInTransaction(ICommand command, boolean retry) {
		boolean successful = false;
		boolean closed = false;
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			command.execute(new OperationProvider(session));
			tx.commit();
			successful = true;
		} catch (Exception e) {
			handleException(e, retry);
			if (tx != null) {
				try {
					tx.rollback();
				} catch (TransactionException te) {
					handleException(te, retry);
				}
			}
		} finally {
			try {
				session.close();
				closed = true;
			} catch (HibernateException he) {
				handleException(he, retry);
			}
		}
		
		if ((!successful || !closed) && retry) {
			// retry once
			executeInTransaction(command, false);
		}
	}
	
	public abstract void handleException(Exception e, boolean retry);
	
	public void tearDown() {
		sessionFactory.close();
	}

	/**
	 * Creates a new Producer using all read-only properties.
	 */
	public Producer createProducer() {
		final Producer[] entity = new Producer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProducer();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Producer with the given id.
	 */
	public Producer getProducer(final int id) {
		final Producer[] entity = new Producer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProducer(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Producer.
	 */
	public List<Producer> getAllProducers() {
		final List<Producer> entities = new ArrayList<Producer>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllProducers());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Producer.
	 */
	public List<Producer> searchProducers(final String _searchString, final int _maxResults) {
		final List<Producer> entities = new ArrayList<Producer>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProducers(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Producer.
	 */
	public void delete(final Producer entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Producer entities.
	 */
	public int countProducers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProducers();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new PriceSet using all read-only properties.
	 */
	public PriceSet createPriceSet() {
		final PriceSet[] entity = new PriceSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPriceSet();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PriceSet with the given id.
	 */
	public PriceSet getPriceSet(final int id) {
		final PriceSet[] entity = new PriceSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPriceSet(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type PriceSet.
	 */
	public List<PriceSet> getAllPriceSets() {
		final List<PriceSet> entities = new ArrayList<PriceSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPriceSets());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type PriceSet.
	 */
	public List<PriceSet> searchPriceSets(final String _searchString, final int _maxResults) {
		final List<PriceSet> entities = new ArrayList<PriceSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPriceSets(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a PriceSet.
	 */
	public void delete(final PriceSet entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of PriceSet entities.
	 */
	public int countPriceSets() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPriceSets();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Item using all read-only properties.
	 */
	public Item createItem(final PriceSet priceSet) {
		final Item[] entity = new Item[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createItem(priceSet);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Item with the given id.
	 */
	public Item getItem(final int id) {
		final Item[] entity = new Item[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getItem(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Items with the given priceSet.
	 */
	public List<Item> getItemsByPriceSet(final PriceSet priceSet) {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getItemsByPriceSet(priceSet));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Items with the given producer.
	 */
	public List<Item> getItemsByProducer(final Producer producer) {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getItemsByProducer(producer));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Item.
	 */
	public List<Item> getAllItems() {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllItems());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItems(final String _searchString, final int _maxResults) {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchItems(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithPriceSet(final PriceSet priceSet, final String _searchString, final int _maxResults) {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchItemWithPriceSet(priceSet, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Item.
	 */
	public List<Item> searchItemWithProducer(final Producer producer, final String _searchString, final int _maxResults) {
		final List<Item> entities = new ArrayList<Item>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchItemWithProducer(producer, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Item.
	 */
	public void delete(final Item entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Item entities.
	 */
	public int countItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new SupplierItem using all read-only properties.
	 */
	public SupplierItem createSupplierItem(final java.lang.String supplierItemNumber, final Supplier supplier) {
		final SupplierItem[] entity = new SupplierItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSupplierItem(supplierItemNumber, supplier);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the SupplierItem with the given id.
	 */
	public SupplierItem getSupplierItem(final int id) {
		final SupplierItem[] entity = new SupplierItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getSupplierItem(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the SupplierItems with the given supplier.
	 */
	public List<SupplierItem> getSupplierItemsBySupplier(final Supplier supplier) {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getSupplierItemsBySupplier(supplier));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the SupplierItems with the given item.
	 */
	public List<SupplierItem> getSupplierItemsByItem(final Item item) {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getSupplierItemsByItem(item));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type SupplierItem.
	 */
	public List<SupplierItem> getAllSupplierItems() {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllSupplierItems());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItems(final String _searchString, final int _maxResults) {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSupplierItems(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithSupplier(final Supplier supplier, final String _searchString, final int _maxResults) {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSupplierItemWithSupplier(supplier, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type SupplierItem.
	 */
	public List<SupplierItem> searchSupplierItemWithItem(final Item item, final String _searchString, final int _maxResults) {
		final List<SupplierItem> entities = new ArrayList<SupplierItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSupplierItemWithItem(item, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a SupplierItem.
	 */
	public void delete(final SupplierItem entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of SupplierItem entities.
	 */
	public int countSupplierItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSupplierItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Supplier using all read-only properties.
	 */
	public Supplier createSupplier(final java.lang.String name) {
		final Supplier[] entity = new Supplier[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSupplier(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Supplier with the given id.
	 */
	public Supplier getSupplier(final int id) {
		final Supplier[] entity = new Supplier[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getSupplier(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Suppliers with the given warehouse.
	 */
	public List<Supplier> getSuppliersByWarehouse(final Warehouse warehouse) {
		final List<Supplier> entities = new ArrayList<Supplier>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getSuppliersByWarehouse(warehouse));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Supplier.
	 */
	public List<Supplier> getAllSuppliers() {
		final List<Supplier> entities = new ArrayList<Supplier>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllSuppliers());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSuppliers(final String _searchString, final int _maxResults) {
		final List<Supplier> entities = new ArrayList<Supplier>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSuppliers(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Supplier.
	 */
	public List<Supplier> searchSupplierWithWarehouse(final Warehouse warehouse, final String _searchString, final int _maxResults) {
		final List<Supplier> entities = new ArrayList<Supplier>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSupplierWithWarehouse(warehouse, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Supplier.
	 */
	public void delete(final Supplier entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Supplier entities.
	 */
	public int countSuppliers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSuppliers();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Warehouse using all read-only properties.
	 */
	public Warehouse createWarehouse(final java.lang.String name) {
		final Warehouse[] entity = new Warehouse[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createWarehouse(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Warehouse with the given id.
	 */
	public Warehouse getWarehouse(final int id) {
		final Warehouse[] entity = new Warehouse[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getWarehouse(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Warehouse.
	 */
	public List<Warehouse> getAllWarehouses() {
		final List<Warehouse> entities = new ArrayList<Warehouse>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllWarehouses());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Warehouse.
	 */
	public List<Warehouse> searchWarehouses(final String _searchString, final int _maxResults) {
		final List<Warehouse> entities = new ArrayList<Warehouse>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchWarehouses(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Warehouse.
	 */
	public void delete(final Warehouse entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Warehouse entities.
	 */
	public int countWarehouses() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countWarehouses();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new CustomerOrder using all read-only properties.
	 */
	public CustomerOrder createCustomerOrder() {
		final CustomerOrder[] entity = new CustomerOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createCustomerOrder();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the CustomerOrder with the given id.
	 */
	public CustomerOrder getCustomerOrder(final int id) {
		final CustomerOrder[] entity = new CustomerOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getCustomerOrder(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the CustomerOrders with the given customer.
	 */
	public List<CustomerOrder> getCustomerOrdersByCustomer(final Customer customer) {
		final List<CustomerOrder> entities = new ArrayList<CustomerOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getCustomerOrdersByCustomer(customer));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type CustomerOrder.
	 */
	public List<CustomerOrder> getAllCustomerOrders() {
		final List<CustomerOrder> entities = new ArrayList<CustomerOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllCustomerOrders());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrders(final String _searchString, final int _maxResults) {
		final List<CustomerOrder> entities = new ArrayList<CustomerOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchCustomerOrders(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type CustomerOrder.
	 */
	public List<CustomerOrder> searchCustomerOrderWithCustomer(final Customer customer, final String _searchString, final int _maxResults) {
		final List<CustomerOrder> entities = new ArrayList<CustomerOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchCustomerOrderWithCustomer(customer, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a CustomerOrder.
	 */
	public void delete(final CustomerOrder entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of CustomerOrder entities.
	 */
	public int countCustomerOrders() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCustomerOrders();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new OrderedItem using all read-only properties.
	 */
	public OrderedItem createOrderedItem() {
		final OrderedItem[] entity = new OrderedItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createOrderedItem();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the OrderedItem with the given id.
	 */
	public OrderedItem getOrderedItem(final int id) {
		final OrderedItem[] entity = new OrderedItem[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getOrderedItem(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the OrderedItems with the given item.
	 */
	public List<OrderedItem> getOrderedItemsByItem(final Item item) {
		final List<OrderedItem> entities = new ArrayList<OrderedItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getOrderedItemsByItem(item));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type OrderedItem.
	 */
	public List<OrderedItem> getAllOrderedItems() {
		final List<OrderedItem> entities = new ArrayList<OrderedItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllOrderedItems());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItems(final String _searchString, final int _maxResults) {
		final List<OrderedItem> entities = new ArrayList<OrderedItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderedItems(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderedItem.
	 */
	public List<OrderedItem> searchOrderedItemWithItem(final Item item, final String _searchString, final int _maxResults) {
		final List<OrderedItem> entities = new ArrayList<OrderedItem>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderedItemWithItem(item, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a OrderedItem.
	 */
	public void delete(final OrderedItem entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of OrderedItem entities.
	 */
	public int countOrderedItems() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countOrderedItems();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Customer using all read-only properties.
	 */
	public Customer createCustomer() {
		final Customer[] entity = new Customer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createCustomer();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Customer with the given id.
	 */
	public Customer getCustomer(final int id) {
		final Customer[] entity = new Customer[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getCustomer(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Customer.
	 */
	public List<Customer> getAllCustomers() {
		final List<Customer> entities = new ArrayList<Customer>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllCustomers());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Customer.
	 */
	public List<Customer> searchCustomers(final String _searchString, final int _maxResults) {
		final List<Customer> entities = new ArrayList<Customer>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchCustomers(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Customer.
	 */
	public void delete(final Customer entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Customer entities.
	 */
	public int countCustomers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCustomers();
			}
		});
		return count[0];
	}
	
}
