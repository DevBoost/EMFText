/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 *
 */
package org.emftext.sdk.ui.syntaxgenerator.jobs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.CommonPlugin;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.codegen.util.GenClassCache;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.FontStyle;
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
import org.emftext.sdk.generatorconfig.ClassContext;
import org.emftext.sdk.generatorconfig.ClassContextDefinition;
import org.emftext.sdk.generatorconfig.ClassRule;
import org.emftext.sdk.generatorconfig.ClassRuleReference;
import org.emftext.sdk.generatorconfig.FeatureContext;
import org.emftext.sdk.generatorconfig.FeatureContextDefinition;
import org.emftext.sdk.generatorconfig.FeatureReference;
import org.emftext.sdk.generatorconfig.FeatureRule;
import org.emftext.sdk.generatorconfig.FeatureRuleReference;
import org.emftext.sdk.generatorconfig.Features;
import org.emftext.sdk.generatorconfig.GeneratorConfig;
import org.emftext.sdk.generatorconfig.GeneratorRule;
import org.emftext.sdk.generatorconfig.GeneratorconfigFactory;
import org.emftext.sdk.generatorconfig.GeneratorconfigPackage;


/**
 * Implements the generation process to derive a configurable syntax definition for a given metamodel
 *
 *
 * @author Christian Wende, Moritz Bartl
 *
 */
public class SyntaxGenerationProcess implements IRunnableWithProgress {

	private static final String KEYWORD_VIOLETT = "7F0055";

	private static final GenClassUtil genClassUtil = new GenClassUtil();
	private final GenClassCache genClassCache = new GenClassCache();

	private final IFile file;
	private ConcretesyntaxFactory concretesyntaxFactory;
	private ConcreteSyntax cSyntax;
	private GeneratorConfig genConfig;

	private NormalTokenDefinition comment;
	private NormalTokenDefinition floatToken;
	private NormalTokenDefinition intToken;

	public SyntaxGenerationProcess(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			ResourceSet rs = new ResourceSetImpl();
			Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
			final GenModel genModel = (GenModel) genResource.getContents().get(0);

			URI configURI = URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("generatorconfig").toString(), true);
			if (configURI != null && configURI.isPlatform()) {
				IResource workspaceMember = ResourcesPlugin.getWorkspace().getRoot().findMember(configURI.toPlatformString(true));
				if (workspaceMember != null) {
					Resource configResource = rs.getResource(configURI, true);
					genConfig = (GeneratorConfig) configResource.getContents().get(0);
				}
				else {
					configURI = URI.createURI("platform:/plugin/org.emftext.sdk.generatorconfig/metamodel/default.generatorconfig", true);
					Resource configResource = rs.getResource(configURI, true);
					genConfig = (GeneratorConfig) configResource.getContents().get(0);
				}
			}

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

			Map<String, Rule>  genClass2RuleCache = new HashMap<String, Rule>();
			for (Rule rule : cSyntax.getRules()) {
				genClass2RuleCache.put(genClassCache.getQualifiedInterfaceName(rule.getMetaclass()), rule);
			}

			//String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
			List<GenPackage> allGenPackagesWithClassifiers = genModel.getAllGenAndUsedGenPackagesWithClassifiers();

			cSyntax.setPackage(allGenPackagesWithClassifiers.get(0));
			cSyntax.setName(cSyntax.getPackage().getNSName());
			generateRules(genClass2RuleCache, cSyntax.getPackage(), "");

			for(int i = 1; i<allGenPackagesWithClassifiers.size(); i++) {
				GenPackage currentPkg = allGenPackagesWithClassifiers.get(i);

				Import imp = concretesyntaxFactory.createImport();
				cSyntax.getImports().add(imp);
				imp.setPackage(currentPkg);
				String prefix = currentPkg.getQualifiedPackageName();
				imp.setPrefix(prefix);

				generateRules(genClass2RuleCache, currentPkg, prefix);


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

	private void generateRules(Map<String, Rule> genClass2Rule, GenPackage pkg, String prefix) {
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
				Rule newRule = generateRule(genClass);
				if (newRule!=null) {
					cSyntax.getRules().add(newRule);
				}
				newRuleGenerated = true;
			}
		}
		if (newRuleGenerated) {
			generateStandardTokens();
		}
	}

	private Rule generateRule(GenClass genClass) {
		if (genClassUtil.isNotConcrete(genClass)) {
			return null;
		}
		Rule newRule = concretesyntaxFactory.createRule();
		newRule.setMetaclass(genClass);
		Choice newChoice = concretesyntaxFactory.createChoice();
		newRule.setDefinition(newChoice);

		Sequence ruleSequence = concretesyntaxFactory.createSequence();

		List<GenFeature> genClassFeatures = genClass.getAllGenFeatures();
		generateClassSyntax(ruleSequence, genClass, genClassFeatures, getConfigRule(genClass));
		newChoice.getOptions().add(ruleSequence);
		return newRule;
	}

	private void generateClassSyntax(Sequence ruleSequence, GenClass genClass, List<GenFeature> genClassFeatures, GeneratorRule generatorRule) {
		Collection<Definition> definitions = EcoreUtil.copyAll(generatorRule.getDefinition().getParts());

		for (Definition d:definitions) {
			if (d instanceof ClassContext) {
				if (d instanceof ClassRuleReference) {
					GeneratorRule subGeneratorRule = ((ClassRuleReference)d).getRule();
					generateClassSyntax(ruleSequence, genClass, genClassFeatures, subGeneratorRule);
				} else
				if (d instanceof ClassContextDefinition) {
					// use getDefinition(class)
					ClassContextDefinition ccDefinition = (ClassContextDefinition) d;
					ruleSequence.getParts().addAll(ccDefinition.getDefinition(genClass));
				} else
				if (d instanceof FeatureReference) {
					String featureName = ((FeatureReference) d).getFeatureName();
					for (GenFeature genFeature:genClassFeatures) {
						if (genFeature.getName().equals(featureName)) {
							generateFeature(ruleSequence, genFeature, getFeatureRule(genClass));
							genClassFeatures.remove(genFeature);
							break;
						}
					}
				} else
				if (d instanceof Features) {
					//  generate all features
					for (GenFeature genFeature:genClassFeatures) {
						generateFeature(ruleSequence, genFeature, getFeatureRule(genClass));
					}
				}
			} else
			if (d instanceof FeatureContext) {
				//TODO: proper warning?
				throw new RuntimeException("Misusage of FeatureContext in class rule (SyntaxGenerator Config)");
			} else {
				ruleSequence.getParts().add(d);
			}
		}
	}

	private void generateFeature(Sequence ruleSequence, GenFeature genFeature,
			FeatureRule featureRule) {
		Choice featureSyntaxChoice = concretesyntaxFactory.createChoice();

		Sequence innerSequence = concretesyntaxFactory.createSequence();
		generateFeatureSyntax(innerSequence, genFeature, featureRule);
		featureSyntaxChoice.getOptions().add(innerSequence);

		CompoundDefinition innerCompound = concretesyntaxFactory.createCompoundDefinition();
		innerCompound.setDefinitions(featureSyntaxChoice);

		int lowerBound = genFeature.getEcoreFeature().getLowerBound();
		int upperBound = genFeature.getEcoreFeature().getUpperBound();

		if (lowerBound == 1) {
			if (upperBound != 1) {
				innerCompound.setCardinality(concretesyntaxFactory.createPLUS());
			}
		} else {
			if (upperBound == 1) {
				innerCompound.setCardinality(concretesyntaxFactory.createQUESTIONMARK());
			} else {
			innerCompound.setCardinality(concretesyntaxFactory.createSTAR());
			}
		}

		ruleSequence.getParts().add(innerCompound);
	}

	private void generateFeatureSyntax(Sequence ruleSequence, GenFeature genFeature, GeneratorRule featureRule) {

		if (genFeature.isBooleanType()) {
			addBooleanModifier(ruleSequence, genFeature);
		} else {
			Collection<Definition> definitions = EcoreUtil.copyAll(featureRule.getDefinition().getParts());

			for (Definition d:definitions) {
				if (d instanceof FeatureContext) {
					if (d instanceof FeatureRuleReference) {
						GeneratorRule subGeneratorRule = ((FeatureRuleReference)d).getRule();
						generateFeatureSyntax(ruleSequence, genFeature, subGeneratorRule);
					} else
					if (d instanceof FeatureContextDefinition) {
						FeatureContextDefinition fcDefinition = (FeatureContextDefinition) d;
						ruleSequence.getParts().addAll(fcDefinition.getDefinition(genFeature));
					}
				} else
				if (d instanceof ClassContext) {
					//TODO: proper warning?
					throw new RuntimeException("Misusage of FeatureContext in class rule (SyntaxGenerator Config)");
				} else {
					ruleSequence.getParts().add(d);
				}
			}

		}
	}

	private GeneratorRule getConfigRule(GenClass genClass) {
		return genConfig.getClassRules().get(0);
	}

	private FeatureRule getFeatureRule(GenClass genClass) {
		return genConfig.getFeatureRules().get(0);
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

/*	private Sequence generateFeatureSyntax(GenFeature genFeature) {
		Sequence innerSequence = concretesyntaxFactory.createSequence();

		CsString nameKeyword = concretesyntaxFactory.createCsString();
		String name = genFeature.getEcoreFeature().getName();
		nameKeyword.setValue(name);

		innerSequence.getParts().add(nameKeyword);
		CsString colon = concretesyntaxFactory.createCsString();
		colon.setValue(":");
		innerSequence.getParts().add(colon);


		innerSequence.getParts().add(content);
		return innerSequence;
	} */

	private void addBooleanModifier(Sequence ruleSequence, GenFeature genFeature) {
		PlaceholderUsingSpecifiedToken adjective = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
		adjective.setCardinality(concretesyntaxFactory.createQUESTIONMARK());
		adjective.setFeature(genFeature);
		ruleSequence.getParts().add(adjective);
	}

	private boolean containsSelfOfSuper(Set<EClassifier> containedClasses, EClass ecoreClass) {
		if (containedClasses.contains(ecoreClass)) return true;
		for (EClass superClass : ecoreClass.getEAllSuperTypes()) {
			if (containedClasses.contains(superClass)) return true;
		}
		return false;
	}
}
