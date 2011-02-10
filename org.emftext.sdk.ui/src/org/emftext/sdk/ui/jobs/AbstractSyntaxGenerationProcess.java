/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.ui.jobs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.util.GenClassUtil;

public abstract class AbstractSyntaxGenerationProcess implements IRunnableWithProgress {
	
	private static final String FLOAT_TOKEN_NAME = "FLOAT";

	private static final String INTEGER_TOKEN_NAME = "INTEGER";

	private static final String KEYWORD_VIOLETT = "7F0055";

	private static final GenClassUtil genClassUtil = new GenClassUtil();

	public static final ConcretesyntaxFactory CS_FACTORY = ConcretesyntaxFactory.eINSTANCE;

	private final IFile file;

	public AbstractSyntaxGenerationProcess(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		ResourceSet rs = new ResourceSetImpl();
		Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
		final GenModel genModel = (GenModel) genResource.getContents().get(0);
		
		URI uri = URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("cs").toString(), true);
		Resource csResource = null;
		if (uri != null && uri.isPlatform()) {
			IResource workspaceMember = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
			if (workspaceMember != null) {
				csResource = rs.getResource(uri, true);
			}
			else {
				csResource = rs.createResource(uri);
			}
		}
		
		EObject currentSyntax = null;
		if (csResource != null && csResource.getContents().size() > 0) {
			currentSyntax = csResource.getContents().get(0);
		}
		
		ConcreteSyntax cSyntax;
		if (currentSyntax instanceof ConcreteSyntax) {
			cSyntax = (ConcreteSyntax) currentSyntax;
		} else {
			cSyntax = CS_FACTORY.createConcreteSyntax();	
			csResource.getContents().add(cSyntax);
		}
		fillSyntax(cSyntax, genModel);
		
		try {
			csResource.save(null);
		} catch (IOException e) {
        	// TODO cwende: this exception should be shown to the user
			EMFTextSDKPlugin.logError("Exception while saving resource.", e);
		}
	}

	public void fillSyntax(ConcreteSyntax cSyntax, GenModel genModel) {
		GenClassCache genClassCache = cSyntax.getGenClassCache();
		
		Map<String, Rule>  genClass2RuleCache = new LinkedHashMap<String, Rule>(); 
		for (Rule rule : cSyntax.getRules()) {
			genClass2RuleCache.put(genClassCache.getQualifiedInterfaceName(rule.getMetaclass()), rule);
		}
		
		List<GenPackage> allGenPackagesWithClassifiers = genModel.getAllGenAndUsedGenPackagesWithClassifiers();
		
		cSyntax.setPackage(allGenPackagesWithClassifiers.get(0));
		cSyntax.setName(cSyntax.getPackage().getNSName());
		generateRules(cSyntax, genClass2RuleCache, cSyntax.getPackage(), "", genClassCache);
		
		for (int i = 1; i < allGenPackagesWithClassifiers.size(); i++) {
			GenPackage currentPkg = allGenPackagesWithClassifiers.get(i);
			
			Import imp = CS_FACTORY.createImport();
			cSyntax.getImports().add(imp);
			imp.setPackage(currentPkg);
			String prefix = currentPkg.getQualifiedPackageName();
			imp.setPrefix(prefix);
			
			generateRules(cSyntax, genClass2RuleCache, currentPkg, prefix, genClassCache);
		}
		generateTokenstyles(cSyntax);
	}

	private void generateTokenstyles(ConcreteSyntax cSyntax) {
		TreeIterator<EObject> allContents = cSyntax.eAllContents();
		HashMap<String, TokenStyle> cachedStyles = new HashMap<String, TokenStyle>();
		for (TokenStyle style : cSyntax.getTokenStyles()) {
			for (String tokenName : style.getTokenNames()) {
				cachedStyles.put(tokenName, style);
			}
		}
		 
		while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if (object instanceof CsString) {
				CsString s = (CsString) object;
				if (cachedStyles.get(s.getValue()) != null) continue;
				if(! s.getValue().matches("\\w*")) continue;
				
				TokenStyle tokenStyle = CS_FACTORY.createTokenStyle();
				tokenStyle.getTokenNames().add(s.getValue());
				tokenStyle.setRgb(KEYWORD_VIOLETT);
				tokenStyle.getFontStyles().add(FontStyle.BOLD);
				
				cSyntax.getTokenStyles().add(tokenStyle);
				cachedStyles.put(s.getValue(), tokenStyle);
			}
		}
	}

	private void generateRules(ConcreteSyntax cSyntax, Map<String, Rule> genClass2Rule, GenPackage pkg, String prefix, GenClassCache genClassCache) {
		EList<GenClass> genClasses = pkg.getGenClasses();
		Set<EClassifier> containedClasses = new LinkedHashSet<EClassifier>();
		for (GenClass genClass : genClasses) {
			List<GenFeature> allChildrenFeatures = genClass.getAllChildrenFeatures();
			for (GenFeature genFeature : allChildrenFeatures) {
				EClassifier type = genFeature.getEcoreFeature().getEType();
				if (!type.equals(genClass.getEcoreClass())) {
					containedClasses.add(type);
				}
			}
		}
		
		// determine start symbols
		for (GenClass genClass : genClasses) {
			if (genClassUtil.isConcrete(genClass) && 
				!containsSelfOfSuper(containedClasses, genClass.getEcoreClass()) ) {
				cSyntax.getStartSymbols().add(genClass);
			}
		}
		
		boolean newRuleGenerated = false;
		for (GenClass genClass : genClasses) {
			if (genClass2Rule.get(genClassCache.getQualifiedInterfaceName(genClass)) == null) {
				generateRule(cSyntax, genClass);
				newRuleGenerated = true;
			}
		}
		if (newRuleGenerated) {
			generateStandardTokens(cSyntax);
		}
	}

	private void generateRule(ConcreteSyntax cSyntax, GenClass genClass) {
		if (genClassUtil.isNotConcrete(genClass)) {
			return;
		}
		Rule newRule = CS_FACTORY.createRule();
		newRule.setMetaclass(genClass);
		cSyntax.getRules().add(newRule);
		
		Choice newChoice = CS_FACTORY.createChoice();
		newRule.getChildren().clear();
		newRule.getChildren().add(newChoice);
		Sequence ruleSequence = CS_FACTORY.createSequence();
		newChoice.getChildren().add(ruleSequence);
		
		List<GenFeature> allGenFeatures = genClass.getAllGenFeatures();
		
		for (GenFeature genFeature : allGenFeatures) {
			if (genFeature.isBooleanType()) {
				addBooleanModifier(ruleSequence, genFeature);
			}
		}
		
		CsString newDefinition = CS_FACTORY.createCsString();
		newDefinition.setValue(genClass.getName());
		
		ruleSequence.getChildren().add(newDefinition);
		
		addOpening(genClass, ruleSequence);
		
		Choice featureSyntaxChoice = CS_FACTORY.createChoice();
		for (GenFeature genFeature : allGenFeatures) {
			if (!genFeature.isBooleanType() || genFeature.getEcoreFeature().getUpperBound() == -1) {
				generateFeatureSyntax(cSyntax, featureSyntaxChoice, genFeature);
			}
		}
		
		if (featureSyntaxChoice.getOptions().size() > 0) {
			CompoundDefinition innerCompound = CS_FACTORY.createCompoundDefinition();
			innerCompound.getChildren().clear();
			innerCompound.getChildren().add(featureSyntaxChoice);
		
			ruleSequence.getChildren().add(innerCompound);
			innerCompound.setCardinality(Cardinality.STAR);
		}

		addClosing(genClass, ruleSequence);
	}

	public abstract void addOpening(GenClass genClass, Sequence ruleSequence);

	public abstract void addClosing(GenClass genClass, Sequence ruleSequence);

	public abstract void createFeaturePrefix(GenFeature genFeature, Sequence sequence);

	private void generateStandardTokens(ConcreteSyntax cSyntax) {
		List<CompleteTokenDefinition> toRemove = new ArrayList<CompleteTokenDefinition>();
		EList<TokenDirective> existing = cSyntax.getTokens();
		for (TokenDirective tokenDirective : existing) {
			if (tokenDirective instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition def = (CompleteTokenDefinition) tokenDirective;
				if (def.getName().equals(INTEGER_TOKEN_NAME) ||
						def.getName().equals(FLOAT_TOKEN_NAME) ||
						def.getName().equals("COMMENT")) {
					toRemove.add(def);
				}
			}
		}
		
		cSyntax.getTokens().removeAll(toRemove);
		NormalTokenDefinition intToken = createToken(INTEGER_TOKEN_NAME, "('-')?('1'..'9')('0'..'9')*|'0'");
		NormalTokenDefinition floatToken = createToken(FLOAT_TOKEN_NAME, "('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ ");
		NormalTokenDefinition comment = createToken("COMMENT", "'//'(~('\\n'|'\\r'|'\\uffff'))*");
		
		cSyntax.getTokens().add(comment);
		cSyntax.getTokens().add(intToken);
		cSyntax.getTokens().add(floatToken);
	}

	private NormalTokenDefinition createToken(String name, String expression) {
		NormalTokenDefinition newToken = CS_FACTORY.createNormalTokenDefinition();
		newToken.setName(name);
		AtomicRegex regex = CS_FACTORY.createAtomicRegex();
		regex.setAtomicExpression(expression);
		newToken.getRegexParts().add(regex);
		return newToken;
	}

	private void generateFeatureSyntax(ConcreteSyntax cSyntax, Choice featureSyntaxChoice,
			GenFeature genFeature) {
		Sequence innerSequence = CS_FACTORY.createSequence();

		createFeaturePrefix(genFeature, innerSequence);
		
		Terminal content = null;
		if (genFeature.getEcoreFeature() instanceof EReference && ((EReference)genFeature.getEcoreFeature()).isContainment() ) {
			content = CS_FACTORY.createContainment();
		}
		else{
			String typeName = genFeature.getEcoreFeature().getEType().getInstanceClassName();
			if (genFeature.isStringType()) {
				PlaceholderInQuotes placeholder = CS_FACTORY.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			else if (typeName == null) {
				content = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
			}
			else if (typeName.equals("String")) {
				PlaceholderInQuotes placeholder = CS_FACTORY.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			
			else if (typeName.equals("int") || typeName.equals("long") || typeName.equals("short")) {
				PlaceholderUsingSpecifiedToken placeholder = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(getTokenByName(cSyntax, INTEGER_TOKEN_NAME));
				content = placeholder;
			}
			
			else if (typeName.equals("float") || typeName.equals("double")) {
				PlaceholderUsingSpecifiedToken placeholder = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(getTokenByName(cSyntax, FLOAT_TOKEN_NAME));
				content = placeholder;
			}										
			else {
				content = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
			}
		}									
		content.setFeature(genFeature);
		
		innerSequence.getChildren().add(content);
		featureSyntaxChoice.getChildren().add(innerSequence);
	}

	private CompleteTokenDefinition getTokenByName(ConcreteSyntax cSyntax, String tokenName) {
		for (TokenDirective tokenDirective : cSyntax.getTokens()) {
			if (tokenDirective instanceof NormalTokenDefinition) {
				NormalTokenDefinition tokenDefinition = (NormalTokenDefinition) tokenDirective;
				if (tokenDefinition.getName().equals(tokenName)) {
					return tokenDefinition;
				}
			}
		}
		return null;
	}

	private void addBooleanModifier(Sequence ruleSequence, GenFeature genFeature) {
		PlaceholderUsingSpecifiedToken adjective = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
		adjective.setCardinality(Cardinality.QUESTIONMARK);
		adjective.setFeature(genFeature);
		ruleSequence.getChildren().add(adjective);
	}

	private boolean containsSelfOfSuper(Set<EClassifier> containedClasses, EClass ecoreClass) {
		if (containedClasses.contains(ecoreClass)) return true;
		for (EClass superClass : ecoreClass.getEAllSuperTypes()) {
			if (containedClasses.contains(superClass)) return true;						
		}
		return false;
	}

	protected void addOpeningBracket(Sequence sequence) {
		CsString openBracket = CS_FACTORY.createCsString();
		openBracket.setValue("{");
		sequence.getChildren().add(openBracket);
	}

	protected void addClosingBracket(Sequence sequence) {
		CsString closeBracket = CS_FACTORY.createCsString();
		closeBracket.setValue("}");
		sequence.getChildren().add(closeBracket);
	}

	protected void addFeatureNameColon(GenFeature genFeature, Sequence sequence) {
		String name = genFeature.getEcoreFeature().getName();
		
		CsString nameKeyword = CS_FACTORY.createCsString();
		nameKeyword.setValue(name);
		sequence.getChildren().add(nameKeyword);
		
		CsString colon = CS_FACTORY.createCsString();
		colon.setValue(":");
		sequence.getChildren().add(colon);
	}
}
