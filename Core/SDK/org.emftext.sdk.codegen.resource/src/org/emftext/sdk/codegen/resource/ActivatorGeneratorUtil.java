/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.STATUS;
import de.devboost.codecomposers.java.JavaComposite;

public class ActivatorGeneratorUtil {
	
	public void addLogMethods(JavaComposite sc, String resourceClassName) {
		addLogErrorMethod(sc);
		addLogWarningMethod(sc);
		addLogInfoMethod(sc);
		addLogMethod(sc, resourceClassName);
	}

	private void addLogErrorMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Helper method for error logging.",
			"@param message the error message to log",
			"@param throwable the exception that describes the error in detail (can be null)",
			"@return the status object describing the error"
		);
		sc.add("public static " + I_STATUS(sc) + " logError(String message, Throwable throwable) {");
		sc.add("return log(" + I_STATUS(sc) + ".ERROR, message, throwable);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLogWarningMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Helper method for logging warnings.",
			"@param message the warning message to log",
			"@param throwable the exception that describes the warning in detail (can be null)",
			"@return the status object describing the warning"
		);
		sc.add("public static " + I_STATUS(sc) + " logWarning(String message, Throwable throwable) {");
		sc.add("return log(" + I_STATUS(sc) + ".WARNING, message, throwable);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLogInfoMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Helper method for logging infos.",
			"@param message the info message to log",
			"@param throwable the exception that describes the info in detail (can be null)",
			"@return the status object describing the info"
		);
		sc.add("public static " + I_STATUS(sc) + " logInfo(String message, Throwable throwable) {");
		sc.add("return log(" + I_STATUS(sc) + ".INFO, message, throwable);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLogMethod(JavaComposite sc, String resourceClassName) {
		sc.addJavadoc(
			"Helper method for logging.",
			"@param type the type of the message to log",
			"@param message the message to log",
			"@param throwable the exception that describes the error in detail (can be null)",
			"@return the status object describing the error"
		);
		sc.add("protected static " + I_STATUS(sc) + " log(int type, String message, Throwable throwable) {");
		sc.add(I_STATUS(sc) + " status;");
		sc.add("if (throwable != null) {");
		sc.add("status = new " + STATUS(sc) + "(type, " + resourceClassName + ".PLUGIN_ID, 0, message, throwable);");
		sc.add("} else {");
		sc.add("status = new " + STATUS(sc) + "(type, " + resourceClassName + ".PLUGIN_ID, message);");
		sc.add("}");
			
		sc.add("final " + resourceClassName + " pluginInstance = " + resourceClassName + ".getDefault();");
		sc.add("if (pluginInstance == null) {");
		sc.add("System.err.println(message);");
		sc.add("if (throwable != null) {");
		sc.add("throwable.printStackTrace();");
		sc.add("}");
		sc.add("} else {");
		sc.add("pluginInstance.getLog().log(status);");
		sc.add("}");
		sc.add("return status;");
		sc.add("}");
		sc.addLineBreak();
	}
}
