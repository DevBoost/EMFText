/**
 * 
 */
package org.reuseware.emftextedit.sdk.codegen;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.Definition;
import org.reuseware.emftextedit.concretesyntax.PLUS;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Sequence;

public class LeftRecursionDetector {
	


	private Map<String, Collection<String>> genClasses2superNames;
	private ConcreteSyntax grammar;

	public LeftRecursionDetector(
			Map<String, Collection<String>> genClasses2superNames, ConcreteSyntax concreteSyntax) {
		this.genClasses2superNames = genClasses2superNames;
		this.grammar = concreteSyntax;
	}

	public Rule findLeftRecursion(Rule rule) {
    	Rule leftProducingRule = findLeftProducingRule(rule.getMetaclass(), rule);
    	return leftProducingRule; 
	}
    
    private Rule findLeftProducingRule(GenClass metaclass, Rule rule) {
    	if (rule == null) return null;
    	return findLeftProducingRule(metaclass, rule.getDefinition(), rule); 
	}

	private Rule findLeftProducingRule(GenClass metaclass, Choice c, Rule currentRule) {
		for (Sequence sequence : c.getOptions()) {
			Rule leftProducingRule = findLeftProducingRule(metaclass, sequence, currentRule);
			if (leftProducingRule != null) return leftProducingRule;
		}
		return null;
	}

	Rule findLeftProducingRule(GenClass metaclass, Sequence sequence, Rule currentRule) {
		for (Definition definition : sequence.getParts()) {
			if (definition instanceof Containment) {
				Containment c = (Containment) definition;
				GenClass featureType = c.getFeature().getTypeGenClass();
				if (metaclass.equals(featureType) || 
						//this.genClasses2superNames.get(featureType.getName()).contains(metaclass.getName()) ||
						this.genClasses2superNames.get(metaclass.getName()).contains(featureType.getName())) {
					return currentRule;
				} else {
					Rule featureRule = null;
					EList<Rule> allRules = this.grammar.getAllRules();
					for (Rule rule : allRules) {
						if (rule.getMetaclass().equals(featureType)) {
							featureRule = rule;
						}
					}
					if (currentRule.equals(featureRule) ) {
						if (this.genClasses2superNames.get(metaclass.getName()).contains(currentRule.getMetaclass().getName())) {
							return featureRule;
						}
						else return null; // we have found a recursion, but not for the type we started from
					}
					
					Rule leftProducingRule = findLeftProducingRule(metaclass, featureRule);
					if (leftProducingRule != null) {
						return leftProducingRule;
					}
				}
			}
			else if (definition instanceof CompoundDefinition) {
				CompoundDefinition compound = (CompoundDefinition) definition;
				Rule leftProducingRule = findLeftProducingRule(metaclass, compound.getDefinitions(), currentRule);
				if (leftProducingRule != null) {
					return leftProducingRule;
				}
			} 
			if (  (definition.getCardinality() instanceof PLUS) || definition.getCardinality() == null) {
				break;
			}
		}
		return null;
	}

	public boolean isDirectLeftRecursive(Rule rule) {
		boolean isDirectLeftRecursive = false;
		GenClass metaclass = rule.getMetaclass();
		EList<Sequence> options = rule.getDefinition().getOptions();
		GenFeature recursiveFeature = null;
		for (Sequence sequence : options) {
			Rule leftProducingRule = findLeftProducingRule(metaclass, sequence, rule);
			if (leftProducingRule == null) continue; // choice option not lr
			else if (!rule.equals(leftProducingRule)) return false; // choice option indirect lr 
			else if (sequence.getParts().get(0) instanceof Containment) { // we found a recursion, now it
																		  // needs to start with recursive 
																		  // containment to be direct left recursive
				Containment c = (Containment) sequence.getParts().get(0);
				GenClass featureType = c.getFeature().getTypeGenClass();
				if (metaclass.equals(featureType) || 
						this.genClasses2superNames.get(metaclass.getName()).contains(featureType.getName())) {
					isDirectLeftRecursive = true;
					
					if (recursiveFeature == null) {
						recursiveFeature = c.getFeature();
					} else if (!recursiveFeature.equals(c.getFeature())) return false; // found recursion on another feature, this is not supported
					continue;
				} 
				else return false; // wrong containment type
			}
			else return false; // recursive option which does not start with recursive containment
				
		}
		
		return isDirectLeftRecursive;
	}

	

}