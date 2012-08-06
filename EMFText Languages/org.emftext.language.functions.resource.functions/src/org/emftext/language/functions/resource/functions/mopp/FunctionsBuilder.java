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
package org.emftext.language.functions.resource.functions.mopp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.emftext.language.functions.FunctionSet;
import org.emftext.language.functions.generators.LatexGenerator;
import org.emftext.language.functions.resource.functions.IFunctionsBuilder;
import org.emftext.language.functions.resource.functions.util.FunctionsStreamUtil;
import org.emftext.language.functions.resource.functions.util.FunctionsURIUtil;

public class FunctionsBuilder implements IFunctionsBuilder {
	
	private final static String PDF_CONSOLE = FunctionsBuilder.class.getName() + ".pdf_console";
	
	public boolean isBuildingNeeded(URI uri) {
		return !new FunctionsURIUtil().isInBinFolder(uri);
	}
	
	public IStatus build(FunctionsResource resource, IProgressMonitor monitor) {
		IFile modelFile = WorkspaceSynchronizer.getFile(resource);
		IContainer modelFolder = modelFile.getParent();
		File modelFolderFile = modelFolder.getLocation().toFile();
		
		File latexFile = runLatexGenerator(resource, monitor, modelFolderFile);
		
		runPDFLatex(modelFolderFile, latexFile);
		runPDFLatex(modelFolderFile, latexFile);
		refreshFolder(monitor, modelFolder);
		return Status.OK_STATUS;
	}

	private File runLatexGenerator(FunctionsResource resource,
			IProgressMonitor monitor, File modelFolderFile) {
		String filename = resource.getURI().trimFileExtension().lastSegment();
		
		final File latexMainFile = new File(modelFolderFile, filename + ".tex");
		final File latexCostsFile = new File(modelFolderFile, filename + "_function_costs.tex");

		LatexGenerator generator = new LatexGenerator();
		EList<EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return latexMainFile;
		}
		EObject root = contents.get(0);
		if (!(root instanceof FunctionSet)) {
			return latexMainFile;
		}
		FunctionSet functionSet = (FunctionSet) root;

		saveToFile(latexMainFile, generator.generateLatexMainFile(filename), false);
		
		generateFunctionDescriptionFile(modelFolderFile, filename, generator,
				functionSet, "");
		
		saveToFile(latexCostsFile, generator.generateFunctionCostTable(functionSet), true);
		return latexMainFile;
	}

	private void generateFunctionDescriptionFile(File modelFolderFile,
			String filename, LatexGenerator generator, FunctionSet functionSet, String suffix) {
		
		if (!functionSet.getElements().isEmpty()) {
			final File latexFunctionsFile = new File(modelFolderFile, filename + "_function_descriptions" + suffix + ".tex");
			saveToFile(latexFunctionsFile, generator.generateFunctionDescriptions(functionSet), true);
		}
		
		for (FunctionSet subset : functionSet.getSubsets()) {
			generateFunctionDescriptionFile(modelFolderFile, filename, generator, subset, "_" + subset.getName());
		}
	}

	private void saveToFile(final File targetFile, String text, boolean override) {
		if (targetFile.exists() && !override) {
			return;
		}
		try {
			InputStream in = new ByteArrayInputStream(text.getBytes("UTF-8"));
			FileOutputStream fos = new FileOutputStream(targetFile);
			FunctionsStreamUtil.copy(in, fos);
			fos.close();
		} catch (IOException e) {
			FunctionsPlugin.logError(e.getMessage(), e);
		}
	}

	private void runPDFLatex(final File modelFolderFile, final File latexFile) {
		new Job("Run PDF Latex") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// call PDF Latex
				ProcessBuilder builder = new ProcessBuilder("pdflatex", "-interaction=nonstopmode", "--src", latexFile.getAbsolutePath());
				try {
					builder.directory(modelFolderFile);
					Process process = builder.start();
					
			        InputStream inputStream = process.getInputStream();
			        byte[] buffer = new byte[8096];
			        int read = 0;
			        StringBuffer buf = new StringBuffer();
			        while (read >= 0) {
			            read = inputStream.read(buffer);                
			            if (read > 0) {
			                String text = new String(buffer, 0, read);
			                buf.append(text);
			            }
			        }

			        MessageConsole myConsole = findConsole(PDF_CONSOLE);
	                MessageConsoleStream out = myConsole.newMessageStream();
	                out.println(buf.toString());
	                out.close();
				} catch (IOException e) {
					FunctionsPlugin.logError(e.getMessage(), e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}
	
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

   private void refreshFolder(IProgressMonitor monitor, IContainer modelFolder) {
		try {
			modelFolder.refreshLocal(1, monitor);
		} catch (CoreException e) {
			FunctionsPlugin.logError(e.getMessage(), e);
		}
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
