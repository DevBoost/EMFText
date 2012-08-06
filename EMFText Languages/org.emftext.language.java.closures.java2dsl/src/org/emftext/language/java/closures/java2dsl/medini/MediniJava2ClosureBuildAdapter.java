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
package org.emftext.language.java.closures.java2dsl.medini;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractMediniBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;

public class MediniJava2ClosureBuildAdapter extends AbstractMediniBuilderAdapter {

	@Override
	public int getTimeout() {
		return 3000000;
	}

	@Override
	public int getMaxActiveThreads() {
		return 1;
	}

	@Override
	public String getDirectoryWithScripts() {
		return "transformations";
	}

	@Override
	public String getScriptInOneDirection() {
		return "java2closure";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "java2closure";
	}

	@Override
	public String getUtilClassName() {
		return "ClosureMediniStatisticUtil";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.CLOSURE;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.CLOSURE;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("Closures_Closure");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("Closures_Closure");
	}

	@Override
	public String getFileExtension() {
		return "closure";
	}

	@Override
	public String getTransformationName() {
		return "copy";
	}

	@Override
	public String getDomainNameInLeftDirection() {
		return "CLOSURES";
	}

	@Override
	public String getDomainNameInRightDirection() {
		return "JAVA";
	}
	
	
}
