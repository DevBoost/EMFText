package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DOCUMENT_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.JOB;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class BackgroundParsingStrategyGenerator extends BaseGenerator {

	private String editorClassName;

	public BackgroundParsingStrategyGenerator() {
		super();
	}

	private BackgroundParsingStrategyGenerator(GenerationContext context) {
		super(context, EArtifact.BACKGROUND_PARSING_STRATEGY);
		editorClassName = context.getQualifiedClassName(EArtifact.EDITOR);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A background parsing strategy that starts parsing after a amount of");
		sc.add("// time after the last key stroke. If keys are pressed within the delay");
		sc.add("// interval, the delay is reset. If keys are pressed during background");
		sc.add("// parsing the parse thread is stopped and a new parse task is scheduled.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addParseMethod(sc);
		addCancelMethod(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addCancelMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("protected void canceling() {");
		sc.add("resource.cancelReload();");
		sc.add("}");
		sc.add("};");
		sc.add("job.schedule(DELAY);");
		sc.add("}");
		sc.add("}");
	}

	private void addParseMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Schedules a task for background parsing that will be started after");
		sc.add("// a delay.");
		sc.add("public void parse(" + DOCUMENT_EVENT + " event, final " + getClassNameHelper().getI_TEXT_RESOURCE() + " resource, final " + editorClassName + " editor) {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final String contents = event.getDocument().get();");
		sc.add("if (contents == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("// this synchronization is needed to avoid the creation");
		sc.add("// of multiple tasks. without the synchronization this");
		sc.add("// could easily happen, when this method is accessed by");
		sc.add("// multiple threads. the creation of multiple task would");
		sc.add("// imply the multiple background parsing threads for one");
		sc.add("// editor are created, which is not desired.");
		sc.add("synchronized (lock) {");
		sc.add("// cancel old task");
		sc.add("if (job != null) {");
		sc.add("// stop current parser (if there is one)");
		sc.add("job.cancel();");
		sc.add("try {");
		sc.add("job.join();");
		sc.add("} catch (InterruptedException e) {}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("// schedule new task");
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

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private static long DELAY = 500;");
		sc.addLineBreak();
		sc.add("// this timer is used to schedule a parsing task and execute");
		sc.add("// it after a given delay");
		sc.add("private Object lock = new Object();");
		sc.add("// the background parsing task (may be null)");
		sc.add("private " + JOB + " job;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BackgroundParsingStrategyGenerator(context);
	}
}
