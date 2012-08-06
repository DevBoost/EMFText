/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.modelquery.resource;

import java.lang.ref.WeakReference;
import java.util.Set;

import org.reuseware.sokan.ID;
import org.reuseware.sokan.index.notify.IndexListener;
import org.reuseware.sokan.index.util.IndexUtil;

public class CustomModelqueryResourceIndexListener implements IndexListener {

	private WeakReference<CustomModelqueryResource> resourceRef = null;
	//private URI resourceURI = null;
	
	public CustomModelqueryResourceIndexListener(
			CustomModelqueryResource resource) {
		this.resourceRef = new WeakReference<CustomModelqueryResource>(resource);
		//this.resourceURI = resource.getURI();
	}

	public void indexChanged(Set<ID> delta) {
		CustomModelqueryResource resource = resourceRef.get();
		if (resource != null) {
			//TODO #1811: this will not trigger an update of the Reuseware composition interface of
			//     the modelquery since the index for the modelquery itself is not updated. 
			//     Updating it here however would result in an infinite loop since the update would
			//     call this listener again.
			resource.executeQuery();
		}
		else {
			IndexUtil.INSTANCE.removeListener(this);
		}
	}

}
