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
package org.emftext.language.java.if2shortif;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractQVTOBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;


public class If2ShortIfBuildAdapter extends AbstractQVTOBuilderAdapter {

	@Override
	public int getTimeout() {
		return 30000;
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
		return "if2shortif";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "shortif2if";
	}

	@Override
	public String getUtilClassName() {
		return "If2ShortIfQVTOStatisticUtil";
	}
	
	@Override
	public String getFileExtension() {
		return "java";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.JAVA;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.JAVA;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("expressions_ConditionalExpression");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("CondExpr2Cond");
	}

}
