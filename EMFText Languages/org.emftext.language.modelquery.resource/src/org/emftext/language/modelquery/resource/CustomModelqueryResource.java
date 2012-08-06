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
package org.emftext.language.modelquery.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.emftext.language.modelquery.ModelQuery;
import org.emftext.language.modelquery.resource.modelquery.ModelqueryEProblemType;
import org.emftext.language.modelquery.resource.modelquery.mopp.ModelqueryResource;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.index.notify.IndexListener;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.ResourceUtil;

public class CustomModelqueryResource extends ModelqueryResource {
	
	IndexListener indexListener = null;
	
	public CustomModelqueryResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		indexListener = new CustomModelqueryResourceIndexListener(this);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		executeQuery();
		IndexUtil.INSTANCE.addListener(indexListener);
	}
	
	protected void doUnload() {
		IndexUtil.INSTANCE.removeListener(indexListener);
		super.doUnload();
	}
	

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		super.doSave(outputStream, options);
		if (contents.isEmpty() || !(contents.get(0) instanceof ModelQuery)) {
			return;
		}
		ModelQuery modelQuery = (ModelQuery) contents.get(0);
		
		ID myID = ResourceUtil.idFrom(getURI());
		if (myID == null) {
			this.addError("To save a modelquery it must reside in a Sokan store", 
					ModelqueryEProblemType.ANALYSIS_PROBLEM,
					modelQuery);
			return;
		}
		
		final Copier copier = new Copier();
		final TransactionalEditingDomain eDomain = 
			TransactionUtil.getEditingDomain(this);
		
		Iterator<String>  idIterator = modelQuery.getResultIDs().iterator();
		Iterator<EObject> contentsIterator = contents.iterator();
		contentsIterator.next();
		
		Set<Resource> modifiedResources = new LinkedHashSet<Resource>();
		
		while(idIterator.hasNext() && contentsIterator.hasNext()) {
			String idString = idIterator.next();
			ID id = ResourceUtil.idFrom(idString);
			EObject root = contentsIterator.next();
			
			URI modelURI = null;
			
			if (idString.startsWith("/")) {
				modelURI = getURI().trimSegments(myID.getSegments().size()).appendSegments(
						id.getSegments().toArray(new String[id.getSegments().size()]));
			}
			else {
				//relative
				modelURI = getURI().trimSegments(1).appendSegments(
						id.getSegments().toArray(new String[id.getSegments().size()]));
			}
			if (modelURI == null) {
				continue;
			}
			
			Resource modelResource = getResourceSet().getResource(modelURI, false);
			if (modelResource == null) {
				modelResource = getResourceSet().createResource(modelURI);
			}
			else if (!modifiedResources.contains(modelResource)){
				modelResource.unload();
				modelResource.getContents().clear();
			}
			modifiedResources.add(modelResource);
			final EObject rootCopy = copier.copy(root);
			
			if (eDomain != null) {
				final Resource resourceToModify = modelResource;
				eDomain.getCommandStack().execute(new RecordingCommand(eDomain) {	
					@Override
					protected void doExecute() {
						resourceToModify.getContents().add(rootCopy);
					}
				});
			}
			else {
				modelResource.getContents().add(rootCopy);
			}
		}
		
		if (eDomain != null) {
			eDomain.getCommandStack().execute(new RecordingCommand(eDomain) {	
				@Override
				protected void doExecute() {
					copier.copyReferences();
				}
			});
		}
		else {
			copier.copyReferences();
		}
		
		for(Resource toSave : modifiedResources) {
			toSave.save(getResourceSet().getLoadOptions());
			IndexUtil.INSTANCE.addArtifact(toSave.getURI());
		}
	}
	
	public void executeQuery() {
		if (contents.isEmpty() || !(contents.get(0) instanceof ModelQuery)) {
			return;
		}

		final ModelQuery modelQuery = (ModelQuery) contents.get(0);
		final Map<EObject, String> result = new LinkedHashMap<EObject, String>();
		final Copier copier = new Copier();
		final TransactionalEditingDomain eDomain = 
			TransactionUtil.getEditingDomain(this);
		
		String baseString = "";
		for(String queryString : ((ModelQuery) modelQuery).getQueries()) {
			if (!queryString.startsWith("/")) {
				//relative
				ID myID = ResourceUtil.idFrom(getURI());
				if (myID == null) {
					this.addError("A relative modelquery must reside in a Sokan store",
							ModelqueryEProblemType.ANALYSIS_PROBLEM,
							modelQuery);
					return;
				}
				baseString = computeBaseID(myID);
				queryString = baseString + queryString;
			}
			else {
				baseString = "";
			}
			
			try {
				Pattern pattern = Pattern.compile(queryString);
				
				for (IndexRow row : IndexUtil.INSTANCE.getIndex()) {
					String id = ResourceUtil.idString(row.getArtifactID());
					Matcher m = pattern.matcher(id);
					if (m.matches()) {
						try {
							Resource foundResource = getResourceSet().getResource(
									URI.createURI(row.getPhyURI()), true);
							for(EObject copy : copier.copyAll(foundResource.getContents())) {
								String relativeID = id.substring(baseString.length(), id.length());
								result.put(copy, relativeID);
							}		
						} catch (Exception e) { }
					}
				}
			}
			catch (PatternSyntaxException pse) {
				this.addError("Not a correct query: " + queryString, 
						ModelqueryEProblemType.ANALYSIS_PROBLEM,
						modelQuery);
			}
		}
		
		copier.copyReferences();
		
		if (eDomain != null) {
			eDomain.getCommandStack().execute(new RecordingCommand(eDomain) {	
				@Override
				protected void doExecute() {
					contents.clear();
					contents.add(modelQuery);
					for(EObject copy : result.keySet()) {
						contents.add(copy);
						modelQuery.getResultIDs().add(result.get(copy));
					}
				}
			});
		}
		else {
			contents.clear();
			contents.add(modelQuery);
			for(EObject copy : result.keySet()) {
				contents.add(copy);
				modelQuery.getResultIDs().add(result.get(copy));
			}
		}
	}
	
	private String computeBaseID(ID myID) {
		String baseString;
		List<String> base = new ArrayList<String>(myID.getSegments());
		base.remove(base.size()-1);
		baseString = ResourceUtil.idString(base) + "/";
		return baseString;
	}
}
