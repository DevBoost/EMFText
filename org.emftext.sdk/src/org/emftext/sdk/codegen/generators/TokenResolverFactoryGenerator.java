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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractTokenResolverFactory;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * Generates a TokenResolverFactory which will contain a mapping from ANTLR token names to 
 * TokenResolver implementations. It will inherit from BasicTokenResolverFactory.
 * 
 * @see org.emftext.runtime.resource.impl.AbstractTokenResolverFactory
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class TokenResolverFactoryGenerator extends BaseGenerator {
	
	private GenerationContext context;
	
	public TokenResolverFactoryGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getTokenResolverFactoryClassName());
		this.context = context;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + AbstractTokenResolverFactory.class.getName() + " implements " + ITokenResolverFactory.class.getName() + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "() {");
		for (TokenDefinition definition : context.getConcreteSyntax().getAllTokens()) {
			if (!definition.isUsed()) {
				continue;
			}
			// user defined tokens may stem from an imported syntax
			ConcreteSyntax containingSyntax = context.getContainingSyntax(definition);
			String tokenResolverClassName = context.getTokenResolverClassName(definition);
			if (tokenResolverClassName != null) {
				if (definition.getAttributeName() != null) {
					String featureName = definition.getAttributeName();
					sc.add("super.registerCollectInTokenResolver(\"" + featureName + "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				} else {
					sc.add("super.registerTokenResolver(\"" +definition.getName()+ "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				}
			}
		}
		sc.add("}");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}
