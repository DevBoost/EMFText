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
package org.emftext.sdk.codegen.generators;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.util.StreamUtil;
import org.emftext.test.WorkspaceIndexer;

/**
 * This test case checks that all code generator classes to adhere to some 
 * coding standards.
 */
public class GeneratorConformanceTest extends TestCase {

	private static final int MINIMUM_GENERATOR_CLASSES = 168;

	public void testAnnotations() {
		List<File> javaFiles = new WorkspaceIndexer().getFilesFromIndex(".java");
		Map<String, File> sourceFileMap = new LinkedHashMap<String, File>();
		for (File file : javaFiles) {
			String className = getClassName(file);
			sourceFileMap.put(className, file);
		}

		List<Class<?>> generatorClasses = getGeneratorClasses();
		assertTrue("Can't find all generator classes.", generatorClasses.size() > MINIMUM_GENERATOR_CLASSES);
		for (Class<?> generatorClass : generatorClasses) {
			Annotation annotation = generatorClass.getAnnotation(SyntaxDependent.class);
			if (annotation == null) {
				// no annotation found. make sure the generator does not access the
				// concrete syntax
				String className = generatorClass.getName();
				File sourceFile = sourceFileMap.get(className);
				String sourceCode = null;
				try {
					sourceCode = StreamUtil.getContentAsString(sourceFile);
				} catch (IOException e) {
					e.printStackTrace();
					fail(e.getMessage());
				}
				int containedGetSyntaxCalls = countOccurrences(sourceCode, "getConcreteSyntax()");
				int containedGetNameCalls = countOccurrences(sourceCode, "getConcreteSyntax().getName()");
				
				// Generator classes that are not annotated with @SyntaxDependent must not call
				// getConcreteSyntax(). The only exception that is allowed is to access the name
				// of the syntax.
				if (containedGetSyntaxCalls > 0 && containedGetNameCalls != containedGetSyntaxCalls) {
					fail("Generator source code of class " + generatorClass.getSimpleName() + " must not contain calls to getConcreteSyntax().");
				}
			}
		}
	}
	
	private int countOccurrences(String textToSearchIn, String textToSearchFor) {
		int count = 0;
		int index = -1;
		do {
			index = textToSearchIn.indexOf(textToSearchFor, index + 1);
			if (index >= 0) {
				count++;
			}
		} while (index >= 0);
		return count;
	}

	public void testInstantiation() {
		List<Class<?>> generatorClasses = getGeneratorClasses();
		
		int generatorClassCount = generatorClasses.size();
		System.out.println("Found generator classes: " + generatorClassCount);
		assertTrue("Can't find all generator classes.", generatorClassCount > MINIMUM_GENERATOR_CLASSES);
		
		for (Class<?> generatorClass : generatorClasses) {
			Constructor<?>[] constructors = generatorClass.getConstructors();
			String className = generatorClass.getName();
			assertEquals("Class " + className + " must have exactly one constructor.", 1, constructors.length);
			Constructor<?> constructor = constructors[0];
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			assertEquals("Class " + className + " must have only a default constructor.", 0, parameterTypes.length);
			assertTrue("Class " + className + " must have public default constructor.", Modifier.isPublic(constructor.getModifiers()));
			
			// we'd also like to check that doGenerate() and generateJavaContent() method have @Override annotations,
			// but the @Override annotation is not preserved in the class files, which renders this check impossible
		}
	}

	private List<Class<?>> getGeneratorClasses() {
		List<File> classFiles = new WorkspaceIndexer().getFilesFromIndex(".class");
		List<String> classNames = getClassNames(classFiles);
		List<Class<?>> classes = getClasses(classNames);

		List<Class<?>> generatorClasses = new ArrayList<Class<?>>();
		for (Class<?> clazz : classes) {
			if (IGenerator.class.isAssignableFrom(clazz) &&
				!clazz.isInterface() &&
				!Modifier.isAbstract(clazz.getModifiers())) {
				generatorClasses.add(clazz);
			}
		}
		return generatorClasses;
	}

	private List<Class<?>> getClasses(List<String> classNames) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (String className : classNames) {
			if (className.startsWith("org.emftext.sdk.codegen.")) {
				classes.addAll(getClass(className));
			}
		}
		return classes;
	}

	private Collection<Class<?>> getClass(String className) {
		Set<Class<?>> result = new LinkedHashSet<Class<?>>(1);
		
		try {
			Class<?> clazz = Class.forName(className);
			result.add(clazz);
		} catch (Throwable t) {
			// ignore
		}
		return result;
	}

	private List<String> getClassNames(List<File> classFiles) {
		List<String> classNames = new ArrayList<String>();
		for (File file : classFiles) {
			String className = getClassName(file);
			classNames.add(className);
		}
		return classNames;
	}

	private String getClassName(File file) {
		String path = file.getPath();
		String pathToClass = cut(path, "/src/");
		pathToClass = cut(pathToClass, "\\src\\");
		pathToClass = cut(pathToClass, "/bin/");
		pathToClass = cut(pathToClass, "\\bin\\");
		//cut for class files in project root (path looks like: '../project-name/')
		if (pathToClass.startsWith("..")) {
			pathToClass = cut(pathToClass, "\\");
			pathToClass = cut(pathToClass, "\\");
		}
		if (pathToClass.startsWith("..")) {
			pathToClass = cut(pathToClass, "/");
			pathToClass = cut(pathToClass, "/");
		}
		
		pathToClass = pathToClass.replace("/", ".");
		pathToClass = pathToClass.replace("\\", ".");
		pathToClass = pathToClass.replace(".class", "");
		pathToClass = pathToClass.replace(".java", "");
		
		return pathToClass;
	}

	private String cut(String pathToClass, String string) {
		int index = pathToClass.indexOf(string);
		if (index >= 0) {
			return pathToClass.substring(index + string.length());
		} else {
			return pathToClass;
		}
	}
}
