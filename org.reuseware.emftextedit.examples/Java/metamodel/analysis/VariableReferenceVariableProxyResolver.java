package org.reuseware.java.resource.java.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;
import org.reuseware.java.Class;
import org.reuseware.java.ClassMember;
import org.reuseware.java.JavaPackage;
import org.reuseware.java.MethodCall;
import org.reuseware.java.Type;
import org.reuseware.java.Variable;
import org.reuseware.java.VariableReference;

public class VariableReferenceVariableProxyResolver extends ProxyResolverImpl {

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		VariableReference ref = (VariableReference) container;
		Type type = null;
		
		if (reference.equals(JavaPackage.Literals.REFERENCE__NEXT)) {
			if (ref.eContainer() instanceof VariableReference) {
				VariableReference parent = (VariableReference) ref.eContainer();
				type = parent.getVariable().getType();
			}
			else if (ref.eContainer() instanceof MethodCall) {
				MethodCall parent = (MethodCall) ref.eContainer();
				type = parent.getMethod().getType();
			}
		}
		else {
			EObject result = super.doResolve(proxy, container, reference, resource);
			return result;
		}
		
		if (type instanceof org.reuseware.java.Class) {
			String varName = proxy.eProxyURI().fragment();
			for(ClassMember var : ((Class) type).getMembers()) {
				if (var instanceof Variable) {
					if (varName.equals(((Variable)var).getName())) {
						return var;
					}
				}
			}
		}
		
		return null;
	}
}
