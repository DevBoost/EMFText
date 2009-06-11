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
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.NameUtil;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	private static final String STRING = String.class.getName();
	private static final String MAP = Map.class.getName();
	private static final NameUtil nameUtil = new NameUtil();
	
	private GenFeature proxyReference;
	private String defaultResolverDelegateName;

	public ReferenceResolverGenerator(GenerationContext context, GenFeature proxyReference) {
		super(context.getResolverPackageName(), nameUtil.getReferenceResolverClassName(proxyReference));
		this.proxyReference = proxyReference;
		this.defaultResolverDelegateName = context.getQualifiedDefaultResolverDelegateName();
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
	    sc.add("package " + getResourcePackageName() + ";");	
	    sc.addLineBreak();
	    sc.add("public class " + getResourceClassName() + " extends " + AbstractReferenceResolver.class.getName() + "<" + proxyReference.getGenClass().getQualifiedInterfaceName() + ", " + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + "> {");
	    sc.addLineBreak();
		addFields(sc);
		addResolveMethod(sc);
	    addDeResolveMethod(sc);
	    addSetOptionsMethod(sc);
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void addFields(StringComposite sc) {
		String typeParameters = "<" + proxyReference.getGenClass().getQualifiedInterfaceName() + ", " + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + ">";
		sc.add("private " + defaultResolverDelegateName + typeParameters + " delegate = new " + defaultResolverDelegateName + typeParameters + "();");
	    sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("public " + STRING + " deResolve(" + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + " element, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference) {");
		sc.add("return delegate.deResolve(element, container, reference);");
		sc.add("}");
	    sc.addLineBreak();
	}

	private void addResolveMethod(StringComposite sc) {
		sc.add("public void resolve(" + STRING + " identifier, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + IReferenceResolveResult.class.getName() + "<" + proxyReference.getTypeGenClass().getQualifiedInterfaceName() + "> result) {");
		sc.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);");
		sc.add("}");
	    sc.addLineBreak();
	}

	private void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add("// TODO save options in a field or leave method empty if this resolver does not depend on any option");
		sc.add("}");
	    sc.addLineBreak();
	}
}
