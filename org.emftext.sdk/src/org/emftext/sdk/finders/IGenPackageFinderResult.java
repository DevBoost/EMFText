package org.emftext.sdk.finders;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * Implementations of this interface are instantiated by implementations of
 * {@link IGenPackageFinder}. The main purpose of this interface is to
 * encapsulate a {@link GenPackage}.
 */
public interface IGenPackageFinderResult {

	/**
	 * @return The encapsulated {@link GenPackage}.
	 */
	public GenPackage getResult();
}
