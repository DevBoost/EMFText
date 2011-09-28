package org.emftext.sdk.codegen.resource.generators.mopp;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.util.Pair;

public class ExpectationsConstantsGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		List<Integer[]> expectationCalls = getContext().getConstantsPool().getExpectationCalls();
		sc.add("public final static int EXPECTATIONS[][] = new int[" + expectationCalls.size() + "][];");
		sc.addLineBreak();
		
		List<Pair<String, Integer>> statements = new ArrayList<Pair<String,Integer>>();
		int index = 0;
		for (Integer[] expectationCall : expectationCalls) {
			statements.add(new Pair<String, Integer>(
				"EXPECTATIONS[" + index +  "] = new int[" + expectationCall.length + "];", 
				20
			));
			int index2 = 0;
			for (Integer integer : expectationCall) {
				statements.add(new Pair<String, Integer>(
					"EXPECTATIONS[" + index +  "][" + index2 +  "] = " + integer.toString() + ";",
					20
				));
				index2++;
			}
			index++;
		}
		sc.addLargeMethod("initialize", statements);
		
		sc.add("static {");
		sc.add("initialize();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
