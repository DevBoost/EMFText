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
package org.emftext.sdk.ant;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RegisterGenModelTask extends Task {
       
    private String namespaceURI;
    private String genModelURI;

    @Override
    public void execute() throws BuildException {
    
		EPackage.Registry.INSTANCE.put(
				GenModelPackage.eNS_URI,
				GenModelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(
				EcorePackage.eNS_URI,
				EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(
				"http://www.eclipse.org/uml2/2.2.0/GenModel",
				getUML2GenPackage());
		EPackage.Registry.INSTANCE.put(
				"http://www.eclipse.org/uml2/4.0.0/Types",
				getUML2TypesPackage());
		
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		extensionToFactoryMap.put("genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		
		// We ignore the deprecation warning until the method is not available
		// anymore to keep this code runnable against old versions of EMF as
		// long as possible.
		@SuppressWarnings("deprecation")
        final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
        URI genModelURIObject = URI.createURI(genModelURI);
        ResourceSet rs = new ResourceSetImpl();
        Resource resource = null;
        try {
        	resource = rs.getResource(genModelURIObject, true);
        	
            for (GenPackage genPackage : ((GenModel)resource.getContents().get(0)).getGenPackages()) {
            	EPackage ecorePackage = genPackage.getEcorePackage();
				String nsURI = ecorePackage.getNsURI();
				EPackage.Registry.INSTANCE.put(nsURI, ecorePackage);
            }
        } catch (Exception e) {
        	e.printStackTrace();
          	throw new BuildException("Can't load generator model from " + genModelURIObject);
        }
    	
        packageNsURIToGenModelLocationMap.put(namespaceURI, genModelURIObject);
    }
    
	private EPackage getUML2GenPackage() {
		try {
			Class<?> factoryClass = Class.forName(
					"org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage");
			Field field_eINSTANCE = factoryClass.getField("eINSTANCE");
			EPackage ePackage = (EPackage) field_eINSTANCE.get(null);
			return ePackage;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException("Error while creating UML2 genmodel adapter.", e);
		}
	}
	
	private EPackage getUML2TypesPackage() {
		try {
			Class<?> factoryClass = Class.forName(
					"org.eclipse.uml2.types.TypesPackage");
			Field field_eINSTANCE = factoryClass.getField("eINSTANCE");
			EPackage ePackage = (EPackage) field_eINSTANCE.get(null);
			return ePackage;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException("Error while accessing UML2 types package.", e);
		}
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public String getGenModelURI() {
		return genModelURI;
	}

	public void setGenModelURI(String genModelURI) {
		this.genModelURI = genModelURI;
	}
}
