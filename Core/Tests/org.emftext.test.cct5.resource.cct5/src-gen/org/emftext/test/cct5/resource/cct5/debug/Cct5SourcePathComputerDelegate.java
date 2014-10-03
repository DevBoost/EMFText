/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.emf.common.util.URI;

public class Cct5SourcePathComputerDelegate implements ISourcePathComputerDelegate {
	
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		return new ISourceContainer[] {new ISourceContainer() {
			
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Class adapter) {
				return null;
			}
			
			public boolean isComposite() {
				return false;
			}
			
			public void init(ISourceLookupDirector director) {
				// do nothing
			}
			
			public ISourceContainerType getType() {
				return null;
			}
			
			public ISourceContainer[] getSourceContainers() throws CoreException {
				return new ISourceContainer[0];
			}
			
			public String getName() {
				return "Resource URI";
			}
			
			public Object[] findSourceElements(String name) throws CoreException {
				URI eUri = URI.createURI(name);
				if (eUri.isPlatformResource()) {
					String platformString = eUri.toPlatformString(true);
					return new Object[] {ResourcesPlugin.getWorkspace().getRoot().findMember(platformString)};
				}
				return new Object[0];
			}
			
			public void dispose() {
			}
		}};
	}
	
}
