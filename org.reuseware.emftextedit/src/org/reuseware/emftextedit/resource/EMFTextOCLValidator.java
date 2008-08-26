package org.reuseware.emftextedit.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

public class EMFTextOCLValidator {
	
	private TextResource textResource;

	public void analyse(EObject rootObject) {
		
		Resource resource = rootObject.eResource();
		if (resource instanceof TextResource) {
			this.textResource = (TextResource) resource;
		}
		TreeIterator<EObject> allContents = resource.getAllContents();
		IFile file = WorkspaceSynchronizer.getFile(resource);

		int errors = 0;
		while (allContents.hasNext()) {
			errors += evaluate((EObject) allContents.next(), file);
		}
		
	}
	
	private Collection<EClass> getAllMetaclasses(EObject object) {
		Set<EClass> metaclasses = new HashSet<EClass>();
		EClass metaclass = object.eClass();
		metaclasses.add(metaclass);
		EList<EClass> superTypes = metaclass.getESuperTypes();
		metaclasses.addAll(superTypes);
		for (EClass supertype : superTypes) {
			metaclasses.addAll(collectSupertypes(supertype));
		}
		return metaclasses;
	}
	
	private Collection<EClass> collectSupertypes(EClass type) {
		Set<EClass> metaclasses = new HashSet<EClass>();
		EList<EClass> superTypes = type.getESuperTypes();
		metaclasses.addAll(superTypes);
		for (EClass supertype : superTypes) {
			metaclasses.addAll(collectSupertypes(supertype));
		}
		return metaclasses;
	}
	
	private int evaluate(EObject targetObject, IFile file) {
		int errors = 0;

		List<EAnnotation> annotations = new ArrayList<EAnnotation>();
		Collection<EClass> metaclasses = getAllMetaclasses(targetObject);
				
		for (EClass metaclass : metaclasses) {
			annotations.addAll(metaclass.getEAnnotations());
		}
		
		
		for (EAnnotation annotation : annotations) {
			if (annotation.getSource().equals("OCL")) {
				Iterator<String> detailsIt = annotation.getDetails().keySet()
						.iterator();
				while (detailsIt.hasNext()) {
					Object key = detailsIt.next();
					String value = annotation.getDetails().get(key);
					OCL ocl = OCL
							.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
					OCL.Helper helper = ocl.createOCLHelper();
					try {
						helper.setInstanceContext(targetObject);
						OCLExpression exp = helper.createQuery(value);
						Query<?, ?, ?> query = OCL.newInstance().createQuery(
								exp);

						Object eval = query.evaluate(targetObject);
						boolean report = false;
						
						if ((eval instanceof Boolean)){	
							report = !((Boolean) eval).booleanValue(); 
						}
						else if(eval instanceof EObject){
							report = ((EObject)eval).eClass().getName().equals("Invalid_Class");
						}
						
						
						if(report){
							errors++;
							String errorMsg = key.toString();
							if (textResource != null) {
								textResource.addError(errorMsg, targetObject);
							}
							else {
								
								IMarker marker = file.createMarker(IMarker.PROBLEM);
								
								marker.setAttribute(IMarker.MESSAGE, errorMsg);
								marker.setAttribute(IMarker.SEVERITY,
										IMarker.SEVERITY_ERROR);
	
								marker.setAttribute(IMarker.LOCATION, targetObject
										.toString());
							}							
		
						}
					} catch (org.eclipse.ocl.ParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return errors;
	}
}
