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

	/**
	 * This method is used by the meta model cache to determine
	 * whether the content a generator package has changed since
	 * the last time is was loaded. If this method returns true,
	 * the result is thrown away and the model is loaded again.
	 * 
	 * @return
	 */
	public boolean hasChanged();
}
