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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

/**
 * The PostProcessingContext is passed through all CS post processors to 
 * collect problems that are found during analysis. When post processing
 * is complete, the problems are propagated to the underlying resource. 
 * We do not attach problem right away to the resource, because there may
 * be @SuppressWarnings annotations, which remove warnings after the
 * analysis.
 */
public class PostProcessingContext {

	private class WrappedElementBasedProblem implements IProblemWrapper {

		private ICsProblem problem;
		private EObject cause;
		
		public WrappedElementBasedProblem(ICsProblem problem, EObject cause) {
			super();
			this.problem = problem;
			this.cause = cause;
		}

		public ICsProblem getProblem() {
			return problem;
		}

		public EObject getCause() {
			return cause;
		}

		public boolean wasCausedBy(EObject element) {
			return element == cause;
		}
	}
	
	private class WrappedPositionBasedProblem implements IProblemWrapper {

		private ICsProblem problem;
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		
		public WrappedPositionBasedProblem(ICsProblem problem, int column, int line, int charStart, int charEnd) {
			super();
			this.problem = problem;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
		}

		public ICsProblem getProblem() {
			return problem;
		}
		
		public int getColumn() {
			return column;
		}

		public int getLine() {
			return line;
		}

		public int getCharStart() {
			return charStart;
		}

		public int getCharEnd() {
			return charEnd;
		}

		public boolean wasCausedBy(EObject element) {
			// position-based problems are caused be the root element.
			// actually these problems are not caused by any specific
			// object, but it is most reasonable to assign them to the 
			// root object. This is required by the SuppressWarnings 
			// class which needs a cause for all problems to check 
			// whether a warning needs to be removed or not.
			return element.eContainer() == null;
		}
	}
	
	private CsResource resource;
	private List<IProblemWrapper> problems;

	public PostProcessingContext(CsResource resource) {
		super();
		this.resource = resource;
		this.problems = new ArrayList<IProblemWrapper>();
	}

	public CsResource getResource() {
		return resource;
	}

	public void addProblem(CsProblem problem, int column, int line, int charStart, int charEnd) {
		problems.add(new WrappedPositionBasedProblem(problem, column, line, charStart, charEnd));
	}

	public void addProblem(CsProblem problem, EObject cause) {
		problems.add(new WrappedElementBasedProblem(problem, cause));
	}

	public boolean hasErrors() {
		for (IProblemWrapper wrappedProblem : problems) {
			ICsProblem problem = wrappedProblem.getProblem();
			if (problem.getSeverity() == CsEProblemSeverity.ERROR) {
				return true;
			}
		}
		return false;
	}

	public List<IProblemWrapper> getWarnings() {
		List<IProblemWrapper> warnings = new ArrayList<IProblemWrapper>();
		for (IProblemWrapper problem : problems) {
			if (problem.getProblem().getSeverity() == CsEProblemSeverity.WARNING) {
				warnings.add(problem);
			}
		}
		return Collections.unmodifiableList(warnings);
	}

	public void addProblemsToResource() {
		CsMarkerHelper.unmark(getResource(), CsEProblemType.ANALYSIS_PROBLEM);
		for (IProblemWrapper problem : problems) {
			if (problem instanceof WrappedElementBasedProblem) {
				WrappedElementBasedProblem elementBasedProblem = (WrappedElementBasedProblem) problem;
				getResource().addProblem(elementBasedProblem.getProblem(), elementBasedProblem.getCause());
			} else if (problem instanceof WrappedPositionBasedProblem) {
				WrappedPositionBasedProblem positionBasedProblem = (WrappedPositionBasedProblem) problem;
				getResource().addProblem(positionBasedProblem.getProblem(), positionBasedProblem.getColumn(), positionBasedProblem.getLine(), positionBasedProblem.getCharStart(), positionBasedProblem.getCharEnd());
			} else {
				assert false;
			}
		}
	}

	public void removeWarning(IProblemWrapper warningToRemove) {
		problems.remove(warningToRemove);
	}
}
