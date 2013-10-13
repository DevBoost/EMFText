/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension4;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.osgi.framework.Bundle;

/**
 * A class to display the information of an element. Most of the code is taken
 * from <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>.
 */
public class CsTextHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {
	
	private static final String FONT = JFaceResources.DIALOG_FONT;
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider hoverTextProvider;
	/**
	 * The style sheet (css).
	 */
	private static String styleSheet;
	
	/**
	 * The hover control creator.
	 */
	private IInformationControlCreator hoverControlCreator;
	
	/**
	 * The presentation control creator.
	 */
	private IInformationControlCreator presenterControlCreator;
	
	/**
	 * A simple default implementation of a {@link ISelectionProvider}. It stores the
	 * selection and notifies all selection change listeners when the selection is set.
	 */
	public static class SimpleSelectionProvider implements ISelectionProvider {
		
		private final ListenerList selectionChangedListeners;
		private ISelection selection;
		
		public SimpleSelectionProvider() {
			selectionChangedListeners = new ListenerList();
		}
		
		public ISelection getSelection() {
			return selection;
		}
		
		public void setSelection(ISelection selection) {
			this.selection = selection;
			
			Object[] listeners = selectionChangedListeners.getListeners();
			for (int i = 0; i < listeners.length; i++) {
				((ISelectionChangedListener) listeners[i]).selectionChanged(new SelectionChangedEvent(this, selection));
			}
		}
		
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}
		
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}
		
	}
	
	/**
	 * This action will be activated if the button in the hover window is pushed to
	 * jump to the declaration.
	 */
	public static class OpenDeclarationAction extends Action {
		
		private final org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl infoControl;
		
		/**
		 * Creates the action to jump to the declaration.
		 * 
		 * @param infoControl the info control holds the hover information and the target
		 * element
		 */
		public OpenDeclarationAction(org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl infoControl) {
			this.infoControl = infoControl;
			setText("Open Declaration");
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_ETOOL_HOME_NAV));
		}
		
		/**
		 * Creates, sets, activates a hyperlink.
		 */
		public void run() {
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput infoInput = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput) infoControl.getInput();
			infoControl.notifyDelayedInputChange(null);
			infoControl.dispose();
			if (infoInput.getInputElement() instanceof EObject) {
				EObject decEO = (EObject) infoInput.getInputElement();
				if (decEO != null && decEO.eResource() != null) {
					org.emftext.sdk.concretesyntax.resource.cs.ui.CsHyperlink hyperlink = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsHyperlink(null, decEO, infoInput.getTokenText());
					hyperlink.open();
				}
			}
		}
	}
	
	/**
	 * Presenter control creator. Creates a hover control after focus.
	 */
	public static final class PresenterControlCreator extends AbstractReusableInformationControlCreator {
		
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl iControl = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl(parent, FONT, tbm);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);
				tbm.add(openDeclarationAction);
				final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();
				
				IInputChangedListener inputChangeListener = new IInputChangedListener() {
					public void inputChanged(Object newInput) {
						if (newInput == null) {
							selectionProvider.setSelection(new StructuredSelection());
						} else if (newInput instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput) {
							org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput input = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput) newInput;
							Object inputElement = input.getInputElement();
							selectionProvider.setSelection(new StructuredSelection(inputElement));
							// If there is an element of type EObject in the input element, the button to open
							// the declaration will be set enable
							boolean isEObjectInput = inputElement instanceof EObject;
							openDeclarationAction.setEnabled(isEObjectInput);
							if (isEObjectInput) {
								String simpleName = inputElement.getClass().getSimpleName();
								simpleName = simpleName.substring(0, simpleName.length() - 4);
								openDeclarationAction.setText("Open " + simpleName);
							} else							openDeclarationAction.setText("Open Declaration");
						}
					}
				};
				iControl.addInputChangeListener(inputChangeListener);
				
				tbm.update(true);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, true);
			}
		}
	}
	
	/**
	 * Hover control creator. Creates a hover control before focus.
	 */
	public static final class HoverControlCreator extends AbstractReusableInformationControlCreator {
		
		/**
		 * The information presenter control creator.
		 */
		private final IInformationControlCreator fInformationPresenterControlCreator;
		
		/**
		 * 
		 * @param informationPresenterControlCreator control creator for enriched hover
		 */
		public HoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}
		
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl.isAvailable(parent)) {
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl iControl = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBrowserInformationControl(parent, FONT, tooltipAffordanceString) {
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}
		
		public boolean canReuse(IInformationControl control) {
			if (!super.canReuse(control)) {
				return false;
			}
			
			if (control instanceof IInformationControlExtension4) {
				String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
				((IInformationControlExtension4) control).setStatusText(tooltipAffordanceString);
			}
			
			return true;
		}
	}
	
	/**
	 * Creates a new TextHover to collect the information about the hovered element.
	 */
	public CsTextHover(org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
		this.hoverTextProvider = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIMetaInformation().getHoverTextProvider();
	}
	
	// The warning about overriding or implementing a deprecated API cannot be avoided
	// because the SourceViewerConfiguration class depends on ITextHover.
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		Object hoverInfo = getHoverInfo2(textViewer, hoverRegion);
		if (hoverInfo == null) {
			return null;
		}
		return ((org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput) hoverInfo).getHtml();
	}
	
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y) {
			return new Region(selection.x, selection.y);
		}
		return new Region(offset, 0);
	}
	
	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null) {
			hoverControlCreator = new HoverControlCreator(getInformationPresenterControlCreator());
		}
		return hoverControlCreator;
	}
	
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null) {
			presenterControlCreator = new PresenterControlCreator();
		}
		return presenterControlCreator;
	}
	
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput internalGetHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return null;
		}
		org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		if (elementsAtOffset == null || elementsAtOffset.size() == 0) {
			return null;
		}
		return getHoverInfo(elementsAtOffset, textViewer, null);
	}
	
	/**
	 * Computes the hover info.
	 * 
	 * @param elements the resolved elements
	 * @param constantValue a constant value iff result contains exactly 1 constant
	 * field, or <code>null</code>
	 * @param previousInput the previous input, or <code>null</code>
	 * 
	 * @return the HTML hover info for the given element(s) or <code>null</code> if no
	 * information is available
	 */
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput getHoverInfo(List<EObject> elements, ITextViewer textViewer, org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput previousInput) {
		StringBuffer buffer = new StringBuffer();
		EObject proxyObject = getFirstProxy(elements);
		EObject containerObject = getFirstNonProxy(elements);
		EObject declarationObject = null;
		// get the token text, which is hovered. It is needed to jump to the declaration.
		String tokenText = "";
		if (proxyObject != null) {
			org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource = resourceProvider.getResource();
			org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
			int offset = locationMap.getCharStart(proxyObject);
			int length = locationMap.getCharEnd(proxyObject) + 1 - offset;
			try {
				tokenText = textViewer.getDocument().get(offset, length);
			} catch (BadLocationException e) {
			}
			declarationObject = EcoreUtil.resolve(proxyObject, resourceProvider.getResource());
			if (declarationObject != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(containerObject, declarationObject));
			}
		} else {
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(elements.get(0)));
		}
		if (buffer.length() > 0) {
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsHTMLPrinter.insertPageProlog(buffer, 0, org.emftext.sdk.concretesyntax.resource.cs.ui.CsTextHover.getStyleSheet());
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsHTMLPrinter.addPageEpilog(buffer);
			return new org.emftext.sdk.concretesyntax.resource.cs.ui.CsDocBrowserInformationControlInput(previousInput, declarationObject, resourceProvider.getResource(), buffer.toString(), tokenText);
		}
		return null;
	}
	
	/**
	 * Sets the style sheet font.
	 * 
	 * @return the hover style sheet
	 */
	private static String getStyleSheet() {
		if (styleSheet == null) {
			styleSheet = loadStyleSheet();
		}
		String css = styleSheet;
		// Sets background color for the hover text window
		css += "body {background-color:#FFFFE1;}\n";
		FontData fontData = JFaceResources.getFontRegistry().getFontData(FONT)[0];
		css = org.emftext.sdk.concretesyntax.resource.cs.ui.CsHTMLPrinter.convertTopLevelFont(css, fontData);
		
		return css;
	}
	
	/**
	 * Loads and returns the hover style sheet.
	 * 
	 * @return the style sheet, or <code>null</code> if unable to load
	 */
	private static String loadStyleSheet() {
		Bundle bundle = Platform.getBundle(org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.PLUGIN_ID);
		URL styleSheetURL = bundle.getEntry("/css/hover_style.css");
		if (styleSheetURL != null) {
			try {
				return org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil.getContent(styleSheetURL.openStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "";
	}
	
	private static EObject getFirstProxy(List<EObject> elements) {
		return getFirstObject(elements, true);
	}
	
	private static EObject getFirstNonProxy(List<EObject> elements) {
		return getFirstObject(elements, false);
	}
	
	private static EObject getFirstObject(List<EObject> elements, boolean proxy) {
		for (EObject object : elements) {
			if (proxy == object.eIsProxy()) {
				return object;
			}
		}
		return null;
	}
	
}
