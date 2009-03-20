/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.sdk.ui.jobs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;


/**
 * Implements the generation process to derive a HUTN-based syntax for a given metamodel
 * 
 * 
 * @author Christian Wende
 *
 */
public class HUTNGenerationProcess implements IRunnableWithProgress {
	private final IFile file;
	private ConcretesyntaxFactory concretesyntaxFactory;
	private ConcreteSyntax cSyntax;
	private NormalToken comment;
	private NormalToken floatToken;
	private NormalToken intToken;

	public HUTNGenerationProcess(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor monitor)throws InvocationTargetException, InterruptedException {
			ResourceSet rs = new ResourceSetImpl();
			Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
			final GenModel genModel = (GenModel) genResource.getContents().get(0);
			
			concretesyntaxFactory = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory();
			Resource csResource = rs.createResource(URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("cs").toString(), true));
			cSyntax = concretesyntaxFactory.createConcreteSyntax();		
			csResource.getContents().clear();
			csResource.getContents().add(cSyntax);
			
			//String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
	    	cSyntax.setPackage(genModel.getGenPackages().get(0));
			cSyntax.setName(cSyntax.getPackage().getNSName());
			
			EList<GenClass> genClasses = cSyntax.getPackage().getGenClasses();
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
				if (!genClass.isAbstract() && !genClass.isInterface() && !containsSelfOfSuper(containedClasses, genClass.getEcoreClass()) ) {
					cSyntax.getActiveStartSymbols().add(genClass);
				}
			}
			
			cSyntax.getRules().clear();
			
			for (GenClass genClass : genClasses) {
				generateRule(genClass);
			}
			
			
			try {
				csResource.save(null);
			} catch (IOException e) {
				EMFTextRuntimePlugin.logError("Exception while saving resource.", e);
			}
	}

	private void generateRule(GenClass genClass) {
		if (genClass.isAbstract() || genClass.isInterface()) return;
		Rule newRule = concretesyntaxFactory.createRule();
		newRule.setMetaclass(genClass);
		cSyntax.getRules().add(newRule);
		
		Choice newChoice = concretesyntaxFactory.createChoice();
		newRule.setDefinition(newChoice);
		Sequence ruleSequence = concretesyntaxFactory.createSequence();
		newChoice.getOptions().add(ruleSequence);
		
		intToken = concretesyntaxFactory.createNormalToken();
		intToken.setName("INTEGER");
		intToken.setRegex("('-')?('1'..'9')('0'..'9')*|'0'");
		floatToken = concretesyntaxFactory.createNormalToken();
		floatToken.setName("FLOAT");
		floatToken.setRegex("('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ ");
		comment = concretesyntaxFactory.createNormalToken();
		comment.setName("COMMENT");
		comment.setRegex("'//'(~('\\n'|'\\r'))*");
		
		cSyntax.getTokens().clear();
		cSyntax.getTokens().add(comment);
		cSyntax.getTokens().add(intToken);
		cSyntax.getTokens().add(floatToken);
		
		
		List<GenFeature> allGenFeatures = genClass.getAllGenFeatures();
		
		for (GenFeature genFeature : allGenFeatures) {
			if (genFeature.isBooleanType()) {
				addBooleanModifier(ruleSequence, genFeature);
			}
		}
		
		CsString newDefinition = concretesyntaxFactory.createCsString();
		newDefinition.setValue(genClass.getName());
		
		ruleSequence.getParts().add(newDefinition);
		
		CsString openBracket = concretesyntaxFactory.createCsString();
		openBracket.setValue("{");
		ruleSequence.getParts().add(openBracket);
		
		Choice featureSyntaxChoice = concretesyntaxFactory.createChoice();
		for (GenFeature genFeature : allGenFeatures) {
			if (!genFeature.isBooleanType() || genFeature.getEcoreFeature().getUpperBound() == -1) {
				createFeatureSyntax(featureSyntaxChoice, genFeature);
			}
		}
		
		if(featureSyntaxChoice.getOptions().size() > 0) {
			CompoundDefinition innerCompound = concretesyntaxFactory.createCompoundDefinition();
			innerCompound.setDefinitions(featureSyntaxChoice);
			ruleSequence.getParts().add(innerCompound);
			innerCompound.setCardinality(concretesyntaxFactory.createSTAR());
		}
		
		CsString closeBracket = concretesyntaxFactory.createCsString();
		closeBracket.setValue("}");
		ruleSequence.getParts().add(closeBracket);
		
	}

	private void createFeatureSyntax(Choice featureSyntaxChoice,
			GenFeature genFeature) {
		Sequence innerSequence = concretesyntaxFactory.createSequence();
											
		CsString nameKeyword = concretesyntaxFactory.createCsString();
		nameKeyword.setValue(genFeature.getEcoreFeature().getName());
		innerSequence.getParts().add(nameKeyword);
		CsString colon = concretesyntaxFactory.createCsString();
		colon.setValue(":");
		innerSequence.getParts().add(colon);
		
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
		
		innerSequence.getParts().add(content);
		featureSyntaxChoice.getOptions().add(innerSequence);
	}

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
