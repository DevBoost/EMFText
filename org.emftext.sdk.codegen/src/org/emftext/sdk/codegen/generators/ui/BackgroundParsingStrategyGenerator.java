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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DOCUMENT_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.JOB;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STATUS;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class BackgroundParsingStrategyGenerator extends JavaBaseGenerator {

	public BackgroundParsingStrategyGenerator() {
		super();
	}

	private BackgroundParsingStrategyGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.BACKGROUND_PARSING_STRATEGY);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
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
		addParseMethod(sc);
		addCancelMethod(sc);
		
		sc.add("}");
		return true;
	}

	private void addCancelMethod(StringComposite sc) {
		sc.add("protected void canceling() {");
		sc.add("resource.cancelReload();");
		sc.add("}");
		sc.add("};");
		sc.add("job.schedule(DELAY);");
		sc.add("}");
		sc.add("}");
	}

	private void addParseMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Schedules a task for background parsing that will be started after " +
			"a delay."
		);
		sc.add("public void parse(" + DOCUMENT_EVENT + " event, final " + iTextResourceClassName + " resource, final " + editorClassName + " editor) {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final String contents = event.getDocument().get();");
		sc.add("if (contents == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment(
			"this synchronization is needed to avoid the creation " +
			"of multiple tasks. without the synchronization this " +
			"could easily happen, when this method is accessed by " +
			"multiple threads. the creation of multiple tasks would " +
			"imply the multiple background parsing threads for one " +
			"editor are created, which is not desired."
		);
		sc.add("synchronized (lock) {");
		sc.addComment("cancel old task");
		sc.add("if (job != null) {");
		sc.addComment("stop current parser (if there is one)");
		sc.add("job.cancel();");
		sc.add("try {");
		sc.add("job.join();");
		sc.add("} catch (InterruptedException e) {}");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("schedule new task");
		sc.add("job = new " + JOB + "(\"parsing document\") {");
		sc.addLineBreak();
		
		sc.add("protected " + I_STATUS + " run(" + I_PROGRESS_MONITOR + " monitor) {");
		sc.add("try {");
		sc.add("resource.reload(new " + BYTE_ARRAY_INPUT_STREAM + "(contents.getBytes()), null);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("editor.notifyBackgroundParsingFinished();");
		sc.add("return " + STATUS + ".OK_STATUS;");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("private " + JOB + " job;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new BackgroundParsingStrategyGenerator(context);
	}
}
