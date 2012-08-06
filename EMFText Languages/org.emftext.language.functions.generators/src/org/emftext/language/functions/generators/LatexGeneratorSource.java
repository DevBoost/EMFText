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

import de.devboost.commenttemplate.CommentTemplate;
import de.devboost.commenttemplate.ReplacementRule;
import de.devboost.commenttemplate.VariableAntiQuotation;

@SuppressWarnings("unused")
@VariableAntiQuotation("#%s#")
@ReplacementRule(pattern="~~u",replacement="\\u")
public class LatexGeneratorSource {

	@CommentTemplate
	public String generateLatexMainFile(String filename) {
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
		return null;
	}
	
	@CommentTemplate
	public String generateFunctionDescriptions(FunctionSet functionSet) {
		List<Function> rootFunctions = getRootFunctions(functionSet);
		String text = "";
		for (Function rootFunction : rootFunctions) {
			text = text + generateLatexForFunction(rootFunction, "sub");
		}
		/*%
		% Attention: This file is generated and will be overridden.
		%
		#text#
		*/
		return null;
	}

	@CommentTemplate
	public String generateFunctionCostTable(FunctionSet functionSet) {
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String functionCosts = generateFunctionCosts(functionSet);
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
		return null;
	}
	
	@CommentTemplate
	public String generateFunctionCosts(FunctionSet functionSet) {
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String readableName = functionSet.getReadableName();
		/**/
		if (functionSet.eContainer() != null) {
/*			\textbf{#readableName#} & \textbf{#totalCosts#} (Summe) \\
			\hline
*/
		}
		List<Function> rootFunctions = getFunctions(functionSet, false);
		for (Function rootFunction : rootFunctions) {
			String row = generateRowForFunction(rootFunction, "\\xspace\\xspace");
/*			#row#
*/
		}
		for (FunctionSet subset : functionSet.getSubsets()) {
			String costs = generateFunctionCosts(subset);
/*			#costs#
*/
		}
/*		\hline
		*/
		return null;
	}
	
	@CommentTemplate
	public String generateRowForFunction(Function function, String prefix) {
		boolean hasChildren = !function.getChildren().isEmpty();
		boolean isIgnored = function.getTargetVersion() != null && function.getTargetVersion().isIgnored(); 
		String readableName = function.getReadableName();
		String totalCosts = Integer.toString(function.getTotalCosts());
		if (!isIgnored) {
			/*
			#prefix# */
			if (hasChildren) {
				/*\textbf{*/
			}
			/* #readableName# */
			if (hasChildren) {
				/*}*/
			}
			/*&*/
			if (hasChildren) {
				/*\textbf{*/
			}
			if (hasChildren) {
				/*$\sum$ */
			}
			/*#totalCosts#*/
			if (hasChildren) {
				/*}*/
			}
			/*\\
			\hline
			*/
		}
		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction : validChildren) {
			String column = generateRowForFunction(childFunction, "\\xspace\\xspace" + prefix);
			/*#column#*/
		}
		return null;
	}
	
	@CommentTemplate
	public String generateLatexForFunction(Function function, String prefix) {
		String section = prefix + "section";
		boolean addLineBreak = false;
		List<Function> relatedFunctions = function.getRelatedFunctions();
		String linksToRelatedFunctions = "";
		for (Function relatedFunction : relatedFunctions) {
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
		/*
			\#section#{#readableName#}
			\label{func:#label#}
			
			*/
		if (addLineBreak) {
			/*\newline */
		}
		if (function.getChildren().isEmpty()) {
			String costs = Integer.toString(function.getCosts());
			/*\marginpar{\tiny{#costs#~\timeunit}}*/
		}
		String readableDescription = function.getReadableDescription();
		String description = readableDescription == null ? "" : readableDescription.replaceAll("'(.*)'", "\\\\inquotes{\\1}");
		/* #description#
		*/
		
		if (!relatedFunctions.isEmpty()) {
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
			/*
			\noindent{\footnotesize \targetversion #targetName#}
			*/
		}

		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction : validChildren) {
			String subText = generateLatexForFunction(childFunction, ("sub" + prefix));
			/*#subText#*/
		}
		return null;
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
		for (FunctionSet nextSubset : subsets) {
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
