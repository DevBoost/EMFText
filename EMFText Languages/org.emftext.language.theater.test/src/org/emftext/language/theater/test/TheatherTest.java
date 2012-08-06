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
package org.emftext.language.theater.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.theater.Actor;
import org.emftext.language.theater.Play;
import org.emftext.language.theater.Role;
import org.emftext.language.theater.Speech;
import org.junit.Test;

public class TheatherTest extends ParsingTestCase {
	
	private static final String PATH_TO_INPUT_FILE = "input" + File.separator + "macbeth.theater";

	@Test
	public void testAppearsIn() throws IOException {
		Resource actingResource = parserInputFile(PATH_TO_INPUT_FILE);
		assertTrue("Resource is empty",actingResource != null);
		assertTrue("Resource has no root", actingResource.getContents().size() == 1 && 
				actingResource.getContents().get(0) instanceof Play);
		Play play = (Play) actingResource.getContents().get(0);
		EList<Actor> actors = play.getEnsemble().getActors();
		boolean visitedTomas = false;
		for (Actor actor : actors) {
			assertTrue("Actor has no appearances: " + actor.getName(), actor.getAppearsIn().size()>0);
			assertTrue("Actor has no role script: " + actor.getName(), actor.getPlays().get(0).getRoleScript().size()>0);
			if (actor.getName().equals("Thomas")) {
				EList<Speech> roleScript = actor.getPlays().get(0).getRoleScript();
				for (Speech speech : roleScript) {
					System.out.println(speech.getPlayedBy() + ": " + speech.getText());
				}
				assertEquals("Role Scrips size is wrong.", 58, actor.getPlays().get(0).getRoleScript().size());
				visitedTomas  = true;
			}
		}
		assertTrue("Thomas was not visited", visitedTomas);
	}
	
	@Test
	public void testActOne() throws IOException {
		Resource actingResource = parserInputFile(PATH_TO_INPUT_FILE);
		assertTrue("Resource is empty", actingResource != null);
		assertTrue("Resource has no root", actingResource.getContents().size() == 1 && 
				actingResource.getContents().get(0) instanceof Play);
		Play play = (Play) actingResource.getContents().get(0);
		
		for (Role role : play.getDeclaredRoles()) {
			if(role.getName().equals("Macb")) {
				System.out.println("=== Macbeth - Act 1 ===");
				EList<Speech> roleScript = role.getRoleScript();
				for (Speech speech : roleScript) {
					System.out.println(speech.getPlayedBy().get(0).getName() + ": '" + speech.getText()+"'\n");
				}
			} else if (role.getName().equals("1")) {
				System.out.println("=== Witch One - Act 1 ===");
				EList<Speech> roleScript = role.getRoleScript();
				for (Speech speech : roleScript) {
					System.out.println(speech.getPlayedBy().get(0).getName() + ": '" + speech.getText()+"'\n");
				}
			}
		}
	}
}
