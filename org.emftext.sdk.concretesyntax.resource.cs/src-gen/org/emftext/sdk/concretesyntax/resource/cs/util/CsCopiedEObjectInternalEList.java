/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.util;

public class CsCopiedEObjectInternalEList extends org.emftext.sdk.concretesyntax.resource.cs.util.CsCopiedEList<org.eclipse.emf.ecore.EObject> implements org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject> {
	
	private org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject> original;
	private org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject> copy;
	
	public CsCopiedEObjectInternalEList(org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject> original) {
		super(original);
		this.original = original;
		this.copy = new org.eclipse.emf.ecore.util.BasicInternalEList<org.eclipse.emf.ecore.EObject>(org.eclipse.emf.ecore.EObject.class);
		this.copy.addAll(this.original);
	}
	
	public boolean basicContains(java.lang.Object object) {
		return copy.basicContains(object);
	}
	
	public boolean basicContainsAll(java.util.Collection<?> collection) {
		return copy.basicContainsAll(collection);
	}
	
	public org.eclipse.emf.ecore.EObject basicGet(int index) {
		return copy.basicGet(index);
	}
	
	public int basicIndexOf(java.lang.Object object) {
		return copy.basicIndexOf(object);
	}
	
	public java.util.Iterator<org.eclipse.emf.ecore.EObject> basicIterator() {
		return copy.basicIterator();
	}
	
	public int basicLastIndexOf(java.lang.Object object) {
		return copy.basicLastIndexOf(object);
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> basicList() {
		return copy.basicList();
	}
	
	public java.util.ListIterator<org.eclipse.emf.ecore.EObject> basicListIterator() {
		return copy.basicListIterator();
	}
	
	public java.util.ListIterator<org.eclipse.emf.ecore.EObject> basicListIterator(int index) {
		return copy.basicListIterator(index);
	}
	
	public java.lang.Object[] basicToArray() {
		return copy.basicToArray();
	}
	
	public <T> T[] basicToArray(T[] array) {
		return copy.basicToArray(array);
	}
	
	public boolean equals(java.lang.Object o) {
		return copy.equals(o);
	}
	
	public int hashCode() {
		return copy.hashCode();
	}
	
	public boolean addAllUnique(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> collection) {
		copy.addAllUnique(collection);
		return original.addAllUnique(collection);
	}
	
	public boolean addAllUnique(int index, java.util.Collection<? extends org.eclipse.emf.ecore.EObject> collection) {
		copy.addAllUnique(index, collection);
		return original.addAllUnique(index, collection);
	}
	
	public void addUnique(org.eclipse.emf.ecore.EObject object) {
		copy.addUnique(object);
		original.addUnique(object);
	}
	
	public void addUnique(int index, org.eclipse.emf.ecore.EObject object) {
		copy.addUnique(index, object);
		original.addUnique(index, object);
	}
	
	public org.eclipse.emf.common.notify.NotificationChain basicAdd(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.common.notify.NotificationChain notifications) {
		copy.basicAdd(object, notifications);
		return original.basicAdd(object, notifications);
	}
	
	public org.eclipse.emf.common.notify.NotificationChain basicRemove(java.lang.Object object,
	org.eclipse.emf.common.notify.NotificationChain notifications) {
		copy.basicRemove(object, notifications);
		return original.basicRemove(object, notifications);
	}
	
	public org.eclipse.emf.ecore.EObject setUnique(int index, org.eclipse.emf.ecore.EObject object) {
		copy.setUnique(index, object);
		return original.setUnique(index, object);
	}
}
