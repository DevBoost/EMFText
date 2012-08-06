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
package org.emftext.sdk.ui.syntaxgenerator.jobs;

import java.util.Collection;

import org.emftext.sdk.generatorconfig.ClassRuleReference;
import org.emftext.sdk.generatorconfig.GeneratorConfig;
import org.emftext.sdk.generatorconfig.GeneratorconfigPackage;
import org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigEObjectUtil;

public class InterpreterCaller {

	public void interpreteGeneratorConfig(GeneratorConfig config) {
		GeneratorConfigInterpreter interpreter = new GeneratorConfigInterpreter();
		InterpreterContext context = new InterpreterContext();
		
		Collection<ClassRuleReference> classRuleReferences = GeneratorconfigEObjectUtil.getObjectsByType(config.eAllContents(), GeneratorconfigPackage.eINSTANCE.getClassRuleReference());
		for (ClassRuleReference classRuleReference : classRuleReferences) {
			interpreter.addObjectToInterprete(classRuleReference);
		}
		
		interpreter.interprete(context);
	}
}
