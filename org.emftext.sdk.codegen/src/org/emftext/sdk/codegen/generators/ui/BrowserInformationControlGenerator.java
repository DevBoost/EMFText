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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ASSERT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BROWSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FONT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DELAYED_INPUT_CHANGE_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INFORMATION_CONTROL_EXTENSION2;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_INPUT_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.J_FACE_RESOURCES;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.KEY_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.KEY_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LOCATION_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MENU;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OPEN_WINDOW_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.POINT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROGRESS_ADAPTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROGRESS_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RECTANGLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SHELL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SLIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING_READER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STYLE_RANGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT_ERROR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT_LAYOUT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT_PRESENTATION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT_STYLE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOOL_BAR_MANAGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.WINDOW_EVENT;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class BrowserInformationControlGenerator extends JavaBaseGenerator {

	public BrowserInformationControlGenerator() {
		super();
	}

	private BrowserInformationControlGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.BROWSER_INFORMATION_CONTROL);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"Displays HTML information in a {@link " + BROWSER + "} widget.",
			"<p>",
			"This {@link IInformationControlExtension2} expects {@link #setInput(Object)} to be " +
			"called with an argument of type {@link BrowserInformationControlInput}.",
			"</p>",
			"<p>Moved into this package from <code>org.eclipse.jface.internal.text.revisions</code>.</p>",
			"<p>This class may be instantiated; it is not intended to be subclassed.</p>",
			"<p>Current problems:",
			"<ul>",
			"\t<li>the size computation is too small</li>",
			"\t<li>focusLost event is not sent - see https://bugs.eclipse.org/bugs/show_bug.cgi?id=84532</li>",
			"</ul>",
			"</p>",
			"@since 3.2"
		);
		
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_INFORMATION_CONTROL + " implements " + I_INFORMATION_CONTROL_EXTENSION2 + ", " + I_DELAYED_INPUT_CHANGE_PROVIDER + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Tells whether the " + SWT + " " + BROWSER + " widget and hence this information " +
			"control is available.",
			"@param parent the parent component used for checking or <code>null</code> if none",
			"@return <code>true</code> if this control is available"
		);
		
		sc.add("public static boolean isAvailable(" + COMPOSITE + " parent) {");
		sc.add("if (!fgAvailabilityChecked) {");
		sc.add("try {");
		sc.add(BROWSER + " browser= new " + BROWSER + "(parent, " + SWT + ".NONE);");
		sc.add("browser.dispose();");
		sc.add("fgIsAvailable= true;");
		sc.addLineBreak();
		sc.add(SLIDER + " sliderV= new " + SLIDER + "(parent, " + SWT + ".VERTICAL);");
		sc.add(SLIDER + " sliderH= new " + SLIDER + "(parent, " + SWT + ".HORIZONTAL);");
		sc.add("int width= sliderV.computeSize(" + SWT + ".DEFAULT, " + SWT + ".DEFAULT).x;");
		sc.add("int height= sliderH.computeSize(" + SWT + ".DEFAULT, " + SWT + ".DEFAULT).y;");
		sc.add("fgScrollBarSize= new " + POINT + "(width, height);");
		sc.add("sliderV.dispose();");
		sc.add("sliderH.dispose();");
		sc.add("} catch (" + SWT_ERROR + " er) {");
		sc.add("fgIsAvailable= false;");
		sc.add("} finally {");
		sc.add("fgAvailabilityChecked= true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return fgIsAvailable;");
		sc.add("}");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.addJavadoc("Minimal size constraints.");
		sc.add("private static final int MIN_WIDTH = 80;");
		sc.add("private static final int MIN_HEIGHT = 50;");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.addJavadoc("Availability checking cache.");
		sc.add("private static boolean fgIsAvailable = false;");
		sc.add("private static boolean fgAvailabilityChecked = false;");
		sc.addLineBreak();
		sc.addJavadoc("Cached scroll bar width and height");
		sc.add("private static " + POINT + " fgScrollBarSize;");
		sc.addLineBreak();
		sc.addJavadoc("The control's browser widget");
		sc.add("private " + BROWSER + " fBrowser;");
		sc.addJavadoc("Tells whether the browser has content");
		sc.add("private boolean fBrowserHasContent;");
		sc.addJavadoc("Text layout used to approximate size of content when rendered in browser");
		sc.add("private " + TEXT_LAYOUT + " fTextLayout;");
		sc.addJavadoc("Bold text style");
		sc.add("private " + TEXT_STYLE + " fBoldStyle;");
		sc.addLineBreak();
		sc.add("private " + docBrowserInformationControlInputClassName + " fInput;");
		sc.addLineBreak();
		sc.addJavadoc(
			"<code>true</code> iff the browser has completed loading of the last " +
			"input set via {@link #setInformation(String)}."
		);
		sc.add("private boolean fCompleted = false;");
		sc.addLineBreak();
		sc.addJavadoc("The listener to be notified when a delayed location changing event happened.");
		sc.add("private " + I_INPUT_CHANGED_LISTENER + " fDelayedInputChangeListener;");
		sc.addLineBreak();
		sc.addJavadoc("The listeners to be notified when the input changed.");
		sc.add("private " + LISTENER_LIST + " fInputChangeListeners = new " + LISTENER_LIST + "(" + LISTENER_LIST + ".IDENTITY);");
		sc.addLineBreak();
		sc.addJavadoc("The symbolic name of the font used for size computations, or <code>null</code> to use dialog font.");
		sc.add("private final String fSymbolicFontName;");
		sc.addLineBreak();

		sc.addJavadoc(
			"Creates a browser information control with the given shell as parent.",
			"@param parent the parent shell",
			"@param symbolicFontName the symbolic name of the font used for size computations",
			"@param resizable <code>true</code> if the control should be resizable"
		);
		sc.add("public " + getResourceClassName() + "(" + SHELL + " parent, String symbolicFontName, boolean resizable) {");
		sc.add("super(parent, resizable);");
		sc.add("fSymbolicFontName= symbolicFontName;");
		sc.add("create();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Creates a browser information control with the given shell as parent.",
			"@param parent the parent shell",
			"@param symbolicFontName the symbolic name of the font used for size computations",
			"@param statusFieldText the text to be used in the optional status field " +
			"or <code>null</code> if the status field should be hidden"
		);
		sc.add("public " + getResourceClassName() + "(" + SHELL + " parent, String symbolicFontName, String statusFieldText) {");
		sc.add("super(parent, statusFieldText);");
		sc.add("fSymbolicFontName= symbolicFontName;");
		sc.add("create();");
		sc.add("}");
		sc.addLineBreak();
		sc.addJavadoc(
			"Creates a browser information control with the given shell as parent.",
			"@param parent the parent shell",
			"@param symbolicFontName the symbolic name of the font used for size computations",
			"@param toolBarManager the manager or <code>null</code> if toolbar is not desired",
			"@since 3.4"
		);
		sc.add("public " + getResourceClassName() + "(" + SHELL + " parent, String symbolicFontName, " + TOOL_BAR_MANAGER + " toolBarManager) {");
		sc.add("super(parent, toolBarManager);");
		sc.add("fSymbolicFontName= symbolicFontName;");
		sc.add("create();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see org.eclipse.jface.text." + ABSTRACT_INFORMATION_CONTROL + "#createContent(" + COMPOSITE + ")");
		sc.add("protected void createContent(" + COMPOSITE + " parent) {");
		sc.add("fBrowser= new " + BROWSER + "(parent, " + SWT + ".NONE);");
		sc.add(DISPLAY + " display= getShell().getDisplay();");
		sc.add("fBrowser.setForeground(display.getSystemColor(" + SWT + ".COLOR_INFO_FOREGROUND));");
		sc.add("fBrowser.setBackground(display.getSystemColor(" + SWT + ".COLOR_INFO_BACKGROUND));");
		sc.add("fBrowser.addKeyListener(new " + KEY_LISTENER + "() {");
		sc.add("public void keyPressed(" + KEY_EVENT + " e)  {");
		sc.add("if (e.character == 0x1B) // ESC");
		sc.add("dispose(); // XXX: Just hide? Would avoid constant recreations.");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void keyReleased(" + KEY_EVENT + " e) {}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("fBrowser.addProgressListener(new " + PROGRESS_ADAPTER + "() {");
		sc.add("public void completed(" + PROGRESS_EVENT + " event) {");
		sc.add("fCompleted= true;");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("fBrowser.addOpenWindowListener(new " + OPEN_WINDOW_LISTENER + "() {");
		sc.add("public void open(" + WINDOW_EVENT + " event) {");
		sc.add("event.required= true; // Cancel opening of new windows");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.addComment("Replace browser's built-in context menu with none");
		sc.add("fBrowser.setMenu(new " + MENU + "(getShell(), " + SWT + ".NONE));");
		sc.addLineBreak();
		sc.add("createTextLayout();");
		sc.add("}");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.addJavadoc("{@inheritDoc} This control can handle {@link String}(no handle) and");
		sc.add("public void setInput(Object input) {");
		sc.add(ASSERT + ".isLegal(input == null || input instanceof String || input instanceof " + docBrowserInformationControlInputClassName + ");");
		sc.addLineBreak();
		sc.add("if (input instanceof String) {");
		sc.add("setInformation((String)input);");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("fInput= (" + docBrowserInformationControlInputClassName + ") input;");
		sc.addLineBreak();
		sc.add("String content= null;");
		sc.add("if (fInput != null)");
		sc.add("content= fInput.getHtml();");
		sc.addLineBreak();
		sc.add("fBrowserHasContent= content != null && content.length() > 0;");
		sc.addLineBreak();
		sc.add("if (!fBrowserHasContent)");
		sc.add("content= \"<html><body ></html>\";");
		sc.addLineBreak();
		sc.add("boolean RTL= (getShell().getStyle() & " + SWT + ".RIGHT_TO_LEFT) != 0;");
		sc.add("boolean resizable= isResizable();");
		sc.addLineBreak();
		sc.addComment(
			"The default \"overflow:auto\" would not result in a predictable width for the client area " +
			"and the re-wrapping would cause visual noise"
		);
		sc.add("String[] styles= null;");
		sc.add("if (RTL && resizable) {");
		sc.add("styles= new String[] { \"direction:rtl;\", \"overflow:scroll;\", \"word-wrap:break-word;\" };");
		sc.add("} else if (RTL && !resizable) {");
		sc.add("styles= new String[] { \"direction:rtl;\", \"overflow:hidden;\", \"word-wrap:break-word;\" };");
		sc.add("} else if (!resizable) {");
		sc.addComment(
			"XXX: In IE, \"word-wrap: break-word;\" causes bogus wrapping even in non-broken words :-(see e.g. Javadoc of String). " +
			"Re-check whether we really still need this now that the Javadoc Hover header already sets this style."
		);
		sc.add("styles= new String[] { \"overflow:hidden;\"/*, \"word-wrap: break-word;\"*/ };");
		sc.add("} else {");
		sc.add("styles= new String[] { \"overflow:scroll;\" };");
		sc.add("}");
		sc.addLineBreak();
		sc.add("StringBuffer buffer= new StringBuffer(content);");
		sc.add(htmlPrinterClassName + ".insertStyles(buffer, styles);");
		sc.add("content= buffer.toString();");
		sc.addLineBreak();
		
		sc.addComment(
			"XXX: Should add some JavaScript here that shows something like " +
			"\"(continued...)\" or \"...\" at the end of the visible area when the page overflowed " +
			"with \"overflow:hidden;\"."
		);
		
		sc.addLineBreak();
		sc.add("fCompleted= false;");
		sc.add("fBrowser.setText(content);");
		sc.addLineBreak();
		sc.add("Object[] listeners= fInputChangeListeners.getListeners();");
		sc.add("for (int i= 0; i < listeners.length; i++) {");
		sc.add("((" + I_INPUT_CHANGED_LISTENER + ")listeners[i]).inputChanged(fInput);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControl#setVisible(boolean)");
		sc.add("public void setVisible(boolean visible) {");
		sc.add(SHELL + " shell= getShell();");
		sc.add("if (shell.isVisible() == visible) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (!visible) {");
		sc.add("super.setVisible(false);");
		sc.add("setInput(null);");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment(
			"The Browser widget flickers when made visible while it is not completely loaded. " +
			"The fix is to delay the call to setVisible until either loading is completed " +
			"(see ProgressListener in constructor), or a timeout has been reached."
		);
		
		sc.add("final " + DISPLAY + " display = shell.getDisplay();");
		sc.addLineBreak();
		sc.addComment("Make sure the display wakes from sleep after timeout:");
		sc.add("display.timerExec(100, new Runnable() {");
		sc.add("public void run() {");
		sc.add("fCompleted= true;");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("while (!fCompleted) {");
		sc.addComment("Drive the event loop to process the events required to load the browser widget's contents:");
		sc.add("if (!display.readAndDispatch()) {");
		sc.add("display.sleep();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("shell = getShell();");
		sc.add("if (shell == null || shell.isDisposed()) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment(
			"Avoids flickering when replacing hovers, especially on Vista in ON_CLICK mode. " +
			"Causes flickering on GTK. Carbon does not care."
		);
		
		sc.add("if (\"win32\".equals(" + SWT + ".getPlatform())) {");
		sc.add("shell.moveAbove(null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("super.setVisible(true);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see " + ABSTRACT_INFORMATION_CONTROL + "#setSize(int, int)");
		sc.add("public void setSize(int width, int height) {");
		sc.add("fBrowser.setRedraw(false); // avoid flickering");
		sc.add("try {");
		sc.add("super.setSize(width, height);");
		sc.add("} finally {");
		sc.add("fBrowser.setRedraw(true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Creates and initializes the text layout used to compute the size hint.",
			"@since 3.2"
		);
		sc.add("private void createTextLayout() {");
		sc.add("fTextLayout= new " + TEXT_LAYOUT + "(fBrowser.getDisplay());");
		sc.addLineBreak();
		sc.addComment("Initialize fonts");
		sc.add("String symbolicFontName= fSymbolicFontName == null ? " + J_FACE_RESOURCES + ".DIALOG_FONT : fSymbolicFontName;");
		sc.add(FONT + " font = " + J_FACE_RESOURCES + ".getFont(symbolicFontName);");
		sc.add("fTextLayout.setFont(font);");
		sc.add("fTextLayout.setWidth(-1);");
		sc.add("font = " + J_FACE_RESOURCES + ".getFontRegistry().getBold(symbolicFontName);");
		sc.add("fBoldStyle = new " + TEXT_STYLE + "(font, null, null);");
		sc.addLineBreak();
		sc.addComment("Compute and set tab width");
		sc.add("fTextLayout.setText(\"    \");");
		sc.add("int tabWidth = fTextLayout.getBounds().width;");
		sc.add("fTextLayout.setTabs(new int[] {tabWidth});");
		sc.addLineBreak();
		sc.add("fTextLayout.setText(\"\");");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControl#dispose()");
		sc.add("public void dispose() {");
		sc.add("if (fTextLayout != null) {");
		sc.add("fTextLayout.dispose();");
		sc.add("fTextLayout = null;");
		sc.add("}");
		sc.add("fBrowser = null;");
		sc.addLineBreak();
		sc.add("super.dispose();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControl#computeSizeHint()");
		sc.add("public " + POINT + " computeSizeHint() {");
		sc.add(POINT + " sizeConstraints = getSizeConstraints();");
		sc.add(RECTANGLE + " trim = computeTrim();");
		sc.add("int height = trim.height;");
		sc.addLineBreak();
		// FIXME: The html2text does not render <p> like a browser.
		// Instead of inserting an empty line, it just adds a single line break.
		// Furthermore, the indentation of <dl><dd> elements is too small (e.g with a long @see line)
		sc.add(TEXT_PRESENTATION + " presentation= new " + TEXT_PRESENTATION + "();");
		sc.add("String text;");
		sc.add("try {");
		sc.add("text = " + htmlPrinterClassName + ".html2text(new " + STRING_READER + "(fInput.getHtml()), presentation);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("text = \"\";");
		sc.add("}");
		sc.add("fTextLayout.setText(text);");
		sc.add("fTextLayout.setWidth(sizeConstraints == null ? " + SWT + ".DEFAULT : sizeConstraints.x - trim.width);");
		sc.add(ITERATOR + "<?> iter= presentation.getAllStyleRangeIterator();");
		sc.add("while (iter.hasNext()) {");
		sc.add(STYLE_RANGE + " sr= (" + STYLE_RANGE + ")iter.next();");
		sc.add("if (sr.fontStyle == " + SWT + ".BOLD) {");
		sc.add("fTextLayout.setStyle(fBoldStyle, sr.start, sr.start + sr.length - 1);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add(RECTANGLE + " bounds= fTextLayout.getBounds(); // does not return minimum width, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=217446");
		sc.add("int lineCount= fTextLayout.getLineCount();");
		sc.add("int textWidth= 0;");
		sc.add("for (int i= 0; i < lineCount; i++) {");
		sc.add(RECTANGLE + " rect= fTextLayout.getLineBounds(i);");
		sc.add("int lineWidth= rect.x + rect.width;");
		sc.add("if (i == 0) {");
		sc.add("lineWidth += fInput.getLeadingImageWidth();");
		sc.add("}");
		sc.add("textWidth= Math.max(textWidth, lineWidth);");
		sc.add("}");
		sc.add("bounds.width= textWidth;");
		sc.add("fTextLayout.setText(\"\");");
		sc.addLineBreak();
		sc.add("int minWidth= bounds.width;");
		sc.add("height= height + bounds.height;");
		sc.addLineBreak();
		sc.addComment("Add some air to accommodate for different browser renderings");
		sc.add("minWidth+= 15;");
		sc.add("height+= 15;");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.addComment("Apply max size constraints");
		sc.add("if (sizeConstraints != null) {");
		sc.add("if (sizeConstraints.x != " + SWT + ".DEFAULT) {");
		sc.add("minWidth= Math.min(sizeConstraints.x, minWidth + trim.width);");
		sc.add("}");
		sc.add("if (sizeConstraints.y != " + SWT + ".DEFAULT) {");
		sc.add("height= Math.min(sizeConstraints.y, height);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Ensure minimal size");
		sc.add("int width= Math.max(MIN_WIDTH, minWidth);");
		sc.add("height= Math.max(MIN_HEIGHT, height);");
		sc.add(POINT + " windowSize = new " + POINT + "(width, height);");
		sc.add("return windowSize;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see org.eclipse.jface.text.IInformationControlExtension3#computeTrim()");
		sc.add("public " + RECTANGLE + " computeTrim() {");
		sc.add(RECTANGLE + " trim = super.computeTrim();");
		sc.add("if (isResizable()) {");
		sc.add("boolean RTL = (getShell().getStyle() & " + SWT + ".RIGHT_TO_LEFT) != 0;");
		sc.add("if (RTL) {");
		sc.add("trim.x-= fgScrollBarSize.x;");
		sc.add("}");
		sc.add("trim.width+= fgScrollBarSize.x;");
		sc.add("trim.height+= fgScrollBarSize.y;");
		sc.add("}");
		sc.add("return trim;");
		sc.add("}");
		sc.addLineBreak();
		sc.addJavadoc(
			"Adds the listener to the collection of listeners who will be " +
			"notified when the current location has changed or is about to change.",
			"@param listener the location listener",
			"@since 3.4"
		);
		sc.add("public void addLocationListener(" + LOCATION_LISTENER + " listener) {");
		sc.add("fBrowser.addLocationListener(listener);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControl#setForegroundColor(" + COLOR + ")");
		sc.add("public void setForegroundColor(" + COLOR + " foreground) {");
		sc.add("super.setForegroundColor(foreground);");
		sc.add("fBrowser.setForeground(foreground);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControl#setBackgroundColor(" + COLOR + ")");
		sc.add("public void setBackgroundColor(" + COLOR + " background) {");
		sc.add("super.setBackgroundColor(background);");
		sc.add("fBrowser.setBackground(background);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see IInformationControlExtension#hasContents()");
		sc.add("public boolean hasContents() {");
		sc.add("return fBrowserHasContent;");
		sc.add("}");
		sc.addLineBreak();

		sc.addJavadoc(
			"Adds a listener for input changes to this input change provider. " +
			"Has no effect if an identical listener is already registered.",
			"@param inputChangeListener the listener to add",
			"@since 3.4"
		);
		sc.add("public void addInputChangeListener(" + I_INPUT_CHANGED_LISTENER + " inputChangeListener) {");
		sc.add(ASSERT + ".isNotNull(inputChangeListener);");
		sc.add("fInputChangeListeners.add(inputChangeListener);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Removes the given input change listener from this input change provider. " +
			"Has no effect if an identical listener is not registered.",
			"@param inputChangeListener the listener to remove",
			"@since 3.4"
		);
		sc.add("public void removeInputChangeListener(" + I_INPUT_CHANGED_LISTENER + " inputChangeListener) {");
		sc.add("fInputChangeListeners.remove(inputChangeListener);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"@see " + I_DELAYED_INPUT_CHANGE_PROVIDER + "#setDelayedInputChangeListener(" + I_INPUT_CHANGED_LISTENER + ")",
			"@since 3.4"
		);
		sc.add("public void setDelayedInputChangeListener(" + I_INPUT_CHANGED_LISTENER + " inputChangeListener) {");
		sc.add("fDelayedInputChangeListener= inputChangeListener;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Tells whether a delayed input change listener is registered.",
			"@return <code>true</code> iff a delayed input change listener is currently registered",
			"@since 3.4"
		);
		sc.add("public boolean hasDelayedInputChangeListener() {");
		sc.add("return fDelayedInputChangeListener != null;");
		sc.add("}");
		sc.addLineBreak();

		sc.addJavadoc(
			"Notifies listeners of a delayed input change.",
			"@param newInput the new input, or <code>null</code> to request cancellation",
			"@since 3.4"
		);
		sc.add("public void notifyDelayedInputChange(Object newInput) {");
		sc.add("if (fDelayedInputChangeListener != null)");
		sc.add("fDelayedInputChangeListener.inputChanged(newInput);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"@see java.lang.Object#toString()",
			"@since 3.4"
		);
		sc.add("public String toString() {");
		sc.add("String style= (getShell().getStyle() & " + SWT + ".RESIZE) == 0 ? \"fixed\" : \"resizeable\";");
		sc.add("return super.toString() + \" -  style: \" + style;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@return the current browser input or <code>null</code>");
		sc.add("public " + docBrowserInformationControlInputClassName + " getInput() {");
		sc.add("return fInput;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see org.eclipse.jface.text.IInformationControlExtension5#computeSizeConstraints(int, int)");
		sc.add("public " + POINT + " computeSizeConstraints(int widthInChars, int heightInChars) {");
		sc.add("if (fSymbolicFontName == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(GC + " gc= new " + GC + "(fBrowser);");
		sc.add(FONT + " font= fSymbolicFontName == null ? " + J_FACE_RESOURCES + ".getDialogFont() : " + J_FACE_RESOURCES + ".getFont(fSymbolicFontName);");
		sc.add("gc.setFont(font);");
		sc.add("int width= gc.getFontMetrics().getAverageCharWidth();");
		sc.add("int height= gc.getFontMetrics().getHeight();");
		sc.add("gc.dispose();");
		sc.addLineBreak();
		sc.add("return new " + POINT + "(widthInChars * width, heightInChars * height);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BrowserInformationControlGenerator(context);
	}
}
