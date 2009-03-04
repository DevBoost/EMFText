/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
