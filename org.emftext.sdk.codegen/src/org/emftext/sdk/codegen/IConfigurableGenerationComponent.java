package org.emftext.sdk.codegen;

/**
 * An interface that allows to configure code generation components.
 * A configuration includes setting an IProblemCollector, which is 
 * used to signal problem encountered during code generation. It also
 * entails setting an IFileSystemConnector, which is used to retrieve
 * the location of projects in the file system.
 */
public interface IConfigurableGenerationComponent {

	public void setProblemCollector(IProblemCollector problemCollector);
	public void setFileSystemConnector(IFileSystemConnector fileSystemConnector);
}
