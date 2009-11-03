/*******************************************************************************
 * Copyright (c) 2006-2009 
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
	private File genmodelFile;
	private long initialEcoreModificationStamp;
	private long initialGenmodelModificationStamp;
	
	public GenPackageInFileResult(GenPackage genPackage, File ecoreFile, File genmodelFile) {
		assert genPackage != null;
		//assert ecoreFile != null;
		
		this.genPackage = genPackage;
		this.ecoreFile = ecoreFile;
		if (ecoreFile != null) {
			this.initialEcoreModificationStamp = ecoreFile.lastModified();
		}
		this.genmodelFile = genmodelFile;
		if (genmodelFile != null) {
			this.initialGenmodelModificationStamp = genmodelFile.lastModified();
		}
	}
	
	public GenPackage getResult() {
		return genPackage;
	}

	public boolean hasChanged() {
		boolean ecoreFileDiffers = false;
		boolean genmodelFileDiffers = false;
		if (ecoreFile != null) {
			ecoreFileDiffers = initialEcoreModificationStamp != ecoreFile.lastModified();
		}
		if (genmodelFile != null) {
			genmodelFileDiffers = initialGenmodelModificationStamp != genmodelFile.lastModified();
		}
		return ecoreFileDiffers || genmodelFileDiffers;
	}
}
