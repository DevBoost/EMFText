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
package org.emftext.language.hedl.test;

import java.util.List;

import org.emftext.language.hedl.resource.hedl.mopp.HedlTaskItem;
import org.emftext.language.hedl.resource.hedl.mopp.HedlTaskItemDetector;

import junit.framework.TestCase;

public class TaskItemDetectorTest extends TestCase {

	private HedlTaskItemDetector detector;

	public void setUp() {
		detector = new HedlTaskItemDetector();
	}
	
	public void testDetection1() {
		String text = "/** TODO item one */";
		int line = 0;
		int charStart = 0;
		
		List<HedlTaskItem> taskItems = detector.findTaskItems(text, line, charStart);
		assertEquals(1, taskItems.size());
		HedlTaskItem firstItem = taskItems.get(0);
		assertEquals("TODO item one", firstItem.getMessage());
	}

	public void testDetection2() {
		testDetection(0, 0);
		testDetection(20, 100);
	}

	private void testDetection(int line, int charStart) {
		String text = 
			"/** \n" +
			" * TODO item one \n" +
			" * TODO item two \n" +
			" * TODO item three \n" +
			" */";
		
		List<HedlTaskItem> taskItems = detector.findTaskItems(text, line, charStart);
		assertEquals(3, taskItems.size());
		HedlTaskItem firstItem = taskItems.get(0);
		String itemOneText = "TODO item one";
		assertEquals(itemOneText, firstItem.getMessage());
		assertEquals(charStart + text.indexOf(itemOneText), firstItem.getCharStart());
		assertEquals(itemOneText, firstItem.getMessage());

		HedlTaskItem secondItem = taskItems.get(1);
		String itemTwoText = "TODO item two";
		assertEquals(itemTwoText, secondItem.getMessage());
		assertEquals(charStart + text.indexOf(itemTwoText), secondItem.getCharStart());
		assertEquals(itemTwoText, secondItem.getMessage());
		
		HedlTaskItem thirdItem = taskItems.get(2);
		String itemThreeText = "TODO item three";
		assertEquals(itemThreeText, thirdItem.getMessage());
		assertEquals(charStart + text.indexOf(itemThreeText), thirdItem.getCharStart());
		assertEquals(itemThreeText, thirdItem.getMessage());
		
		assertEquals(line + 1, firstItem.getLine());
		assertEquals(line + 2, secondItem.getLine());
		assertEquals(line + 3, thirdItem.getLine());

		assertEquals("TODO", firstItem.getKeyword());
		assertEquals("TODO", secondItem.getKeyword());
		assertEquals("TODO", thirdItem.getKeyword());
	}

	public void testDetection3() {
		String text = "// TODO item one";
		int line = 0;
		int charStart = 0;
		
		List<HedlTaskItem> taskItems = detector.findTaskItems(text, line, charStart);
		assertEquals(1, taskItems.size());
		HedlTaskItem firstItem = taskItems.get(0);
		assertEquals("TODO item one", firstItem.getMessage());
	}


	public void testDetection4() {
		String text = "// TODO item one";
		int line = 20;
		int charStart = 1000;
		
		List<HedlTaskItem> taskItems = detector.findTaskItems(text, line, charStart);
		assertEquals(1, taskItems.size());
		HedlTaskItem firstItem = taskItems.get(0);
		assertEquals("TODO item one", firstItem.getMessage());
	}

}
