/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


public class Cct5ResourcePostProcessor implements org.emftext.test.cct5.resource.cct5.ICct5ResourcePostProcessor {
	
	public void process(org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
