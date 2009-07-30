package org.emftext.runtime.ui.extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.part.FileEditorInput;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.osgi.framework.Bundle;

//TODO hoang-kim can we remove the warnings?
@SuppressWarnings("restriction")
public class TextHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {

	private EMFTextEditor editor;

	// TODO gather the collect-in features from the language specification
	protected final static String COMMENTS = "comments";

	public TextHover(EMFTextEditor editor) {
		super();
		this.editor = editor;
	}

	/**
	 * Action to go back to the previous input in the hover control.
	 * 
	 * @since 3.4
	 */
	// private static final class BackAction extends Action {
	// private final BrowserInformationControl fInfoControl;
	//
	// public BackAction(BrowserInformationControl infoControl) {
	// fInfoControl= infoControl;
	// setText("Back");
	// ISharedImages images= PlatformUI.getWorkbench().getSharedImages();
	// setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_BACK));
	// setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_BACK_DISABLED));
	//			
	// update();
	// }
	//		
	// public void run() {
	// BrowserInformationControlInput previous= (BrowserInformationControlInput)
	// fInfoControl.getInput().getPrevious();
	// if (previous != null) {
	// fInfoControl.setInput(previous);
	// }
	// }
	//
	// public void update() {
	// BrowserInformationControlInput current= fInfoControl.getInput();
	//
	// if (current != null && current.getPrevious() != null) {
	// BrowserInput previous= current.getPrevious();
	// setToolTipText("Back to "+previous.getInputName());
	// setEnabled(true);
	// } else {
	// setToolTipText("Back");
	// setEnabled(false);
	// }
	// }
	// }

	/**
	 * Action to go forward to the next input in the hover control.
	 * 
	 * @since 3.4
	 */
	// private static final class ForwardAction extends Action {
	// private final BrowserInformationControl fInfoControl;
	//
	// public ForwardAction(BrowserInformationControl infoControl) {
	// fInfoControl= infoControl;
	// setText("Forward");
	// ISharedImages images= PlatformUI.getWorkbench().getSharedImages();
	// setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));
	// setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD_DISABLED));
	//			
	// update();
	// }
	//		
	// public void run() {
	// BrowserInformationControlInput next= (BrowserInformationControlInput)
	// fInfoControl.getInput().getNext();
	// if (next != null) {
	// fInfoControl.setInput(next);
	// }
	// }
	//
	// public void update() {
	// BrowserInformationControlInput current= fInfoControl.getInput();
	//
	// if (current != null && current.getNext() != null) {
	// setToolTipText("Forward to "+ current.getNext().getInputName());
	// setEnabled(true);
	// } else {
	// setToolTipText("Forward");
	// setEnabled(false);
	// }
	// }
	// }

	/**
	 * Action that opens the current hover input element.
	 * 
	 * @since 3.4
	 */
	private static final class OpenDeclarationAction extends Action {
		private final BrowserInformationControl infoControl;

		public OpenDeclarationAction(BrowserInformationControl infoControl) {
			this.infoControl = infoControl;
			setText("Open Declaration");
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_ETOOL_HOME_NAV)); // TODO:
																								// better
																								// image
			//JavaPluginImages.setLocalImageDescriptors(this, "goto_input.gif"); //$NON-NLS-1$ //TODO: better images
		}

		/*
		 * @see org.eclipse.jface.action.Action#run()
		 */
		public void run() {
			// TODO goto declaration

			DocBrowserInformationControlInput infoInput = (DocBrowserInformationControlInput) infoControl.getInput(); // TODO:
																														// check
																														// cast
			infoControl.notifyDelayedInputChange(null);
			infoControl.dispose(); // FIXME: should have protocol to hide,
									// rather than dispose
			EObject decEO = infoInput.getElement();
			if (decEO != null && decEO.eResource() != null) {
				if (decEO.eResource().equals(infoInput.getResource())) {
					((EMFTextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.getActiveEditor()).setCaret(decEO);
				} else {
					IFile file = getIFileFromResource(decEO);
					if (file != null) {
						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						try {
							page.openEditor(new FileEditorInput(file), page.getActiveEditor().getSite().getId());

							IEditorPart ep = page.getActiveEditor();
							if (ep instanceof EMFTextEditor) {
								EMFTextEditor emftEditor = (EMFTextEditor) ep;
								emftEditor.setCaret(decEO);
							}
						} catch (PartInitException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// try {
			// //FIXME: add hover location to editor navigation history?
			// JavaUI.openInEditor(infoInput.getElement());
			// } catch (PartInitException e) {
			// JavaPlugin.log(e);
			// } catch (JavaModelException e) {
			// JavaPlugin.log(e);
			// }
		}

		private IFile getIFileFromResource(EObject object) {
			URI resourceURI = object.eResource().getURI();
			if (resourceURI.toString().startsWith("pathmap")) {
				resourceURI = URIConverter.URI_MAP.get(resourceURI);
			}
			if (resourceURI.isPlatformResource()) {
				String platformString = resourceURI.toPlatformString(true);
				if (platformString != null) {
					return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
				}
			}
			return null;
		}
	}

	/**
	 * Presenter control creator.
	 * 
	 * @since 3.3
	 */
	public static final class PresenterControlCreator extends AbstractReusableInformationControlCreator {

		/*
		 * @seeorg.eclipse.jdt.internal.ui.text.java.hover.
		 * AbstractReusableInformationControlCreator
		 * #doCreateInformationControl(org.eclipse.swt.widgets.Shell)
		 */
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (BrowserInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				BrowserInformationControl iControl = new BrowserInformationControl(parent, JFaceResources.DEFAULT_FONT,
						tbm);

				// Disable the ShowInDocView and OpenExternalBrowser
				// final BackAction backAction= new BackAction(iControl);
				// backAction.setEnabled(false);
				// tbm.add(backAction);
				// final ForwardAction forwardAction= new
				// ForwardAction(iControl);
				// tbm.add(forwardAction);
				// forwardAction.setEnabled(false);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);
				tbm.add(openDeclarationAction);
				final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();

				IInputChangedListener inputChangeListener = new IInputChangedListener() {
					public void inputChanged(Object newInput) {
						// backAction.update();
						// forwardAction.update();
						if (newInput == null) {
							selectionProvider.setSelection(new StructuredSelection());
						} else if (newInput instanceof BrowserInformationControlInput) {
							BrowserInformationControlInput input = (BrowserInformationControlInput) newInput;
							Object inputElement = input.getInputElement();
							selectionProvider.setSelection(new StructuredSelection(inputElement));
							boolean isEObjectInput = inputElement instanceof EObject;
							openDeclarationAction.setEnabled(isEObjectInput);
						}
					}
				};
				iControl.addInputChangeListener(inputChangeListener);

				tbm.update(true);

				addLinkListener(iControl);
				return iControl;

			} else {
				return new DefaultInformationControl(parent, true);
			}
		}
	}

	/**
	 * Hover control creator.
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
		public HoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.java.hover.AbstractReusableInformationControlCreator#doCreateInformationControl(org.eclipse.swt.widgets.Shell)
		 */
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				BrowserInformationControl iControl = new BrowserInformationControl(parent, JFaceResources.DEFAULT_FONT,
						tooltipAffordanceString) {
					
					/*
					 * @see
					 * org.eclipse.jface.text.IInformationControlExtension5#getInformationPresenterControlCreator()
					 */
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.java.hover.AbstractReusableInformationControlCreator#canReuse(org.eclipse.jface.text.IInformationControl)
		 */
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

	private static void addLinkListener(final BrowserInformationControl control) {

		// control.addLocationListener(JavaElementLinks.createLocationListener(new
		// JavaElementLinks.ILinkHandler() {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.ILinkHandler
		 * #handleJavadocViewLink(org.eclipse.jdt.core.IJavaElement)
		 */
		// public void handleJavadocViewLink(IJavaElement linkTarget) {
		// control.notifyDelayedInputChange(null);
		// control.setVisible(false);
		// control.dispose(); //FIXME: should have protocol to hide, rather than
		// dispose
		// try {
		// JavadocView view= (JavadocView)
		// JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
		// view.setInput(linkTarget);
		// } catch (PartInitException e) {
		// JavaPlugin.log(e);
		// }
		// }
		//			
		// /* (non-Javadoc)
		// * @see
		// org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.ILinkHandler#handleInlineJavadocLink(org.eclipse.jdt.core.IJavaElement)
		// */
		// public void handleInlineDocLink(IJavaElement linkTarget) {
		// DocBrowserInformationControlInput hoverInfo= getHoverInfo(new
		// IJavaElement[] { linkTarget }, null,
		// (DocBrowserInformationControlInput) control.getInput());
		// if (control.hasDelayedInputChangeListener())
		// control.notifyDelayedInputChange(hoverInfo);
		// else
		// control.setInput(hoverInfo);
		// }
		//			
		// /* (non-Javadoc)
		// * @see
		// org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.ILinkHandler#handleDeclarationLink(org.eclipse.jdt.core.IJavaElement)
		// */
		// public void handleDeclarationLink(IJavaElement linkTarget) {
		// control.notifyDelayedInputChange(null);
		// control.dispose(); //FIXME: should have protocol to hide, rather than
		// dispose
		// try {
		// //FIXME: add hover location to editor navigation history?
		// JavaUI.openInEditor(linkTarget);
		// } catch (PartInitException e) {
		// JavaPlugin.log(e);
		// } catch (JavaModelException e) {
		// JavaPlugin.log(e);
		// }
		// }
		//
		// /* (non-Javadoc)
		// * @see
		// org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.ILinkHandler#handleExternalLink(java.net.URL,
		// org.eclipse.swt.widgets.Display)
		// */
		// public boolean handleExternalLink(URL url, Display display) {
		// control.notifyDelayedInputChange(null);
		// control.dispose(); //FIXME: should have protocol to hide, rather than
		// dispose
		//
		// // open external links in real browser:
		//				OpenBrowserUtil.open(url, display, ""); //$NON-NLS-1$
		//				
		// return true;
		// }
		//			
		// public void handleTextSet() {
		// }
		// }));
	}

	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		ITextResource textResource = (ITextResource) editor.getResource();
		ILocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		EObject proxyAtOffset = getFirstProxy(elementsAtOffset);
		if (proxyAtOffset != null) {
			proxyAtOffset = EcoreUtil.resolve(proxyAtOffset, textResource);
			if (proxyAtOffset.eResource() != null && !proxyAtOffset.eResource().equals(textResource)) {
				// TODO handle external resources
				proxyAtOffset = elementsAtOffset.get(0);
			}
		} else {
			proxyAtOffset = elementsAtOffset.get(0);
		}
		if (proxyAtOffset.eResource() != null) {
			try {
				return textViewer.getDocument().get(locationMap.getCharStart(proxyAtOffset), locationMap.getCharEnd(proxyAtOffset) - locationMap.getCharStart(proxyAtOffset) + 1);// nothing
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
		return ((DocBrowserInformationControlInput) getHoverInfo2(textViewer, hoverRegion)).getHtml();
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

	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null) {
			hoverControlCreator = new HoverControlCreator(getInformationPresenterControlCreator());
		}
		return hoverControlCreator;
	}

	/*
	 * @see org.eclipse.jface.text.ITextHoverExtension2#getInformationPresenterControlCreator()
	 */
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null) {
			presenterControlCreator = new PresenterControlCreator();
		}
		return presenterControlCreator;
	}

	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		// TODO remove this once the background parsing is active
		if (editor.isDirty()) {
			return null;
		}
		return internalGetHoverInfo(textViewer, hoverRegion);
	}

	private DocBrowserInformationControlInput internalGetHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		ILocationMap locationMap = ((ITextResource) editor.getResource()).getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		if (elementsAtOffset == null || elementsAtOffset.size() == 0) {
			return null;
		}
		return getHoverInfo(elementsAtOffset, null);
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
	private DocBrowserInformationControlInput getHoverInfo(List<EObject> elements,
			DocBrowserInformationControlInput previousInput) {
		
		StringBuffer buffer = new StringBuffer();
		int leadingImageWidth = 0;
		EObject proxyObject = getFirstProxy(elements);
		EObject declarationObject = null;
		if (proxyObject != null) {
			declarationObject = EcoreUtil.resolve(proxyObject, editor.getResource());
			if (declarationObject != null) {
				HTMLPrinter.addParagraph(buffer, getInfoText(declarationObject, false));
			}
		} else {
			HTMLPrinter.addParagraph(buffer, getInfoText(elements.get(0), false));
		}
		if (buffer.length() > 0) {
			HTMLPrinter.insertPageProlog(buffer, 0, TextHover.getStyleSheet());
			HTMLPrinter.addPageEpilog(buffer);
			return new DocBrowserInformationControlInput(previousInput, declarationObject, editor.getResource(), buffer.toString(),
					leadingImageWidth);
		}
		return null;
	}

	private static String getInfoText(EObject member, boolean allowImage) {
		if (member == null) {
			return null;
		}
		EClass eClass = member.eClass();
		StringBuffer label = new StringBuffer("<strong>" + eClass.getName() + "</strong>");
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value=null;
			try {
				value = member.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
				//e.printStackTrace();
			}
			if (value != null && value.toString()!=null&&!value.toString().equals("[]")) {
				if (attribute.getName().equals(COMMENTS)) {
					HTMLPrinter.addSmallHeader(label, COMMENTS + ":");
					String comments = value.toString();
					comments = comments.substring(1, comments.length() - 1);
					HTMLPrinter.addParagraph(label, replaceNewlineToHTMLBR(comments));
					continue;
				}
				label.append("<br />" + attribute.getName() + ": " + member.eGet(attribute).toString());
			}
		}
		// String imageName= null;
		// if (allowImage) {
		// URL imageUrl=
		// JavaPlugin.getDefault().getImagesOnFSRegistry().getImageURL(member);
		// if (imageUrl != null) {
		// imageName= imageUrl.toExternalForm();
		// }
		// }

		// StringBuffer buf= new StringBuffer();
		// addImageAndLabel(buf, imageName, 16, 16, 2, 2, label.toString(), 20,
		// 2);
		// return buf.toString();
		return label.toString();
	}

	/**
	 * Returns the hover style sheet.
	 * 
	 * @return the style sheet
	 */
	private static String getStyleSheet() {
		if (styleSheet == null) {
			styleSheet = loadStyleSheet();
		}
		String css = styleSheet;
		if (css != null) {
			FontData fontData = JFaceResources.getFontRegistry().getFontData(JFaceResources.DEFAULT_FONT)[0];
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
					if (reader != null)
						reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void addImageAndLabel(StringBuffer buffer, String imageName, int imageWidth, int imageHeight,
			int imageLeft, int imageTop, String label, int labelLeft, int labelTop) {

		if (imageName != null) {
			StringBuffer imageStyle = new StringBuffer("position: absolute; "); //$NON-NLS-1$
			imageStyle.append("width: ").append(imageWidth).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			imageStyle.append("height: ").append(imageHeight).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			imageStyle.append("top: ").append(imageTop).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			imageStyle.append("left: ").append(imageLeft).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$

			buffer.append("<!--[if lte IE 6]><![if gte IE 5.5]>\n"); //$NON-NLS-1$
			buffer
					.append("<span style=\"").append(imageStyle).append("filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='").append(imageName).append("')\"></span>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			buffer.append("<![endif]><![endif]-->\n"); //$NON-NLS-1$

			buffer.append("<!--[if !IE]>-->\n"); //$NON-NLS-1$
			buffer.append("<img style='").append(imageStyle).append("' src='").append(imageName).append("'/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			buffer.append("<!--<![endif]-->\n"); //$NON-NLS-1$
			buffer.append("<!--[if gte IE 7]>\n"); //$NON-NLS-1$
			buffer.append("<img style='").append(imageStyle).append("' src='").append(imageName).append("'/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			buffer.append("<![endif]-->\n"); //$NON-NLS-1$
		}

		buffer.append("<div style='word-wrap:break-word;"); //$NON-NLS-1$
		if (imageName != null) {
			buffer.append("margin-left: ").append(labelLeft).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			buffer.append("margin-top: ").append(labelTop).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		buffer.append("'>"); //$NON-NLS-1$

		for (int i = 0; i < label.length(); i++) {
			char ch = label.charAt(i);
			if (ch == '<') {
				buffer.append("&lt;"); //$NON-NLS-1$
			} else if (ch == '>') {
				buffer.append("&gt;"); //$NON-NLS-1$
			} else {
				buffer.append(ch);
			}
		}

		buffer.append("</div>"); //$NON-NLS-1$
	}

	private static EObject getFirstProxy(List<EObject> objects) {
		for (EObject object : objects) {
			if (object.eIsProxy()) {
				return object;
			}
		}
		return null;
	}

	private static String replaceNewlineToHTMLBR(String str) {
		if (str != null) {
			return str.replaceAll("\\n", "<br />");
		}
		return null;
	}

}
