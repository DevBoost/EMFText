package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PREFERENCE_CONVERTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT_ATTRIBUTE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.BaseGenerator;

// TODO once the text token scanners are generated we might not need
// ITextResourcePluginMetaInformation.createLexer() anymore
public class TokenScannerGenerator extends BaseGenerator {

	private String colorManagerClassName;
	private String pluginActivatorClassName;

	public TokenScannerGenerator() {
		super();
	}

	private TokenScannerGenerator(GenerationContext context) {
		super(context, EArtifact.TOKEN_SCANNER);
		colorManagerClassName = getContext().getQualifiedClassName(EArtifact.COLOR_MANAGER);
		pluginActivatorClassName = getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// An adapter from the Eclipse <code>" + I_TOKEN_SCANNER + "</code> interface");
		sc.add("// to the EMFText <code>ITextLexer</code> interface.");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + " implements " + I_TOKEN_SCANNER + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetTokenLengthMethod(sc);
		addGetTokenOffsetMethod(sc);
		addNextTokenMethod(sc);
		addSetRangeMethod(sc);
		addGetTokenTextMethod(sc);
	}

	private void addGetTokenTextMethod(StringComposite sc) {
		sc.add("public String getTokenText() {");
		sc.add("return currentToken.getText();");
		sc.add("}");
	}

	private void addSetRangeMethod(StringComposite sc) {
		sc.add("public void setRange(" + I_DOCUMENT + " document, int offset, int length) {");
		sc.add("this.offset = offset;");
		sc.add("try {");
		sc.add("lexer.setText(document.get(offset, length));");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("//ignore this error. It might occur during editing when locations are outdated quickly.");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNextTokenMethod(StringComposite sc) {
		sc.add("public " + I_TOKEN + " nextToken() {");
		sc.add("currentToken = lexer.getNextToken();");
		sc.add("if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {");
		sc.add("return " + org.eclipse.jface.text.rules.Token.class.getName() + ".EOF;");
		sc.add("}");
		sc.add(TEXT_ATTRIBUTE + " ta = null;");
		sc.add("String tokenName = currentToken.getName();");
		sc.add("if (tokenName != null) {");
		sc.add("String enableKey = " + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".ENABLE);");
		sc.add("if (store.getBoolean(enableKey)) {");
		sc.add("String colorKey = " + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".COLOR);");
		sc.add(COLOR + " color = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(store, colorKey));");
		sc.add("int style = " + SWT + ".NORMAL;");
		sc.add("if (store.getBoolean(" + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".BOLD))) {");
		sc.add("style = style | " + SWT + ".BOLD;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".ITALIC))) {");
		sc.add("style = style | " + SWT + ".ITALIC;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".STRIKETHROUGH))) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".STRIKETHROUGH;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + getClassNameHelper().getSYNTAX_COLORING_HELPER() + ".getPreferenceKey(languageId, tokenName, " + getClassNameHelper().getSTYLE_PROPERTY() + ".UNDERLINE))) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".UNDERLINE;");
		sc.add("}");
		sc.add("ta = new " + TEXT_ATTRIBUTE + "(color, null, style);");
		sc.add("}");
		sc.add("}");
		//TODO potential performance improvement for large files in the future:
		//build a map of tokens and reuse them instead of creating new ones
		sc.add("return new " + org.eclipse.jface.text.rules.Token.class.getName() + "(ta);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenOffsetMethod(StringComposite sc) {
		sc.add("public int getTokenOffset() {");
		sc.add("return offset + currentToken.getOffset();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenLengthMethod(StringComposite sc) {
		sc.add("public int getTokenLength() {");
		sc.add("return currentToken.getLength();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		String metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);

		sc.add("// @param colorManager A manager to obtain color objects");
		sc.add("public " + getResourceClassName() + "(" + colorManagerClassName + " colorManager) {");
		sc.add("this.lexer = new " + metaInformationClassName + "().createLexer();");
		sc.add("this.languageId = new " + metaInformationClassName + "().getSyntaxName();");
		sc.add("this.store = " + pluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("this.colorManager = colorManager;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getClassNameHelper().getI_TEXT_SCANNER() + " lexer;");
		sc.add("private " + getClassNameHelper().getI_TEXT_TOKEN() + " currentToken;");
		sc.add("private int offset;");
		sc.add("private String languageId;");
		sc.add("private " + I_PREFERENCE_STORE + " store;");
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new TokenScannerGenerator(context);
	}
}
