package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsNewFileWizard extends org.eclipse.jface.wizard.Wizard implements org.eclipse.ui.INewWizard {
	
	private String categoryId = null;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsNewFileWizardPage page;
	private org.eclipse.jface.viewers.ISelection selection;
	private String newName = null;
	
	public CsNewFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String id) {
		categoryId = id;
	}
	
	// Adds the page to the wizard.
	public void addPages() {
		page = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsNewFileWizardPage(selection, getFileExtension());
		addPage(page);
	}
	
	// This method is called when 'Finish' button is pressed in
	// the wizard. We will create an operation and run it
	// using wizard as execution context.
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		this.newName = fileName;
		int seperatorIdx = newName.indexOf('.');
		if(seperatorIdx != -1) {
			newName = newName.substring(0, seperatorIdx);
		}
		final org.eclipse.core.resources.IFile file;
		try {
			file = getFile(fileName, containerName);
		} catch (org.eclipse.core.runtime.CoreException e1) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("java.lang.Exception while initializing new file", e1);
			return false;
		}
		
		if (file.exists()) {
			// ask for confirmation
			org.eclipse.swt.widgets.MessageBox messageBox = new org.eclipse.swt.widgets.MessageBox(getShell(), org.eclipse.swt.SWT.ICON_QUESTION			| org.eclipse.swt.SWT.YES | org.eclipse.swt.SWT.NO);
			messageBox.setMessage("File \"" + fileName + "\" already exists. Do you want to override it?");
			messageBox.setText("File exists");
			int response = messageBox.open();
			if (response == org.eclipse.swt.SWT.NO) {
				return true;
			}
		}
		
		org.eclipse.jface.operation.IRunnableWithProgress op = new org.eclipse.jface.operation.IRunnableWithProgress() {
			public void run(org.eclipse.core.runtime.IProgressMonitor monitor) throws java.lang.reflect.InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (org.eclipse.core.runtime.CoreException e) {
					throw new java.lang.reflect.InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (java.lang.reflect.InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			org.eclipse.jface.dialogs.MessageDialog.openError(getShell(), "Error", realException.getMessage());
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("java.lang.Exception while initializing new file", e);
			return false;
		}
		return true;
	}
	
	// The worker method. It will find the container, create the
	// file if missing or just replace its contents, and open
	// the editor on the newly created file.
	private void doFinish(String containerName, String fileName, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		final org.eclipse.core.resources.IFile file = getFile(fileName, containerName);
		try {
			java.io.InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (java.io.IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				org.eclipse.ui.IWorkbenchPage page = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					org.eclipse.ui.ide.IDE.openEditor(page, file, true);
				} catch (org.eclipse.ui.PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	private org.eclipse.core.resources.IFile getFile(String fileName, String containerName) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IWorkspaceRoot root = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
		org.eclipse.core.resources.IResource resource = root.findMember(new org.eclipse.core.runtime.Path(containerName));
		if (!resource.exists() || !(resource instanceof org.eclipse.core.resources.IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		org.eclipse.core.resources.IContainer container = (org.eclipse.core.resources.IContainer) resource;
		final org.eclipse.core.resources.IFile file = container.getFile(new org.eclipse.core.runtime.Path(fileName));
		return file;
	}
	
	// We will initialize file contents with a sample text.
	private java.io.InputStream openContentStream() {
		return new java.io.ByteArrayInputStream(getExampleContent().getBytes());
	}
	
	private void throwCoreException(String message) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.runtime.IStatus status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, "NewFileContentPrinter", org.eclipse.core.runtime.IStatus.OK, message, null);
		throw new org.eclipse.core.runtime.CoreException(status);
	}
	
	// We will accept the selection in the workbench to see if
	// we can initialize from it.
	// @see IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	public void init(org.eclipse.ui.IWorkbench workbench, org.eclipse.jface.viewers.IStructuredSelection selection) {
		this.selection = selection;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	private String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("java.lang.Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public java.lang.String getFileExtension() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation getMetaInformation() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	}
	
	public String getExampleContent() {
		return "SYNTAXDEF myFileExtension\n" +
		"FOR <http://www.some-domain.org/myLanguage> <optional/path/to/myLanguage.genmodel>\n" +
		"START StartMetaClass\n" +
		"\n" +
		"OPTIONS {\n" +
		"\treloadGeneratorModel = \"true\";\n" +
		"}\n" +
		"\n" +
		"RULES {\n" +
		"\t// syntax definition for class 'StartMetaClass'\n" +
		"\tStartMetaClass   ::= \"myKeyword\" attributeOfStartMetaClass[] aContainmentReference* ;\n" +
		"\t\n" +
		"\t// syntax definition for class 'AnotherMetaClass'\n" +
		"\tAnotherMetaClass ::= \"otherKeyword\" aNonContainmentReference[];\n" +
		"}";
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPrinter(outputStream, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource());
	}
}
