package org.emftext.sdk.codegen.composites;

public class ManifestComposite extends StringComposite {

	public ManifestComposite() {
		super(true);
	}

	@Override
	protected boolean isLineBreaker(Component component) {
		return true;
	}
}
