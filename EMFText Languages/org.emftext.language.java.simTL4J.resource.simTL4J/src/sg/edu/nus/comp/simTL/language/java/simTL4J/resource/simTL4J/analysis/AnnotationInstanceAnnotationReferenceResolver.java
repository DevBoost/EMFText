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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import sg.edu.nus.comp.simTL.language.java.simTL4J.JavaClasspath;
import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationInstance;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Annotation;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Classifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.ConcreteClassifierDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.IResolutionTargetDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.ScopedTreeWalker;

public class AnnotationInstanceAnnotationReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationInstance, sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Classifier> {
	
	public java.lang.String deResolve(Classifier element, AnnotationInstance container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, AnnotationInstance annotationInstance, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ISimTL4JReferenceResolveResult<Classifier> result) {
		List<sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		EObject startingPoint = annotationInstance;
		EObject target =  null; 
		
		if(annotationInstance.getNamespaces().size() > 0) {
			EObject lastClassInNS = ConcreteClassifierDecider.resolveRelativeNamespace(
					annotationInstance, 0, annotationInstance, annotationInstance, reference);
			if (lastClassInNS != null) {
				startingPoint = lastClassInNS;
			}
			else {
				//absolute class starting with package
				target = resolveFullQualifiedAnnotationReferences(identifier, annotationInstance);
			}
		}
		
		if (target == null) {
			deciderList.add(new ConcreteClassifierDecider());		
			ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
			target = treeWalker.walk(startingPoint, identifier, annotationInstance, reference);
		}
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
	
	private EObject resolveFullQualifiedAnnotationReferences(String identifier,
			AnnotationInstance annotationInstance) {
			
		if (annotationInstance.getNamespaces().size() > 0) {
			String containerName = annotationInstance.getNamespacesAsString();
			ConcreteClassifier target = (ConcreteClassifier) EcoreUtil.resolve(
					JavaClasspath.get(annotationInstance).getClassifier(containerName + identifier), annotationInstance.eResource());
		
			if (target instanceof Annotation) {
				return target;
			}
		}
		
		return null;
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
