package org.emftext.sdk.codegen;

public interface IConfigurableGenerationComponent {

	public void setProblemCollector(IProblemCollector problemCollector);
	public void setFileSystemConnector(IFileSystemConnector fileSystemConnector);
}
