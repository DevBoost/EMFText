/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A CsLayoutInformationAdapter is used to store layout information that is found
 * while parsing text files. Layout information does include all unused tokens.
 * Usually, these are whitespace characters, line breaks and comments, but
 * depending on the concrete syntax definition it can also include other tokens.
 * CsLayoutInformationAdapters are attached to EObjects and aggregate multiple
 * LayoutInformation objects. Each of these objects contains the layout that was
 * found before a keyword, attribute or reference.
 * </p>
 * 
 * <p>
 * Since layout information is stored in EAdapters, models can be transformed and
 * modified, while still keeping the formatting of the original text document from
 * which the model was originally created.
 * </p>
 */
public class CsLayoutInformationAdapter implements Adapter {
	
	/**
	 * The EObject that this adapter is attached to.
	 */
	private Notifier target;
	
	/**
	 * A list of LayoutInformation objects. one for each keyword, attribute and
	 * reference.
	 */
	private List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>();
	
	/**
	 * Returns the EObject that this adapter is attached to.
	 */
	public Notifier getTarget() {
		return target;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	public void notifyChanged(Notification notification) {
	}
	
	/**
	 * Sets the EObject that this adapter is attached to.
	 */
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}
	
	public List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> getLayoutInformations() {
		return layoutInformations;
	}
	
	public void addLayoutInformation(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation) {
		layoutInformations.add(layoutInformation);
	}
	
	/**
	 * Iterates over all layout informations and searches for those that refer to the
	 * given proxy object. Then, the old target of these layout informations (i.e.,
	 * the proxy) is changed to the new target. This is required, because at the time
	 * when the layout information is collected, all references point to proxy
	 * objects. But, later on these proxy objects are replaced by the objects that are
	 * referenced. To keep the layout information up to date, this replacement must be
	 * propagated to all attached layout information objects.
	 */
	public void replaceProxy(EObject proxy, EObject target) {
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation : layoutInformations) {
			layoutInformation.replaceProxy(proxy, target);
		}
	}
	
}
