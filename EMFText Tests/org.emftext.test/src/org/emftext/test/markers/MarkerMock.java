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

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class MarkerMock implements IMarker {

	private FileMock fileMock;
	private String type;

	public MarkerMock(FileMock fileMock, String type) {
		this.fileMock = fileMock;
		this.type = type;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() throws CoreException {
		fileMock.getMarkers().remove(this);
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getAttribute(String attributeName) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttribute(String attributeName, int defaultValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAttribute(String attributeName, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAttribute(String attributeName, boolean defaultValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAttributes() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAttributes(String[] attributeNames) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreationTime() throws CoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IResource getResource() {
		return fileMock;
	}

	@Override
	public String getType() throws CoreException {
		return type;
	}

	@Override
	public boolean isSubtypeOf(String superType) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttribute(String attributeName, int value)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttribute(String attributeName, Object value)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttribute(String attributeName, boolean value)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(String[] attributeNames, Object[] values)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(Map<String, ? extends Object> attributes)
			throws CoreException {
		// TODO Auto-generated method stub

	}

}
