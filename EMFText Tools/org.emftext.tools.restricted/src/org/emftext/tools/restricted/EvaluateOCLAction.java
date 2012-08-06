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
package org.emftext.tools.restricted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.ocl.ParserException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class EvaluateOCLAction implements IObjectActionDelegate {

	protected static final String[] TOP_LEVEL_DOMAINS = new String[] {"de", "org", "com"};
	private ISelection selection;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i
					.hasNext();) {
				Object o = i.next();
				if (o instanceof IFile) {
					IFile file = (IFile) o;
					process(file);
				}
			}
		}
	}

	private void process(final IFile file) {
		// open dialog with an input field where OCL expressions
		// can be inserted and another text field where the result is shown
		final Shell shell = new Shell(Display.getCurrent());
		
		final ApplicationWindow window = new ApplicationWindow(shell) {
			
			protected Control createContents(Composite parent) {
				parent.getShell().setSize(1024, 768);
				parent.getShell().setText("OCL Evaluator");
				
				Composite composite = new Composite(parent, SWT.NULL);

				GridLayout layout = new GridLayout();
				layout.makeColumnsEqualWidth = true;

				composite.setLayout(layout);
				
				final StyledText expressionTextField = new StyledText(composite, SWT.MULTI);
				expressionTextField.setEditable(false);
				setLayout(expressionTextField, true);
				expressionTextField.setWordWrap(true);
				
				final StyledText outputTextField = new StyledText(composite, SWT.MULTI);
				outputTextField.setEditable(false);
				outputTextField.setWordWrap(true);
				setLayout(outputTextField, true);
				
				final StyledText inputTextField = new StyledText(composite, SWT.MULTI);
				inputTextField.setEditable(true);
				setLayout(inputTextField, true);
				inputTextField.setText("Insert OCL expressions here...");
				inputTextField.setWordWrap(true);
				inputTextField.setFocus();
				
				inputTextField.addModifyListener(new ModifyListener() {

					public void modifyText(ModifyEvent e) {
						evaluateOCL(file, inputTextField.getText(), outputTextField, expressionTextField);
					}
				});
				
				inputTextField.addListener(SWT.Selection, new Listener() {

					public void handleEvent(Event event) {
						int start = event.x;
						int end = event.y;
						String text = inputTextField.getText();
						if (start != end) {
							text = text.substring(start, end);
						}
						evaluateOCL(file, text, outputTextField, expressionTextField);
					}

				});
				
				final Button buttonInputDialog = new Button(composite, SWT.PUSH);
				buttonInputDialog.setText("Close");
				buttonInputDialog.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						close();
					}
				});
				return composite;
			}

			private void setLayout(final StyledText inputTextField, boolean fillVertically) {
				GridData layoutData = new GridData(GridData.VERTICAL_ALIGN_FILL);
				inputTextField.setLayoutData(layoutData);
				if (fillVertically) {
					layoutData.verticalAlignment = GridData.FILL;
					layoutData.grabExcessVerticalSpace = true;
				}
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.grabExcessHorizontalSpace = true;
			}
		};
		window.setStatus("OCL Evaluator");
		window.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	private void evaluateOCL(IFile file, String text, final StyledText outputTextField, StyledText expressionTextField) {
		outputTextField.setText("Result: \n\n");
		outputTextField.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		expressionTextField.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		EObject root = null;
		try {
			root = loadResource(URI.createFileURI(file.getLocation().toFile().getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
			expressionTextField.setText(e.getClass().getName() + " : " + e.getMessage());
			return;
		}
		if (root == null) {
			expressionTextField.setText("Root element is null. Can't evaluate OCL query.");
			return;
		}

		final boolean[] foundSomething = new boolean[1];
		final boolean[] foundSomethingGood = new boolean[1];
		Evaluator evaluator = new Evaluator(new IEvaluationResultHandler() {
			public void handleResult(EObject context, Object result,
					String message) {
				foundSomething[0] = true;
				foundSomethingGood[0] = true;
				String currentText = outputTextField.getText();
				String text = context == null ? "" : context.toString() + ": ";
				text += result == null ? "null" : result.toString();
				text = addLineBreaks(text);
				outputTextField.setText(currentText + text + "\n");
			}

			private String addLineBreaks(String text) {
				String result = text;
				for (String domain : TOP_LEVEL_DOMAINS) {
					result = result.replace(", " + domain, ", \n" + domain);
				}
				return result;
			}

			public void handleException(EObject context, ParserException e) {
				foundSomething[0] = true;
				String currentText = outputTextField.getText();
				String text = context == null ? "" : context.toString() + ": ";
				text = e.getClass().getName() + ": " + e.getMessage();
				outputTextField.setText(currentText + text + "\n");
			}
		});
		List<RestrictedExpression> constraints = new ArrayList<RestrictedExpression>();
		RestrictedExpression restrictedExpression = new RestrictedExpression(text);
		constraints.add(restrictedExpression);
		evaluator.evaluateOCLQueries(root, constraints);

		if (!foundSomething[0]) {
			expressionTextField.setText("No result." + (restrictedExpression.isInvariant() ? " (probably there were no objects matching the context of the invariant)" : ""));
		} else {
			if (foundSomethingGood[0]) {
				expressionTextField.setText("OCL " + getType(restrictedExpression) + ":\n\n" + restrictedExpression.getOclExpression());
				outputTextField.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
				expressionTextField.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			} else {
				expressionTextField.setText("Invalid OCL " + getType(restrictedExpression) + ":\n\n" + restrictedExpression.getOclExpression());
			}
		}
	}

	private String getType(RestrictedExpression restrictedExpression) {
		return (restrictedExpression.isInvariant() ? "invariant" : "query");
	}

	private EObject loadResource(
			URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = (Resource) resourceSet.createResource(uri);
		resource.load(null);
		EObject content = resource.getContents().get(0);
		return content;
	}
}
