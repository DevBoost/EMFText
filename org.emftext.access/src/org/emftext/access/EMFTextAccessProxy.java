package org.emftext.access;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
			ILocationMap.class,
			IParseResult.class,
			ITextParser.class,
			ITextPrinter.class,
			ITextResource.class,
			IMetaInformation.class,
			ITextScanner.class,
			ITextToken.class
	};

	protected Object impl;

	private EMFTextAccessProxy(Object impl) {
		this.impl = impl;
	}

	public static Object get(Object impl, Class<?> accessInterface) {
		//proxies are not cached because also new objects (e.g., Parser, Printer) might be created
		return Proxy.newProxyInstance(
				impl.getClass().getClassLoader(),
				new Class[] { accessInterface },
				new EMFTextAccessProxy(impl));
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
			implMethod = impl.getClass().getMethod(method.getName(), method.getParameterTypes());
			result = implMethod.invoke(impl, args);

			if (result != null && isAccessInterface(method.getReturnType())) {
				result = EMFTextAccessProxy.get(result, method.getReturnType());
			}
		} catch (NoSuchMethodException e) {
			EMFTextAccessPlugin.logError("Required method not defined: " + impl.getClass().getCanonicalName() + "." + method.getName(), null);
		}
		return result;
	}
}
