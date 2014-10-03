/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class Cct5NewFileContentProvider {
	
	public org.emftext.test.cct5.resource.cct5.ICct5MetaInformation getMetaInformation() {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new EClass[] {
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(EClass[] startClasses, EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(EClass eClass, EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		EObject root = new org.emftext.test.cct5.resource.cct5.util.Cct5MinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		org.emftext.test.cct5.resource.cct5.ICct5TextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (IOException e) {
			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextPrinter getPrinter(OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource());
	}
	
}
