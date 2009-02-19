/**
 * 
 */
package org.emftext.sdk.analysis;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * TODO cwende add comment
 */
public class LeftRecursionDetector {

	private Map<String, Collection<String>> genClassNames2superNames;
	private ConcreteSyntax grammar;

	public LeftRecursionDetector(
			Map<String, Collection<String>> genClassNames2superNames, ConcreteSyntax concreteSyntax) {
		this.genClassNames2superNames = genClassNames2superNames;
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

	public Rule findLeftProducingRule(GenClass metaclass, Sequence sequence, Rule currentRule) {
		for (Definition definition : sequence.getParts()) {
			if (definition instanceof Containment) {
				Containment c = (Containment) definition;
				final GenFeature feature = c.getFeature();
				if (feature == null) {
					continue;
				}
				if (feature.getEcoreFeature() == null) {
					continue;
				}
				GenClass featureType = feature.getTypeGenClass();
				if (metaclass.equals(featureType) || 
						//this.genClasses2superNames.get(featureType.getName()).contains(metaclass.getName()) ||
						genClassNames2superNames.get(metaclass.getQualifiedInterfaceName()).contains(featureType.getQualifiedInterfaceName())) {
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
						if (genClassNames2superNames.get(metaclass.getQualifiedInterfaceName()).contains(currentRule.getMetaclass().getQualifiedInterfaceName())) {
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
						genClassNames2superNames.get(metaclass.getQualifiedInterfaceName()).contains(featureType.getQualifiedInterfaceName())) {
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