package org.reuseware.emftextedit.codegen;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Option;

public class GeneratorUtil {

	/**
     *  Collects all the subclasses for which concrete syntax is defined.
     */
    public static Collection<GenClass> getSubClassesWithCS(GenClass genClass, Collection<Rule> source){
        Collection<GenClass> subClasses = new LinkedList<GenClass>();

        for (Rule rule : source) {
     	   	GenClass subClassCand = rule.getMetaclass();
        		//There seem to be multiple instances of metaclasses when accessed through the genmodel. Therefore, we compare by name
        		for(EClass superClass : subClassCand.getEcoreClass().getEAllSuperTypes()) {
        			EClass ecoreClass = genClass.getEcoreClass();
					if (superClass.getName().equals(ecoreClass.getName()) && 
        					superClass.getEPackage().getNsURI().equals(ecoreClass.getEPackage().getNsURI())) {
        				subClasses.add(subClassCand);
        			}
        		} 
        }
        return subClasses;
    }
    
	/**
     *  Checks whether a subclass with cs does exist.
     */
    public static boolean hasSubClassesWithCS(GenClass genClass, Collection<Rule> source){
         for(Rule rule : source) {
     	   	GenClass subClassCand = rule.getMetaclass();
        		for(EClass superClass : subClassCand.getEcoreClass().getEAllSuperTypes()) {
        			if (superClass.getName().equals(genClass.getEcoreClass().getName()) && 
        					superClass.getEPackage().getNsURI().equals(genClass.getEcoreClass().getEPackage().getNsURI())) {
        				return true;
        			}
        		} 
        }
        return false;

    }
    
    public static Option getOptionByName(String optionName, Collection<Option> options){
    	if(options!=null&&!options.isEmpty()){
    		for(Option option:options){
    			if(optionName.equals(option.getName())){
    				return option;
    			}
    		}
    	}
    	return null;
    }
    

}
