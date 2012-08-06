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
package org.emftext.language.templateconcepts.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.templateconcepts.call.TemplateCall;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallOptionProvider;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallOptions;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallResourcePostProcessor;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallResourcePostProcessorProvider;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallTextResource;
import org.emftext.language.templateconcepts.call.resource.templatecall.mopp.TemplatecallResource;
import org.emftext.language.templateconcepts.Template;

public class InterpreterExecuter implements ITemplatecallOptionProvider, ITemplatecallResourcePostProcessorProvider, ITemplatecallResourcePostProcessor {

	public void process(TemplatecallResource resource) {
		if (resource==null || resource.getContents().size() == 0) {
			return;
		}
		TemplateCall tc = (TemplateCall) resource.getContents().get(0);
		final EObject parameterModel = tc.getParameterModel();
		Template template = tc.getTarget();
		ITemplateInterpreter interpreter = TemplateInterpreterFactory.createTemplateInterpreter();
		Collection<Diagnostic> problems = new ArrayList<Diagnostic>();
		EObject templateInstanceAST = interpreter.interprete(template, parameterModel, problems);
		if (problems.size() > 0) {
			for (Diagnostic problem : problems) {
				resource.getErrors().add(problem);
			}
		} else {
			// pretty print templateInstanceAST
			saveTemplateInstance(resource, templateInstanceAST);
		}
	}

	private void saveTemplateInstance(ITemplatecallTextResource resource,
			EObject templateInstanceAST) {

		if (templateInstanceAST == null) {
			System.out.println("Interpreter.saveTemplateInstance() AST is null.");
			return;
		}
		// figure out the correct file extension for the template instance

		String fileExtension = resource.getURI().trimFileExtension().fileExtension();

		if (fileExtension == null) {
			fileExtension = "unknown";
		}
		// TODO Find different way to resolve object language metamodel (Put into template itself)
		/*String targetNamespace = templateInstanceAST.eClass().getEPackage().getNsURI();
		Map<String, URI> syntaxes = EMFTextRuntimePlugin.getURIToConcreteSyntaxLocationMap();
		for (String syntaxName : syntaxes.keySet()) {
			if (syntaxName.startsWith(targetNamespace + "%%")) {
				fileExtension = syntaxName.split("%%")[1];
			}
		}*/
		// save it
		final Resource instance = new ResourceSetImpl().createResource(resource.getURI().trimFileExtension().trimFileExtension().appendFileExtension(fileExtension));
		instance.getContents().add(templateInstanceAST);
		new Job("saving " + instance.getURI().lastSegment()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					instance.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	public ITemplatecallResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(ITemplatecallOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public void terminate() {
		// do nothing
	}
}
