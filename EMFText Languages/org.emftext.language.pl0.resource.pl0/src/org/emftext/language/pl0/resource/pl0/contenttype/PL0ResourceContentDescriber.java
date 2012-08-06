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
package org.emftext.language.pl0.resource.pl0.contenttype;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource;
import org.emftext.language.pl0.resource.pl0.util.Pl0StreamUtil;

public class PL0ResourceContentDescriber implements IContentDescriber {

	public PL0ResourceContentDescriber() {
		
	}

	public int describe(InputStream contents, IContentDescription description) throws IOException {
		try {
			Resource resource = new Pl0Resource();
			String content = Pl0StreamUtil.getContent(contents);
			ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes());
			// here a NPE is thrown but as far as I debugged 
			// I could see that the content could be parsed correctly
			resource.load(stream, Collections.EMPTY_MAP);
			if(resource.getContents().get(0) instanceof Program){
				return IContentDescriber.VALID;
			} else {
				return IContentDescriber.INVALID;
			}
		} catch (Exception e) {
			// do nothing
		}
		return IContentDescriber.INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
