package org.emftext.sdk.ant;

import java.lang.reflect.Field;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.EPackage;

public class RegisterEPackageTask extends Task {

	private String namespaceURI;
	private String packageClass;

	@Override
	public void execute() throws BuildException {

		try {
			Field factoryInstance = Class.forName(packageClass).getField("eINSTANCE");
			Object ePackageObject = factoryInstance.get(null);
			EPackage.Registry.INSTANCE.put(namespaceURI, ePackageObject);
		} catch (Exception e) {
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
}
