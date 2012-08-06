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
package org.emftext.language.java.mdsm2011.qvto;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.closures.ClosuresPackage;

public class MetamodelUtil {

	private static final String extendString = "_transformed";
	
	/**
	 * Collect necessary meta model packages.
	 * 
	 * @return
	 */
	public static Collection<EPackage> collectMetaModels() {
		
		Collection<EPackage> metaPackages = new ArrayList<EPackage>();
		metaPackages.add(JavaPackage.eINSTANCE);
		metaPackages.add(ClosuresPackage.eINSTANCE);
		//metaPackages.add(PropertiesPackage.eINSTANCE);
		
		return metaPackages;
	}
	
	/**
	 * Helper for XMI loading. Does lazy loading.
	 * Load a Resource with a name with the help of a ResourceSet.
	 * 
	 * @param xmlFileName
	 *            file name to load
	 * @return the EMF resource
	 */
	public static Resource getResource(String xmlFileName, ResourceSet rs) {
		URI uri = URI.createFileURI(xmlFileName);
		Resource resource = null;
		try {
			resource = rs.getResource(uri, true);
		} catch (Throwable fileNotFoundException) {
			resource = rs.createResource(uri);
		}
		return resource;
	}
	
	public static Resource getResource(URI fileURI, ResourceSet rs) {
		
		Resource resource = null;
		try {
			resource = rs.getResource(fileURI, true);
		} catch (Throwable fileNotFoundException) {
			resource = rs.createResource(fileURI);
		}
		return resource;
	}
	
	public static URI getTargetFileURI(
			URI sourcePathURI, 
			File sourceFile, 
			URI targetPathURI, 
			ResourceSet rs) throws Exception{
		
		URI srcURI = URI.createFileURI(sourceFile.getCanonicalPath());
		srcURI = rs.getURIConverter().normalize(srcURI);
		
		URI tempURI = sourcePathURI.appendSegment("");
		URI lastParts = srcURI.deresolve(tempURI);
		String[] segments = lastParts.segments();
		
		// kill '..' in segments
		ArrayList<String> tempSegemnts = new ArrayList<String>();
		for(int i=0; i<segments.length;i++){
			if(!segments[i].equals(".."))
				tempSegemnts.add(segments[i]);
		}
		String[] newSegments = new String[1];
		newSegments = tempSegemnts.toArray(newSegments);
		
		URI outFileURI = targetPathURI.appendSegments(newSegments);
		outFileURI = outFileURI.trimFileExtension().trimFileExtension();
		outFileURI = outFileURI.trimSegments(1).appendSegment(
				outFileURI.segment(outFileURI.segmentCount()-1).concat(extendString))
				.appendFileExtension("java.xmi");
		return outFileURI;
	}
}
