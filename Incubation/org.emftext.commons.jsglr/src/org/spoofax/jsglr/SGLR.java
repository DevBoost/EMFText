 /*
 * Created on 03.des.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU Lesser General Public License, v2.1
 */
package org.spoofax.jsglr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;

import org.spoofax.ArrayDeque;

import aterm.ATerm;
import aterm.ATermFactory;
import aterm.pure.PureFactory;

public class SGLR {             
   
    
    static final int EOF = ParseTable.NUM_CHARS;
    
    static final int TAB_SIZE = 8;
    
    private static final Timer abortTimer = new Timer(true);
    
    private int abortTimerJobId;

    protected static boolean WORK_AROUND_MULTIPLE_LOOKAHEAD;
    
    //Performance testing
    private static long parseTime=0;
    private static int parseCount=0;
        
    //handles recover productions 
    private RecoverAlgorithm recoverHandler;
        
    public Frame startFrame; 
    
    private long startTime;
    
    private volatile boolean asyncAborted;
    
    private ATermFactory factory;

    public Frame acceptingStack;

    public ArrayDeque<Frame> activeStacks;

    private ParseTable parseTable;

    public int currentToken;

    public int tokensSeen;

    protected int lineNumber;

    protected int columnNumber;

    private ArrayDeque<ActionState> forShifter;

    private ArrayDeque<Frame> forActor;

    private ArrayDeque<Frame> forActorDelayed;

    private int maxBranches;

    private int maxToken;

    private int maxLine;

    private int maxColumn;

    private int maxTokenNumber;

    private AmbiguityManager ambiguityManager;

    public Disambiguator disambiguator;

    private int rejectCount;

    private int reductionCount;

    private PushbackInputStream currentInputStream;
   
    //Creates indent- and dedent- tokens
    //Meant for parsing of indentation based languages
    //TODO: still under construction
    private IndentTokenizer indentTokenHandler;
    
    // ------------------------------------- Integrated recovery  ------------------------
  //Keeps track of the indentation for each line
   // private IndentationHandler indentHandler;
    
    private ParserHistory history;
    
    private RecoveryConnector recoverIntegrator;
    
    private boolean useIntegratedRecovery;

    private boolean reduceRecoverOnly;
    
    //Keeps track of the indentation for each line
    //public IndentationHandler getIndentHandler() {
      //  return indentHandler;
    //}
    
    public ParserHistory getHistory() {
        return history;
    }    
    
    // -------------------- forcing accept recovery --------------------------------
    private boolean enforcePrefixAccept;

    public void setEnforcePrefixAccept(boolean forcingParse) {
        this.enforcePrefixAccept = forcingParse;
    }
    
    //-------------------------- fine-grained recovery ----------------------------------
    private boolean fineGrainemode;
    private int recoverTolerance;
    private ArrayDeque<Frame> recoveryActor;    
    private int maxNrOfRecoveries; //max number of recoveries allowed fragment during fine-grained recovery
    private RecoverDisambiguator recoverDisambiguator;    
    private int lengthAvoidCheck; //checks number of avoids over restricted fragment

    public void setMaxNrOfRecoveries(int maxNrOfRecoveries) {
        this.maxNrOfRecoveries = maxNrOfRecoveries;
    }

    public void setLengthAvoidCheck(int lengthAvoidCheck) {
        this.lengthAvoidCheck = lengthAvoidCheck;
    }   
    
    public void setFineGrainedMode(boolean b) {
        fineGrainemode=b; 
        if(fineGrainemode)
            recoverTolerance=maxNrOfRecoveries;
        else
            recoverTolerance=0;
    }
       
    SGLR() {
        basicInit(null);
    }

    public SGLR(final ATermFactory pf, ParseTable parseTable) {
        assert pf != null;
        assert parseTable != null;
        // Init with a new factory for both serialized or BAF instances.
        this.parseTable = parseTable;
        basicInit(pf);        
    }
    
    public void setRecoverHandler(RecoverAlgorithm recoverHandler) throws NoRecoveryRulesException {
        useIntegratedRecovery = false;
        this.recoverHandler = recoverHandler;
        recoverHandler.initialize(this);
        if (!parseTable.hasRecovers() && recoverHandler.getClass() != NoRecovery.class)
            throw new NoRecoveryRulesException(this);
    }
    
    public RecoveryBase getRecoverHandler() {
        return recoverHandler;
    }

    //TODO: Recovery choices (???): structure / structure+bridge / structure+fine-grained / structure+bridge+fine-grained / old backtrack
    /**
     * Structure-based recovery with bridge parsing.
     * 
     * @deprecated Use {@link #setRecoverHandler(RecoverAlgorithm)} instead
     *             with {@link StructureRecoveryAlgorithm}.
     */
    @Deprecated
    public void setUseStructureRecovery(boolean useRoughRecovery, IRecoveryParser parser) {
        useIntegratedRecovery = useRoughRecovery;
        recoverIntegrator = new RecoveryConnector(this, parser);
    }
    
    /**
     * Structure-based recovery without bridge parsing.
     * 
     * @deprecated Use {@link #setRecoverHandler(RecoverAlgorithm)} instead
     *             with {@link StructureRecoveryAlgorithm}.
     */
    @Deprecated
    public final void setUseStructureRecovery(boolean useRoughRecovery) throws NoRecoveryRulesException {        
        setUseStructureRecovery(useRoughRecovery, null);
    }
    
    /**
     * Aborts an asynchronously running parse job, causing it to throw an exception.     * 
     * (Provides no guarantee that the parser is actually cancelled.)
     */
    public void asyncAbort() {
        asyncAborted = true;
    }

    private void basicInit(ATermFactory factory) {
        this.factory = factory;
        if (factory == null)
            factory = new PureFactory();
        activeStacks = new ArrayDeque<Frame>();     
        forActor = new ArrayDeque<Frame>();
        forActorDelayed = new ArrayDeque<Frame>();
        recoveryActor = new ArrayDeque<Frame>();
        forShifter = new ArrayDeque<ActionState>();

        // FIXME This is *wrong*: need to set the input string size instead
        ambiguityManager = new AmbiguityManager(10000);

        disambiguator = new Disambiguator();
        //indentHandler = new IndentationHandler();
       // indentTokenHandler = new IndentTokenizer(indentHandler, false);  
        //recoverHandler = new BackTrackRecovery2();
        //recoverHandler = new SimpleRecovering(this);
        recoverHandler = new NoRecovery();
        //recoverHandler = new CoarseGrainedRecovery();        
        recoverHandler.initialize(this);        
        useIntegratedRecovery = false;
        recoverIntegrator = null;
        history=new ParserHistory(); 
        setEnforcePrefixAccept(false);
        recoverDisambiguator=new RecoverDisambiguator(this.parseTable);
    }

    public static boolean isDebugging() {
        return Tools.debugging;
    }

    public static boolean isLogging() {
        return Tools.logging;
    }

    /**
     * Initializes the active stacks. At the start of parsing there is only one
     * active stack, and this stack contains the start symbol obtained from the
     * parse table.
     * 
     * @return the initial stack
     */
    private Frame initActiveStacks() {
        activeStacks.clear();
        Frame st0 = newStack(parseTable.getInitialState());
        addStack(st0);
        return st0;
    }
    
    public final ATerm parse(InputStream fis)  throws IOException, SGLRException {        
        return parse(fis, null);
    }   
    
    public ATerm parse(InputStream fis, String startSymbol) throws IOException,
            BadTokenException, TokenExpectedException, ParseException,
            SGLRException {
        logBeforeParsing();        
        initParseVariables(fis);        
        startTime = System.currentTimeMillis();
        initParseTimer();
        return sglrParse(startSymbol);
    }
    
    public final ATerm parse(String input) throws IOException, BadTokenException,
            TokenExpectedException, ParseException, SGLRException {
        
        return parse(input, null);
    }
    
    public ATerm parse(String input, String startSymbol) throws IOException, BadTokenException, TokenExpectedException, ParseException,
        SGLRException {
        
        return parse(new ByteArrayInputStream(input.getBytes("ISO-8859-1")), startSymbol);
    }
    
    private void initParseTimer() {
        if (Tools.timeout > 0) {
            // We use a single shared timer to conserve native threads
            // and a jobId to recognize stale abort events
            synchronized (abortTimer) {
                asyncAborted = false;
                ++abortTimerJobId;
            }
            final int jobId = abortTimerJobId;
            abortTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    synchronized (abortTimer) {
                        if (abortTimerJobId == jobId)
                            asyncAbort();
                    }
                }
            }, Tools.timeout
            );
        } else {
            asyncAborted = false;
        }
    }

    private ATerm sglrParse(String startSymbol)
            throws IOException, BadTokenException, TokenExpectedException,
            ParseException, SGLRException {       
        
        try {
            do {
                readNextToken();                
                //indentHandler.updateIndentation(currentToken);
                //indentTokenHandler.handleIndentShifts(this);                
                //recoverHandler.afterStreamRead(currentToken);
                history.keepTokenAndState(this);
                doParseStep(); 
                //recoverHandler.afterParseStep();
                //  Tools.debug("SGLR: "+(char)currentToken);             
            } while (currentToken != SGLR.EOF && activeStacks.size() > 0);
            
            if(useIntegratedRecovery && acceptingStack==null){                
                recoverIntegrator.recover();                              
                if(acceptingStack==null && activeStacks.size()>0)
                    return sglrParse(startSymbol);
            } else if(recoverHandler.meetsRecoverCriteria()){
                recoverHandler.recover();
                if(acceptingStack==null)
                    return sglrParse(startSymbol);
            }
           
        } catch (CancellationException e) {
            throw new ParseTimeoutException(this, currentToken, tokensSeen - 1, lineNumber,
                    columnNumber);
        }           
                
        logAfterParsing();    
        
        Link s = acceptingStack.findDirectLink(startFrame);
                
        if (s == null)
            throw new ParseException(this, "Accepting stack has no link");
     
        logParseResult(s);
        Tools.debug("avoids: ", s.recoverCount);
        //Tools.debug(s.label.toParseTree(parseTable));
        
        return disambiguator.applyFilters(this, s.label, startSymbol, tokensSeen);
    }

    void readNextToken() throws IOException {
        logCurrentToken();            
        currentToken = getNextToken();    
    }

    public void doParseStep() throws IOException {               
        parseCharacter(); //applies reductions on active stack structure and fills forshifter                      
        shifter(); //renewes active stacks with states in forshifter
        if(useIntegratedRecovery && fineGrainemode)
            recoverTolerance=maxNrOfRecoveries;
    }    

    private void initParseVariables(InputStream fis) {        
        startFrame = initActiveStacks();
        tokensSeen = 0;
        columnNumber = 0;
        lineNumber = 1;        
        currentInputStream = new PushbackInputStream(fis, 1024);
        acceptingStack = null; 
        history.keepInitialState(this);
    }    

    private void reportInvalidToken(Frame singlePreviousStack)
            throws BadTokenException, TokenExpectedException {
        if (singlePreviousStack != null) {
            Action action = singlePreviousStack.peek().getSingularAction();
            
            if (action != null && action.getActionItems().length == 1) {
                StringBuilder expected = new StringBuilder();
                
                do {
                    int token = action.getSingularRange();
                    if (token == -1) break;
                    expected.append((char) token);
                    
                    ActionItem[] items = action.getActionItems();
                    
                    if (!(items.length == 1 && items[0].type == ActionItem.SHIFT))
                        break;
                    
                    Shift shift = (Shift) items[0];
                    action = parseTable.getState(shift.nextState).getSingularAction();
                                        
                } while (action != null);

                if (expected.length() > 0)
                    throw new TokenExpectedException(this, expected.toString(), currentToken,
                                                     tokensSeen - 1, lineNumber, columnNumber);
            }
        }
        
        throw new BadTokenException(this, currentToken, tokensSeen - 1, lineNumber,
                                           columnNumber);
    }

    private void shifter() {
        logBeforeShifter();
        clearActiveStacks(false);

        IParseNode prod = parseTable.lookupProduction(currentToken);

        while (forShifter.size() > 0) {
            ActionState as = forShifter.remove();
            if(enforcePrefixAccept)
                prod=parseTable.lookupProduction(as.currentToken);
            if (!parseTable.hasRejects() || !as.st.allLinksRejected()) {
                Frame st1 = findStack(activeStacks, as.s);
                if (st1 == null) {
                    st1 = newStack(as.s);
                    addStack(st1);
                }
                st1.addLink(as.st, prod, 1);
            } else {
                if (Tools.logging) {
                    Tools.logger("Shifter: skipping rejected stack with state ",
                                 as.st.state.stateNumber);
                }
            }
        }
        logAfterShifter();
    }    

    private void addStack(Frame st1) {
        if(Tools.tracing) {
            TRACE("SG_AddStack() - " + st1.state.stateNumber);
        }
        activeStacks.addFirst(st1);
    }    

    private void parseCharacter() throws IOException {
        logBeforeParseCharacter();

        ArrayDeque<Frame> actives = new ArrayDeque<Frame>(activeStacks); // FIXME avoid garbage        
        clearForActorDelayed(false);
        clearForShifter(false);
        recoveryActor.clear();
        while (actives.size() > 0 || forActor.size() > 0) {
            Frame st;
            st = pickStackNodeFromActivesOrForActor(actives);
            if (!st.allLinksRejected()) {
                actor(st);
            }
            
            if(actives.size() == 0 && forActor.size() == 0) {
                reduceRecoverOnly=false;
                fillForActorWithDelayedFrames(); //Fills foractor, clears foractor delayed
            }
            if(fineGrainemode && actives.size() == 0 && forActor.size() == 0) {
                if(recoverTolerance<=0 || recoveryActor.size()==0){
                    reduceRecoverOnly=false;
                    return;
                }
                fillForActorWithRecoverFrames(); //Fills foractor, clears recover actor
                recoverTolerance-=1;
                reduceRecoverOnly=true;
            }    
        }
        return;
    }

    private void fillForActorWithDelayedFrames() {
        if(Tools.tracing) {
            TRACE("SG_ - both empty");
        }
        forActor = forActorDelayed;
        forActorDelayed = new ArrayDeque<Frame>(); // FIXME: avoid garbage
    }
    
    private void fillForActorWithRecoverFrames() {       
        forActor = recoveryActor;
        recoveryActor = new ArrayDeque<Frame>(); // FIXME: avoid garbage
    }

    private Frame pickStackNodeFromActivesOrForActor(ArrayDeque<Frame> actives) {
        Frame st;
        if(actives.size() > 0) {
            if(Tools.tracing) {
                TRACE("SG_ - took active");
            }
            st = actives.remove();
        } else {
            if(Tools.tracing) {
                TRACE("SG_ - took foractor");
            }
            st = forActor.remove();
        }
        return st;
    }    

    private void actor(Frame st) throws IOException {
        State s = st.peek();
        logBeforeActor(st, s);        
        for (Action action : s.getActions()) {
            if(enforcePrefixAccept)
                currentToken = action.getFirstCharValue();
            if (action.accepts(currentToken)) {
                for (ActionItem ai : action.getActionItems()) {                    
                    switch (ai.type) {
                        case ActionItem.SHIFT: {
                            if(reduceRecoverOnly)
                                break;
                            Shift sh = (Shift) ai;
                            ActionState actState = new ActionState(st, parseTable.getState(sh.nextState));
                            actState.currentToken = currentToken;                            
                            addShiftPair(actState); //Adds StackNode to forshifter
                            statsRecordParsers(); //sets some values un current parse state
                            break;
                        }
                        case ActionItem.REDUCE: {
                            Reduce red = (Reduce) ai;
                            doReductions(st, red.production);
                            break;
                        }
                        case ActionItem.REDUCE_LOOKAHEAD: {
                            ReduceLookahead red = (ReduceLookahead) ai;
                            if(checkLookahead(red)) {
                                if(Tools.tracing) {
                                    TRACE("SG_ - ok");
                                }
                                doReductions(st, red.production);
                            }
                            break;
                        }
                        case ActionItem.ACCEPT: {
                            if(reduceRecoverOnly)
                                break;
                            if (!st.allLinksRejected()) {
                                acceptingStack = st;
                                if (Tools.logging) {
                                    Tools.logger("Reached the accept state");
                                }
                            }
                            break;
                        }
                        default:
                            throw new NotImplementedException();
                     }
                }
            }            
        }
        
        if(Tools.tracing) {
            TRACE("SG_ - actor done");
        }
    }    

    private boolean checkLookahead(ReduceLookahead red) throws IOException {
        return doCheckLookahead(red, red.getCharRanges(), 0);
    }
    
    private boolean doCheckLookahead(ReduceLookahead red, RangeList[] charClass, int pos) throws IOException {
        if(Tools.tracing) {
            TRACE("SG_CheckLookAhead() - ");
        }
        
        int c = currentInputStream.read();
        
        // EOF
        if(c == -1) 
            return true;
        
        boolean permit = true;
        
        if(pos < charClass.length)
            permit = charClass[pos].within(c) ? false : doCheckLookahead(red, charClass, pos + 1);

        currentInputStream.unread(c);
        return permit;
    }

    private void addShiftPair(ActionState state) {
        if(Tools.tracing) {
            TRACE("SG_AddShiftPair() - " + state.s.stateNumber);
        }
        forShifter.add(state);
    }

    private void statsRecordParsers() {
        if (forShifter.size() > maxBranches) {
            maxBranches = forShifter.size();
            maxToken = currentToken;
            maxColumn = columnNumber;
            maxLine = lineNumber;
            maxTokenNumber = tokensSeen;
        }
    }

    private void doReductions(Frame st, Production prod) throws IOException {
        if(recoverModeOk(st, prod)){
            List<Path> paths = st.findAllPaths(prod.arity);         
            logBeforeDoReductions(st, prod, paths.size());
            reduceAllPaths(prod, paths);
            logAfterDoReductions();
        }
    }
    
    private boolean recoverModeOk(Frame st, Production prod) {
        if(useIntegratedRecovery && prod.isRecoverProduction() && !reduceRecoverOnly && recoverTolerance>0){
           //if(findStack(recoveryActor, st.state)==null)
            if(!recoveryActor.contains(st))
                recoveryActor.addFirst(st);
        }
        // TODO: is this condition right??
        return !useIntegratedRecovery || prod.isRecoverProduction() == reduceRecoverOnly;
    }
    
    private void doLimitedReductions(Frame st, Production prod, Link l) throws IOException { //Todo: Look add sharing code with doReductions
        if(recoverModeOk(st, prod)){
            List<Path> paths = st.findLimitedPaths(prod.arity, l); //find paths containing the link         
            logBeforeLimitedReductions(st, prod, l, paths);        
            reduceAllPaths(prod, paths);
        }
    }

    private void reduceAllPaths(Production prod, List<Path> paths)
            throws IOException {
        
        for (int i = paths.size() - 1; i >= 0; i--) {
            Path path = paths.get(i);
            List<IParseNode> kids = path.getATerms();
            Frame st0 = path.getEnd();
            State next = parseTable.go(st0.peek(), prod.label);
            logReductionPath(prod, path, kids, st0, next);
            reducer(st0, next, prod, kids, path);
        }
        clearPath(paths);
        
        if (asyncAborted) {
            // Rethrown as ParseTimeoutException in SGLR.sglrParse()
            throw new CancellationException("Long-running parse job aborted");
        }
    }

    
    private void clearPath(List<Path> paths) {
        if(Tools.tracing) {
            SGLR.TRACE("SG_ClearPath() - " + paths.size());
        }
        paths.clear();
    }

    private void reducer(Frame st0, State s, Production prod, List<IParseNode> kids, Path path) throws IOException {
        int length = path.getLength();        
        int numberOfRecoveries = calcRecoverCount(prod, path); 
        if(fineGrainemode && calcRecoverCountRestricted(prod, path) > maxNrOfRecoveries)
            return;
        IParseNode t = prod.apply(kids);
        Frame st1; 
        Link nl;
        if(prod.isRecoverProduction()){
            if(!useIntegratedRecovery)
            {                
                recoverHandler.handleRecoverProduction(st0, s, length, numberOfRecoveries, t);
                if(recoverHandler.haltsOnRecoverProduction(st0))
                    return;
            }
        }                
        logBeforeReducer(s, prod, length);
        increaseReductionCount();        
        st1 = findStack(activeStacks, s);
        if (st1 == null) {
            addNewStack(st0, s, prod, length, numberOfRecoveries, t);            
        } else {
            /* A stack with state s exists; check for ambiguities */
            nl = st1.findDirectLink(st0);

            if (nl != null) {
                logAmbiguity(st0, prod, st1, nl);
                if (prod.isRejectProduction()) {
                    nl.reject();
                }
                handleAmbiguity(numberOfRecoveries, t, nl);

            } else {
                nl = st1.addLink(st0, t, length);
                nl.recoverCount = numberOfRecoveries;
                if (prod.isRejectProduction())
                    nl.reject();                
                logAddedLink(st0, st1, nl);              
                actorOnActiveStacksOverNewLink(nl);
            }
        }
        if(Tools.tracing) {
            TRACE_ActiveStacks();
            TRACE("SG_ - reducer done");
        }
    }
    
    private void handleAmbiguity(int numberOfRecoveries, IParseNode t, Link nl) throws IOException {        
        if(enforcePrefixAccept)
            return; //not interested in ambiguity!
        //if both branches contain no recover productions and not in recover mode, create an Amb node.
        if(numberOfRecoveries == 0 && nl.recoverCount==0){            
            if(recoverIntegrator==null)
                createAmbNode(t, nl);
            else if (!recoverIntegrator.isActive())
                createAmbNode(t, nl);
            return;
        }
        // old recovery method
        if(!useIntegratedRecovery){
            recoverHandler.handleAmbiguity(numberOfRecoveries, t, nl);
            return;
        }              
        //integrated recovery, not prefix accept, recover branch
        int nlOld = nl.recoverCount;
        recoverDisambiguator.handleAmbiguity(numberOfRecoveries, t, nl);
        if(nl.recoverCount < nlOld)
            actorOnActiveStacksOverNewLink(nl);
                        
    }

    void createAmbNode(IParseNode t, Link nl) {
        nl.addAmbiguity(t, tokensSeen);
        ambiguityManager.increaseAmbiguityCalls();
    }
    
    private void addNewStack(Frame st0, State s, Production prod, int length,
            int numberOfRecoveries, IParseNode t) {
        Frame st1;
        Link nl;
        /* Found no existing stack with for state s; make new stack */
        st1 = newStack(s);            
        nl = st1.addLink(st0, t, length);
        nl.recoverCount = numberOfRecoveries;   
        addStack(st1);            
        forActorDelayed.addFirst(st1);
        if(Tools.tracing) {
            TRACE("SG_AddStack() - " + st1.state.stateNumber);
        }
        if (prod.isRejectProduction()) {
            if (Tools.logging) {
                Tools.logger("Reject [new]");
            }
            nl.reject();
            increaseRejectCount();
        }
    }  

    private void actorOnActiveStacksOverNewLink(Link nl) throws IOException {
        // Note: ActiveStacks can be modified inside doLimitedReductions
        // new elements may be inserted at the beginning
        final int sz = activeStacks.size();
        for (int i = 0; i < sz; i++) {
//                for(Frame st2 : activeStacks) {
            if(Tools.tracing) {
                TRACE("SG_ activeStack - ");
            }
            int pos = activeStacks.size() - sz + i;
            Frame st2 = activeStacks.get(pos);
            boolean b0 = st2.allLinksRejected();
            boolean b1 = inReduceStacks(forActor, st2);
            boolean b2 = inReduceStacks(forActorDelayed, st2);
            if (b0 || b1 || b2)
                continue; //stacknode will find reduction in regular process

            for (Action action : st2.peek().getActions()) {
                if (action.accepts(currentToken) || enforcePrefixAccept) {
                    for (ActionItem ai : action.getActionItems()) {                  
                        switch(ai.type) {
                            case ActionItem.REDUCE:
                                Reduce red = (Reduce) ai;
                                doLimitedReductions(st2, red.production, nl);                           
                                break;
                            case ActionItem.REDUCE_LOOKAHEAD:
                                ReduceLookahead red2 = (ReduceLookahead) ai;                         
                                if(checkLookahead(red2)) {
                                    doLimitedReductions(st2, red2.production, nl);                               
                                }
                                break;
                        }
                    }
                }
            }
        }
    }    

    private int calcRecoverCount(Production prod, Path path) {
        int numberOfRecoveries = path.getRecoverCount();
        if(prod.isRecoverProduction())
        {
            numberOfRecoveries+=1;
        }
        return numberOfRecoveries;
    }
    
    private int calcRecoverCountRestricted(Production prod, Path path) {
        int numberOfRecoveries = path.getRecoverCount(lengthAvoidCheck);
        if(prod.isRecoverProduction())
        {
            numberOfRecoveries +=1;
        }
        return numberOfRecoveries;
    }
    
    private boolean inReduceStacks(Queue<Frame> q, Frame frame) {
        if(Tools.tracing) {
            TRACE("SG_InReduceStacks() - " + frame.state.stateNumber);
        }
        return q.contains(frame);
    }

    protected Frame newStack(State s) {
        if(Tools.tracing) {
            TRACE("SG_NewStack() - " + s.stateNumber);
        }
        return new Frame(s);
    }

    private void increaseReductionCount() {
        reductionCount++;
    }

    protected void increaseRejectCount() {
        rejectCount++;
    }

    protected int getRejectCount() {
        return rejectCount;
    }

    Frame findStack(ArrayDeque<Frame> stacks, State s) {
        if(Tools.tracing) {
            TRACE("SG_FindStack() - " + s.stateNumber);
        }

        // We need only check the top frames of the active stacks.
        if (Tools.debugging) {
            Tools.debug("findStack() - ", dumpActiveStacks());
            Tools.debug(" looking for ", s.stateNumber);
        }

        final int size = stacks.size();
        for (int i = 0; i < size; i++) {
            if (stacks.get(i).state.stateNumber == s.stateNumber) {
                if(Tools.tracing) {
                    TRACE("SG_ - found stack");
                }
                return stacks.get(i);
            }
        }
        if(Tools.tracing) {
            TRACE("SG_ - stack not found");
        }
        return null;
    }     
   

    private int getNextToken() throws IOException {
        if(Tools.tracing) {
            TRACE("SG_NextToken() - ");
        }

        int t = currentInputStream.read();
        updateParserFields(t);
        if(t==-1)
            return SGLR.EOF;
        return t;
    }

    protected void updateParserFields(int t) {
        tokensSeen++;

        if (Tools.debugging) {
            Tools.debug("getNextToken() - ", t, "(", (char) t, ")");
        }

        switch (t) {
        case '\n':
            lineNumber++;
            columnNumber = 0;
            break;
        case '\t':
            columnNumber = (columnNumber / TAB_SIZE + 1) * TAB_SIZE;
            break;
        case -1:
            break;
        default:
            columnNumber++;
        }
    }

    static int num = 0;

    @Deprecated
    public void setFilter(boolean filter) {
        getDisambiguator().setFilterAny(filter);
    }

    public void clear() {
        if (this.acceptingStack != null) {
            this.acceptingStack.clear();
        }

        clearActiveStacks(true);
        clearForActorDelayed(true);
        clearForActor(true);
        clearForShifter(true);

        this.parseTable = null;
        this.factory = null;
        this.ambiguityManager = null; // todo clear
    }

    private void clearForShifter(boolean all) {
        if (all) {
            for (ActionState as : forShifter) {
                as.clear(all);
            }
        }
        this.forShifter.clear();
    }

    private void clearForActor(boolean all) {
        if (all) {
            for (Frame frame : forActor) {
                frame.clear();
            }
        }
        forActor.clear();
    }

    private void clearForActorDelayed(boolean all) {
        if (all) {
            for (Frame frame : forActorDelayed) {
                frame.clear();
            }
        }
        forActorDelayed.clear();
    }

    private void clearActiveStacks(boolean all) {
        if (all) {
            for (Frame frame : activeStacks) {
                frame.clear();
            }
        }
        activeStacks.clear();
    }

    ParseTable getParseTable() {
        return parseTable;
    }

    AmbiguityManager getAmbiguityManager() {
        return ambiguityManager;
    }
    
    public Disambiguator getDisambiguator() {
        return disambiguator;
    }
    
    public void setDisambiguator(Disambiguator disambiguator) {
        this.disambiguator = disambiguator;
    }

    public ATermFactory getFactory() {
        return factory;
    }

    public int getReductionCount() {
        return reductionCount;
    }

    public int getRejectionCount() {
        return rejectCount;
    }
    
    @Deprecated
    public static void setWorkAroundMultipleLookahead(boolean value) {
        WORK_AROUND_MULTIPLE_LOOKAHEAD = value;
    }   
       

      
      
    
    ////////////////////////////////////////////////////// Log functions ///////////////////////////////////////////////////////////////////////////////
    
    static void TRACE(String string) {
        System.err.println("[" + num + "] " + string);
        num++;
    }

    private String dumpActiveStacks() {
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        if (activeStacks == null) {
            sb.append(" GSS unitialized");
        } else {
            sb.append("{").append(activeStacks.size()).append("} ");
            for (Frame f : activeStacks) {
                if (!first)
                    sb.append(", ");
                sb.append(f.dumpStack());
                first = false;
            }
        }
        return sb.toString();
    }

    
    private void logParseResult(Link s) {
        if (isDebugging()) {
            Tools.debug("internal parse tree:\n", s.label);
        }

        if(Tools.tracing) {
            TRACE("SG_ - internal tree: " + s.label);
        }       
                
        if (Tools.measuring) {
            Measures m = new Measures();
            //Tools.debug("Time (ms): " + (System.currentTimeMillis()-startTime));
            m.setTime(System.currentTimeMillis() - startTime);
            //Tools.debug("Red.: " + reductionCount);
            m.setReductionCount(reductionCount);
            //Tools.debug("Nodes: " + Frame.framesCreated);
            m.setFramesCreated(Frame.framesCreated);
            //Tools.debug("Links: " + Link.linksCreated);
            m.setLinkedCreated(Link.linksCreated);
            //Tools.debug("avoids: " + s.avoidCount);
            m.setAvoidCount(s.recoverCount);
            //Tools.debug("Total Time: " + parseTime);
            m.setParseTime(parseTime);
            //Tools.debug("Total Count: " + parseCount);
            Measures.setParseCount(++parseCount);
            //Tools.debug("Average Time: " + (int)parseTime / parseCount);
            m.setAverageParseTime((int)parseTime / parseCount);
            m.setRecoverTime(recoverHandler.getRecoverTime());
            Tools.setMeasures(m);
        }
    }
    

    private void logBeforeParsing() {
        if(Tools.tracing) {
            TRACE("SG_Parse() - ");
        }

        if (Tools.debugging) {
            Tools.debug("parse() - ", dumpActiveStacks());
        }
    }
    
    private void logAfterParsing()
            throws BadTokenException, TokenExpectedException {
        Frame singlePreviousStack;
        singlePreviousStack = activeStacks.size() == 1
        ? activeStacks.get(0)
        : null;
        if (isLogging()) {
            Tools.logger("Number of lines: ", lineNumber);
            Tools.logger("Maximum ", maxBranches, " parse branches reached at token ",
                         logCharify(maxToken), ", line ", maxLine, ", column ", maxColumn,
                         " (token #", maxTokenNumber, ")");

            long elapsed = System.currentTimeMillis() - startTime;
            Tools.logger("Parse time: " + elapsed / 1000.0f + "s");
        }

        if (isDebugging()) {
            Tools.debug("Parsing complete: all tokens read");
        }

        if (acceptingStack == null) {
            reportInvalidToken(singlePreviousStack);
        }

        if (isDebugging()) {
            Tools.debug("Accepting stack exists");
        }
    }

    private void logCurrentToken() {
        if (isLogging()) {
            Tools.logger("Current token (#", tokensSeen, "): ", logCharify(currentToken));
        }
    }
    
    private void logAfterShifter() {
        if(Tools.tracing) {
            TRACE("SG_DiscardShiftPairs() - ");
            TRACE_ActiveStacks();
        }
    }

    private void logBeforeShifter() {
        if(Tools.tracing) {
            TRACE("SG_Shifter() - ");
            TRACE_ActiveStacks();
        }
        
        if (Tools.logging) {
            Tools.logger("#", tokensSeen, ": shifting ", forShifter.size(), " parser(s) -- token ",
                         logCharify(currentToken), ", line ", lineNumber, ", column ", columnNumber);
        }

        if (Tools.debugging) {
            Tools.debug("shifter() - " + dumpActiveStacks());

            Tools.debug(" token   : " + currentToken);
            Tools.debug(" parsers : " + forShifter.size());
        }
    }
    
    private void logBeforeParseCharacter() {
        if(Tools.tracing) {
            TRACE("SG_ParseToken() - ");
        }

        if (Tools.debugging) {
            Tools.debug("parseCharacter() - " + dumpActiveStacks());
            Tools.debug(" # active stacks : " + activeStacks.size());
        }

        /* forActor = *///computeStackOfStacks(activeStacks);

        if (Tools.debugging) {
            Tools.debug(" # for actor     : " + forActor.size());
        }
    }
    
    private String logCharify(int currentToken) {
        switch (currentToken) {
        case 32:
            return "\\32";
        case SGLR.EOF:
            return "EOF";
        case '\n':
            return "\\n";
        case 0:
            return "\\0";
        default:
            return "" + (char) currentToken;
        }
    }
    
    private void logBeforeActor(Frame st, State s) {
        List<ActionItem> actionItems = null;
        
        if (Tools.debugging || Tools.tracing) {
            actionItems = s.getActionItems(currentToken);
        }
        
        if(Tools.tracing) {
            TRACE("SG_Actor() - " + st.state.stateNumber);
            TRACE_ActiveStacks();
        }
        
        if (Tools.debugging) {
            Tools.debug("actor() - ", dumpActiveStacks());
        }       

        if (Tools.debugging) {
            Tools.debug(" state   : ", s.stateNumber);
            Tools.debug(" token   : ", currentToken);
        }        

        if (Tools.debugging) {
            Tools.debug(" actions : ", actionItems);
        }
        
        if(Tools.tracing) {
            TRACE("SG_ - actions: " + actionItems.size());
        }
    }
    
    private void logAfterDoReductions() {
        if (Tools.debugging) {
            Tools.debug("<doReductions() - " + dumpActiveStacks());
        }
        
        if(Tools.tracing) {
            TRACE("SG_ - doreductions done");
        }
    }

    private void logReductionPath(Production prod, Path path,
            List<IParseNode> kids, Frame st0, State next) {
        if (Tools.debugging) {
            Tools.debug(" path: ", path);
            Tools.debug(" kids: ", kids);        
            Tools.debug(st0.state);
        }            

        if (Tools.logging) {
            Tools.logger("Goto(", st0.peek().stateNumber, ",", prod.label + ") == ",
                         next.stateNumber);
        }
    }   
    

    private void logBeforeDoReductions(Frame st, Production prod,
            final int pathsCount) {
        if(Tools.tracing) {
            TRACE("SG_DoReductions() - " + st.state.stateNumber);
        }

        if (Tools.debugging) {
            Tools.debug("doReductions() - " + dumpActiveStacks());
            logReductionInfo(st, prod);       
            Tools.debug(" paths : " + pathsCount);
        }
    }
    
    private void logBeforeLimitedReductions(Frame st, Production prod, Link l,
            List<Path> paths) {
        if(Tools.tracing) {
            TRACE("SG_ - back in reducer ");
            TRACE_ActiveStacks();
            TRACE("SG_DoLimitedReductions() - " + st.state.stateNumber + ", " + l.parent.state.stateNumber);
        }

        if (Tools.debugging) {
            Tools.debug("doLimitedReductions() - ", dumpActiveStacks());
            logReductionInfo(st, prod);
            List<?> reversePaths = (List<?>) ((ArrayList<?>) paths).clone();
            Collections.reverse(reversePaths);
            Tools.debug(reversePaths);
        }
    }

    private void logReductionInfo(Frame st, Production prod) {
        Tools.debug(" state : ", st.peek().stateNumber);
        Tools.debug(" token : ", currentToken);
        Tools.debug(" label : ", prod.label);
        Tools.debug(" arity : ", prod.arity);
        Tools.debug(" stack : ", st.dumpStack());
    }

    private void logAddedLink(Frame st0, Frame st1, Link nl) {
        if (Tools.debugging) {
            Tools.debug(" added link ", nl, " from ", st1.state.stateNumber, " to ",
                        st0.state.stateNumber);
        }               

        if(Tools.tracing) {
            TRACE_ActiveStacks();
        }
    }
    
    private void logBeforeReducer(State s, Production prod, int length) {
        if(Tools.tracing) {
            TRACE("SG_Reducer() - " + s.stateNumber + ", " + length + ", " + prod.label);
            TRACE_ActiveStacks();
        }

        if (Tools.logging) {
            Tools.logger("Reducing; state ", s.stateNumber, ", token: ", logCharify(currentToken),
                         ", production: ", prod.label);
        }

        if (Tools.debugging) {
            Tools.debug("reducer() - ", dumpActiveStacks());

            Tools.debug(" state      : ", s.stateNumber);
            Tools.debug(" token      : ", logCharify(currentToken) + " (" + currentToken + ")");
            Tools.debug(" production : ", prod.label);
        }
    }

    private void TRACE_ActiveStacks() {
        TRACE("SG_ - active stacks: " + activeStacks.size());
        TRACE("SG_ - for_actor stacks: " + forActor.size());
        TRACE("SG_ - for_actor_delayed stacks: " + forActorDelayed.size());
    }

   
    private void logAmbiguity(Frame st0, Production prod, Frame st1, Link nl) {
        if (Tools.logging) {
            Tools.logger("Ambiguity: direct link ", st0.state.stateNumber, " -> ",
                         st1.state.stateNumber, " ", (prod.isRejectProduction() ? "{reject}" : ""));
            if (nl.label instanceof ParseNode) {
                Tools.logger("nl is ", nl.isRejected() ? "{reject}" : "", " for ",
                             ((ParseNode) nl.label).label);
            }
        }

        if (Tools.debugging) {
            Tools.debug("createAmbiguityCluster - ", tokensSeen - nl.getLength() - 1, "/",
                        nl.getLength());
        }
    }    
    //-------------------------------------------------- mj: debug and recovery ------------------------
        
    //Used for debugging
    private String mjInfo() {
        String result = "";
        result += "CURR TOKEN: " + (char)currentToken;
        result += " ACTIVESTACKS: ";
        for (Frame f : activeStacks) {
            result += f.state.stateNumber;
            if(f.minAvoidValue() > 0)
                result += "$"+f.minAvoidValue() + "$";
            result += "; ";            
        }
        result += " FORACTOR: ";
        for (Frame f : forActor) {
            result += f.state.stateNumber;
            result += "; ";
        }
        result += " FORACTOR_DELAYED: ";
        for (Frame f : forActorDelayed) {
            result += f.state.stateNumber;
            result += "; ";
        }
        result += " FORSHIFTER: ";
        for (ActionState as : forShifter) {
            result += "{ ";
            result += as.st.state.stateNumber;
            result+=",";
            result += as.s.stateNumber;            
            result += "} ; ";
        }
        return result;        
    } 
    
    private String[] viewStackObject(boolean avoidFiltered){
        List<String> stackPaths = new ArrayList<String>();
        for (Frame actNode : activeStacks) {
            List<String> testMJ = actNode.getStackPaths("", avoidFiltered);
            stackPaths.addAll(testMJ);
        }
        return stackPaths.toArray(new String[stackPaths.size()]);
    }  
    
    private String[] viewRecoverActor(){
        List<String> stackPaths = new ArrayList<String>();
        for (Frame actNode : recoveryActor) {
            List<String> testMJ = actNode.getStackPaths("", false);
            stackPaths.addAll(testMJ);
        }
        return stackPaths.toArray(new String[stackPaths.size()]);
    }  
    
    private String[] viewStackObject()
    {
        return viewStackObject(false);
    }
    
    private String[] viewFilteredStackObject()
    {
        return viewStackObject(true);
    }
    
    private void mjTesting() {        
        Tools.debug((char)currentToken); 
    }

     
    
    
}
