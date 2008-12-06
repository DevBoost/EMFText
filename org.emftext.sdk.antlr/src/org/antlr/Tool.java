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
package org.antlr;

import org.antlr.tool.*;
import org.antlr.codegen.CodeGenerator;
import org.antlr.analysis.*;
import org.antlr.runtime.misc.Stats;

import java.io.*;
import java.util.*;

/** The main ANTLR entry point.  Read a grammar and generate a parser. */
public class Tool {
	public static final String VERSION = "3.0.1";

	public static final String UNINITIALIZED_DIR = "<unset-dir>";

    // Input parameters / option

    protected List grammarFileNames = new ArrayList();
	protected boolean generate_NFA_dot = false;
	protected boolean generate_DFA_dot = false;
	protected String outputDirectory = UNINITIALIZED_DIR;
	protected String libDirectory = ".";
	protected boolean debug = false;
	protected boolean trace = false;
	protected boolean profile = false;
	protected boolean report = false;
	protected boolean printGrammar = false;
	protected boolean depend = false;
	protected boolean forceAllFilesToOutputDir = false;

	// the internal options are for my use on the command line during dev

	public static boolean internalOption_PrintGrammarTree = false;
	public static boolean internalOption_PrintDFA = false;
	public static boolean internalOption_ShowNFConfigsInDFA = false;
	public static boolean internalOption_watchNFAConversion = false;

    public static void main(String[] args) {
		ErrorManager.info("ANTLR Parser Generator  Version " +
						  VERSION + " (August 13, 2007)  1989-2007");
		Tool antlr = new Tool(args);
		antlr.process();
		System.exit(0);
	}

	public Tool() {
	}

	public Tool(String[] args) {
		processArgs(args);
	}

	public void processArgs(String[] args) {
		if ( args==null || args.length==0 ) {
			help();
			return;
		}
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-o") || args[i].equals("-fo")) {
				if (i + 1 >= args.length) {
					System.err.println("missing output directory with -fo/-o option; ignoring");
				}
				else {
					if ( args[i].equals("-fo") ) { // force output into dir
						forceAllFilesToOutputDir = true;
					}
					i++;
					outputDirectory = args[i];
					if ( outputDirectory.endsWith("/") ||
						 outputDirectory.endsWith("\\") )
					{
						outputDirectory =
							outputDirectory.substring(0,outputDirectory.length()-1);
					}
					File outDir = new File(outputDirectory);
					if( outDir.exists() && !outDir.isDirectory() ) {
						ErrorManager.error(ErrorManager.MSG_OUTPUT_DIR_IS_FILE,outputDirectory);
						libDirectory = ".";
					}
				}
			}
			else if (args[i].equals("-lib")) {
				if (i + 1 >= args.length) {
					System.err.println("missing library directory with -lib option; ignoring");
				}
				else {
					i++;
					libDirectory = args[i];
					if ( libDirectory.endsWith("/") ||
						 libDirectory.endsWith("\\") )
					{
						libDirectory =
							libDirectory.substring(0,libDirectory.length()-1);
					}
					File outDir = new File(libDirectory);
					if( !outDir.exists() ) {
						ErrorManager.error(ErrorManager.MSG_DIR_NOT_FOUND,libDirectory);
						libDirectory = ".";
					}
				}
			}
			else if (args[i].equals("-nfa")) {
				generate_NFA_dot=true;
			}
			else if (args[i].equals("-dfa")) {
				generate_DFA_dot=true;
			}
			else if (args[i].equals("-debug")) {
				debug=true;
			}
			else if (args[i].equals("-trace")) {
				trace=true;
			}
			else if (args[i].equals("-report")) {
				report=true;
			}
			else if (args[i].equals("-profile")) {
				profile=true;
			}
			else if (args[i].equals("-print")) {
				printGrammar = true;
			}
			else if (args[i].equals("-depend")) {
				depend=true;
			}
			else if (args[i].equals("-message-format")) {
				if (i + 1 >= args.length) {
					System.err.println("missing output format with -message-format option; using default");
				}
				else {
					i++;
					ErrorManager.setFormat(args[i]);
				}
			}
			else if (args[i].equals("-Xgrtree")) {
				internalOption_PrintGrammarTree=true; // print grammar tree
			}
			else if (args[i].equals("-Xdfa")) {
				internalOption_PrintDFA=true;
			}
			else if (args[i].equals("-Xnoprune")) {
				DFAOptimizer.PRUNE_EBNF_EXIT_BRANCHES=false;
			}
			else if (args[i].equals("-Xnocollapse")) {
				DFAOptimizer.COLLAPSE_ALL_PARALLEL_EDGES=false;
			}
			else if (args[i].equals("-Xdbgconversion")) {
				NFAToDFAConverter.debug = true;
			}
			else if (args[i].equals("-Xmultithreaded")) {
				NFAToDFAConverter.SINGLE_THREADED_NFA_CONVERSION = false;
			}
			else if (args[i].equals("-Xnomergestopstates")) {
				DFAOptimizer.MERGE_STOP_STATES = false;
			}
			else if (args[i].equals("-Xdfaverbose")) {
				internalOption_ShowNFConfigsInDFA = true;
			}
			else if (args[i].equals("-Xwatchconversion")) {
				internalOption_watchNFAConversion = true;
			}
			else if (args[i].equals("-XdbgST")) {
				CodeGenerator.EMIT_TEMPLATE_DELIMITERS = true;
			}
			else if (args[i].equals("-Xnoinlinedfa")) {
				CodeGenerator.GEN_ACYCLIC_DFA_INLINE = false;
			}
			else if (args[i].equals("-Xm")) {
				if (i + 1 >= args.length) {
					System.err.println("missing max recursion with -Xm option; ignoring");
				}
				else {
					i++;
					NFAContext.MAX_SAME_RULE_INVOCATIONS_PER_NFA_CONFIG_STACK = Integer.parseInt(args[i]);
				}
			}
			else if (args[i].equals("-Xmaxdfaedges")) {
				if (i + 1 >= args.length) {
					System.err.println("missing max number of edges with -Xmaxdfaedges option; ignoring");
				}
				else {
					i++;
					DFA.MAX_STATE_TRANSITIONS_FOR_TABLE = Integer.parseInt(args[i]);
				}
			}
			else if (args[i].equals("-Xconversiontimeout")) {
				if (i + 1 >= args.length) {
					System.err.println("missing max time in ms -Xconversiontimeout option; ignoring");
				}
				else {
					i++;
					DFA.MAX_TIME_PER_DFA_CREATION = Integer.parseInt(args[i]);
				}
			}
			else if (args[i].equals("-Xnfastates")) {
				DecisionProbe.verbose=true;
			}			
			else if (args[i].equals("-X")) {
				Xhelp();
			}
            else {
                if (args[i].charAt(0) != '-') {
                    // Must be the grammar file
                    grammarFileNames.add(args[i]);
                }
            }
        }
    }

    /*
    protected void checkForInvalidArguments(String[] args, BitSet cmdLineArgValid) {
        // check for invalid command line args
        for (int a = 0; a < args.length; a++) {
            if (!cmdLineArgValid.member(a)) {
                System.err.println("invalid command-line argument: " + args[a] + "; ignored");
            }
        }
    }
    */

    public void process()  {
		int numFiles = grammarFileNames.size();
		for (int i = 0; i < numFiles; i++) {
			String grammarFileName = (String) grammarFileNames.get(i);
			if ( numFiles > 1 && !depend ) {
			    System.out.println(grammarFileName);
			}
			try {
				if ( depend ) {
					BuildDependencyGenerator dep =
						new BuildDependencyGenerator(this, grammarFileName);
					List outputFiles = dep.getGeneratedFileList();
					List dependents = dep.getDependenciesFileList();
					//System.out.println("output: "+outputFiles);
					//System.out.println("dependents: "+dependents);
					System.out.println(dep.getDependencies());
					continue;
				}
				Grammar grammar = getGrammar(grammarFileName);
				processGrammar(grammar);

				if ( printGrammar ) {
					grammar.printGrammar(System.out);
				}

				if ( generate_NFA_dot ) {
					generateNFAs(grammar);
				}
				if ( generate_DFA_dot ) {
					generateDFAs(grammar);
				}
				if ( report ) {
					GrammarReport report = new GrammarReport(grammar);
					System.out.println(report.toString());
					// print out a backtracking report too (that is not encoded into log)
					System.out.println(report.getBacktrackingReport());
					// same for aborted NFA->DFA conversions
					System.out.println(report.getEarlyTerminationReport());
				}
				if ( profile ) {
					GrammarReport report = new GrammarReport(grammar);
					Stats.writeReport(GrammarReport.GRAMMAR_STATS_FILENAME,
											  report.toNotifyString());
				}

				// now handle the lexer if one was created for a merged spec
				String lexerGrammarStr = grammar.getLexerGrammar();
				if ( grammar.type==Grammar.COMBINED && lexerGrammarStr!=null ) {
					String lexerGrammarFileName =
						grammar.getImplicitlyGeneratedLexerFileName();
					Writer w = getOutputFile(grammar,lexerGrammarFileName);
					w.write(lexerGrammarStr);
					w.close();
					StringReader sr = new StringReader(lexerGrammarStr);
					Grammar lexerGrammar = new Grammar();
					lexerGrammar.setTool(this);
					File lexerGrammarFullFile =
						new File(getFileDirectory(lexerGrammarFileName),lexerGrammarFileName);
					lexerGrammar.setFileName(lexerGrammarFullFile.toString());
					lexerGrammar.importTokenVocabulary(grammar);
					lexerGrammar.setGrammarContent(sr);
					sr.close();
					processGrammar(lexerGrammar);
				}
			}
			catch (IOException e) {
				ErrorManager.error(ErrorManager.MSG_CANNOT_OPEN_FILE,
								   grammarFileName);
			}
			catch (Exception e) {
				ErrorManager.error(ErrorManager.MSG_INTERNAL_ERROR, grammarFileName, e);
			}
		}
    }

	public Grammar getGrammar(String grammarFileName)
		throws IOException, antlr.TokenStreamException, antlr.RecognitionException
	{
		//StringTemplate.setLintMode(true);
		FileReader fr = null;
		fr = new FileReader(grammarFileName);
		BufferedReader br = new BufferedReader(fr);
		Grammar grammar = new Grammar(this,grammarFileName,br);
		grammar.setWatchNFAConversion(internalOption_watchNFAConversion);
		br.close();
		fr.close();
		return grammar;
	}

	protected void processGrammar(Grammar grammar)
	{
		String language = (String)grammar.getOption("language");
		if ( language!=null ) {
			CodeGenerator generator = new CodeGenerator(this, grammar, language);
			grammar.setCodeGenerator(generator);
			generator.setDebug(debug);
			generator.setProfile(profile);
			generator.setTrace(trace);
			generator.genRecognizer();
		}
	}

	protected void generateDFAs(Grammar g) {
		for (int d=1; d<=g.getNumberOfDecisions(); d++) {
			DFA dfa = g.getLookaheadDFA(d);
			if ( dfa==null ) {
				continue; // not there for some reason, ignore
			}
			DOTGenerator dotGenerator = new DOTGenerator(g);
			String dot = dotGenerator.getDOT( dfa.startState );
			String dotFileName = g.name+"_dec-"+d;
			try {
				writeDOTFile(g, dotFileName, dot);
			}
			catch(IOException ioe) {
				ErrorManager.error(ErrorManager.MSG_CANNOT_GEN_DOT_FILE,
								   dotFileName,
								   ioe);
			}
		}
	}

	protected void generateNFAs(Grammar g) {
		DOTGenerator dotGenerator = new DOTGenerator(g);
		Collection rules = g.getRules();
		for (Iterator itr = rules.iterator(); itr.hasNext();) {
			Rule r = (Rule) itr.next();
			String ruleName = r.name;
			try {
				writeDOTFile(
					g,
					ruleName,
					dotGenerator.getDOT(g.getRuleStartState(ruleName)));
			}
			catch (IOException ioe) {
				ErrorManager.error(ErrorManager.MSG_CANNOT_WRITE_FILE, ioe);
			}
		}
	}

	protected void writeDOTFile(Grammar g, String name, String dot) throws IOException {
		Writer fw = getOutputFile(g, name+".dot");
		fw.write(dot);
		fw.close();
	}

	private static void help() {
        System.err.println("usage: java org.antlr.Tool [args] file.g [file2.g file3.g ...]");
		System.err.println("  -o outputDir          specify output directory where all output is generated");
		System.err.println("  -fo outputDir         same as -o but force even files with relative paths to dir");
		System.err.println("  -lib dir              specify location of token files");
		System.err.println("  -depend               generate file dependencies");
		System.err.println("  -report               print out a report about the grammar(s) processed");
		System.err.println("  -print                print out the grammar without actions");
		System.err.println("  -debug                generate a parser that emits debugging events");
		System.err.println("  -profile              generate a parser that computes profiling information");
		System.err.println("  -nfa                  generate an NFA for each rule");
		System.err.println("  -dfa                  generate a DFA for each decision point");
		System.err.println("  -message-format name  specify output style for messages");
		System.err.println("  -X                    display extended argument list");
    }

	private static void Xhelp() {
		System.err.println("  -Xgrtree               print the grammar AST");
		System.err.println("  -Xdfa                  print DFA as text ");
		System.err.println("  -Xnoprune              test lookahead against EBNF block exit branches");
		System.err.println("  -Xnocollapse           collapse incident edges into DFA states");
		System.err.println("  -Xdbgconversion        dump lots of info during NFA conversion");
		System.err.println("  -Xmultithreaded        run the analysis in 2 threads");
		System.err.println("  -Xnomergestopstates    do not merge stop states");
		System.err.println("  -Xdfaverbose           generate DFA states in DOT with NFA configs");
		System.err.println("  -Xwatchconversion      print a message for each NFA before converting");
		System.err.println("  -XdbgST                put tags at start/stop of all templates in output");
		System.err.println("  -Xm m                  max number of rule invocations during conversion");
		System.err.println("  -Xmaxdfaedges m        max \"comfortable\" number of edges for single DFA state");
		System.err.println("  -Xconversiontimeout t  set NFA conversion timeout for each decision");
		System.err.println("  -Xnoinlinedfa          make all DFA with tables; no inline prediction with IFs");
		System.err.println("  -Xnfastates            for nondeterminisms, list NFA states for each path");
    }

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

    /** This method is used by all code generators to create new output
     *  files. If the outputDir set by -o is not present it will be created.
	 *  The final filename is sensitive to the output directory and
	 *  the directory where the grammar file was found.  If -o is /tmp
	 *  and the original grammar file was foo/t.g then output files
	 *  go in /tmp/foo.
	 *
	 *  The output dir -o spec takes precedence if it's absolute.
	 *  E.g., if the grammar file dir is absolute the output dir is given
	 *  precendence. "-o /tmp /usr/lib/t.g" results in "/tmp/T.java" as
	 *  output (assuming t.g holds T.java).
	 *
	 *  If no -o is specified, then just write to the directory where the
	 *  grammar file was found.
	 *
	 *  If outputDirectory==null then write a String.
     */
    public Writer getOutputFile(Grammar g, String fileName) throws IOException {
		if ( outputDirectory==null ) {
			return new StringWriter();
		}
		// output directory is a function of where the grammar file lives
		// for subdir/T.g, you get subdir here.  Well, depends on -o etc...
		File outputDir = getOutputDirectory(g.getFileName());
		File outputFile = new File(outputDir, fileName);

		if( !outputDir.exists() ) {
			outputDir.mkdirs();
		}
        FileWriter fw = new FileWriter(outputFile);
		return new BufferedWriter(fw);
    }

	public File getOutputDirectory(String fileNameWithPath) {
		File outputDir = new File(outputDirectory);
		String fileDirectory = getFileDirectory(fileNameWithPath);
		if ( outputDirectory!=UNINITIALIZED_DIR ) {
			// -o /tmp /var/lib/t.g => /tmp/T.java
			// -o subdir/output /usr/lib/t.g => subdir/output/T.java
			// -o . /usr/lib/t.g => ./T.java
			if ( fileDirectory!=null &&
				 (new File(fileDirectory).isAbsolute() ||
				  fileDirectory.startsWith("~")) || // isAbsolute doesn't count this :(
				  forceAllFilesToOutputDir
				)
			{
				// somebody set the dir, it takes precendence; write new file there
				outputDir = new File(outputDirectory);
			}
			else {
				// -o /tmp subdir/t.g => /tmp/subdir/t.g
				if ( fileDirectory!=null ) {
					outputDir = new File(outputDirectory, fileDirectory);
				}
				else {
					outputDir = new File(outputDirectory);
				}
			}
		}
		else {
			// they didn't specify a -o dir so just write to location
			// where grammar is, absolute or relative
			String dir = ".";
			if ( fileDirectory!=null ) {
				dir = fileDirectory;
			}
			outputDir = new File(dir);
		}
		return outputDir;
	}

	/** Open a file in the -lib dir.  For now, it's just .tokens files */
	public BufferedReader getLibraryFile(String fileName) throws IOException {
		String fullName = libDirectory+File.separator+fileName;
		FileReader fr = new FileReader(fullName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

	public String getLibraryDirectory() {
		return libDirectory;
	}

	/** Return the directory containing the grammar file for this grammar.
	 *  normally this is a relative path from current directory.  People will
	 *  often do "java org.antlr.Tool grammars/*.g3"  So the file will be
	 *  "grammars/foo.g3" etc...  This method returns "grammars".
	 */
	public String getFileDirectory(String fileName) {
		File f = new File(fileName);
		return f.getParent();
	}

	/** If the tool needs to panic/exit, how do we do that? */
	public void panic() {
		throw new Error("ANTLR panic");
	}

	/** Return a time stamp string accurate to sec: yyyy-mm-dd hh:mm:ss */
	public static String getCurrentTimeStamp() {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH)+1; // zero-based for months
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String sy = String.valueOf(y);
		String sm = m<10?"0"+m:String.valueOf(m);
		String sd = d<10?"0"+d:String.valueOf(d);
		String sh = h<10?"0"+h:String.valueOf(h);
		String smin = min<10?"0"+min:String.valueOf(min);
		String ssec = sec<10?"0"+sec:String.valueOf(sec);
		return new StringBuffer().append(sy).append("-").append(sm).append("-")
			.append(sd).append(" ").append(sh).append(":").append(smin)
			.append(":").append(ssec).toString();
	}

}
