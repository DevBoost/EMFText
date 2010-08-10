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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsLayoutInformationAdapter implements org.eclipse.emf.common.notify.Adapter {
	
	private org.eclipse.emf.common.notify.Notifier target;
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>();
	
	public org.eclipse.emf.common.notify.Notifier getTarget() {
		return target;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
	}
	
	public void setTarget(org.eclipse.emf.common.notify.Notifier newTarget) {
		this.target = newTarget;
	}
	
	public java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> getLayoutInformations() {
		return layoutInformations;
	}
	
	public void addLayoutInformation(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation) {
		layoutInformations.add(layoutInformation);
	}
	
	public void replaceProxy(org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation : layoutInformations) {
			layoutInformation.replaceProxy(proxy, target);
		}
	}
	
}
