package org.emftext.sdk.codegen.generators.adapter;

import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * Adapts explicitly defined tokens from the CS specification to the internal 
 * interfaces.
 */
public class UserDefinedTokenDefinitionAdapter implements IInternalTokenDefinition {
	
	private NewDefinedToken adaptee;
	private boolean implicitlyReferenced;
	
	public UserDefinedTokenDefinitionAdapter(NewDefinedToken adaptee){
		this(adaptee,false);
	}
	
	public UserDefinedTokenDefinitionAdapter(NewDefinedToken adaptee,boolean implicitlyReferenced){
		if (adaptee==null) {
			throw new IllegalArgumentException("Adaptee cant be null!");
		}
		this.adaptee = adaptee;
		this.implicitlyReferenced = implicitlyReferenced;
	}

	public TokenDefinition getBaseDefinition() {
		return adaptee;
	}

	public String getExpression() {
		return adaptee.getRegex();
	}

	public String getName() {
		return adaptee.getName();
	}

	public String getPrefix() {
		return null;
	}

	public String getSuffix() {
		return null;
	}
	
	public boolean isReferenced(){
		return implicitlyReferenced||!adaptee.getAttributeReferences().isEmpty();
	}
	
	public boolean isDerived(){
		return false;
	}

	public boolean isCollect() {
		return adaptee.getAttributeName() != null;
	}
}