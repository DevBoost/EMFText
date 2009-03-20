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

import org.emftext.sdk.concretesyntax.PredefinedToken;

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
	
	public PredefinedToken getBaseDefinition() {
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
