package org.reuseware.emftextedit.sdk.ui.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.reuseware.emftextedit.sdk.concretesyntax.Choice;
import org.reuseware.emftextedit.sdk.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcretesyntaxFactory;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcretesyntaxPackage;
import org.reuseware.emftextedit.sdk.concretesyntax.CsString;
import org.reuseware.emftextedit.sdk.concretesyntax.DefinedPlaceholder;
import org.reuseware.emftextedit.sdk.concretesyntax.DerivedPlaceholder;
import org.reuseware.emftextedit.sdk.concretesyntax.NormalToken;
import org.reuseware.emftextedit.sdk.concretesyntax.Rule;
import org.reuseware.emftextedit.sdk.concretesyntax.Sequence;
import org.reuseware.emftextedit.sdk.concretesyntax.Terminal;

/**
 * An action that generates a HUTN based concrete syntax for the given genmodel
 * 
 * @author jj2
 *
 */
public class GenerateHUTNAction implements IObjectActionDelegate {
    
	private ISelection selection;
    //private IWorkbenchPart part;

    /**
     * Calls {@link #process(IFile)} for all selected <i>cs</i> files .
     */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    if (file.getFileExtension().startsWith("genmodel")) process(file);
                }
            }
		}
	}
    
	/**
	 * Generates a HUTN based concrete syntax for the given genmodel.
	 * 
	 * @param file The file that contains the concrete syntax definition.
	 */
    public void process(final IFile file) {
        try {                 
        	
        	IRunnableWithProgress runnable = new IRunnableWithProgress(){
        		public void run(IProgressMonitor monitor)throws InvocationTargetException, InterruptedException {
        				ResourceSet rs = new ResourceSetImpl();
        				Resource genResource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
        				final GenModel genModel = (GenModel) genResource.getContents().get(0);
        				
        				final ConcretesyntaxFactory concretesyntaxFactory = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory();
        				Resource csResource = rs.createResource(URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("cs").toString(), true));
        				final ConcreteSyntax cSyntax = (ConcreteSyntax) concretesyntaxFactory.createConcreteSyntax();		
        				csResource.getContents().clear();
        				csResource.getContents().add(cSyntax);
        				
        				//String csPackageName = (cSyntax.getPackage().getBasePackage()==null?"":cSyntax.getPackage().getBasePackage()+".")+cSyntax.getPackage().getEcorePackage().getName()+".resource."+cSyntax.getName();
        		    	cSyntax.setPackage(genModel.getGenPackages().get(0));
        				cSyntax.setName(cSyntax.getPackage().getNSName());
        				
        				EList<GenClass> genClasses = cSyntax.getPackage().getGenClasses();
        				Set<EClassifier> containedClasses = new HashSet<EClassifier>();
        				for (GenClass genClass : genClasses) {
							List<GenFeature> allChildrenFeatures = genClass.getAllChildrenFeatures();
							for (GenFeature genFeature : allChildrenFeatures) {
								EClassifier type = genFeature.getEcoreFeature().getEType();
								if (!type.equals(genClass.getEcoreClass())) {
									containedClasses.add(type);
								}
							}
        				}
        				for (GenClass genClass : genClasses) {
        					if (!genClass.isAbstract() && !genClass.isInterface() && !containsSelfOfSuper(containedClasses, genClass.getEcoreClass()) ) {
        						cSyntax.getStartSymbols().add(genClass);
        					}
        				}
        				
        				cSyntax.getRules().clear();
        				
        				for (GenClass genClass : genClasses) {
        					if (genClass.isAbstract() || genClass.isInterface()) continue;
        					Rule newRule = concretesyntaxFactory.createRule();
							newRule.setMetaclass(genClass);
        					cSyntax.getRules().add(newRule);
        					
        					Choice newChoice = concretesyntaxFactory.createChoice();
							newRule.setDefinition(newChoice);
        					Sequence newSequence = concretesyntaxFactory.createSequence();
							newChoice.getOptions().add(newSequence);
							
							NormalToken intToken = concretesyntaxFactory.createNormalToken();
							intToken.setName("INTEGER");
							intToken.setRegex("('-')?('1'..'9')('0'..'9')*|'0'");
							NormalToken floatToken = concretesyntaxFactory.createNormalToken();
							floatToken.setName("FLOAT");
							floatToken.setRegex("('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ ");
							NormalToken comment = concretesyntaxFactory.createNormalToken();
							comment.setName("COMMENT");
							comment.setRegex("'//'(~('\\n'|'\\r'))*");
							
							cSyntax.getTokens().clear();
							cSyntax.getTokens().add(comment);
							cSyntax.getTokens().add(intToken);
							cSyntax.getTokens().add(floatToken);
							
							
							List<GenFeature> allGenFeatures = genClass.getAllGenFeatures();
							
							for (GenFeature genFeature : allGenFeatures) {
								if (genFeature.isBooleanType()) {
									DefinedPlaceholder adjective = concretesyntaxFactory.createDefinedPlaceholder();
									adjective.setCardinality(concretesyntaxFactory.createQUESTIONMARK());
									adjective.setFeature(genFeature);
									newSequence.getParts().add(adjective);
								}
							}
							
							CsString newDefinition = concretesyntaxFactory.createCsString();
							newDefinition.setValue(genClass.getName());
							
							newSequence.getParts().add(newDefinition);
							
							CsString openBracket = concretesyntaxFactory.createCsString();
							openBracket.setValue("{");
							newSequence.getParts().add(openBracket);
							
							Choice parameterChoice = concretesyntaxFactory.createChoice();
							for (GenFeature genFeature : allGenFeatures) {
								if (!genFeature.isBooleanType() || genFeature.getEcoreFeature().getUpperBound() == -1) {
									Sequence innerSequence = concretesyntaxFactory.createSequence();
																		
									CsString nameKeyword = concretesyntaxFactory.createCsString();
									nameKeyword.setValue(genFeature.getEcoreFeature().getName());
									innerSequence.getParts().add(nameKeyword);
									CsString colon = concretesyntaxFactory.createCsString();
									colon.setValue(":");
									innerSequence.getParts().add(colon);
									
									Terminal content = null;
									if (genFeature.getEcoreFeature() instanceof EReference && ((EReference)genFeature.getEcoreFeature()).isContainment() ) {
										content = concretesyntaxFactory.createContainment();
									}
									else{
										String typeName = genFeature.getEcoreFeature().getEType().getInstanceClassName();
										if (genFeature.isStringType()) {
											DerivedPlaceholder placeholder = concretesyntaxFactory.createDerivedPlaceholder();
											placeholder.setPrefix("\"");
											placeholder.setSuffix("\"");
											content = placeholder;
										}
										else if (typeName == null) {
											content = concretesyntaxFactory.createDefinedPlaceholder();
										}
										else if(typeName.equals("String")) {
											DerivedPlaceholder placeholder = concretesyntaxFactory.createDerivedPlaceholder();
											placeholder.setPrefix("\"");
											placeholder.setSuffix("\"");
											content = placeholder;
										}
										
										else if(typeName.equals("int") || typeName.equals("long")  || typeName.equals("short")){
											DefinedPlaceholder placeholder = concretesyntaxFactory.createDefinedPlaceholder();
											placeholder.setToken(intToken);
											content = placeholder;
										}
										
										else if(typeName.equals("float") || typeName.equals("double")){
											DefinedPlaceholder placeholder = concretesyntaxFactory.createDefinedPlaceholder();
											placeholder.setToken(floatToken);
											content = placeholder;
										}										
										else {
											content = concretesyntaxFactory.createDefinedPlaceholder();
										}
										
										
									}									
									content.setFeature(genFeature);
									
									
									
									innerSequence.getParts().add(content);
									parameterChoice.getOptions().add(innerSequence);
								}
							}
							if(parameterChoice.getOptions().size() > 0) {
								CompoundDefinition innerCompound = concretesyntaxFactory.createCompoundDefinition();
								innerCompound.setDefinitions(parameterChoice);
								newSequence.getParts().add(innerCompound);
								innerCompound.setCardinality(concretesyntaxFactory.createSTAR());
							}
							CsString closeBracket = concretesyntaxFactory.createCsString();
							closeBracket.setValue("}");
							newSequence.getParts().add(closeBracket);
							
							
						}
        				
        				
        				try {
							csResource.save(null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        		}

				private boolean containsSelfOfSuper(Set<EClassifier> containedClasses, EClass ecoreClass) {
					if (containedClasses.contains(ecoreClass)) return true;
					for (EClass superClass : ecoreClass.getEAllSuperTypes()) {
						if (containedClasses.contains(superClass)) return true;						
					}
					return false;
				}


        		
        	};
        	
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
         } 
        catch (InvocationTargetException e){
        	e.getTargetException().printStackTrace();
        }
        catch (InterruptedException e){
        	e.printStackTrace();
        }
     }
    
   
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        //this.part = targetPart;
	}
    

}
