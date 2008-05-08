package org.reuseware.emftextedit.codegen;

import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.eclipse.core.resources.IFolder;

/**
 * A resource package provides all information which are needed bye the ResourcePackageGenerator. 
 * This means an resolved concrete syntax, a package name for parser and printer, 
 * a package name for resolvers (proxy and token resolvers) and a resource targetfolder.
 * 
 * @see org.reuseware.emftextedit.codegen.ResourcePackageGenerator
 * @author skarol
 *
 */

public class ResourcePackage {
	
	private ConcreteSyntax csSource;
	private String csPackageName;
	private String resolverPackageName;
	private IFolder targetFolder;
	
	public ResourcePackage(ConcreteSyntax csSource,String csPackageName,IFolder targetFolder){
		if(csSource==null||targetFolder==null)
			throw new NullPointerException("A ConcreteSyntax and an IFolder have to be specified!");
		this.csSource = csSource;
		this.targetFolder = targetFolder;
		this.csPackageName = csPackageName;
		resolverPackageName = (csPackageName==null||csPackageName.equals("")?"":csPackageName+  ".") + "analysis";
	}
	
	/**
	 * @return The concrete syntax to be processed and which is 
	 * assumed to contain all resolved information.
	 */
	public ConcreteSyntax getConcreteSyntax(){
		return csSource;
	}
	
	/**
	 * @return The base package where parser and lexer will go to.
	 */
	public String getCsPackageName(){
		return csPackageName;
	}
	
	/**	 
	 * @return The base package where token and proxy resolvers go to.
	 */
	public String getResolverPackageName(){
		return resolverPackageName;
	}
	
	/**
	 * @return The base folder to which generated packages are printed.
	 */
	public IFolder getTargetFolder(){
		return targetFolder;
	}
	
}
