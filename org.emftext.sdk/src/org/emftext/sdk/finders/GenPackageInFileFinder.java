package org.emftext.sdk.finders;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.MetamodelManager;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

public abstract class GenPackageInFileFinder implements IGenPackageFinder {

	protected IGenPackageFinderResult findGenPackage(ConcreteSyntax syntax, String nsURI, final ResourceSet rs, URI genModelURI) {
		Resource genModelResource = null;
		
		try {
			genModelResource = rs.getResource(genModelURI, true);
		} catch (Exception e) {}
		
		EList<EObject> contents = null; 
		if (genModelResource != null) {
			contents = genModelResource.getContents();	
		}
		if (contents != null && contents.size() > 0) {
			GenModel genModel = (GenModel) contents.get(0);
			File ecoreFile = null;
			
			if (Platform.isRunning()) {
				// reload generator model if option is enabled
				boolean reloadEnabled = OptionManager.INSTANCE.getBooleanOptionValue(syntax, ICodeGenOptions.RELOAD_GENERATOR_MODEL);
				if (reloadEnabled) {
					genModel = reloadGeneratorModel(genModel);
				}

				// find the Ecore files used by the generator model 
				List<GenFeature> allGenFeatures = genModel.getAllGenFeatures();
				for (GenFeature genFeature : allGenFeatures) {
					final Resource resource = genFeature.getEcoreFeature().eResource();
					if (resource == null) {
						continue;
					}
					URI uri = resource.getURI();
					if (uri == null) {
						continue;
					}
					IResource ecoreMember = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
					ecoreFile = ecoreMember.getLocation().toFile();
					break;
				}
			}

			Map<String, GenPackage> packages =  MetamodelManager.getGenPackages(genModel);
			for (String uri : packages.keySet()) {
				if (uri.equals(nsURI)) {
					return new GenPackageInFileResult(packages.get(nsURI), ecoreFile);
				}
			}
		}
		return null;
	}

	private GenModel reloadGeneratorModel(GenModel genModel) {
		System.out.println("reloadGeneratorModel()");
		if (Platform.isRunning()) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			final URI genModelURI = genModel.eResource().getURI();
			IResource member = workspace.getRoot().findMember(genModelURI.toPlatformString(true));
			if (member instanceof IFile) {
				IFile file = (IFile) member;
				if (!file.isReadOnly()) {
	            	try {
	            		updateGenModel(genModel);
	            		ResourceSet rs = new ResourceSetImpl();
	            		Resource genModelResource = rs.getResource(genModelURI, true);
	        			return (GenModel) genModelResource.getContents().get(0);
	            	} catch (Exception e) {
	            		EMFTextRuntimePlugin.logError("Error while updating genmodel " + file, e);
	            	}
	        	}
			}
		}
		return genModel;
	}

	private void updateGenModel(final GenModel genModel) throws Exception {
        final Resource genModelResource = genModel.eResource();
 
		final boolean reconcileSucceeded = genModel.reconcile();
		if (!reconcileSucceeded) {
			throw new RuntimeException("Reconciliation of genmodel failed.");
		}
        
        final Diagnostic diag = genModel.diagnose();
        if (diag.getSeverity() != Diagnostic.OK) {
        	throw new DiagnosticException(diag);
        }
        
		genModelResource.save(Collections.EMPTY_MAP);
	}

	protected ConcreteSyntax getSyntax(GenPackageDependentElement container) {
		return (ConcreteSyntax) EcoreUtil.getRootContainer(container);
	}
}
