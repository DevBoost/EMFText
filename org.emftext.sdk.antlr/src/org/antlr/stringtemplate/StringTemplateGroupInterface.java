package org.antlr.stringtemplate;

import org.antlr.stringtemplate.language.*;

import java.util.*;
import java.io.Reader;

/** A group interface is like a group without the template implementations;
 *  there are just template names/argument-lists like this:
 *
 *  interface foo;
 *  class(name,fields);
 *  method(name,args,body);
 *
 */
public class StringTemplateGroupInterface {
	/** What is the group name */
	protected String name;

	/** Maps template name to TemplateDefinition object */
	protected Map templates = new LinkedHashMap();

	/** Are we derived from another group?  Templates not found in this group
	 *  will be searched for in the superGroup recursively.
	 */
	protected StringTemplateGroupInterface superInterface = null;

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

	/** All the info we need to track for a template defined in an interface */
	static class TemplateDefinition {
		public String name;
		public LinkedHashMap formalArgs; // LinkedHashMap<FormalArgument>
		public boolean optional = false;
		public TemplateDefinition(String name, LinkedHashMap formalArgs, boolean optional) {
			this.name = name;
			this.formalArgs = formalArgs;
			this.optional = optional;
		}
	}

	public StringTemplateGroupInterface(Reader r) {
		this(r,DEFAULT_ERROR_LISTENER,(StringTemplateGroupInterface)null);
	}

	public StringTemplateGroupInterface(Reader r, StringTemplateErrorListener errors) {
		this(r,errors,(StringTemplateGroupInterface)null);
	}

	/** Create an interface from the input stream */
	public StringTemplateGroupInterface(Reader r,
										StringTemplateErrorListener errors,
										StringTemplateGroupInterface superInterface)
	{
		this.listener = errors;
		setSuperInterface(superInterface);
		parseInterface(r);
	}

	public StringTemplateGroupInterface getSuperInterface() {
		return superInterface;
	}

	public void setSuperInterface(StringTemplateGroupInterface superInterface) {
		this.superInterface = superInterface;
	}

	protected void parseInterface(Reader r) {
		try {
			InterfaceLexer lexer = new InterfaceLexer(r);
			InterfaceParser parser = new InterfaceParser(lexer);
			parser.groupInterface(this);
			//System.out.println("read interface\n"+this.toString());
		}
		catch (Exception e) {
			String name = "<unknown>";
			if ( getName()!=null ) {
				name = getName();
			}
			error("problem parsing group "+name+": "+e, e);
		}
	}

	public void defineTemplate(String name, LinkedHashMap formalArgs, boolean optional) {
		TemplateDefinition d = new TemplateDefinition(name,formalArgs,optional);
		templates.put(d.name,d);
	}

	/** Return a list of all template names missing from group that are defined
	 *  in this interface.  Return null if all is well.
	 */
	public List getMissingTemplates(StringTemplateGroup group) {
		List missing = new ArrayList();
		for (Iterator it = templates.keySet().iterator(); it.hasNext();) {
			String name = (String)it.next();
			TemplateDefinition d = (TemplateDefinition)templates.get(name);
			if ( !d.optional && !group.isDefined(d.name) ) {
				missing.add(d.name);
			}
		}
		if ( missing.size()==0 ) {
			missing = null;
		}
		return missing;
	}

	/** Return a list of all template sigs that are present in the group, but
	 *  that have wrong formal argument lists.  Return null if all is well.
	 */
	public List getMismatchedTemplates(StringTemplateGroup group) {
		List mismatched = new ArrayList();
		for (Iterator it = templates.keySet().iterator(); it.hasNext();) {
			String name = (String)it.next();
			TemplateDefinition d = (TemplateDefinition)templates.get(name);
			if ( group.isDefined(d.name) ) {
				StringTemplate defST = group.getTemplateDefinition(d.name);
				Map formalArgs = defST.getFormalArguments();
				boolean ack = false;
				if ( (d.formalArgs!=null && formalArgs==null) ||
					(d.formalArgs==null && formalArgs!=null) ||
					d.formalArgs.size() != formalArgs.size() )
				{
					ack=true;
				}
				if ( !ack ) {
					for (Iterator it2 = formalArgs.keySet().iterator();
						 it2.hasNext();)
					{
						String argName = (String)it2.next();
						if ( d.formalArgs.get(argName)==null ) {
							ack=true;
							break;
						}
					}
				}
				if ( ack ) {
					//System.out.println(d.formalArgs+"!="+formalArgs);
					mismatched.add(getTemplateSignature(d));
				}
			}
		}
		if ( mismatched.size()==0 ) {
			mismatched = null;
		}
		return mismatched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String toString() {
        StringBuffer buf = new StringBuffer();
		buf.append("interface ");
		buf.append(getName());
		buf.append(";\n");
		for (Iterator it = templates.keySet().iterator(); it.hasNext();) {
			String name = (String)it.next();
			TemplateDefinition d = (TemplateDefinition)templates.get(name);
			buf.append( getTemplateSignature(d) );
			buf.append(";\n");
		}
		return buf.toString();
	}

	protected String getTemplateSignature(TemplateDefinition d) {
		StringBuffer buf = new StringBuffer();
		if ( d.optional ) {
			buf.append("optional ");
		}
		buf.append(d.name);
		if ( d.formalArgs!=null ) {
			StringBuffer args = new StringBuffer();
			args.append('(');
			int i=1;
			for (Iterator it = d.formalArgs.keySet().iterator(); it.hasNext();) {
				String name = (String) it.next();
				if ( i>1 ) {
					args.append(", ");
				}
				args.append(name);
				i++;
			}
			args.append(')');
			buf.append(args);
		}
		else {
			buf.append("()");
		}
		return buf.toString();
	}
}
