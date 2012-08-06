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
package org.emftext.language.conference.resource.conference.analysis;

public class ConferenceOrganizersReferenceResolver implements org.emftext.language.conference.resource.conference.IConferenceReferenceResolver<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> {

	private org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultResolverDelegate<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> delegate = new org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultResolverDelegate<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant>();

	public void resolve(java.lang.String identifier, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.conference.resource.conference.IConferenceReferenceResolveResult<org.emftext.language.conference.Participant> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.conference.Participant element, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
