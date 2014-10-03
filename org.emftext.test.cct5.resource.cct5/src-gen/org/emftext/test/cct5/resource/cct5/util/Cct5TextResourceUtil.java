/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class Cct5TextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.
 */
public class Cct5TextResourceUtil {
	
	/**
	 * Use org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated
	public static org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource getResource(IFile file) {
		return new org.emftext.test.cct5.resource.cct5.util.Cct5EclipseProxy().getResource(file);
	}
	
	/**
	 * Use org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated
	public static org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource getResource(File file, Map<?,?> options) {
		return org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated
	public static org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource getResource(URI uri) {
		return org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource(uri);
	}
	
	/**
	 * Use org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated
	public static org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource getResource(URI uri, Map<?,?> options) {
		return org.emftext.test.cct5.resource.cct5.util.Cct5ResourceUtil.getResource(uri, options);
	}
	
}
