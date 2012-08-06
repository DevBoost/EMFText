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
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import sg.edu.nus.comp.simTL.language.java.simTL4J.JavaClasspath;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Classifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.containers.CompilationUnit;
import sg.edu.nus.comp.simTL.language.java.simTL4J.expressions.Expression;
import sg.edu.nus.comp.simTL.language.java.simTL4J.expressions.NestedExpression;
import sg.edu.nus.comp.simTL.language.java.simTL4J.instantiations.NewConstructorCall;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ElementReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.IdentifierReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.Reference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferenceableElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferencesPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.ConcreteClassifierDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.EnumConstantDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.FieldDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.IResolutionTargetDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.LocalVariableDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.MethodDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.PackageDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.ParameterDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.TypeParameterDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.ScopedTreeWalker;
import sg.edu.nus.comp.simTL.language.java.simTL4J.types.PrimitiveType;
import sg.edu.nus.comp.simTL.language.java.simTL4J.util.TemporalCompositeClassifier;

public class ElementReferenceTargetReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.references.ElementReference, sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferenceableElement> {
	
	public java.lang.String deResolve(ReferenceableElement element, ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof ConcreteClassifier) {
			ConcreteClassifier concreteClassifier = (ConcreteClassifier) element;
			
			Object fullNamesOption = container.eResource().getResourceSet().getLoadOptions().get(
					JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES);	
			if (!(fullNamesOption instanceof Boolean)) {
				fullNamesOption = Boolean.FALSE;
			}		
			if (container.getPrevious() == null && Boolean.TRUE.equals(fullNamesOption)) {
				String packageName = "";
				String fullClassName = concreteClassifier.getName();
				EObject parent = concreteClassifier.eContainer();
				while(parent instanceof Classifier) {
					fullClassName = ((Classifier)parent).getName() + "." + fullClassName;
					parent = parent.eContainer();
				}
				if (parent instanceof CompilationUnit) {
					EList<String> namespaces = ((CompilationUnit)parent).getNamespaces();
					for(String s : namespaces) { packageName += s + "."; }
				}
				return packageName + fullClassName;
			}
			
			if(concreteClassifier.getFullName() != null) {
				return concreteClassifier.getFullName();
			}
		}
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ISimTL4JReferenceResolveResult<ReferenceableElement> result) {
		EObject startingPoint = null;
		EObject alternativeStartingPoint = null;
		EObject target = null;
		Reference parentReference = null;
		
		if(container.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			//a follow up reference: different scope
			parentReference = (Reference) container.eContainer();
			if (parentReference instanceof IdentifierReference &&
					((IdentifierReference)parentReference).getTarget() instanceof Package) {
				startingPoint = ((IdentifierReference)parentReference).getTarget();
			}
			else {
				startingPoint = parentReference.getReferencedType();
				if (parentReference instanceof NestedExpression) {
					alternativeStartingPoint = ((NestedExpression) parentReference
							).getExpression().getAlternativeType();
				}
			
				//do not search on primitive types but their class representation
				if (startingPoint instanceof PrimitiveType) {
					startingPoint = ((PrimitiveType) startingPoint).wrapPrimitiveType();
				}

				if (parentReference instanceof NestedExpression) {
					startingPoint = (((NestedExpression)parentReference).getExpression()).getType();
				}
				
				//special case: anonymous class in constructor call
				while (parentReference instanceof NestedExpression) {
					Expression nestedExpression = ((NestedExpression)parentReference).getExpression();
					if (nestedExpression instanceof Reference) {
						parentReference = (Reference) nestedExpression; 
					}
					else {
						parentReference = null;
					}
				}
				if (parentReference instanceof NewConstructorCall &&
						((NewConstructorCall)parentReference).getAnonymousClass() != null) {
					startingPoint = ((NewConstructorCall)parentReference).getAnonymousClass();
				}
				
			}
		}
		else {
			startingPoint = container;
		}
		
		if(target == null) {
			if(startingPoint instanceof TemporalCompositeClassifier) {
				for(EObject superType : ((TemporalCompositeClassifier)startingPoint).getSuperTypes()) {
					target = searchFromStartingPoint(identifier, container, reference,
							superType);
					if (target != null) {
						break;
					}
				}
			}
			else {
				target = searchFromStartingPoint(identifier, container, reference,
						startingPoint);	
			}
		}
		if(target == null && alternativeStartingPoint != null && !alternativeStartingPoint.equals(startingPoint)) {
			target = searchFromStartingPoint(identifier, container, reference,
					alternativeStartingPoint);
		}
		
		if (target != null) {
			result.addMapping(identifier, (ReferenceableElement) target);
		}
	}

	private EObject searchFromStartingPoint(java.lang.String identifier,
			ElementReference container,
			org.eclipse.emf.ecore.EReference reference, EObject startingPoint) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		deciderList.add(new EnumConstantDecider());
		deciderList.add(new FieldDecider());
		deciderList.add(new LocalVariableDecider());
		deciderList.add(new ParameterDecider());
		deciderList.add(new MethodDecider());
		
		deciderList.add(new ConcreteClassifierDecider());
		deciderList.add(new TypeParameterDecider());
		
		deciderList.add(new PackageDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		return treeWalker.walk(startingPoint, identifier, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
