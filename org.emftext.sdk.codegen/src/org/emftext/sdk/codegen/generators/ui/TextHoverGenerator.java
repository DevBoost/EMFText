/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ACTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUNDLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DEFAULT_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EDITORS_UI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FONT_DATA;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INFORMATION_CONTROL_EXTENSION4;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INPUT_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SHARED_IMAGES;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_HOVER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_HOVER_EXTENSION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_HOVER_EXTENSION2;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.J_FACE_RESOURCES;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.POINT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SHELL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOOL_BAR_MANAGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URL;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class TextHoverGenerator extends JavaBaseGenerator {

	private String editorClassName;
	private String htmlPrinterClassName;
	private String browserInformationControlClassName;
	private String docBrowserInformationControlInputClassName;
	private String hyperlinkClassName;
	private String textHoverClassName;

	public TextHoverGenerator() {
		super();
	}

	private TextHoverGenerator(GenerationContext context) {
		super(context, EArtifact.TEXT_HOVER);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
		htmlPrinterClassName = getContext().getQualifiedClassName(EArtifact.HTML_PRINTER);
		browserInformationControlClassName = getContext().getQualifiedClassName(EArtifact.BROWER_INFORMATION_CONTROL);
		docBrowserInformationControlInputClassName = getContext().getQualifiedClassName(EArtifact.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		hyperlinkClassName = getContext().getQualifiedClassName(EArtifact.HYPERLINK);
		textHoverClassName = getContext().getQualifiedClassName(EArtifact.TEXT_HOVER);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A class to display the information of an element.");
		sc.add("// Most of the code is taken from");
		sc.add("// <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>.");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + " implements " + I_TEXT_HOVER + ", " + I_TEXT_HOVER_EXTENSION + ", " + I_TEXT_HOVER_EXTENSION2 + "{");
		sc.addLineBreak();

		addFields(sc);
		addInnerClasses(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
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
	}

	private void addInnerClasses(StringComposite sc) {
		addSimpleSelectionProviderClass(sc);
		addOpenDeclarationActionClass(sc);
		addPresenterControlCreatorClass(sc);
		addHoverControlCreatorClass(sc);
	}

	private void addHoverControlCreatorClass(StringComposite sc) {
		sc.add("//Hover control creator. Creates a hover control before focus.");
		sc.add("public static final class HoverControlCreator extends " + ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR + " {");
		sc.addLineBreak();
		sc.add("// The information presenter control creator.");
		sc.add("private final " + I_INFORMATION_CONTROL_CREATOR + " fInformationPresenterControlCreator;");
		sc.addLineBreak();
		sc.add("// @param informationPresenterControlCreator");
		sc.add("//            control creator for enriched hover");
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

	private void addFields(StringComposite sc) {
		sc.add("private static final String FONT = " + J_FACE_RESOURCES + ".DIALOG_FONT;");
		sc.add("private " + editorClassName + " editor;");
		sc.add("private " + getClassNameHelper().getI_HOVER_TEXT_PROVIDER() + " hoverTextProvider;");
		sc.add("// The style sheet (css).");
		sc.add("private static String styleSheet;");
		sc.addLineBreak();
		sc.add("// The hover control creator.");
		sc.add("private " + I_INFORMATION_CONTROL_CREATOR + " hoverControlCreator;");
		sc.addLineBreak();
		sc.add("// The presentation control creator.");
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
		sc.add("public " + OBJECT + " getHoverInfo2(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " hoverRegion) {");
		sc.add("return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInternalGetHoverInfoMethod(StringComposite sc) {
		sc.add("private " + docBrowserInformationControlInputClassName + " internalGetHoverInfo(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " hoverRegion) {");
		sc.add(getClassNameHelper().getI_TEXT_RESOURCE() + " textResource = editor.getResource();");
		sc.add(getClassNameHelper().getI_LOCATION_MAP() + " locationMap = textResource.getLocationMap();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());");
		sc.add("if (elementsAtOffset == null || elementsAtOffset.size() == 0) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return getHoverInfo(elementsAtOffset, textViewer, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverInfo3Method(StringComposite sc) {
		sc.add("// Computes the hover info.");
		sc.add("//");
		sc.add("// @param elements");
		sc.add("//            the resolved elements");
		sc.add("// @param constantValue");
		sc.add("//            a constant value iff result contains exactly 1 constant field,");
		sc.add("//            or <code>null</code>");
		sc.add("// @param previousInput");
		sc.add("//            the previous input, or <code>null</code>");
		sc.add("// @return the HTML hover info for the given element(s) or <code>null</code>");
		sc.add("//         if no information is available");
		sc.add("private " + docBrowserInformationControlInputClassName + " getHoverInfo(" + LIST + "<" + E_OBJECT + "> elements, " + I_TEXT_VIEWER + " textViewer, " + docBrowserInformationControlInputClassName + " previousInput) {");
		sc.add("StringBuffer buffer = new StringBuffer();");
		sc.add(E_OBJECT + " proxyObject = getFirstProxy(elements);");
		sc.add(E_OBJECT + " declarationObject = null;");
		sc.add("// get the token text, which is hovered. It is needed to jump to the");
		sc.add("// declaration.");
		sc.add("String tokenText = \"\";");
		sc.add("if (proxyObject != null) {");
		sc.add(getClassNameHelper().getI_TEXT_RESOURCE() + " textResource = editor.getResource();");
		sc.add(getClassNameHelper().getI_LOCATION_MAP() + " locationMap = textResource.getLocationMap();");
		sc.add("int offset = locationMap.getCharStart(proxyObject);");
		sc.add("int length = locationMap.getCharEnd(proxyObject) + 1 - offset;");
		sc.add("try {");
		sc.add("tokenText = textViewer.getDocument().get(offset, length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("declarationObject = " + ECORE_UTIL + ".resolve(proxyObject, editor.getResource());");
		sc.add("if (declarationObject != null) {");
		sc.add(htmlPrinterClassName + ".addParagraph(buffer, hoverTextProvider.getHoverText(declarationObject));");
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

	private void addGetStyleSheetMethod(StringComposite sc) {
		sc.add("// Sets the style sheet font.");
		sc.add("//");
		sc.add("// @return the hover style sheet");
		sc.add("//");
		sc.add("private static String getStyleSheet() {");
		sc.add("if (styleSheet == null) {");
		sc.add("styleSheet = loadStyleSheet();");
		sc.add("}");
		sc.add("String css = styleSheet;");
		sc.add("// Sets background color for the hover text window");
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
		sc.add("for (" + E_OBJECT + " object : elements) {");
		sc.add("if (object.eIsProxy()) {");
		sc.add("return object;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
	}

	private void addLoadStyleSheetMethod(StringComposite sc) {
		sc.add("// Loads and returns the hover style sheet.");
		sc.add("//");
		sc.add("// @return the style sheet, or <code>null</code> if unable to load");
		sc.add("private static String loadStyleSheet() {");
		sc.add(BUNDLE + " bundle = " + PLATFORM + ".getBundle(" + getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR) + ".PLUGIN_ID);");
		sc.add(URL + " styleSheetURL = bundle.getEntry(\"/" + GenerationContext.DEFAULT_CSS_DIR + "/" + GenerationContext.HOVER_STYLE_FILENAME + "\");");
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

	private void addPresenterControlCreatorClass(StringComposite sc) {
		sc.add("// Presenter control creator. Creates a hover control after focus.");
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
		sc.add("public void inputChanged(" + OBJECT + " newInput) {");
		sc.add("if (newInput == null) {");
		sc.add("selectionProvider.setSelection(new " + STRUCTURED_SELECTION + "());");
		sc.add("} else if (newInput instanceof " + docBrowserInformationControlInputClassName + ") {");
		sc.add(docBrowserInformationControlInputClassName + " input = (" + docBrowserInformationControlInputClassName + ") newInput;");
		sc.add(OBJECT + " inputElement = input.getInputElement();");
		sc.add("selectionProvider.setSelection(new " + STRUCTURED_SELECTION + "(inputElement));");
		sc.add("// If there is an element of type EObject in the");
		sc.add("// input element, the button to open the declaration");
		sc.add("// will be set enable");
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

	private void addOpenDeclarationActionClass(StringComposite sc) {
		sc.add("// This action will be activated if the button in the hover window is pushed");
		sc.add("// to jump to the declaration.");
		sc.add("public static class OpenDeclarationAction extends " + ACTION + " {");
		sc.addLineBreak();
		sc.add("private final " + browserInformationControlClassName + " infoControl;");
		sc.addLineBreak();
		sc.add("// Creates the action to jump to the declaration.");
		sc.add("//");
		sc.add("// @param infoControl");
		sc.add("//            the info control holds the hover information and the");
		sc.add("//            target element");
		sc.add("public OpenDeclarationAction(" + browserInformationControlClassName + " infoControl) {");
		sc.add("this.infoControl = infoControl;");
		sc.add("setText(\"Open Declaration\");");
		sc.add(I_SHARED_IMAGES + " images = " + PLATFORM_UI + ".getWorkbench().getSharedImages();");
		// TODO use better image
		sc.add("setImageDescriptor(images.getImageDescriptor(" + I_SHARED_IMAGES + ".IMG_ETOOL_HOME_NAV));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("// Creates, sets, activates a hyperlink.");
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

	private void addConstructor(StringComposite sc) {
		sc.add("// Creates a new TextHover to collect the information about the hovered");
		sc.add("// element.");
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor) {");
		sc.add("super();");
		sc.add("this.editor = editor;");
		sc.add("hoverTextProvider = new " + getContext().getQualifiedClassName(EArtifact.META_INFORMATION) + "().getHoverTextProvider();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSimpleSelectionProviderClass(StringComposite sc) {
		sc.add("// A simple default implementation of a {@link " + I_SELECTION_PROVIDER + "}. It stores");
		sc.add("// the selection and notifies all selection change listeners when the selection");
		sc.add("// is set.");
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
		sc.add(OBJECT + "[] listeners = selectionChangedListeners.getListeners();");
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

	public IGenerator newInstance(GenerationContext context) {
		return new TextHoverGenerator(context);
	}
}
