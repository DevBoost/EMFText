/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.emftext.sdk.codegen.resource.generators.ClassNameConstants;
import org.emftext.sdk.codegen.resource.ui.UIClassNameConstants;
import org.junit.Test;

import de.devboost.codecomposers.java.JavaComposite;

public class ClassNameConstantsTest {

	@Test
	public void testClassNames() {
		assertCorrectBehavior(ClassNameConstants.class, OldClassNameConstants.class);
	}

	@Test
	public void testUIClassNames() {
		assertCorrectBehavior(UIClassNameConstants.class, OldUIClassNameConstants.class);
	}

	@Test
	public void testNoDuplicates() {
		assertNoDuplicateMethods(UIClassNameConstants.class, ClassNameConstants.class);
		assertNoDuplicateMethods(ClassNameConstants.class, de.devboost.codecomposers.java.ClassNameConstants.class);
	}

	private void assertNoDuplicateMethods(Class<?> class1, Class<?> class2) {
		
		Method[] methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			try {
				String name = method.getName();
				if ("getClassName".equals(name)) {
					continue;
				}
				class2.getDeclaredMethod(name, method.getParameterTypes());
				fail("Duplicate method " + name + " in class " + class2.getCanonicalName());
			} catch (SecurityException e) {
				fail(e.getMessage());
			} catch (NoSuchMethodException e) {
				// This is expected
			}
		}
	}

	private void assertCorrectBehavior(Class<?> newClass, Class<?> oldClass) {
		assertMethodsAreStatic(newClass);
		assertMethodsReturnCorrectTypeNames(newClass, oldClass);
	}

	private void assertMethodsReturnCorrectTypeNames(Class<?> newClass,
			Class<?> oldClass) {
		
		JavaComposite jc = new JavaComposite() {
			
			// We directly return the qualified class name instead of delegating
			// to the ImportsPlaceholder to avoid the simple names are returned.
			public String getClassName(String qualifiedClassName) {
				return qualifiedClassName;
			}
		};

		Method[] methods = oldClass.getDeclaredMethods();
		for (Method method : methods) {
			try {
				Object oldResult = method.invoke(null, new Object[] {jc});
				assertTrue(oldResult instanceof String);
				String oldTypeName = (String) oldResult;
				
				Method newMethod = newClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
				Object newResult = newMethod.invoke(null, new Object[] {jc});
				assertTrue(newResult instanceof String);
				String newTypeName = (String) newResult;
				
				assertEquals("Type names must be equals.", oldTypeName, newTypeName);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				fail(e.getMessage());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				fail(e.getMessage());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				fail(e.getMessage());
			} catch (SecurityException e) {
				e.printStackTrace();
				fail(e.getMessage());
			} catch (NoSuchMethodException e) {
				// Ignore if the new class does not contain a method.
			}
		}
	}

	private void assertMethodsAreStatic(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			boolean isStatic = Modifier.isStatic(method.getModifiers());
			assertTrue("Method " + method.getName() + " not static.", isStatic);
		}
	}
}
