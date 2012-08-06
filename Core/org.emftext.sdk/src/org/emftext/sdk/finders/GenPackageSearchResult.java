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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class GenPackageSearchResult {

	private Collection<GenPackage> foundPackages;
	private boolean locationHintIsCorrect;

	public GenPackageSearchResult() {
		this.foundPackages = new LinkedHashSet<GenPackage>();
		this.locationHintIsCorrect = false;
	}

	public Collection<GenPackage> getFoundPackages() {
		return foundPackages;
	}

	public boolean isLocationHintCorrect() {
		return locationHintIsCorrect;
	}

	public void addGenPackage(GenPackage genPackage) {
		foundPackages.add(genPackage);
	}

	public void setLocationHintCorrect() {
		locationHintIsCorrect = true;
	}
}
