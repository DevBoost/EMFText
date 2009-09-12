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
package org.emftext.runtime.ui.extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.emftext.runtime.resource.IHoverTextProvider;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.osgi.framework.Bundle;

/**
 * A <code>TextHover</code> class to display the information of an element. The
 * most of the code is taken from
 * <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>.
 * 
 * @author Tan-Ky Hoang-Kim
 * 
 */
public class TextHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {

	private EMFTextEditor editor;
	private static final String FONT = JFaceResources.DIALOG_FONT;
	private IHoverTextProvider hoverTextProvider;
	
	/**
	 * A simple default implementation of a {@link ISelectionProvider}. It stores
	 * the selection and notifies all selection change listeners when the selection
	 * is set.
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
	 * Creates a new TextHover to collect the information about the hovered
	 * element.
	 * 
	 * @param editor
	 *            the <code>EMFTextEditor</code>
	 * @param colorManager
	 */
	public TextHover(EMFTextEditor editor) {
		super();
		this.editor = editor;
		hoverTextProvider = editor.getResource().getMetaInformation().getHoverTextProvider();
	}

	/**
	 * This action will be activated if the button in the hover window is pushed
	 * to jump to the declaration.
	 * 
	 * @author Tan-Ky Hoang-Kim
	 * 
	 */
	public static class OpenDeclarationAction extends Action {
		
		private final BrowserInformationControl infoControl;

		/**
		 * Creates the action to jump to the declaration.
		 * 
		 * @param infoControl
		 *            the info control holds the hover information and the
		 *            target element
		 */
		public OpenDeclarationAction(BrowserInformationControl infoControl) {
			this.infoControl = infoControl;
			setText("Open Declaration");
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			// TODO: better image
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_ETOOL_HOME_NAV));
		}

		/**
		 * Creates, sets, activates a hyperlink.
		 */
		public void run() {
			DocBrowserInformationControlInput infoInput = (DocBrowserInformationControlInput) infoControl.getInput();
			infoControl.notifyDelayedInputChange(null);
			infoControl.dispose(); // FIXME: should have protocol to hide,
			// rather than dispose
			if (infoInput.getInputElement() instanceof EObject) {
				EObject decEO = (EObject) infoInput.getInputElement();
				if (decEO != null && decEO.eResource() != null) {
					Hyperlink hyperlink = new Hyperlink(null, decEO,infoInput.getTokenText());
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
			if (BrowserInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				BrowserInformationControl iControl = new BrowserInformationControl(parent, FONT, tbm);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);
				tbm.add(openDeclarationAction);
				final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();

				IInputChangedListener inputChangeListener = new IInputChangedListener() {
					public void inputChanged(Object newInput) {
						if (newInput == null) {
							selectionProvider
									.setSelection(new StructuredSelection());
						} else if (newInput instanceof DocBrowserInformationControlInput) {
							DocBrowserInformationControlInput input = (DocBrowserInformationControlInput) newInput;
							Object inputElement = input.getInputElement();
							selectionProvider
									.setSelection(new StructuredSelection(
											inputElement));
							// If there is an element of type EObject in the
							// input element, the button to open the declaration
							// will be set enable
							boolean isEObjectInput = inputElement instanceof EObject;
							openDeclarationAction.setEnabled(isEObjectInput);
							if (isEObjectInput) {
								String simpleName = inputElement.getClass().getSimpleName();
								simpleName = simpleName.substring(0, simpleName.length()-4);
								openDeclarationAction.setText("Open "+simpleName);
							}
							else
								openDeclarationAction.setText("Open Declaration");
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
		 * @param informationPresenterControlCreator
		 *            control creator for enriched hover
		 */
		public HoverControlCreator(
				IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		/*
		 * @seeorg.eclipse.jdt.internal.ui.text.java.hover.
		 * AbstractReusableInformationControlCreator
		 * #doCreateInformationControl(org.eclipse.swt.widgets.Shell)
		 */
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI
					.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				BrowserInformationControl iControl = new BrowserInformationControl(
						parent, FONT, tooltipAffordanceString) {

					/*
					 * @see
					 * org.eclipse.jface.text.IInformationControlExtension5#
					 * getInformationPresenterControlCreator()
					 */
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				return iControl;
			} else {
				return new DefaultInformationControl(parent,
						tooltipAffordanceString);
			}
		}

		/*
		 * @seeorg.eclipse.jdt.internal.ui.text.java.hover.
		 * AbstractReusableInformationControlCreator
		 * #canReuse(org.eclipse.jface.text.IInformationControl)
		 */
		public boolean canReuse(IInformationControl control) {
			if (!super.canReuse(control)) {
				return false;
			}

			if (control instanceof IInformationControlExtension4) {
				String tooltipAffordanceString = EditorsUI
						.getTooltipAffordanceString();
				((IInformationControlExtension4) control)
						.setStatusText(tooltipAffordanceString);
			}

			return true;
		}
	}

	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		return ((DocBrowserInformationControlInput) getHoverInfo2(textViewer,
				hoverRegion)).getHtml();
	}

	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y) {
			return new Region(selection.x, selection.y);
		}
		return new Region(offset, 0);
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.ITextHoverExtension#getHoverControlCreator()
	 */
	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null) {
			hoverControlCreator = new HoverControlCreator(
					getInformationPresenterControlCreator());
		}
		return hoverControlCreator;
	}

	/*
	 * @seeorg.eclipse.jface.text.ITextHoverExtension2#
	 * getInformationPresenterControlCreator()
	 */
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null) {
			presenterControlCreator = new PresenterControlCreator();
		}
		return presenterControlCreator;
	}

	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);
	}

	private DocBrowserInformationControlInput internalGetHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		
		ITextResource textResource = editor.getResource();
		ILocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		if (elementsAtOffset == null || elementsAtOffset.size() == 0) {
			return null;
		}
		return getHoverInfo(elementsAtOffset, textViewer, null);
	}

	/**
	 * Computes the hover info.
	 * 
	 * @param elements
	 *            the resolved elements
	 * @param constantValue
	 *            a constant value iff result contains exactly 1 constant field,
	 *            or <code>null</code>
	 * @param previousInput
	 *            the previous input, or <code>null</code>
	 * @return the HTML hover info for the given element(s) or <code>null</code>
	 *         if no information is available
	 * @since 3.4
	 */
	private DocBrowserInformationControlInput getHoverInfo(List<EObject> elements, ITextViewer textViewer, DocBrowserInformationControlInput previousInput) {
		StringBuffer buffer = new StringBuffer();
		EObject proxyObject = getFirstProxy(elements);
		EObject declarationObject = null;
		// get the token text, which is hovered. It is needed to jump to the
		// declaration.
		String tokenText = "";
		if (proxyObject != null) {
			ITextResource textResource = editor.getResource();
			ILocationMap locationMap = textResource.getLocationMap();
			int offset = locationMap.getCharStart(proxyObject);
			int length = locationMap.getCharEnd(proxyObject) + 1 - offset;
			try {
				tokenText = textViewer.getDocument().get(offset, length);
			} catch (BadLocationException e) {
			}
			declarationObject = EcoreUtil.resolve(proxyObject, editor.getResource());
			if (declarationObject != null) {
				HTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(declarationObject));
			}
		} else {
			HTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(elements.get(0)));
		}
		if (buffer.length() > 0) {
			HTMLPrinter.insertPageProlog(buffer, 0, TextHover.getStyleSheet());
			HTMLPrinter.addPageEpilog(buffer);
			return new DocBrowserInformationControlInput(previousInput, declarationObject, editor.getResource(), buffer.toString(), tokenText);
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
		if (css != null) {
			FontData fontData = JFaceResources.getFontRegistry().getFontData(FONT)[0];
			css = HTMLPrinter.convertTopLevelFont(css, fontData);
		}

		return css;
	}

	/**
	 * Loads and returns the hover style sheet.
	 * 
	 * @return the style sheet, or <code>null</code> if unable to load
	 */
	private static String loadStyleSheet() {
		// TODO adjust this constant
		Bundle bundle = Platform.getBundle("org.emftext.runtime.ui");
		URL styleSheetURL = bundle.getEntry("/DocHoverStyleSheet.css"); //$NON-NLS-1$
		if (styleSheetURL != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(styleSheetURL.openStream()));
				StringBuffer buffer = new StringBuffer();
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				return buffer.toString();
			} catch (IOException ex) {
				ex.printStackTrace();
				return ""; //$NON-NLS-1$
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static EObject getFirstProxy(List<EObject> elements) {
		for (EObject object : elements) {
			if (object.eIsProxy()) {
				return object;
			}
		}
		return null;
	}
}
