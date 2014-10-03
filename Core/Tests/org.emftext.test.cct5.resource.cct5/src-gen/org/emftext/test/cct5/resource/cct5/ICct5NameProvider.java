/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

public interface ICct5NameProvider {
	
	/**
	 * Returns a list of potential identifiers that may be used to reference the given
	 * element. This method can be used to customize the identification of elements.
	 */
	public List<String> getNames(EObject element);
	
}
