/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IContextDependentURIFragmentGenerator extends BaseGenerator {

	private String iReferenceResolveResultClassName;

	public IContextDependentURIFragmentGenerator() {
		super();
	}

	private IContextDependentURIFragmentGenerator(GenerationContext context) {
		super(context, EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
		iReferenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVE_RESULT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IContextDependentURIFragmentGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An <code>IContextDependentURIFragment</code> points at an element");
		sc.add("// referenced from another element throughan  <code>identifier</code>.");
		sc.add("// In contrast to a normal EMF URI fragment (<code>URI.fragment</code>),");
		sc.add("// which is a String that can be resolved to an element within a");
		sc.add("// <code>Resource</code>, the <code>identifier</code> of a");
		sc.add("// <code>IContextDependentURIFragment</code> does not have");
		sc.add("// to be globally unique.");
		sc.add("// <p>");
		sc.add("// An <code>IContextDependentURIFragment</code> is registered");
		sc.add("// a <code>ITextResource</code> for a proxy for which it defines the URI fragment.");
		sc.add("// <code>ITextResource.getEObject()</code> uses the");
		sc.add("// <code>IContextDependentURIFragment.resolve()</code> instead of the normal");
		sc.add("// <code>URI.fragment</code>-based resolving when an");
		sc.add("// <code>IContextDependentURIFragment.resolve()</code> is available.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference that can be resolved by this fragment");
		sc.add("//");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType extends " + E_OBJECT + "> {");
		sc.addLineBreak();
		
		sc.add("// A prefix that can be used in a <code>URI.fragment</code> String of a proxy");
		sc.add("// to indicate the existence of an <code>IContextDependentURIFragment</code>.");
		
		sc.add("public static final String INTERNAL_URI_FRAGMENT_PREFIX = \"EMFTEXT_INTERNAL_URI_FRAGMENT_\";");
		sc.addLineBreak();
		
		sc.add("// @return The proxy object.");
		sc.add("public " + E_OBJECT + " getProxy();");
		sc.addLineBreak();
		
		sc.add("// @return An identifier that identifies the element(s) at which the proxy points in context.");
		sc.add("public String getIdentifier();");
		sc.addLineBreak();
		
		sc.add("// @return The element that references the proxy.");
		sc.add("public " + E_OBJECT + " getContainer();");
		sc.addLineBreak();
		
		sc.add("// @return The references of the container's <code>EClass</code> that holds the proxy.");
		sc.add("public " + E_REFERENCE + " getReference();");
		sc.addLineBreak();
		
		sc.add("// @return The position if reference is multiple; -1 otherwise.");
		sc.add("public int getPositionInReference();");
		sc.addLineBreak();
		
		sc.add("// Resolves the proxy to the real element(s) using context information.");
		sc.add("//");
		sc.add("// @return result of resolving process");
		
		sc.add("public " + iReferenceResolveResultClassName + "<ReferenceType> resolve();");
		sc.addLineBreak();
		
		sc.add("// @return <code>true</code> if <code>resolve()</code> was called successfully before.");
		sc.add("public boolean isResolved();");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}
