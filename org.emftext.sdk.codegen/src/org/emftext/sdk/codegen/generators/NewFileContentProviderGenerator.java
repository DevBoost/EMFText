package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.util.StreamUtil;
import org.emftext.sdk.util.StringUtil;

public class NewFileContentProviderGenerator extends BaseGenerator {

	private final static GenClassUtil genClassUtil = new GenClassUtil();
	private String mimimalModelHelperClassName;
	private String metaInformationClassName;

	public NewFileContentProviderGenerator() {
		super();
	}
	
	private NewFileContentProviderGenerator(GenerationContext context) {
		super(context, EArtifact.NEW_FILE_CONTENT_PROVIDER);
		mimimalModelHelperClassName = getContext().getQualifiedClassName(EArtifact.MINIMAL_MODEL_HELPER);
		metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addMethods(sc);

		sc.add("}");
		
		out.write(sc.toString());
		out.flush();
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetMetaInformationMethod(sc);
		addGetNewFileContentMethod(sc);
		addGetExampleContentMethod1(sc);
		addGetExampleContentMethod2(sc);
		addGetPrinterMethod(sc);
	}

	private void addGetPrinterMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TEXT_PRINTER() + " getPrinter(" + OutputStream.class.getName() + " outputStream) {");
		sc.add("return new " + getContext().getQualifiedClassName(EArtifact.PRINTER) + "(outputStream, new " + getContext().getQualifiedClassName(EArtifact.RESOURCE) + "());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " getMetaInformation() {");
		sc.add("return new " + metaInformationClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNewFileContentMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		sc.add("public " + STRING + " getNewFileContent(" + STRING + " newFileName) {");
		sc.add("return getExampleContent(new " + E_CLASS + "[] {");
		for (GenClass startSymbol : startSymbols) {
			sc.add(genClassUtil.getAccessor(startSymbol) + ",");
		}
		sc.add("}, getMetaInformation().getClassesWithSyntax(), newFileName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExampleContentMethod2(StringComposite sc) {
		sc.add("protected String getExampleContent(" + E_CLASS + " eClass, " + E_CLASS + "[] allClassesWithSyntax, " + STRING + " newFileName) {");
		sc.add("// create a minimal model");
		sc.add(E_OBJECT + " root = new " + mimimalModelHelperClassName + "().getMinimalModel(eClass, allClassesWithSyntax, newFileName);");
		sc.add("// use printer to get text for model");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " buffer = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add(getClassNameHelper().getI_TEXT_PRINTER() + " printer = getPrinter(buffer);");
		sc.add("try {");
		sc.add("printer.print(root);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"Exception while generating example content.\", e);");
		sc.add("}");
		sc.add("return buffer.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExampleContentMethod1(StringComposite sc) {
		sc.add("protected String getExampleContent(" + E_CLASS + "[] startClasses, " + E_CLASS + "[] allClassesWithSyntax, " + STRING + " newFileName) {");
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		Resource resource = syntax.eResource();
		URI newFileURI = resource.getURI().trimFileExtension().appendFileExtension("newfile").appendFileExtension(syntax.getName());
		String newFileContent = null;
		try {
			InputStream newFileStream = resource.getResourceSet().getURIConverter().createInputStream(newFileURI);
			newFileContent = StreamUtil.getContent(newFileStream);
			// replace platform specific line separators with \n,
			// which will be replaced again by platform specific
			// separators when the new file wizard is called, which
			// may happen on a different platform
			newFileContent = newFileContent.replace("\r\n", "\n");
			newFileContent = newFileContent.replace("\r", "\n");
		} catch (IOException ioe) {
			// do nothing - use the minimal model creator instead
		}
		if (newFileContent != null) {
			sc.add("String content = \"" + StringUtil.escapeToJavaString(newFileContent) + "\".replace(\"\\n\", System.getProperty(\"line.separator\"));");
		} else {
			sc.add("String content = \"\";");
			sc.add("for (" + E_CLASS + " next : startClasses) {");
			sc.add("content = getExampleContent(next, allClassesWithSyntax, newFileName);");
			sc.add("if (content.trim().length() > 0) {");
			sc.add("break;");
			sc.add("}");
			sc.add("}");
		}
		sc.add("return content;");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new NewFileContentProviderGenerator(context);
	}
}
