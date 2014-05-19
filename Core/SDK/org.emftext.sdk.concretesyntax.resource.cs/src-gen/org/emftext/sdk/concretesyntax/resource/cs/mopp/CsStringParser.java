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

/**
 * Utility class to allow parsing of textual language fragments in string format.
 */
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CsStringParser {
	
	/**
	 * Parses the textual representation of a model. This method is deprecated because
	 * it uses the default platform encoding. Use {@link #parseString(String, String}
	 * instead.
	 */
	@Deprecated
	public static EObject parseString(String textualModel) {
		return parseString(textualModel, (EClass) null);
	}
	
	/**
	 * Parses the textual representation of a model.
	 */
	public static EObject parseString(String textualModel, String encoding) {
		return parseString(textualModel, null, encoding);
	}
	
	/**
	 * Parses the textual representation of a model using an arbitrary start class as
	 * override for the ones specified in the syntax. The start class must have a
	 * corresponding rule (i.e., it must be a non-abstract non-interface class with
	 * declared concrete syntax that does not represent an operator rule). This method
	 * is deprecated because it uses the default platform encoding. Use {@link
	 * #parseString(String, EClass, String)} instead.
	 */
	@Deprecated
	public static EObject parseString(String textualModel, EClass startEClass) {
		ByteArrayInputStream input = null;
		
		new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().registerResourceFactory();
		try {
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.createResource(URI.createFileURI("in_memory_temp.cs"));
			
			input = new ByteArrayInputStream(textualModel.getBytes());
			
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			
			if (startEClass != null) {
				options.put(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.RESOURCE_CONTENT_TYPE, startEClass);
			}
			
			resource.load(input, options);
			
			List<EObject> contents = resource.getContents();
			
			if (!contents.isEmpty()) {
				return contents.get(0);
			}
		} catch(Exception e) {
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch(Exception e) {
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Parses the textual representation of a model using an arbitrary start class as
	 * override for the ones specified in the syntax. The start class must have a
	 * corresponding rule (i.e., it must be a non-abstract non-interface class with
	 * declared concrete syntax that does not represent an operator rule).
	 */
	public static EObject parseString(String textualModel, EClass startEClass, String encoding) {
		ByteArrayInputStream input = null;
		
		new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().registerResourceFactory();
		try {
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.createResource(URI.createFileURI("in_memory_temp.cs"));
			
			if (encoding == null) {
				input = new ByteArrayInputStream(textualModel.getBytes());
			} else {
				input = new ByteArrayInputStream(textualModel.getBytes(encoding));
			}
			
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			
			if (startEClass != null) {
				options.put(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.RESOURCE_CONTENT_TYPE, startEClass);
			}
			
			resource.load(input, options);
			
			List<EObject> contents = resource.getContents();
			
			if (!contents.isEmpty()) {
				return contents.get(0);
			}
		} catch(Exception e) {
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch(IOException e) {
				}
			}
		}
		
		return null;
	}
	
}
