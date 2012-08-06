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
package org.emftext.language.devices.resource.devices.analysis;

public class MessagePartsReferenceResolver implements org.emftext.language.devices.resource.devices.IDevicesReferenceResolver<org.emftext.language.devices.Message, org.emftext.language.devices.MessagePart> {
	
	private org.emftext.language.devices.resource.devices.analysis.DevicesDefaultResolverDelegate<org.emftext.language.devices.Message, org.emftext.language.devices.MessagePart> delegate = new org.emftext.language.devices.resource.devices.analysis.DevicesDefaultResolverDelegate<org.emftext.language.devices.Message, org.emftext.language.devices.MessagePart>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.devices.Message container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.devices.resource.devices.IDevicesReferenceResolveResult<org.emftext.language.devices.MessagePart> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.devices.MessagePart element, org.emftext.language.devices.Message container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
