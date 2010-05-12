package org.emftext.sdk.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LicenceHeaderUtil {

	/**
	 * Loads the license head test if the option OptionTypes.LICENCE_HEADER
	 * was specified. If the license can not be found or the license path
	 * was not given, null is returned.
	 * 
	 * @param concreteSyntax
	 * @return
	 */
	public String loadLicenceHeaderText(ConcreteSyntax concreteSyntax) {
		String licenceLocation = getLicenceLocation(concreteSyntax);
		if (licenceLocation == null) {
			return null;
		}
		Resource resource = concreteSyntax.eResource();
		URI resourceUri = resource.getURI();
		URI licenceUri = URI.createURI(licenceLocation);
		if (licenceUri.isRelative()) {
			licenceUri = licenceUri.resolve(resourceUri);
		}
		try {

			InputStream newFileStream = resource
					.getResourceSet().getURIConverter().createInputStream(
							licenceUri);
			return StreamUtil.getContentAsString(newFileStream);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Return the value of the syntax option OptionTypes.LICENCE_HEADER,
	 * or null if the option is not set.
	 * 
	 * @param concreteSyntax
	 * @return
	 */
	public String getLicenceLocation(ConcreteSyntax concreteSyntax) {
		String licenceLocation = OptionManager.INSTANCE
				.getStringOptionValue(concreteSyntax,
						OptionTypes.LICENCE_HEADER);
		return licenceLocation;
	}
}
