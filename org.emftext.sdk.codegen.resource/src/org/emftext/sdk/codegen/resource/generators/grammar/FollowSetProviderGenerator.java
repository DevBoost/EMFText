package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

public class FollowSetProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private NameUtil nameUtil = new NameUtil();
	private GeneratorUtil generatorUtil = new GeneratorUtil();

	public FollowSetProviderGenerator() {
		super();
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This class provides the follow sets for all terminals of " +
			"the grammar. These sets are used during code completion."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addTerminalConstants(sc);
		sc.add("}");
	}

	private void addTerminalConstants(JavaComposite sc) {
		Map<EObject, String> idMap = getContext().getIdMap();
		for (EObject expectedElement : idMap.keySet()) {
			String terminalID = idMap.get(expectedElement);
			
			if (expectedElement instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) expectedElement;
				GenFeature genFeature = placeholder.getFeature();
				// ignore the anonymous features
				if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
					continue;
				}

				sc.add("public final static " + iExpectedElementClassName + " " + terminalID + " = new " + expectedStructuralFeatureClassName + 
						"(" + grammarInformationProviderClassName + "." + nameUtil.getFieldName(placeholder) + ");");
			} else if (expectedElement instanceof CsString) {
				CsString expectedKeyword = (CsString) expectedElement;
				sc.add("public final static " + iExpectedElementClassName + " " + terminalID + " = new " + expectedCsStringClassName +  
						"(" + grammarInformationProviderClassName + "." + nameUtil.getFieldName(expectedKeyword) + ");");
			} else {
				throw new RuntimeException("Unknown expected element type: " + expectedElement);
			}
		}
		sc.addLineBreak();

		Map<String, Set<Expectation>> followSetMap = getContext().getFollowSetMap();
		// ask for all features to make sure respective fields are generated
		for (String firstID : followSetMap.keySet()) {
			for (Expectation expectation : followSetMap.get(firstID)) {
				List<GenFeature> containmentTrace = expectation.getContainmentTrace();
				for (GenFeature genFeature : containmentTrace) {
					getContext().getFeatureConstantFieldName(genFeature);
				}
			}
		}
		
		Map<GenFeature, String> eFeatureToConstantNameMap = getContext().getFeatureToConstantNameMap();
		// generate fields for all used features
		for (GenFeature genFeature : eFeatureToConstantNameMap.keySet()) {
			String fieldName = getContext().getFeatureConstantFieldName(genFeature);
			String featureAccessor = generatorUtil.getFeatureAccessor(genFeature.getGenClass(), genFeature);
			sc.add("public final static " + E_STRUCTURAL_FEATURE + " " + fieldName + " = " + featureAccessor + ";");
		}
		sc.addLineBreak();
		
		sc.add("public final static " + E_STRUCTURAL_FEATURE + "[] EMPTY_FEATURE_ARRAY = new " + E_STRUCTURAL_FEATURE + "[0];");
		sc.addLineBreak();
		
		// we need to split the code to wire the terminals with their
		// followers, because the code does exceed the 64KB limit for
		// methods if the grammar is big
		int bytesUsedInCurrentMethod = 0;
		boolean methodIsFull = true;
		int i = 0;
		int numberOfMethods = 0;
		// create multiple wireX() methods
		for (String firstID : followSetMap.keySet()) {
			if (methodIsFull) {
				sc.add("public static void wire" + numberOfMethods + "() {");
				numberOfMethods++;
				methodIsFull = false;
			}
			for (Expectation expectation : followSetMap.get(firstID)) {
				EObject follower = expectation.getExpectedElement();
				List<GenFeature> containmentTrace = expectation.getContainmentTrace();
				StringBuilder trace = new StringBuilder();
				if (containmentTrace.isEmpty()) {
					trace.append(", EMPTY_FEATURE_ARRAY");
				} else {
					trace.append(", new " + E_STRUCTURAL_FEATURE + "[] {");
					for (GenFeature genFeature : containmentTrace) {
						trace.append(getContext().getFeatureConstantFieldName(genFeature) + ", ");
						// another 16 bytes for each access to a constant
						bytesUsedInCurrentMethod += 16;
					}
					trace.append("}");
				}
				sc.add(firstID + ".addFollower(" + getContext().getID(follower) + trace + ");");
				// the method call takes 19 bytes
				bytesUsedInCurrentMethod += 19;
			}
			if (bytesUsedInCurrentMethod >= 63 * 1024) {
				methodIsFull = true;
				bytesUsedInCurrentMethod = 0;
			}
			if (methodIsFull || i == followSetMap.keySet().size() - 1) {
				sc.add("}");
			}
			i++;
		}
		// call all wireX() methods from the static constructor
		sc.addComment("wire the terminals");
		sc.add("static {");
		for (int c = 0; c < numberOfMethods; c++) {
			sc.add("wire" + c + "();");
		}
		sc.add("}");
	}
}
