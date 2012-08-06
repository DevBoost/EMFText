package org.emftext.language.eocl.semantics

import tudresden.attributegrammar.integration.kiama.util.CollectionConverterJ2S._
import tudresden.attributegrammar.integration.kiama.util.CollectionConverterS2J._


object OclAnnotation {
	def apply(
	          _eAnnotations : List[org.eclipse.emf.ecore.EAnnotation],
	          _source : String,
	          _details : List[java.util.Map.Entry[String, String]],
	          _eModelElement : org.eclipse.emf.ecore.EModelElement,
	          _contents : List[org.eclipse.emf.ecore.EObject],
	          _references : List[org.eclipse.emf.ecore.EObject],
	          _invariantsOrDefinitions : List[tudresden.ocl20.pivot.language.ocl.InvariantExpCS]	          
	          ) = {
		
		val __oclAnnotation = org.emftext.language.eocl.EoclFactory.eINSTANCE.createOclAnnotation
		
		if (_eAnnotations != null)
			__oclAnnotation.getEAnnotations.addAll(_eAnnotations)
			__oclAnnotation.setSource(_source)
		if (_details != null)
			__oclAnnotation.getDetails.addAll(_details)
			__oclAnnotation.setEModelElement(_eModelElement)
		if (_contents != null)
			__oclAnnotation.getContents.addAll(_contents)
		if (_references != null)
			__oclAnnotation.getReferences.addAll(_references)
		if (_invariantsOrDefinitions != null)
			__oclAnnotation.getInvariantsOrDefinitions.addAll(_invariantsOrDefinitions)
		
		__oclAnnotation
		
	}

	def unapply(__oclAnnotation : org.emftext.language.eocl.OclAnnotation) : Some[Tuple5[List[org.eclipse.emf.ecore.EAnnotation], List[java.util.Map.Entry[String, String]], List[org.eclipse.emf.ecore.EObject], List[tudresden.ocl20.pivot.language.ocl.InvariantExpCS], String]] = {
		Some(
			__oclAnnotation.getEAnnotations,
			__oclAnnotation.getDetails,
			__oclAnnotation.getContents,
			__oclAnnotation.getInvariantsOrDefinitions,
			__oclAnnotation.getSource		
		)
	}

}

