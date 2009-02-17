package org.emftext.sdk;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * Implementations of this interface are instantiated by implementations of
 * {@link IGenPackageFinder}. The main purpose of this interface is to
 * encapsulate a {@link GenPackage} and make sure that it is possible to
 * determine if it needs to be updated.
 */
public interface IGenPackageFinderResult {

	/**
	 * @return The encapsulated {@link GenPackage}.
	 */
	public GenPackage getResult();

	/**
	 * This method is used to determine if the encapsulated {@link GenPackage}
	 * has changed and needs to be updated.
	 * 
	 * @return <code>true</code> iff the encapsulated {@link GenPackage} has
	 *         changed, <code>false</code> otherwise.
	 */
	public boolean hasChanged();

	/**
	 * Returns true if multiple generator package with the same namespace
	 * URI were found.
	 */
	public boolean foundMultiple();
}
