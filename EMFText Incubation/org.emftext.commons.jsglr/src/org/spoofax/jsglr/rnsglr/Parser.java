package org.spoofax.jsglr.rnsglr;

import java.util.LinkedList;
import java.util.List;

import org.spoofax.jsglr.ActionItem;
import org.spoofax.jsglr.NotImplementedException;
import org.spoofax.jsglr.ParseTable;
import org.spoofax.jsglr.Reduce;
import org.spoofax.jsglr.ReduceLookahead;
import org.spoofax.jsglr.Shift;
import org.spoofax.jsglr.State;

public class Parser {
    
    // TODO: Use ArrayDeque in RNSGLR parsre 
	
	ParseInfo info;
	Config config;
	ParseTable parseTable;
	private Object treeRoot;
	GSS gss;
	private ParserStatistics stats;
	private TokenStream stream;
	private ParserFilter filter;
	private ParserErrorHandler errorHandler;
	
	void checkReduceLookahead(ReduceLookahead a, GSSNode startStateNode, GSSNode startStateNode2, int i, Object object) {throw new NotImplementedException();}
	
	void checkForReductionsThatNeedRedoing(int k, Token nextToken, GSSNode w, GSSNode v, Tree z) {throw new NotImplementedException();}
	
	void countETreeNodes(Arguments f) {
		
		
	}
	
	void reducer() {
		GSSEdge newEdge; // GSS edge from w to u
		Arguments children; // the tree nodes found during the reduction traversal
		GSSNode original;
		GSSNode v; // node to begin reduction traversal from
		GSSNode u; // node found at end of reduction path 
		GSSNode w; // node created in current level as result of reduction
		int X; // production number being reduced
		SpecialAttribute Xattr; // the attribute of the production being reduced
		int m; // length of (RN) reduction
		//int t; // length of next (queued) reduction found
		int l; // the reduction's goto state number
		int numberOfLeavesInTree;
		Tree z; // tree node created for reduction
		Arguments f; // epsilon tree of reduction
		Tree y; // tree found of reduction's first edge
		ReductionPath paths; // reduction paths traversed
		ReductionPath head; 
		Token nextToken = stream.getCurrentToken();
		
		original = gss.getReductionQueueOriginalNode();
		v = gss.getReductionQueueGSSNode();
		X = gss.getReductionQueueProduction();
		Xattr = gss.getReductionQueueAttribute();
		m = gss.getReductionQueueLength();
		f = gss.getReductionQueueETree();
		y = gss.getReductionQueueFirstEdgeTree();
		gss.removeReductionQueueElement();
		
		stats.increaseReductionsDone();
		if(!f.isEmpty()) 
			stats.increaseRNReductionsDone();
		if(Xattr.isReject())
			stats.increaseRejectedReductionsDone();
		stats.addReductionLength(m);
		
		if(config.statsFlag) {
			countETreeNodes(f);
		}
		
		if(m > 0) {
			paths = gss.findAllPaths(gss.getLevel(original), v, m - 1, y, f);
		} else {
			paths = gss.addReductionPath(v, f, null);
		}
		
		while(paths != null) {
			u = gss.getReductionPathTargetGSSNode(paths);
			numberOfLeavesInTree = gss.getCurrentLevelNumber() - gss.getLevel(u);
			l = gss.getState(u).go(X);
			children = gss.getReductionPathTreeNodes(paths);
			
			if(m == 0) {
				assert(u == v);
				if(f.length() > 1) {
					z = Tree.makeTreeAmb(f);
				} else {
					z = f.first();
				}
			} else {
				z = Tree.makeTreeAppl(parseTable.getProduction(X), children);
				stats.incrementParseTreeNodesCreatedCount();
				if(Xattr.isReject())
					stats.incrementRejectTreesCreated();
			} 
			
			w = gss.findNodeInCurrentLevel(l);
			
			if(w != null) {
				newEdge = gss.findDirectEdge(w, y);
				if(newEdge == null) {
					newEdge = gss.addEdge(w, u, z, Xattr.isReject());
					if(m != 0 && !filter.getRejectFlag() || !newEdge.isRejected()) {
						checkForReductionsThatNeedRedoing(l, nextToken, w, u, z);
					}
				} else {
					if(Xattr.isReject()) {
						newEdge.setRejected();
					}
					
					if(m > 0) {
						Tree.createAmbCluster(newEdge.tree, z, stream.tokensRead(), - numberOfLeavesInTree - 1);
					}
				}
				
			} else {
				List<ActionItem> actionItems = parseTable.getState(l).getActionItems(nextToken.intValue());
				
				w = gss.createNode(parseTable.getState(l), false, gss.getCurrentLevelNumber());
				newEdge = gss.addEdge(w, u, z, Xattr.isReject());
				
				gss.addToCurrentLevel(w);
				
				for(ActionItem ai : actionItems) {
					switch(ai.type) {
					case ActionItem.SHIFT:
						gss.addShiftQueueElement(((Shift)ai).nextState, w);
						break;
					case ActionItem.REDUCE: {
						Reduce a = (Reduce)ai;
						if(a.arity == 0) {
							gss.addReductionQueueElement(w, w, a.production, a.specialAttribute, 0, a.eTree, null);
						} else if(!filter.getRejectFlag() || !newEdge.isRejected()) {
							if(m != 0 && a.arity != 0) {
								gss.addReductionQueueElement(w, u, a.production, a.specialAttribute, a.arity, a.eTree, z);
							}
						}
						break;
					}
					case ActionItem.REDUCE_LOOKAHEAD: {
						ReduceLookahead a = (ReduceLookahead)ai;
						if(a.arity == 0) {
							checkReduceLookahead(a, w, w, 0, null);
						} else if(!filter.getRejectFlag() || !newEdge.isRejected()) {
							if(m != 0 && a.arity != 0) {
								checkReduceLookahead(a, w, u, a.arity, z);
							}
						}
						break;
					}
					case ActionItem.ACCEPT:
						gss.setAcceptNode(w);
						treeRoot = z;
						break;
					case ActionItem.ERROR:
					default:
						break;
					}
				}
			}
			
			head = paths;
			paths = gss.nextReductionPath(paths);
			gss.clearReductionPath(head);
		}
	}
	
	void shifter() {
		Tree z; // tree node created for the shift
		GSSNode v; // GSS node to shift from (current level)
		GSSNode w; // GSS node shifted to (next level)
		List<GSSNode> newActiveStacks = new LinkedList<GSSNode>(); // the new next level in the GSS FIXME list or queue?
		int k; // state number to shift to
		//GSSEdge newEdge; // GSS edged added from v to w for shift FIXME necessary?
		Token nextToken; 
		
		stats.increaseShiftsDone();
		
		z = Tree.makeTreeChar(stream.getCurrentToken());
		stats.increaseSymbolTreeNodesCreated();
		stream.saveState();
		nextToken = stream.readNextToken();
		
		while(!gss.isShiftQueueEmpty()) {
			k = gss.getShiftQueueStateNumber();
			v = gss.getShiftQueueGSSNode();
			w = gss.findStateInNodeList(k, newActiveStacks);
			
			if(w != null) {
				//newEdge = 
				gss.addEdge(w, v, z, false);
				checkForReductionsThatNeedRedoing(k, nextToken, w, v, z);
			} else {
				List<ActionItem> actionItems = parseTable.getState(k).getActionItems(nextToken.intValue());
				
				w = gss.createNode(parseTable.getState(k), true, gss.getCurrentLevelNumber() + 1);
				//newEdge = 
				gss.addEdge(w, v, z, false);
				newActiveStacks.add(w);
				
				for(ActionItem ai : actionItems) {
					switch(ai.type) {
					case ActionItem.SHIFT:
						gss.addShiftQueueElement(((Shift)ai).nextState, w);
						break;
					case ActionItem.REDUCE: {
						Reduce a = (Reduce)ai;
						if(a.arity == 0) {
							gss.addReductionQueueElement(w, w, a.production, a.specialAttribute, 0, a.eTree, null);
						} else {
							gss.addReductionQueueElement(w, v, a.production, a.specialAttribute, a.arity, a.eTree, z);
						}
						break;
					}
					case ActionItem.REDUCE_LOOKAHEAD: {
						ReduceLookahead a = (ReduceLookahead)ai;
						if(a.arity == 0) {
							checkReduceLookahead(a, w, w, 0, null);
						} else {
							checkReduceLookahead(a, w, v, a.arity, z);
						}
						break;
					}
					case ActionItem.ACCEPT:
						gss.setAcceptNode(w);
						treeRoot = z;
						break;
					
					case ActionItem.ERROR:
					default:
						break;
					}
				}
			}
			gss.removeShiftQueueElement();
		}
		
		gss.copyNewShiftQueue();
		gss.addNewLevel(newActiveStacks);
		
		stream.loadState();
	}
	
	void initParser() {throw new NotImplementedException();}
	
	public Object parse(TokenStream tokenStream) {
		// SG_parse
	
		State initialState = parseTable.getInitialState();
		
		stream = tokenStream;
		initParser();
	
		List<ActionItem> actionItems = initialState.getActionItems(tokenStream.peek());
		
		if(tokenStream.isEmpty()) {
			for(ActionItem ai : actionItems) {
				if(ai.type == ActionItem.ACCEPT) {
					assert_("Parsing an empty string from a nullable start symbol!");
					treeRoot = null;
				}
			}
		} else {
			GSSNode startStateNode = gss.createNode(initialState, false, gss.getCurrentLevelNumber());
			gss.addToCurrentLevel(startStateNode);
			
			for(ActionItem ai : actionItems) {
				switch(ai.type) {
				case ActionItem.SHIFT:
					gss.addShiftQueueElement(((Shift)ai).nextState, startStateNode);
					break;
				case ActionItem.REDUCE: {
					Reduce a = (Reduce)ai;
					if(a.arity == 0) {
						gss.addReductionQueueElement(startStateNode, startStateNode, a.production, a.specialAttribute, 0, a.eTree, null);
					}
					break;
				}
				case ActionItem.REDUCE_LOOKAHEAD: {
					ReduceLookahead a = (ReduceLookahead)ai;
					if(a.arity == 0) {
						checkReduceLookahead(a, startStateNode, startStateNode, 0, null);
					}
					break;
				}
				default: 
				case ActionItem.ERROR:
					break;
				}
			}
		}

		do {
			tokenStream.readNextToken();
			
			while(!gss.isReductionQueueEmpty()) {
				reducer();
			}
			
			gss.resetReductionQueue();
			
			if(!tokenStream.endOfStream()) {
				shifter();
			}
			
			if(config.verboseFlag) {
				info.printStatusBar("sglr: parsing", tokenStream.tokensRead(), tokenStream.length()+1);
			}
		} while(!tokenStream.endOfStream() && gss.getCurrentLevel() != null);
		
		if(config.verboseFlag) {
			info.printDotAndNewLine();
		}
		
		errorHandler.parseError();
		
		if(config.statsFlag) {
			// allocation info
		}
		
		return config.returnOutput ? treeRoot : null;
	}
	

	private void assert_(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
