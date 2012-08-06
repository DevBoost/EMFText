package org.antlr.stringtemplate;

import java.io.*;

/** A simple loader that looks only in the directory(ies) you
 *  specify in the ctor, but it uses the classpath rather than
 *  absolute dirs so it can be used when the ST application is jar'd up.
 *  You may specify the char encoding.
 */
public class CommonGroupLoader extends PathGroupLoader {

	public CommonGroupLoader(StringTemplateErrorListener errors) {
		super(errors);
	}

	/** Pass a single dir or multiple dirs separated by colons from which
	 *  to load groups/interfaces.  These are interpreted as relative
	 *  paths to be used with CLASSPATH to locate groups.  E.g.,
	 *  If you pass in "org/antlr/codegen/templates" and ask to load
	 *  group "foo" it will try to load via classpath as
	 *  "org/antlr/codegen/templates/foo".
	 */
	public CommonGroupLoader(String dirStr, StringTemplateErrorListener errors) {
		super(dirStr,errors);
	}

	/** Look in each relative directory for the file called 'name'.
	 *  Load via classpath.
	 */
	protected BufferedReader locate(String name) throws IOException {
		for (int i = 0; i < dirs.size(); i++) {
			String dir = (String) dirs.get(i);
			String fileName = dir+"/"+name;
			//System.out.println("trying "+fileName);
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream is = cl.getResourceAsStream(fileName);
			if ( is==null ) {
				cl = this.getClass().getClassLoader();
				is = cl.getResourceAsStream(fileName);
			}
			if ( is!=null ) {
				return new BufferedReader(getInputStreamReader(is));
			}
		}
		return null;
	}

}