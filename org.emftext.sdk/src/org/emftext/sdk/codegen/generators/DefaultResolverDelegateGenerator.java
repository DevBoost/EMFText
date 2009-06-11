package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class DefaultResolverDelegateGenerator extends BaseGenerator {

	private static final String INTERNAL_E_OBJECT = InternalEObject.class.getName();
	private static final String I_CONTEXT_DEPENDENT_URI_FRAGMENT = IContextDependentURIFragment.class.getName();
	private static final String E_OPERATION = EOperation.class.getName();
	private static final String E_ATTRIBUTE = EAttribute.class.getName();
	private static final String E_STRUCTURAL_FEATURE = EStructuralFeature.class.getName();
	private static final String RUNTIME_EXCEPTION = RuntimeException.class.getName();
	private static final String ITERATOR = Iterator.class.getName();
	private static final String E_OBJECT_UTIL = EObjectUtil.class.getName();
	private static final String I_REFERENCE_RESOLVE_RESULT = IReferenceResolveResult.class.getName();
	private static final String E_REFERENCE = EReference.class.getName();
	private static final String STRING = String.class.getName();
	private static final String E_OBJECT = EObject.class.getName();
	private static final String E_CLASS = EClass.class.getName();
	private static final String I_TEXT_RESOURCE = ITextResource.class.getName();
	private static final String OBJECT = Object.class.getName();

	public DefaultResolverDelegateGenerator(GenerationContext context) {
		super(context.getResolverPackageName(), context.getDefaultResolverDelegateName());
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> {");

		addFields(sc);
		addResolveMethod(sc);
		addCheckElementMethod(sc);
		addCastMethod(sc);
		addProduceDeResolveErrorMessage(sc);
		addDeResolveMethod(sc);
		addMatchesMethod1(sc);
		addMatchesMethod2(sc);
		addGetNameMethod(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addGetNameMethod(StringComposite sc) {
		sc.add("private " + STRING + " getName(ReferenceType element) {");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if(element.eIsProxy()) {");
		sc.add(STRING + " fragment = ((" + INTERNAL_E_OBJECT + ") element).eProxyURI().fragment();");
		sc.add("if (fragment != null && fragment.startsWith(" + I_CONTEXT_DEPENDENT_URI_FRAGMENT + ".INTERNAL_URI_FRAGMENT_PREFIX)) {");
		sc.add("fragment = fragment.substring(" + I_CONTEXT_DEPENDENT_URI_FRAGMENT + ".INTERNAL_URI_FRAGMENT_PREFIX.length());");
		sc.add("}");
		sc.add("return fragment;");
		sc.add("}");
		sc.add("else if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add("return (" + STRING + ") element.eGet(nameAttr);");
		sc.add("} else {");
		sc.add("//try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " strAttribute : element.eClass().getEAllAttributes()) {");
		sc.add("if (!strAttribute.isMany() &&");
		sc.add("strAttribute.getEType().getInstanceClassName().equals(" + STRING + ".class.getName())) {");
		sc.add("return (" + STRING + ") element.eGet(strAttribute);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + E_OPERATION + " o : element.eClass().getEAllOperations()) {");
		sc.add("if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {");
		sc.add(STRING + " result = (" + STRING + ") " + E_OBJECT_UTIL + ".invokeOperation(element, o);");
		sc.add("if (result != null) {");
		sc.add("return result;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod2(StringComposite sc) {
		sc.add("private " + STRING + " matches(" + STRING + " identifier, " + OBJECT + " attributeValue, boolean matchFuzzy) {");
		sc.add("if (attributeValue != null && attributeValue instanceof " + STRING + ") {");
		sc.add(STRING + " name = (" + STRING + ") attributeValue;");
		sc.add("if (name.startsWith(identifier) && matchFuzzy) {");
		sc.add("return name;");
		sc.add("}");
		sc.add("if (name.equals(identifier)) {");
		sc.add("return identifier;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod1(StringComposite sc) {
		sc.add("private " + STRING + " matches(" + E_OBJECT + " element, " + STRING + " identifier, boolean matchFuzzy) {");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add(OBJECT + " attributeValue = element.eGet(nameAttr);");
		sc.add("return matches(identifier, attributeValue, matchFuzzy);");
		sc.add("} else {");
		sc.add("//try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " stringAttribute : element.eClass().getEAllAttributes()) {");
		sc.add("if (stringAttribute.getEType().getInstanceClassName().equals(" + STRING + ".class.getName())) {");
		sc.add(OBJECT + " attributeValue = element.eGet(stringAttribute);");
		sc.add(STRING + " match = matches(identifier, attributeValue, matchFuzzy);");
		sc.add("if (match != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("");
		sc.add("for (" + E_OPERATION + " o : element.eClass().getEAllOperations()) {");
		sc.add("if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {");
		sc.add(STRING + " result = (" + STRING + ") " + E_OBJECT_UTIL + ".invokeOperation(element, o);");
		sc.add(STRING + " match = matches(identifier, result, matchFuzzy);");
		sc.add("if (match != null) {");
		sc.add("return match;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("protected " + STRING + " deResolve(ReferenceType element, ContainerType container, " + E_REFERENCE + " reference) {");
		sc.add("return getName(element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addProduceDeResolveErrorMessage(StringComposite sc) {
		sc.add("protected " + STRING + " produceDeResolveErrorMessage(" + E_OBJECT + " refObject, " + E_OBJECT + " container, " + E_REFERENCE + " reference, " + I_TEXT_RESOURCE + " resource) {");
		sc.add(STRING + " msg = getClass().getSimpleName() + \": \" + reference.getEType().getName() + \" \\\"\" + refObject.toString() + \"\\\" not de-resolveable\";");
		sc.add("return msg;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCastMethod(StringComposite sc) {
		sc.add("// This method encapsulates an unchecked cast from EObject to");
		sc.add("// ReferenceType. We can not do this cast strictly type safe,");
		sc.add("// because type parameters are erased by compilation. Thus, an");
		sc.add("// instanceof check can not be performed at runtime.");
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.addLineBreak();
		sc.add("private ReferenceType cast(" + E_OBJECT + " element) {");
		sc.add("return (ReferenceType) element;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCheckElementMethod(StringComposite sc) {
		sc.add("private boolean checkElement(" + E_OBJECT + " element, " + E_CLASS + " type, " + STRING + " identifier, boolean resolveFuzzy, " + I_REFERENCE_RESOLVE_RESULT + "<ReferenceType> result) {");
		sc.add("if (element.eIsProxy()) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(E_CLASS + " eClass = element.eClass();");
		sc.add("boolean hasCorrectType = eClass.equals(type) || eClass.getEAllSuperTypes().contains(type);");
		sc.add("if (!hasCorrectType) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("final " + STRING + " match = matches(element, identifier, resolveFuzzy);");
		sc.add("if (match == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("// we can safely cast 'element' to 'ReferenceType' here,");
		sc.add("// because we've checked the type of 'element' against");
		sc.add("// the type of the reference. unfortunately the compiler");
		sc.add("// does not know that this is sufficient, so we must call");
		sc.add("// cast(), which is not type safe by itself.");
		sc.add("result.addMapping(match, cast(element));");
		sc.add("if (!resolveFuzzy) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveMethod(StringComposite sc) {
		sc.add("// This standard implementation searches the tree for objects of the ");
		sc.add("// correct type with a name attribute matching the identifier.");
		sc.add("protected void resolve(" + STRING + " identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + I_REFERENCE_RESOLVE_RESULT + "<ReferenceType> result) {");
		sc.add("try {");
		sc.add(E_CLASS + " type = reference.getEReferenceType();");
		sc.add(E_OBJECT + " root = " + E_OBJECT_UTIL + ".findRootContainer(container);");
		sc.add("// first check whether the root element matches");
		sc.add("boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("// then check the contents");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> iterator = root.eAllContents(); iterator.hasNext(); ) {");
		sc.add(E_OBJECT + " element = iterator.next();");
		sc.add("continueSearch = checkElement(element, type, identifier, resolveFuzzy, result);");
		sc.add("if (!continueSearch) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + RUNTIME_EXCEPTION + " rte) {");
		sc.add("// catch exception here to prevent EMF proxy resolution from swallowing it");
		sc.add("rte.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("public final static " + STRING + " NAME_FEATURE = \"name\";");
		sc.addLineBreak();
	}

}
