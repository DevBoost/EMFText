package org.emftext.sdk.codegen.resource.generators.code_completion.helpers;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * A ContainmentLink represents a containment feature in the context of a 
 * metaclass.
 */
public class ContainmentLink {

	private GenClass containerClass;
	private GenFeature genFeature;
	
	public ContainmentLink(GenClass containerClass, GenFeature genFeature) {
		super();
		this.containerClass = containerClass;
		this.genFeature = genFeature;
	}
	
	public GenClass getContainerClass() {
		return containerClass;
	}

	public GenFeature getFeature() {
		return genFeature;
	}
	
	public String toString() {
		return genFeature.getName() + "->" + containerClass.getName();
	}
}
