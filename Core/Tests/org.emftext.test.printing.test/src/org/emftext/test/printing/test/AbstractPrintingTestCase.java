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
package org.emftext.test.printing.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.test.printing.modellayout.resource.modellayout.IModellayoutTextPrinter;
import org.emftext.test.printing.modellayout.resource.modellayout.IModellayoutTextResource;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutLayoutInformation;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutPrinter;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutPrinter2;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutResource;
import org.emftext.test.printing.modellayout.resource.modellayout.util.ModellayoutLayoutUtil;
import org.emftext.test.printing.resource.printing.IPrintingTextPrinter;
import org.emftext.test.printing.resource.printing.IPrintingTextResource;
import org.emftext.test.printing.resource.printing.mopp.PrintingMetaInformation;
import org.emftext.test.printing.resource.printing.mopp.PrintingPrinter;
import org.emftext.test.printing.resource.printing.mopp.PrintingPrinter2;
import org.emftext.test.printing.resource.printing.mopp.PrintingResource;
import org.emftext.test.printing.resource.printing.mopp.PrintingResourceFactoryDelegator;
import org.emftext.test.printing.resource.printing.util.PrintingResourceUtil;

public abstract class AbstractPrintingTestCase extends TestCase {

	protected final static String NEW_LINE = PrintingPrinter2.NEW_LINE;
	private int count = 0;

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new PrintingMetaInformation().getSyntaxName(),
				new PrintingResourceFactoryDelegator());
	}
	
	protected Resource createTempResource() {
		// we do need a fresh resource set for each new resource to avoid
		// the proxy object are resolve to the wrong target object
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.createResource(URI.createURI("temp" + count + "." + new PrintingMetaInformation().getSyntaxName()));
	}
	
	protected EObject parse(String text) {
		Resource tempResource = createTempResource();
		try {
			tempResource.load(new ByteArrayInputStream(text.getBytes()), getOptions());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EcoreUtil.resolveAll(tempResource);
		EList<EObject> contents = tempResource.getContents();
		EcoreUtil.resolveAll(tempResource);
		Set<EObject> unresolvedProxies = PrintingResourceUtil.findUnresolvedProxies(tempResource);
		assertEquals("Resource must not contain unresolved proxy objects.", 0, unresolvedProxies.size());
		assertNotNull("Resource must have content.", contents);
		assertEquals(1, contents.size());
		if (!tempResource.getErrors().isEmpty()) 
			System.err.println(tempResource.getErrors().get(0).getMessage());
		assertEquals("Resource should have no errors", 0, tempResource.getErrors().size());
		EObject root = contents.get(0);
		return root;
	}
	
	protected Map<?, ?> getOptions() {
		return null;
	}

	protected void assertPrinting(EObject object, String expectedResultForAutomaticTokenSpace, String expectedResultForTokenSpace1) {
		assertPrinting(object, expectedResultForAutomaticTokenSpace, expectedResultForTokenSpace1, true);
	}

	protected void assertPrinting(EObject object, String expectedResultForAutomaticTokenSpace, String expectedResultForTokenSpace1, boolean compareWithOldPrinter) {
		// we cannot compare anymore with the classic printer, because
		// smart token space handling yields completely different results
		assertPrinting(object, expectedResultForAutomaticTokenSpace, true, false);
		assertPrinting(object, expectedResultForTokenSpace1, false, compareWithOldPrinter);
	}

	protected void assertPrinting(EObject object, String expected, boolean useAutomaticTokenSpaceHandling, boolean compareWithOldPrinter) {
		Resource resource = createTempResource();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String automatic;
		String printer2result;
		// configure printer
		if (resource instanceof PrintingResource) {
			PrintingPrinter2 printer2 = new PrintingPrinter2(outputStream, (IPrintingTextResource) resource);
			if (useAutomaticTokenSpaceHandling) {
				printer2.setHandleTokenSpaceAutomatically(true);
				printer2.setTokenSpace(1);
				automatic = " (automatic)";
			} else {
				printer2.setHandleTokenSpaceAutomatically(false);
				printer2.setTokenSpace(1);
				automatic = "";
			}
			printer2result = getPrintResult(object, printer2, outputStream);
		} else {
			ModellayoutPrinter2 printer2 = new ModellayoutPrinter2(outputStream, (IModellayoutTextResource) resource);
			//this is usually done in doSave() of the resource
			checkTransfer(object);
			new ModellayoutLayoutUtil().transferAllLayoutInformationFromModel(object);
			if (useAutomaticTokenSpaceHandling) {
				printer2.setHandleTokenSpaceAutomatically(true);
				printer2.setTokenSpace(1);
				automatic = " (automatic)";
			} else {
				printer2.setHandleTokenSpaceAutomatically(false);
				printer2.setTokenSpace(1);
				automatic = "";
			}
			printer2result = getPrintResult(object, printer2, outputStream);
			new ModellayoutLayoutUtil().transferAllLayoutInformationToModel(object);
		}
		// we do also trim the result from the new printer, when automatic token space
		// handling is disabled, because then an additional whitespace is found at the
		// end of the output
		if (!useAutomaticTokenSpaceHandling) {
			printer2result = ("_" + printer2result).trim().substring(1);
		}
		System.out.println("PRINTER2" + automatic + " returns: ==>" + printer2result + "<== (" + Arrays.toString(printer2result.getBytes()) + ")");
		System.out.println("Expected is:      ==>" + expected + "<== (" + Arrays.toString(expected.getBytes()) + ")");
		
		outputStream = new ByteArrayOutputStream();
		String printer1result;
		if (resource instanceof PrintingResource) {
			resource = new PrintingResource(URI.createURI("temp2." + new PrintingMetaInformation().getSyntaxName()));
			PrintingPrinter printer1 = new PrintingPrinter(outputStream, (IPrintingTextResource) resource);
			printer1result = getPrintResult(object, printer1, outputStream);
		} else {
			resource = new ModellayoutResource(URI.createURI("temp2." + new PrintingMetaInformation().getSyntaxName()));
			ModellayoutPrinter printer1 = new ModellayoutPrinter(outputStream, (IModellayoutTextResource) resource);
			printer1result = getPrintResult(object, printer1, outputStream);
		}
		// remove trailing whitespace, because this is produced by printer 1, but we do not actually
		// want this
		printer1result = trimLines(printer1result);
		if (compareWithOldPrinter) {
			System.out.println("PRINTER1 returns: ==>" + printer1result + "<== (" + Arrays.toString(printer1result.getBytes()) + ")");
		}
		assertEquals("Wrong result from printer2" + automatic + ".", expected, printer2result);
		if (compareWithOldPrinter) {
			assertEquals("Results from printer2 and 1 do not match.", printer2result, printer1result);
		}
	}
	
	private void checkTransfer(EObject object) {
		ModellayoutLayoutUtil layoutUtil = new ModellayoutLayoutUtil();
		layoutUtil.transferAllLayoutInformationFromModel(object);
		List<ModellayoutLayoutInformation> adapters1 = new ArrayList<ModellayoutLayoutInformation>();
		adapters1.addAll(layoutUtil.getLayoutInformationAdapter(object).getLayoutInformations());
		for (Iterator<EObject> i = object.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			adapters1.addAll(layoutUtil.getLayoutInformationAdapter(next).getLayoutInformations());
		}
		
		layoutUtil.transferAllLayoutInformationToModel(object);
		layoutUtil.transferAllLayoutInformationFromModel(object);
		List<ModellayoutLayoutInformation> adapters2 = new ArrayList<ModellayoutLayoutInformation>();
		adapters2.addAll(layoutUtil.getLayoutInformationAdapter(object).getLayoutInformations());
		for (Iterator<EObject> i = object.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			adapters2.addAll(layoutUtil.getLayoutInformationAdapter(next).getLayoutInformations());
		}
		
		compareAdapterLists(adapters1, adapters2);
	}

	private void compareAdapterLists(
			List<ModellayoutLayoutInformation> adapters1,
			List<ModellayoutLayoutInformation> adapters2) {
		assertEquals(adapters1.size(), adapters2.size());
		Iterator<ModellayoutLayoutInformation> i1 = adapters1.iterator();
		Iterator<ModellayoutLayoutInformation> i2 = adapters2.iterator();
		while (i1.hasNext()) {
			ModellayoutLayoutInformation li1 = i1.next();
			ModellayoutLayoutInformation li2 = i2.next();
			assertEquals(li1.getHiddenTokenText(), li2.getHiddenTokenText());
			assertEquals(li1.getObject(null, false), li2.getObject(null, false));
			assertEquals(li1.getStartOffset(), li2.getStartOffset());
			assertEquals(li1.getVisibleTokenText(), li1.getVisibleTokenText());
			assertEquals(li1.getSyntaxElement(), li2.getSyntaxElement());
		}
		
	}

	protected void assertPrintingWithoutLayout(EObject object) {
		//compares the results of printer1 and printer2
		Resource resource = createTempResource();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		String printer2result;
		if (resource instanceof PrintingResource) {
			PrintingPrinter2 printer2 = new PrintingPrinter2(outputStream, (IPrintingTextResource) resource);
			printer2.setHandleTokenSpaceAutomatically(false);
			printer2.setTokenSpace(1);
			printer2result = getPrintResult(object, printer2, outputStream);
		} else {
			ModellayoutPrinter2 printer2 = new ModellayoutPrinter2(outputStream, (IModellayoutTextResource) resource);
			//this is usually done in doSave() of the resource
			new ModellayoutLayoutUtil().transferAllLayoutInformationFromModel(object);
			printer2.setHandleTokenSpaceAutomatically(false);
			printer2.setTokenSpace(1);
			printer2result = getPrintResult(object, printer2, outputStream);
			new ModellayoutLayoutUtil().transferAllLayoutInformationToModel(object);
		}
		printer2result = trimLines(printer2result);
		
		outputStream = new ByteArrayOutputStream();
		String printer1result;
		if (resource instanceof PrintingResource) {
			resource = new PrintingResource(URI.createURI("temp2." + new PrintingMetaInformation().getSyntaxName()));
			PrintingPrinter printer1 = new PrintingPrinter(outputStream, (IPrintingTextResource) resource);
			printer1result = getPrintResult(object, printer1, outputStream);
		} else {
			resource = new ModellayoutResource(URI.createURI("temp2." + new PrintingMetaInformation().getSyntaxName()));
			ModellayoutPrinter printer1 = new ModellayoutPrinter(outputStream, (IModellayoutTextResource) resource);
			printer1result = getPrintResult(object, printer1, outputStream);
		}
		printer1result = trimLines(printer1result);
		
		assertEquals("Results from printer2 and 1 do not match.", printer2result, printer1result);
	}

	private String trimLines(String printer1result) {
		StringBuffer buffer = new StringBuffer();
		String[] lines = printer1result.split(NEW_LINE);
		boolean isFirst = true;
		for (String line : lines) {
			if (!isFirst) {
				buffer.append(NEW_LINE);
			}
			buffer.append(line.replaceAll("\\u0020+$", ""));
			isFirst = false;
		}
		return buffer.toString();
	}

	protected String getPrintResult(EObject object, IPrintingTextPrinter printer, OutputStream outputStream) {
		try {
			printer.print(object);
			String result = outputStream.toString();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return null;
	}
	
	protected String getPrintResult(EObject object, IModellayoutTextPrinter printer, OutputStream outputStream) {
		try {
			printer.print(object);
			String result = outputStream.toString();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return null;
	}
}
