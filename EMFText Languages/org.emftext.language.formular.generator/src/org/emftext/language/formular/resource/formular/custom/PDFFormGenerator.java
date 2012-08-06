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
package org.emftext.language.formular.resource.formular.custom;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;


public class PDFFormGenerator implements IGenerator {

	public byte[] generate(Object argument) {
		FopFactory fopFactory = FopFactory.newInstance();
		IFile foFile = (IFile)argument;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		OutputStream bufferedOutStream = new BufferedOutputStream(outStream);
		try{
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, bufferedOutStream);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();

			StreamSource src = new StreamSource(foFile.getContents());
			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(src, res);

			bufferedOutStream.flush();
			bufferedOutStream.close();
			/*
			FileOutputStream ts = new FileOutputStream("test.pdf");
			ts.write(outStream.toByteArray());
			ts.close();
			*/
			return outStream.toByteArray();
		}
		catch(FOPException e){
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;

	}

}
