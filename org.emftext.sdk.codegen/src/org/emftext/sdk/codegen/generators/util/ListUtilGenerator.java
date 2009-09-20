package org.emftext.sdk.codegen.generators.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ListUtilGenerator extends BaseGenerator {

	public ListUtilGenerator() {
		super();
	}

	private ListUtilGenerator(GenerationContext context) {
		super(context, EArtifact.LIST_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ListUtilGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A utility class that encapsulates some case operations that need to be performed");
		sc.add("// unchecked, because of Java's type erasure.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static <T> " + LIST + "<T> castListUnchecked(Object list) {");
		sc.add("return (" + LIST + "<T>) list;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + LIST + "<Object> copySafelyToObjectList(" + LIST + "<?> list) {");
		sc.add(ITERATOR + "<?> it = list.iterator();");
		sc.add(LIST + "<Object> castedCopy = new " + ARRAY_LIST + "<Object>();");
		sc.add("while (it.hasNext()) {");
		sc.add("castedCopy.add(it.next());");
		sc.add("}");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
