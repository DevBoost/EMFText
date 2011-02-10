/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.finders;

import java.util.Collection;
import java.util.LinkedHashSet;

public class GenPackageResolveResult {

	private Collection<IResolvedGenPackage> resolvedPackages;
	private boolean locationHintCorrect = false;

	public GenPackageResolveResult() {
		this(new LinkedHashSet<IResolvedGenPackage>());
	}

	public GenPackageResolveResult(Collection<IResolvedGenPackage> resolvedPackages) {
		this.resolvedPackages = resolvedPackages;
	}

	public Collection<IResolvedGenPackage> getResolvedPackages() {
		return resolvedPackages;
	}

	public boolean isLocationHintCorrect() {
		return locationHintCorrect;
	}

	public void addResolvedGenPackage(IResolvedGenPackage genPackage) {
		resolvedPackages.add(genPackage);
	}

	public void setLocationHintCorrect() {
		locationHintCorrect = true;
	}
}
