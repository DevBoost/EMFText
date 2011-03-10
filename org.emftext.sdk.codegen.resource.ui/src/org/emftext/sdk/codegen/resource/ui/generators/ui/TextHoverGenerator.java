/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ACTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUNDLE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DEFAULT_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.EDITORS_UI;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FONT_DATA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INFORMATION_CONTROL_EXTENSION4;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INPUT_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SHARED_IMAGES;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_HOVER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_HOVER_EXTENSION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_HOVER_EXTENSION2;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.J_FACE_RESOURCES;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.POINT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.REGION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SHELL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TOOL_BAR_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URL;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class TextHoverGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A class to display the information of an element. " +
			"Most of the code is taken from " +
			"<code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>."
		);
		sc.add("public class " + getResourceClassName() + " implements " + I_TEXT_HOVER + ", " + I_TEXT_HOVER_EXTENSION + ", " + I_TEXT_HOVER_EXTENSION2 + "{");
		sc.addLineBreak();

		addFields(sc);
		addInnerClasses(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetHoverInfoMethod(sc);
		addGetHoverRegionMethod(sc);
		addGetHoverControlCreatorMethod(sc);
		addGetInformationPresenterControlCreatorMethod(sc);
		addGetHoverInfo2Method(sc);
		addInternalGetHoverInfoMethod(sc);
		addGetHoverInfo3Method(sc);
		addGetStyleSheetMethod(sc);
		addLoadStyleSheetMethod(sc);
		addGetFirstProxyMethod(sc);
		addGetFirstNonProxyMethod(sc);
		addGetFirstObjectMethod(sc);
	}

	private void addInnerClasses(JavaComposite sc) {
		addSimpleSelectionProviderClass(sc);
		addOpenDeclarationActionClass(sc);
		addPresenterControlCreatorClass(sc);
		addHoverControlCreatorClass(sc);
	}

	private void addHoverControlCreatorClass(JavaComposite sc) {
		sc.addJavadoc("Hover control creator. Creates a hover control before focus.");
		sc.add("public static final class HoverControlCreator extends " + ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("The information presenter control creator.");
		sc.add("private final " + I_INFORMATION_CONTROL_CREATOR + " fInformationPresenterControlCreator;");
		sc.addLineBreak();
		
		sc.addJavadoc("@param informationPresenterControlCreator control creator for enriched hover");
		sc.add("public HoverControlCreator(" + I_INFORMATION_CONTROL_CREATOR + " informationPresenterControlCreator) {");
		sc.add("fInformationPresenterControlCreator = informationPresenterControlCreator;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + I_INFORMATION_CONTROL + " doCreateInformationControl(" + SHELL + " parent) {");
		sc.add("String tooltipAffordanceString = " + EDITORS_UI + ".getTooltipAffordanceString();");
		sc.add("if (" + browserInformationControlClassName + ".isAvailable(parent)) {");
		sc.add(browserInformationControlClassName + " iControl = new " + browserInformationControlClassName + "(parent, FONT, tooltipAffordanceString) {");
		sc.add("public " + I_INFORMATION_CONTROL_CREATOR + " getInformationPresenterControlCreator() {");
		sc.add("return fInformationPresenterControlCreator;");
		sc.add("}");
		sc.add("};");
		sc.add("return iControl;");
		sc.add("} else {");
		sc.add("return new " + DEFAULT_INFORMATION_CONTROL + "(parent, tooltipAffordanceString);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public boolean canReuse(" + I_INFORMATION_CONTROL + " control) {");
		sc.add("if (!super.canReuse(control)) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (control instanceof " + I_INFORMATION_CONTROL_EXTENSION4 + ") {");
		sc.add("String tooltipAffordanceString = " + EDITORS_UI + ".getTooltipAffordanceString();");
		sc.add("((" + I_INFORMATION_CONTROL_EXTENSION4 + ") control).setStatusText(tooltipAffordanceString);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverInfoMethod(StringComposite sc) {
		sc.add("public String getHoverInfo(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " hoverRegion) {");
		sc.add("return ((" + docBrowserInformationControlInputClassName + ") getHoverInfo2(textViewer, hoverRegion)).getHtml();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverRegionMethod(StringComposite sc) {
		sc.add("public " + I_REGION + " getHoverRegion(" + I_TEXT_VIEWER + " textViewer, int offset) {");
		sc.add(POINT + " selection = textViewer.getSelectedRange();");
		sc.add("if (selection.x <= offset && offset < selection.x + selection.y) {");
		sc.add("return new " + REGION + "(selection.x, selection.y);");
		sc.add("}");
		sc.add("return new " + REGION + "(offset, 0);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static final String FONT = " + J_FACE_RESOURCES + ".DIALOG_FONT;");
		sc.add("private " + editorClassName + " editor;");
		sc.add("private " + iHoverTextProviderClassName + " hoverTextProvider;");
		
		sc.addJavadoc("The style sheet (css).");
		sc.add("private static String styleSheet;");
		sc.addLineBreak();
		
		sc.addJavadoc("The hover control creator.");
		sc.add("private " + I_INFORMATION_CONTROL_CREATOR + " hoverControlCreator;");
		sc.addLineBreak();
		
		sc.addJavadoc("The presentation control creator.");
		sc.add("private " + I_INFORMATION_CONTROL_CREATOR + " presenterControlCreator;");
		sc.addLineBreak();
	}

	private void addGetHoverControlCreatorMethod(StringComposite sc) {
		sc.add("public " + I_INFORMATION_CONTROL_CREATOR + " getHoverControlCreator() {");
		sc.add("if (hoverControlCreator == null) {");
		sc.add("hoverControlCreator = new HoverControlCreator(");
		sc.add("getInformationPresenterControlCreator());");
		sc.add("}");
		sc.add("return hoverControlCreator;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInformationPresenterControlCreatorMethod(StringComposite sc) {
		sc.add("public " + I_INFORMATION_CONTROL_CREATOR + " getInformationPresenterControlCreator() {");
		sc.add("if (presenterControlCreator == null) {");
		sc.add("presenterControlCreator = new PresenterControlCreator();");
		sc.add("}");
		sc.add("return presenterControlCreator;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverInfo2Method(StringComposite sc) {
		sc.add("public Object getHoverInfo2(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " hoverRegion) {");
		sc.add("return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInternalGetHoverInfoMethod(StringComposite sc) {
		sc.add("private " + docBrowserInformationControlInputClassName + " internalGetHoverInfo(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " hoverRegion) {");
		sc.add(iTextResourceClassName + " textResource = editor.getResource();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());");
		sc.add("if (elementsAtOffset == null || elementsAtOffset.size() == 0) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return getHoverInfo(elementsAtOffset, textViewer, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverInfo3Method(JavaComposite sc) {
		sc.addJavadoc(
			"Computes the hover info.",
			"@param elements the resolved elements",
			"@param constantValue a constant value iff result contains exactly 1 constant field, or <code>null</code>",
			"@param previousInput the previous input, or <code>null</code>",
			"@return the HTML hover info for the given element(s) or <code>null</code> if no information is available"
		);
		sc.add("private " + docBrowserInformationControlInputClassName + " getHoverInfo(" + LIST + "<" + E_OBJECT + "> elements, " + I_TEXT_VIEWER + " textViewer, " + docBrowserInformationControlInputClassName + " previousInput) {");
		sc.add("StringBuffer buffer = new StringBuffer();");
		sc.add(E_OBJECT + " proxyObject = getFirstProxy(elements);");
		sc.add(E_OBJECT + " containerObject = getFirstNonProxy(elements);");
		sc.add(E_OBJECT + " declarationObject = null;");
		sc.addComment("get the token text, which is hovered. It is needed to jump to the declaration.");
		sc.add("String tokenText = \"\";");
		sc.add("if (proxyObject != null) {");
		sc.add(iTextResourceClassName + " textResource = editor.getResource();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add("int offset = locationMap.getCharStart(proxyObject);");
		sc.add("int length = locationMap.getCharEnd(proxyObject) + 1 - offset;");
		sc.add("try {");
		sc.add("tokenText = textViewer.getDocument().get(offset, length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("declarationObject = " + ECORE_UTIL + ".resolve(proxyObject, editor.getResource());");
		sc.add("if (declarationObject != null) {");
		sc.add(htmlPrinterClassName + ".addParagraph(buffer, hoverTextProvider.getHoverText(containerObject, declarationObject));");
		sc.add("}");
		sc.add("} else {");
		sc.add(htmlPrinterClassName + ".addParagraph(buffer, hoverTextProvider.getHoverText(elements.get(0)));");
		sc.add("}");
		sc.add("if (buffer.length() > 0) {");
		sc.add(htmlPrinterClassName + ".insertPageProlog(buffer, 0, " + textHoverClassName + ".getStyleSheet());");
		sc.add(htmlPrinterClassName + ".addPageEpilog(buffer);");
		sc.add("return new " + docBrowserInformationControlInputClassName + "(previousInput, declarationObject, editor.getResource(), buffer.toString(), tokenText);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStyleSheetMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Sets the style sheet font.",
			"@return the hover style sheet"
		);
		sc.add("private static String getStyleSheet() {");
		sc.add("if (styleSheet == null) {");
		sc.add("styleSheet = loadStyleSheet();");
		sc.add("}");
		sc.add("String css = styleSheet;");
		sc.addComment("Sets background color for the hover text window");
		sc.add("css += \"body {background-color:#FFFFE1;}\\n\";");
		sc.add("if (css != null) {");
		sc.add(FONT_DATA + " fontData = " + J_FACE_RESOURCES + ".getFontRegistry().getFontData(FONT)[0];");
		sc.add("css = " + htmlPrinterClassName + ".convertTopLevelFont(css, fontData);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return css;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFirstProxyMethod(StringComposite sc) {
		sc.add("private static " + E_OBJECT + " getFirstProxy(" + LIST + "<" + E_OBJECT + "> elements) {");
		sc.add("return getFirstObject(elements, true);");
		sc.add("}");
	}

	private void addGetFirstNonProxyMethod(StringComposite sc) {
		sc.add("private static " + E_OBJECT + " getFirstNonProxy(" + LIST + "<" + E_OBJECT + "> elements) {");
		sc.add("return getFirstObject(elements, false);");
		sc.add("}");
	}

	private void addGetFirstObjectMethod(StringComposite sc) {
		sc.add("private static " + E_OBJECT + " getFirstObject(" + LIST + "<" + E_OBJECT + "> elements, boolean proxy) {");
		sc.add("for (" + E_OBJECT + " object : elements) {");
		sc.add("if (proxy == object.eIsProxy()) {");
		sc.add("return object;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
	}

	private void addLoadStyleSheetMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Loads and returns the hover style sheet.",
			"@return the style sheet, or <code>null</code> if unable to load"
		);
		sc.add("private static String loadStyleSheet() {");
		sc.add(BUNDLE + " bundle = " + PLATFORM + ".getBundle(" + uiPluginActivatorClassName + ".PLUGIN_ID);");
		sc.add(URL + " styleSheetURL = bundle.getEntry(\"/" + UIConstants.DEFAULT_CSS_DIR + "/" + UIConstants.HOVER_STYLE_FILENAME + "\");");
		sc.add("if (styleSheetURL != null) {");
		sc.add(BUFFERED_READER + " reader = null;");
		sc.add("try {");
		sc.add("reader = new " + BUFFERED_READER + "(new " + INPUT_STREAM_READER + "(styleSheetURL.openStream()));");
		sc.add("StringBuffer buffer = new StringBuffer();");
		sc.add("String line = reader.readLine();");
		sc.add("while (line != null) {");
		sc.add("buffer.append(line);");
		sc.add("buffer.append('\\n');");
		sc.add("line = reader.readLine();");
		sc.add("}");
		sc.add("return buffer.toString();");
		sc.add("} catch (" + IO_EXCEPTION + " ex) {");
		sc.add("ex.printStackTrace();");
		sc.add("return \"\";");
		sc.add("} finally {");
		sc.add("try {");
		sc.add("if (reader != null) {");
		sc.add("reader.close();");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPresenterControlCreatorClass(JavaComposite sc) {
		sc.addJavadoc("Presenter control creator. Creates a hover control after focus.");
		sc.add("public static final class PresenterControlCreator extends " + ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR + " {");
		sc.addLineBreak();
		sc.add("public " + I_INFORMATION_CONTROL + " doCreateInformationControl(" + SHELL + " parent) {");
		sc.add("if (" + browserInformationControlClassName + ".isAvailable(parent)) {");
		sc.add(TOOL_BAR_MANAGER + " tbm = new " + TOOL_BAR_MANAGER + "(" + SWT + ".FLAT);");
		sc.add(browserInformationControlClassName + " iControl = new " + browserInformationControlClassName + "(parent, FONT, tbm);");
		sc.add("final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);");
		sc.add("tbm.add(openDeclarationAction);");
		sc.add("final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();");
		sc.addLineBreak();
		sc.add(I_INPUT_CHANGED_LISTENER + " inputChangeListener = new " + I_INPUT_CHANGED_LISTENER + "() {");
		sc.add("public void inputChanged(Object newInput) {");
		sc.add("if (newInput == null) {");
		sc.add("selectionProvider.setSelection(new " + STRUCTURED_SELECTION + "());");
		sc.add("} else if (newInput instanceof " + docBrowserInformationControlInputClassName + ") {");
		sc.add(docBrowserInformationControlInputClassName + " input = (" + docBrowserInformationControlInputClassName + ") newInput;");
		sc.add("Object inputElement = input.getInputElement();");
		sc.add("selectionProvider.setSelection(new " + STRUCTURED_SELECTION + "(inputElement));");
		sc.addComment(
			"If there is an element of type EObject in the " +
			"input element, the button to open the declaration " +
			"will be set enable"
		);
		sc.add("boolean isEObjectInput = inputElement instanceof " + E_OBJECT + ";");
		sc.add("openDeclarationAction.setEnabled(isEObjectInput);");
		sc.add("if (isEObjectInput) {");
		sc.add("String simpleName = inputElement.getClass().getSimpleName();");
		sc.add("simpleName = simpleName.substring(0, simpleName.length() - 4);");
		sc.add("openDeclarationAction.setText(\"Open \" + simpleName);");
		sc.add("} else");
		sc.add("openDeclarationAction.setText(\"Open Declaration\");");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("iControl.addInputChangeListener(inputChangeListener);");
		sc.addLineBreak();
		sc.add("tbm.update(true);");
		sc.add("return iControl;");
		sc.add("} else {");
		sc.add("return new " + DEFAULT_INFORMATION_CONTROL + "(parent, true);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addOpenDeclarationActionClass(JavaComposite sc) {
		sc.addJavadoc(
			"This action will be activated if the button in the hover window is pushed " +
			"to jump to the declaration."
		);
		sc.add("public static class OpenDeclarationAction extends " + ACTION + " {");
		sc.addLineBreak();
		sc.add("private final " + browserInformationControlClassName + " infoControl;");
		sc.addLineBreak();
		sc.addJavadoc(
			"Creates the action to jump to the declaration.",
			"@param infoControl the info control holds the hover information and the target element"
		);
		sc.add("public OpenDeclarationAction(" + browserInformationControlClassName + " infoControl) {");
		sc.add("this.infoControl = infoControl;");
		sc.add("setText(\"Open Declaration\");");
		sc.add(I_SHARED_IMAGES + " images = " + PLATFORM_UI + ".getWorkbench().getSharedImages();");
		sc.add("setImageDescriptor(images.getImageDescriptor(" + I_SHARED_IMAGES + ".IMG_ETOOL_HOME_NAV));");
		sc.add("}");
		sc.addLineBreak();
		sc.addJavadoc("Creates, sets, activates a hyperlink.");
		sc.add("public void run() {");
		sc.add(docBrowserInformationControlInputClassName + " infoInput = (" + docBrowserInformationControlInputClassName + ") infoControl.getInput();");
		sc.add("infoControl.notifyDelayedInputChange(null);");
		// FIXME should have protocol to hide, rather than dispose
		sc.add("infoControl.dispose();");
		sc.add("if (infoInput.getInputElement() instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " decEO = (" + E_OBJECT + ") infoInput.getInputElement();");
		sc.add("if (decEO != null && decEO.eResource() != null) {");
		sc.add(hyperlinkClassName + " hyperlink = new " + hyperlinkClassName + "(null, decEO, infoInput.getTokenText());");
		sc.add("hyperlink.open();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a new TextHover to collect the information about the hovered " +
			"element."
		);
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor) {");
		sc.add("super();");
		sc.add("this.editor = editor;");
		sc.add("hoverTextProvider = new " + uiMetaInformationClassName + "().getHoverTextProvider();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSimpleSelectionProviderClass(JavaComposite sc) {
		sc.addJavadoc(
			"A simple default implementation of a {@link " + I_SELECTION_PROVIDER + "}. It stores " +
			"the selection and notifies all selection change listeners when the selection " +
			"is set."
		);
		sc.add("public static class SimpleSelectionProvider implements " + I_SELECTION_PROVIDER + " {");
		sc.addLineBreak();
		sc.add("private final " + LISTENER_LIST + " selectionChangedListeners;");
		sc.add("private " + I_SELECTION + " selection;");
		sc.addLineBreak();
		sc.add("public SimpleSelectionProvider() {");
		sc.add("selectionChangedListeners = new " + LISTENER_LIST + "();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + I_SELECTION + " getSelection() {");
		sc.add("return selection;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setSelection(" + I_SELECTION + " selection) {");
		sc.add("this.selection = selection;");
		sc.addLineBreak();
		sc.add("Object[] listeners = selectionChangedListeners.getListeners();");
		sc.add("for (int i = 0; i < listeners.length; i++) {");
		sc.add("((" + I_SELECTION_CHANGED_LISTENER + ") listeners[i]).selectionChanged(new " + SELECTION_CHANGED_EVENT + "(this, selection));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		sc.addLineBreak();
	}

	
}
