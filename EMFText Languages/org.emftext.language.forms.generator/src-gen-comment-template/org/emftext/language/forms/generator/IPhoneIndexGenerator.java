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
package org.emftext.language.forms.generator;

import org.emftext.language.forms.Form;
import org.emftext.language.forms.resource.forms.custom.AbstractGenerator;

public class IPhoneIndexGenerator extends AbstractGenerator {
	public String generateString(Object argument) {
		StringBuilder __content = new StringBuilder();
		Form form = (Form) argument;
        String filename = form.eResource().getURI().lastSegment();
		filename = filename.substring(0, filename.length() - form.eResource().getURI().fileExtension().length());
		__content.append("<html>\n");
		__content.append("<body style=\"background-color:#222222;\">\n");
		__content.append("<table align=\"center\" border=\"0\" style=\"background-image:url(./iphone.png);\">\n");
		__content.append("\t<tr height=\"143px\"/><td width=\"28px\"/><td width=\"318px\"/><td width=\"45px\"/></tr>\n");
		__content.append("\t<tr height=\"467px\"><td/><td>\n");
		__content.append("\t\n");
		__content.append("\t<iframe src=\"./");
		__content.append(filename.replaceAll("\\n\\z","").replace("\n","\n\t"));
		__content.append("html\" width=\"100%\" height=\"100%\">\n");
		__content.append("\t</iframe>\n");
		__content.append("\t</td><td/></tr>\n");
		__content.append("\t<tr height=\"120px\"><td/><td/><td/></tr>\n");
		__content.append("</table>\n");
		__content.append("</body> \n");
		__content.append("</html>\n");
		__content.append(""); 
		/*<html>
		<body style="background-color:#222222;">
		<table align="center" border="0" style="background-image:url(./iphone.png);">
			<tr height="143px"/><td width="28px"/><td width="318px"/><td width="45px"/></tr>
			<tr height="467px"><td/><td>
			
			<iframe src="./filenamehtml" width="100%" height="100%">
			</iframe>
			</td><td/></tr>
			<tr height="120px"><td/><td/><td/></tr>
		</table>
		</body> 
		</html>
		*/
		return __content.toString();
	}
}
