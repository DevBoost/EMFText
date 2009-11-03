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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ITextResourceGenerator extends BaseGenerator {

	private String iTextResourcePluginPartClassName;
	private String iLocationMapClassName;
	private String iProblemClassName;
	private String iContextDependentURIFragmentFactoryClassName;

	public ITextResourceGenerator() {
		super();
	}

	private ITextResourceGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_RESOURCE);
		iTextResourcePluginPartClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE_PLUGIN_PART);
		iLocationMapClassName = getContext().getQualifiedClassName(EArtifact.I_LOCATION_MAP);
		iProblemClassName = getContext().getQualifiedClassName(EArtifact.I_PROBLEM);
		iContextDependentURIFragmentFactoryClassName = getContext().getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextResourceGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An extended resource that can hold information about the exact positions");
		sc.add("// of each element of its content in a text file. This can be used to give");
		sc.add("// more detailed error feedback.");
		sc.add("//");
		sc.add("public interface " + getResourceClassName() + " extends " + RESOURCE + ", " + iTextResourcePluginPartClassName + " {");
		sc.addLineBreak();
		
		sc.add("// Try to load the content of this resource from the given stream. If");
		sc.add("// loading fails, the state of this resource is kept. If loading is");
		sc.add("// successful, the content of this resource is replaced with the new");
		sc.add("// content.");
		sc.add("// This method can be used to try loading erroneous files, as e.g.,");
		sc.add("// needed during background parsing in the editor.");
		sc.add("//");
		sc.add("// @param stream the stream to read from");
		sc.add("// @param options the load options to use");
		sc.add("// @throws " + IO_EXCEPTION + " thrown if the stream can not be read");
		sc.add("public void reload(" + INPUT_STREAM + " stream, " + MAP + "<?,?> options) throws " + IO_EXCEPTION + ";");
		sc.addLineBreak();
		
		sc.add("// Try to cancel a current reload of this resource. It is not guaranteed");
		sc.add("// that canceling is successful. If this resource has already finished");
		sc.add("// parsing the new content, it will replace its content unconditionally.");
		sc.add("public void cancelReload();");
		sc.addLineBreak();
		
		sc.add("// Returns a map containing information about the location of model");
		sc.add("// elements in the text.");
		sc.add("//");
		sc.add("// @return the model element to text location mapping");
		sc.add("public " + iLocationMapClassName + " getLocationMap();");
		sc.addLineBreak();
		
		sc.add("// Add an error that should be displayed at the position of the given element.");
		sc.add("public void addProblem(" + iProblemClassName + " problem, " + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("// Add an error to be displayed at the indicated position.");
		sc.add("public void addProblem(" + iProblemClassName + " problem, int column, int line, int charStart, int charEnd);");
		sc.addLineBreak();
		
		sc.add("// Internal method used by the parser to register a context dependent proxy object for later resolution.");
		sc.add("//");
		sc.add("// @param container");
		sc.add("// @param reference");
		sc.add("// @param pos");
		sc.add("// @param id");
		sc.add("// @param proxyElement");
		sc.add("public <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" + iContextDependentURIFragmentFactoryClassName + "<ContainerType, ReferenceType> factory, ContainerType container, " + E_REFERENCE +" reference, " + STRING + " id, " + E_OBJECT + " proxyElement);");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
