package org.strategoxt.imp.runtime.parser;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import lpg.runtime.IPrsStream;

import org.spoofax.jsglr.BadTokenException;
import org.spoofax.jsglr.Disambiguator;
import org.spoofax.jsglr.FilterException;
import org.spoofax.jsglr.InvalidParseTableException;
import org.spoofax.jsglr.NoRecovery;
import org.spoofax.jsglr.NoRecoveryRulesException;
import org.spoofax.jsglr.ParseTable;
import org.spoofax.jsglr.ParseTableManager;
import org.spoofax.jsglr.RecoverAlgorithm;
import org.spoofax.jsglr.SGLR;
import org.spoofax.jsglr.SGLRException;
import org.spoofax.jsglr.TokenExpectedException;
//import org.strategoxt.imp.runtime.Debug;
//import org.strategoxt.imp.runtime.Environment;
import org.strategoxt.imp.runtime.parser.tokens.TokenKindManager;

import aterm.ATerm;

/**
 * IMP IParser implementation using JSGLR, imploding parse trees to AST nodes and tokens.
 *
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */ 
public class JSGLRI extends AbstractSGLRI {
	
	private final ParseTable parseTable;
	
	private ParseTableManager ptm;
	
	private RecoverAlgorithm recoverHandler = new NoRecovery();
	
	private SGLR parser;
	
	private boolean filtersBorked;
	
	// Initialization and parsing
	
	public JSGLRI(String parseTable) throws FileNotFoundException, IOException, InvalidParseTableException{
		this(parseTable, "");
	}
	
	public JSGLRI(String parseTable, String startSymbol,
			/*SGLRParseController controller, */ TokenKindManager tokenManager) throws FileNotFoundException, IOException, InvalidParseTableException {
		super(/*controller, */tokenManager, startSymbol, parseTable);
		ptm = new ParseTableManager();
		this.parseTable = ptm.loadFromFile(parseTable);
		resetState();
	}
	
	public JSGLRI(String parseTable, String startSymbol) throws FileNotFoundException, IOException, InvalidParseTableException {
		this(parseTable, startSymbol, /* null, */ new TokenKindManager());
	}
	
	public void asyncAbort() {
		parser.asyncAbort();
	}
	
	/**
	 * @see SGLR#setRecoverHandler(RecoverAlgorithm)
	 */
	public void setRecoverHandler(RecoverAlgorithm recoverHandler) throws NoRecoveryRulesException {
		this.recoverHandler = recoverHandler;
		parser.setRecoverHandler(recoverHandler);
	}
	
	public Disambiguator getDisambiguator() {
		return parser.getDisambiguator();
	}
	
/*	public IPrsStream getIPrsStream() {
		return super.getController().getIPrsStream();
	}*/
	
	@Override
	protected ATerm doParseNoImplode(char[] inputChars, String filename)
			throws TokenExpectedException, BadTokenException, SGLRException, IOException {
		
		return doParseNoImplode(toByteStream(inputChars), inputChars);
	}
	
	/**
	 * Resets the state of this parser, reinitializing the SGLR instance
	 */
	void resetState() {
		parser = new SGLR(ptm.getFactory(), parseTable);
		parser.getDisambiguator().setFilterPriorities(!filtersBorked);
		try {
			parser.setRecoverHandler(recoverHandler);
		} catch (NoRecoveryRulesException e) {
			// Already handled/logged this error in setRecoverHandler()
//			if (Debug.ENABLED)
//				Environment.logException(e);
		}
	}
	
	private ATerm doParseNoImplode(InputStream inputStream, char[] inputChars)
			throws TokenExpectedException, BadTokenException, SGLRException, IOException {
		
		// FIXME: Some bug in JSGLR is causing its state to get corrupted; must reset it every parse
		resetState();
		
		// Read stream using tokenizer/lexstream
		
		try {
			return parser.parse(inputStream, getStartSymbol());
		} catch (FilterException e) {
//			Environment.logException("Parse filter failure - disabling priority filters and trying again", e);
			filtersBorked = true;
			parser.getDisambiguator().setFilterPriorities(false);
			return parser.parse(inputStream, getStartSymbol());
		}
	}
}
