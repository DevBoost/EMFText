package org.spoofax.jsglr.rnsglr;

import java.util.List;

import org.spoofax.jsglr.NotImplementedException;
import org.spoofax.jsglr.Production;
import org.spoofax.jsglr.State;

public class GSS {

	public boolean isReductionQueueEmpty() {
		throw new NotImplementedException();
	}

	public int getCurrentLevelNumber() {
		throw new NotImplementedException();
	}

	public GSSNode createNode(State startState, boolean b,
			int currentLevelNumber) {
		throw new NotImplementedException();
	}

	public void addToCurrentLevel(GSSNode startStateNode) {
		throw new NotImplementedException();
	}

	public void resetReductionQueue() {
		throw new NotImplementedException();
	}

	public void addShiftQueueElement(int nextState, GSSNode startStateNode) {
		throw new NotImplementedException();
	}

	public Object getCurrentLevel() {
		throw new NotImplementedException();
	}

	public void addReductionQueueElement(GSSNode startStateNode,
			GSSNode startStateNode2, 
			Production production, 
			SpecialAttribute specAttr,
			int i, 
			Arguments tree, 
			Object object) {
		throw new NotImplementedException();
		
	}

	public boolean isShiftQueueEmpty() {
		throw new NotImplementedException();
	}

	public GSSEdge addEdge(GSSNode w, GSSNode v, Tree z, boolean b) {
		throw new NotImplementedException();
	}

	public int getShiftQueueStateNumber() {
		throw new NotImplementedException();
	}

	public GSSNode getShiftQueueGSSNode() {
		throw new NotImplementedException();
	}

	public GSSNode findStateInNodeList(int k, List<GSSNode> newActiveStacks) {
		throw new NotImplementedException();
	}

	public void setAcceptNode(GSSNode w) {
		throw new NotImplementedException();
	}

	public void removeShiftQueueElement() {
		throw new NotImplementedException();
	}

	public void copyNewShiftQueue() {
		throw new NotImplementedException();	
	}

	public void addNewLevel(List<GSSNode> newActiveStacks) {
		throw new NotImplementedException();
	}

	public GSSNode getReductionQueueOriginalNode() {
		throw new NotImplementedException();
	}

	public GSSNode getReductionQueueGSSNode() {
		throw new NotImplementedException();
	}

	public int getReductionQueueProduction() {
		throw new NotImplementedException();
	}

	public SpecialAttribute getReductionQueueAttribute() {
		throw new NotImplementedException();
	}

	public int getReductionQueueLength() {
		throw new NotImplementedException();
	}

	public Arguments getReductionQueueETree() {
		throw new NotImplementedException();
	}

	public Tree getReductionQueueFirstEdgeTree() {
		throw new NotImplementedException();
	}

	public void removeReductionQueueElement() {
		throw new NotImplementedException();
	}

	public int getLevel(GSSNode original) {
		throw new NotImplementedException();
	}

	public ReductionPath findAllPaths(Object level, GSSNode v, int i, Tree y,
			Arguments f) {
		throw new NotImplementedException();
	}

	public ReductionPath addReductionPath(GSSNode v, Arguments f, Object object) {
		throw new NotImplementedException();
	}

	public GSSNode getReductionPathTargetGSSNode(ReductionPath paths) {
		throw new NotImplementedException();
	}

	public State getState(GSSNode u) {
		throw new NotImplementedException();
	}

	public Arguments getReductionPathTreeNodes(ReductionPath paths) {
		throw new NotImplementedException();
	}

	public GSSNode findNodeInCurrentLevel(int l) {
		throw new NotImplementedException();
	}

	public ReductionPath nextReductionPath(ReductionPath paths) {
		throw new NotImplementedException();
	}

	public void clearReductionPath(ReductionPath head) {
		throw new NotImplementedException();
	}

	public GSSEdge findDirectEdge(GSSNode w, Tree y) {
		throw new NotImplementedException();
	}

}
