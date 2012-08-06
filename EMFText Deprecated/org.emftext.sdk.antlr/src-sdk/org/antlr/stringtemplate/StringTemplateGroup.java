/*
 [The "BSD licence"]
 Copyright (c) 2003-2005 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.stringtemplate;

import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.antlr.stringtemplate.language.GroupLexer;
import org.antlr.stringtemplate.language.GroupParser;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

import java.util.*;
import java.io.*;
import java.lang.reflect.Constructor;

/** Manages a group of named mutually-referential StringTemplate objects.
 *  Currently the templates must all live under a directory so that you
 *  can reference them as foo.st or gutter/header.st.  To refresh a
 *  group of templates, just create a new StringTemplateGroup and start
 *  pulling templates from there.  Or, set the refresh interval.
 *
 *  Use getInstanceOf(template-name) to get a string template
 *  to fill in.
 *
 *  The name of a template is the file name minus ".st" ending if present
 *  unless you name it as you load it.
 *
 *  You can use the group file format also to define a group of templates
 *  (this works better for code gen than for html page gen).  You must give
 *  a Reader to the ctor for it to load the group; this is general and
 *  distinguishes it from the ctors for the old-style "load template files
 *  from the disk".
 *
 *  10/2005 I am adding a StringTemplateGroupLoader concept so people can define supergroups
 *  within a group and have it load that group automatically.
 */
public class StringTemplateGroup {
	/** What is the group name */
	protected String name;

	/** Maps template name to StringTemplate object */
	protected Map templates = new HashMap();

	/** Maps map names to HashMap objects.  This is the list of maps
	 *  defined by the user like typeInitMap ::= ["int":"0"]
	 */
	protected Map maps = new HashMap();

	/** How to pull apart a template into chunks? */
	protected Class templateLexerClass = null;

	/** You can set the lexer once if you know all of your groups use the
	 *  same separator.  If the instance has templateLexerClass set
	 *  then it is used as an override.
	 */
	protected static Class defaultTemplateLexerClass = DefaultTemplateLexer.class;

	/** Under what directory should I look for templates?  If null,
	 *  to look into the CLASSPATH for templates as resources.
	 */
	protected String rootDir = null;

	/** Track all groups by name; maps name to StringTemplateGroup */
	protected static Map nameToGroupMap = Collections.synchronizedMap(new HashMap());

	/** Track all interfaces by name; maps name to StringTemplateGroupInterface */
	protected static Map nameToInterfaceMap = Collections.synchronizedMap(new HashMap());

	/** Are we derived from another group?  Templates not found in this group
	 *  will be searched for in the superGroup recursively.
	 */
	protected StringTemplateGroup superGroup = null;

	/** Keep track of all interfaces implemented by this group. */
	protected List interfaces = null;

	/** When templates are files on the disk, the refresh interval is used
	 *  to know when to reload.  When a Reader is passed to the ctor,
	 *  it is a stream full of template definitions.  The former is used
	 *  for web development, but the latter is most likely used for source
	 *  code generation for translators; a refresh is unlikely.  Anyway,
	 *  I decided to track the source of templates in case such info is useful
	 *  in other situations than just turning off refresh interval.  I just
	 *  found another: don't ever look on the disk for individual templates
	 *  if this group is a group file...immediately look into any super group.
	 *  If not in the super group, report no such template.
	 */
	protected boolean templatesDefinedInGroupFile = false;

	/** Normally AutoIndentWriter is used to filter output, but user can
	 *  specify a new one.
	 */
	protected Class userSpecifiedWriter;

	protected boolean debugTemplateOutput = false;

	/** The set of templates to ignore when dumping start/stop debug strings */
	protected Set noDebugStartStopStrings;

	/** A Map<Class,Object> that allows people to register a renderer for
	 *  a particular kind of object to be displayed for any template in this
	 *  group.  For example, a date should be formatted differently depending
	 *  on the locale.  You can set Date.class to an object whose
	 *  toString(Object) method properly formats a Date attribute
	 *  according to locale.  Or you can have a different renderer object
	 *  for each locale.
	 *
	 *  These render objects are used way down in the evaluation chain
	 *  right before an attribute's toString() method would normally be
	 *  called in ASTExpr.write().
	 *
	 *  Synchronized at creation time.
	 */
	protected Map attributeRenderers;

	/** Maps obj.prop to a value to avoid reflection costs; track one
	 *  set of all class.property -> Member mappings for all ST usage in VM.
	protected static Map classPropertyCache = new HashMap();

	public static class ClassPropCacheKey {
		Class c;
		String propertyName;
		public ClassPropCacheKey(Class c, String propertyName) {
			this.c=c;
			this.propertyName=propertyName;
		}

		public boolean equals(Object other) {
			ClassPropCacheKey otherKey = (ClassPropCacheKey)other;
			return c.equals(otherKey.c) &&
				propertyName.equals(otherKey.propertyName);
		}

		public int hashCode() {
			return c.hashCode()+propertyName.hashCode();
		}
	}
	 */

	/** If a group file indicates it derives from a supergroup, how do we
	 *  find it?  Shall we make it so the initial StringTemplateGroup file
	 *  can be loaded via this loader?  Right now we pass a Reader to ctor
	 *  to distinguish from the other variety.
	 */
	private static StringTemplateGroupLoader groupLoader = null;

	/** Where to report errors.  All string templates in this group
	 *  use this error handler by default.
	 */
	protected StringTemplateErrorListener listener = DEFAULT_ERROR_LISTENER;

	public static StringTemplateErrorListener DEFAULT_ERROR_LISTENER =
		new StringTemplateErrorListener() {
			public void error(String s, Throwable e) {
				System.err.println(s);
				if ( e!=null ) {
					e.printStackTrace(System.err);
				}
			}
			public void warning(String s) {
				System.out.println(s);
			}
		};

	/** Used to indicate that the template doesn't exist.
	 *  We don't have to check disk for it; we know it's not there.
	 */
	protected static final StringTemplate NOT_FOUND_ST =
		new StringTemplate();

	/** How long before tossing out all templates in seconds. */
	protected int refreshIntervalInSeconds = Integer.MAX_VALUE/1000; // default: no refreshing from disk
	protected long lastCheckedDisk = 0L;

	/** How are the files encoded (ascii, UTF8, ...)?  You might want to read
	 *  UTF8 for example on an ascii machine.
	 */
	String fileCharEncoding = System.getProperty("file.encoding");

	/** Create a group manager for some templates, all of which are
	 *  at or below the indicated directory.
	 */
	public StringTemplateGroup(String name, String rootDir) {
		this(name,rootDir,DefaultTemplateLexer.class);
	}

	public StringTemplateGroup(String name, String rootDir, Class lexer) {
		this.name = name;
		this.rootDir = rootDir;
		lastCheckedDisk = System.currentTimeMillis();
		nameToGroupMap.put(name, this);
		this.templateLexerClass = lexer;
	}

	/** Create a group manager for some templates, all of which are
	 *  loaded as resources via the classloader.
	 */
	public StringTemplateGroup(String name) {
		this(name,null,null);
	}

	public StringTemplateGroup(String name, Class lexer) {
		this(name,null,lexer);
	}

	/** Create a group from the template group defined by a input stream.
	 *  The name is pulled from the file.  The format is
	 *
	 *  group name;
	 *
	 *  t1(args) ::= "..."
	 *  t2() ::= <<
	 *  >>
	 *  ...
	 */
	public StringTemplateGroup(Reader r) {
		this(r,AngleBracketTemplateLexer.class,DEFAULT_ERROR_LISTENER,(StringTemplateGroup)null);
	}

	public StringTemplateGroup(Reader r, StringTemplateErrorListener errors) {
		this(r,AngleBracketTemplateLexer.class,errors,(StringTemplateGroup)null);
	}

	public StringTemplateGroup(Reader r, Class lexer) {
		this(r,lexer,null,(StringTemplateGroup)null);
	}

	public StringTemplateGroup(Reader r, Class lexer, StringTemplateErrorListener errors) {
		this(r,lexer,errors,(StringTemplateGroup)null);
	}

	/** Create a group from the input stream, but use a nondefault lexer
	 *  to break the templates up into chunks.  This is usefor changing
	 *  the delimiter from the default $...$ to <...>, for example.
	 */
	public StringTemplateGroup(Reader r,
							   Class lexer,
							   StringTemplateErrorListener errors,
							   StringTemplateGroup superGroup)
	{
		this.templatesDefinedInGroupFile = true;
		// if no lexer specified, then assume <...> when loading from group file
		if ( lexer==null ) {
			lexer = AngleBracketTemplateLexer.class;
		}
		this.templateLexerClass = lexer;
		if ( errors!=null ) { // always have to have a listener
			this.listener = errors;
		}
		setSuperGroup(superGroup);
		parseGroup(r);
		nameToGroupMap.put(name, this);
		verifyInterfaceImplementations();
	}

	/** What lexer class to use to break up templates.  If not lexer set
	 *  for this group, use static default.
	 */
	public Class getTemplateLexerClass() {
		if ( templateLexerClass!=null ) {
			return templateLexerClass;
		}
		return defaultTemplateLexerClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSuperGroup(StringTemplateGroup superGroup) {
		this.superGroup = superGroup;
	}

	/** Called by group parser when ": supergroupname" is found.
	 *  This method forces the supergroup's lexer to be same as lexer
	 *  for this (sub) group.
	 */
	public void setSuperGroup(String superGroupName) {
		StringTemplateGroup superGroup =
			(StringTemplateGroup)nameToGroupMap.get(superGroupName);
		if ( superGroup !=null ) { // we've seen before; just use it
			setSuperGroup(superGroup);
			return;
		}
		// else load it using this group's template lexer
		superGroup = loadGroup(superGroupName, this.templateLexerClass, null);
		if ( superGroup !=null ) {
			nameToGroupMap.put(superGroupName, superGroup);
			setSuperGroup(superGroup);
		}
		else {
			if ( groupLoader==null ) {
				listener.error("no group loader registered", null);
			}
		}
	}

	/** Just track the new interface; check later.  Allows dups, but no biggie. */
	public void implementInterface(StringTemplateGroupInterface I) {
		if ( interfaces==null ) {
			interfaces = new ArrayList();
		}
		interfaces.add(I);
	}

	/** Indicate that this group implements this interface; load if necessary
	 *  if not in the nameToInterfaceMap.
	 */
	public void implementInterface(String interfaceName) {
		StringTemplateGroupInterface I =
			(StringTemplateGroupInterface)nameToInterfaceMap.get(interfaceName);
		if ( I!=null ) { // we've seen before; just use it
			implementInterface(I);
			return;
		}
		I = loadInterface(interfaceName); // else load it
		if ( I!=null ) {
			nameToInterfaceMap.put(interfaceName, I);
			implementInterface(I);
		}
		else {
			if ( groupLoader==null ) {
				listener.error("no group loader registered", null);
			}
		}
	}

	public StringTemplateGroup getSuperGroup() {
		return superGroup;
	}

	/** Walk up group hierarchy and show top down to this group */
	public String getGroupHierarchyStackString() {
		List groupNames = new LinkedList();
		StringTemplateGroup p = this;
		while ( p!=null ) {
			groupNames.add(0,p.name);
			p = p.superGroup;
		}
		return groupNames.toString().replaceAll(",","");
	}

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	/** StringTemplate object factory; each group can have its own. */
	public StringTemplate createStringTemplate() {
		StringTemplate st = new StringTemplate();
		return st;
	}

	/** A support routine that gets an instance of name knowing which
	 *  ST encloses it for error messages.
	 */
	protected StringTemplate getInstanceOf(StringTemplate enclosingInstance,
										   String name)
		throws IllegalArgumentException
	{
		//System.out.println("getInstanceOf("+getName()+"::"+name+")");
		StringTemplate st = lookupTemplate(enclosingInstance,name);
		if ( st!=null ) {
			StringTemplate instanceST = st.getInstanceOf();
			return instanceST;
		}
		return null;
	}

	/** The primary means of getting an instance of a template from this
	 *  group.
	 */
	public StringTemplate getInstanceOf(String name) {
		return getInstanceOf(null, name);
	}

	/** The primary means of getting an instance of a template from this
	 *  group when you have a predefined set of attributes you want to
	 *  use.
	 */
	public StringTemplate getInstanceOf(String name, Map attributes) {
		StringTemplate st = getInstanceOf(name);
		st.attributes = attributes;
		return st;
	}

	public StringTemplate getEmbeddedInstanceOf(StringTemplate enclosingInstance,
												String name)
		throws IllegalArgumentException
	{
		/*
		System.out.println("surrounding group is "+
						   enclosingInstance.getGroup().getName()+
						   " with native group "+enclosingInstance.getNativeGroup().getName());
						   */
		StringTemplate st = null;
		// TODO: seems like this should go into lookupTemplate
		if ( name.startsWith("super.") ) {
			// for super.foo() refs, ensure that we look at the native
			// group for the embedded instance not the current evaluation
			// group (which is always pulled down to the original group
			// from which somebody did group.getInstanceOf("foo");
			st = enclosingInstance.getNativeGroup().getInstanceOf(enclosingInstance, name);
		}
		else {
			st = getInstanceOf(enclosingInstance, name);
		}
		// make sure all embedded templates have the same group as enclosing
		// so that polymorphic refs will start looking at the original group
		st.setGroup(this);
		st.setEnclosingInstance(enclosingInstance);
		return st;
	}

	/** Get the template called 'name' from the group.  If not found,
	 *  attempt to load.  If not found on disk, then try the superGroup
	 *  if any.  If not even there, then record that it's
	 *  NOT_FOUND so we don't waste time looking again later.  If we've gone
	 *  past refresh interval, flush and look again.
	 *
	 *  If I find a template in a super group, copy an instance down here
	 */
	public synchronized StringTemplate lookupTemplate(StringTemplate enclosingInstance,
													  String name)
		throws IllegalArgumentException
	{
		//System.out.println("look up "+getName()+"::"+name);
		if ( name.startsWith("super.") ) {
			if ( superGroup!=null ) {
				int dot = name.indexOf('.');
				name = name.substring(dot+1,name.length());
				StringTemplate superScopeST =
					superGroup.lookupTemplate(enclosingInstance,name);
				/*
				System.out.println("superScopeST is "+
								   superScopeST.getGroup().getName()+"::"+name+
								   " with native group "+superScopeST.getNativeGroup().getName());
				*/
				return superScopeST;
			}
			throw new IllegalArgumentException(getName()+
											   " has no super group; invalid template: "+name);
		}
		checkRefreshInterval();
		StringTemplate st = (StringTemplate)templates.get(name);
		if ( st==null ) {
			// not there?  Attempt to load
			if ( !templatesDefinedInGroupFile ) {
				// only check the disk for individual template
				st = loadTemplateFromBeneathRootDirOrCLASSPATH(getFileNameFromTemplateName(name));
			}
			if ( st==null && superGroup!=null ) {
				// try to resolve in super group
				st = superGroup.getInstanceOf(name);
				// make sure that when we inherit a template, that it's
				// group is reset; it's nativeGroup will remain where it was
				if ( st!=null ) {
					st.setGroup(this);
				}
			}
			if ( st!=null ) { // found in superGroup
				// insert into this group; refresh will allow super
				// to change it's def later or this group to add
				// an override.
				templates.put(name, st);
			}
			else {
				// not found; remember that this sucker doesn't exist
				templates.put(name, NOT_FOUND_ST);
				String context = "";
				if ( enclosingInstance!=null ) {
					context = "; context is "+
							  enclosingInstance.getEnclosingInstanceStackString();
				}
				String hier = getGroupHierarchyStackString();
				context += "; group hierarchy is "+hier;
				throw new IllegalArgumentException("Can't find template "+
												   getFileNameFromTemplateName(name)+
												   context);
			}
		}
		else if ( st==NOT_FOUND_ST ) {
			return null;
		}
		//System.out.println("lookup found "+st.getGroup().getName()+"::"+st.getName());
		return st;
	}

	public StringTemplate lookupTemplate(String name) {
		return lookupTemplate(null, name);
	}

	protected void checkRefreshInterval() {
		if ( templatesDefinedInGroupFile ) {
			return;
		}
		boolean timeToFlush=refreshIntervalInSeconds==0 ||
							(System.currentTimeMillis()-lastCheckedDisk)>=refreshIntervalInSeconds*1000;
		if ( timeToFlush ) {
			// throw away all pre-compiled references
			templates.clear();
			lastCheckedDisk = System.currentTimeMillis();
		}
	}

	protected StringTemplate loadTemplate(String name, BufferedReader r)
			throws IOException
	{
		String line;
		String nl = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer(300);
		while ((line = r.readLine()) != null) {
			buf.append(line);
			buf.append(nl);
		}
		// strip newlines etc.. from front/back since filesystem
		// may add newlines etc...
		String pattern = buf.toString().trim();
		if ( pattern.length()==0 ) {
			error("no text in template '"+name+"'");
			return null;
		}
		return defineTemplate(name, pattern);
	}

	/** Load a template whose name is derived from the template filename.
	 *  If there is no root directory, try to load the template from
	 *  the classpath.  If there is a rootDir, try to load the file
	 *  from there.
	 */
	protected StringTemplate loadTemplateFromBeneathRootDirOrCLASSPATH(String fileName)
	{
		StringTemplate template = null;
		String name = getTemplateNameFromFileName(fileName);
		// if no rootDir, try to load as a resource in CLASSPATH
		if ( rootDir==null ) {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream is = cl.getResourceAsStream(fileName);
			if ( is==null ) {
				cl = this.getClass().getClassLoader();
				is = cl.getResourceAsStream(fileName);
			}
			if ( is==null ) {
				return null;
			}
			BufferedReader br = null;
			try {
				br = new BufferedReader(getInputStreamReader(is));
				template = loadTemplate(name, br);
			}
			catch (IOException ioe) {
				error("Problem reading template file: "+fileName,ioe);
			}
			finally {
				if ( br!=null ) {
					try {
						br.close();
					}
					catch (IOException ioe2) {
						error("Cannot close template file: "+fileName, ioe2);
					}
				}
			}
			return template;
		}
		// load via rootDir
		template = loadTemplate(name, rootDir+"/"+fileName);
		return template;
	}

	/** (public so that people can override behavior; not a general
	 *  purpose method)
	 */
	public String getFileNameFromTemplateName(String templateName) {
		return templateName+".st";
	}

	/** Convert a filename relativePath/name.st to relativePath/name.
	 *  (public so that people can override behavior; not a general
	 *  purpose method)
	 */
	public String getTemplateNameFromFileName(String fileName) {
		String name = fileName;
		int suffix = name.lastIndexOf(".st");
		if ( suffix>=0 ) {
			name = name.substring(0, suffix);
		}
		return name;
	}

	protected StringTemplate loadTemplate(String name, String fileName)
	{
		BufferedReader br = null;
		StringTemplate template = null;
		try {
			InputStream fin = new FileInputStream(fileName);
			InputStreamReader isr = getInputStreamReader(fin);
			br = new BufferedReader(isr);
			template = loadTemplate(name, br);
			br.close();
			br = null;
		}
		catch (IOException ioe) {
			if ( br!=null ) {
				try {
					br.close();
				}
				catch (IOException ioe2) {
					error("Cannot close template file: "+fileName);
				}
			}
		}
		return template;
	}

	protected InputStreamReader getInputStreamReader(InputStream in) {
		InputStreamReader isr = null;
		try {
			 isr = new InputStreamReader(in, fileCharEncoding);
		}
		catch (UnsupportedEncodingException uee) {
			error("Invalid file character encoding: "+fileCharEncoding);
		}
		return isr;
	}

	public String getFileCharEncoding() {
		return fileCharEncoding;
	}

	public void setFileCharEncoding(String fileCharEncoding) {
		this.fileCharEncoding = fileCharEncoding;
	}

	/** Define an examplar template; precompiled and stored
	 *  with no attributes.  Remove any previous definition.
	 */
	public synchronized StringTemplate defineTemplate(String name,
													  String template)
	{
		//System.out.println("defineTemplate "+getName()+"::"+name);
		if ( name!=null && name.indexOf('.')>=0 ) {
			throw new IllegalArgumentException("cannot have '.' in template names");
		}
		StringTemplate st = createStringTemplate();
		st.setName(name);
		st.setGroup(this);
		st.setNativeGroup(this);
		st.setTemplate(template);
		st.setErrorListener(listener);
		templates.put(name, st);
		return st;
	}

	/** Track all references to regions <@foo>...<@end> or <@foo()>.  */
	public StringTemplate defineRegionTemplate(String enclosingTemplateName,
											   String regionName,
											   String template,
											   int type)
	{
		String mangledName =
			getMangledRegionName(enclosingTemplateName,regionName);
		StringTemplate regionST = defineTemplate(mangledName, template);
		regionST.setIsRegion(true);
		regionST.setRegionDefType(type);
		return regionST;
	}

	/** Track all references to regions <@foo>...<@end> or <@foo()>.  */
	public StringTemplate defineRegionTemplate(StringTemplate enclosingTemplate,
											   String regionName,
											   String template,
											   int type)
	{
		StringTemplate regionST =
			defineRegionTemplate(enclosingTemplate.getOutermostName(),
								 regionName,
								 template,
								 type);
		enclosingTemplate.getOutermostEnclosingInstance().addRegionName(regionName);
		return regionST;
	}

	/** Track all references to regions <@foo()>.  We automatically
	 *  define as
	 *
	 *     @enclosingtemplate.foo() ::= ""
	 *
	 *  You cannot set these manually in the same group; you have to subgroup
	 *  to override.
	 */
	public StringTemplate defineImplicitRegionTemplate(StringTemplate enclosingTemplate,
													   String name)
	{
		return defineRegionTemplate(enclosingTemplate,
									name,
									"",
									StringTemplate.REGION_IMPLICIT);

	}

	/** The "foo" of t() ::= "<@foo()>" is mangled to "region#t#foo" */
	public String getMangledRegionName(String enclosingTemplateName,
									   String name)
	{
		return "region__"+enclosingTemplateName+"__"+name;
	}

	/** Return "t" from "region__t__foo" */
	public String getUnMangledTemplateName(String mangledName)
	{
		return mangledName.substring("region__".length(),
									 mangledName.lastIndexOf("__"));
	}

	/** Make name and alias for target.  Replace any previous def of name */
	public synchronized StringTemplate defineTemplateAlias(String name, String target) {
		StringTemplate targetST=getTemplateDefinition(target);
		if ( targetST==null ){
			error("cannot alias "+name+" to undefined template: "+target);
			return null;
		}
		templates.put(name, targetST);
		return targetST;
	}

	public synchronized boolean isDefinedInThisGroup(String name) {
		StringTemplate st = (StringTemplate)templates.get(name);
		if ( st!=null ) {
			if ( st.isRegion() ) {
				// don't allow redef of @t.r() ::= "..." or <@r>...<@end>
				if ( st.getRegionDefType()==StringTemplate.REGION_IMPLICIT ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/** Get the ST for 'name' in this group only */
	public synchronized StringTemplate getTemplateDefinition(String name) {
		return (StringTemplate)templates.get(name);
	}

	/** Is there *any* definition for template 'name' in this template
	 *  or above it in the group hierarchy?
	 */
	public boolean isDefined(String name) {
		try {
			return lookupTemplate(name)!=null;
		}
		catch (IllegalArgumentException iae) {
			return false;
		}
	}

	protected void parseGroup(Reader r) {
		try {
			GroupLexer lexer = new GroupLexer(r);
			GroupParser parser = new GroupParser(lexer);
			parser.group(this);
			//System.out.println("read group\n"+this.toString());
		}
		catch (Exception e) {
			String name = "<unknown>";
			if ( getName()!=null ) {
				name = getName();
			}
			error("problem parsing group "+name+": "+e, e);
		}
	}

	/** verify that this group satisfies its interfaces */
	protected void verifyInterfaceImplementations() {
		for (int i = 0; interfaces!=null && i < interfaces.size(); i++) {
			StringTemplateGroupInterface I =
				(StringTemplateGroupInterface)interfaces.get(i);
			List missing = I.getMissingTemplates(this);
			List mismatched = I.getMismatchedTemplates(this);
			if ( missing!=null ) {
				error("group "+getName()+" does not satisfy interface "+
					  I.getName()+": missing templates "+missing);
			}
			if ( mismatched!=null ) {
				error("group "+getName()+" does not satisfy interface "+
					  I.getName()+": mismatched arguments on these templates "+mismatched);
			}
		}
	}

	public int getRefreshInterval() {
		return refreshIntervalInSeconds;
	}

	/** How often to refresh all templates from disk.  This is a crude
	 *  mechanism at the moment--just tosses everything out at this
	 *  frequency.  Set interval to 0 to refresh constantly (no caching).
	 *  Set interval to a huge number like MAX_INT to have no refreshing
	 *  at all (DEFAULT); it will cache stuff.
	 */
	public void setRefreshInterval(int refreshInterval) {
		this.refreshIntervalInSeconds = refreshInterval;
	}

	public void setErrorListener(StringTemplateErrorListener listener) {
		this.listener = listener;
	}

	public StringTemplateErrorListener getErrorListener() {
		return listener;
	}

	/** Specify a StringTemplateWriter implementing class to use for
	 *  filtering output
	 */
	public void setStringTemplateWriter(Class c) {
		userSpecifiedWriter = c;
	}

	/** return an instance of a StringTemplateWriter that spits output to w.
	 *  If a writer is specified, use it instead of the default.
	 */
	public StringTemplateWriter getStringTemplateWriter(Writer w) {
		StringTemplateWriter stw = null;
		if ( userSpecifiedWriter!=null ) {
			try {
				Constructor ctor =
					userSpecifiedWriter.getConstructor(new Class[] {Writer.class});
				stw = (StringTemplateWriter) ctor.newInstance(new Object[] {w});
			}
			catch (Exception e) {
				error("problems getting StringTemplateWriter",e);
			}
		}
		if ( stw==null ) {
			stw = new AutoIndentWriter(w);
		}
		return stw;
	}

	/** Specify a complete map of what object classes should map to which
	 *  renderer objects for every template in this group (that doesn't
	 *  override it per template).
	 */
	public void setAttributeRenderers(Map renderers) {
		this.attributeRenderers = renderers;
	}

	/** Register a renderer for all objects of a particular type for all
	 *  templates in this group.
	 */
	public void registerRenderer(Class attributeClassType, Object renderer) {
		if ( attributeRenderers==null ) {
			attributeRenderers = Collections.synchronizedMap(new HashMap());
		}
		attributeRenderers.put(attributeClassType, renderer);
	}

	/** What renderer is registered for this attributeClassType for
	 *  this group?  If not found, as superGroup if it has one.
	 */
	public AttributeRenderer getAttributeRenderer(Class attributeClassType) {
		if ( attributeRenderers==null ) {
			if ( superGroup==null ) {
				return null; // no renderers and no parent?  Stop.
			}
			// no renderers; consult super group
			return superGroup.getAttributeRenderer(attributeClassType);
		}

		AttributeRenderer renderer =
			(AttributeRenderer)attributeRenderers.get(attributeClassType);
		if ( renderer==null ) {
			if ( superGroup!=null ) {
				// no renderer registered for this class, check super group
				renderer = superGroup.getAttributeRenderer(attributeClassType);
			}
		}
		return renderer;
	}

	/*
	public void cacheClassProperty(Class c, String propertyName, Member member) {
		Object key = new ClassPropCacheKey(c,propertyName);
		classPropertyCache.put(key,member);
	}

	public Member getCachedClassProperty(Class c, String propertyName) {
		Object key = new ClassPropCacheKey(c,propertyName);
		return (Member)classPropertyCache.get(key);
	}
	*/

	public Map getMap(String name) {
		if ( maps==null ) {
			if ( superGroup==null ) {
				return null;
			}
			return superGroup.getMap(name);
		}
		Map m = (Map)maps.get(name);
		if ( m==null && superGroup!=null ) {
			m = superGroup.getMap(name);
		}
		return m;
	}

	/** Define a map for this group; not thread safe...do not keep adding
	 *  these while you reference them.
	 */
	public void defineMap(String name, Map mapping) {
		maps.put(name, mapping);
	}

	public static void registerDefaultLexer(Class lexerClass) {
		defaultTemplateLexerClass = lexerClass;
	}

	public static void registerGroupLoader(StringTemplateGroupLoader loader) {
		groupLoader = loader;
	}

	public static StringTemplateGroup loadGroup(String name) {
		return loadGroup(name, null, null);
	}

	public static StringTemplateGroup loadGroup(String name,
												StringTemplateGroup superGroup)
	{
		return loadGroup(name, null, superGroup);
	}

	public static StringTemplateGroup loadGroup(String name,
												Class lexer,
												StringTemplateGroup superGroup)
	{
		if ( groupLoader!=null ) {
			return groupLoader.loadGroup(name, lexer, superGroup);
		}
		return null;
	}

	public static StringTemplateGroupInterface loadInterface(String name) {
		if ( groupLoader!=null ) {
			return groupLoader.loadInterface(name);
		}
		return null;
	}

	public void error(String msg) {
		error(msg, null);
	}

	public void error(String msg, Exception e) {
		if ( listener!=null ) {
			listener.error(msg,e);
		}
		else {
			System.err.println("StringTemplate: "+msg);
			if ( e!=null ) {
				e.printStackTrace();
			}
		}
	}

	public synchronized Set getTemplateNames() {
		return templates.keySet();
	}

	/** Indicate whether ST should emit <templatename>...</templatename>
	 *  strings for debugging around output for templates from this group.
	 */
	public void emitDebugStartStopStrings(boolean emit) {
		this.debugTemplateOutput = emit;
	}

	public void doNotEmitDebugStringsForTemplate(String templateName) {
		if ( noDebugStartStopStrings==null ) {
			noDebugStartStopStrings = new HashSet();
		}
		noDebugStartStopStrings.add(templateName);
	}

	public void emitTemplateStartDebugString(StringTemplate st,
											 StringTemplateWriter out)
		throws IOException
	{
		if ( noDebugStartStopStrings==null ||
			 !noDebugStartStopStrings.contains(st.getName()) )
		{
			String groupPrefix = "";
			if ( !st.getName().startsWith("if") && !st.getName().startsWith("else") ) {
				if ( st.getNativeGroup()!=null ) {
					groupPrefix = st.getNativeGroup().getName()+".";
				}
				else {
					groupPrefix = st.getGroup().getName()+".";
				}
			}
			out.write("<"+groupPrefix +st.getName()+">");
		}
	}

	public void emitTemplateStopDebugString(StringTemplate st,
											StringTemplateWriter out)
		throws IOException
	{
		if ( noDebugStartStopStrings==null ||
			 !noDebugStartStopStrings.contains(st.getName()) )
		{
			String groupPrefix = "";
			if ( !st.getName().startsWith("if") && !st.getName().startsWith("else") ) {
				if ( st.getNativeGroup()!=null ) {
					groupPrefix = st.getNativeGroup().getName()+".";
				}
				else {
					groupPrefix = st.getGroup().getName()+".";
				}
			}
			out.write("</"+groupPrefix+st.getName()+">");
		}
	}

	public String toString() {
		return toString(true);
	}

	public String toString(boolean showTemplatePatterns) {
		StringBuffer buf = new StringBuffer();
		Set templateNameSet = templates.keySet();
		List sortedNames = new ArrayList(templateNameSet);
		Collections.sort(sortedNames);
		Iterator iter = sortedNames.iterator();
		buf.append("group "+getName()+";\n");
		StringTemplate formalArgs = new StringTemplate("$args;separator=\",\"$");
		while (iter.hasNext()) {
			String tname = (String) iter.next();
			StringTemplate st = (StringTemplate)templates.get(tname);
			if ( st!=NOT_FOUND_ST ) {
				formalArgs = formalArgs.getInstanceOf();
				formalArgs.setAttribute("args", st.getFormalArguments());
				buf.append(tname+"("+formalArgs+")");
				if ( showTemplatePatterns ) {
					buf.append(" ::= <<");
					buf.append(st.getTemplate());
					buf.append(">>\n");
				}
				else {
					buf.append('\n');
				}
			}
		}
		return buf.toString();
	}
}
