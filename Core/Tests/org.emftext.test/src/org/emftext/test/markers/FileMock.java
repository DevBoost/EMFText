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
package org.emftext.test.markers;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

public class FileMock implements IFile {

	private List<MarkerMock> markers = new ArrayList<MarkerMock>();

	@Override
	public void accept(IResourceProxyVisitor visitor, int memberFlags)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void accept(IResourceVisitor visitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void accept(IResourceVisitor visitor, int depth,
			boolean includePhantoms) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void accept(IResourceVisitor visitor, int depth, int memberFlags)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void clearHistory(IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void copy(IPath destination, boolean force, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void copy(IPath destination, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void copy(IProjectDescription description, boolean force,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void copy(IProjectDescription description, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public IMarker createMarker(String type) throws CoreException {
		MarkerMock newMarker = new MarkerMock(this, type);
		markers.add(newMarker);
		return newMarker;
	}

	@Override
	public IResourceProxy createProxy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(boolean force, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void delete(int updateFlags, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void deleteMarkers(String type, boolean includeSubtypes, int depth)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean exists() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IMarker findMarker(long id) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IMarker[] findMarkers(String type, boolean includeSubtypes, int depth)
			throws CoreException {
		
		List<IMarker> found = new ArrayList<IMarker>();
		for (IMarker next : markers) {
			if (next.getType().equals(type)) {
				found.add(next);
			}
		}
		return found.toArray(new IMarker[found.size()]);
	}

	@Override
	public int findMaxProblemSeverity(String type, boolean includeSubtypes,
			int depth) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getFileExtension() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getLocalTimeStamp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPath getLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getLocationURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IMarker getMarker(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getModificationStamp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPathVariableManager getPathVariableManager() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IContainer getParent() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<QualifiedName, String> getPersistentProperties()
			throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getPersistentProperty(QualifiedName key) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IProject getProject() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPath getProjectRelativePath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPath getRawLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getRawLocationURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ResourceAttributes getResourceAttributes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<QualifiedName, Object> getSessionProperties()
			throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getSessionProperty(QualifiedName key) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IWorkspace getWorkspace() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAccessible() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDerived() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDerived(int options) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isHidden() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isHidden(int options) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLinked() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isVirtual() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLinked(int options) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLocal(int depth) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPhantom() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSynchronized(int depth) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTeamPrivateMember() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTeamPrivateMember(int options) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void move(IPath destination, boolean force, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void move(IPath destination, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void move(IProjectDescription description, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void move(IProjectDescription description, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void refreshLocal(int depth, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void revertModificationStamp(long value) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setDerived(boolean isDerived) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setDerived(boolean isDerived, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setHidden(boolean isHidden) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setLocal(boolean flag, int depth, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public long setLocalTimeStamp(long value) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPersistentProperty(QualifiedName key, String value)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setReadOnly(boolean readOnly) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setResourceAttributes(ResourceAttributes attributes)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setSessionProperty(QualifiedName key, Object value)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setTeamPrivateMember(boolean isTeamPrivate)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void touch(IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(ISchedulingRule rule) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void appendContents(InputStream source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void appendContents(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void create(InputStream source, boolean force,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void create(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void createLink(IPath localLocation, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void createLink(URI location, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void delete(boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public String getCharset() throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCharset(boolean checkImplicit) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCharsetFor(Reader reader) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IContentDescription getContentDescription() throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputStream getContents() throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputStream getContents(boolean force) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getEncoding() throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPath getFullPath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IFileState[] getHistory(IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void move(IPath destination, boolean force, boolean keepHistory,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setCharset(String newCharset) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setCharset(String newCharset, IProgressMonitor monitor)
			throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setContents(InputStream source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setContents(IFileState source, boolean force,
			boolean keepHistory, IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setContents(InputStream source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setContents(IFileState source, int updateFlags,
			IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException();

	}

	public void accept(IResourceProxyVisitor visitor, int depth, int memberFlags)
			throws CoreException {
		// this method was introduced in Eclipse 3.8/4.2	
	}

	public List<MarkerMock> getMarkers() {
		return markers;
	}
}
