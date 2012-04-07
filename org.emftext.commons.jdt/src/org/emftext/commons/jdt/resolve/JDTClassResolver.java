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
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.emftext.commons.jdt.JDTJavaClass;
import org.emftext.commons.jdt.JdtFactory;
import org.emftext.commons.jdt.JdtPackage;

/**
 * This class can be used to find all Java classes that are available in a given
 * JDT Java project.
 */
public class JDTClassResolver {

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
		return null;
	}
	
	private IJavaProject getJavaProject(IProject project) {
		return (isJavaProject(project) ? JavaCore.create(project) : null);
	}

	public List<JDTJavaClass> getAllClassesInClassPath(final IJavaProject javaProject) {
		List<JDTJavaClass> classes = new ArrayList<JDTJavaClass>();
		try {
			SearchEngine searchEngine = new SearchEngine();
			ClasspathFiller visitor = new ClasspathFiller();
			searchEngine.searchAllTypeNames(null, null, 
					SearchEngine.createJavaSearchScope(new IJavaProject[] {javaProject}), 
					visitor, IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);
			classes = visitor.getClassesInClasspath();
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

	private static final class ClasspathFiller extends TypeNameRequestor {
		
		private List<JDTJavaClass> classesInClasspath = new ArrayList<JDTJavaClass>();

		@Override
		public void acceptType(int modifiers,
				char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			
			JDTJavaClass javaClass = JdtFactory.eINSTANCE.createJDTJavaClass();
			javaClass.setPackageName(String.valueOf(packageName));
			for (char[] enclosingType : enclosingTypeNames) {
				javaClass.getEnclosingTypeNames().add(String.valueOf(enclosingType));
			}
			javaClass.setSimpleName(String.valueOf(simpleTypeName));
			classesInClasspath.add(javaClass);			
		}

		public List<JDTJavaClass> getClassesInClasspath() {
			return classesInClasspath;
		}
	}
}
