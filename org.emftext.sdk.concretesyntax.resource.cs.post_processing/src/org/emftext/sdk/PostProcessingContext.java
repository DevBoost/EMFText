package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;
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
		private int i1;
		private int i2;
		private int i3;
		private int i4;
		
		public WrappedPositionBasedProblem(ICsProblem problem, int i1, int i2, int i3, int i4) {
			super();
			this.problem = problem;
			this.i1 = i1;
			this.i2 = i2;
			this.i3 = i3;
			this.i4 = i4;
		}

		public ICsProblem getProblem() {
			return problem;
		}
		
		public int getI1() {
			return i1;
		}

		public int getI2() {
			return i2;
		}

		public int getI3() {
			return i3;
		}

		public int getI4() {
			return i4;
		}

		public boolean wasCausedBy(EObject element) {
			// position-based problems are caused be the root element.
			// actually these problems are not caused by any specific
			// object, but it is most reasonable to assign them to the 
			// root object. This is required by the SuppressWarnings 
			// class which needs a cause for all problems to check 
			// whether a warning needs to be remove or not.
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

	public void addProblem(CsProblem problem, int i1, int i2, int i3, int i4) {
		problems.add(new WrappedPositionBasedProblem(problem, i1, i2, i3, i4));
	}

	public void addProblem(CsProblem problem, EObject cause) {
		problems.add(new WrappedElementBasedProblem(problem, cause));
	}

	public boolean hasErrors() {
		for (IProblemWrapper wrappedProblem : problems) {
			ICsProblem problem = wrappedProblem.getProblem();
			if (problem.getType() == CsEProblemType.ERROR) {
				return true;
			}
		}
		return false;
	}

	public List<IProblemWrapper> getWarnings() {
		List<IProblemWrapper> warnings = new ArrayList<IProblemWrapper>();
		for (IProblemWrapper problem : problems) {
			if (problem.getProblem().getType() == CsEProblemType.WARNING) {
				warnings.add(problem);
			}
		}
		return Collections.unmodifiableList(warnings);
	}

	public void addProblemsToResource() {
		for (IProblemWrapper problem : problems) {
			if (problem instanceof WrappedElementBasedProblem) {
				WrappedElementBasedProblem elementBasedProblem = (WrappedElementBasedProblem) problem;
				getResource().addProblem(elementBasedProblem.getProblem(), elementBasedProblem.getCause());
			} else if (problem instanceof WrappedPositionBasedProblem) {
				WrappedPositionBasedProblem positionBasedProblem = (WrappedPositionBasedProblem) problem;
				getResource().addProblem(positionBasedProblem.getProblem(), positionBasedProblem.getI1(), positionBasedProblem.getI2(), positionBasedProblem.getI3(), positionBasedProblem.getI4());
			} else {
				assert false;
			}
		}
	}

	public void removeWarning(IProblemWrapper warningToRemove) {
		problems.remove(warningToRemove);
	}
}
