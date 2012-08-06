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
package org.emftext.languages.petrinets.lib;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import java.util.*;
import org.emftext.language.petrinets.*;
import org.eclipse.emf.ecore.*;

public class StandardlibSemanticsEvaluation {

	public class RemovalException extends Exception {
		private static final long serialVersionUID = -8317569526723196361L;
	}

	public void revertRemovalTransactions() {
		for(RemovalTransaction<?> e : removalTransactions) {
			e.revert();
		}
	}

	private class RemovalTransaction<T> {
		private List<T> list;
		private T element;
		public RemovalTransaction(List<T> l, T e) {
			list = l;
			element = e;
		}

		public void revert() {
			list.add(element);
		}
	}

	private List<RemovalTransaction<?>> removalTransactions;

	private void startTransaction() {
		assert(removalTransactions.isEmpty());
		removalTransactions = new LinkedList<RemovalTransaction<?>>();
	}

	List<PendingChange> pendingChanges = new LinkedList<PendingChange>();

	private class PendingChange {
		private String transitionName;
		private List<Object> arguments;
		public PendingChange(String transitionName, List<Object> arguments) {
			this.transitionName = transitionName;
			this.arguments = arguments;
		}
	}

	private void addPendingChange(String transitionName, List<Object> arguments) {
		this.pendingChanges.add(new PendingChange(transitionName, arguments));
	}

	public void intialisePlaces(EObject model) {
		relayObject(model);
		TreeIterator<EObject> eAllContents = model.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			relayObject(eObject);
		}
	}
	private void relayObject(EObject eObject) {
	}

	public void evaluateSemantics() {
		while(this.pendingChanges.size() > 0) {
			PendingChange pc = pendingChanges.remove(0);
		}
	}

}
