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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IReferenceResolveResultGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The result of a single attempt to resolve an identifier. The " +
			"result can either be successful (identifier was resolved to one " +
			"or more objects) or failed (identifier was not resolved). In " +
			"the case of failure, the result provides an error message.",
			"This interface must not be implemented by clients.",
			"@param <ReferenceType> the type of the references that can be contained in this result"
		);
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the error message that describes what went wrong while resolving a reference.");
		sc.add("public String getErrorMessage();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns an unmodifiable collection of the quick fixes that can be used to resolve the resolving error.");
		sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes();");
		sc.addLineBreak();
		
		sc.addJavadoc("Adds a quick fix to the set of quick fixes that can be used to resolve the resolving error.");
		sc.add("public void addQuickFix(" + iQuickFixClassName + " quickFix);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Sets the error message that describes what went wrong while " +
			"resolving a reference. If a mapping for the reference was " +
			"already found (i.e., addMapping() was called before), the " +
			"call to this method is ignored. If addMapping() is called " +
			"afterwards, the error message is also discarded.",
			"@param message the error that prevented resolving the reference"
		);
		sc.add("public void setErrorMessage(String message);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Adds a mapping from the given identifier to the given object. " +
			"Adding such a mapping means that the identifier was resolved " +
			"to reference the target object. " +
			"Previous errors as well as future ones will be discarded. Once " +
			"a mapping is found, resolve errors have no meaning any more.",
			"The target object can be null if the resolution is fuzzy. " +
			"Otherwise target must not be null and implementations of " +
			"this method can throw an IllegalArgumentException if this " +
			"rule is violated.",
			"Optionally a warning can be passed to this method if resolving " +
			"the reference was successful, but not accurate."
		);
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning);");
		sc.addLineBreak();
		
		sc.addJavadoc("@see addMapping(String, ReferenceType, String)");
		sc.add("public void addMapping(String identifier, ReferenceType target);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Adds a mapping from the given identifier to another identifier. " +
			"This is useful for multilevel resolving where internal identifiers " +
			"are replaced by external ones depending on the context. Usually " +
			"the external identifiers are replaced by target object later on.",
			"Optionally a warning can be passed to this method if resolving " +
			"reference was successful, but not accurate.",
			"@param identifier",
			"@param newIdentifier");
		sc.add("public void addMapping(String identifier, " + URI + " newIdentifier, String warning);");
		sc.addLineBreak();
		
		sc.addJavadoc("@see addMapping(String, " + URI + ", String)");
		sc.add("public void addMapping(String identifier, " + URI + " newIdentifier);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Indicates the type of the result. Depending on the type of " +
			"the result different information is available (e.g., the " +
			"error message is only set if the resolve operation failed).",
			"@return true if the reference was successfully resolved"
		);
		sc.add("public boolean wasResolved();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Indicates the type of the result. Depending on the type of " +
			"the result different information is available (e.g., the " +
			"unique mapping is only set if the resolve operation returned " +
			"a unique result).",
			"@return true if the reference was resolved to exactly one target object");
		sc.add("public boolean wasResolvedUniquely();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Indicates the type of the result. Depending on the type of " +
			"the result different information is available (e.g., the " +
			"multiple mappings are only set if the resolve operation returned " +
			"multiple result).\n\n"+
			"@return true the reference was resolved to more than one target object");
		sc.add("public boolean wasResolvedMultiple();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns all mappings that were found while resolving an identifier.");
		sc.add("public " + COLLECTION + "<" + iReferenceMappingClassName + "<ReferenceType>> getMappings();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
