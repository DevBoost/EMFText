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
/**
 * 
 */
package org.emftext.sdk.ui.jobs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
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
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenStyle;


/**
 * Implements the generation process to derive a HUTN-based syntax for a given metamodel
 * 
 * 
 * @author Christian Wende
 *
 */
public class HUTNGenerationProcess implements IRunnableWithProgress {
	
	private static final String KEYWORD_VIOLETT = "7F0055";

	private static final GenClassUtil genClassUtil = new GenClassUtil();
	
	private final IFile file;
	private ConcretesyntaxFactory concretesyntaxFactory;
	private ConcreteSyntax cSyntax;
	private NormalTokenDefinition comment;
	private NormalTokenDefinition floatToken;
	private NormalTokenDefinition intToken;

	public HUTNGenerationProcess(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			ResourceSet rs = new ResourceSetImpl();
			Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
			final GenModel genModel = (GenModel) genResource.getContents().get(0);
			
			concretesyntaxFactory = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory();
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
			
			if (currentSyntax instanceof ConcreteSyntax) {
				cSyntax = (ConcreteSyntax) currentSyntax;
			} else {
				cSyntax = concretesyntaxFactory.createConcreteSyntax();	
				csResource.getContents().add(cSyntax);
			}
			GenClassCache genClassCache = cSyntax.getGenClassCache();
			
			Map<String, Rule>  genClass2RuleCache = new HashMap<String, Rule>(); 
			for (Rule rule : cSyntax.getRules()) {
				genClass2RuleCache.put(genClassCache.getQualifiedInterfaceName(rule.getMetaclass()), rule);
			}
			
			//String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
			List<GenPackage> allGenPackagesWithClassifiers = genModel.getAllGenAndUsedGenPackagesWithClassifiers();
			
			cSyntax.setPackage(allGenPackagesWithClassifiers.get(0));
			cSyntax.setName(cSyntax.getPackage().getNSName());
			generateRules(genClass2RuleCache, cSyntax.getPackage(), "", genClassCache);
			
			for(int i = 1; i<allGenPackagesWithClassifiers.size(); i++) {
				GenPackage currentPkg = allGenPackagesWithClassifiers.get(i);
				
				Import imp = concretesyntaxFactory.createImport();
				cSyntax.getImports().add(imp);
				imp.setPackage(currentPkg);
				String prefix = currentPkg.getQualifiedPackageName();
				imp.setPrefix(prefix);
				
				generateRules(genClass2RuleCache, currentPkg, prefix, genClassCache);
				
				
			}
			generateTokenstyles();
			
			try {
				csResource.save(null);
			} catch (IOException e) {
	        	// TODO cwende: this exception should be shown to the user
				EMFTextSDKPlugin.logError("Exception while saving resource.", e);
			}
	}

	private void generateTokenstyles() {
		 TreeIterator<EObject> allContents = cSyntax.eAllContents();
		 HashMap<String, TokenStyle> cachedStyles = new HashMap<String, TokenStyle>();
		 for (TokenStyle style : cSyntax.getTokenStyles()) {
			cachedStyles.put(style.getTokenName(), style);
		}
		 
		 while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if (object instanceof CsString) {
				CsString s = (CsString) object;
				if (cachedStyles.get(s.getValue()) != null) continue;
				if(! s.getValue().matches("\\w*")) continue;
				
				TokenStyle tokenStyle = concretesyntaxFactory.createTokenStyle();
				tokenStyle.setTokenName(s.getValue());
				tokenStyle.setRgb(KEYWORD_VIOLETT);
				tokenStyle.getFontStyles().add(FontStyle.BOLD);
				
				cSyntax.getTokenStyles().add(tokenStyle);
				cachedStyles.put(s.getValue(), tokenStyle);
					
			}
		}
	}

	private void generateRules(Map<String, Rule> genClass2Rule, GenPackage pkg, String prefix, GenClassCache genClassCache) {
		EList<GenClass> genClasses = pkg.getGenClasses();
		Set<EClassifier> containedClasses = new HashSet<EClassifier>();
		for (GenClass genClass : genClasses) {
			List<GenFeature> allChildrenFeatures = genClass.getAllChildrenFeatures();
			for (GenFeature genFeature : allChildrenFeatures) {
				EClassifier type = genFeature.getEcoreFeature().getEType();
				if (!type.equals(genClass.getEcoreClass())) {
					containedClasses.add(type);
				}
			}
		}
		for (GenClass genClass : genClasses) {
			if (genClassUtil.isConcrete(genClass) && 
				!containsSelfOfSuper(containedClasses, genClass.getEcoreClass()) ) {
				cSyntax.getStartSymbols().add(genClass);
			}
		}
		
		boolean newRuleGenerated = false;
		for (GenClass genClass : genClasses) {
			if (genClass2Rule.get(genClassCache.getQualifiedInterfaceName(genClass)) == null) {
				generateRule(genClass);
				newRuleGenerated = true;
			}
		}
		if (newRuleGenerated) {
			generateStandardTokens();
		}
	}

	private void generateRule(GenClass genClass) {
		if (genClassUtil.isNotConcrete(genClass)) {
			return;
		}
		Rule newRule = concretesyntaxFactory.createRule();
		newRule.setMetaclass(genClass);
		cSyntax.getRules().add(newRule);
		
		Choice newChoice = concretesyntaxFactory.createChoice();
		newRule.getChildren().clear();
		newRule.getChildren().add(newChoice);
		Sequence ruleSequence = concretesyntaxFactory.createSequence();
		newChoice.getChildren().add(ruleSequence);
		
		List<GenFeature> allGenFeatures = genClass.getAllGenFeatures();
		
		for (GenFeature genFeature : allGenFeatures) {
			if (genFeature.isBooleanType()) {
				addBooleanModifier(ruleSequence, genFeature);
			}
		}
		
		CsString newDefinition = concretesyntaxFactory.createCsString();
		newDefinition.setValue(genClass.getName());
		
		ruleSequence.getChildren().add(newDefinition);
		
		CsString openBracket = concretesyntaxFactory.createCsString();
		openBracket.setValue("{");
		ruleSequence.getChildren().add(openBracket);
		
		Choice featureSyntaxChoice = concretesyntaxFactory.createChoice();
		for (GenFeature genFeature : allGenFeatures) {
			if (!genFeature.isBooleanType() || genFeature.getEcoreFeature().getUpperBound() == -1) {
				generateFeatureSyntax(featureSyntaxChoice, genFeature);
			}
		}
		
		if (featureSyntaxChoice.getOptions().size() > 0) {
			CompoundDefinition innerCompound = concretesyntaxFactory.createCompoundDefinition();
			innerCompound.getChildren().clear();
			innerCompound.getChildren().add(featureSyntaxChoice);
		
			ruleSequence.getChildren().add(innerCompound);
			innerCompound.setCardinality(concretesyntaxFactory.createSTAR());
		}
		
		CsString closeBracket = concretesyntaxFactory.createCsString();
		closeBracket.setValue("}");
		ruleSequence.getChildren().add(closeBracket);
		
	}

	private void generateStandardTokens() {
		List<CompleteTokenDefinition> toRemove = new ArrayList<CompleteTokenDefinition>();
		EList<TokenDirective> existing = cSyntax.getTokens();
		for (TokenDirective tokenDirective : existing) {
			if (tokenDirective instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition def = (CompleteTokenDefinition) tokenDirective;
				if (def.getName().equals("INTEGER") ||
						def.getName().equals("FLOAT") ||
						def.getName().equals("COMMENT")) {
					toRemove.add(def);
				}
			}
		}
		
		cSyntax.getTokens().removeAll(toRemove);
		intToken = createToken("INTEGER", "('-')?('1'..'9')('0'..'9')*|'0'");
		floatToken = createToken("FLOAT", "('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ ");
		comment = createToken("COMMENT", "'//'(~('\\n'|'\\r'|'\\uffff'))*");
		
		cSyntax.getTokens().add(comment);
		cSyntax.getTokens().add(intToken);
		cSyntax.getTokens().add(floatToken);
	}

	private NormalTokenDefinition createToken(String name, String expression) {
		NormalTokenDefinition newToken = concretesyntaxFactory.createNormalTokenDefinition();
		newToken.setName(name);
		AtomicRegex regex = concretesyntaxFactory.createAtomicRegex();
		regex.setAtomicExpression(expression);
		newToken.getRegexParts().add(regex);
		return newToken;
	}

	private void generateFeatureSyntax(Choice featureSyntaxChoice,
			GenFeature genFeature) {
		Sequence innerSequence = concretesyntaxFactory.createSequence();
											
		CsString nameKeyword = concretesyntaxFactory.createCsString();
		String name = genFeature.getEcoreFeature().getName();
		nameKeyword.setValue(name);
		
		innerSequence.getChildren().add(nameKeyword);
		CsString colon = concretesyntaxFactory.createCsString();
		colon.setValue(":");
		innerSequence.getChildren().add(colon);
		
		Terminal content = null;
		if (genFeature.getEcoreFeature() instanceof EReference && ((EReference)genFeature.getEcoreFeature()).isContainment() ) {
			content = concretesyntaxFactory.createContainment();
		}
		else{
			String typeName = genFeature.getEcoreFeature().getEType().getInstanceClassName();
			if (genFeature.isStringType()) {
				PlaceholderInQuotes placeholder = concretesyntaxFactory.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			else if (typeName == null) {
				content = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
			}
			else if(typeName.equals("String")) {
				PlaceholderInQuotes placeholder = concretesyntaxFactory.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			
			else if(typeName.equals("int") || typeName.equals("long")  || typeName.equals("short")){
				PlaceholderUsingSpecifiedToken placeholder = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(intToken);
				content = placeholder;
			}
			
			else if(typeName.equals("float") || typeName.equals("double")){
				PlaceholderUsingSpecifiedToken placeholder = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(floatToken);
				content = placeholder;
			}										
			else {
				content = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
			}
			
			
		}									
		content.setFeature(genFeature);
		
		innerSequence.getChildren().add(content);
		featureSyntaxChoice.getChildren().add(innerSequence);
	}

	private void addBooleanModifier(Sequence ruleSequence, GenFeature genFeature) {
		PlaceholderUsingSpecifiedToken adjective = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
		adjective.setCardinality(concretesyntaxFactory.createQUESTIONMARK());
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
}
