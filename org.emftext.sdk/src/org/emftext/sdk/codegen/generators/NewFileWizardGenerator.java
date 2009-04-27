package org.emftext.sdk.codegen.generators;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * The NewFileContentGenerator can be used to create a NewFileWizard that 
 * creates a minimal sample file from a concrete syntax when it is invoked.
 * 
 * TODO mseifert: check whether we can create the minimal model and thus
 * the example document at generation time instead of runtime. As the model
 * instantiation is performed using reflection the code for the meta model
 * should not be needed.
 */
public class NewFileWizardGenerator implements IGenerator {
	
	private final static GeneratorUtil helper = new GeneratorUtil();
	
	private GenerationContext context;

	public NewFileWizardGenerator(GenerationContext context) {
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + context.getPackageName() + ";");
		sc.add("public class " + context.getNewFileActionClassName() + " extends " + AbstractNewFileWizard.class.getName() + " {");
		sc.addLineBreak();
		
		sc.add("public String getFileExtension() {");
		ConcreteSyntax syntax = context.getConcreteSyntax();
		sc.add("return \"" + syntax.getName() + "\";");
		sc.add("}");
		sc.addLineBreak();

		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		Collection<GenClass> classesWithSyntax = helper.getClassesWithSyntax(syntax);

		sc.add("public String getExampleContent() {");
		sc.add("return getExampleContent(new " + EClass.class.getName() + "[] {");
		for (GenClass startSymbol : startSymbols) {
			sc.add(getAccessor(startSymbol) + ",");
		}
		sc.add("}, new " + EClass.class.getName() + "[] {");
		for (GenClass startSymbol : classesWithSyntax) {
			sc.add(getAccessor(startSymbol) + ",");
		}
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + ITextPrinter.class.getName() + " getPrinter(" + OutputStream.class.getName() + " outputStream) {");
		sc.add("return new " + context.getQualifiedPrinterName() + "(outputStream, new " + context.getResourceClassName() + "());");
		sc.add("}");

		sc.add("}");
		
		out.write(sc.toString());
		out.flush();
		return true;
	}

	private String getAccessor(GenClass startSymbol) {
		return startSymbol.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + startSymbol.getClassifierAccessorName() + "()";
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return new ArrayList<GenerationProblem>();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return new ArrayList<GenerationProblem>();
	}
}
