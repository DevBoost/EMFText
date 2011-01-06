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
