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
package org.emftext.language.java.treejava.resource.compiler;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.instantiations.InstantiationsFactory;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.treejava.Node;
import org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaResource;

public class TreeJavaCompiler {

	public void compile(TreejavaResource resource) throws IOException {
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		final Resource javaResource = resource.getResourceSet().createResource(javaURI);
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));

		boolean changed = true;

		while (changed) {
			changed = false;

			for(Iterator<EObject> i = javaResource.getAllContents(); i.hasNext(); ) {
				EObject next = i.next();
				if(next instanceof Node) {
					Node node = (Node) next;
					NewConstructorCall ncc = convertTreeToNewConstructorCallChain(node);
					EcoreUtil.replace(node, ncc);
					changed = true;
					break;
				}
			}
		}

		javaResource.save(null);
	}

	private NewConstructorCall convertTreeToNewConstructorCallChain(Node rootNode) {
		NewConstructorCall ncc = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		ncc.setTypeReference(rootNode.getTypeReference());
		if (rootNode.getName() != null) {
			StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
			stringReference.setValue(rootNode.getName());
			ncc.getArguments().add(stringReference);
		}
		for(Node childNode : rootNode.getChildren()) {
			NewConstructorCall childNcc = convertTreeToNewConstructorCallChain(childNode);
			ncc.getArguments().add(childNcc);
		}
		return ncc;
	}
}
