package org.emftext.sdk.codegen;

/**
 * An interface that must be implemented by all code generation 
 * components. The interface provide access to an IProblemCollector, 
 * which is used to signal problems encountered during code generation. 
 * It also entails a method to obtain an IFileSystemConnector, which 
 * is used to retrieve the location of projects in the file system.
 */
public interface ICodeGenerationComponent {
	
	public IFileSystemConnector getFileSystemConnector();
	
	public IProblemCollector getProblemCollector();
}
