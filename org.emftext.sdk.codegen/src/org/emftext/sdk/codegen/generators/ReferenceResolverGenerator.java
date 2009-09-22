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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.codegen.ClassNameHelper;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator implements IGenerator {
	
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();

	private GenerationContext context;
	private ClassNameHelper classNameHelper;
	private GenFeature proxyReference;
	private String defaultResolverDelegateName;

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public ReferenceResolverGenerator() {
		super();
	}
			
	private ReferenceResolverGenerator(GenerationContext context) {
		super();
		this.context = context;
		this.classNameHelper = new ClassNameHelper(context);
		this.defaultResolverDelegateName = context.getQualifiedDefaultResolverDelegateName();
	}
	
	public void setProxyReference(GenFeature proxyReference) {
		this.proxyReference = proxyReference;
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
	    sc.add("package " + context.getResolverPackageName() + ";");	
	    sc.addLineBreak();
	    sc.add("public class " + csUtil.getReferenceResolverClassName(proxyReference) + " implements " + getClassNameHelper().getI_REFERENCE_RESOLVER() + "<" + genClassFinder.getQualifiedInterfaceName(proxyReference.getGenClass()) + ", " + genClassFinder.getQualifiedInterfaceName(proxyReference.getTypeGenClass()) + "> {");
	    sc.addLineBreak();
		addFields(sc);
		addResolveMethod(sc);
	    addDeResolveMethod(sc);
	    generatorUtil.addSetOptionsMethod(sc, "// TODO save options in a field or leave method empty if this resolver does not depend on any option");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	public ClassNameHelper getClassNameHelper() {
		return classNameHelper;
	}

	private void addFields(StringComposite sc) {
		String typeParameters = "<" + genClassFinder.getQualifiedInterfaceName(proxyReference.getGenClass()) + ", " + genClassFinder.getQualifiedInterfaceName(proxyReference.getTypeGenClass()) + ">";
		sc.add("private " + defaultResolverDelegateName + typeParameters + " delegate = new " + defaultResolverDelegateName + typeParameters + "();");
	    sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("public " + STRING + " deResolve(" + genClassFinder.getQualifiedInterfaceName(proxyReference.getTypeGenClass()) + " element, " + genClassFinder.getQualifiedInterfaceName(proxyReference.getGenClass()) + " container, " + EReference.class.getName() + " reference) {");
		sc.add("return delegate.deResolve(element, container, reference);");
		sc.add("}");
	    sc.addLineBreak();
	}

	private void addResolveMethod(StringComposite sc) {
		sc.add("public void resolve(" + STRING + " identifier, " + genClassFinder.getQualifiedInterfaceName(proxyReference.getGenClass()) + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<" + genClassFinder.getQualifiedInterfaceName(proxyReference.getTypeGenClass()) + "> result) {");
		sc.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);");
		sc.add("}");
	    sc.addLineBreak();
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptySet();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptySet();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ReferenceResolverGenerator(context);
	}
}
