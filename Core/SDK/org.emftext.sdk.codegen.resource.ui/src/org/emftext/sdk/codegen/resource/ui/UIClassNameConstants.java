/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;

import javax.swing.event.DocumentListener;

import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedNotSetException;
import org.antlr.runtime3_4_0.MismatchedRangeException;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.MismatchedTreeNodeException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filebuffers.IAnnotationModelFactory;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.templates.editor.Editor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IViewerNotification;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider.ViewerRefresh;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractInformationControl;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDelayedInputChangeProvider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension2;
import org.eclipse.jface.text.IInformationControlExtension4;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
import org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector;
import org.eclipse.ui.texteditor.spelling.SpellingProblem;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.wizards.IWizardCategory;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.emftext.sdk.codegen.resource.generators.ClassNameConstants;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import de.devboost.codecomposers.java.JavaComposite;

/**
 * Constants for class names used in the generated code.
 */
@SuppressWarnings("restriction")
public class UIClassNameConstants extends ClassNameConstants {

	public static String ABSTRACT_HANDLER(JavaComposite jc) {
		return jc.getClassName(AbstractHandler.class);
	}

	public static String ABSTRACT_INFORMATION_CONTROL(JavaComposite jc) {
		return jc.getClassName(AbstractInformationControl.class);
	}

	public static String ABSTRACT_LAUNCH_CONFIGURATION_TAB(JavaComposite jc) {
		return jc.getClassName(AbstractLaunchConfigurationTab.class);
	}

	public static String ABSTRACT_LAUNCH_CONFIGURATION_TAB_GROUP(
			JavaComposite jc) {
		return jc.getClassName(AbstractLaunchConfigurationTabGroup.class
				.getName());
	}

	public static String ABSTRACT_MARKER_ANNOTATION_MODEL(JavaComposite jc) {
		return jc.getClassName(AbstractMarkerAnnotationModel.class);
	}

	public static String ABSTRACT_PREFERENCE_INITIALIZER(JavaComposite jc) {
		return jc.getClassName(AbstractPreferenceInitializer.class);
	}

	public static String ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR(
			JavaComposite jc) {
		return jc.getClassName(AbstractReusableInformationControlCreator.class
				.getName());
	}

	public static String ABSTRACT_UI_PLUGIN(JavaComposite jc) {
		return jc.getClassName(AbstractUIPlugin.class);
	}

	public static String ACTION(JavaComposite jc) {
		return jc.getClassName(Action.class);
	}

	public static String ADAPTER(JavaComposite jc) {
		return jc.getClassName(Adapter.class);
	}

	public static String ADAPTER_FACTORY(JavaComposite jc) {
		return jc.getClassName(AdapterFactory.class);
	}

	public static String ADAPTER_FACTORY_CONTENT_PROVIDER(JavaComposite jc) {
		return jc.getClassName(AdapterFactoryContentProvider.class);
	}

	public static String ADAPTER_FACTORY_EDITING_DOMAIN(JavaComposite jc) {
		return jc.getClassName(AdapterFactoryEditingDomain.class);
	}

	public static String ADAPTER_FACTORY_LABEL_PROVIDER(JavaComposite jc) {
		return jc.getClassName(AdapterFactoryLabelProvider.class);
	}

	public static String ADAPTER_IMPL(JavaComposite jc) {
		return jc.getClassName(AdapterImpl.class);
	}

	public static String ANNOTATION(JavaComposite jc) {
		return jc.getClassName(Annotation.class);
	}

	public static String ANTLR_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ANTLRInputStream.class);
	}

	public static String ANTLR_PARSER(JavaComposite jc) {
		return jc.getClassName(org.antlr.runtime3_4_0.Parser.class);
	}

	public static String ANTLR_STRING_STREAM(JavaComposite jc) {
		return jc.getClassName(ANTLRStringStream.class);
	}

	public static String ARRAYS(JavaComposite jc) {
		return jc.getClassName(java.util.Arrays.class);
	}

	public static String ARRAY_LIST(JavaComposite jc) {
		return jc.getClassName(ArrayList.class);
	}

	public static String ASSERT(JavaComposite jc) {
		return jc.getClassName(Assert.class);
	}

	public static String BAD_LOCATION_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(BadLocationException.class);
	}

	public static String BAD_POSITION_CATEGORY_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(BadPositionCategoryException.class);
	}

	public static String BASIC_COMMAND_STACK(JavaComposite jc) {
		return jc.getClassName(BasicCommandStack.class);
	}

	public static String BASIC_E_LIST(JavaComposite jc) {
		return jc.getClassName(BasicEList.class);
	}

	public static String BASIC_E_MAP(JavaComposite jc) {
		return jc.getClassName(BasicEMap.class);
	}

	public static String BASIC_INTERNAL_E_LIST(JavaComposite jc) {
		return jc.getClassName(BasicInternalEList.class);
	}

	public static String BIT_SET(JavaComposite jc) {
		return jc.getClassName(BitSet.class);
	}

	public static String BROWSER(JavaComposite jc) {
		return jc.getClassName(Browser.class);
	}

	public static String BUFFERED_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(BufferedOutputStream.class);
	}

	public static String BUFFERED_READER(JavaComposite jc) {
		return jc.getClassName(BufferedReader.class);
	}

	public static String BUNDLE(JavaComposite jc) {
		return jc.getClassName(Bundle.class);
	}

	public static String BUNDLE_CONTEXT(JavaComposite jc) {
		return jc.getClassName(BundleContext.class);
	}

	public static String BUSY_INDICATOR(JavaComposite jc) {
		return jc.getClassName(BusyIndicator.class);
	}

	public static String BUTTON(JavaComposite jc) {
		return jc.getClassName(Button.class);
	}

	public static String BYTE_ARRAY_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ByteArrayInputStream.class);
	}

	public static String BYTE_ARRAY_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ByteArrayOutputStream.class);
	}

	public static String CELL_EDITOR(JavaComposite jc) {
		return jc.getClassName(CellEditor.class);
	}

	public static String COLLECTION(JavaComposite jc) {
		return jc.getClassName(Collection.class);
	}

	public static String COLLECTIONS(JavaComposite jc) {
		return jc.getClassName(Collections.class);
	}

	public static String COLOR(JavaComposite jc) {
		return jc.getClassName(Color.class);
	}

	public static String COLOR_SELECTOR(JavaComposite jc) {
		return jc.getClassName(ColorSelector.class);
	}

	public static String COMBO(JavaComposite jc) {
		return jc.getClassName(Combo.class);
	}

	public static String COMMON_TOKEN(JavaComposite jc) {
		return jc.getClassName(CommonToken.class);
	}

	public static String COMMON_TOKEN_STREAM(JavaComposite jc) {
		return jc.getClassName(CommonTokenStream.class);
	}

	public static String COMPARABLE(JavaComposite jc) {
		return jc.getClassName(Comparable.class);
	}

	public static String COMPARATOR(JavaComposite jc) {
		return jc.getClassName(Comparator.class);
	}

	public static String COMPLETION_PROPOSAL(JavaComposite jc) {
		return jc.getClassName(CompletionProposal.class);
	}

	public static String COMPOSED_ADAPTER_FACTORY(JavaComposite jc) {
		return jc.getClassName(ComposedAdapterFactory.class);
	}

	public static String COMPOSITE(JavaComposite jc) {
		return jc.getClassName(Composite.class);
	}

	public static String CONSTRAINT_STATUS(JavaComposite jc) {
		return jc.getClassName(ConstraintStatus.class);
	}

	public static String CONTAINER_SELECTION_DIALOG(JavaComposite jc) {
		return jc.getClassName(ContainerSelectionDialog.class);
	}

	public static String CONTENT_ASSISTANT(JavaComposite jc) {
		return jc.getClassName(ContentAssistant.class);
	}

	public static String CONTENT_ASSIST_ACTION(JavaComposite jc) {
		return jc.getClassName(ContentAssistAction.class);
	}

	public static String CONTEXT_INFORMATION(JavaComposite jc) {
		return jc.getClassName(ContextInformation.class);
	}

	public static String CONTROL(JavaComposite jc) {
		return jc.getClassName(Control.class);
	}

	public static String CORE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(CoreException.class);
	}

	public static String DEBUG_PLUGIN(JavaComposite jc) {
		return jc.getClassName(DebugPlugin.class);
	}

	public static String DEBUG_UI_TOOLS(JavaComposite jc) {
		return jc.getClassName(DebugUITools.class);
	}

	public static String DEFAULT_ANNOTATION_HOVER(JavaComposite jc) {
		return jc.getClassName(DefaultAnnotationHover.class);
	}

	public static String DEFAULT_DAMAGER_REPAIRER(JavaComposite jc) {
		return jc.getClassName(DefaultDamagerRepairer.class);
	}

	public static String DEFAULT_INDENT_LINE_AUTO_EDIT_STRATEGY(JavaComposite jc) {
		return jc.getClassName(DefaultIndentLineAutoEditStrategy.class
				.getName());
	}

	public static String DEFAULT_INFORMATION_CONTROL(JavaComposite jc) {
		return jc.getClassName(DefaultInformationControl.class);
	}

	public static String DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.common.util.Diagnostic.class
				.getName());
	}

	public static String DIAGNOSTICIAN(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.ecore.util.Diagnostician.class
				.getName());
	}

	public static String DIALOG(JavaComposite jc) {
		return jc.getClassName(Dialog.class);
	}

	public static String DISPLAY(JavaComposite jc) {
		return jc.getClassName(Display.class);
	}

	public static String DOCUMENT(JavaComposite jc) {
		return jc.getClassName(Document.class);
	}

	public static String DOCUMENT_COMMAND(JavaComposite jc) {
		return jc.getClassName(DocumentCommand.class);
	}

	public static String DOCUMENT_EVENT(JavaComposite jc) {
		return jc.getClassName(DocumentEvent.class);
	}

	public static String DOCUMENT_LISTENER(JavaComposite jc) {
		return jc.getClassName(DocumentListener.class);
	}

	public static String EARLY_EXIT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(EarlyExitException.class);
	}

	public static String ECORE_FACTORY(JavaComposite jc) {
		return jc.getClassName(EcoreFactory.class);
	}

	public static String ECORE_ITEM_PROVIDER_ADAPTER_FACTORY(JavaComposite jc) {
		return jc.getClassName(EcoreItemProviderAdapterFactory.class);
	}

	public static String ECORE_UTIL(JavaComposite jc) {
		return jc.getClassName(EcoreUtil.class);
	}

	public static String EDITING_DOMAIN(JavaComposite jc) {
		return jc.getClassName(EditingDomain.class);
	}

	public static String EDITOR(JavaComposite jc) {
		return jc.getClassName(Editor.class);
	}

	public static String EDITORS_UI(JavaComposite jc) {
		return jc.getClassName(EditorsUI.class);
	}

	public static String ELEMENT_BASED_TEXT_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName("ElementBasedTextDiagnostic");
	}

	public static String ELEMENT_TREE_SELECTION_DIALOG(JavaComposite jc) {
		return jc.getClassName(ElementTreeSelectionDialog.class);
	}

	public static String ENUMERATION(JavaComposite jc) {
		return jc.getClassName(Enumeration.class);
	}

	public static String EVALUATION_MODE(JavaComposite jc) {
		return jc.getClassName(EvaluationMode.class);
	}

	public static String EVENT(JavaComposite jc) {
		return jc.getClassName(Event.class);
	}

	public static String EXECUTION_EVENT(JavaComposite jc) {
		return jc.getClassName(ExecutionEvent.class);
	}

	public static String EXECUTION_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(ExecutionException.class);
	}

	public static String E_ATTRIBUTE(JavaComposite jc) {
		return jc.getClassName(EAttribute.class);
	}

	public static String E_CLASS(JavaComposite jc) {
		return jc.getClassName(EClass.class);
	}

	public static String E_CLASSIFIER(JavaComposite jc) {
		return jc.getClassName(EClassifier.class);
	}

	public static String E_DATA_TYPE(JavaComposite jc) {
		return jc.getClassName(EDataType.class);
	}

	public static String E_ENUM(JavaComposite jc) {
		return jc.getClassName(EEnum.class);
	}

	public static String E_ENUM_LITERAL(JavaComposite jc) {
		return jc.getClassName(EEnumLiteral.class);
	}

	public static String E_LIST(JavaComposite jc) {
		return jc.getClassName(EList.class);
	}

	public static String E_MAP(JavaComposite jc) {
		return jc.getClassName(EMap.class);
	}

	public static String E_OBJECT(JavaComposite jc) {
		return jc.getClassName(EObject.class);
	}

	public static String E_OBJECT_IMPL(JavaComposite jc) {
		return jc.getClassName(EObjectImpl.class);
	}

	public static String E_OPERATION(JavaComposite jc) {
		return jc.getClassName(EOperation.class);
	}

	public static String E_PACKAGE(JavaComposite jc) {
		return jc.getClassName(EPackage.class);
	}

	public static String E_REFERENCE(JavaComposite jc) {
		return jc.getClassName(EReference.class);
	}

	public static String E_STRUCTURAL_FEATURE(JavaComposite jc) {
		return jc.getClassName(EStructuralFeature.class);
	}

	public static String FAILED_PREDICATE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(FailedPredicateException.class);
	}

	public static String FILE(JavaComposite jc) {
		return jc.getClassName(File.class);
	}

	public static String FILE_DIALOG(JavaComposite jc) {
		return jc.getClassName(FileDialog.class);
	}

	public static String FILE_DOCUMENT_PROVIDER(JavaComposite jc) {
		return jc.getClassName(FileDocumentProvider.class);
	}

	public static String FILE_EDITOR_INPUT(JavaComposite jc) {
		return jc.getClassName(FileEditorInput.class);
	}

	public static String FILE_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(FileInputStream.class);
	}

	public static String FILE_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(FileOutputStream.class);
	}

	public static String FONT(JavaComposite jc) {
		return jc.getClassName(Font.class);
	}

	public static String FONT_DATA(JavaComposite jc) {
		return jc.getClassName(FontData.class);
	}

	public static String FONT_METRICS(JavaComposite jc) {
		return jc.getClassName(FontMetrics.class);
	}

	public static String GC(JavaComposite jc) {
		return jc.getClassName(GC.class);
	}

	public static String GEN_CLASS(JavaComposite jc) {
		return jc.getClassName(GenClass.class);
	}

	public static String GEN_FEATURE(JavaComposite jc) {
		return jc.getClassName(GenFeature.class);
	}

	public static String GEN_PACKAGE(JavaComposite jc) {
		return jc.getClassName(GenPackage.class);
	}

	public static String GRID_DATA(JavaComposite jc) {
		return jc.getClassName(GridData.class);
	}

	public static String GRID_LAYOUT(JavaComposite jc) {
		return jc.getClassName(GridLayout.class);
	}

	public static String GROUP(JavaComposite jc) {
		return jc.getClassName(Group.class);
	}

	public static String GROUP_MARKER(JavaComposite jc) {
		return jc.getClassName(GroupMarker.class);
	}

	public static String HANDLER_UTIL(JavaComposite jc) {
		return jc.getClassName(HandlerUtil.class);
	}

	public static String I_ELEMENT_COMPARER(JavaComposite jc) {
		return jc.getClassName(IElementComparer.class);
	}

	public static String IDE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.ui.ide.IDE.class);
	}

	public static String ILLEGAL_ARGUMENT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IllegalArgumentException.class);
	}

	public static String IMAGE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.swt.graphics.Image.class);
	}

	public static String IMAGE_DATA(JavaComposite jc) {
		return jc.getClassName(ImageData.class);
	}

	public static String IMAGE_DESCRIPTOR(JavaComposite jc) {
		return jc.getClassName(ImageDescriptor.class);
	}

	public static String IMAGE_LOADER(JavaComposite jc) {
		return jc.getClassName(ImageLoader.class);
	}

	public static String INCREMENTAL_PROJECT_BUILDER(JavaComposite jc) {
		return jc.getClassName(IncrementalProjectBuilder.class);
	}

	public static String INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(InputStream.class);
	}

	public static String INPUT_STREAM_READER(JavaComposite jc) {
		return jc.getClassName(InputStreamReader.class);
	}

	public static String INTEGER(JavaComposite jc) {
		return jc.getClassName(Integer.class);
	}

	public static String INTERNAL_E_LIST(JavaComposite jc) {
		return jc.getClassName(InternalEList.class);
	}

	public static String INTERNAL_E_OBJECT(JavaComposite jc) {
		return jc.getClassName(InternalEObject.class);
	}

	public static String INT_STREAM(JavaComposite jc) {
		return jc.getClassName(IntStream.class);
	}

	public static String INVOCATION_HANDLER(JavaComposite jc) {
		return jc.getClassName(InvocationHandler.class);
	}

	public static String INVOCATION_TARGET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(InvocationTargetException.class);
	}

	public static String IO_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IOException.class);
	}

	public static String ITERATOR(JavaComposite jc) {
		return jc.getClassName(Iterator.class);
	}

	public static String I_ACTION(JavaComposite jc) {
		return jc.getClassName(IAction.class);
	}

	public static String I_ACTION_BARS(JavaComposite jc) {
		return jc.getClassName(IActionBars.class);
	}

	public static String I_ADAPTABLE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.core.runtime.IAdaptable.class
				.getName());
	}

	public static String I_ANNOTATION_ACCESS_EXTENSION(JavaComposite jc) {
		return jc.getClassName(IAnnotationAccessExtension.class);
	}

	public static String I_ANNOTATION_HOVER(JavaComposite jc) {
		return jc.getClassName(IAnnotationHover.class);
	}

	public static String I_ANNOTATION_MODEL(JavaComposite jc) {
		return jc.getClassName(IAnnotationModel.class);
	}

	public static String I_ANNOTATION_MODEL_FACTORY(JavaComposite jc) {
		return jc.getClassName(IAnnotationModelFactory.class);
	}

	public static String I_AUTO_EDIT_STRATEGY(JavaComposite jc) {
		return jc.getClassName(IAutoEditStrategy.class);
	}

	public static String I_BATCH_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(IBatchValidator.class);
	}

	public static String I_CHILDREN_COUNT_UPDATE(JavaComposite jc) {
		return jc.getClassName(IChildrenCountUpdate.class);
	}

	public static String I_CHILDREN_UPDATE(JavaComposite jc) {
		return jc.getClassName(IChildrenUpdate.class);
	}

	public static String I_COMMAND(JavaComposite jc) {
		return jc.getClassName(ICommand.class);
	}

	public static String I_COMPLETION_PROPOSAL(JavaComposite jc) {
		return jc.getClassName(ICompletionProposal.class);
	}

	public static String I_CONFIGURATION_ELEMENT(JavaComposite jc) {
		return jc.getClassName(IConfigurationElement.class);
	}

	public static String I_CONTAINER(JavaComposite jc) {
		return jc.getClassName(IContainer.class);
	}

	public static String I_CONTENT_ASSISTANT(JavaComposite jc) {
		return jc.getClassName(IContentAssistant.class);
	}

	public static String I_CONTENT_ASSIST_PROCESSOR(JavaComposite jc) {
		return jc.getClassName(IContentAssistProcessor.class);
	}

	public static String I_CONTENT_OUTLINE_PAGE(JavaComposite jc) {
		return jc.getClassName(IContentOutlinePage.class);
	}

	public static String I_CONTEXT_INFORMATION(JavaComposite jc) {
		return jc.getClassName(IContextInformation.class);
	}

	public static String I_CONTEXT_INFORMATION_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(IContextInformationValidator.class);
	}

	public static String I_CONTEXT_SERVICE(JavaComposite jc) {
		return jc.getClassName(IContextService.class);
	}

	public static String I_DEBUG_MODEL_PRESENTATION(JavaComposite jc) {
		return jc.getClassName(IDebugModelPresentation.class);
	}

	public static String I_DELAYED_INPUT_CHANGE_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IDelayedInputChangeProvider.class);
	}

	public static String I_DIALOG_CONSTANTS(JavaComposite jc) {
		return jc.getClassName(IDialogConstants.class);
	}

	public static String I_DOCUMENT(JavaComposite jc) {
		return jc.getClassName(IDocument.class);
	}

	public static String I_DOCUMENT_EXTENSION_3(JavaComposite jc) {
		return jc.getClassName(IDocumentExtension3.class);
	}

	public static String I_DOCUMENT_LISTENER(JavaComposite jc) {
		return jc.getClassName(IDocumentListener.class);
	}

	public static String I_EDITING_DOMAIN_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IEditingDomainProvider.class);
	}

	public static String I_EDITOR_DESCRIPTOR(JavaComposite jc) {
		return jc.getClassName(IEditorDescriptor.class);
	}

	public static String I_EDITOR_INPUT(JavaComposite jc) {
		return jc.getClassName(IEditorInput.class);
	}

	public static String I_EDITOR_PART(JavaComposite jc) {
		return jc.getClassName(IEditorPart.class);
	}

	public static String I_ELEMENT_CONTENT_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IElementContentProvider.class);
	}

	public static String I_ELEMENT_LABEL_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IElementLabelProvider.class);
	}

	public static String I_EXTENSION_REGISTRY(JavaComposite jc) {
		return jc.getClassName(IExtensionRegistry.class);
	}

	public static String I_FILE(JavaComposite jc) {
		return jc.getClassName(IFile.class);
	}

	public static String I_FILE_EDITOR_INPUT(JavaComposite jc) {
		return jc.getClassName(IFileEditorInput.class);
	}

	public static String I_HAS_CHILDREN_UPDATE(JavaComposite jc) {
		return jc.getClassName(IHasChildrenUpdate.class);
	}

	public static String I_HYPERLINK(JavaComposite jc) {
		return jc.getClassName(IHyperlink.class);
	}

	public static String I_HYPERLINK_DETECTOR(JavaComposite jc) {
		return jc.getClassName(IHyperlinkDetector.class);
	}

	public static String I_INFORMATION_CONTROL(JavaComposite jc) {
		return jc.getClassName(IInformationControl.class);
	}

	public static String I_INFORMATION_CONTROL_CREATOR(JavaComposite jc) {
		return jc.getClassName(IInformationControlCreator.class);
	}

	public static String I_INFORMATION_CONTROL_EXTENSION2(JavaComposite jc) {
		return jc.getClassName(IInformationControlExtension2.class);
	}

	public static String I_INFORMATION_CONTROL_EXTENSION4(JavaComposite jc) {
		return jc.getClassName(IInformationControlExtension4.class);
	}

	public static String I_INFORMATION_PRESENTER(JavaComposite jc) {
		return jc
				.getClassName(org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter.class
						);
	}

	public static String I_INPUT_CHANGED_LISTENER(JavaComposite jc) {
		return jc.getClassName(IInputChangedListener.class);
	}

	public static String I_ITEM_LABEL_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IItemLabelProvider.class);
	}

	public static String I_ITEM_PROPERTY_DESCRIPTOR(JavaComposite jc) {
		return jc.getClassName(IItemPropertyDescriptor.class);
	}

	public static String I_ITEM_PROPERTY_SOURCE(JavaComposite jc) {
		return jc.getClassName(IItemPropertySource.class);
	}

	public static String I_LABEL_PROVIDER_LISTENER(JavaComposite jc) {
		return jc.getClassName(ILabelProviderListener.class);
	}

	public static String I_LABEL_UPDATE(JavaComposite jc) {
		return jc.getClassName(ILabelUpdate.class);
	}

	public static String I_LAUNCH(JavaComposite jc) {
		return jc.getClassName(ILaunch.class);
	}

	public static String I_LAUNCH_CONFIGURATION(JavaComposite jc) {
		return jc.getClassName(ILaunchConfiguration.class);
	}

	public static String I_LAUNCH_CONFIGURATION_DIALOG(JavaComposite jc) {
		return jc.getClassName(ILaunchConfigurationDialog.class);
	}

	public static String I_LAUNCH_CONFIGURATION_TAB(JavaComposite jc) {
		return jc.getClassName(ILaunchConfigurationTab.class);
	}

	public static String I_LAUNCH_CONFIGURATION_TYPE(JavaComposite jc) {
		return jc.getClassName(ILaunchConfigurationType.class);
	}

	public static String I_LAUNCH_CONFIGURATION_WORKING_COPY(JavaComposite jc) {
		return jc.getClassName(ILaunchConfigurationWorkingCopy.class);
	}

	public static String I_LAUNCH_SHORTCUT2(JavaComposite jc) {
		return jc.getClassName(ILaunchShortcut2.class);
	}

	public static String I_LINE_BREAKPOINT(JavaComposite jc) {
		return jc.getClassName(ILineBreakpoint.class);
	}

	public static String I_MARKER(JavaComposite jc) {
		return jc.getClassName(IMarker.class);
	}

	public static String I_MARKER_RESOLUTION(JavaComposite jc) {
		return jc.getClassName(IMarkerResolution.class);
	}

	public static String I_MARKER_RESOLUTION2(JavaComposite jc) {
		return jc.getClassName(IMarkerResolution2.class);
	}

	public static String I_MARKER_RESOLUTION_GENERATOR(JavaComposite jc) {
		return jc.getClassName(IMarkerResolutionGenerator.class);
	}

	public static String I_MEMENTO(JavaComposite jc) {
		return jc.getClassName(IMemento.class);
	}

	public static String I_MENU_LISTENER(JavaComposite jc) {
		return jc.getClassName(org.eclipse.jface.action.IMenuListener.class
				.getName());
	}

	public static String I_MENU_MANAGER(JavaComposite jc) {
		return jc.getClassName(org.eclipse.jface.action.IMenuManager.class
				.getName());
	}

	public static String I_NEW_WIZARD(JavaComposite jc) {
		return jc.getClassName(INewWizard.class);
	}

	public static String I_PAGE_SITE(JavaComposite jc) {
		return jc.getClassName(IPageSite.class);
	}

	public static String I_PART_LISTENER2(JavaComposite jc) {
		return jc.getClassName(IPartListener2.class);
	}

	public static String I_PATH(JavaComposite jc) {
		return jc.getClassName(IPath.class);
	}

	public static String I_PREFERENCE_STORE(JavaComposite jc) {
		return jc.getClassName(IPreferenceStore.class);
	}

	public static String I_PRESENTATION_RECONCILER(JavaComposite jc) {
		return jc.getClassName(IPresentationReconciler.class);
	}

	public static String I_PROGRESS_MONITOR(JavaComposite jc) {
		return jc.getClassName(IProgressMonitor.class);
	}

	public static String I_PROJECT(JavaComposite jc) {
		return jc.getClassName(IProject.class);
	}

	public static String I_PROJECT_DESCRIPTION(JavaComposite jc) {
		return jc.getClassName(IProjectDescription.class);
	}

	public static String I_PROJECT_NATURE(JavaComposite jc) {
		return jc.getClassName(IProjectNature.class);
	}

	public static String I_PROPERTY_DESCRIPTOR(JavaComposite jc) {
		return jc.getClassName(IPropertyDescriptor.class);
	}

	public static String I_PROPERTY_SHEET_PAGE(JavaComposite jc) {
		return jc.getClassName(IPropertySheetPage.class);
	}

	public static String I_PROPERTY_SOURCE(JavaComposite jc) {
		return jc.getClassName(IPropertySource.class);
	}

	public static String I_QUICK_ASSIST_ASSISTANT(JavaComposite jc) {
		return jc.getClassName(IQuickAssistAssistant.class);
	}

	public static String I_QUICK_ASSIST_INVOCATION_CONTEXT(JavaComposite jc) {
		return jc.getClassName(IQuickAssistInvocationContext.class);
	}

	public static String I_QUICK_ASSIST_PROCESSOR(JavaComposite jc) {
		return jc.getClassName(IQuickAssistProcessor.class);
	}

	public static String I_QUICK_FIXABLE_ANNOTATION(JavaComposite jc) {
		return jc.getClassName(IQuickFixableAnnotation.class);
	}

	public static String I_REGION(JavaComposite jc) {
		return jc.getClassName(IRegion.class);
	}

	public static String I_RESOURCE(JavaComposite jc) {
		return jc.getClassName(IResource.class);
	}

	public static String I_RESOURCE_CHANGE_EVENT(JavaComposite jc) {
		return jc.getClassName(IResourceChangeEvent.class);
	}

	public static String I_RESOURCE_CHANGE_LISTENER(JavaComposite jc) {
		return jc.getClassName(IResourceChangeListener.class);
	}

	public static String I_RESOURCE_DELTA(JavaComposite jc) {
		return jc.getClassName(IResourceDelta.class);
	}

	public static String I_RESOURCE_DELTA_VISITOR(JavaComposite jc) {
		return jc.getClassName(IResourceDeltaVisitor.class);
	}

	public static String I_RUNNABLE_WITH_PROGRESS(JavaComposite jc) {
		return jc.getClassName(IRunnableWithProgress.class);
	}

	public static String I_SELECTION(JavaComposite jc) {
		return jc.getClassName(ISelection.class);
	}

	public static String I_SELECTION_CHANGED_LISTENER(JavaComposite jc) {
		return jc.getClassName(ISelectionChangedListener.class);
	}

	public static String I_SELECTION_PROVIDER(JavaComposite jc) {
		return jc.getClassName(ISelectionProvider.class);
	}

	public static String I_SELECTION_SERVICE(JavaComposite jc) {
		return jc.getClassName(ISelectionService.class);
	}
	
	public static String I_SELECTION_STATUS_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(ISelectionStatusValidator.class);
	}

	public static String I_SHARED_IMAGES(JavaComposite jc) {
		return jc.getClassName(ISharedImages.class);
	}

	public static String I_SOURCE_VIEWER(JavaComposite jc) {
		return jc.getClassName(ISourceViewer.class);
	}

	public static String I_STATUS(JavaComposite jc) {
		return jc.getClassName(IStatus.class);
	}

	public static String I_STORAGE(JavaComposite jc) {
		return jc.getClassName(IStorage.class);
	}

	public static String I_STORAGE_EDITOR_INPUT(JavaComposite jc) {
		return jc.getClassName(IStorageEditorInput.class);
	}

	public static String I_STRUCTURED_SELECTION(JavaComposite jc) {
		return jc.getClassName(IStructuredSelection.class);
	}

	public static String I_TEXT_EDITOR(JavaComposite jc) {
		return jc.getClassName(ITextEditor.class);
	}

	public static String I_TEXT_EDITOR_ACTION_CONSTANTS(JavaComposite jc) {
		return jc.getClassName(ITextEditorActionConstants.class);
	}

	public static String I_TEXT_EDITOR_ACTION_DEFINITION_IDS(JavaComposite jc) {
		return jc.getClassName(ITextEditorActionDefinitionIds.class);
	}

	public static String I_TEXT_HOVER(JavaComposite jc) {
		return jc.getClassName(ITextHover.class);
	}

	public static String I_TEXT_HOVER_EXTENSION(JavaComposite jc) {
		return jc.getClassName(ITextHoverExtension.class);
	}

	public static String I_TEXT_HOVER_EXTENSION2(JavaComposite jc) {
		return jc.getClassName(ITextHoverExtension2.class);
	}

	public static String I_TEXT_OPERATION_TARGET(JavaComposite jc) {
		return jc.getClassName(ITextOperationTarget.class);
	}

	public static String I_TEXT_PRESENTATION_LISTENER(JavaComposite jc) {
		return jc.getClassName(ITextPresentationListener.class);
	}

	public static String I_TEXT_SELECTION(JavaComposite jc) {
		return jc.getClassName(ITextSelection.class);
	}

	public static String I_TEXT_VIEWER(JavaComposite jc) {
		return jc.getClassName(ITextViewer.class);
	}

	public static String I_TEXT_VIEWER_EXTENSION5(JavaComposite jc) {
		return jc.getClassName(ITextViewerExtension5.class);
	}

	public static String I_TOGGLE_BREAKPOINTS_TARGET(JavaComposite jc) {
		return jc.getClassName(IToggleBreakpointsTarget.class);
	}

	public static String I_TOOL_BAR_MANAGER(JavaComposite jc) {
		return jc.getClassName(IToolBarManager.class);
	}

	public static String I_TOKEN(JavaComposite jc) {
		return jc.getClassName(IToken.class);
	}

	public static String I_TOKEN_SCANNER(JavaComposite jc) {
		return jc.getClassName(ITokenScanner.class);
	}

	public static String I_TREE_CONTENT_PROVIDER(JavaComposite jc) {
		return jc.getClassName(ITreeContentProvider.class);
	}

	public static String I_TYPED_REGION(JavaComposite jc) {
		return jc.getClassName(ITypedRegion.class);
	}

	public static String I_VALUE_DETAIL_LISTENER(JavaComposite jc) {
		return jc.getClassName(IValueDetailListener.class);
	}

	public static String I_VERTICAL_RULER(JavaComposite jc) {
		return jc.getClassName(IVerticalRuler.class);
	}

	public static String I_VIEWER_PROVIDER(JavaComposite jc) {
		return jc.getClassName(IViewerProvider.class);
	}

	public static String I_WIZARD(JavaComposite jc) {
		return jc.getClassName(IWizard.class);
	}

	public static String I_WIZARD_CATEGORY(JavaComposite jc) {
		return jc.getClassName(IWizardCategory.class);
	}

	public static String I_WORKBENCH(JavaComposite jc) {
		return jc.getClassName(IWorkbench.class);
	}

	public static String I_WORKBENCH_ACTION_CONSTANTS(JavaComposite jc) {
		return jc.getClassName(IWorkbenchActionConstants.class);
	}

	public static String I_WORKBENCH_PAGE(JavaComposite jc) {
		return jc.getClassName(IWorkbenchPage.class);
	}

	public static String I_WORKBENCH_PART(JavaComposite jc) {
		return jc.getClassName(IWorkbenchPart.class);
	}

	public static String I_WORKBENCH_PART_REFERENCE(JavaComposite jc) {
		return jc.getClassName(IWorkbenchPartReference.class);
	}

	public static String I_WORKBENCH_PREFERENCE_PAGE(JavaComposite jc) {
		return jc.getClassName(IWorkbenchPreferencePage.class);
	}
	
	public static String I_WORKING_SET(JavaComposite jc) {
		return jc.getClassName(IWorkingSet.class);
	}
	
	public static String I_WORKING_SET_MANAGER(JavaComposite jc) {
		return jc.getClassName(IWorkingSetManager.class);
	}

	public static String I_WORKSPACE(JavaComposite jc) {
		return jc.getClassName(IWorkspace.class);
	}

	public static String I_WORKSPACE_ROOT(JavaComposite jc) {
		return jc.getClassName(IWorkspaceRoot.class);
	}

	public static String JFACE_DIALOG(JavaComposite jc) {
		return jc
				.getClassName(org.eclipse.jface.dialogs.Dialog.class);
	}

	public static String JOB(JavaComposite jc) {
		return jc.getClassName(org.eclipse.core.runtime.jobs.Job.class
				.getName());
	}

	public static String J_FACE_RESOURCES(JavaComposite jc) {
		return jc.getClassName(JFaceResources.class);
	}

	public static String J_FACE_TOKEN(JavaComposite jc) {
		return jc.getClassName(org.eclipse.jface.text.rules.Token.class
				.getName());
	}

	public static String KEY_EVENT(JavaComposite jc) {
		return jc.getClassName(KeyEvent.class);
	}

	public static String KEY_LISTENER(JavaComposite jc) {
		return jc.getClassName(KeyListener.class);
	}

	public static String LABEL(JavaComposite jc) {
		return jc.getClassName(Label.class);
	}

	public static String LABEL_PROVIDER(JavaComposite jc) {
		return jc.getClassName(LabelProvider.class);
	}

	public static String LEXER(JavaComposite jc) {
		return jc.getClassName(Lexer.class);
	}

	public static String LINK(JavaComposite jc) {
		return jc.getClassName(Link.class);
	}

	public static String LINKED_HASH_MAP(JavaComposite jc) {
		return jc.getClassName(LinkedHashMap.class);
	}

	public static String LINKED_HASH_SET(JavaComposite jc) {
		return jc.getClassName(LinkedHashSet.class);
	}

	public static String LINKED_LIST(JavaComposite jc) {
		return jc.getClassName(LinkedList.class);
	}

	public static String LIST(JavaComposite jc) {
		return jc.getClassName(List.class);
	}

	public static String LISTENER(JavaComposite jc) {
		return jc.getClassName(Listener.class);
	}

	public static String LISTENER_LIST(JavaComposite jc) {
		return jc.getClassName(ListenerList.class);
	}

	public static String LIST_ITERATOR(JavaComposite jc) {
		return jc.getClassName(ListIterator.class);
	}

	public static String LOCATION_LISTENER(JavaComposite jc) {
		return jc.getClassName(LocationListener.class);
	}

	public static String MANY_INVERSE(JavaComposite jc) {
		return jc
				.getClassName(EObjectWithInverseResolvingEList.ManyInverse.class
						);
	}

	public static String MAP(JavaComposite jc) {
		return jc.getClassName(Map.class);
	}

	public static String MAP_ENTRY(JavaComposite jc) {
		return jc.getClassName(Map.Entry.class);
	}

	public static String MARKER_ANNOTATION(JavaComposite jc) {
		return jc.getClassName(MarkerAnnotation.class);
	}

	public static String MATCHER(JavaComposite jc) {
		return jc.getClassName(Matcher.class);
	}

	public static String MENU(JavaComposite jc) {
		return jc.getClassName(Menu.class);
	}

	public static String MENU_MANAGER(JavaComposite jc) {
		return jc.getClassName(org.eclipse.jface.action.MenuManager.class
				.getName());
	}

	public static String MESSAGE_BOX(JavaComposite jc) {
		return jc.getClassName(MessageBox.class);
	}

	public static String MESSAGE_DIALOG(JavaComposite jc) {
		return jc.getClassName(MessageDialog.class);
	}

	public static String MESSAGE_DIGEST(JavaComposite jc) {
		return jc.getClassName(MessageDigest.class);
	}

	public static String METHOD(JavaComposite jc) {
		return jc.getClassName(java.lang.reflect.Method.class);
	}

	public static String MISMATCHED_NOT_SET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedNotSetException.class);
	}

	public static String MISMATCHED_RANGE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedRangeException.class);
	}

	public static String MISMATCHED_SET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedSetException.class);
	}

	public static String MISMATCHED_TOKEN_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedTokenException.class);
	}

	public static String MISMATCHED_TREE_NODE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedTreeNodeException.class);
	}

	public static String MODEL_VALIDATION_SERVICE(JavaComposite jc) {
		return jc.getClassName(ModelValidationService.class);
	}

	public static String MODIFY_EVENT(JavaComposite jc) {
		return jc.getClassName(ModifyEvent.class);
	}

	public static String MODIFY_LISTENER(JavaComposite jc) {
		return jc.getClassName(ModifyListener.class);
	}

	public static String MOUSE_EVENT(JavaComposite jc) {
		return jc.getClassName(MouseEvent.class);
	}

	public static String MOUSE_LISTENER(JavaComposite jc) {
		return jc.getClassName(MouseListener.class);
	}

	public static String NOTIFICATION(JavaComposite jc) {
		return jc.getClassName(Notification.class);
	}

	public static String NOTIFICATION_CHAIN(JavaComposite jc) {
		return jc.getClassName(NotificationChain.class);
	}

	public static String NOTIFIER(JavaComposite jc) {
		return jc.getClassName(Notifier.class);
	}

	public static String NO_SUCH_ALGORITHM_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoSuchAlgorithmException.class);
	}

	public static String NO_VIABLE_ALT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoViableAltException.class);
	}

	public static String NULL_POINTER_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NullPointerException.class);
	}

	public static String OPEN_WINDOW_LISTENER(JavaComposite jc) {
		return jc.getClassName(OpenWindowListener.class);
	}

	public static String OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(OutputStream.class);
	}

	public static String OUTPUT_STREAM_WRITER(JavaComposite jc) {
		return jc.getClassName(OutputStreamWriter.class);
	}

	public static String PAGE(JavaComposite jc) {
		return jc.getClassName(Page.class);
	}

	public static String PART_INIT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(PartInitException.class);
	}

	public static String PATH(JavaComposite jc) {
		return jc.getClassName(Path.class);
	}

	public static String PATTERN(JavaComposite jc) {
		return jc.getClassName(java.util.regex.Pattern.class);
	}

	public static String PLATFORM(JavaComposite jc) {
		return jc.getClassName(Platform.class);
	}

	public static String PLATFORM_UI(JavaComposite jc) {
		return jc.getClassName(PlatformUI.class);
	}

	public static String POINT(JavaComposite jc) {
		return jc.getClassName(Point.class);
	}

	public static String POSITION(JavaComposite jc) {
		return jc.getClassName(Position.class);
	}

	public static String POSITION_BASED_TEXT_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName("PositionBasedTextDiagnostic");
	}

	public static String PREFERENCE_CONVERTER(JavaComposite jc) {
		return jc.getClassName(PreferenceConverter.class);
	}

	public static String PREFERENCE_PAGE(JavaComposite jc) {
		return jc.getClassName(PreferencePage.class);
	}

	public static String PRESENTATION_RECONCILER(JavaComposite jc) {
		return jc.getClassName(PresentationReconciler.class);
	}

	public static String PRINTER_WRITER(JavaComposite jc) {
		return jc.getClassName(PrintWriter.class);
	}

	public static String PROGRAM(JavaComposite jc) {
		return jc.getClassName(Program.class);
	}

	public static String PROGRESS_ADAPTER(JavaComposite jc) {
		return jc.getClassName(ProgressAdapter.class);
	}

	public static String PROGRESS_EVENT(JavaComposite jc) {
		return jc.getClassName(ProgressEvent.class);
	}

	public static String PROJECTION_ANNOTATION(JavaComposite jc) {
		return jc.getClassName(ProjectionAnnotation.class);
	}

	public static String PROJECTION_ANNOTATION_MODEL(JavaComposite jc) {
		return jc.getClassName(ProjectionAnnotationModel.class);
	}

	public static String PROJECTION_SUPPORT(JavaComposite jc) {
		return jc.getClassName(ProjectionSupport.class);
	}

	public static String PROJECTION_VIEWER(JavaComposite jc) {
		return jc.getClassName(ProjectionViewer.class);
	}

	public static String PROPERTY_DESCRIPTOR(JavaComposite jc) {
		return jc.getClassName(PropertyDescriptor.class);
	}

	public static String PROPERTY_SHEET_PAGE(JavaComposite jc) {
		return jc.getClassName(PropertySheetPage.class);
	}

	public static String PROPERTY_SOURCE(JavaComposite jc) {
		return jc.getClassName(PropertySource.class);
	}

	public static String PROXY(JavaComposite jc) {
		return jc.getClassName(Proxy.class);
	}

	public static String PUSHBACK_READER(JavaComposite jc) {
		return jc.getClassName(PushbackReader.class);
	}

	public static String QUICK_ASSIST_ASSISTANT(JavaComposite jc) {
		return jc.getClassName(QuickAssistAssistant.class);
	}

	public static String READER(JavaComposite jc) {
		return jc.getClassName(Reader.class);
	}

	public static String RECOGNITION_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(RecognitionException.class);
	}

	public static String RECOGNIZER_SHARED_STATE(JavaComposite jc) {
		return jc
				.getClassName(org.antlr.runtime3_4_0.RecognizerSharedState.class
						.getName());
	}

	public static String RECTANGLE(JavaComposite jc) {
		return jc.getClassName(Rectangle.class);
	}

	public static String REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY(
			JavaComposite jc) {
		return jc.getClassName(ReflectiveItemProviderAdapterFactory.class
				.getName());
	}

	public static String REGION(JavaComposite jc) {
		return jc.getClassName(Region.class);
	}

	public static String RESOLVER_SWITCH_FIELD_NAME(JavaComposite jc) {
		return jc.getClassName("resolverSwitch");
	}

	public static String RESOURCE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.ecore.resource.Resource.class
				.getName());
	}

	public static String RESOURCES_PLUGIN(JavaComposite jc) {
		return jc.getClassName(ResourcesPlugin.class);
	}

	public static String RESOURCE_BUNDLE(JavaComposite jc) {
		return jc.getClassName(ResourceBundle.class);
	}

	public static String RESOURCE_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName(Diagnostic.class);
	}

	public static String RESOURCE_FACTORY(JavaComposite jc) {
		return jc.getClassName(Resource.Factory.class);
	}

	public static String RESOURCE_IMPL(JavaComposite jc) {
		return jc.getClassName(ResourceImpl.class);
	}

	public static String RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY(JavaComposite jc) {
		return jc.getClassName(ResourceItemProviderAdapterFactory.class
				.getName());
	}

	public static String RESOURCE_MARKER_ANNOTATION_MODEL(JavaComposite jc) {
		return jc.getClassName(ResourceMarkerAnnotationModel.class);
	}

	public static String RESOURCE_SET(JavaComposite jc) {
		return jc.getClassName(ResourceSet.class);
	}

	public static String RESOURCE_SET_IMPL(JavaComposite jc) {
		return jc.getClassName(ResourceSetImpl.class);
	}

	public static String RGB(JavaComposite jc) {
		return jc.getClassName(RGB.class);
	}

	public static String SAFE_RUNNABLE(JavaComposite jc) {
		return jc.getClassName(SafeRunnable.class);
	}

	public static String SAFE_RUNNER(JavaComposite jc) {
		return jc.getClassName(SafeRunner.class);
	}

	public static String SCROLLABLE(JavaComposite jc) {
		return jc.getClassName(Scrollable.class);
	}

	public static String SCROLL_BAR(JavaComposite jc) {
		return jc.getClassName(ScrollBar.class);
	}

	public static String SELECTION_ADAPTER(JavaComposite jc) {
		return jc.getClassName(SelectionAdapter.class);
	}

	public static String SELECTION_CHANGED_EVENT(JavaComposite jc) {
		return jc.getClassName(SelectionChangedEvent.class);
	}

	public static String SELECTION_EVENT(JavaComposite jc) {
		return jc.getClassName(SelectionEvent.class);
	}

	public static String SELECTION_LISTENER(JavaComposite jc) {
		return jc.getClassName(SelectionListener.class);
	}

	public static String SELECT_MARKER_RULES_ACTION(JavaComposite jc) {
		return jc.getClassName(SelectMarkerRulerAction.class);
	}

	public static String SET(JavaComposite jc) {
		return jc.getClassName(Set.class);
	}

	public static String SHELL(JavaComposite jc) {
		return jc.getClassName(Shell.class);
	}

	public static String SLIDER(JavaComposite jc) {
		return jc.getClassName(Slider.class);
	}

	public static String SOURCE_VIEWER_CONFIGURATION(JavaComposite jc) {
		return jc.getClassName(SourceViewerConfiguration.class);
	}

	public static String STACK(JavaComposite jc) {
		return jc.getClassName(Stack.class);
	}

	public static String STATUS(JavaComposite jc) {
		return jc.getClassName(Status.class);
	}

	public static String STRING_BUILDER(JavaComposite jc) {
		return jc.getClassName(StringBuilder.class);
	}

	public static String STRING_READER(JavaComposite jc) {
		return jc.getClassName(StringReader.class);
	}

	public static String STRING_WRITER(JavaComposite jc) {
		return jc.getClassName(StringWriter.class);
	}

	public static String STRUCTURED_SELECTION(JavaComposite jc) {
		return jc.getClassName(StructuredSelection.class);
	}

	public static String STRUCTURED_VIEWER(JavaComposite jc) {
		return jc.getClassName(StructuredViewer.class);
	}

	public static String STYLED_TEXT(JavaComposite jc) {
		return jc.getClassName(StyledText.class);
	}

	public static String STYLE_RANGE(JavaComposite jc) {
		return jc.getClassName(StyleRange.class);
	}

	public static String SWT(JavaComposite jc) {
		return jc.getClassName(SWT.class);
	}

	public static String SWT_ERROR(JavaComposite jc) {
		return jc.getClassName(SWTError.class);
	}

	public static String SWT_LIST(JavaComposite jc) {
		return jc.getClassName(org.eclipse.swt.widgets.List.class);
	}

	public static String TEXT(JavaComposite jc) {
		return jc.getClassName(org.eclipse.swt.widgets.Text.class);
	}

	public static String TEXT_ATTRIBUTE(JavaComposite jc) {
		return jc.getClassName(TextAttribute.class);
	}

	public static String TEXT_EDITOR(JavaComposite jc) {
		return jc.getClassName(TextEditor.class);
	}

	public static String TEXT_INVOCATION_CONTEXT(JavaComposite jc) {
		return jc.getClassName(TextInvocationContext.class);
	}

	public static String TEXT_LAYOUT(JavaComposite jc) {
		return jc.getClassName(TextLayout.class);
	}

	public static String TEXT_PRESENTATION(JavaComposite jc) {
		return jc.getClassName(TextPresentation.class);
	}

	public static String TEXT_SELECTION(JavaComposite jc) {
		return jc.getClassName(TextSelection.class);
	}

	public static String TEXT_SOURCE_VIEWER_CONFIGURATION(JavaComposite jc) {
		return jc.getClassName(TextSourceViewerConfiguration.class);
	}

	public static String TEXT_STYLE(JavaComposite jc) {
		return jc.getClassName(TextStyle.class);
	}

	public static String TEXT_UTILITIES(JavaComposite jc) {
		return jc.getClassName(TextUtilities.class);
	}

	public static String TEXT_VIEWER(JavaComposite jc) {
		return jc.getClassName(TextViewer.class);
	}

	public static String TIMER(JavaComposite jc) {
		return jc.getClassName(Timer.class);
	}

	public static String TIMER_TASK(JavaComposite jc) {
		return jc.getClassName(TimerTask.class);
	}

	public static String TOOL_BAR_MANAGER(JavaComposite jc) {
		return jc.getClassName(ToolBarManager.class);
	}

	public static String TREE_SELECTION(JavaComposite jc) {
		return jc.getClassName(TreeSelection.class);
	}

	public static String TREE_VIEWER(JavaComposite jc) {
		return jc.getClassName(TreeViewer.class);
	}

	public static String URI(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.common.util.URI.class);
	}

	public static String URI_CONVERTER(JavaComposite jc) {
		return jc.getClassName(URIConverter.class);
	}

	public static String URL(JavaComposite jc) {
		return jc.getClassName(URL.class);
	}

	public static String VERIFY_EVENT(JavaComposite jc) {
		return jc.getClassName(VerifyEvent.class);
	}

	public static String VERIFY_KEY_LISTENER(JavaComposite jc) {
		return jc.getClassName(VerifyKeyListener.class);
	}

	public static String VERIFY_LISTENER(JavaComposite jc) {
		return jc.getClassName(VerifyListener.class);
	}

	public static String VIEWER(JavaComposite jc) {
		return jc.getClassName(Viewer.class);
	}

	public static String VIEWER_COMPARATOR(JavaComposite jc) {
		return jc.getClassName(ViewerComparator.class);
	}

	public static String VIEWER_FILTER(JavaComposite jc) {
		return jc.getClassName(ViewerFilter.class);
	}

	public static String WINDOW(JavaComposite jc) {
		return jc.getClassName(Window.class);
	}

	public static String WINDOW_EVENT(JavaComposite jc) {
		return jc.getClassName(WindowEvent.class);
	}

	public static String WIZARD(JavaComposite jc) {
		return jc.getClassName(Wizard.class);
	}

	public static String WIZARD_PAGE(JavaComposite jc) {
		return jc.getClassName(WizardPage.class);
	}

	public static String WORKBENCH_CONTENT_PROVIDER(JavaComposite jc) {
		return jc.getClassName(WorkbenchContentProvider.class);
	}

	public static String WORKBENCH_LABEL_PROVIDER(JavaComposite jc) {
		return jc.getClassName(WorkbenchLabelProvider.class);
	}

	public static String XML_MEMENTO(JavaComposite jc) {
		return jc.getClassName(XMLMemento.class);
	}

	public static String WIZARD_NEW_PROJECT_CREATION_PAGE(JavaComposite jc) {
		return jc.getClassName(WizardNewProjectCreationPage.class);
	}

	public static String WORKSPACE_MODIFY_OPERATION(JavaComposite jc) {
		return jc.getClassName(WorkspaceModifyOperation.class);
	}

	public static String SUB_PROGRESS_MONITOR(JavaComposite jc) {
		return jc.getClassName(SubProgressMonitor.class);
	}

	public static String BASIC_NEW_PROJECT_RESOURCE_WIZARD(JavaComposite jc) {
		return jc.getClassName(BasicNewProjectResourceWizard.class);
	}

	public static String ABSTRACT_DECORATED_TEXT_EDITOR_PREFERENCE_CONSTANTS(
			JavaComposite jc) {
		return jc
				.getClassName(AbstractDecoratedTextEditorPreferenceConstants.class
						.getName());
	}

	public static String I_RECONCILER(JavaComposite jc) {
		return jc.getClassName(IReconciler.class);
	}

	public static String SPELLING_SERVICE(JavaComposite jc) {
		return jc.getClassName(SpellingService.class);
	}

	public static String I_RECONCILING_STRATEGY(JavaComposite jc) {
		return jc.getClassName(IReconcilingStrategy.class);
	}

	public static String SPELLING_RECONCILE_STRATEGY(JavaComposite jc) {
		return jc.getClassName(SpellingReconcileStrategy.class);
	}

	public static String I_SPELLING_PROBLEM_COLLECTOR(JavaComposite jc) {
		return jc.getClassName(ISpellingProblemCollector.class);
	}

	public static String SPELLING_PROBLEM(JavaComposite jc) {
		return jc.getClassName(SpellingProblem.class);
	}

	public static String MONO_RECONCILER(JavaComposite jc) {
		return jc.getClassName(MonoReconciler.class);
	}
	
	public static String VIEWER_REFRESH(JavaComposite jc) {
		return jc.getClassName(ViewerRefresh.class);
	}
	
	public static String I_VIEWER_NOTIFICATION(JavaComposite jc) {
		return jc.getClassName(IViewerNotification.class);
	}
}
