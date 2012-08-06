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
package org.emftext.language.filesystem.resource.physical;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.filesystem.FilesystemFactory;
import org.emftext.language.filesystem.Folder;
import org.emftext.language.filesystem.PlainFile;

public class PhysicalFilesystemResource implements Resource, Resource.Internal {

	private URI uri;
	private org.emftext.language.filesystem.File contentRoot;

	public PhysicalFilesystemResource(URI uri) {
		this.uri = uri;
	}

	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
	}

	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> getContents() {
		BasicEList<EObject> contents = new BasicEList<EObject>(1);
		contents.add(contentRoot);
		return contents;
	}

	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceSet getResourceSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getURIFragment(EObject eObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTrackingModification() {
		// TODO Auto-generated method stub
		return false;
	}

	public void load(Map<?, ?> options) throws IOException {
		String fileString = uri.toFileString();
		System.out.println("PhysicalFilesystemResource.load() " + fileString);
		File file = new File(fileString);
		if (file.isDirectory()) {
			contentRoot = loadContents(file);
		} else {
			contentRoot = loadContent(file);
		}
	}

	private Folder loadContents(File physicalDirectory) {
		Folder directoryObject = FilesystemFactory.eINSTANCE.createFolder();
		directoryObject.setName(physicalDirectory.getName());
		File[] files = physicalDirectory.listFiles();
		for (File file : files) {
			directoryObject.getContents().add(loadContent(file));
		}
		return directoryObject;
	}

	private org.emftext.language.filesystem.File loadContent(File physicalFile) {
		if (physicalFile.isDirectory()) {
			Folder folderObject = FilesystemFactory.eINSTANCE.createFolder();
			folderObject.setName(physicalFile.getName());
			folderObject.getContents().add(loadContents(physicalFile));
			return folderObject;
		} else {
			PlainFile fileObject = FilesystemFactory.eINSTANCE.createPlainFile();
			fileObject.setName(physicalFile.getName());
			return fileObject;
		}
	}

	public void load(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		load(options);
	}

	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public void save(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		// TODO Auto-generated method stub

	}

	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub

	}

	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub

	}

	public void setTrackingModification(boolean isTrackingModification) {
		// TODO Auto-generated method stub

	}

	public void setURI(URI uri) {
		// TODO Auto-generated method stub

	}

	public void unload() {
		// TODO Auto-generated method stub

	}

	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	public void attached(EObject eObject) {
		// TODO Auto-generated method stub

	}

	public NotificationChain basicSetResourceSet(ResourceSet resourceSet,
			NotificationChain notifications) {
		// TODO Auto-generated method stub
		return null;
	}

	public void detached(EObject eObject) {
		// TODO Auto-generated method stub

	}

	public boolean isLoading() {
		// TODO Auto-generated method stub
		return false;
	}

}
