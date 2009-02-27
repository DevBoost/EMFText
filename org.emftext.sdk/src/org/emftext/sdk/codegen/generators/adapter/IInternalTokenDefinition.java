package org.emftext.sdk.codegen.generators.adapter;

import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * This interface encapsulates both automatically derived 
 * and user-defined token definitions.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface IInternalTokenDefinition {
	
	public String getName();
	public String getExpression();
	//might be null
	public String getPrefix();
	//might be null
	public String getSuffix();
	//might be null
	public TokenDefinition getBaseDefinition();
	
	public boolean isReferenced();
	public boolean isDerived();
	public boolean isCollect();
}