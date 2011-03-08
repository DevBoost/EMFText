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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.util.EObjectUtil;

public class UnreachableRuleAnalyser extends AbstractPostProcessor {
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		// abstract syntax definitions cannot be analyzed w.r.t. rule
		// reachability
		if (syntax.isAbstract()) {
			return;
		}
		Set<Rule> reachableRules = getStartRules(syntax);
		int oldSize = -1;
		do {
			oldSize = reachableRules.size();
			
			for (Rule maybeReachableRule : syntax.getAllRules()) {
				
				if (reachableRules.contains(maybeReachableRule)) {
					continue;
				}
				
				if (isReachable(reachableRules, maybeReachableRule)) {
					reachableRules.add(maybeReachableRule);					
				}
			}
		} while (reachableRules.size() > oldSize);
				
		for (Rule rule : syntax.getAllRules()) {
			if (reachableRules.contains(rule)) {
				continue;
			}
			String message = "Rule is not reachable (wrong super class or missing right hand side definition?)";
			addRuleProblem(
				CsAnalysisProblemType.UNREACHABLE_RULE, 
				message,
				syntax,
				rule
			);			
		}
	}

	private boolean isReachable(Set<Rule> reachableRules, Rule maybeReachableRule) {
		EClass maybeReachableClass = maybeReachableRule.getMetaclass().getEcoreClass();

		// A rule is reachable if it is a subclass of a rule that can be reached
		for (Rule reachableRule : reachableRules) {
			EClass reachableClass = reachableRule.getMetaclass().getEcoreClass();
			if (isSubClassOrEqual(reachableRule.getSyntax().getEClassUtil(), maybeReachableClass, reachableClass)) {
				//System.err.println("rule " + maybeReachableRule + " is reachable through subclass");
				return true;
			}
		}
		
		// or if it's contained in the right hand side of a reachable rule.
		for (Rule reachableRule : reachableRules) {
			Collection<Containment> containments = EObjectUtil
				.getObjectsByType(reachableRule.eAllContents(),
					ConcretesyntaxPackage.eINSTANCE.getContainment());
			for (Containment containment : containments) {
				List<GenClass> allowedTypes = containment.getAllowedSubTypes();
				for (GenClass allowedType : allowedTypes) {
					EClass allowedEType = allowedType.getEcoreClass();
					if (isSubClassOrEqual(reachableRule.getSyntax().getEClassUtil(), maybeReachableClass, allowedEType)) {
						//System.err.println("rule " + maybeReachableRule + " is reachable through containment");
						return true;
					}
				}
			}
		}

		return false;
	}
	
	private Set<Rule> getStartRules(ConcreteSyntax syntax) {
		Set<Rule> startRules = new LinkedHashSet<Rule>();
		
		// Add initial rules based on start symbols.
		for (GenClass startGenClass : syntax.getStartSymbols()) {
			for (Rule rule : syntax.getAllRules()) {
				if (isSubClassOrEqual(rule.getSyntax().getEClassUtil(), rule.getMetaclass().getEcoreClass(), startGenClass.getEcoreClass())) {
					startRules.add(rule);
				}
			}
		}
		return startRules;
	}

	// TODO move this method to EClassUtil.ejava
	private boolean isSubClassOrEqual(EClassUtil eClassUtil, EClass subclassCandidate, EClass superType) {
		boolean isEqual = eClassUtil.namesAndPackageURIsAreEqual(subclassCandidate, superType);
		boolean isSubclass = eClassUtil.isSubClass(subclassCandidate, superType);
		return isEqual || isSubclass;
	}
}
