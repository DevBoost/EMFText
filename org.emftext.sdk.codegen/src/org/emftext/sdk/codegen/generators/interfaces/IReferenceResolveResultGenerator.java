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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IReferenceResolveResultGenerator extends JavaBaseGenerator {

	private String iReferenceMappingClassName;

	public IReferenceResolveResultGenerator() {
		super();
	}

	private IReferenceResolveResultGenerator(GenerationContext context) {
		super(context, EArtifact.I_REFERENCE_RESOLVE_RESULT);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IReferenceResolveResultGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// The result of a single attempt to resolve an identifier. The");
		sc.add("// result can either be successful (identifier was resolved to one");
		sc.add("// or more objects) or failed (identifier was not resolved). In");
		sc.add("// the case of failure, the result provides an error message.");
		sc.add("//");
		sc.add("// This interface must not be implemented by clients.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the references that can be contained in this result");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.add("// Returns the error message that describes what went wrong while");
		sc.add("// resolving a reference.");
		sc.add("public String getErrorMessage();");
		sc.addLineBreak();
		
		sc.add("// Sets the error message that describes what went wrong while");
		sc.add("// resolving a reference. If a mapping for the reference was");
		sc.add("// already found (i.e., addMapping() was called before), the");
		sc.add("// call to this method is ignored. If addMapping() is called");
		sc.add("// afterwards, the error message is also discarded.");
		sc.add("//");
		sc.add("// @param message the error that prevented resolving the reference");
		sc.add("public void setErrorMessage(String message);");
		sc.addLineBreak();
		
		sc.add("// Adds a mapping from the given identifier to the given object.");
		sc.add("// Adding such a mapping means that the identifier was resolved");
		sc.add("// to reference the target object.");
		sc.add("// Previous errors as well as future ones will be discarded. Once");
		sc.add("// a mapping is found, resolve errors have no meaning any more.");
		sc.add("//");
		sc.add("// The target object can be null if the resolution is fuzzy.");
		sc.add("// Otherwise target must not be null and implementations of");
		sc.add("// this method can throw an IllegalArgumentException if this");
		sc.add("// rule is violated.");
		sc.add("//");
		sc.add("// Optionally a warning can be passed to this method if resolving");
		sc.add("// the reference was successful, but not accurate.");
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning);");
		sc.addLineBreak();
		
		sc.add("// @see addMapping(String, ReferenceType, String)");
		sc.add("public void addMapping(String identifier, ReferenceType target);");
		sc.addLineBreak();
		
		sc.add("// Adds a mapping from the given identifier to another identifier.");
		sc.add("// This is useful for multilevel resolving where internal identifiers");
		sc.add("// are replace by external ones depending on the context. Usually");
		sc.add("// the external identifiers are replaced by target object later on.");
		sc.add("//");
		sc.add("// Optionally a warning can be passed to this method if resolving");
		sc.add("// the reference was successful, but not accurate.");
		sc.add("//");
		sc.add("// @param identifier");
		sc.add("// @param newIdentifier");
		sc.add("public void addMapping(String identifier, " + URI + " newIdentifier, String warning);");
		sc.addLineBreak();
		
		sc.add("// @see addMapping(String, " + URI + ", String)");
		sc.add("public void addMapping(String identifier, " + URI + " newIdentifier);");
		sc.addLineBreak();
		
		sc.add("// Indicates the type of the result. Depending on the type of");
		sc.add("// the result different information is available (e.g., the");
		sc.add("// error message is only set if the resolve operation failed).");
		sc.add("//");
		sc.add("// @return");
		sc.add("public boolean wasResolved();");
		sc.addLineBreak();
		
		sc.add("// Indicates the type of the result. Depending on the type of");
		sc.add("// the result different information is available (e.g., the");
		sc.add("// unique mapping is only set if the resolve operation returned");
		sc.add("// a unique result).");
		sc.add("//");
		sc.add("// @return");
		sc.add("public boolean wasResolvedUniquely();");
		sc.addLineBreak();
		
		sc.add("// Indicates the type of the result. Depending on the type of");
		sc.add("// the result different information is available (e.g., the");
		sc.add("// multiple mappings are only set if the resolve operation returned");
		sc.add("// multiple result).");
		sc.add("//");
		sc.add("// @return");
		sc.add("public boolean wasResolvedMultiple();");
		sc.addLineBreak();
		
		sc.add("// Returns all mappings that were found while resolving an");
		sc.add("// identifier.");
		sc.add("public " + COLLECTION + "<" + iReferenceMappingClassName + "<ReferenceType>> getMappings();");
		sc.add("}");
		return true;
	}
}
