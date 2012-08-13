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
