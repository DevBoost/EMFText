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
package org.emftext.language.formsextension.resource.formsextension.mopp;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.formsextension.ExtendedForm;
import org.emftext.language.formsextension.resource.formsextension.IFormsextensionBuilder;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.instantiations.InstantiationsFactory;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;

public class FormsextensionBuilder implements IFormsextensionBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// return true to enable building of all resources
		return true;
	}
	
	public IStatus build(FormsextensionResource resource, IProgressMonitor monitor) {
		URI uri = resource.getURI();
		if (isInBinFolder(uri)) {
			return Status.CANCEL_STATUS; 
		}
		
		if (resource.getWarnings().size() + resource.getErrors().size() > 0) {
			return Status.CANCEL_STATUS; 
		}
		
		EObject root = resource.getContents().get(0);
		if (root instanceof ExtendedForm) {
			ExtendedForm eform = (ExtendedForm) root;
			ClassMethod javaMethod = eform.getJavaMethod();
			if (javaMethod == null || javaMethod.eIsProxy()) {
				return Status.CANCEL_STATUS; 
			}
			fillMethodWithInterpreterCall(resource, javaMethod);
			
			try {
				javaMethod.eResource().save(Collections.EMPTY_MAP);
			} catch (Exception e) {
				e.printStackTrace();
				return Status.CANCEL_STATUS;
			}
		}
		
		return Status.OK_STATUS;
	}

	private boolean isInBinFolder(URI uri) {
		for (String segment : uri.segments()) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}

	private void fillMethodWithInterpreterCall(FormsextensionResource resource,
			ClassMethod javaMethod) {
		EList<Statement> body = javaMethod.getStatements();
		
		NewConstructorCall constructorCall = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		ClassifierReference classifierRef = TypesFactory.eINSTANCE.createClassifierReference();
		
		Class clazz = ClassifiersFactory.eINSTANCE.createClass();
		clazz.setName("org.emftext.language.forms.interpreter.FormInterpreter");
		classifierRef.setTarget(clazz);
		constructorCall.setTypeReference(classifierRef);
		
		ExpressionStatement statement = StatementsFactory.eINSTANCE.createExpressionStatement();
		statement.setExpression(constructorCall);
		body.clear();
		body.add(statement);
		MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
		ClassMethod callMethod = MembersFactory.eINSTANCE.createClassMethod();
		callMethod.setName("interprete");
		methodCall.setTarget(callMethod);
		StringReference stringExpression = ReferencesFactory.eINSTANCE.createStringReference();
		IFile file = WorkspaceSynchronizer.getFile(resource);
		String uri = file.getProjectRelativePath().toString();
		stringExpression.setValue(uri);
		methodCall.getArguments().add(stringExpression);
		
		constructorCall.setNext(methodCall);
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
