package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaStringComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GeneratorUtil;

/**
 * A generator that creates a multiplexing reference resolver.
 * Depending on the type of the reference that must be resolved,
 * the generated class delegates the resolve call to the appropriate
 * reference resolver.
 */
public class ReferenceResolverSwitchGenerator extends BaseGenerator {
	
	private final GenerationContext context;
	
	/**
	 * 
	 * 
	 * @param context
	 */
	public ReferenceResolverSwitchGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getReferenceResolverSwitchClassName());
		this.context = context;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		out.print(generateReferenceResolverSwitch());
		return true;
	}
	
	 /**
     * Generates the reference resolver switch that calls the correct
     * reference resolvers generated by <code>generateReferenceResolver()</code>.
     */
    private String generateReferenceResolverSwitch()  {  
    	StringComposite sc = new JavaStringComposite();
        sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " implements " + IReferenceResolverSwitch.class.getName() + " {");
        sc.addLineBreak();
		
		generateFields(sc);
		generateResolveMethod(sc);
		generateResolveStrictMethod(sc);   
		generateDeResolveMethod(sc);   
        generateSetOptionsMethod(sc);
		generateResolveFuzzyMethod(sc);
		
		sc.add("}");
		
    	return sc.toString();	
    }

	private void generateResolveFuzzyMethod(StringComposite sc) {
		sc.add("public void resolveFuzzy(" + String.class.getName() + " identifier, " + EObject.class.getName() + " container, int position, " + IReferenceResolveResult.class.getName() + " result) {");
		for (GenFeature proxyReference : context.getNonContainmentReferences()) {
			GenClass genClass = proxyReference.getGenClass();
			String accessorName = genClass.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get"  + genClass.getName() + "()";
			String generatedClassName = context.getReferenceResolverClassName(proxyReference);
			GenFeature genFeature = GeneratorUtil.findGenFeature(genClass, proxyReference.getName());
			sc.add("if (" + accessorName+ ".isInstance(container)) {");
			sc.add(org.eclipse.emf.ecore.EStructuralFeature.class.getName() + " feature = container.eClass()." + GeneratorUtil.createGetFeatureCall(genClass, genFeature) + ";");
			sc.add("if (feature instanceof " + org.eclipse.emf.ecore.EReference.class.getName() + ") {");
			sc.add(low(generatedClassName) + ".resolve(identifier, (" + genClass.getQualifiedInterfaceName() + ") container, (" + org.eclipse.emf.ecore.EReference.class.getName() + ") feature, position, true, result);");
			sc.add("}");
			sc.add("}");
		}
		sc.add("}");
	}

	private void generateSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + java.util.Map.class.getName() + "<?, ?> options) {");
		for (GenFeature proxyReference : context.getNonContainmentReferences()) {
			String generatedClassName = context.getReferenceResolverClassName(proxyReference);
			sc.add(low(generatedClassName) + ".setOptions(options);");			
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateDeResolveMethod(StringComposite sc) {
		sc.add("public " + String.class.getName() + " deResolve(" + EObject.class.getName() + " refObject, " + EObject.class.getName() + " container, " + EReference.class.getName() + " reference) {");
		for(GenFeature proxyReference : context.getNonContainmentReferences()) {
			String generatedClassName = context.getReferenceResolverClassName(proxyReference);
			final GenClass genClass = proxyReference.getGenClass();
			String genClassName = genClass.getQualifiedInterfaceName();
			String featureID = GeneratorUtil.getFeatureConstant(genClass, GeneratorUtil.findGenFeature(genClass, proxyReference.getName()));
			sc.add("if (container instanceof " + genClassName + " && reference.getFeatureID() == " + featureID + ") {");		
			sc.add("return " + low(generatedClassName)+".deResolve(refObject, (" + genClassName + ") container, reference);");			
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateResolveStrictMethod(StringComposite sc) {
		sc.add("public void resolveStrict(" + String.class.getName() + " identifier, " + EObject.class.getName() + " container, " + EReference.class.getName() + " reference, int position, " + IReferenceResolveResult.class.getName() + " result) {");		
		for(GenFeature proxyReference : context.getNonContainmentReferences()) {
			String generatedClassName = context.getReferenceResolverClassName(proxyReference);
			GenClass genClass = proxyReference.getGenClass();
			String featureID = GeneratorUtil.getFeatureConstant(genClass, GeneratorUtil.findGenFeature(genClass, proxyReference.getName()));
			final String genClassName = genClass.getQualifiedInterfaceName();
			sc.add("if (container instanceof " + genClassName + " && reference.getFeatureID() == " + featureID + ") {");
			sc.add(low(generatedClassName) + ".resolve(identifier, (" + genClassName + ") container, reference, position, false, result);");
			sc.add("return;");
			sc.add("}");			
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateResolveMethod(StringComposite sc) {
		sc.add("public void resolve(" + String.class.getName() + " identifier, " + EObject.class.getName() + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + IReferenceResolveResult.class.getName() + " result) {");
		sc.add("if (resolveFuzzy) {");
		sc.add("resolveFuzzy(identifier, container, position, result);");
		sc.add("} else {");
		sc.add("resolveStrict(identifier, container, reference, position, result);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateFields(StringComposite sc) {
    	List<String> generatedResolvers = new ArrayList<String>();

		for (GenFeature proxyReference : context.getNonContainmentReferences()) {
			String generatedClassName = context.getReferenceResolverClassName(proxyReference);
			if (!generatedResolvers.contains(generatedClassName)) {
				generatedResolvers.add(generatedClassName);
				String fullClassName = context.getResolverPackageName(proxyReference) + "." + generatedClassName;
				sc.add("protected " + fullClassName + " " + low(generatedClassName) + " = new " + fullClassName + "();");			
			}
		}
	    sc.addLineBreak();
	}
}
