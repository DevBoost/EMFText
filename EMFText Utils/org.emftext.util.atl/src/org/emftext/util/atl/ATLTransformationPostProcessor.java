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
package org.emftext.util.atl;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;

public abstract class ATLTransformationPostProcessor {

	private ModelLoader modelLoader;
	private boolean isInTransformation;
	protected Resource currentResource;

	protected abstract Map<String, String> getMetamodelURIs();

	protected abstract String getTransformationURI();

	protected abstract String getInMetamodelName();

	protected abstract String getOutMetamodelName();

	protected abstract String getOutputURI();

	private void createResources() {
		modelLoader = new AtlEMFModelHandler().createModelLoader();
	}

	private void initMetamodels(Map<String, ASMEMFModel> models)
			throws IOException {
		for (String mmname : getMetamodelURIs().keySet()) {
			String uri = getMetamodelURIs().get(mmname);
			ASMEMFModel metamodel = (ASMEMFModel) modelLoader.loadModel(mmname,
					modelLoader.getMOF(), "uri:" + uri);
			models.put(mmname, metamodel);
		}
	}

	public void processBasic(Resource resource) {

		if (isInTransformation) {
			return;
		}
		this.currentResource = resource;
		isInTransformation = true;
		try {
			URL trafo = new URL(getTransformationURI());

			Map<String, ASMEMFModel> models = new HashMap<String, ASMEMFModel>();
			createResources();
			initMetamodels(models);

			String outUri = getOutputURI();

			// load models
			ASMEMFModel inputModel = (ASMEMFModel) modelLoader.loadModel("IN",
					models.get(getInMetamodelName()), resource.getURI()
							.toPlatformString(true));
			ASMEMFModel outputModel = (ASMEMFModel) modelLoader.newModel("OUT",
					outUri, models.get(getOutMetamodelName()));

			models.put("IN", inputModel);
			models.put("OUT", outputModel);

			// launch
			AtlLauncher.getDefault().launch(trafo, Collections.EMPTY_MAP,
					models, Collections.EMPTY_MAP, Collections.EMPTY_LIST,
					Collections.EMPTY_MAP);

			modelLoader.save(outputModel, outUri);
			isInTransformation = false;
			this.currentResource = null;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			isInTransformation = false;
			this.currentResource = null;
		}
	}
}
