==Intend== 
This implementation uses model driven software development based on Java, EMF
and generative technologies of the Dropsbox (http://www.dropsbox.org/). 

==Features==
Company
Cut
Total
Serialization
Vizualisation
Depth
Mentoring
Precedence
Parsing

==Special Features==
Rename Refactoring
Extract Subdepartment
(Meta) Feature Visualization 

==Technologies==
EMF+Eclipse
Java
EMFText (Parsing, Serialization, Mentoring)
EMFText DSLs
	Text-Ecore (Company Model) 
	eJava (Depth,Cut)
	A DOT implementation
GraphViz + DOT (Vizualisation)
JastEMF+JastAdd (Total,Precedence)
Refactory (Rename Refactoring, Extract Subdepartment)
FeatureMapper (Feature Visualization)

==Motivation==
We use one of the advantages of model-driven software development for the combination of different tools to implement 
different features of 101Companies. Most of the involved tools have been developed using EMFText, other tools like Graphviz 
and JastEMF are independent of EMFText.

==Architecture==
EMFText is used for creating an interactive textual editor. It provides a parser and a printer for company models. 
References from employees to mentors are resolved automatically by EMFText. The company model is given by a specification
in Text-Ecore which is an EMFText-based representation of Ecore models (instead of the XMI one). The Usage of eJava avoids
having to add implementations of the Operations for Depth and Cut into the generated code artifacts (by the EMF generator 
model). The JastEMF tool is used to integrate a JastAdd attribute grammar into the model code which computes salary totals 
and evaluates the precedence constraint. The EMF+EMFText-based represention of the Graphviz DOT language finally is used for the transformation of Company 
specifications into a DOT specifications. The DOT specification is then compiled into a PDF using GraphViz.  

==Installation/Setup==
 - Install the Eclipse 3.7 Modelling Distribution (Includes EMF)
 - Install the current Trunk Version of EMFText (will soon get out as Version 1.4.0 for Eclipse 3.7) and the DSLs from the update-site (http://emftext.org/update_trunk)
 	- Feature EMFText (only for build)
 	- Feature EMFText Syntax Ecore TEXT (Languages Root Feature)
    - Feature EMFText Syntax eJava (Languages Root Feature) (only for build)
    - Feature EMFText DOT (Graphviz)
    - Feature Refactory Runtime (Refactory Root Feature)
 - Install the current Trunk Version of JastEMF (will soon get out as Version 0.1.6 for Eclipse 3.7) from the update-site (http://jastemf.googlecode.com/svn/trunk/build/org.jastemf.build/distribution)   
 	- Feature JastEMF Core (only for build)	
 - Install the current Version of FeatureMapper for its update-site (http://featuremapper.org/update/) (only needed for mapping the company features to metamodel)
 - Install GraphViz from http://www.graphviz.org/Download_windows.php (needed to generate the vizualization PDF from the generated DOT File)



==Build (Requires correct set-up)==
Sources are located in the 
http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/EMFText%20Languages/org.emftext.language.company (model & syntax specifications), 
http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/EMFText%20Languages/org.emftext.language.company.resource.company (generated parsing & printing & interpretation plugin), 
http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/EMFText%20Languages/org.emftext.language.company.resource.company.ui (UI integration,Outline and Properties view).
http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/EMFText%20Languages/org.emftext.language.company.text (test cases)

Steps:
	- src-gen folders should be empty
	- generate the EMF + JastEMF Code using the EMF Semantic task in the build.xml (takes some time, must be run in the same jre as workspace)
 	- generate the EMFText Plugins (right click on company.text.cs --> Generate Text Resource)
    - check if there are any errors in the code
    
 ==Run (Requires correct build)==
 	- just run a new eclipse instance from the workspace and create a new company file using the EMFText new file wizzard
 	- have fun :-)! 