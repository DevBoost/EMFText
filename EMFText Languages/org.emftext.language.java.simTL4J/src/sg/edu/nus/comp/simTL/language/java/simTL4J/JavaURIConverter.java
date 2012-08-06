/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package sg.edu.nus.comp.simTL.language.java.simTL4J;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;

public class JavaURIConverter extends ExtensibleURIConverterImpl {

	private URIMap parentMap = null;
	
	public void setParentMap(URIMap parentMap) {
		this.parentMap = parentMap;
	}

	protected URIMap getInternalURIMap() {
		if (uriMap == null)	{
			URIMappingRegistryImpl mappingRegistryImpl = new URIMappingRegistryImpl() {
				
				private static final long serialVersionUID = 1L;

				@Override
				protected URI delegatedGetURI(URI uri) {
					if (parentMap != null) {
						URI mappedUri = parentMap.getURI(uri);
						if (! uri.equals(mappedUri)) {
							// System.out.println("Mapped " + uri + " to " + mappedUri + " by " + JavaURIConverter.this);
						}
						return mappedUri;
					}
					return URIMappingRegistryImpl.INSTANCE.getURI(uri);
				}
			};
			uriMap = (URIMap)mappingRegistryImpl.map();
		}
		return uriMap;
	}

}
