/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;


public abstract class AbstractGenerationContext<ContextType> implements IContext<ContextType> {

	private final IFileSystemConnector fileSystemConnector;
	private final IProblemCollector problemCollector;
	
	public AbstractGenerationContext(IFileSystemConnector fileSystemConnector,
			IProblemCollector problemCollector) {
		super();
		if (fileSystemConnector == null) {
			throw new IllegalArgumentException("fileSystemConnector must not be null.");
		}
		this.fileSystemConnector = fileSystemConnector;
		if (problemCollector == null) {
			throw new IllegalArgumentException("problemCollector must not be null.");
		}
		this.problemCollector = problemCollector;
	}

	public IFileSystemConnector getFileSystemConnector() {
		return fileSystemConnector;
	}

	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
}
