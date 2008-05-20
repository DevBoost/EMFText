package org.reuseware.java.resource.java.analysis; 

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.reuseware.emftextedit.resource.*;
import org.reuseware.emftextedit.resource.impl.*;
import org.reuseware.java.Classifier;
import org.reuseware.java.CompilationUnit;
import org.reuseware.java.Import;

public class TypeProxyResolver extends ProxyResolverImpl {

	
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		//imports
		while(container.eContainer() != null) {
			container = container.eContainer();
		}
		
		CompilationUnit cu = (CompilationUnit) container;
		
		for(Import imp : cu.getImports()) {
			for (Classifier t : imp.getClassifiers()) {
				if(!t.eIsProxy())
					if (t.getName().equals(proxy.eProxyURI().fragment())) {
						return t;
					}
			}
		}
		
		//same package
		IContainer folder = ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true)).getParent();   
		final URI folderURI  = resource.getURI().trimSegments(1);
		final ResourceSet rs = resource.getResourceSet();

		String typeName  = proxy.eProxyURI().fragment();
		Resource typeDef = rs.getResource(folderURI.appendSegment(typeName + ".java"), false);
		
		if (typeDef != null) {
			CompilationUnit importedCu = (CompilationUnit) typeDef.getContents().get(0);
			return importedCu.getTypeDeclarations().get(0);
		}
		
		try {
			folder.accept(new IResourceVisitor() {
				
				private boolean root = true;
				
				public boolean visit(IResource resource) throws CoreException {
					if(root) {
						root = false;
						return true;
					}
					
					if(resource instanceof IFile) {
						IFile file = (IFile) resource;
						if ("java".equals(file.getFileExtension())) {
							rs.getResource(folderURI.appendSegment(file.getName()), true);
						}
					}
					return false;
				}
				
			});
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if (typeDef == null) {
			return null;
		}
		else {
			CompilationUnit importedCu = (CompilationUnit) typeDef.getContents().get(0);
			return importedCu.getTypeDeclarations().get(0);
		}
	}
}
