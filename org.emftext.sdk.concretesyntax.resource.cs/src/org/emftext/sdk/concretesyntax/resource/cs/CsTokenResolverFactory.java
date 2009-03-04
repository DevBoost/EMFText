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
package org.emftext.sdk.concretesyntax.resource.cs;

public class CsTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	public CsTokenResolverFactory() {
		super.registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUALIFIED_NAMETokenResolver());
		super.registerTokenResolver("NUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsNUMBERTokenResolver());
		super.registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		super.registerTokenResolver("QUOTED_39_39", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
		super.registerTokenResolver("QUOTED_34_34", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34TokenResolver());
	}
}
