/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IContextDependentURIFragmentGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"An <code>IContextDependentURIFragment</code> points at an element " +
			"referenced from another element through an <code>identifier</code>. " +
			"In contrast to a normal EMF URI fragment (<code>URI.fragment</code>), " +
			"which is a String that can be resolved to an element within a " +
			"<code>Resource</code>, the <code>identifier</code> of a " +
			"<code>IContextDependentURIFragment</code> does not have " +
			"to be globally unique.",
			"<p>",
			"An <code>IContextDependentURIFragment</code> is registered " +
			"a <code>ITextResource</code> for a proxy for which it defines the URI fragment." +
			"<code>ITextResource.getEObject()</code> uses the" +
			"<code>IContextDependentURIFragment.resolve()</code> instead of the normal" +
			"<code>URI.fragment</code>-based resolving when an" +
			"<code>IContextDependentURIFragment.resolve()</code> is available.",
			"@param <ReferenceType> the type of the reference that can be resolved by this fragment"
		);
		sc.add("public interface " + getResourceClassName() + "<ReferenceType extends " + E_OBJECT + "> {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A prefix that can be used in a <code>URI.fragment</code> String of a proxy " +
			"to indicate the existence of an <code>IContextDependentURIFragment</code>."
		);
		sc.add("public static final String INTERNAL_URI_FRAGMENT_PREFIX = \"EMFTEXT_INTERNAL_URI_FRAGMENT_\";");
		sc.addLineBreak();
		
		sc.addJavadoc("@return The proxy object.");
		sc.add("public " + E_OBJECT + " getProxy();");
		sc.addLineBreak();
		
		sc.addJavadoc("@return An identifier that identifies the element(s) at which the proxy points in context.");
		sc.add("public String getIdentifier();");
		sc.addLineBreak();
		
		sc.addJavadoc("@return The element that references the proxy.");
		sc.add("public " + E_OBJECT + " getContainer();");
		sc.addLineBreak();
		
		sc.addJavadoc("@return The references of the container's <code>EClass</code> that holds the proxy.");
		sc.add("public " + E_REFERENCE + " getReference();");
		sc.addLineBreak();
		
		sc.addJavadoc("@return The position if reference is multiple; -1 otherwise.");
		sc.add("public int getPositionInReference();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Resolves the proxy to the real element(s) using context information.",
			"@return result of resolving process"
		);
		sc.add("public " + iReferenceResolveResultClassName + "<ReferenceType> resolve();");
		sc.addLineBreak();
		
		sc.addJavadoc("@return <code>true</code> if <code>resolve()</code> was called successfully before.");
		sc.add("public boolean isResolved();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
