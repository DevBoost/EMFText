package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Basic Interface to directly manipulate parsed tokens and convert them into the attribute type in the meta model.
 * All generated TokenResolvers inherit from JavaBasedTokenResolver which does the standard conversion to Java Types.
 * 
 * @see org.emftext.runtime.resource.impl.JavaBasedTokenResolver
 * @see org.emftext.sdk.codegen.TokenResolverGenerator
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface ITokenResolver extends IConfigurable {
	
	/**
	 * Converts a token into an Object (might be a String again). 
	 * 
	 * @param lexem the parsed String
	 * @param feature the corresponding feature in the meta model
	 * @param result the result of resolving the lexem, can be used to add processing errors
	 */
	public void resolve(String lexem, EStructuralFeature feature, ITokenResolveResult result);
	// TODO mseifert: remove these two methods
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource);
	public String getErrorMessage();
	
	/**
	 * Does the inverse mapping from Object to a lexem which can be printed.
	 * 
	 * @param value the Object to be printed as String
	 * @param feature the corresponding feature
	 * @param container the container of the object
	 * @return the String representation or null if a problem occurred
	 */
	public String deResolve(Object value, EStructuralFeature feature, EObject container);
}
