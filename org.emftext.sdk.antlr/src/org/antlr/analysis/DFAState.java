/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
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
package org.antlr.analysis;

import org.antlr.misc.IntSet;
import org.antlr.misc.OrderedHashSet;
import org.antlr.misc.Utils;
import org.antlr.tool.Grammar;

import java.util.*;

/** A DFA state represents a set of possible NFA configurations.
 *  As Aho, Sethi, Ullman p. 117 says "The DFA uses its state
 *  to keep track of all possible states the NFA can be in after
 *  reading each input symbol.  That is to say, after reading
 *  input a1a2..an, the DFA is in a state that represents the
 *  subset T of the states of the NFA that are reachable from the
 *  NFA's start state along some path labeled a1a2..an."
 *  In conventional NFA->DFA conversion, therefore, the subset T
 *  would be a bitset representing the set of states the
 *  NFA could be in.  We need to track the alt predicted by each
 *  state as well, however.  More importantly, we need to maintain
 *  a stack of states, tracking the closure operations as they
 *  jump from rule to rule, emulating rule invocations (method calls).
 *  Recall that NFAs do not normally have a stack like a pushdown-machine
 *  so I have to add one to simulate the proper lookahead sequences for
 *  the underlying LL grammar from which the NFA was derived.
 *
 *  I use a list of NFAConfiguration objects.  An NFAConfiguration
 *  is both a state (ala normal conversion) and an NFAContext describing
 *  the chain of rules (if any) followed to arrive at that state.  There
 *  is also the semantic context, which is the "set" of predicates found
 *  on the path to this configuration.
 *
 *  A DFA state may have multiple references to a particular state,
 *  but with different NFAContexts (with same or different alts)
 *  meaning that state was reached via a different set of rule invocations.
 */
public class DFAState extends State {
    public static final int INITIAL_NUM_TRANSITIONS = 4;
	public static final int PREDICTED_ALT_UNSET = NFA.INVALID_ALT_NUMBER-1;

    /** We are part of what DFA?  Use this ref to get access to the
     *  context trees for an alt.
     */
    public DFA dfa;

    /** Track the transitions emanating from this DFA state.  The List
     *  elements are Transition objects.
     */
    protected List transitions = new ArrayList(INITIAL_NUM_TRANSITIONS);

	/** When doing an acyclic DFA, this is the number of lookahead symbols
	 *  consumed to reach this state.  This value may be nonzero for most
	 *  dfa states, but it is only a valid value if the user has specified
	 *  a max fixed lookahead.
	 */
    protected int k;

    /** The NFA->DFA algorithm may terminate leaving some states
     *  without a path to an accept state, implying that upon certain
     *  input, the decision is not deterministic--no decision about
     *  predicting a unique alternative can be made.  Recall that an
     *  accept state is one in which a unique alternative is predicted.
     */
    protected int acceptStateReachable = DFA.REACHABLE_UNKNOWN;

    /** Rather than recheck every NFA configuration in a DFA state (after
     *  resolving) in findNewDFAStatesAndAddDFATransitions just check
     *  this boolean.  Saves a linear walk perhaps DFA state creation.
     *  Every little bit helps.
     */
    protected boolean resolvedWithPredicates = false;

	/** If a closure operation finds that we tried to invoke the same
	 *  rule too many times (stack would grow beyond a threshold), it
	 *  marks the state has aborted and notifies the DecisionProbe.
	 */
	protected boolean abortedDueToRecursionOverflow = false;

	/** If we detect recursion on more than one alt, decision is non-LL(*),
	 *  but try to isolate it to only those states whose closure operations
	 *  detect recursion.  There may be other alts that are cool:
	 *
	 *  a : recur '.'
	 *    | recur ';'
	 *    | X Y  // LL(2) decision; don't abort and use k=1 plus backtracking
	 *    | X Z
	 *    ;
	 */
	protected boolean abortedDueToMultipleRecursiveAlts = false;

	/** Build up the hash code for this state as NFA configurations
     *  are added as it's monotonically increasing list of configurations.
     */
    protected int cachedHashCode;

	protected int cachedUniquelyPredicatedAlt = PREDICTED_ALT_UNSET;

    /** The set of NFA configurations (state,alt,context) for this DFA state */
    protected Set nfaConfigurations = new HashSet();

    /** Used to prevent the closure operation from looping to itself and
     *  hence looping forever.  Sensitive to the NFA state, the alt, and
     *  the context.  This just the nfa config set because we want to
	 *  prevent closures only on states contributed by closure not reach
	 *  operations.
     */
	protected Set closureBusy = new HashSet();

	/** As this state is constructed (i.e., as NFA states are added), we
     *  can easily check for non-epsilon transitions because the only
     *  transition that could be a valid label is transition(0).  When we
     *  process this node eventually, we'll have to walk all states looking
     *  for all possible transitions.  That is of the order: size(label space)
     *  times size(nfa states), which can be pretty damn big.  It's better
     *  to simply track possible labels.
     *  This is type List<Label>.
     */
    protected OrderedHashSet reachableLabels = new OrderedHashSet();

    public DFAState(DFA dfa) {
        this.dfa = dfa;
    }

    public Transition transition(int i) {
        return (Transition)transitions.get(i);
    }

    public int getNumberOfTransitions() {
        return transitions.size();
    }

    public void addTransition(Transition t) {
        transitions.add(t);
    }

	/** Add a transition from this state to target with label.  Return
	 *  the transition number from 0..n-1.
	 */
    public int addTransition(DFAState target, Label label) {
        transitions.add( new Transition(label, target) );
		return transitions.size()-1;
    }

    public Transition getTransition(int trans) {
        return (Transition)transitions.get(trans);
    }

	public void removeTransition(int trans) {
		transitions.remove(trans);
	}

    /** Add an NFA configuration to this DFA node.  Add uniquely
     *  an NFA state/alt/syntactic&semantic context (chain of invoking state(s)
     *  and semantic predicate contexts).
     *
     *  I don't see how there could be two configurations with same
     *  state|alt|synCtx and different semantic contexts because the
     *  semantic contexts are computed along the path to a particular state
     *  so those two configurations would have to have the same predicate.
     *  Nonetheless, the addition of configurations is unique on all
     *  configuration info.  I guess I'm saying that syntactic context
     *  implies semantic context as the latter is computed according to the
     *  former.
     *
     *  As we add configurations to this DFA state, track the set of all possible
     *  transition labels so we can simply walk it later rather than doing a
     *  loop over all possible labels in the NFA.
     */
    public void addNFAConfiguration(NFAState state, NFAConfiguration c) {
		if ( nfaConfigurations.contains(c) ) {
            return;
        }

        nfaConfigurations.add(c);

        // update hashCode; for some reason using context.hashCode() also
        // makes the GC take like 70% of the CPU and is slow!
        cachedHashCode += c.state + c.alt;

        // update reachableLabels
        if ( state.transition(0)!=null ) {
            Label label = state.transition(0).label;
            if ( !(label.isEpsilon()||label.isSemanticPredicate()) ) {
                if ( state.transition(1)==null ) {
                    c.singleAtomTransitionEmanating = true;
                }
                addReachableLabel(label);
            }
        }
    }

	public void addNFAConfiguration(NFAState state, int alt, NFAContext context, SemanticContext semanticContext) {
		NFAConfiguration c = new NFAConfiguration(state.stateNumber,
												  alt,
												  context,
												  semanticContext);
		addNFAConfiguration(state, c);
	}

	/** Add label uniquely and disjointly; intersection with
     *  another set or int/char forces breaking up the set(s).
     *
     *  Example, if reachable list of labels is [a..z, {k,9}, 0..9],
     *  the disjoint list will be [{a..j,l..z}, k, 9, 0..8].
     *
     *  As we add NFA configurations to a DFA state, we might as well track
     *  the set of all possible transition labels to make the DFA conversion
     *  more efficient.  W/o the reachable labels, we'd need to check the
     *  whole vocabulary space (could be 0..\uFFFF)!  The problem is that
     *  labels can be sets, which may overlap with int labels or other sets.
     *  As we need a deterministic set of transitions from any
     *  state in the DFA, we must make the reachable labels set disjoint.
     *  This operation amounts to finding the character classes for this
     *  DFA state whereas with tools like flex, that need to generate a
     *  homogeneous DFA, must compute char classes across all states.
     *  We are going to generate DFAs with heterogeneous states so we
     *  only care that the set of transitions out of a single state are
     *  unique. :)
     *
     *  The idea for adding a new set, t, is to look for overlap with the
     *  elements of existing list s.  Upon overlap, replace
     *  existing set s[i] with two new disjoint sets, s[i]-t and s[i]&t.
     *  (if s[i]-t is nil, don't add).  The remainder is t-s[i], which is
     *  what you want to add to the set minus what was already there.  The
     *  remainder must then be compared against the i+1..n elements in s
     *  looking for another collision.  Each collision results in a smaller
     *  and smaller remainder.  Stop when you run out of s elements or
     *  remainder goes to nil.  If remainder is non nil when you run out of
     *  s elements, then add remainder to the end.
     *
     *  Single element labels are treated as sets to make the code uniform.
     */
    protected void addReachableLabel(Label label) {
        /*
		System.out.println("addReachableLabel to state "+dfa.decisionNumber+"."+stateNumber+": "+label.getSet().toString(dfa.nfa.grammar));
		System.out.println("start of add to state "+dfa.decisionNumber+"."+stateNumber+": " +
				"reachableLabels="+reachableLabels.toString());
        */
		if ( reachableLabels.contains(label) ) { // exact label present
            return;
        }
        IntSet t = label.getSet();
        IntSet remainder = t; // remainder starts out as whole set to add
        int n = reachableLabels.size(); // only look at initial elements
        // walk the existing list looking for the collision
        for (int i=0; i<n; i++) {
            Label rl = (Label)reachableLabels.get(i);
            /*
            if ( label.equals(rl) ) {
                // OPTIMIZATION:
                // exact label already here, just return; previous addition
                // would have made everything unique/disjoint
                return;
            }
            */
            IntSet s_i = rl.getSet();
            IntSet intersection = s_i.and(t);
            /*
			System.out.println("comparing ["+i+"]: "+label.toString(dfa.nfa.grammar)+" & "+
                    rl.toString(dfa.nfa.grammar)+"="+
                    intersection.toString(dfa.nfa.grammar));
            */
			if ( intersection.isNil() ) {
                continue;
            }

            // For any (s_i, t) with s_i&t!=nil replace with (s_i-t, s_i&t)
            // (ignoring s_i-t if nil; don't put in list)

            // Replace existing s_i with intersection since we
            // know that will always be a non nil character class
            reachableLabels.set(i, new Label(intersection));

            // Compute s_i-t to see what is in current set and not in incoming
            IntSet existingMinusNewElements = s_i.subtract(t);
			//System.out.println(s_i+"-"+t+"="+existingMinusNewElements);
            if ( !existingMinusNewElements.isNil() ) {
                // found a new character class, add to the end (doesn't affect
                // outer loop duration due to n computation a priori.
                Label newLabel = new Label(existingMinusNewElements);
                reachableLabels.add(newLabel);
            }

			/*
            System.out.println("after collision, " +
                    "reachableLabels="+reachableLabels.toString());
					*/

            // anything left to add to the reachableLabels?
            remainder = t.subtract(s_i);
            if ( remainder.isNil() ) {
                break; // nothing left to add to set.  done!
            }

            t = remainder;
        }
        if ( !remainder.isNil() ) {
			/*
			System.out.println("before add remainder to state "+dfa.decisionNumber+"."+stateNumber+": " +
					"reachableLabels="+reachableLabels.toString());
			System.out.println("remainder state "+dfa.decisionNumber+"."+stateNumber+": "+remainder.toString(dfa.nfa.grammar));
            */
			Label newLabel = new Label(remainder);
            reachableLabels.add(newLabel);
        }
		/*
		System.out.println("#END of add to state "+dfa.decisionNumber+"."+stateNumber+": " +
				"reachableLabels="+reachableLabels.toString());
				*/
    }

    public OrderedHashSet getReachableLabels() {
        return reachableLabels;
    }

    public Set getNFAConfigurations() {
        return this.nfaConfigurations;
    }

    public void setNFAConfigurations(Set configs) {
        this.nfaConfigurations = configs;
    }

    /** A decent hash for a DFA state is the sum of the NFA state/alt pairs.
     *  This is used when we add DFAState objects to the DFA.states Map and
     *  when we compare DFA states.  Computed in addNFAConfiguration()
     */
    public int hashCode() {
        return cachedHashCode;
    }

    /** Two DFAStates are equal if their NFA configuration sets are the
	 *  same. This method is used to see if a DFA state already exists.
	 *
     *  Because the number of alternatives and number of NFA configurations are
     *  finite, there is a finite number of DFA states that can be processed.
     *  This is necessary to show that the algorithm terminates.
	 *
	 *  Cannot test the state numbers here because in DFA.addState we need
	 *  to know if any other state exists that has this exact set of NFA
	 *  configurations.  The DFAState state number is irrelevant.
     */
    public boolean equals(Object o) {
        DFAState other = (DFAState)o;
        if ( o==null ) {
            return false;
        }
        if ( this.hashCode()!=other.hashCode() ) {
            return false;
        }
		// if not same number of NFA configuraitons, cannot be same state
		if ( this.nfaConfigurations.size() != other.nfaConfigurations.size() ) {
			return false;
		}

		// compare set of NFA configurations in this set with other
        Iterator iter = this.nfaConfigurations.iterator();
        while (iter.hasNext()) {
            NFAConfiguration myConfig = (NFAConfiguration) iter.next();
			if ( !other.nfaConfigurations.contains(myConfig) ) {
				return false;
			}
        }
        return true;
    }

    /** Walk each configuration and if they are all the same alt, return
     *  that alt else return NFA.INVALID_ALT_NUMBER.  Ignore resolved
     *  configurations, but don't ignore resolveWithPredicate configs
     *  because this state should not be an accept state.  We need to add
     *  this to the work list and then have semantic predicate edges
     *  emanating from it.
     */
    public int getUniquelyPredictedAlt() {
		if ( cachedUniquelyPredicatedAlt!=PREDICTED_ALT_UNSET ) {
			return cachedUniquelyPredicatedAlt;
		}
        int alt = NFA.INVALID_ALT_NUMBER;
        Iterator iter = nfaConfigurations.iterator();
        NFAConfiguration configuration;
        while (iter.hasNext()) {
            configuration = (NFAConfiguration) iter.next();
            // ignore anything we resolved; predicates will still result
            // in transitions out of this state, so must count those
            // configurations; i.e., don't ignore resolveWithPredicate configs
            if ( configuration.resolved ) {
                continue;
            }
            if ( alt==NFA.INVALID_ALT_NUMBER ) {
                alt = configuration.alt; // found first nonresolved alt
            }
            else if ( configuration.alt!=alt ) {
                return NFA.INVALID_ALT_NUMBER;
            }
        }
		this.cachedUniquelyPredicatedAlt = alt;
        return alt;
    }

	/** Return the uniquely mentioned alt from the NFA configurations;
	 *  Ignore the resolved bit etc...  Return INVALID_ALT_NUMBER
	 *  if there is more than one alt mentioned.
	 */ 
	public int getUniqueAlt() {
		int alt = NFA.INVALID_ALT_NUMBER;
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			if ( alt==NFA.INVALID_ALT_NUMBER ) {
				alt = configuration.alt; // found first alt
			}
			else if ( configuration.alt!=alt ) {
				return NFA.INVALID_ALT_NUMBER;
			}
		}
		return alt;
	}

	/** When more than one alternative can match the same input, the first
	 *  alternative is chosen to resolve the conflict.  The other alts
	 *  are "turned off" by setting the "resolved" flag in the NFA
	 *  configurations.  Return the set of disabled alternatives.  For
	 *
	 *  a : A | A | A ;
	 *
	 *  this method returns {2,3} as disabled.  This does not mean that
	 *  the alternative is totally unreachable, it just means that for this
	 *  DFA state, that alt is disabled.  There may be other accept states
	 *  for that alt.
	 */
	public Set getDisabledAlternatives() {
		Set disabled = new LinkedHashSet();
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			if ( configuration.resolved ) {
				disabled.add(Utils.integer(configuration.alt));
			}
		}
		return disabled;
	}

	/**
	public int getNumberOfEOTNFAStates() {
		int n = 0;
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			NFAState s = dfa.nfa.getState(configuration.state);
			if ( s.isEOTState() ) {
				n++;
			}
		}
		return n;
	}
    */
	
	protected Set getNonDeterministicAlts() {
		int user_k = dfa.getUserMaxLookahead();
		if ( user_k>0 && user_k==k ) {
			// if fixed lookahead, then more than 1 alt is a nondeterminism
			// if we have hit the max lookahead
			return getAltSet();
		}
		else if ( abortedDueToMultipleRecursiveAlts || abortedDueToRecursionOverflow ) {
			// if we had to abort for non-LL(*) state assume all alts are a problem
			return getAltSet();
		}
		else {
			return getConflictingAlts();
		}
	}

    /** Walk each NFA configuration in this DFA state looking for a conflict
     *  where (s|i|ctx) and (s|j|ctx) exist, indicating that state s with
     *  context conflicting ctx predicts alts i and j.  Return an Integer set
	 *  of the alternative numbers that conflict.  Two contexts conflict if
	 *  they are equal or one is a stack suffix of the other or one is
	 *  the empty context.
	 *
     *  Use a hash table to record the lists of configs for each state
	 *  as they are encountered.  We need only consider states for which
	 *  there is more than one configuration.  The configurations' predicted
	 *  alt must be different or must have different contexts to avoid a
	 *  conflict.
	 *
	 *  Don't report conflicts for DFA states that have conflicting Tokens
	 *  rule NFA states; they will be resolved in favor of the first rule.
     */
    protected Set getConflictingAlts() {
		// TODO this is called multiple times: cache result?
		//System.out.println("getNondetAlts for DFA state "+stateNumber);
 		Set nondeterministicAlts = new HashSet();

		// If only 1 NFA conf then no way it can be nondeterministic;
		// save the overhead.  There are many o-a->o NFA transitions
		// and so we save a hash map and iterator creation for each
		// state.
		if ( nfaConfigurations.size()<=1 ) {
			return null;
		}

		// First get a list of configurations for each state.
		// Most of the time, each state will have one associated configuration
		Iterator iter = nfaConfigurations.iterator();
		Map stateToConfigListMap = new HashMap();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			Integer stateI = Utils.integer(configuration.state);
			List prevConfigs = (List)stateToConfigListMap.get(stateI);
			if ( prevConfigs==null ) {
				prevConfigs = new ArrayList();
				stateToConfigListMap.put(stateI, prevConfigs);
			}
			prevConfigs.add(configuration);
		}

		// potential conflicts are states with > 1 configuration and diff alts
		Set states = stateToConfigListMap.keySet();
		int numPotentialConflicts = 0;
		for (Iterator it = states.iterator(); it.hasNext();) {
			Integer stateI = (Integer) it.next();
			boolean thisStateHasPotentialProblem = false;
			List configsForState = (List)stateToConfigListMap.get(stateI);
			int alt=0;
			for (int i = 0; i < configsForState.size() && configsForState.size()>1 ; i++) {
				NFAConfiguration c = (NFAConfiguration) configsForState.get(i);
				if ( alt==0 ) {
					alt = c.alt;
				}
				else if ( c.alt!=alt ) {
					/*
					System.out.println("potential conflict in state "+stateI+
									   " configs: "+configsForState);
					*/
					// 11/28/2005: don't report closures that pinch back
					// together in Tokens rule.  We want to silently resolve
					// to the first token definition ala lex/flex by ignoring
					// these conflicts.
					if ( dfa.nfa.grammar.type!=Grammar.LEXER ||
						 !dfa.decisionNFAStartState.enclosingRule.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) )
					{
						numPotentialConflicts++;
						thisStateHasPotentialProblem = true;
					}
				}
			}
			if ( !thisStateHasPotentialProblem ) {
				// remove NFA state's configurations from
				// further checking; no issues with it
				// (can't remove as it's concurrent modification; set to null)
				stateToConfigListMap.put(stateI, null);
			}
		}

		// a fast check for potential issues; most states have none
		if ( numPotentialConflicts==0 ) {
			return null;
		}

		// we have a potential problem, so now go through config lists again
		// looking for different alts (only states with potential issues
		// are left in the states set).  Now we will check context.
		// For example, the list of configs for NFA state 3 in some DFA
		// state might be:
		//   [3|2|[28 18 $], 3|1|[28 $], 3|1, 3|2]
		// I want to create a map from context to alts looking for overlap:
		//   [28 18 $] -> 2
		//   [28 $] -> 1
		//   [$] -> 1,2
		// Indeed a conflict exists as same state 3, same context [$], predicts
		// alts 1 and 2.
		// walk each state with potential conflicting configurations
		for (Iterator it = states.iterator(); it.hasNext();) {
			Integer stateI = (Integer) it.next();
			List configsForState = (List)stateToConfigListMap.get(stateI);
			// compare each configuration pair s, t to ensure:
			// s.ctx different than t.ctx if s.alt != t.alt
			for (int i = 0; configsForState!=null && i < configsForState.size(); i++) {
				NFAConfiguration s = (NFAConfiguration) configsForState.get(i);
				for (int j = i+1; j < configsForState.size(); j++) {
					NFAConfiguration t = (NFAConfiguration)configsForState.get(j);
					// conflicts means s.ctx==t.ctx or s.ctx is a stack
					// suffix of t.ctx or vice versa (if alts differ).
					// Also a conflict if s.ctx or t.ctx is empty
					if ( s.alt != t.alt && s.context.conflictsWith(t.context) ) {
						nondeterministicAlts.add(Utils.integer(s.alt));
						nondeterministicAlts.add(Utils.integer(t.alt));
					}
				}
			}
		}

		if ( nondeterministicAlts.size()==0 ) {
			return null;
		}
        return nondeterministicAlts;
    }

	/** Get the set of all alts mentioned by all NFA configurations in this
	 *  DFA state.
	 */
	public Set getAltSet() {
		Set alts = new HashSet();
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			alts.add(Utils.integer(configuration.alt));
		}
		if ( alts.size()==0 ) {
			return null;
		}
		return alts;
	}

	/** Get the set of all states mentioned by all NFA configurations in this
	 *  DFA state associated with alt.
	 */
	public Set getNFAStatesForAlt(int alt) {
		Set alts = new HashSet();
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			if ( configuration.alt == alt ) {
				alts.add(Utils.integer(configuration.state));
			}
		}
		return alts;
	}

	/** For gated productions, we need a list of all predicates for the
	 *  target of an edge so we can gate the edge based upon the predicates
	 *  associated with taking that path (if any).
	 *
	 *  experimental 11/29/2005
	 *
	public Set getGatedPredicatesInNFAConfigurations() {
		Set preds = new HashSet();
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			if ( configuration.semanticContext.isGated() ) {
				preds.add(configuration.semanticContext);
			}
		}
		if ( preds.size()==0 ) {
			return null;
		}
		return preds;
	}
	 */

	public Set getSyntacticPredicatesInNFAConfigurations() {
		Set synpreds = new HashSet();
		Iterator iter = nfaConfigurations.iterator();
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			SemanticContext gatedPredExpr =
				configuration.semanticContext.getGatedPredicateContext();
			// if this is a manual syn pred (gated and syn pred), add
			if ( gatedPredExpr!=null &&
				 configuration.semanticContext.isSyntacticPredicate() )
			{
				synpreds.add(configuration.semanticContext);
			}
		}
		if ( synpreds.size()==0 ) {
			return null;
		}
		return synpreds;
	}

	/** For gated productions, we need an OR'd list of all predicates for the
	 *  target of an edge so we can gate the edge based upon the predicates
	 *  associated with taking that path (if any).
	 *
	 *  For syntactic predicates, we only want to generate predicate
	 *  evaluations as it transitions to an accept state; waste to
	 *  do it earlier.  So, only add gated preds derived from manually-
	 *  specified syntactic predicates if this is an accept state.
	 *
	 *  Also, since configurations w/o gated predicates are like true
	 *  gated predicates, finding a configuration whose alt has no gated
	 *  predicate implies we should evaluate the predicate to true. This
	 *  means the whole edge has to be ungated. Consider:
	 *
	 *	 X : ('a' | {p}?=> 'a')
	 *	   | 'a' 'b'
	 *	   ;
	 *
	 *  Here, you 'a' gets you from s0 to s1 but you can't test p because
	 *  plain 'a' is ok.  It's also ok for starting alt 2.  Hence, you can't
	 *  test p.  Even on the edge going to accept state for alt 1 of X, you
	 *  can't test p.  You can get to the same place with and w/o the context.
	 *  Therefore, it is never ok to test p in this situation. 
	 *
	 *  TODO: cache this as it's called a lot; or at least set bit if >1 present in state
	 */
	public SemanticContext getGatedPredicatesInNFAConfigurations() {
		Iterator iter = nfaConfigurations.iterator();
		SemanticContext unionOfPredicatesFromAllAlts = null;
		NFAConfiguration configuration;
		while (iter.hasNext()) {
			configuration = (NFAConfiguration) iter.next();
			SemanticContext gatedPredExpr =
				configuration.semanticContext.getGatedPredicateContext();
			if ( gatedPredExpr==null ) {
				// if we ever find a configuration w/o a gated predicate
				// (even if it's a nongated predicate), we cannot gate
				// the indident edges.
				return null;
			}
			else if ( acceptState || !configuration.semanticContext.isSyntacticPredicate() ) {
				// at this point we have a gated predicate and, due to elseif,
				// we know it's an accept and not a syn pred.  In this case,
				// it's safe to add the gated predicate to the union.  We
				// only want to add syn preds if it's an accept state.  Other
				// gated preds can be used with edges leading to accept states.
				if ( unionOfPredicatesFromAllAlts==null ) {
					unionOfPredicatesFromAllAlts = gatedPredExpr;
				}
				else {
					unionOfPredicatesFromAllAlts =
						SemanticContext.or(unionOfPredicatesFromAllAlts,gatedPredExpr);
				}
			}
		}
		if ( unionOfPredicatesFromAllAlts instanceof SemanticContext.TruePredicate ) {
			return null;
		}
		return unionOfPredicatesFromAllAlts;
	}

    /** Is an accept state reachable from this state? */
    public int getAcceptStateReachable() {
        return acceptStateReachable;
    }

    public void setAcceptStateReachable(int acceptStateReachable) {
        this.acceptStateReachable = acceptStateReachable;
    }

    public boolean isResolvedWithPredicates() {
        return resolvedWithPredicates;
    }

    /** Print all NFA states plus what alts they predict */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(stateNumber+":{");
        Iterator iter = nfaConfigurations.iterator();
        int i = 1;
        while (iter.hasNext()) {
            NFAConfiguration configuration = (NFAConfiguration) iter.next();
            if ( i>1 ) {
                buf.append(", ");
            }
            buf.append(configuration);
            i++;
        }
        buf.append("}");
        return buf.toString();
    }

	public int getLookaheadDepth() {
		return k;
	}

	public void setLookaheadDepth(int k) {
		this.k = k;
		if ( k > dfa.max_k ) { // track max k for entire DFA
			dfa.max_k = k;
		}
	}

}
