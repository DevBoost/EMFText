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
package org.emftext.language.forms.resource.forms.custom;

import generator.html.IPhoneFormGenerator;
import generator.xml.FOFormGenerator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.generator.HTMLFormGenerator;
import org.emftext.language.forms.generator.IPhoneIndexGenerator;
import org.emftext.language.forms.generator.XMLFormGenerator;
import org.emftext.language.forms.resource.forms.FormsGeneratorPlugin;

/**
 * The FormsGenerator use all available generators to
 * transform .form files to readable output formats.
 */
public class FormsGenerator {

	public void process(EList<EObject> contents) {

		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			if (eobject instanceof Form) {
				final Form form = (Form) eobject;
				final IProject project = WorkspaceSynchronizer.getFile(
						form.eResource()).getProject();
				Job creationJob = new Job("Generating Forms") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						createHTMLForm(project, form);
						createIPhoneForm(project, form);
						createXMLForm(project, form);
						IFile result = createFoForm(project, form);
						createPSForm(result, getTrimedFilename(form));
						return Status.OK_STATUS;
					}

				};

				creationJob.schedule();
			}
		}

	}

	private void createIPhoneForm(IProject project, Form form) {
		String iphone = "iphone";

		final IPhoneFormGenerator iphoneFormGen = new IPhoneFormGenerator();
		generateForm(project, form, iphone, getTrimedFilename(form) + "html",
				iphoneFormGen);
		final IPhoneIndexGenerator iphoneIndexGen = new IPhoneIndexGenerator();
		generateForm(project, form, iphone, "index.html", iphoneIndexGen);
		copyAndExtractWebAppFramework(project.getFolder(iphone));

	}

	private String getTrimedFilename(Form form) {
		String filename = form.eResource().getURI().lastSegment();
		filename = filename.substring(0, filename.length()
				- form.eResource().getURI().fileExtension().length());
		return filename;
	}

	private void copyAndExtractWebAppFramework(IFolder iFolder) {
		IFile destFile = iFolder.getFile("WebApp.zip");
		if (destFile.exists())
			return;
		URL entry = FormsGeneratorPlugin.getDefault().getBundle().getEntry(
				"/WebApp.zip");

		try {
			InputStream in = entry.openStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte buf[] = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			out.flush();
			destFile.create(new ByteArrayInputStream(out.toByteArray()), false,
					new NullProgressMonitor());
			in.close();
			iFolder.refreshLocal(IFolder.DEPTH_INFINITE,
					new NullProgressMonitor());
			unzip(destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void unzip(IFile zioContainer) {
		File localFile = zioContainer.getLocation().toFile();
		File containingFolder = localFile.getParentFile();
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(localFile);
			List<ZipEntry> files = new ArrayList<ZipEntry>();
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry nextElement = entries.nextElement();
				if (nextElement.isDirectory()) {
					File dir = new File(containingFolder + File.separator
							+ nextElement.getName());
					dir.mkdir();
				} else {
					files.add(nextElement);
				}
			}

			for (ZipEntry fileEntry : files) {
				int size;
				byte[] buffer = new byte[2048];
				BufferedInputStream bis = new BufferedInputStream(zipFile
						.getInputStream(fileEntry));
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(containingFolder + File.separator
								+ fileEntry.getName()), buffer.length);
				while ((size = bis.read(buffer, 0, buffer.length)) != -1) {
					bos.write(buffer, 0, size);
				}
				bos.flush();
				bos.close();
				bis.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createHTMLForm(IProject project, Form form) {
		final HTMLFormGenerator htmlFormGen = new HTMLFormGenerator();
		generateForm(project, form, "html", getTrimedFilename(form) + "html",
				htmlFormGen);
	}

	private void createXMLForm(IProject project, Form form) {
		XMLFormGenerator xmlFormGenerator = new XMLFormGenerator();
		generateForm(project, form, "xml", getTrimedFilename(form) + "xml",
				xmlFormGenerator);
	}

	private IFile createFoForm(IProject project, Form form) {
		FOFormGenerator foFormGenerator = new FOFormGenerator();
		return generateForm(project, form, "xsl-fo", getTrimedFilename(form)
				+ "xml", foFormGenerator);
	}

	private IFile createPSForm(IFile foFile, String titel) {
		PDFFormGenerator psFormGenerator = new PDFFormGenerator();
		return generateForm(foFile.getProject(), foFile, "pdf", titel + "pdf",
				psFormGenerator);
	}

	private IFile generateForm(IProject targetProject, Object argument,
			String folderName, String filename, final IGenerator generator) {
		try {

			IFolder folder = targetProject.getFolder(folderName);
			if (!folder.exists()) {
				try {
					folder.create(true, true, new NullProgressMonitor());
					folder.refreshLocal(IFolder.DEPTH_INFINITE,
							new NullProgressMonitor());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			IFile file = folder.getFile(filename);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] generatedBytes = generator.generate(argument);
			if (generatedBytes != null) {
				outStream.write(generatedBytes);
			}
			outStream.flush();

			if (!file.exists()) {
				file.create(new ByteArrayInputStream(outStream.toByteArray()),
						false, new NullProgressMonitor());
			} else {
				file
						.setContents(new ByteArrayInputStream(outStream
								.toByteArray()), false, true,
								new NullProgressMonitor());
			}

			folder.refreshLocal(IFolder.DEPTH_INFINITE,
					new NullProgressMonitor());
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}
}
