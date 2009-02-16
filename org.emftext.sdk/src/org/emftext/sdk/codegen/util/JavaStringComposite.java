package org.emftext.sdk.codegen.util;

/**
 * A custom StringComposite that is configured with the Java-specific
 * line break characters and indentation starter and stoppers.
 */
public class JavaStringComposite extends StringComposite {

	public JavaStringComposite() {
		super(true);
		addIndentationStarter("{");
		addIndentationStopper("}");
		addLineBreaker("{");
		addLineBreaker(";");
		addLineBreaker("}");
		addLineBreaker("*/");
	}

	@Override
	protected boolean isLineBreaker(Component component) {
		boolean superResult = super.isLineBreaker(component);
		if (superResult) {
			return true;
		}
		// add line breaks after single line comments
		return component.toString().contains("//");
	}
}
