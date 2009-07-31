/*******************************************************************************
 * Copyright (c) 2006-2009
 * Software Technology Group, Dresden University of Technology
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextEditorConfiguration;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.runtime.ui.editor.bg_parsing.IBackgroundParsingListener;
import org.emftext.runtime.ui.editor.bg_parsing.IBackgroundParsingStrategy;
import org.emftext.runtime.ui.editor.bg_parsing.NoBackgroundParsingListener;
import org.emftext.runtime.ui.editor.bg_parsing.NoBackgroundParsingStrategy;
import org.emftext.runtime.ui.extensions.CodeFoldingManager;
import org.emftext.runtime.ui.extensions.Highlighting;
import org.emftext.runtime.ui.outline.EMFTextOutlinePage;

/**
 * A text editor for models for which text resources were generated by EMFText.
 *
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class EMFTextEditor extends TextEditor implements IEditingDomainProvider {

	private Highlighting highlighting;

	private ProjectionSupport projectionSupport;
	private ProjectionAnnotationModel annotationModel;
	private CodeFoldingManager codeFoldingManager;

	private IBackgroundParsingStrategy bgParsingStrategy = new NoBackgroundParsingStrategy();
	private IBackgroundParsingListener bgParsingListener = new NoBackgroundParsingListener();

	/**
	 * A custom document listener that triggers background parsing if
	 * needed.
	 */
	private final class DocumentListener implements IDocumentListener {

		public void documentAboutToBeChanged(DocumentEvent event) {}

		public void documentChanged(DocumentEvent event) {
			if (!bgParsingStrategy.isParsingRequired(event)) {
				return;
			}
			parseNewContents(event);
			bgParsingListener.parsingCompleted(resourceCopy);
		}

		private void parseNewContents(DocumentEvent event) {
			String contents = event.getDocument().get();
			try {
				resourceCopy.unload();
				resourceCopy.load(new ByteArrayInputStream(contents.getBytes()), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * The MarkerAdapter is attached to all resources opened in
	 * EMFText editors. When changes are applied to the resource
	 * all existing (potentially invalid) markers are removed
	 * and replaced by new ones. Further the adapter can be
	 * disabled to avoid unnecessary marking when a set of
	 * changes is applied.
	 */
	private final class MarkerAdapter extends AdapterImpl {
		private boolean enabled = true;

		public boolean isAdapterForType(Object type) {
			return type == EMFTextEditor.class;
		}

		public void notifyChanged(Notification notification) {
			if (!enabled) {
				return;
			}
			try {
				MarkerHelper.unmark((Resource)getTarget());
				MarkerHelper.mark((Resource)getTarget());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}

	private ColorManager colorManager;

	private EMFTextOutlinePage emfTextEditorOutlinePage;

	private ITextResource resource;

	private ITextResource resourceCopy;

	private MarkerAdapter markerAdapter = new MarkerAdapter();

	private PropertySheetPage propertySheetPage;

	private EditingDomain editingDomain;

	private ComposedAdapterFactory adapterFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			if (emfTextEditorOutlinePage == null) {
				emfTextEditorOutlinePage = new EMFTextOutlinePage(this);
				emfTextEditorOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
							// This ensures that we handle selections correctly.
							public void selectionChanged(SelectionChangedEvent event) {
								handleContentOutlineSelection(event.getSelection());
							}
						});
			}
			return emfTextEditorOutlinePage;
		} else if (required.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		return super.getAdapter(required);
	}


	public EMFTextEditor() {
		super();
		colorManager = new ColorManager();
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
        setDocumentProvider(new FileDocumentProvider());
		setSourceViewerConfiguration(new EMFTextEditorConfiguration(this,colorManager));
		initializeEditingDomain();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}
	
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		// Code Folding
		ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
		// Occurrence initiation, need ITextResource and ISourceViewer.
		highlighting = new Highlighting(resource, viewer, colorManager);
		projectionSupport = new ProjectionSupport(viewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.install();

		// turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);
		annotationModel = viewer.getProjectionAnnotationModel();
		codeFoldingManager=new CodeFoldingManager(annotationModel,viewer);
	}
	
	@Override
	protected void doSetInput(IEditorInput editorInput) throws CoreException {
		super.doSetInput(editorInput);

		initializeResourceObject(editorInput);

		IDocument document = getDocumentProvider().getDocument(getEditorInput());
		document.addDocumentListener(new DocumentListener());
	}

	private void initializeResourceObject(IEditorInput editorInput) {
		FileEditorInput input = (FileEditorInput) editorInput;
		String path = input.getFile().getFullPath().toString();
		URI uri = URI.createPlatformResourceURI(path, true);
		resource = (ITextResource) editingDomain.getResourceSet().getResource(uri, false);
		if (resource == null) {
			try {
				Resource loadedResource = editingDomain.getResourceSet().getResource(uri, true);
				if (loadedResource instanceof ITextResource) {
					resource = (ITextResource) loadedResource;
					EcoreUtil.resolveAll(resource);
					Resource newResource = new ResourceSetImpl().createResource(uri);
					if (newResource instanceof ITextResource) {
						resourceCopy = (ITextResource) newResource;
					}
					MarkerHelper.unmark(resource);
					MarkerHelper.mark(resource);
					resource.eAdapters().add(markerAdapter);
				} else {
					// the resource was not loaded by an EMFText resource, but some other EMF resource
					EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("No EMFText resource.", "Sorry, no registered EMFText resource can handle this file type.");
				}
			} catch (Exception e) {
				EMFTextRuntimePlugin.logError("Exception while loading resource in " + EMFTextEditor.class.getSimpleName() + ".", e);
			}
		}
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	public void handleContentOutlineSelection(ISelection selection) {
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection)
					.getFirstElement();
			if (selectedElement instanceof EObject) {
				EObject selectedEObject = (EObject) selectedElement;
				Resource resource = selectedEObject.eResource();
				if (resource instanceof ITextResource) {
					ITextResource textResource = (ITextResource) resource;
					ILocationMap locationMap = textResource.getLocationMap();
					int elementCharStart = locationMap.getCharStart(selectedEObject);
					int elementCharEnd = locationMap.getCharEnd(selectedEObject);
//					selectAndReveal(elementCharStart, elementCharEnd - elementCharStart + 1);
//					this.getSelectionProvider().setSelection(selection);
					TextSelection textEditorSelection = new TextSelection(elementCharStart,
							elementCharEnd - elementCharStart + 1);
					this.getSelectionProvider().setSelection(textEditorSelection);
				}
			}
		}
	}
	
	@Override
	protected void performSave(boolean overwrite, IProgressMonitor progressMonitor) {

		super.performSave(overwrite, progressMonitor);
		FileEditorInput input = (FileEditorInput) getEditorInput();
		String path = input.getFile().getFullPath().toString();
		ITextResource thisFile = (ITextResource) editingDomain.getResourceSet().getResource(URI.createPlatformResourceURI(path, true), true);
		thisFile.unload();
		try {
			markerAdapter.setEnabled(false);
			thisFile.load(editingDomain.getResourceSet().getLoadOptions());
			EcoreUtil.resolveAll(thisFile);
			markerAdapter.setEnabled(true);

			MarkerHelper.unmark(thisFile);
			MarkerHelper.mark(thisFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//TODO perform update code folding on save to test because of the TextResource bug
		getSourceViewerConfiguration().getReconciler(getSourceViewer()).install(getSourceViewer());
	}

	public void registerTextPresentationListener(ITextPresentationListener listener) {
		ISourceViewer viewer = getSourceViewer();
		if (viewer instanceof TextViewer) {
			((TextViewer) viewer).addTextPresentationListener(listener);
		}
	}

	public void invalidateTextRepresentation() {
		ISourceViewer viewer = getSourceViewer();
		if (viewer != null) {
			viewer.invalidateTextPresentation();
		}
		highlighting.resetBrackets();
		
	}

	public void setFocus() {
		super.setFocus();
		this.invalidateTextRepresentation();
	}

	@Override
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		FileEditorInput input = (FileEditorInput) getEditorInput();
		String path = input.getFile().getFullPath().toString();
		Resource oldFile = editingDomain.getResourceSet().getResource(URI.createPlatformResourceURI(path, true), true);

		super.performSaveAs(progressMonitor);

		//load and resave
		input = (FileEditorInput) getEditorInput();
		path = input.getFile().getFullPath().toString();
		Resource newFile = editingDomain.getResourceSet().createResource(URI.createPlatformResourceURI(path, true));
		newFile.getContents().clear();
		newFile.getContents().addAll(oldFile.getContents());
		try {
			oldFile.unload();
			if (newFile.getErrors().isEmpty()) {
				newFile.save(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
	}

	public void markResource() {
		try {
			MarkerHelper.unmark(resource);
			MarkerHelper.mark(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(ITextResource resource) {
		this.resource = resource;
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new PropertySheetPage() {

				@Override
				public void handleEntrySelection(ISelection selection) {
					super.handleEntrySelection(selection);
					propertySheetPage.getControl().setEnabled(false);
				}

			};

			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		}
		return propertySheetPage;
	}

	@Override
	protected void createActions() {
		super.createActions();

		ResourceBundle aResourceBundle = ResourceBundle
				.getBundle("org.emftext.runtime.ui.EMFTextEditorMessages");
		String actionId = "ConAssActionId";

		IAction action = new ContentAssistAction(aResourceBundle,
				"ContentAssistProposal.", this); //$NON-NLS-1$
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction(actionId, action); //$NON-NLS-1$
		markAsStateDependentAction(actionId, true); //$NON-NLS-1$
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(action, helpContextId);
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	private void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();
		// CommandStackListeners can listen for changes. Not sure whether this
		// is needed.

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}

	/**
	 * The code pretty much corresponds to what EMF generates for a tree editor
	 */
	protected IResourceChangeListener resourceChangeListener =
		new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				try {
					class ResourceDeltaVisitor implements IResourceDeltaVisitor {
						protected ResourceSet resourceSet = editingDomain.getResourceSet();

						public boolean visit(IResourceDelta delta) {
							if (delta.getResource().getType() == IResource.FILE) {
								if (delta.getKind() == IResourceDelta.REMOVED ||
								    delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
									//is this a resource we did load with our resource set?
									Resource otherResource = resourceSet.getResource(URI.createURI(delta.getFullPath().toString()), false);
									if (otherResource != null && !otherResource.equals(resource)) {
										otherResource.unload();
									}
								}
							}

							return true;
						}
					}

					ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
					delta.accept(visitor);
				}
				catch (CoreException exception) {
					EMFTextRuntimePlugin.logError("Unexpected Error: ", exception);
				}
			}
		};

	/**
	 * Set the caret to the offset of the given element.
	 * @param element has to be contained in the ITextResource of this editor.
	 */
	public void setCaret(EObject element) {
		if (element == null) {
			return;
		}
		ISourceViewer viewer= getSourceViewer();
		ILocationMap locationMap = ((ITextResource) element.eResource()).getLocationMap();
		viewer.getTextWidget().setSelection(locationMap.getCharStart(element));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.jface.text.source.IVerticalRuler, int)
	 */
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);

		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}

	public void updateFoldingStructure(List<Position> positions) {
		codeFoldingManager.updateCodefolding(positions);
	}
}
