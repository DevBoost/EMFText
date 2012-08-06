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
package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SupplierItem"
)
/*
 * This class is generated from the entity 'SupplierItem' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class SupplierItem {
	
	@GenericGenerator(name="SupplierItemIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="SupplierItem"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SupplierItemIdGenerator")
	private int id;

	private java.lang.String supplierItemNumber;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="supplier", updatable=false, nullable=false)
	private Supplier supplier;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="item", nullable=false)
	private Item item;
	
	private double supplierPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastUpdate;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public SupplierItem() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public SupplierItem(java.lang.String supplierItemNumber, Supplier supplier) {
		super();
		this.supplierItemNumber = supplierItemNumber;
		this.supplier = supplier;
	}
	
	/**
	 * Returns the automatically generated id the identifies this entity object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * The property 'id' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of property 'supplierItemNumber'.
	 */
	public java.lang.String getSupplierItemNumber() {
		return supplierItemNumber;
	}
	
	/**
	 * The property 'supplierItemNumber' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setSupplierItemNumber(java.lang.String newValue) {
		this.supplierItemNumber = newValue;
	}
	
	/**
	 * Returns the value of property 'supplier'.
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * The property 'supplier' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setSupplier(Supplier newValue) {
		this.supplier = newValue;
	}
	
	/**
	 * Returns the value of property 'item'.
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Sets the value of property 'item'.
	 */
	public void setItem(Item newValue) {
		this.item = newValue;
	}
	
	/**
	 * Returns the value of property 'supplierPrice'.
	 */
	public double getSupplierPrice() {
		return supplierPrice;
	}
	
	/**
	 * Sets the value of property 'supplierPrice'.
	 */
	public void setSupplierPrice(double newValue) {
		this.supplierPrice = newValue;
	}
	
	/**
	 * Returns the value of property 'lastUpdate'.
	 */
	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}
	
	/**
	 * Sets the value of property 'lastUpdate'.
	 */
	public void setLastUpdate(java.util.Date newValue) {
		this.lastUpdate = newValue;
	}
	
}
