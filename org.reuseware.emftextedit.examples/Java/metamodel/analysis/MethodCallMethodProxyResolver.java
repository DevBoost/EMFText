package org.reuseware.java.resource.java.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;
import org.reuseware.java.Class;
import org.reuseware.java.ClassMember;
import org.reuseware.java.Method;
import org.reuseware.java.MethodCall;
import org.reuseware.java.Type;
import org.reuseware.java.VariableReference;

public class MethodCallMethodProxyResolver extends ProxyResolverImpl {

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		MethodCall call = (MethodCall) container;
		Type type = null;
		
		if (call.eContainer() instanceof VariableReference) {
			VariableReference parent = (VariableReference) call.eContainer();
			type = parent.getVariable().getType();
		}
		else if (call.eContainer() instanceof MethodCall) {
			MethodCall parent = (MethodCall) call.eContainer();
			type = parent.getMethod().getType();
		}
		else {
			EObject result = super.doResolve(proxy, container, reference, resource);
			return result;
		}
		
		if (type instanceof org.reuseware.java.Class) {
			String methodName = proxy.eProxyURI().fragment();
			for(ClassMember method : ((Class) type).getMembers()) {
				if (method instanceof Method) {
					if (methodName.equals(((Method)method).getName())) {
						return method;
					}
				}
			}
		}
		
		return null;
	}
	
	

}
