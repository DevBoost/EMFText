package org.spoofax.jsglr;

import aterm.*;

public class ParseTreeTools {

  private final static int PARSE_TREE = 0;
  private final static int APPL_PROD = 0;
  private final static int APPL_ARGS = 1;
  private final static int PROD_ATTRS = 2;
  private final static int ATTRS_LIST = 0;
  private final static int TERM_CONS = 0;
  private final static int CONS_NAME = 0;

  private AFun parsetreeFun;
  private AFun applFun;
  private AFun termFun;
  private AFun prodFun;
  private AFun noattrsFun;
  private AFun attrsFun;
  private AFun consFun;

  public ParseTreeTools(ATermFactory factory) {
    super();
    parsetreeFun = factory.makeAFun("parsetree", 2, false);
    applFun = factory.makeAFun("appl", 2, false);
    prodFun = factory.makeAFun("prod", 3, false);
    noattrsFun = factory.makeAFun("no-attrs", 0, false);
    attrsFun = factory.makeAFun("attrs", 1, false);
    termFun = factory.makeAFun("term", 1, false);
    consFun = factory.makeAFun("cons", 1, false);
  }

  private static ATermAppl assertAppl(ATerm t) {
    if(t instanceof ATermAppl) {
      return (ATermAppl) t;
    }
    else {
      throw new IllegalArgumentException("Expected aterm application: " + t);
    }
  }

  private static ATermAppl assertAppl(ATerm t, AFun fun) {
    ATermAppl result = assertAppl(t);
    if(result.getAFun() != fun) {
      throw new IllegalArgumentException("Expected application of function " + fun + ": " + result.getAFun());
    }

    return result;
  }

  /**
   * Given a production or application returns the constructor name
   * attached to the production, or null if there is no constructor.
   *
   * @author Martin Bravenboer
   * @author Lennart Kats
   */
  public String getConstructor(ATerm arg) {
    ATermAppl appl = assertAppl(arg, applFun);

    ATermAppl prod;
    if(appl.getAFun() == prodFun) {
      prod = appl;
    }
    else if(appl.getAFun() == applFun) {
      prod = assertAppl(appl.getArgument(APPL_PROD), prodFun);
    }
    else {
      throw new IllegalArgumentException("Expected prod or appl: " + arg);
    }

    ATermAppl attrs = assertAppl(prod.getArgument(PROD_ATTRS));
    if(attrs.getAFun() == noattrsFun) {
      return null;
    }
    else {
      for(ATerm attr: (ATermList) attrs.getChildAt(ATTRS_LIST)) {
	if (attr instanceof ATermAppl) {
	  ATermAppl namedAttr = (ATermAppl) attr;
	  if (namedAttr.getAFun() == termFun) {
	    namedAttr = (ATermAppl) namedAttr.getArgument(TERM_CONS);
	    if (namedAttr.getAFun() == consFun) {
	      namedAttr = (ATermAppl) namedAttr.getArgument(CONS_NAME);
	      return namedAttr.getName();
	    }
	  }
	}
      }
    }

    return null;
  }

  /**
   * Yields a parse tree (parsetree or appl) to a String.
   *
   * @author Martin Bravenboer
   */
  public String yield(ATerm parsetree) {
    StringBuilder builder = new StringBuilder();
    yield(parsetree, builder);
    return builder.toString();
  }

  /**
   * Yields a parse tree (parsetree or appl) to a string builder.
   *
   * @author Martin Bravenboer
   */
  public void yield(ATerm parsetree, StringBuilder builder) {
    ATermAppl appl = assertAppl(parsetree);
    if(appl.getAFun() == parsetreeFun) {
      appl = assertAppl(appl.getArgument(PARSE_TREE));
    }

    yieldAppl(appl, builder);
  }

  /**
   * Private helper for the yield method.
   */
  private void yieldAppl(ATermAppl appl, StringBuilder builder) {
    for(ATerm t : (ATermList) appl.getArgument(APPL_ARGS)) {
      if(t instanceof ATermAppl) {
	ATermAppl arg = (ATermAppl) t;
	if(arg.getAFun() == applFun) {
	  yieldAppl(arg, builder);
	}
	else {
	  throw new IllegalArgumentException("Don't know how to yield " + arg);
	}
      }
      else if(t instanceof ATermInt) {
	ATermInt arg = (ATermInt) t;
	builder.append((char) arg.getInt());	
      }
      else {
	throw new IllegalArgumentException("Don't know how to yield " + t);
      }
    }
  }
}