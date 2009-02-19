package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.util.JavaStringComposite;
import org.emftext.sdk.codegen.util.StringComposite;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	private GenFeature proxyReference;

	public ReferenceResolverGenerator(GenerationContext context, GenFeature proxyReference) {
		super(context.getResolverPackageName(), context.getReferenceResolverClassName(proxyReference));
		this.proxyReference = proxyReference;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaStringComposite();
	    sc.add("package " + getResourcePackageName() + ";");	
	    sc.addLineBreak();
	    sc.add("public class " + getResourceClassName() + " extends " + AbstractReferenceResolver.class.getName() + "<" + proxyReference.getGenClass().getQualifiedInterfaceName() + "> {");

	    sc.addLineBreak();
	    generateDoDeResolveMethod(sc);
	    
	    sc.addLineBreak();
		generateDoResolveMethod(sc);

		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void generateDoDeResolveMethod(StringComposite sc) {
		sc.add("@Override");
	    sc.addLineBreak();
		sc.add("protected " + String.class.getName() + " doDeResolve(" + EObject.class.getName() + " element, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference) {");
		sc.add("return super.doDeResolve(element, container, reference);");
		sc.add("}");
	}

	private void generateDoResolveMethod(StringComposite sc) {
		sc.add("@Override");
	    sc.addLineBreak();
		sc.add("protected void doResolve(" + String.class.getName() + " identifier, " + proxyReference.getGenClass().getQualifiedInterfaceName() + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + IReferenceResolveResult.class.getName() + " result) {");
		sc.add("super.doResolve(identifier, container, reference, position, resolveFuzzy, result);");
		sc.add("}");
	}
}
