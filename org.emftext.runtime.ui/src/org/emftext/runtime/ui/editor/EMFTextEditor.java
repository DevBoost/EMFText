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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextScanner;
import org.emftext.runtime.resource.ITextToken;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextEditorConfiguration;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.IBackgroundParsingListener;
import org.emftext.runtime.ui.IBackgroundParsingStrategy;
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.runtime.ui.editor.bg_parsing.DelayedBackgroundParsingStrategy;
import org.emftext.runtime.ui.extensions.CodeFoldingManager;
import org.emftext.runtime.ui.extensions.Highlighting;
import org.emftext.runtime.ui.outline.EMFTextOutlinePage;
import org.emftext.runtime.ui.outline.EMFTextPropertySheetPage;

/**
 * A text editor for models for which text resources were generated by EMFText.
 */
public class EMFTextEditor extends TextEditor implements IEditingDomainProvider {

	private Highlighting highlighting;
	private ProjectionSupport projectionSupport;
	private CodeFoldingManager codeFoldingManager;
	private IBackgroundParsingStrategy bgParsingStrategy = new DelayedBackgroundParsingStrategy();
	private Collection<IBackgroundParsingListener> bgParsingListeners = new ArrayList<IBackgroundParsingListener>();
	private ColorManager colorManager = new ColorManager();
	private EMFTextOutlinePage emfTextEditorOutlinePage;
	private ITextResource resource;
	private MarkerAdapter markerAdapter = new MarkerAdapter();
	private IResourceChangeListener resourceChangeListener = new ModelResourceChangeListener();
	private EMFTextPropertySheetPage propertySheetPage;
	private EditingDomain editingDomain;
	private ComposedAdapterFactory adapterFactory;

	private final class MarkerUpdateListener implements
			IBackgroundParsingListener {
		public void parsingCompleted(Resource resource) {
			try {
				MarkerHelper.unmark(resource);
				MarkerHelper.mark(resource);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * A custom document listener that triggers background parsing if needed.
	 */
	private final class DocumentListener implements IDocumentListener {

		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		public void documentChanged(DocumentEvent event) {
			bgParsingStrategy.parse(event, resource, EMFTextEditor.this);
		}
	}

	/**
	 * The MarkerAdapter is attached to all resources opened in EMFText editors.
	 * When changes are applied to the resource all existing (potentially
	 * invalid) markers are removed and replaced by new ones. Further the
	 * adapter can be disabled to avoid unnecessary marking when a set of
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
			Object notifier = notification.getNotifier();
			if (notifier != null && notifier instanceof ITextResource) {
				ITextResource resource = (ITextResource) notifier;
				if (!resource.isLoaded()) {
					return;
				}
				try {
					MarkerHelper.unmark(resource);
					MarkerHelper.mark(resource);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}

	/**
	 * Reacts to changes of the text resource displayed in the editor and
	 * resources cross-referenced by it. Cross-referenced resources are
	 * unloaded, the displayed resource is reloaded. An attempt to resolve all
	 * proxies in the displayed resource is made after each change.
	 * <p>
	 * The code pretty much corresponds to what EMF generates for a tree editor
	 */
	private final class ModelResourceChangeListener implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					protected ResourceSet resourceSet = editingDomain.getResourceSet();

					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() != IResource.FILE) {
							return true;
						}
						int deltaKind = delta.getKind();
						if (deltaKind == IResourceDelta.REMOVED || deltaKind == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
							Resource changedResource = resourceSet.getResource(URI.createURI(delta.getFullPath().toString()), false);
							if (changedResource != null) {
								markerAdapter.setEnabled(false);
								changedResource.unload();
								if (changedResource.equals(resource)) {
									// reload the resource displayed in the editor
									resourceSet.getResource(resource.getURI(), true);
								}
								EcoreUtil.resolveAll(resource);
								markerAdapter.setEnabled(true);
								// reset the selected element in outline and
								// properties by text position
								highlighting.setEObjectSelection();
							}
						}

						return true;
					}
				}

				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);
			} catch (CoreException exception) {
				EMFTextRuntimePlugin.logError("Unexpected Error: ", exception);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			return getOutlinePage();
		} else if (required.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		return super.getAdapter(required);
	}

	public EMFTextEditor() {
		super();
		setDocumentProvider(new FileDocumentProvider());
		setSourceViewerConfiguration(new EMFTextEditorConfiguration(this, colorManager));
		initializeEditingDomain();
		addBackgroundParsingListener(new MarkerUpdateListener());
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		// Code Folding
		ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
		// Occurrence initiation, need ITextResource and ISourceViewer.
		highlighting = new Highlighting(resource, viewer, colorManager, this);

		projectionSupport = new ProjectionSupport(viewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.install();

		// turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);
		codeFoldingManager = new CodeFoldingManager(viewer, this);
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
		ResourceSet resourceSet = editingDomain.getResourceSet();
		resource = (ITextResource) resourceSet.getResource(uri, false);
		if (resource == null) {
			try {
				Resource loadedResource = resourceSet.getResource(uri, true);
				if (loadedResource instanceof ITextResource) {
					setResource(loadedResource);
				} else {
					// the resource was not loaded by an EMFText resource, but
					// some other EMF resource
					EMFTextRuntimeUIPlugin.getDefault().showErrorDialog("No EMFText resource.", "Sorry, no registered EMFText resource can handle this file type.");
				}
			} catch (Exception e) {
				EMFTextRuntimePlugin.logError(
						"Exception while loading resource in "
								+ EMFTextEditor.class.getSimpleName() + ".", e);
			}
		}
	}

	protected void setResource(Resource loadedResource) throws CoreException {
		resource = (ITextResource) loadedResource;
		EcoreUtil.resolveAll(resource);
		MarkerHelper.unmark(resource);
		MarkerHelper.mark(resource);
		resource.eAdapters().add(markerAdapter);
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	@Override
	protected void performSave(boolean overwrite, IProgressMonitor progressMonitor) {

		super.performSave(overwrite, progressMonitor);
		// update markers after the resource has been reloaded
		try {
			MarkerHelper.unmark(resource);
			MarkerHelper.mark(resource);
		} catch (CoreException e) {
			EMFTextRuntimePlugin.logError("Exception while updating markers on resource", e);
		}
		
		// Save code folding state
		codeFoldingManager.saveCodeFoldingStateFile(resource.getURI().toString());
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
		highlighting.resetValues();
	}

	public void setFocus() {
		super.setFocus();
		this.invalidateTextRepresentation();
	}

	@Override
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		FileEditorInput input = (FileEditorInput) getEditorInput();
		String path = input.getFile().getFullPath().toString();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		URI platformURI = URI.createPlatformResourceURI(path, true);
		Resource oldFile = resourceSet.getResource(platformURI, true);

		super.performSaveAs(progressMonitor);

		// load and resave
		input = (FileEditorInput) getEditorInput();
		path = input.getFile().getFullPath().toString();
		Resource newFile = resourceSet.createResource(platformURI);
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
		// Save code folding state, is it possible with a new name
		codeFoldingManager.saveCodeFoldingStateFile(resource.getURI().toString());
	}

	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
	}

	public ITextResource getResource() {
		return resource;
	}

	protected void setResource(ITextResource resource) {
		this.resource = resource;
	}

	private Object getOutlinePage() {
		if (emfTextEditorOutlinePage == null) {
			emfTextEditorOutlinePage = new EMFTextOutlinePage(this);
			emfTextEditorOutlinePage.addSelectionChangedListener(highlighting);
			highlighting.addSelectionChangedListener(emfTextEditorOutlinePage);
		}
		return emfTextEditorOutlinePage;
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new EMFTextPropertySheetPage();
			// add a slightly modified adapter factory that does not return any
			// editors for properties
			// this way, a model can never be modified through the properties
			// view
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory) {
				protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
					return new PropertySource(object, itemPropertySource) {
						protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
							return new PropertyDescriptor(object, itemPropertyDescriptor) {
								public CellEditor createPropertyEditor(Composite composite) {
									return null;
								}
							};
						}
					};
				}
			});
			highlighting.addSelectionChangedListener(propertySheetPage);
		}
		return propertySheetPage;
	}

	@Override
	protected void createActions() {
		super.createActions();

		ResourceBundle aResourceBundle = ResourceBundle.getBundle("org.emftext.runtime.ui.EMFTextEditorMessages");
		String actionId = "ConAssActionId";

		IAction action = new ContentAssistAction(aResourceBundle, "ContentAssistProposal.", this);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction(actionId, action);
		markAsStateDependentAction(actionId, true);
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

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,commandStack, new HashMap<Resource, Boolean>());
	}

	/**
	 * Set the caret to the offset of the given element.
	 * 
	 * @param element
	 *            has to be contained in the ITextResource of this editor.
	 */
	public void setCaret(EObject element, String text) {
		try {
			if (element == null || text == null || text.equals("")) {
				return;
			}
			ISourceViewer viewer = getSourceViewer();
			ITextResource textResource = (ITextResource) element.eResource();
			ILocationMap locationMap = textResource.getLocationMap();
			int destination = locationMap.getCharStart(element);
			int length = locationMap.getCharEnd(element) + 1 - destination;

			ITextScanner lexer = resource.getMetaInformation().createLexer();
			try {
				lexer.setText(viewer.getDocument().get(destination, length));
				ITextToken token = lexer.getNextToken();
				String tokenText = token.getText();
				while (tokenText != null) {
					if (token.getText().equals(text)) {
						destination += token.getOffset();
						break;
					}
					token = lexer.getNextToken();
					tokenText = token.getText();
				}
			} catch (BadLocationException e) {
			}
			destination = ((ProjectionViewer) viewer).modelOffset2WidgetOffset(destination);
			if (destination < 0) {
				destination = 0;
			}
			viewer.getTextWidget().setSelection(destination);
		} catch (Exception e) {
			EMFTextRuntimePlugin.logError("Exception in setCaret()", e);
		}
	}

	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);

		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}

	public void addBackgroundParsingListener(IBackgroundParsingListener listener) {
		bgParsingListeners.add(listener);
	}

	public void notifyBackgroundParsingFinished() {
		for (IBackgroundParsingListener listener : bgParsingListeners) {
			listener.parsingCompleted(resource);
		}
	}
}
