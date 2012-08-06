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

public class JumpTargetReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Jump, sg.edu.nus.comp.simTL.language.java.simTL4J.statements.JumpLabel> {
	
	private sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultResolverDelegate<sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Jump, sg.edu.nus.comp.simTL.language.java.simTL4J.statements.JumpLabel> delegate = new sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultResolverDelegate<sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Jump, sg.edu.nus.comp.simTL.language.java.simTL4J.statements.JumpLabel>();
	
	public void resolve(java.lang.String identifier, sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Jump container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult<sg.edu.nus.comp.simTL.language.java.simTL4J.statements.JumpLabel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(sg.edu.nus.comp.simTL.language.java.simTL4J.statements.JumpLabel element, sg.edu.nus.comp.simTL.language.java.simTL4J.statements.Jump container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
