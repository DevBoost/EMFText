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

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Enumeration;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.StaticMemberImport;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.EnumConstant;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.Member;
import sg.edu.nus.comp.simTL.language.java.simTL4J.modifiers.AnnotableAndModifiable;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferenceableElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult;

public class StaticMemberImportStaticMembersReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.imports.StaticMemberImport, sg.edu.nus.comp.simTL.language.java.simTL4J.references.ReferenceableElement> {
	
	public java.lang.String deResolve(ReferenceableElement element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, StaticMemberImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ISimTL4JReferenceResolveResult<ReferenceableElement> result) {
		ConcreteClassifier classifier = theImport.getClassifierAtNamespaces();
		classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : classifier.getAllMembers(theImport)) {
				if (identifier.equals(member.getName()) && member instanceof ReferenceableElement) {
					if (member instanceof AnnotableAndModifiable) {
						if (member.eIsProxy()) {
							member = (Member) EcoreUtil.resolve(member, theImport);
						}
						if(((AnnotableAndModifiable)member).isStatic()) {
							result.addMapping(identifier, (ReferenceableElement) member);
						}
					}
				}
			}
			
			if (classifier instanceof Enumeration) {
				for(EnumConstant enumConstant : ((Enumeration)classifier).getConstants()) {
					if (identifier.equals(enumConstant.getName())) {
						result.addMapping(identifier, enumConstant);
						return;
					}
				}
			}
		}	
	}
 
	public void setOptions(Map<?, ?> options) {
	}
	
}
