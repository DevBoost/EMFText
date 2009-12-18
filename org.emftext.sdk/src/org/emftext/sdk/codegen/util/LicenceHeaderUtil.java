package org.emftext.sdk.codegen.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.StreamUtil;

public class LicenceHeaderUtil {

	/**
	 * Loads the licence head test if the option OptionTypes.LICENCE_HEADER
	 * was specified. If the licence can not be found or the licence path
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
			return StreamUtil.getContent(newFileStream);
		} catch (IOException e) {
			return null;
		}
	}

	public String getLicenceLocation(ConcreteSyntax concreteSyntax) {
		String licenceLocation = OptionManager.INSTANCE
				.getStringOptionValue(concreteSyntax,
						OptionTypes.LICENCE_HEADER);
		return licenceLocation;
	}

}
