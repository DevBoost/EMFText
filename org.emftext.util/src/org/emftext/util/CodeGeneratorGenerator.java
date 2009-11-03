/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.creators.AbstractArtifactCreator;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.generators.IClassNameConstants;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil;
import org.emftext.sdk.util.StringUtil;

public class CodeGeneratorGenerator {

	private static final String ADD_QUOTES_HERE = "ADD_QUOTES_HERE";
	private String OLD_SRC_DIR = "org.emftext.runtime" + File.separator + "src";
	private String NEW_SRC_DIR = "org.emftext.util" + File.separator + "src-output";
	private Set<String> importedClasses = new LinkedHashSet<String>();
	private String[] packageNames = new String[] {"org.emftext.runtime", "org.emftext.runtime.util", "org.emftext.runtime.resource", "org.emftext.runtime.resource.impl", };
	private Set<String> eArtifactFields = new LinkedHashSet<String>();
	private Set<String> overrideTypes = new LinkedHashSet<String>();
	private int counter = 114;
	private Set<String> creatorCalls = new LinkedHashSet<String>();

	public static void main(String[] args) {
		new CodeGeneratorGenerator().run();
	}

	private void run() {
		run(OLD_SRC_DIR, NEW_SRC_DIR);
	}
	
	private void run(String oldDir, String newDir) {
		String baseFolderPath = ".." + File.separator + OLD_SRC_DIR;
		File baseFolder = new File(baseFolderPath);
		List<File> allFiles = findAllFiles(baseFolder);
		for (File file : allFiles) {
			handle(oldDir, newDir, file);
		}
		for (String importedClass : importedClasses) {
			//System.out.println("public static String " + StringUtil.convertCamelCaseToAllCaps(importedClass) + " = " + importedClass + ".class.getName();");
		}
		for (String field : eArtifactFields) {
			System.out.println(field + ",");
		}
		for (String type : overrideTypes) {
			System.out.println(type);
		}
		for (String creatorCall : creatorCalls) {
			System.out.println(creatorCall);
		}
	}

	private void handle(String oldDir, String newDir, File file) {
		String path = file.getPath();
		System.out.println("handle(" + path + ")");
		try {
			String fileContent = CsStreamUtil.getContent(new FileInputStream(file));
			String packageName = path.substring(3);
			packageName = packageName.substring(packageName.indexOf(File.separator) + 1, packageName.length());
			packageName = packageName.substring(packageName.indexOf(File.separator) + 1, packageName.length());
			packageName = packageName.substring(0, packageName.lastIndexOf(File.separator));
			packageName = packageName.replace(File.separator, ".");
			String generatorContent = convertToGenerator(packageName, file.getName().replace(".java", ""), fileContent);
			saveClass(oldDir, newDir, file.getAbsolutePath(), generatorContent, "Generator");
			String creatorContent = convertToCreator(packageName, file.getName().replace(".java", ""), fileContent);
			//saveClass(oldDir, newDir, file.getAbsolutePath(), creatorContent, "Creator");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String convertToCreator(String packageName, String replace,
			String fileContent) {

		StringBuffer sb = new StringBuffer();
		sb.append("package " + packageName + ";\n");
		sb.append("\n");
		sb.append("import java.io.File;\n");
		sb.append("import java.util.Collection;\n");
		sb.append("\n");
		sb.append("import org.emftext.sdk.codegen.GenerationContext;\n");
		sb.append("import org.emftext.sdk.codegen.IGenerator;\n");
		sb.append("import " + AbstractArtifactCreator.class.getName() + ";\n");
		sb.append("import org.emftext.sdk.codegen.generators.ScannerlessParserGenerator;\n");
		sb.append("import org.emftext.sdk.concretesyntax.OptionTypes;\n");
		sb.append("\n");
		sb.append("public class " + replace + "Creator extends AbstractArtifactCreator {\n");
		sb.append("\n");
		sb.append("private static final String NAME = \"" + replace + "\";\n");
		sb.append("\n");
		sb.append("public " + replace + "Creator() {\n");
		sb.append("super(NAME);\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("@Override\n");
		sb.append("public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {\n");
		sb.append("\n");
		sb.append("File file = context.getFile(EArtifact." + replace + ");\n");
		sb.append("IGenerator generator = new " + replace + "Generator(context);\n");
		sb.append("\n");
		sb.append("return createArtifact(\n");
		sb.append("context,\n");
		sb.append("generator,\n");
		sb.append("file,\n");
		sb.append("\"Exception while generating \" + NAME + \".\"\n");
		sb.append(");\n");
		sb.append("}\n");
		sb.append("\n");
		sb.append("public OptionTypes getOverrideOption() {\n");
		sb.append("return OptionTypes.OVERRIDE_" + replace + ";\n");
		sb.append("}\n");
		sb.append("}\n");
		sb.append("\n");
		return sb.toString();
	}

	private void saveClass(String oldDir, String newDir, String originalFilePath, String generatorContent, String suffix) throws IOException {
		String newPath = originalFilePath.replace(oldDir, newDir).replace(".java", "") + suffix + ".java";
		File targetFile = new File(newPath);
		File parent = targetFile.getParentFile();
		parent.mkdirs();
		FileWriter writer = new FileWriter(newPath);
		writer.write(generatorContent);
		writer.close();
	}

	private String convertToGenerator(String packageName, String className, String fileContent) {
		//fileContent = replaceDeclaration(className, fileContent, "abstract class");
		//fileContent = replaceDeclaration(className, fileContent, "class");
		//fileContent = replaceDeclaration(className, fileContent, "interface");
	
		//fileContent = fileContent.replace(
		//		"public " + className + "(",
		//		"public " + className + "Generator(");
		
		fileContent = replaceClassNamesWithConstants(fileContent);
			
		StringBuffer result = new StringBuffer();
		
		String[] lines = fileContent.split("\\n\\r|\\r\\n|\\n|\\r");
		int lineCount = 1;
		String generatorName = className + "Generator";
		result.append("package " + packageName + ";\n");
		result.append("\n");
		result.append("import static " + IClassNameConstants.class.getName() + ".*;\n");
		result.append("import " + BaseGenerator.class.getName() + ";\n");
		result.append("import " + GenerationContext.class.getName() + ";\n");
		result.append("import " + PrintWriter.class.getName() + ";\n");
		result.append("import " + EArtifact.class.getName() + ";\n");
		result.append("import " + IGenerator.class.getName() + ";\n");
		result.append("\n");
		result.append("public class " + generatorName + " extends BaseGenerator {\n");
		result.append("\n");
		result.append("\tpublic " + generatorName + "() {\n");
		result.append("\t\tsuper();\n");
		result.append("\t}\n");
		result.append("\n");
		result.append("\tprivate " + generatorName + "(GenerationContext context) {\n");
		String eArtifactField = StringUtil.convertCamelCaseToAllCaps(className);
		result.append("\t\tsuper(context, EArtifact." + eArtifactField + ");\n");
		eArtifactFields.add(eArtifactField + "(\"" + className + "\", new " + className + "Generator(), OptionTypes.OVERRIDE_" + eArtifactField +")");
		overrideTypes.add("<eLiterals name=\"OVERRIDE_" + eArtifactField + "\" value=\"" + (counter++) + "\" literal=\"override" + className + "\"/>");
		
		creatorCalls.add("creators.add(new GenericArtifactCreator(EArtifact." + eArtifactField + "));");
		
		result.append("\t}\n");
		result.append("\n");
		result.append("\tpublic " + IGenerator.class.getSimpleName() + " newInstance(" + GenerationContext.class.getSimpleName() + " context) {\n");
		result.append("\t\treturn new " + generatorName + "(context);\n");
		result.append("\t}\n");
		result.append("\n");
		result.append("\tpublic boolean generate(PrintWriter out) {\n");
		result.append("\t\t" + StringComposite.class.getName() + " sc = new " + JavaComposite.class.getName() + "();\n");
		for (String line : lines) {
			line = line.replace("\n", "");
			line = line.replace("\r", "");
			line = line.replace("\"", "\\\"");
			line = line.replace(ADD_QUOTES_HERE, "\"");
			String trimmedLine = line.trim();
			if (line.startsWith("import ")) {
				continue;
			}
			if (trimmedLine.startsWith("*")) {
				trimmedLine = "//" + trimmedLine.substring(1);
			}
			if (trimmedLine.startsWith("/*")) {
				trimmedLine = "//" + trimmedLine.substring(2);
			}
			if (trimmedLine.equals("*/")) {
				trimmedLine = "";
			}
			if ("".equals(trimmedLine)) {
				result.append("\t\tsc.addLineBreak();\n");
			} else {
				result.append("\t\tsc.add(\"" + trimmedLine + "\");\n");
			}
			//System.out.println(lineCount + ": " + line);
			lineCount++;
		}
		result.append("\t\tout.print(sc.toString());\n");
		result.append("\t\treturn true;\n");
		result.append("\t}\n");
		result.append("}\n");
		String resultAsString = result.toString();
		for (String declaredPackageName : packageNames) {
			resultAsString = resultAsString.replace("\"package " + declaredPackageName + ";", "\"package \" + getResourcePackageName() + \";");
		}
		for (String type : new String[] {"class", "interface"}) {
			resultAsString = resultAsString.replace("\"public " + type + " " + className + " {", "\"public " + type + " \" + getResourceClassName() + \" {");
		}
		for (String deletes : new String[] {"sc.add(\"//*\");", "sc.add(\"///\");"}) {
			resultAsString = resultAsString.replace(deletes, "");
		}
		
		return resultAsString;
	}

	private String replaceClassNamesWithConstants(String fileContent) {
		Pattern classNamePattern = Pattern.compile("[A-Z]([a-z]|[A-Z])*");
		int offset = 0;
		while (true) {
			Matcher matcher = classNamePattern.matcher(fileContent);
			boolean found = matcher.find(offset);
			if (!found) {
				break;
			}
			int start = matcher.start();
			int end = matcher.end();
			if (("" + fileContent.charAt(start - 1)).matches("([a-z]|[A-Z])")) {
				// character before occurrence is also a letter
				// this is probably a variable name and not a type
				offset = end + 1;
				continue;
			}
			String potentialClassName = fileContent.substring(start, end);
			//System.out.println("Found potential class name at (" + start + "-" + end + "): " + potentialClassName);
			boolean isInComment = isInComment(fileContent, start, end);
			boolean isAnImport = isAnImport(fileContent, start, end);
			if (!isInComment && !isAnImport) {
				String qualifiedClassName = isImported(fileContent, potentialClassName);
				boolean isImported = qualifiedClassName != null;
				if (isImported) {
					importedClasses.add(qualifiedClassName);
					String qualifiedClassConstant = StringUtil.convertCamelCaseToAllCaps(qualifiedClassName);
					//System.out.println("Found class " + qualifiedClassName);
					String newCode = ADD_QUOTES_HERE + " + " + qualifiedClassConstant + " + " + ADD_QUOTES_HERE;
					fileContent = fileContent.substring(0, start) + newCode + fileContent.substring(end, fileContent.length());
					offset = start + newCode.length();
				} else {
					offset = end + 1;
				}
			} else {
				offset = end + 1;
			}
		}
		
		return fileContent;
	}

	private boolean isAnImport(String fileContent, int start, int end) {
		if (isInRegularExpression(fileContent, start, end, "import .*;")) {
			return true;
		}
		return false;
	}

	private boolean isInComment(String fileContent, int start, int end) {
		if (isInRegularExpression(fileContent, start, end, "//([^(\\n|\\r|\\uffff)])*")) {
			return true;
		}
		if (isInRegularExpression(fileContent, start, end, "/\\*.\\*/")) {
			return true;
		}
		return false;
	}

	private boolean isInRegularExpression(String fileContent, int start, int end, String pattern) {
		Pattern classNamePattern = Pattern.compile(pattern);
		int offset = 0;
		Matcher matcher = classNamePattern.matcher(fileContent);
		boolean found = matcher.find(offset);
		while (found) {
			int commentStart = matcher.start();
			int commentEnd = matcher.end();
			if (commentStart <= start && commentEnd >= end) {
				return true;
			}
			offset = commentEnd + 1;
			found = matcher.find(offset);
		}
		return false;
	}

	private String isImported(String fileContent, String potentialClassName) {
		Pattern importPattern = Pattern.compile("import .*(" + potentialClassName + ");");
		Matcher matcher = importPattern.matcher(fileContent);
		boolean matches = matcher.find();
		if (matches) {
			String className = matcher.group(1);
			//System.out.println("Found import " + qualifiedClassName);
			return className;
		}
		return null;
	}

	private List<File> findAllFiles(File currentFile) {
		List<File> result = new ArrayList<File>();
		if (!currentFile.exists()) {
			System.out.println(currentFile.getAbsolutePath() + " does not exist.");
		}
		if (currentFile.isFile()) {
			result.add(currentFile);
		}
		if (currentFile.isDirectory()) {
			File[] files = currentFile.listFiles(new FileFilter() {

				public boolean accept(File pathname) {
					final String name = pathname.getName();
					final boolean isJavaFile = name.endsWith(".java");
					final boolean isAbstract = name.startsWith("Abstract");
					final boolean isInterface = name.startsWith("I");
					final boolean isDir = pathname.isDirectory();
					final boolean isFile = pathname.isFile();
					boolean hasCorrectName = pathname.getName().startsWith("UnexpectedContentTypeException");
					boolean isInCorrectPackage = pathname.getAbsolutePath().contains("org.emftext.runtime.resource.impl.code_completion".replace(".", "\\"));
					isInCorrectPackage |= pathname.getAbsolutePath().contains("org.emftext.runtime.util".replace(".", "\\"));
					return isDir || (isFile && isJavaFile && hasCorrectName);
				}
				
			});
			for (File file : files) {
				result.addAll(findAllFiles(file));
			}
		}
		return result;
	}
}
