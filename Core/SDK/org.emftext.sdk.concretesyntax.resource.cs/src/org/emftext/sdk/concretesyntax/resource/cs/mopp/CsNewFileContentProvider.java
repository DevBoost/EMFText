/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.access.resource.INewFileContentProvider;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation;

public class CsNewFileContentProvider {
	
	public ICsMetaInformation getMetaInformation() {
		return new CsMetaInformation();
	}
	
	/**
	 * This method is not used, but to keep the {@link CsNewFileContentProvider}
	 * class backwards compatibly with the {@link INewFileContentProvider}
	 * interface we do not remove it.
	 */
	public String getNewFileContent(String newFileName) {
		return "";
	}
	
	public String getNewFileContent(IFile newFile) {
		EClass[] startClasses = new EClass[] {
			ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
		};
		EClass[] classesWithSyntax = getMetaInformation().getClassesWithSyntax();
		return getExampleContent(startClasses, classesWithSyntax, newFile);
	}
	
	protected String getExampleContent(EClass[] startClasses, EClass[] allClassesWithSyntax, IFile newFile) {
		String fileExtension = "myFileExtension";
		String namespaceURI = "http://www.some-domain.org/myLanguage";
		String genmodelLocationHint = "optional/path/to/myLanguage.genmodel";
		String startMetaClassName = "StartMetaClass";
		
		// Determine better values from file.

		// Important to use the absolute file system path returned by
		// getLocation() because otherwise proxies (such as to the wrapped
		// EPackages) cannot be resolved properly.
		IPath newLocation = newFile.getLocation();
		IPath genmodelPath = newLocation.removeFileExtension().addFileExtension("genmodel");
		URI genmodelURI = URI.createFileURI(genmodelPath.toString());
		
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			
			Resource genmodelResource = resourceSet.createResource(genmodelURI);
			genmodelResource.load(Collections.EMPTY_MAP);
			
			List<EObject> ecoreContents = genmodelResource.getContents();
			if (!ecoreContents.isEmpty()) {
				EObject ecoreContent = ecoreContents.get(0);
				
				if (ecoreContent instanceof GenModel) {
					GenModel genModel = (GenModel) ecoreContent;
					List<GenPackage> genPackages = genModel.getGenPackages();
					
					outer:
					for (GenPackage genPackage : genPackages) {
						EPackage ePackage = genPackage.getEcorePackage();
						
						fileExtension = genPackage.getFileExtension() + "_text";
						namespaceURI = ePackage.getNsURI();
						// If the genmodel could be found with the derived name,
						// then there is no need to specify it explicitly.
						genmodelLocationHint = null;
						
						List<EClassifier> eClassifiers = ePackage.getEClassifiers();
						for (EClassifier eClassifier : eClassifiers) {
							if (eClassifier instanceof EClass) {
								EClass eClass = (EClass) eClassifier;
								
								if (!eClass.isAbstract() && !eClass.isInterface()) {
									startMetaClassName = eClass.getName();
									break outer;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			CsPlugin.logWarning("Exception while deriving example content for new CS file.", e);
		}
		
		
		// Create the example content.
		final String endl = System.getProperty("line.separator");
		
		String content = "";
		content += "SYNTAXDEF " + fileExtension + endl;
		content += "FOR <" + namespaceURI + ">";
		
		if (genmodelLocationHint != null) {
			content += " <" + genmodelLocationHint + ">";
		}
		
		content += endl;
		
		content += "START " + startMetaClassName + endl;
		content += endl;
		content += "OPTIONS {" + endl;
		content += "\treloadGeneratorModel = \"true\";" + endl;
		content += "}" + endl;
		content += endl;
		content += "RULES {" + endl;
		content += "\t// syntax definition for class '" + startMetaClassName + "'" + endl;
		content += "\t" + startMetaClassName + " ::= \"myKeyword\" attributeOf" + startMetaClassName + "[] aContainmentReference*;" + endl;
		content += "\t" + endl;
		content += "\t// syntax definition for class 'AnotherMetaClass'" + endl;
		content += "\tAnotherMetaClass ::= \"otherKeyword\" aNonContainmentReference[];" + endl;
		content += "}" + endl;
		
		return content;
	}
}
