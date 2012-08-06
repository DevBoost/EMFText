/*
 * Created on 04.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aterm.AFun;
import aterm.ATerm;
import aterm.ATermAppl;
import aterm.ATermFactory;
import aterm.ATermList;

public class ParseTable implements Serializable {
    
    /**
     * Number of possible characters to expect
     * (0x10FFFF would be all chars of UTF-8, but is not yet
     *  supported by the parse table format.)
     */
    protected static final int NUM_CHARS = 256; 

    private static final long serialVersionUID = -3372429249660900093L;
    
    private static boolean printedWarning;

    private State[] states;

    private int startState;

    private Label[] labels;

    private Priority[] priorities;
    
    private Associativity[] associativities;
    
    private boolean hasRejects;
    
    private boolean hasAvoids;
    
    private boolean hasPrefers;
    
    private boolean hasRecovers;

    transient private ATermFactory factory;

    transient public AFun applAFun;

    transient public AFun ambAFun;

    private Label[] injections;
    
    // TODO: allocate prototypes to avoid measurable GC overhead in ParseTable construction
    //       (especially when using the CMS garbage collector, those gotos and stuff
    //        introduce a lot of overhead)

    private transient HashMap<Goto, Goto> gotoCache = new HashMap<Goto, Goto>();

    private transient HashMap<Shift, Shift> shiftCache = new HashMap<Shift, Shift>();

    private transient HashMap<Reduce, Reduce> reduceCache = new HashMap<Reduce, Reduce>();

    private transient HashMap<RangeList, RangeList> rangesCache = new HashMap<RangeList, RangeList>();
    
    public ParseTable(ATerm pt) throws InvalidParseTableException {
        parse(pt);
        initAFuns(pt.getFactory());
    }

    public void initAFuns(ATermFactory factory) {
        this.factory = factory;
        applAFun = factory.makeAFun("appl", 2, false);
        ambAFun = factory.makeAFun("amb", 1, false);
    }

    public ATermFactory getFactory() {
        return factory;
    }

    private boolean parse(ATerm pt) throws InvalidParseTableException {
        int version = Term.intAt(pt, 0);
        startState = Term.intAt(pt, 1);
        ATermList labelsTerm = Term.listAt(pt, 2);
        ATermAppl statesTerm = Term.applAt(pt, 3);
        ATermAppl prioritiesTerm = Term.applAt(pt, 4);

        if (version != 4 && version !=6) {
            throw new InvalidParseTableException("Only supports version 4 and 6 tables.");
        }

        labels = parseLabels(labelsTerm);
        states = parseStates(statesTerm);
        priorities = parsePriorities(prioritiesTerm);
        associativities = parseAssociativities(prioritiesTerm);

        injections = new Label[labels.length];
        for(int i=0;i<labels.length;i++)
            if(labels[i] != null && labels[i].isInjection())
                injections[i] = labels[i];
        
        gotoCache = null;
        shiftCache = null;
        reduceCache = null;
        
        return true;
    }

    private Priority[] parsePriorities(ATermAppl prioritiesTerm) throws InvalidParseTableException {

        ATermList prods = Term.listAt(prioritiesTerm, 0);
        List<Priority> ret = new ArrayList<Priority>();
        
        while (!prods.isEmpty()) {
            ATermAppl a = (ATermAppl) prods.getFirst();
            prods = prods.getNext();
            
            int left = Term.intAt(a, 0);
            int right = Term.intAt(a, 1);
            if (a.getName().equals("left-prio")) {
                // handled by parseAssociativities
            } else if (a.getName().equals("right-prio")) {
                // handled by parseAssociativities
            } else if (a.getName().equals("non-assoc")) {
                // handled by parseAssociativities
            } else if (a.getName().equals("gtr-prio")) {
                if(left != right)
                    ret.add(new Priority(Priority.GTR, left, right));
            } else if (a.getName().equals("arg-gtr-prio")) {
            	int arg = right;
            	right = Term.intAt(a, 1);
                if(left != right)
                    ret.add(new Priority(Priority.GTR, left, right, arg));
            } else {
                throw new InvalidParseTableException("Unknown priority : " + a.getName());
            }
        }
        return ret.toArray(new Priority[0]);
    }

    private Associativity[] parseAssociativities(ATermAppl prioritiesTerm) throws InvalidParseTableException {

        ATermList prods = Term.listAt(prioritiesTerm, 0);
        List<Associativity> ret = new ArrayList<Associativity>();
        
        for (ATermAppl a = (ATermAppl) prods.getFirst(); !prods.getNext().isEmpty(); prods = prods.getNext()) {
            int left = Term.intAt(a, 0);
            int right = Term.intAt(a, 1);
            if (a.getName().equals("left-prio")) {
                if(left == right)
                    ret.add(new Associativity(Priority.LEFT, left));
            } else if (a.getName().equals("right-prio")) {
                if(left == right)
                    ret.add(new Associativity(Priority.RIGHT, left));
            } else if (a.getName().equals("non-assoc")) {
                if(left == right)
                    ret.add(new Associativity(Priority.NONASSOC, left));
            } else if (a.getName().equals("gtr-prio")) {
                // handled by parsePriorities
            } else if (a.getName().equals("arg-gtr-prio")) {
                // handled by parsePriorities
            } else {
                throw new InvalidParseTableException("Unknown priority : " + a.getName());
            }
        }
        return ret.toArray(new Associativity[0]);
    }

    private Label[] parseLabels(ATermList labelsTerm) throws InvalidParseTableException {

        Label[] ret = new Label[labelsTerm.getChildCount() + NUM_CHARS + 1];
        
        while (!labelsTerm.isEmpty()) {
            ATermAppl a = Term.applAt(labelsTerm, 0);
            labelsTerm = labelsTerm.getNext();
            ATermAppl prod = Term.applAt(a, 0);
            int labelNumber = Term.intAt(a, 1);
            boolean injection = isInjection(prod);
            ProductionAttributes pa = parseProductionAttributes(Term.applAt(prod, 2));
            ret[labelNumber] = new Label(labelNumber, prod, pa, injection);
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
	private boolean isInjection(ATermAppl prod) {

        List r = prod.match("prod([<term>],cf(sort(<term>)),<term>)");
        if (r != null && r.size() == 1) {
            ATerm x = (ATerm) r.get(0);
            return !(x.match("lit(<str>)") == null);
        }

        r = prod.match("prod([<term>],lex(sort(<str>)),<term>)");
        if (r != null && r.size() == 1) {
            ATerm x = (ATerm) r.get(0);
            return !(x.match("lit(<str)") == null);
        }

        return false;
    }

    private ProductionAttributes parseProductionAttributes(ATermAppl attr)
            throws InvalidParseTableException {
        if (attr.getName().equals("attrs")) {
            int type = 0;
            boolean isRecover = false;
            ATerm term = null;
            
            for (ATermList ls = (ATermList) attr.getChildAt(0); !ls.isEmpty(); ls = ls.getNext()) {
                ATermAppl t = (ATermAppl) ls.getFirst();
                String ctor = t.getName();
                if (ctor.equals("reject")) {
                    type = ProductionType.REJECT;
                    hasRejects = true;
                } else if (ctor.equals("prefer")) {
                    type = ProductionType.PREFER;
                    hasPrefers = true;
                } else if (ctor.equals("avoid")) {
                    type = ProductionType.AVOID;
                    hasAvoids = true;
                } else if (ctor.equals("bracket")) {
                    type = ProductionType.BRACKET;
                } else {
                    if (ctor.equals("assoc")) {
                        ATermAppl a = (ATermAppl) t.getChildAt(0);
                        if (a.getName().equals("left") || a.getName().equals("assoc")) {
                        	// ('assoc' is identical to 'left' for the parser)
                            type = ProductionType.LEFT_ASSOCIATIVE;
                        } else if (a.getName().equals("right")) {
                            type = ProductionType.RIGHT_ASSOCIATIVE;
                        } else if (a.getName().equals("non-assoc")) {
                            // FIXME: complete and test the non-assoc implementation
                            // (it currently already seems to work at least for direct cases)
                            // the current SDF manual and some tests seem to indicate that non-assoc
                            // has the same effects the same as having a priority P > P
                        } else {
                            throw new InvalidParseTableException("Unknown assocativity: " + a.getName());
                        }
                    } else if (	ctor.equals("term") && t.getChildCount() == 1) {
                        // Term needs to be shaped as term(cons(Constructor)) to be a constructor
                    	if(t.getChildAt(0) instanceof ATermAppl) {
                    	    ATermAppl child = (ATermAppl) t.getChildAt(0);
                            if (child.getChildCount() == 1 && child.getName().equals("cons")) {
                    			term = (ATerm) t.getChildAt(0).getChildAt(0);
                    		} else if (child.getChildCount() == 0 && child.getName().equals("recover")) {
                    		    hasRecovers = isRecover = true;
                    		}
                    	}
                    	// TODO Support other terms that are not a constructor (custom annotations)
                    } else if (ctor.equals("id")) {
                        // FIXME not certain about this
                        term = (ATerm) t.getChildAt(0);
                    } else {
                        throw new InvalidParseTableException("Unknown attribute: " + t);
                    }
                }
            }
            return new ProductionAttributes(term, type, isRecover);
        } else if (attr.getName().equals("no-attrs")) {
            return new ProductionAttributes(null, ProductionType.NO_TYPE, false);
        }
        throw new InvalidParseTableException("Unknown attribute type: " + attr);
    }

    private State[] parseStates(ATermAppl statesTerm) throws InvalidParseTableException {

        ATermList states = Term.listAt(statesTerm, 0);
        State[] ret = new State[states.getLength()];
        for(int i = 0; i < ret.length; i++) {
            ATermAppl stateRec = (ATermAppl) states.getFirst();
            states = states.getNext();

            int stateNumber = Term.intAt(stateRec, 0);
            Goto[] gotos = parseGotos(Term.listAt(stateRec, 1));
            Action[] actions = parseActions(Term.listAt(stateRec, 2));

            ret[i] = new State(stateNumber, gotos, actions);
        }

        return ret;
    }

    private Goto makeGoto(int newStateNumber, RangeList ranges) {
        Goto g = new Goto(ranges, newStateNumber);
        Goto cached = gotoCache.get(g);
        if (cached == null) {
            gotoCache.put(g, g);
            return g;
        } else {
            return cached;
        }
    }
    

    private Action[] parseActions(ATermList actionList) throws InvalidParseTableException {
        Action[] ret = new Action[actionList.getChildCount()];

        for(int i = 0; i < ret.length; i++) {
            ATermAppl action = (ATermAppl) actionList.getFirst();
            actionList = actionList.getNext();
            RangeList ranges = parseRanges(Term.listAt(action, 0));
            ActionItem[] items = parseActionItems(Term.listAt(action, 1));
            ret[i] = new Action(ranges, items);
        }
        return ret;
    }

    private ActionItem[] parseActionItems(ATermList items) throws InvalidParseTableException {

        ActionItem[] ret = new ActionItem[items.getChildCount()];

        for(int i = 0; i < ret.length; i++) {
            ActionItem item = null;
            ATermAppl a = (ATermAppl) items.getFirst();
            items = items.getNext();

            if (a.getName().equals("reduce") && a.getAFun().getArity() == 3) {
                int productionArity = Term.intAt(a, 0);
                int label = Term.intAt(a, 1);
                int status = Term.intAt(a, 2);
                boolean isRecoverAction = getLabel(label).getAttributes().isRecoverProduction();
                item = makeReduce(productionArity, label, status, isRecoverAction);
            } else if(a.getName().equals("reduce") && a.getAFun().getArity() == 4) {
                int productionArity = Term.intAt(a, 0);
                int label = Term.intAt(a, 1);
                int status = Term.intAt(a, 2);
                RangeList[] charClasses = parseCharRanges(Term.listAt(a, 3));
                item = makeReduceLookahead(productionArity, label, status, charClasses);
                
            } else if (a.getName().equals("accept")) {
                item = new Accept();
            } else if (a.getName().equals("shift")) {
                int nextState = Term.intAt(a, 0);
                item = makeShift(nextState);
            } else {
                throw new InvalidParseTableException("Unknown action " + a.getName());
            }
            ret[i] = item;
        }
        return ret;
    }

    private RangeList[] parseCharRanges(ATermList list) throws InvalidParseTableException {
        RangeList[] ret = new RangeList[list.getLength()];
        for (int i=0;i<ret.length; i++) {
            ATermAppl t = Term.asAppl(list.getFirst());
            list = list.getNext();
            ATermList l, n;            
            if (t.getName().equals("look")) { // sdf2bundle 2.4
                l = Term.listAt(Term.applAt(t, 0), 0);
                n = Term.listAt(t, 1);
            } else { // sdf2bundle 2.6
                assert t.getName().equals("follow-restriction");
                l = Term.listAt(Term.termAt(Term.listAt(t, 0), 0), 0);
                n = Term.listAt(t, 0).getNext();
            }
            
            // FIXME: multiple lookahead are not fully supported or tested
            //        (and should work for both 2.4 and 2.6 tables)
            
            if (Term.termAt(l, 1) == null) {
                // This handles restrictions like:
                //   LAYOUT? -/- [\/].[\/]
                // where there is no other restriction that starts with a [\/]
                
                ret[i] = new RangeList(new Range(Term.intAt(l, 0)));
            } else if (n.getLength() > 0) {
                // This handles restrictions like:
                //   LAYOUT? -/- [\/].[\/\+].[\*]
                throw new InvalidParseTableException("Multiple lookahead not fully supported");
            } else {
                // This handles restrictions like:
                //   LAYOUT? -/- [\/].[\/]
                //   LAYOUT? -/- [\/].[\*]
                //   LAYOUT? -/- [\/].[\{]
                
                ret[i] = parseRanges(l);
            }
        }
        return ret;
    }

    private ActionItem makeReduceLookahead(int productionArity, int label, int status, RangeList[] charClasses) {
        return new ReduceLookahead(productionArity, label, status, charClasses);
    }
    
    private Reduce makeReduce(int arity, int label, int status, boolean isRecoverAction) {
        Reduce r = new Reduce(arity, label, status, isRecoverAction);
        Reduce cached = reduceCache.get(r);
        if (cached == null) {
            reduceCache.put(r, r);
            return r;
        } else {
            return cached;
        }
    }

    private Shift makeShift(int nextState) {
        Shift s = new Shift(nextState);
        Shift cached = shiftCache.get(s);
        if (cached == null) {
            shiftCache.put(s, s);
            return s;
        } else {
            return cached;
        }
    }

    private Goto[] parseGotos(ATermList gotos) throws InvalidParseTableException {
        Goto[] ret = new Goto[gotos.getChildCount()];
        for(int i = 0; i < ret.length; i++) {
            ATermAppl go = (ATermAppl) gotos.getFirst();
            gotos = gotos.getNext();

            ATermList rangeList = Term.listAt(go, 0);
            int newStateNumber = Term.intAt(go, 1);
            RangeList ranges = parseRanges(rangeList);
            //int[] productionLabels = parseProductionLabels(rangeList);
            ret[i] = makeGoto(newStateNumber, ranges);
        }

        return ret;
    }

//    private int[] parseProductionLabels(ATermList ranges) throws InvalidParseTableException {
//
//        int[] ret = new int[ranges.getChildCount()];
//
//        for (int i = 0; i < ranges.getChildCount(); i++) {
//            ATerm t = Term.termAt(ranges, i);
//            if (Term.isInt(t)) {
//                ret[i] = Term.toInt(t);
//            } else {
////                else if(Term.isAppl(t) && ((ATermAppl)t).getName().equals("range")) {
////                int s = Term.intAt(t, 0);
////                int e = Term.intAt(t, 1);
//                Tools.debug(t);
//                throw new InvalidParseTableException("");
//            }
//        }
//        return ret;
//    }

    private RangeList parseRanges(ATermList ranges) throws InvalidParseTableException {
        // TODO: Optimize - directly create int[] for RangeList, don't bother with intermediate Range objects
        Range[] ret = new Range[ranges.getChildCount()];

        for(int i = 0; i < ret.length; i++) {
            ATerm t = ranges.getFirst();
            ranges = ranges.getNext();
            if (Term.isInt(t)) {
                ret[i] = makeRange(Term.toInt(t));
            } else {
                int low = Term.intAt(t, 0);
                int hi = Term.intAt(t, 1);
                ret[i] = makeRange(low, hi);
            }
        }
        
        return makeRangeList(ret);
    }

    private RangeList makeRangeList(Range[] ranges) throws InvalidParseTableException {
        RangeList r = new RangeList(ranges);
        RangeList cached = rangesCache.get(r);
        if (cached == null) {
            rangesCache.put(r, r);
            return r;
        } else {
            return cached;
        }
    }

    private Range makeRange(int low, int hi) throws InvalidParseTableException {
        return new Range(low, hi);
    }

    private Range makeRange(int n) throws InvalidParseTableException {
        return makeRange(n, n);
    }

    public State getInitialState() {
        return states[startState];
    }

    public State go(State s, int label) {
        return states[s.go(label)];
    }

    public Label getLabel(int label) {
        return labels[label];
    }

    public State getState(int s) {
        return states[s];
    }

    public int getStateCount() {
        return states.length;
    }

    public int getProductionCount() {
        return labels.length - NUM_CHARS;
    }

    public int getActionEntryCount() {
        int total = 0;
        for (State s : states) {
            total += s.getActionItemCount();
        }
        return total;
    }

    public int getGotoCount() {
        int total = 0;
        for (State s : states) {
            total += s.getGotoCount();
        }
        return total;
    }

    public int getActionCount() {
        int total = 0;
        for (State s : states) {
            total += s.getActionCount();
        }
        return total;
    }

    public boolean hasPriorities() {
        return priorities.length > 0 || associativities.length > 0;
    }

    public boolean hasRejects() {
        return hasRejects;
    }

    public boolean hasPrefers() {
        return hasPrefers;
    }

    public boolean hasAvoids() {
        return hasAvoids;
    }
    
    public boolean hasRecovers() {
        return hasRecovers;
    }
    
    public boolean hasPrefersOrAvoids() {
        return hasAvoids() || hasPrefers();
    }

    public IParseNode lookupProduction(int currentToken) {
        return new ParseProductionNode(currentToken);
    }

    public ATerm getProduction(int prod) {
        if (prod < NUM_CHARS) {
            return factory.makeInt(prod);
        }
        return labels[prod].prod;
    }

    public List<Priority> getPriorities(Label prodLabel) {
        // TODO: optimize - *maybe* cache getPriorities()?
        List<Priority> ret = new ArrayList<Priority>();
        for (Priority p : priorities) {
            if (p.left == prodLabel.labelNumber && p.type == Priority.GTR) {
                ret.add(p);
            }
        }
        return ret;
    }

    public Label lookupInjection(int prod) {
        return injections[prod];
    }

	public void lookupAction(int stateNumber, int peekNextToken) {
		throw new NotImplementedException();
	}
}
