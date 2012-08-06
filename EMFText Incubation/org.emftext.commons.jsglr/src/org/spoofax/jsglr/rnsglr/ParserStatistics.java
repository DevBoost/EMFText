package org.spoofax.jsglr.rnsglr;

import org.spoofax.jsglr.NotImplementedException;

public class ParserStatistics {

	private int shiftCount;
	private int symbolTreeNodesCreated;
	private int reductionsDone;
	private int RNReductionsDone;
	private int rejectedReductionsDone;
	private int rejectedTreesCreated;
	private int parseTreeNodesCreated;
	
	public void increaseShiftsDone() {
		shiftCount++;
	}

	public void increaseSymbolTreeNodesCreated() {
		symbolTreeNodesCreated++;
	}

	public void increaseReductionsDone() {
		reductionsDone++;
	}

	public void increaseRNReductionsDone() {
		RNReductionsDone++;
		
	}

	public void increaseRejectedReductionsDone() {
		rejectedReductionsDone++;
	}

	public void addReductionLength(int m) {
		throw new NotImplementedException();
	}

	public void incrementRejectTreesCreated() {
		rejectedTreesCreated++;
	}

	public void incrementParseTreeNodesCreatedCount() {
		parseTreeNodesCreated++;
	}

}
