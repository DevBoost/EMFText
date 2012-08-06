/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.functions.generators;

import java.util.ArrayList;
import java.util.List;

import org.emftext.language.functions.Function;
import org.emftext.language.functions.FunctionSet;
import org.emftext.language.functions.TargetVersion;
import de.devboost.commenttemplate.ReplacementRule;
import de.devboost.commenttemplate.VariableAntiQuotation;

@SuppressWarnings("unused")
@VariableAntiQuotation("#%s#")
@ReplacementRule(pattern="~~u",replacement="\\u")
public class LatexGenerator {
	public String generateLatexMainFile(String filename) {
	StringBuilder __content = new StringBuilder();
	__content.append("\\documentclass{article}\n");
	__content.append("\\usepackage{xspace}\n");
	__content.append("\\usepackage{longtable}\n");
	__content.append("\\usepackage{paralist}\n");
	__content.append("\\usepackage[pdfpagelayout=OneColumn,colorlinks,linkcolor=black,citecolor=black,urlcolor=black,plainpages=false,pdfpagelabels,bookmarksopen=false]{hyperref}\n");
	__content.append("\\hypersetup{pdfpagemode=UseNone,colorlinks=true} \n");
	__content.append("\\newcommand{\\inquotes}[1]{\\glqq#1\\grqq}\n");
	__content.append("\n");
	__content.append("\\newcommand{\\timeunit}[0]{Days}\n");
	__content.append("\\newcommand{\\tableheaderfunction}[0]{Function}\n");
	__content.append("\\newcommand{\\tableheadereffort}[0]{Costs in \\timeunit}\n");
	__content.append("\\newcommand{\\tablefootertotaleffort}[0]{Total costs}\n");
	__content.append("\\newcommand{\\costtablecaption}[0]{Cost per function}\n");
	__content.append("\\newcommand{\\targetversion}[0]{Target version: }\n");
	__content.append("\n");
	__content.append("\\makeatletter\n");
	__content.append("\\newcounter{subsubsubsection}[subsubsection]\n");
	__content.append("\\setcounter{subsubsubsection}{1}\n");
	__content.append("\\setcounter{secnumdepth}{4}\n");
	__content.append("\\setcounter{tocdepth}{4}\n");
	__content.append("\\renewcommand{\\thesubsubsubsection}{\\thesubsubsection.\\@arabic\\c@subsubsubsection}\n");
	__content.append("\n");
	__content.append("\\makeatother\n");
	__content.append("\n");
	__content.append("\\begin{document}\n");
	__content.append("\n");
	__content.append("\\tableofcontents\n");
	__content.append("\n");
	__content.append("\\clearpage\n");
	__content.append("\n");
	__content.append("\\section{Functions}\n");
	__content.append("\\input{");
	__content.append(filename.replaceAll("\\n\\z",""));
	__content.append("_function_descriptions}\n");
	__content.append("\n");
	__content.append("\\section{Costs}\n");
	__content.append("\\input{");
	__content.append(filename.replaceAll("\\n\\z",""));
	__content.append("_function_costs}\n");
	__content.append("\n");
	__content.append("\\end{document}\n");
	__content.append("");
		/*\documentclass{article}
		~~usepackage{xspace}
		~~usepackage{longtable}
		~~usepackage{paralist}
		~~usepackage[pdfpagelayout=OneColumn,colorlinks,linkcolor=black,citecolor=black,urlcolor=black,plainpages=false,pdfpagelabels,bookmarksopen=false]{hyperref}
		\hypersetup{pdfpagemode=UseNone,colorlinks=true} 
		\newcommand{\inquotes}[1]{\glqq#1\grqq}
		
		\newcommand{\timeunit}[0]{Days}
		\newcommand{\tableheaderfunction}[0]{Function}
		\newcommand{\tableheadereffort}[0]{Costs in \timeunit}
		\newcommand{\tablefootertotaleffort}[0]{Total costs}
		\newcommand{\costtablecaption}[0]{Cost per function}
		\newcommand{\targetversion}[0]{Target version: }
		
		\makeatletter
		\newcounter{subsubsubsection}[subsubsection]
		\setcounter{subsubsubsection}{1}
		\setcounter{secnumdepth}{4}
		\setcounter{tocdepth}{4}
		\renewcommand{\thesubsubsubsection}{\thesubsubsection.\@arabic\c@subsubsubsection}
		
		\makeatother
		
		\begin{document}
		
		\tableofcontents
		
		\clearpage
		
		\section{Functions}
		\input{#filename#_function_descriptions}
		
		\section{Costs}
		\input{#filename#_function_costs}
		
		\end{document}
		*/
		return __content.toString();
	}
	public String generateFunctionDescriptions(FunctionSet functionSet) {
	StringBuilder __content = new StringBuilder();
		List<Function> rootFunctions = getRootFunctions(functionSet);
		String text = "";
		for (Function rootFunction :rootFunctions) {
			text = text + generateLatexForFunction(rootFunction, "sub");
		}
	__content.append("%\n");
	__content.append("% Attention: This file is generated and will be overridden.\n");
	__content.append("%\n");
	__content.append("");
	__content.append(text.replaceAll("\\n\\z",""));
	__content.append("\n");
	__content.append("");
		/*%
		% Attention: This file is generated and will be overridden.
		%
		#text#
		*/
		return __content.toString();
	}
	public String generateFunctionCostTable(FunctionSet functionSet) {
	StringBuilder __content = new StringBuilder();
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String functionCosts = generateFunctionCosts(functionSet);
	__content.append("%\n");
	__content.append("% Attention: This file is generated and will be overridden.\n");
	__content.append("%\n");
	__content.append("\\begin{longtable}{|l|p{2.25cm}|}\n");
	__content.append("\t\\hline\n");
	__content.append("\t\\tableheaderfunction & \n");
	__content.append("\t\\tableheadereffort \\\\\n");
	__content.append("\t\\hline\n");
	__content.append("\t\\hline\n");
	__content.append("\t");
	__content.append(functionCosts.replaceAll("\\n\\z","").replace("\n","\n\t"));
	__content.append("\n");
	__content.append("\t\\textbf{\\tablefootertotaleffort} &\n");
	__content.append("\t\\textbf{$\\sum$ ");
	__content.append(totalCosts.replaceAll("\\n\\z","").replace("\n","\n\t"));
	__content.append("} \\\\\n");
	__content.append("\t\\hline\n");
	__content.append("\\end{longtable}\n");
	__content.append("");
		/*%
		% Attention: This file is generated and will be overridden.
		%
		\begin{longtable}{|l|p{2.25cm}|}
			\hline
			\tableheaderfunction & 
			\tableheadereffort \\
			\hline
			\hline
			#functionCosts#
			\textbf{\tablefootertotaleffort} &
			\textbf{$\sum$ #totalCosts#} \\
			\hline
		\end{longtable}
		*/
		return __content.toString();
	}
	public String generateFunctionCosts(FunctionSet functionSet) {
	StringBuilder __content = new StringBuilder();
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String readableName = functionSet.getReadableName();
	__content.append("");
		/**/
		if (functionSet.eContainer() != null) {
	__content.append("\\textbf{");
	__content.append(readableName.replaceAll("\\n\\z",""));
	__content.append("} & \\textbf{");
	__content.append(totalCosts.replaceAll("\\n\\z",""));
	__content.append("} (Summe) \\\\\n");
	__content.append("\\hline\n");
	__content.append("");
/*			\textbf{#readableName#} & \textbf{#totalCosts#} (Summe) \\
			\hline
*/
		}
		List<Function> rootFunctions = getFunctions(functionSet, false);
		for (Function rootFunction :rootFunctions) {
			String row = generateRowForFunction(rootFunction, "\\xspace\\xspace");
	__content.append("");
	__content.append(row.replaceAll("\\n\\z",""));
	__content.append("\n");
	__content.append("");
/*			#row#
*/
		}
		for (FunctionSet subset : functionSet.getSubsets()) {
			String costs = generateFunctionCosts(subset);
	__content.append("");
	__content.append(costs.replaceAll("\\n\\z",""));
	__content.append("\n");
	__content.append("");
/*			#costs#
*/
		}
	__content.append("\\hline\n");
	__content.append("");
/*		\hline
		*/
		return __content.toString();
	}
	public String generateRowForFunction(Function function, String prefix) {
	StringBuilder __content = new StringBuilder();
		boolean hasChildren = !function.getChildren().isEmpty();
		boolean isIgnored = function.getTargetVersion() != null && function.getTargetVersion().isIgnored(); 
		String readableName = function.getReadableName();
		String totalCosts = Integer.toString(function.getTotalCosts());
		if (!isIgnored) {
	__content.append("\n");
	__content.append("");
	__content.append(prefix.replaceAll("\\n\\z",""));
	__content.append(" ");
			/*
			#prefix# */
			if (hasChildren) {
	__content.append("\\textbf{");
				/*\textbf{*/
			}
	__content.append(" ");
	__content.append(readableName.replaceAll("\\n\\z",""));
	__content.append(" ");
			/* #readableName# */
			if (hasChildren) {
	__content.append("}");
				/*}*/
			}
	__content.append("&");
			/*&*/
			if (hasChildren) {
	__content.append("\\textbf{");
				/*\textbf{*/
			}
			if (hasChildren) {
	__content.append("$\\sum$ ");
				/*$\sum$ */
			}
	__content.append("");
	__content.append(totalCosts.replaceAll("\\n\\z",""));
	__content.append("");
			/*#totalCosts#*/
			if (hasChildren) {
	__content.append("}");
				/*}*/
			}
	__content.append("\\\\\n");
	__content.append("\\hline\n");
	__content.append("");
			/*\\
			\hline
			*/
		}
		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction :validChildren) {
			String column = generateRowForFunction(childFunction, "\\xspace\\xspace" + prefix);
	__content.append("");
	__content.append(column.replaceAll("\\n\\z",""));
	__content.append("");
			/*#column#*/
		}
		return __content.toString();
	}
	public String generateLatexForFunction(Function function, String prefix) {
	StringBuilder __content = new StringBuilder();
		String section = prefix + "section";
		boolean addLineBreak = false;
		List<Function> relatedFunctions = function.getRelatedFunctions();
		String linksToRelatedFunctions = "";
		for (Function relatedFunction :relatedFunctions) {
			linksToRelatedFunctions = linksToRelatedFunctions + relatedFunction.getReadableName() + "~(\\ref{func:" + getLabel(relatedFunction) + "})";
			if (relatedFunctions.indexOf(relatedFunction) < relatedFunctions.size() - 1) {
				linksToRelatedFunctions = linksToRelatedFunctions + ", ";
			}
		}
		if ("subsubsubsection".equals(section)) {
	section = "paragraph";
	addLineBreak = true;
		}
		String readableName = function.getReadableName();
		String label = getLabel(function);
	__content.append("\n");
	__content.append("\t\\");
	__content.append(section.replaceAll("\\n\\z","").replace("\n","\n\t"));
	__content.append("{");
	__content.append(readableName.replaceAll("\\n\\z",""));
	__content.append("}\n");
	__content.append("\t\\label{func:");
	__content.append(label.replaceAll("\\n\\z","").replace("\n","\n\t"));
	__content.append("}\n");
	__content.append("\t\n");
	__content.append("\t");
		/*
			\#section#{#readableName#}
			\label{func:#label#}
			
			*/
		if (addLineBreak) {
	__content.append("\\newline ");
			/*\newline */
		}
		if (function.getChildren().isEmpty()) {
			String costs = Integer.toString(function.getCosts());
	__content.append("\\marginpar{\\tiny{");
	__content.append(costs.replaceAll("\\n\\z",""));
	__content.append("~\\timeunit}}");
			/*\marginpar{\tiny{#costs#~\timeunit}}*/
		}
		String readableDescription = function.getReadableDescription();
		String description = readableDescription == null ? "" : readableDescription.replaceAll("'(.*)'", "\\\\inquotes{\\1}");
	__content.append(" ");
	__content.append(description.replaceAll("\\n\\z",""));
	__content.append("\n");
	__content.append("");
		/* #description#
		*/
		
		if (!relatedFunctions.isEmpty()) {
	__content.append("\n");
	__content.append("\\vspace{0.2cm}\n");
	__content.append("\n");
	__content.append("\\noindent{\\footnotesize Verwandte Funktionen: ");
	__content.append(linksToRelatedFunctions.replaceAll("\\n\\z",""));
	__content.append("}\n");
	__content.append("");
			/*
			\vspace{0.2cm}
			
			\noindent{\footnotesize Verwandte Funktionen: #linksToRelatedFunctions#}
			*/
		}
		if (function.getChildren().isEmpty()) {
			TargetVersion targetVersion = function.getTargetVersion();
			String targetName = "n/a";
			if (targetVersion != null) {
				targetName = targetVersion.getReadableName();
			}
	__content.append("\n");
	__content.append("\\noindent{\\footnotesize \\targetversion ");
	__content.append(targetName.replaceAll("\\n\\z",""));
	__content.append("}\n");
	__content.append("");
			/*
			\noindent{\footnotesize \targetversion #targetName#}
			*/
		}

		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction :validChildren) {
			String subText = generateLatexForFunction(childFunction, ("sub" + prefix));
	__content.append("");
	__content.append(subText.replaceAll("\\n\\z",""));
	__content.append("");
			/*#subText#*/
		}
		return __content.toString();
	}

	private String getLabel(Function function) {
		String name = function.getName();
		String label = name.replace("_", ":").replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE").replace("ß", "ss");
		return label;
	}

	private List<Function> getValidChildFunctions(Function function) {
		List<Function> validChildren = new ArrayList<Function>();
		for (Function child : function.getChildren()) {
			if (!child.isIgnored()) {
				validChildren.add(child);
			}
		}
		return validChildren;
	}

	public List<Function> getFunctions(FunctionSet functionSet, boolean addFunctionsFromSubset) {
		List<Function> list = getRootFunctions(functionSet);
		if (!addFunctionsFromSubset) {
			return list;
		}
		List<FunctionSet> subsets = functionSet.getSubsets();
		for (FunctionSet nextSubset :subsets) {
			list.addAll(getFunctions(nextSubset, addFunctionsFromSubset));
		}
		return list;
	}

	private List<Function> getRootFunctions(FunctionSet functionSet) {
		List<Function> rootFunctions = new ArrayList<Function>();
		for (Function function : functionSet.getFunctions()) {
			if (function.getParent() == null && !function.isIgnored()) {
				rootFunctions.add(function);
			}
		}
		return rootFunctions;
	}
	}
