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
package org.emftext.sdk.generatorconfig.resource.generatorconfig;

// An element that is expected at a given position in a resource
// stream.
public interface IGeneratorconfigExpectedElement {

	public java.lang.String getTokenName();
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	public void addFollower(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path);
	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers();
}
