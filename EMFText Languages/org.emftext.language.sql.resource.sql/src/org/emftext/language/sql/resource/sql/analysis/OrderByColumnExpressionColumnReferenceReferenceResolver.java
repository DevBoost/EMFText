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
package org.emftext.language.sql.resource.sql.analysis;

public class OrderByColumnExpressionColumnReferenceReferenceResolver implements org.emftext.language.sql.resource.sql.ISqlReferenceResolver<org.emftext.language.sql.select.orderBy.OrderByColumnExpression, org.emftext.language.sql.select.column.Column> {
	
	private org.emftext.language.sql.resource.sql.analysis.SqlDefaultResolverDelegate<org.emftext.language.sql.select.orderBy.OrderByColumnExpression, org.emftext.language.sql.select.column.Column> delegate = new org.emftext.language.sql.resource.sql.analysis.SqlDefaultResolverDelegate<org.emftext.language.sql.select.orderBy.OrderByColumnExpression, org.emftext.language.sql.select.column.Column>();
	
	public void resolve(String identifier, org.emftext.language.sql.select.orderBy.OrderByColumnExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.sql.resource.sql.ISqlReferenceResolveResult<org.emftext.language.sql.select.column.Column> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.sql.select.column.Column element, org.emftext.language.sql.select.orderBy.OrderByColumnExpression container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
