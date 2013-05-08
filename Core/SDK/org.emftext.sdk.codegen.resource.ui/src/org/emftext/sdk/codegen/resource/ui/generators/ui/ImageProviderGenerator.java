/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FIELD;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE_LOCATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ACCESS_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MALFORMED_URL_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NO_SUCH_FIELD_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SECURITY_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SHARED_IMAGES;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PLATFORM_UI;

import org.eclipse.ui.ISharedImages;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.IClassNameConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class ImageProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A provider class for all images that are required by the generated UI plug-in. " +
			"The default implementation load images from the bundle and caches them to make sure " +
			"each image is loaded at most once."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetImageMethod(sc);
		addGetImageDescriptorMethod(sc);
	}

	private void addGetImageDescriptorMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the image for the given key. " +
			"Possible keys are:",
			"<ul>",
			"<li>platform:/plugin/your.plugin/icons/yourIcon.png</li>",
			"<li>bundleentry://557.fwk3560063/icons/yourIcon.png</li>",
			"</ul>"
		);
		sc.add("public " + IMAGE_DESCRIPTOR + " getImageDescriptor(String key) {");
		sc.add(I_PATH + " path = new " + PATH + "(key);");
		sc.add(uiPluginActivatorClassName + " plugin = " + uiPluginActivatorClassName + ".getDefault();");
		sc.add("if (plugin == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(IMAGE_DESCRIPTOR + " descriptor = " + IMAGE_DESCRIPTOR + ".createFromURL(" + FILE_LOCATOR + ".find(plugin.getBundle(), path, null));");
		sc.add("if (" + IMAGE_DESCRIPTOR + ".getMissingImageDescriptor().equals(descriptor) || descriptor == null) {");
		sc.addComment("try loading image from any bundle");
		sc.add("try {");
		sc.add(IClassNameConstants.URL + " pluginUrl = new " + IClassNameConstants.URL + "(key);");
		sc.add("descriptor = " + IMAGE_DESCRIPTOR + ".createFromURL(pluginUrl);");
		sc.add("if (" + IMAGE_DESCRIPTOR + ".getMissingImageDescriptor().equals(descriptor) || descriptor == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("} catch (" + MALFORMED_URL_EXCEPTION + " mue) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"IconProvider can't load image (URL is malformed).\", mue);");
		sc.add("}");
		sc.add("}");
		sc.add("return descriptor;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("public final static " + getResourceClassName() + " INSTANCE = new " + getResourceClassName() + "();");
		sc.addLineBreak();
		sc.add("private " + MAP + "<String, " + IMAGE + "> imageCache = new " + LINKED_HASH_MAP + "<String, " + IMAGE + ">();");
		sc.addLineBreak();
	}

	private void addGetImageMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the image associated with the given key. " +
			"The key can be either a path to an image file in the resource bundle or " +
			"a shared image from " + ISharedImages.class.getName() + "."
		);
		sc.add("public " + IMAGE + " getImage(String key) {");
		sc.add("if (key == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(IMAGE + " image = null;");
		sc.addComment("try shared images");
		sc.add("try {");
		sc.add(FIELD + " declaredField = " + I_SHARED_IMAGES + ".class.getDeclaredField(key);");
		sc.add("Object valueObject = declaredField.get(null);");
		sc.add("if (valueObject instanceof String) {");
		sc.add("String value = (String) valueObject;");
		sc.add("image = " + PLATFORM_UI + ".getWorkbench().getSharedImages().getImage(value);");
		sc.add("}");
		sc.add("} catch (" + SECURITY_EXCEPTION + " e) {");
		sc.add("} catch (" + NO_SUCH_FIELD_EXCEPTION + " e) {");
		sc.add("} catch (" + ILLEGAL_ARGUMENT_EXCEPTION + " e) {");
		sc.add("} catch (" + ILLEGAL_ACCESS_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("if (image != null) {");
		sc.add("return image;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("try cache");
		sc.add("if (imageCache.containsKey(key)) {");
		sc.add("return imageCache.get(key);");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("try loading image from UI bundle");
		sc.add(IMAGE_DESCRIPTOR + " descriptor = getImageDescriptor(key);");
		sc.add("if (descriptor == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("image = descriptor.createImage();");
		sc.add("if (image == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("imageCache.put(key, image);");
		sc.add("return image;");
		sc.add("}");
		sc.addLineBreak();
	}
}
