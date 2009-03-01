/**
 * 
 */
package org.emftext.sdk.finders;

import java.io.File;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class GenPackageInFileResult implements IGenPackageFinderResult {

	private long initialModifiedStamp;
	private GenPackage genPackage;
	private File file;
	
	public GenPackageInFileResult(GenPackage genPackage, File file) {
		assert genPackage != null;
		assert file != null;
		
		this.genPackage = genPackage;
		this.file = file;
		if (file != null) {
			this.initialModifiedStamp = file.lastModified();
		}
	}
	
	public GenPackage getResult() {
		return genPackage;
	}

	public boolean hasChanged() {
		if (file != null) {
			return initialModifiedStamp != file.lastModified();
		} else {
			return false;
		}
	}
}