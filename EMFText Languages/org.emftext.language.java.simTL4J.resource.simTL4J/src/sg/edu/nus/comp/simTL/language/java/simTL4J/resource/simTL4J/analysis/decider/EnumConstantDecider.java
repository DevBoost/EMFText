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
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ClassifiersPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Enumeration;
import sg.edu.nus.comp.simTL.language.java.simTL4J.commons.NamedElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.expressions.AssignmentExpression;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.ClassifierImport;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.Import;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.ImportingElement;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.StaticClassifierImport;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.StaticMemberImport;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.EnumConstant;
import sg.edu.nus.comp.simTL.language.java.simTL4J.modifiers.AnnotableAndModifiable;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.MethodCall;
import sg.edu.nus.comp.simTL.language.java.simTL4J.references.Reference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.StatementsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Switch;
import sg.edu.nus.comp.simTL.language.java.simTL4J.statements.SwitchCase;
import sg.edu.nus.comp.simTL.language.java.simTL4J.types.Type;
import sg.edu.nus.comp.simTL.language.java.simTL4J.util.TemporalCompositeClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.variables.LocalVariable;


/**
 * A decider that looks for enumeration constants.
 */
public class EnumConstantDecider extends AbstractDecider {

	private EObject reference = null;

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof EnumConstant) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Switch &&
				reference.eContainmentFeature().equals(StatementsPackage.Literals.CONDITIONAL__CONDITION) &&
				reference.eContainer() instanceof SwitchCase) {
			Switch aSwitch = (Switch) container;
			Type variableType = aSwitch.getVariable().getType();
			if (variableType instanceof Enumeration) {
				return ((Enumeration)variableType).getConstants();
			}
			if (variableType instanceof TemporalCompositeClassifier) {
				for(EObject superType : ((TemporalCompositeClassifier)variableType).getSuperTypes()) {
					if (superType instanceof Enumeration) {
						return ((Enumeration)superType).getConstants();
					}
				}
			}
		}
		if (container instanceof AssignmentExpression) {
			AssignmentExpression assignmentExpression = (AssignmentExpression) container;
			Type assignmentExpressionType = assignmentExpression.getType();
			if (assignmentExpressionType instanceof Enumeration) {
				return ((Enumeration)assignmentExpressionType).getConstants();
			}
		}
		if (container instanceof LocalVariable) {
			LocalVariable localVariable = (LocalVariable) container;
			Type assignmentExpressionType = localVariable.getTypeReference().getTarget();
			if (assignmentExpressionType instanceof Enumeration) {
				return ((Enumeration)assignmentExpressionType).getConstants();
			}
		}

		EList<EObject> resultList = addImports(container);

		return resultList;
	}

	private EList<EObject> addImports(EObject container) {
		if(container instanceof ImportingElement) {
			EList<EObject> resultList = new BasicEList<EObject>();
			for(Import aImport : ((ImportingElement)container).getImports()) {
				if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(aImport.getImportedMembers());
				}
				else if (aImport instanceof ClassifierImport) {
					for (EObject member : ((ClassifierImport)aImport).getClassifier().getMembers()) {
						if (member instanceof AnnotableAndModifiable) {
							if(((AnnotableAndModifiable)member).isStatic()) {
								resultList.add(member);
							}
						}
					}
				}
			}
			return resultList;
		}
		return null;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (ClassifiersPackage.Literals.ENUMERATION__CONSTANTS.equals(containingReference)) {
			return true;
		}
		return false;
	}


	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		reference = referenceContainer;
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
