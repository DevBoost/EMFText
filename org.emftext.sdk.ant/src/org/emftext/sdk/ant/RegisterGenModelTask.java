package org.emftext.sdk.ant;

import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;

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

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
			"ecore",
			new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
			"genmodel",
			new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		
        final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
        URI genModelURIObject = URI.createURI(genModelURI);
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.getResource(genModelURIObject, true);
        if (r == null) {
        	throw new BuildException("Can't load generator model from " + genModelURIObject);
        }
        packageNsURIToGenModelLocationMap.put(namespaceURI, genModelURIObject);
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
 