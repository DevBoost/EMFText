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
package org.emftext.access;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.emftext.access.resource.IColorManager;
import org.emftext.access.resource.IConfigurable;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IParseResult;
import org.emftext.access.resource.ITextParser;
import org.emftext.access.resource.ITextPrinter;
import org.emftext.access.resource.ITextResource;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.access.resource.ITextScanner;
import org.emftext.access.resource.ITextToken;

public class EMFTextAccessProxy implements InvocationHandler {

	protected static Class<?> [] accessInterfaces = {
			IConfigurable.class,
			IColorManager.class,
			ILocationMap.class,
			IParseResult.class,
			ITextParser.class,
			ITextPrinter.class,
			ITextResource.class,
			IMetaInformation.class,
			ITextScanner.class,
			ITextToken.class,
	};

	protected Object impl;
	protected Class<?> accessInterface;

	private EMFTextAccessProxy(Object impl, Class<?> accessInterface) {
		this.impl = impl;
		this.accessInterface = accessInterface;
	}

	public static Object get(Object impl, Class<?> accessInterface) {
		//proxies are not cached because also new objects (e.g., Parser, Printer) might be created
		return Proxy.newProxyInstance(
				impl.getClass().getClassLoader(),
				new Class[] { accessInterface },
				new EMFTextAccessProxy(impl, accessInterface));
	}

	protected static boolean isAccessInterface(Class<?> type) {
		for(int i = 0; i < accessInterfaces.length; i++) {
			if (accessInterfaces[i] == type) {
				return true;
			}
		}
		return false;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		//currently access interface arguments are not support
		Object result = null;
		try {
			Method implMethod;
			implMethod = getMethod(method);
			Object[] proxyArgs = null;
			if (args != null) {
				proxyArgs = new Object[args.length];
				for (int a = 0; a < args.length; a++) {
					Object arg = args[a];
					proxyArgs[a] = arg;
					if (arg instanceof Proxy) {
						Proxy argProxy = (Proxy) arg;
						InvocationHandler handler = Proxy.getInvocationHandler(argProxy);
						if (handler instanceof EMFTextAccessProxy) {
							EMFTextAccessProxy emfHandler = (EMFTextAccessProxy) handler;
							if (isAccessInterface(emfHandler.accessInterface)) {
								// Replace args[a] with emfHandler.impl
								proxyArgs[a] = emfHandler.impl;
							}
						}
					}
				}
			}
			result = implMethod.invoke(impl, proxyArgs);

			if (result != null && isAccessInterface(method.getReturnType())) {
				result = EMFTextAccessProxy.get(result, method.getReturnType());
			}
		} catch (NoSuchMethodException e) {
			EMFTextAccessPlugin.logError("Required method not defined: " + impl.getClass().getCanonicalName() + "." + method.getName(), null);
		}
		return result;
	}

	private Method getMethod(Method method) throws NoSuchMethodException {
		String methodName = method.getName();
		Class<?>[] parameterTypes = method.getParameterTypes();
		// first look for the exact method
		try {
			return impl.getClass().getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			EMFTextAccessPlugin.logError("Required method not defined: " + impl.getClass().getCanonicalName() + "." + method.getName(), null);
		}
		Method[] methods = impl.getClass().getMethods();
		// then look for a methods with the same name (do not care about parameter types)
		// this is needed to find methods that use types from the generated plug-ins as
		// parameters
		for (Method nextMethod : methods) {
			if (methodName.equals(nextMethod.getName())) {
				return nextMethod;
			}
		}
		throw new NoSuchMethodException();
	}
}
