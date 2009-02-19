package org.emftext.sdk.codegen.composites;

public class XMLComposite extends StringComposite {
	
	public XMLComposite() {
		super();
		addLineBreaker(">");
	}

	@Override
	public boolean isIndendationStarter(Component component) {
		return component.toString().endsWith(">") &&
			!component.toString().endsWith("?>") && 
			!isEndTag(component);
	}

	@Override
	public boolean isIndendationStopper(Component component) {
		return isEndTag(component);
	}

	private boolean isEndTag(Component component) {
		return component.toString().matches("</.*>");
	}
}
