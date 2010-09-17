package org.emftext.sdk.ant;

import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class RegisterGenModelTask extends Task {
	
	private String namespaceURI;
	private String packageClass;
	private String genModelURI;

	@Override
	public void execute() throws BuildException {
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		packageNsURIToGenModelLocationMap.put(namespaceURI, URI.createURI(genModelURI));
		try {
			EPackage.Registry.INSTANCE.put(namespaceURI, Class.forName(packageClass));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new BuildException(e.getMessage());
		}
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public String getPackageClass() {
		return packageClass;
	}

	public void setPackageClass(String packageClass) {
		this.packageClass = packageClass;
	}

	public String getGenModelURI() {
		return genModelURI;
	}

	public void setGenModelURI(String genModelURI) {
		this.genModelURI = genModelURI;
	}
}
