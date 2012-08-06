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
package org.emftext.language.java.ejava.resource.ejava.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.emftext.language.java.ejava.resource.ejava.util.EjavaRuntimeUtil;

/**
 * The NewFileWizardPage allows setting the container for the new file, as well as
 * the file name. The page will only accept file names without extension OR with
 * an extension that matches the expected one.
 */
public class EjavaNewFileWizardPage extends org.eclipse.jface.wizard.WizardPage {

	private final String fileExtension;
	private CLabel packageText;
	private CLabel metaclassText;
	private org.eclipse.jface.viewers.ISelection selection;
	private Map<EPackage, IFile> packageMap;
	private String metaClassName = "";
	private String packageName = "";
	private IContainer container;
	private EPackage selectedMetamodel;
	private GenModel correspondingGenmodel;
	private EClass selectedMetaclass;
	private org.eclipse.swt.widgets.Button packageButton;
	private org.eclipse.swt.widgets.Button metaclassButton;
	private IFile ejavaFile;
	private Map<GenModel, IFile> genmodelMap;
	private AdapterFactoryLabelProvider labelProvider;

	/**
	 * Constructor for the NewFileWizardPage.
	 */
	public EjavaNewFileWizardPage(org.eclipse.jface.viewers.ISelection selection, String fileExtension) {
		super("wizardPage");
		setTitle("Create new ejava file");
		setDescription("This wizard creates a new file with *." + fileExtension + " extension that can be opened with the EMFText editor.");
		this.selection = selection;
		this.fileExtension = fileExtension;
	}

	/**
	 * 
	 * @see IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		initializeMeta();
		initializeLabelProvider();
		org.eclipse.swt.widgets.Composite container = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NULL);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		Label label = new org.eclipse.swt.widgets.Label(container, org.eclipse.swt.SWT.NULL);
		label.setText("&Package:");
		packageText = new CLabel(container, SWT.LEFT | SWT.BORDER);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		packageText.setLayoutData(gd);
		packageButton = new org.eclipse.swt.widgets.Button(container, org.eclipse.swt.SWT.PUSH);
		packageButton.setText("Browse...");
		packageButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				EPackage dialogPackage = handleBrowse(packageMap.keySet(), "Select a metamodel contained in this project", EPackage.class); 
				if(dialogPackage != null && !dialogPackage.equals(selectedMetamodel)){
					selectedMetamodel = dialogPackage;
					correspondingGenmodel = getGenmodelFromPackage(selectedMetamodel);
					packageName = selectedMetamodel.getName();
					packageText.setText(labelProvider.getText(selectedMetamodel));
					packageText.setImage(labelProvider.getImage(selectedMetamodel));
					selectedMetaclass = null;
					metaClassName = "";
					metaclassText.setText("");
					metaclassText.setImage(null);
				} 
				dialogChanged();
			}
		});
		label = new org.eclipse.swt.widgets.Label(container, org.eclipse.swt.SWT.NULL);
		label.setText("&Metaclass:");
		metaclassText = new CLabel(container, SWT.LEFT | SWT.BORDER);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		metaclassText.setLayoutData(gd);
		metaclassButton = new org.eclipse.swt.widgets.Button(container, org.eclipse.swt.SWT.PUSH);
		metaclassButton.setText("Browse...");
		metaclassButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				List<EClass> metaclasses = getMetaclassesFromPackage(selectedMetamodel);
				EClass dialogClass = handleBrowse(metaclasses, "Select a metaclass in metamodel '" + getContainerName() + "'", EClass.class);
				if(dialogClass != null && !dialogClass.equals(selectedMetaclass)){
					selectedMetaclass = dialogClass;
					metaClassName = selectedMetaclass.getName();
					metaclassText.setText(labelProvider.getText(selectedMetaclass));
					metaclassText.setImage(labelProvider.getImage(selectedMetaclass));
				}
				dialogChanged();
			}
		});

		initializeUI();
		dialogChanged();
		setControl(container);
	}

	private void initializeLabelProvider() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	private List<EClass> getMetaclassesFromPackage(EPackage selectedMetamodel) {
		List<EClass> metaclasses = new ArrayList<EClass>();
		if(selectedMetamodel != null){
			EList<EClassifier> classifiers = selectedMetamodel.getEClassifiers();
			for (EClassifier classifier : classifiers) {
				if(classifier instanceof EClass){
					metaclasses.add((EClass) classifier); 
				}
			}
			for (EPackage subPackage : selectedMetamodel.getESubpackages()) {
				metaclasses.addAll(getMetaclassesFromPackage(subPackage));
			}
		}
		return metaclasses;
	}

	private <T extends EObject> Map<T, IFile> getEObjectToFileMap(List<IFile> files, Class<T> clazz) {
		if(files == null || files.size() == 0 || clazz == null){
			return null;
		}
		Map<T, IFile> map = new HashMap<T, IFile>();
		ResourceSet rs = new ResourceSetImpl();
		for (IFile file : files) {
			IPath path = file.getFullPath();
			URI uri = URI.createPlatformResourceURI(path.toString(), true);
			Resource emfResource = rs.getResource(uri, true);
			if(emfResource != null){
				EObject model = emfResource.getContents().get(0);
				if(clazz.isInstance(model)){
					map.put(clazz.cast(model), file);
				}
			}
		}
		return map;
	}

	private List<IFile> getFilesByExtension(IContainer parent, String extension) {
		List<IFile> ecoreFiles = new ArrayList<IFile>();
		try {
			IResource[] members = parent.members();
			for (IResource member : members) {
				if(member instanceof IFile && member.getName().endsWith(extension)){
					ecoreFiles.add((IFile) member);
				} else if (member instanceof IFolder){
					ecoreFiles.addAll(getFilesByExtension((IFolder) member, extension));
				}
			}
		} catch (CoreException e1) {
			new EjavaRuntimeUtil().logError("Could not get the members of container " + parent.getName(), e1);
		}
		return ecoreFiles;
	}


	private void initializeMeta() {
		if(selection instanceof IStructuredSelection){
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() == 1){
				Object firstElement = ssel.getFirstElement();
				IProject project = null;
				if(firstElement instanceof IAdaptable){
					IAdaptable adapter = (IAdaptable) firstElement;
					project = (IProject) adapter.getAdapter(IProject.class);
					IResource resource = (IResource) adapter.getAdapter(IResource.class);
					IContainer container = (IContainer) adapter.getAdapter(IContainer.class);
					if(project == null && resource != null){
						project = resource.getProject();
					} else if(project == null && container != null){
						project = container.getProject();
					}
					if(project != null){
						List<IFile> ecoreFiles = getFilesByExtension(project, ".ecore");
						List<IFile> genmodelFiles = getFilesByExtension(project, ".genmodel");
						packageMap = getEObjectToFileMap(ecoreFiles, EPackage.class);
						genmodelMap = getEObjectToFileMap(genmodelFiles, GenModel.class);
						if(genmodelMap == null){
							return;
						}
						if(firstElement instanceof IFile){
							IFile file = (IFile) firstElement;
							metaClassName = file.getFullPath().removeFileExtension().lastSegment();
							IContainer fileParent = file.getParent();
							packageName = fileParent.getFullPath().lastSegment();
							selectedMetamodel = getEPackageByName(packageName);
							if(selectedMetamodel != null){
								selectedMetaclass = (EClass) selectedMetamodel.getEClassifier(metaClassName);
								if(selectedMetaclass == null){
									metaClassName = "";
								}
								correspondingGenmodel = getGenmodelFromPackage(selectedMetamodel);
							} else {
								correspondingGenmodel = null;
								packageName = "";
								metaClassName = "";
							}
						} else if(firstElement instanceof IFolder){
							IFolder folder = (IFolder) firstElement;
							EPackage ePackage = getEPackageByName(folder.getName());
							IContainer parent = folder.getParent();
							IFile ecoreFile = packageMap.get(ePackage);
							if(parent != null && ecoreFile != null && parent.findMember(ecoreFile.getFullPath().lastSegment(), false) != null && ePackage != null){
								selectedMetamodel = ePackage;
								correspondingGenmodel = getGenmodelFromPackage(selectedMetamodel);
								packageName = ePackage.getName();
							} 
						}
					}
				}
			}
		}
	}

	private GenModel getGenmodelFromPackage(EPackage epackage) {
		Set<GenModel> genmodels = genmodelMap.keySet();
		for (GenModel genModel : genmodels) {
			GenPackage genPackage = genModel.findGenPackage(epackage);
			if(genPackage != null){
				return genModel;
			}
		}
		return null;
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */
	private void initializeUI() {
		if(packageMap == null || packageMap.size() == 0){
			updateStatus("No metamodels found in this project");
			packageButton.setEnabled(false);
			metaclassButton.setEnabled(false);
		} else if(genmodelMap == null || genmodelMap.size() == 0){
			updateStatus("No genmodel was found");
			packageButton.setEnabled(false);
			metaclassButton.setEnabled(false);
		} else {
			packageText.setText(getContainerName());
			Image img = labelProvider.getImage(getSelectedMetamodel());
			if(img != null){
				packageText.setImage(img);
			}
			img = labelProvider.getImage(getSelectedMetaclass());
			if(img != null){
				metaclassText.setImage(img);
			}
			metaclassText.setText(getMetaClassName());
		}
	}

	/**
	 * @returns the selected EObject
	 */
	private <T extends ENamedElement> T handleBrowse(Collection<? extends EObject> elements, String message, Class<T> clazz) {
		if(elements == null || elements.size() == 0 || message == null || clazz == null){
			return null;
		}
		FilteredEObjectsSelectionDialog dialog = new FilteredEObjectsSelectionDialog(getShell(), elements, message);
		if (dialog.open() == org.eclipse.ui.dialogs.ContainerSelectionDialog.OK) {
			EObject selectedObject = dialog.getSelectedObject();
			if(clazz.isInstance(selectedObject)){
				return clazz.cast(selectedObject);
			}
		}
		return null;
	}

	private EPackage getEPackageByName(String name){
		if(packageMap == null){
			return null;
		}
		Set<EPackage> set = packageMap.keySet();
		Iterator<EPackage> iterator = set.iterator();
		while (iterator.hasNext()) {
			EPackage ePackage = (EPackage) iterator.next();
			if(ePackage.getName().equals(name)){
				return ePackage;
			}
		}
		return null;
	}

	private IContainer getContainerForEPackage(EPackage epackage){
		IFile ecoreFile = packageMap.get(epackage);
		if(ecoreFile == null){
			return null;
		}
		IContainer parent = ecoreFile.getParent();
		IFolder packageFolder = parent.getFolder(new Path(epackage.getName()));
		return packageFolder;
	}

	/**
	 * Ensures that both text fields are set.
	 */
	private void dialogChanged() {
		EPackage ePackage = getEPackageByName(packageName);
		if(ePackage != null){
			container = getContainerForEPackage(ePackage);
		}
		if(selectedMetaclass != null){
			EPackage currentPackage = selectedMetaclass.getEPackage();
			EPackage eSuperPackage = currentPackage.getESuperPackage();
			String packagePath = "";
			while (eSuperPackage != null) {
				packagePath += currentPackage.getName() + "/";
				currentPackage = eSuperPackage;
				eSuperPackage = eSuperPackage.getESuperPackage();
			}
			ejavaFile = container.getFile(new Path(packagePath + selectedMetaclass.getName() + "." + fileExtension));
		}

		if (getContainerName().length() == 0) {
			updateStatus("Package must be specified");
			return;
		}
		if(container == null){
			updateStatus("Package '" + getContainerName() + "' does not exist");
			return;
		}
		if(container.exists() && !container.isAccessible()){
			updateStatus("Folder '" + getContainerName() + "' must be writable");
			return;
		}

		if (getMetaClassName().length() == 0) {
			updateStatus("Metaclass must be specified");
			return;
		}
		if(selectedMetamodel != null && correspondingGenmodel == null){
			updateStatus("No genmodel for metamodel '" + selectedMetamodel.getName() + "' could be found");
			return;
		}
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return packageName;
	}

	private String getMetaClassName() {
		return metaClassName;
	}

	public IContainer getEJavaFileContainer() {
		return container;
	}

	public IFile getEJavaFile() {
		return ejavaFile;
	}

	public EPackage getSelectedMetamodel() {
		return selectedMetamodel;
	}

	public EClass getSelectedMetaclass() {
		return selectedMetaclass;
	}

	public GenModel getGenmodel() {
		return correspondingGenmodel;
	}
}
