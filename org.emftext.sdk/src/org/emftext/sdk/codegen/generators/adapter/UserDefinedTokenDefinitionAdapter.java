/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
