package org.reuseware.java.resource.java.analysis; 

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;
import org.reuseware.java.Import;
import org.reuseware.java.JavaFactory;

public class ImportClassifiersProxyResolver extends ProxyResolverImpl {

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		Import imp = (Import) container;
		String className = proxy.eProxyURI().fragment();
		
		String qName = "";
		
		for(String pName : imp.getPackage()) {
			qName = qName + pName + ".";
		}
		
		qName = qName + className;
		
		Class<?> theCLass;
		try {
			theCLass = Class.forName(qName);
			
			org.reuseware.java.Class importedClass = JavaFactory.eINSTANCE.createClass();
			importedClass.setName(className);
			
			for(Method aMethod : theCLass.getMethods()) {
				org.reuseware.java.Method member = JavaFactory.eINSTANCE.createMethod();
				member.setName(aMethod.getName());
				importedClass.getMembers().add(member);
			}
			return importedClass;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
