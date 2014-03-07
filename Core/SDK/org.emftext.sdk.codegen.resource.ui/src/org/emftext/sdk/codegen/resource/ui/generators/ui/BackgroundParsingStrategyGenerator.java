/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.JOB;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DOCUMENT_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class BackgroundParsingStrategyGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String PARSE_METHOD_JAVADOC = "Schedules a task for background parsing that will be started after " +
				"a delay.";

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"A background parsing strategy that starts parsing after a amount of " +
			"time after the last key stroke. If keys are pressed within the delay " +
			"interval, the delay is reset. If keys are pressed during background " +
			"parsing the parse thread is stopped and a new parse task is scheduled."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addParseMethod1(sc);
		addParseMethod2(sc);
		addParseMethod3(sc);
		
		addInnerClassParsingJob(sc);
		
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static long DELAY = 500;");
		sc.addLineBreak();

		sc.addJavadoc(
			"this timer is used to schedule a parsing task and execute " +
			"it after a given delay"
		);
		sc.add("private Object lock = new Object();");
		sc.addLineBreak();
		
		sc.addJavadoc("the background parsing task (may be null)");
		sc.add("private ParsingJob job = null;");
		sc.addLineBreak();
	}

	private void addParseMethod1(JavaComposite sc) {
		sc.addJavadoc(PARSE_METHOD_JAVADOC);
		sc.add("public void parse(" + DOCUMENT_EVENT(sc) + " event, final " + iTextResourceClassName + " resource, final " + editorClassName + " editor) {");
		sc.add("parse(event.getDocument(), resource, editor, DELAY);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod2(JavaComposite sc) {
		sc.addJavadoc(PARSE_METHOD_JAVADOC);
		sc.add("public void parse(" + I_DOCUMENT(sc) + " document, final " + iTextResourceClassName + " resource, final " + editorClassName + " editor, long delay) {");
		sc.add("parse(document.get(), resource, editor, delay);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod3(JavaComposite sc) {
		sc.addJavadoc(PARSE_METHOD_JAVADOC);
		sc.add("public void parse(final String contents, final " + iTextResourceClassName + " resource, final " + editorClassName + " editor, long delay) {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (contents == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment(
			"this synchronization is needed to avoid the creation " +
			"of multiple tasks. without the synchronization this " +
			"could easily happen, when this method is accessed by " +
			"multiple threads. the creation of multiple tasks would " +
			"imply that multiple background parsing threads for one " +
			"editor are created, which is not desired."
		);
		sc.add("synchronized (lock) {");
		sc.add("if (job == null || job.getState() != " + JOB(sc) + ".RUNNING) {");
		sc.addComment("schedule new task");
		sc.add("job = new ParsingJob();");
		sc.add("job.resource = resource;");
		sc.add("job.editor = editor;");
		sc.add("job.newContents = contents;");
		sc.add("job.schedule();");
		sc.add("} else {");
		sc.add("job.newContents = contents;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addInnerClassParsingJob(JavaComposite sc) {
		sc.add("private class ParsingJob extends " + JOB(sc) + " {");
		sc.add("private " + editorClassName + " editor;");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.addLineBreak();
		sc.add("public ParsingJob() {");
		sc.add("super(\"parsing document\");");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String newContents = null;");
		sc.addLineBreak();	
		sc.add("protected " + I_STATUS(sc) + " run(" + I_PROGRESS_MONITOR(sc) + " monitor) {");
		sc.add("while (newContents != null ) {");
		sc.add("while (newContents != null) {");
		sc.add("try {");
		sc.add("String currentContent = newContents;");
		sc.add("newContents = null;");
		sc.add("String encoding = null;");
		sc.add("if (resource instanceof " + textResourceClassName + ") {");
		sc.add(textResourceClassName + " concreteResource = (" + textResourceClassName + ") resource;");
		// TODO we should pass the load options here
		sc.add("encoding = concreteResource.getEncoding(null);");
		sc.add("}");
		sc.add("byte[] bytes = null;");
		sc.add("if (encoding != null) {");
		sc.add("bytes = currentContent.getBytes(encoding);");
		sc.add("} else {");
		sc.add("bytes = currentContent.getBytes();");
		sc.add("}");
		sc.add("resource.reload(new " + BYTE_ARRAY_INPUT_STREAM(sc) + "(bytes), null);");
		sc.add("if (newContents != null) {");
		sc.add("Thread.sleep(DELAY);");
		sc.add("}");
		sc.add("} catch (java.lang.Exception e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("editor.notifyBackgroundParsingFinished();");
		sc.add("}");
		sc.add("return " + STATUS(sc) + ".OK_STATUS;");
		sc.add("}");
		sc.add("};");
		sc.addLineBreak();
	}
}
