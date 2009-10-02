package org.emftext.runtime.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.InternalEList;

//TODO mseifert: generate this class
//TODO mseifert: override remove() method of iterators
public class CopiedEObjectInternalEList extends CopiedEList<EObject> implements InternalEList<EObject> {

	private InternalEList<EObject> internalOriginal;
	private InternalEList<EObject> internalCopy;

	public CopiedEObjectInternalEList(InternalEList<EObject> original) {
		super(original);
		this.internalOriginal = original;
		this.internalCopy = new BasicInternalEList<EObject>(EObject.class);
		this.internalCopy.addAll(this.internalOriginal);
	}

	public boolean basicContains(Object object) {
		return internalCopy.basicContains(object);
	}

	public boolean basicContainsAll(Collection<?> collection) {
		return internalCopy.basicContainsAll(collection);
	}

	public EObject basicGet(int index) {
		return internalCopy.basicGet(index);
	}

	public int basicIndexOf(Object object) {
		return internalCopy.basicIndexOf(object);
	}

	public Iterator<EObject> basicIterator() {
		return internalCopy.basicIterator();
	}

	public int basicLastIndexOf(Object object) {
		return internalCopy.basicLastIndexOf(object);
	}

	public List<EObject> basicList() {
		return internalCopy.basicList();
	}

	public ListIterator<EObject> basicListIterator() {
		return internalCopy.basicListIterator();
	}

	public ListIterator<EObject> basicListIterator(int index) {
		return internalCopy.basicListIterator(index);
	}

	public Object[] basicToArray() {
		return internalCopy.basicToArray();
	}

	public <T> T[] basicToArray(T[] array) {
		return internalCopy.basicToArray(array);
	}

	public boolean equals(Object o) {
		return internalCopy.equals(o);
	}

	public int hashCode() {
		return internalCopy.hashCode();
	}


	
	public boolean addAllUnique(Collection<? extends EObject> collection) {
		internalCopy.addAllUnique(collection);
		return internalOriginal.addAllUnique(collection);
	}

	public boolean addAllUnique(int index, Collection<? extends EObject> collection) {
		internalCopy.addAllUnique(index, collection);
		return internalOriginal.addAllUnique(index, collection);
	}

	public void addUnique(EObject object) {
		internalCopy.addUnique(object);
		internalOriginal.addUnique(object);
	}

	public void addUnique(int index, EObject object) {
		internalCopy.addUnique(index, object);
		internalOriginal.addUnique(index, object);
	}

	public NotificationChain basicAdd(EObject object, NotificationChain notifications) {
		internalCopy.basicAdd(object, notifications);
		return internalOriginal.basicAdd(object, notifications);
	}

	public NotificationChain basicRemove(Object object,
			NotificationChain notifications) {
		internalCopy.basicRemove(object, notifications);
		return internalOriginal.basicRemove(object, notifications);
	}

	public EObject setUnique(int index, EObject object) {
		internalCopy.setUnique(index, object);
		return internalOriginal.setUnique(index, object);
	}
}
