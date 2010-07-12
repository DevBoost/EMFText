package org.emftext.sdk.codegen;

public class BasicPackage<ContextType> implements IPackage<ContextType> {

	private String packageName;
	
	public BasicPackage(String packageName) {
		super();
		this.packageName = packageName;
	}

	public String getName(ContextType context) {
		return packageName;
	}
}
