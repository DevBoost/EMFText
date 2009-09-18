package org.emftext.runtime.atl;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;

public abstract class ATLTransformationPostProcessor implements
		IOptionProvider, IResourcePostProcessorProvider, IResourcePostProcessor {

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

	public void process(Resource resource) {

		if (isInTransformation)
			return;
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

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();

		LinkedList<IResourcePostProcessorProvider> postProcessors = new LinkedList<IResourcePostProcessorProvider>();
		postProcessors.add(this);
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);

		return options;
	}
}
