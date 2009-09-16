package org.emftext.runtime.ui.impl;

import org.emftext.runtime.ui.IBackgroundParsingStrategy;

/**
 * This class is used to adapt existing text resource plug-ins to API
 * changes. For EMFText 1.2.0 is must be empty. Future version may add
 * default implementations for new methods that are added to 
 * IBackgroundParsingStrategy.
 */
@Deprecated
public abstract class AbstractBackgroundParsingStrategy implements IBackgroundParsingStrategy {

	// Attention: Please do add only code that adapts existing implementations of
	// old versions of IBackgroundParsingStrategy here.
	// Please document the date and version when the API was changed
}
