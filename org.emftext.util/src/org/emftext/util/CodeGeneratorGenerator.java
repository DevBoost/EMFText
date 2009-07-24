package org.emftext.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.emftext.runtime.util.StreamUtil;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class CodeGeneratorGenerator {

	private static final String ADD_QUOTES_HERE = "ADD_QUOTES_HERE";
	private String OLD_SRC_DIR = "org.emftext.runtime.ui" + File.separator + "src";
	private String NEW_SRC_DIR = "org.emftext.util" + File.separator + "src-output";

	public static void main(String[] args) {
		new CodeGeneratorGenerator().run();
	}

	private void run() {
		String baseFolderPath = ".." + File.separator + OLD_SRC_DIR;
		File baseFolder = new File(baseFolderPath);
		List<File> allFiles = findAllFiles(baseFolder);
		for (File file : allFiles) {
			handle(file);
		}
	}

	private void handle(File file) {
		String path = file.getPath();
		System.out.println("handle(" + path + ")");
		try {
			String fileContent = StreamUtil.getContent(new FileInputStream(file));
			String packageName = path.substring(3);
			packageName = packageName.substring(packageName.indexOf(File.separator) + 1, packageName.length());
			packageName = packageName.substring(packageName.indexOf(File.separator) + 1, packageName.length());
			packageName = packageName.substring(0, packageName.lastIndexOf(File.separator));
			packageName = packageName.replace(File.separator, ".");
			String generatorContent = convertToGenerator(packageName, file.getName().replace(".java", ""), fileContent);
			saveGenerator(file.getAbsolutePath(), generatorContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveGenerator(String originalFilePath, String generatorContent) throws IOException {
		String newPath = originalFilePath.replace(OLD_SRC_DIR, NEW_SRC_DIR).replace(".java", "") + "Generator.java";
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
		result.append("package " + packageName + ";\n");
		result.append("\n");
		result.append("public class " + className + "Generator {\n");
		result.append("\n");
		result.append("\tpublic void generate() {\n");
		result.append("\t\t" + StringComposite.class.getName() + " sc = new " + JavaComposite.class.getName() + "();\n");
		for (String line : lines) {
			line = line.replace("\n", "");
			line = line.replace("\r", "");
			line = line.replace("\"", "\\\"");
			line = line.replace(ADD_QUOTES_HERE, "\"");
			String trimmedLine = line.trim();
			if ("".equals(trimmedLine)) {
				result.append("\t\tsc.addLineBreak();\n");
			} else {
				result.append("\t\tsc.add(\"" + trimmedLine + "\");\n");
			}
			//System.out.println(lineCount + ": " + line);
			lineCount++;
		}
		result.append("\t}\n");
		result.append("}\n");
		return result.toString();
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
			String potentialClassName = fileContent.substring(start, end);
			//System.out.println("Found potential class name at (" + start + "-" + end + "): " + potentialClassName);
			boolean isInComment = isInComment(fileContent, start, end);
			boolean isAnImport = isAnImport(fileContent, start, end);
			if (!isInComment && !isAnImport) {
				String qualifiedClassName = isImported(fileContent, potentialClassName);
				boolean isImported = qualifiedClassName != null;
				if (isImported) {
					//System.out.println("Found class " + qualifiedClassName);
					String newCode = ADD_QUOTES_HERE + " + " + qualifiedClassName + ".class.getName() + " + ADD_QUOTES_HERE;
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
		Pattern importPattern = Pattern.compile("import (.*" + potentialClassName + ");");
		Matcher matcher = importPattern.matcher(fileContent);
		boolean matches = matcher.find();
		if (matches) {
			String qualifiedClassName = matcher.group(1);
			//System.out.println("Found import " + qualifiedClassName);
			return qualifiedClassName;
		}
		return null;
	}

	private String replaceDeclaration(String className, String fileContent, String kind) {
		fileContent = fileContent.replace(
				"public " + kind + " " + className,
				"public " + kind + " " + className + "Generator");
		return fileContent;
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
					return pathname.isDirectory() || 
						(pathname.isFile() && pathname.getName().endsWith(".java"));
				}
				
			});
			for (File file : files) {
				result.addAll(findAllFiles(file));
			}
		}
		return result;
	}
}
