package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IHoverTextProvider;

/**
 * This class is used to adapt existing text resource plug-ins to API
 * changes. For EMFText 1.2.0 is must be empty. Future version may add
 * default implementations for new methods that are added to IHoverTextProvider.
 */
public abstract class AbstractHoverTextProvider implements IHoverTextProvider {

	// Attention: Please do add only code that adapts existing implementations of
	// old versions of IHoverTextProvider here.
	// Please document the date and version when the API was changed
}
