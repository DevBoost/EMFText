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
