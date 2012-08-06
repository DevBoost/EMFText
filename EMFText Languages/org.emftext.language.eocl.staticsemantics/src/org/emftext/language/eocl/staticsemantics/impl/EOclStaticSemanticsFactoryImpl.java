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
package org.emftext.language.eocl.staticsemantics.impl;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.IOclResource;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.factory.OclStaticSemanticsFactory;

public class EOclStaticSemanticsFactoryImpl implements
		OclStaticSemanticsFactory {

	public EOclStaticSemanticsFactoryImpl() {
		
	}
	
	public tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemantics createOclStaticSemantics(IOclResource _resource) {
		return org.emftext.language.eocl.staticsemantics.impl.EOclStaticSemanticsFactoryImplHelper.createOclStaticSemantics(_resource);
	}

}
