package org.emftext.sdk.codegen.composites;

/**
 * A custom StringComposite that can be used to build manifests
 * for Eclipse plug-ins.
 */
public class ManifestComposite extends StringComposite {

	public ManifestComposite() {
		super(true);
	}

	@Override
	protected boolean isLineBreaker(Component component) {
		return true;
	}
}
