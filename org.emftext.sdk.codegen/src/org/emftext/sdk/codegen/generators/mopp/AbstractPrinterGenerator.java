package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.util.StringUtil;

public abstract class AbstractPrinterGenerator extends JavaBaseGenerator {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	
	private String referenceResolverSwitchClassName;

	public AbstractPrinterGenerator() {
		super();
	}

	public AbstractPrinterGenerator(GenerationContext context, EArtifact artifact) {
		super(context, artifact);
		this.referenceResolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
	}

	protected void addGetOptionsMethod(StringComposite sc) {
		sc.add("public " + MAP + "<?,?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("protected " + referenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("return (" + referenceResolverSwitchClassName + ") new " + getClassNameHelper().getMETA_INFORMATION() + "().getReferenceResolverSwitch();");
        sc.add("}");
		sc.addLineBreak();
	}

	/**
	 * Prints the code needed to initialize the printCountingMap.
	 * 
	 * @param sc
	 * @param genClass
	 */
	protected void printCountingMapIntialization(StringComposite sc, GenClass genClass) {
		List<GenFeature> featureList = genClass.getAllGenFeatures();
		String printCountingMapName = "printCountingMap";
		sc.add("// the " + printCountingMapName + " contains a mapping from feature names to");
		sc.add("// the number of remaining elements that still need to be printed.");
		sc.add("// the map is initialized with the number of elements stored in each structural");
		sc.add("// feature. for lists this is the list size. for non-multiple features it is either");
		sc.add("// 1 (if the feature is set) or 0 (if the feature is null).");
		sc.add(new StringComponent(MAP + "<" + STRING + ", " + INTEGER + "> " + printCountingMapName + " = new " + HASH_MAP + "<" + STRING + ", " + INTEGER + ">("
				+ featureList.size() + ");", printCountingMapName));
		
		if (featureList.size() > 0) {
			sc.add(OBJECT + " temp;");
		}
		for (GenFeature genFeature : featureList) {
			EStructuralFeature feature = genFeature.getEcoreFeature();
			sc.add("temp = element." + getAccessMethod(genClass, genFeature)
					+ ";");

			boolean isMultiple = feature.getUpperBound() > 1 || feature.getUpperBound() == -1;
			String featureSize = isMultiple ? "((" + java.util.Collection.class.getName() + "<?>) temp).size()"
					: "1";
			sc.add("printCountingMap.put(\"" + feature.getName()
					+ "\", temp == null ? 0 : " + featureSize + ");");
		}
	}

	// TODO mseifert: I think this code is also somewhere else
	protected String getAccessMethod(GenClass genClass, GenFeature genFeature) {
		if (hasMapType(genClass)) {
			return "get" + StringUtil.capitalize(genFeature.getName()) + "()";
		}
		else {
			String method = "eGet(element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "))";
			return method;
		}
	}

	// TODO mseifert: this should go somewhere else
	protected boolean hasMapType(GenClass genClass) {
		return java.util.Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName());
	}

	protected String getTabString(int count) {
		return getRepeatingString(count, '\t');
	}

	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer spaces = new StringBuffer();
		for (int i = 0; i < count; i++) {
			spaces.append(character);
		}
		return spaces.toString();
	}
}
