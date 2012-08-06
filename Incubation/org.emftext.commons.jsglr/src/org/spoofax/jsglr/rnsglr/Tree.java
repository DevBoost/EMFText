package org.spoofax.jsglr.rnsglr;

import org.spoofax.jsglr.NotImplementedException;

import aterm.ATerm;

public class Tree {

	static Tree makeTreeAppl(ATerm production, Arguments children) {
		throw new NotImplementedException();
	}

	static Tree makeTreeChar(Token currentToken) {
		// TODO Auto-generated method stub
		return null;
	}

	static Tree makeTreeAmb(Arguments f) {
		throw new NotImplementedException();
	}

	static void createAmbCluster(Object tree, Tree z, int tokensRead, int i) {
		throw new NotImplementedException();
	}


}
