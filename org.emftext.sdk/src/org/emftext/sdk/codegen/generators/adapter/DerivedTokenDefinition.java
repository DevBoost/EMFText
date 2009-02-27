package org.emftext.sdk.codegen.generators.adapter;

import org.emftext.sdk.concretesyntax.PreDefinedToken;

/**
 * A common implementation for all derived token definitions.
 */
public class DerivedTokenDefinition implements IInternalTokenDefinition {
	
	private String name;
	private String expression;
	private String prefix;
	private String suffix;
	private boolean implicitlyReferenced;
	private boolean isCollect;
	
	public DerivedTokenDefinition(String name, String expression, String prefix, String suffix, boolean implicitlyReferenced, boolean isCollect){
		this.name = name;
		this.expression = expression;
		this.prefix = prefix;
		this.suffix = suffix;
		this.implicitlyReferenced = implicitlyReferenced;
		this.isCollect = isCollect;
	}
	
	public String getName() {
		return name;
	}
	
	public String getExpression() {
		return expression;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public PreDefinedToken getBaseDefinition() {
		return null;
	}
	
	public boolean isReferenced() {
		return implicitlyReferenced;
	}
	
	public boolean isDerived(){
		return true;
	}

	public boolean isCollect() {
		return isCollect;
	}
}