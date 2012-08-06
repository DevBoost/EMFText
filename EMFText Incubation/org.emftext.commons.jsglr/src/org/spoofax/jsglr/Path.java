/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

//todo managed
//import javolution.realtime.ObjectFactory;
//import javolution.realtime.ObjectPool;
//import javolution.realtime.PoolContext;
//import javolution.realtime.Context;

import java.util.ArrayList;
import java.util.List;

public class Path /*todo managed extends RealtimeObject*/ {

    public final Path parent;

    public final IParseNode label;

    public final Frame frame;

    protected final int length;
    
    public static int totalCount = 0;
    
    public Link lnk;
    
    public int getRecoverCount()
    {
        int result = 0;
        if(lnk!=null)
        {
            result+=lnk.recoverCount;           
        }
        if(parent!=null) //Todo: find out relation linktoparent/parent
        {
            result += parent.getRecoverCount();
        }
        return result;        
    }
    
    public int getRecoverCount(int maxCharLength)
    {
        if(parent==null || this.length<=maxCharLength)
            return getRecoverCount();
        return parent.getRecoverCount(maxCharLength);
    }

    //todo managed
    //public static final PathObjectFactory FACTORY = new PathObjectFactory();

    public static boolean logNewInstanceCreation = false;

/*    Path() {
        super();
    }
*/
    public static Path valueOf(Path parent, Link ln, Frame frame, int length) {
        Path _this = new Path(parent, ln, frame, length);
        
        //(Path)FACTORY.object(); //todo managed
/*
        _this.parent = parent;
        _this.label = label;
        _this.frame = frame;
*/
        return _this;
    }

    Path(Path parent, Link ln, Frame frame, int length) {
        this.parent = parent;
        lnk = ln;
        if(ln!=null){
            this.label = lnk.label;
        }
        else
        {
            this.label = null;
        }
        this.frame = frame;
        this.length = length;
    }

    public Frame getEnd() {
        return frame;
    }

    public final List<IParseNode> getATerms() {
        ArrayList<IParseNode> ret = new ArrayList<IParseNode>();
        for (Path n = parent; n != null; n = n.parent) {
            ret.add(n.label);
        }
        return ret;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        sb.append("<");
        for (Path p = this; p != null; p = p.parent) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(p.frame.state.stateNumber);
            first = false;
        }
        sb.append(">");
        return sb.toString();
    }

    public int getLength() { 
        if (parent == null) {
            return length;
        }
        else {
            return length; //+ parent.getLength();
        }
    }

    //todo managed
//    public static final class PathObjectFactory extends ObjectFactory {
//        protected Path create() {
//            return new Path();
//        }
//
//        private ObjectPool _cachedPool;
//
//        /**
//         * This needs to be called once per thread
//         *
//         * @param poolContext
//         */
//        public final void attach(final Context poolContext) {
//            _cachedPool = ((PoolContext)poolContext).getPool(_index);
//        }
//
//        public Object/*T*/object() {
//            return _cachedPool.next();
//        }
//
////        protected void cleanup(Object/*T*/obj) {
////            //((Path)obj).clear(false);
////        }
//    }
}

