/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RECOGNITION_EXCEPTION;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;

public class UnexpectedContentTypeExceptionGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new UnexpectedContentTypeExceptionGenerator());

	private UnexpectedContentTypeExceptionGenerator() {
		super();
	}

	private UnexpectedContentTypeExceptionGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new UnexpectedContentTypeExceptionGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"An Excpetion to represent invalid content types for parser instances.",
			"@see " + iOptionsClassName + ".RESOURCE_CONTENT_TYPE"
		);
		sc.add("public class " + getResourceClassName() + " extends " + RECOGNITION_EXCEPTION + "{");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addGetContentTypeMethod(sc);
		sc.add("}");
	}

	private void addGetContentTypeMethod(JavaComposite sc) {
		sc.add("public Object getContentType() {");
		sc.add("return contentType;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public  " + getResourceClassName() + "(Object contentType) {");
		sc.add("this.contentType = contentType;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static final long serialVersionUID = 4791359811519433999L;");
		sc.addLineBreak();
		sc.add("private Object contentType = null;");
		sc.addLineBreak();
	}
}
