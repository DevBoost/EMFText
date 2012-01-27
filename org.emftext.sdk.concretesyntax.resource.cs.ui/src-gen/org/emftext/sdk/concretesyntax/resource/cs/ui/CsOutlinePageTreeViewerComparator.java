/*******************************************************************************
 * Copyright (c) 2006-2012
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsOutlinePageTreeViewerComparator extends org.eclipse.jface.viewers.ViewerComparator {
	
	private static java.util.Map<org.eclipse.emf.ecore.EPackage, Integer> ePackageMap = new java.util.LinkedHashMap<org.eclipse.emf.ecore.EPackage, Integer>();
	private static int nextPackageID;
	
	private java.util.Comparator<Object> comparator = new java.util.Comparator<Object>() {
		
		public int compare(Object o1, Object o2) {
			if (!sortLexically) {
				return 0;
			}
			if (o1 instanceof String && o2 instanceof String) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				return s1.compareTo(s2);
			}
			return 0;
		}
	};
	private boolean groupTypes;
	private boolean sortLexically;
	
	public void setGroupTypes(boolean on) {
		this.groupTypes = on;
	}
	
	public void setSortLexically(boolean on) {
		this.sortLexically = on;
	}
	
	@Override	
	public int category(Object element) {
		if (!groupTypes) {
			return 0;
		}
		if (element instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) element;
			org.eclipse.emf.ecore.EClass eClass = eObject.eClass();
			org.eclipse.emf.ecore.EPackage ePackage = eClass.getEPackage();
			int packageID = getEPackageID(ePackage);
			int classifierID = eClass.getClassifierID();
			return packageID + classifierID;
		} else {
			return super.category(element);
		}
	}
	
	private int getEPackageID(org.eclipse.emf.ecore.EPackage ePackage) {
		Integer packageID = ePackageMap.get(ePackage);
		if (packageID == null) {
			packageID = nextPackageID;
			// we assumed that packages do contain at most 1000 classifiers
			nextPackageID += 1000;
			ePackageMap.put(ePackage, nextPackageID);
		}
		return packageID;
	}
	
	public java.util.Comparator<?> getComparator() {
		return this.comparator;
	}
	
	public int compare(org.eclipse.jface.viewers.Viewer viewer, Object o1, Object o2) {
		// first check categories
		int cat1 = category(o1);
		int cat2 = category(o2);
		if (cat1 != cat2) {
			return cat1 - cat2;
		}
		// then try to compare the names
		if (sortLexically && o1 instanceof org.eclipse.emf.ecore.EObject && o2 instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject e1 = (org.eclipse.emf.ecore.EObject) o1;
			org.eclipse.emf.ecore.EObject e2 = (org.eclipse.emf.ecore.EObject) o2;
			org.emftext.sdk.concretesyntax.resource.cs.ICsNameProvider nameProvider = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().createNameProvider();
			java.util.List<String> names1 = nameProvider.getNames(e1);
			java.util.List<String> names2 = nameProvider.getNames(e2);
			if (names1 != null && !names1.isEmpty() && names2 != null && !names2.isEmpty()) {
				String name1 = names1.get(0);
				String name2 = names2.get(0);
				return name1.compareTo(name2);
			}
		}
		return super.compare(viewer, o1, o2);
	}
	
}
