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
package org.emftext.sdk.codegen.resource.generators.mopp;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.util.BinaryIntegerSplitter;

import de.devboost.codecomposers.java.JavaComposite;
import de.devboost.codecomposers.util.Pair;

public class ExpectationsConstantsGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"This class contains some constants that are used during code completion."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		List<Integer[]> expectationCalls = getContext().getConstantsPool().getExpectationCalls();
		sc.add("public final static int EXPECTATIONS[][] = new int[" + expectationCalls.size() + "][];");
		sc.addLineBreak();
		sc.add("public static int index;");
		sc.addLineBreak();
		
		List<Pair<String,Integer>> statements = new ArrayList<Pair<String,Integer>>();
		statements.add(new Pair<String,Integer>(
			"index = 0;", 20 // this is just a rough estimation
		));
		for (Integer[] expectationCall : expectationCalls) {
			statements.add(new Pair<String,Integer>(
				"EXPECTATIONS[index] = new int[" + expectationCall.length + "];",20 // this is just a rough estimation
			));
			int index2 = 0;
			for (Integer integer : expectationCall) {
				BinaryIntegerSplitter splitter = new BinaryIntegerSplitter(integer.intValue());
				String binaryCode = splitter.getComputationCode();
				int byteCodeSize = 20 + splitter.getOperations() * 5; // this is just a rough estimation
				statements.add(new Pair<String,Integer>(
					"EXPECTATIONS[index][" + index2 +  "] = getValue(" + binaryCode + ");", byteCodeSize
				));
				index2++;
			}
			statements.add(new Pair<String,Integer>(
				"index++;", 20 // this is just a rough estimation
			));
			//index++;
		}
		sc.addLargeMethod("initialize", statements);
		
		sc.add("static {");
		sc.add("initialize();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private static int getValue(int... bits) {");
		sc.add("int value = 0;");
		sc.add("int multiplier = 1;");
		sc.add("for (int i = 0; i < bits.length; i++) {");
		sc.add("value = value + bits[i] * multiplier;");
		sc.add("multiplier = multiplier * 2;");
		sc.add("}");
		sc.add("return value;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
