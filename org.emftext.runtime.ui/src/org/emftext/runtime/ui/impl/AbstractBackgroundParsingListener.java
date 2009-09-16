package org.emftext.runtime.ui.impl;

import org.emftext.runtime.ui.IBackgroundParsingListener;

/**
 * This class is used to adapt existing text resource plug-ins to API
 * changes. For EMFText 1.2.0 is must be empty. Future version may add
 * default implementations for new methods that are added to 
 * IBackgroundParsingListener.
 */
@Deprecated
public abstract class AbstractBackgroundParsingListener implements IBackgroundParsingListener {

	// Attention: Please do add only code that adapts existing implementations of
	// old versions of IBackgroundParsingListener here.
	// Please document the date and version when the API was changed
}
