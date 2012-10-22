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
package org.emftext.commons.jdt.resolve;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.emftext.commons.jdt.JDTJavaClassifier;
import org.emftext.commons.jdt.JdtPackage;

/**
 * This class can be used to find all Java classifiers that are available in a 
 * given JDT Java project.
 */
public class JDTClassifierResolver {

	/**
	 * Returns the Java project that is located at the given URI. If the project
	 * at this locations is not a Java project or if there is no project at all,
	 * <code>null</code> is returned.
	 */
	public IJavaProject getJavaProject(URI uri) {
		IProject project = getProject(uri);
		if (project == null) {
			return null;
		}
		IJavaProject javaProject = getJavaProject(project);
		return javaProject;
	}
	
	private boolean isJavaProject(IProject project) {
		if (project == null) {
			return false;
		}
		try {
			return project.isNatureEnabled("org.eclipse.jdt.core.javanature");
		} catch (CoreException e) {
		}
		return false;
	}

	private IProject getProject(URI uri) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (uri.isPlatformResource() && uri.segmentCount() > 2) {
			return root.getProject(uri.segment(1));
		}
		throw new IllegalArgumentException("Can't handle URIs that do not reference platform resources.");
	}
	
	private IJavaProject getJavaProject(IProject project) {
		return (isJavaProject(project) ? JavaCore.create(project) : null);
	}

	/**
	 * Returns a list of all Java classifiers that are available in the 
	 * classpath of the given project.
	 */
	public List<JDTJavaClassifier> getAllClassifiersInClassPath(IJavaProject project) {
		List<JDTJavaClassifier> classes = new ArrayList<JDTJavaClassifier>();
		try {
			SearchEngine searchEngine = new SearchEngine();
			ClassifierVisitor visitor = new ClassifierVisitor(project);
			searchEngine.searchAllTypeNames(null, null, 
					SearchEngine.createJavaSearchScope(new IJavaProject[] {project}), 
					visitor, IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);
			classes = visitor.getClassifiersInClasspath();
		} catch (JavaModelException e) { 
			log("Problem building classpath", e);
		}
		return classes;
	}

	private void log(String msg, JavaModelException e) {
		String pluginName = JdtPackage.class.getPackage().getName();
		Status status = new Status(IStatus.WARNING, pluginName, msg, e);
		ResourcesPlugin.getPlugin().getLog().log(status);
	}
}
