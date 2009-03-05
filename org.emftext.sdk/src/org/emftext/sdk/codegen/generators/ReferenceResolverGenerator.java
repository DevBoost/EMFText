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

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	private GenFeature proxyReference;

	public ReferenceResolverGenerator(GenerationContext context, GenFeature proxyReference) {
		super(context.getResolverPackageName(), context.getReferenceResolverClassName(proxyReference));
		this.proxyReference = proxyReference;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
	    sc.add("package " + getResourcePackageName() + ";");	
	    sc.addLineBreak();
	    sc.add("public class " + getResourceClassName() + " extends " + AbstractReferenceResolver.class.getName() + "<" + proxyReference.getGenClass().getQualifiedInterfaceName() + ", " + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + "> {");

	    sc.addLineBreak();
	    generateDoDeResolveMethod(sc);
	    
	    sc.addLineBreak();
		generateDoResolveMethod(sc);

		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void generateDoDeResolveMethod(StringComposite sc) {
		sc.add("@Override");
	    sc.addLineBreak();
		sc.add("protected " + String.class.getName() + " doDeResolve(" + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + " element, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference) {");
		sc.add("return super.doDeResolve(element, container, reference);");
		sc.add("}");
	}

	private void generateDoResolveMethod(StringComposite sc) {
		sc.add("@Override");
	    sc.addLineBreak();
		sc.add("protected void doResolve(" + String.class.getName() + " identifier, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + IReferenceResolveResult.class.getName() + "<" + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + "> result) {");
		sc.add("super.doResolve(identifier, container, reference, position, resolveFuzzy, result);");
		sc.add("}");
	}
}
