package org.emftext.sdk.finders;

import java.io.File;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * An implementation of the IGenPackageFinderResult interface used
 * that can be used by finders that look up generator models in 
 * files. When objects of this class are created the modification
 * time of the .ecore file that is referenced by the generator 
 * model is determined. This modification time stamp is late on
 * (when the generator model is looked up in the model cache)
 * used to check whether the meta model has changed.
 */
public class GenPackageInFileResult implements IGenPackageFinderResult {

	private GenPackage genPackage;
	private File ecoreFile;
	private long initialModifiedStamp;
	
	public GenPackageInFileResult(GenPackage genPackage, File ecoreFile) {
		assert genPackage != null;
		assert ecoreFile != null;
		
		this.genPackage = genPackage;
		this.ecoreFile = ecoreFile;
		if (ecoreFile != null) {
			this.initialModifiedStamp = ecoreFile.lastModified();
		}
	}
	
	public GenPackage getResult() {
		return genPackage;
	}

	public boolean hasChanged() {
		if (ecoreFile != null) {
			return initialModifiedStamp != ecoreFile.lastModified();
		} else {
			return false;
		}
	}
}