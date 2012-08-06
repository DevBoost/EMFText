/* *******************************************************************
 * Copyright (c) 1999-2001 Xerox Corporation, 
 *               2002 Palo Alto Research Center, Incorporated (PARC).
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors: 
 *     Xerox/PARC     initial implementation 
 *    Alex Vasseur    new factory methods for variants of JP
 * ******************************************************************/

package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.StringTokenizer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.AdviceSignature;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.InitializerSignature;
import org.aspectj.lang.reflect.LockSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.lang.reflect.UnlockSignature;

public final class Factory {
	Class lexicalClass;
	ClassLoader lookupClassLoader;
	String filename;
	int count;

	static Hashtable prims = new Hashtable();
	static {
		prims.put("void", Void.TYPE);
		prims.put("boolean", Boolean.TYPE);
		prims.put("byte", Byte.TYPE);
		prims.put("char", Character.TYPE);
		prims.put("short", Short.TYPE);
		prims.put("int", Integer.TYPE);
		prims.put("long", Long.TYPE);
		prims.put("float", Float.TYPE);
		prims.put("double", Double.TYPE);
	}

	static Class makeClass(String s, ClassLoader loader) {
		if (s.equals("*"))
			return null;
		Class ret = (Class) prims.get(s);
		if (ret != null)
			return ret;
		try {
			/*
			 * The documentation of Class.forName explains why this is the right thing better than I could here.
			 */
			if (loader == null) {
				return Class.forName(s);
			} else {
				// used to be 'return loader.loadClass(s)' but that didn't cause
				// array types to be created and loaded correctly. (pr70404)
				return Class.forName(s, false, loader);
			}
		} catch (ClassNotFoundException e) {
			// System.out.println("null for: " + s);
			// XXX there should be a better return value for this
			return ClassNotFoundException.class;
		}
	}

	public Factory(String filename, Class lexicalClass) {
		// System.out.println("making
		this.filename = filename;
		this.lexicalClass = lexicalClass;
		this.count = 0;
		lookupClassLoader = lexicalClass.getClassLoader();
	}

	public JoinPoint.StaticPart makeSJP(String kind, Signature sig, SourceLocation loc) {
		return new JoinPointImpl.StaticPartImpl(count++, kind, sig, loc);
	}

	public JoinPoint.StaticPart makeSJP(String kind, Signature sig, int l, int c) {
		return new JoinPointImpl.StaticPartImpl(count++, kind, sig, makeSourceLoc(l, c));
	}

	public JoinPoint.StaticPart makeSJP(String kind, Signature sig, int l) {
		return new JoinPointImpl.StaticPartImpl(count++, kind, sig, makeSourceLoc(l, -1));
	}

	public JoinPoint.EnclosingStaticPart makeESJP(String kind, Signature sig, SourceLocation loc) {
		return new JoinPointImpl.EnclosingStaticPartImpl(count++, kind, sig, loc);
	}

	public JoinPoint.EnclosingStaticPart makeESJP(String kind, Signature sig, int l, int c) {
		return new JoinPointImpl.EnclosingStaticPartImpl(count++, kind, sig, makeSourceLoc(l, c));
	}

	public JoinPoint.EnclosingStaticPart makeESJP(String kind, Signature sig, int l) {
		return new JoinPointImpl.EnclosingStaticPartImpl(count++, kind, sig, makeSourceLoc(l, -1));
	}

	public static JoinPoint.StaticPart makeEncSJP(Member member) {
		Signature sig = null;
		String kind = null;
		if (member instanceof Method) {
			Method method = (Method) member;
			sig = new MethodSignatureImpl(method.getModifiers(), method.getName(), method.getDeclaringClass(), method
					.getParameterTypes(), new String[method.getParameterTypes().length], method.getExceptionTypes(), method
					.getReturnType());
			kind = JoinPoint.METHOD_EXECUTION;
		} else if (member instanceof Constructor) {
			Constructor cons = (Constructor) member;
			sig = new ConstructorSignatureImpl(cons.getModifiers(), cons.getDeclaringClass(), cons.getParameterTypes(),
					new String[cons.getParameterTypes().length], cons.getExceptionTypes());
			kind = JoinPoint.CONSTRUCTOR_EXECUTION;
		} else {
			throw new IllegalArgumentException("member must be either a method or constructor");
		}
		return new JoinPointImpl.EnclosingStaticPartImpl(-1, kind, sig, null);
	}

	private static Object[] NO_ARGS = new Object[0];

	public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object _this, Object target) {
		return new JoinPointImpl(staticPart, _this, target, NO_ARGS);
	}

	public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object _this, Object target, Object arg0) {
		return new JoinPointImpl(staticPart, _this, target, new Object[] { arg0 });
	}

	public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object _this, Object target, Object arg0, Object arg1) {
		return new JoinPointImpl(staticPart, _this, target, new Object[] { arg0, arg1 });
	}

	public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object _this, Object target, Object[] args) {
		return new JoinPointImpl(staticPart, _this, target, args);
	}

	public MethodSignature makeMethodSig(String stringRep) {
		MethodSignatureImpl ret = new MethodSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public MethodSignature makeMethodSig(String modifiers, String methodName, String declaringType, String paramTypes,
			String paramNames, String exceptionTypes, String returnType) {
		int modifiersAsInt = Integer.parseInt(modifiers, 16);

		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);

		StringTokenizer st = new StringTokenizer(paramTypes, ":");
		int numParams = st.countTokens();
		Class[] paramTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			paramTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);

		st = new StringTokenizer(paramNames, ":");
		numParams = st.countTokens();
		String[] paramNamesArray = new String[numParams];
		for (int i = 0; i < numParams; i++)
			paramNamesArray[i] = st.nextToken();

		st = new StringTokenizer(exceptionTypes, ":");
		numParams = st.countTokens();
		Class[] exceptionTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			exceptionTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);

		Class returnTypeClass = makeClass(returnType, lookupClassLoader);

		MethodSignatureImpl ret = new MethodSignatureImpl(modifiersAsInt, methodName, declaringTypeClass, paramTypeClasses,
				paramNamesArray, exceptionTypeClasses, returnTypeClass);

		return ret;
	}

	public MethodSignature makeMethodSig(int modifiers, String name, Class declaringType, Class[] parameterTypes,
			String[] parameterNames, Class[] exceptionTypes, Class returnType) {
		MethodSignatureImpl ret = new MethodSignatureImpl(modifiers, name, declaringType, parameterTypes, parameterNames,
				exceptionTypes, returnType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public ConstructorSignature makeConstructorSig(String stringRep) {
		ConstructorSignatureImpl ret = new ConstructorSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public ConstructorSignature makeConstructorSig(String modifiers, String declaringType, String paramTypes, String paramNames,
			String exceptionTypes) {
		int modifiersAsInt = Integer.parseInt(modifiers, 16);

		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);

		StringTokenizer st = new StringTokenizer(paramTypes, ":");
		int numParams = st.countTokens();
		Class[] paramTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			paramTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);

		st = new StringTokenizer(paramNames, ":");
		numParams = st.countTokens();
		String[] paramNamesArray = new String[numParams];
		for (int i = 0; i < numParams; i++)
			paramNamesArray[i] = st.nextToken();

		st = new StringTokenizer(exceptionTypes, ":");
		numParams = st.countTokens();
		Class[] exceptionTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			exceptionTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);

		ConstructorSignatureImpl ret = new ConstructorSignatureImpl(modifiersAsInt, declaringTypeClass, paramTypeClasses,
				paramNamesArray, exceptionTypeClasses);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public ConstructorSignature makeConstructorSig(int modifiers, Class declaringType, Class[] parameterTypes,
			String[] parameterNames, Class[] exceptionTypes) {
		ConstructorSignatureImpl ret = new ConstructorSignatureImpl(modifiers, declaringType, parameterTypes, parameterNames,
				exceptionTypes);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public FieldSignature makeFieldSig(String stringRep) {
		FieldSignatureImpl ret = new FieldSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public FieldSignature makeFieldSig(String modifiers, String name, String declaringType, String fieldType) {
		int modifiersAsInt = Integer.parseInt(modifiers, 16);
		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);
		Class fieldTypeClass = makeClass(fieldType, lookupClassLoader);

		FieldSignatureImpl ret = new FieldSignatureImpl(modifiersAsInt, name, declaringTypeClass, fieldTypeClass);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public FieldSignature makeFieldSig(int modifiers, String name, Class declaringType, Class fieldType) {
		FieldSignatureImpl ret = new FieldSignatureImpl(modifiers, name, declaringType, fieldType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public AdviceSignature makeAdviceSig(String stringRep) {
		AdviceSignatureImpl ret = new AdviceSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public AdviceSignature makeAdviceSig(String modifiers, String name, String declaringType, String paramTypes, String paramNames,
			String exceptionTypes, String returnType) {
		int modifiersAsInt = Integer.parseInt(modifiers, 16);

		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);

		StringTokenizer st = new StringTokenizer(paramTypes, ":");
		int numParams = st.countTokens();
		Class[] paramTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			paramTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);

		st = new StringTokenizer(paramNames, ":");
		numParams = st.countTokens();
		String[] paramNamesArray = new String[numParams];
		for (int i = 0; i < numParams; i++)
			paramNamesArray[i] = st.nextToken();

		st = new StringTokenizer(exceptionTypes, ":");
		numParams = st.countTokens();
		Class[] exceptionTypeClasses = new Class[numParams];
		for (int i = 0; i < numParams; i++)
			exceptionTypeClasses[i] = makeClass(st.nextToken(), lookupClassLoader);
		;

		Class returnTypeClass = makeClass(returnType, lookupClassLoader);

		AdviceSignatureImpl ret = new AdviceSignatureImpl(modifiersAsInt, name, declaringTypeClass, paramTypeClasses,
				paramNamesArray, exceptionTypeClasses, returnTypeClass);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public AdviceSignature makeAdviceSig(int modifiers, String name, Class declaringType, Class[] parameterTypes,
			String[] parameterNames, Class[] exceptionTypes, Class returnType) {
		AdviceSignatureImpl ret = new AdviceSignatureImpl(modifiers, name, declaringType, parameterTypes, parameterNames,
				exceptionTypes, returnType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public InitializerSignature makeInitializerSig(String stringRep) {
		InitializerSignatureImpl ret = new InitializerSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public InitializerSignature makeInitializerSig(String modifiers, String declaringType) {
		int modifiersAsInt = Integer.parseInt(modifiers, 16);
		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);

		InitializerSignatureImpl ret = new InitializerSignatureImpl(modifiersAsInt, declaringTypeClass);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public InitializerSignature makeInitializerSig(int modifiers, Class declaringType) {
		InitializerSignatureImpl ret = new InitializerSignatureImpl(modifiers, declaringType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public CatchClauseSignature makeCatchClauseSig(String stringRep) {
		CatchClauseSignatureImpl ret = new CatchClauseSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public CatchClauseSignature makeCatchClauseSig(String declaringType, String parameterType, String parameterName) {
		Class declaringTypeClass = makeClass(declaringType, lookupClassLoader);

		StringTokenizer st = new StringTokenizer(parameterType, ":");
		Class parameterTypeClass = makeClass(st.nextToken(), lookupClassLoader);

		st = new StringTokenizer(parameterName, ":");
		String parameterNameForReturn = st.nextToken();

		CatchClauseSignatureImpl ret = new CatchClauseSignatureImpl(declaringTypeClass, parameterTypeClass, parameterNameForReturn);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public CatchClauseSignature makeCatchClauseSig(Class declaringType, Class parameterType, String parameterName) {
		CatchClauseSignatureImpl ret = new CatchClauseSignatureImpl(declaringType, parameterType, parameterName);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public LockSignature makeLockSig(String stringRep) {
		LockSignatureImpl ret = new LockSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public LockSignature makeLockSig() {
		Class declaringTypeClass = makeClass("Ljava/lang/Object;", lookupClassLoader);
		LockSignatureImpl ret = new LockSignatureImpl(declaringTypeClass);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public LockSignature makeLockSig(Class declaringType) {
		LockSignatureImpl ret = new LockSignatureImpl(declaringType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public UnlockSignature makeUnlockSig(String stringRep) {
		UnlockSignatureImpl ret = new UnlockSignatureImpl(stringRep);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public UnlockSignature makeUnlockSig() {
		Class declaringTypeClass = makeClass("Ljava/lang/Object;", lookupClassLoader);
		UnlockSignatureImpl ret = new UnlockSignatureImpl(declaringTypeClass);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public UnlockSignature makeUnlockSig(Class declaringType) {
		UnlockSignatureImpl ret = new UnlockSignatureImpl(declaringType);
		ret.setLookupClassLoader(lookupClassLoader);
		return ret;
	}

	public SourceLocation makeSourceLoc(int line, int col) {
		return new SourceLocationImpl(lexicalClass, this.filename, line);
	}
}
