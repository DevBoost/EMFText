package org.emftext.language.eocl.semantics


	private trait OclAnnotationAttributable extends org.emftext.language.eocl.OclAnnotation with tudresden.attributegrammar.integration.kiama.AttributableEObject {
		type T = org.emftext.language.eocl.OclAnnotation
	
		override def getEAnnotation(_source : String) : org.eclipse.emf.ecore.EAnnotation = eObject.getEAnnotation( _source )
		override def eClass() : org.eclipse.emf.ecore.EClass = eObject.eClass()
		override def eIsProxy() : Boolean = eObject.eIsProxy()
		override def eResource() : org.eclipse.emf.ecore.resource.Resource = eObject.eResource()
		override def eContainer() : org.eclipse.emf.ecore.EObject = eObject.eContainer()
		override def eContainingFeature() : org.eclipse.emf.ecore.EStructuralFeature = eObject.eContainingFeature()
		override def eContainmentFeature() : org.eclipse.emf.ecore.EReference = eObject.eContainmentFeature()
		override def eContents() : org.eclipse.emf.common.util.EList[org.eclipse.emf.ecore.EObject] = eObject.eContents()
		override def eAllContents() : org.eclipse.emf.common.util.TreeIterator[org.eclipse.emf.ecore.EObject] = eObject.eAllContents()
		override def eCrossReferences() : org.eclipse.emf.common.util.EList[org.eclipse.emf.ecore.EObject] = eObject.eCrossReferences()
		override def eGet(_feature : org.eclipse.emf.ecore.EStructuralFeature) : java.lang.Object = eObject.eGet( _feature )
		override def eGet(_feature : org.eclipse.emf.ecore.EStructuralFeature, _resolve : Boolean) : java.lang.Object = eObject.eGet( _feature ,  _resolve )
		override def eSet(_feature : org.eclipse.emf.ecore.EStructuralFeature, _newValue : java.lang.Object) : Unit = eObject.eSet( _feature ,  _newValue )
		override def eIsSet(_feature : org.eclipse.emf.ecore.EStructuralFeature) : Boolean = eObject.eIsSet( _feature )
		override def eUnset(_feature : org.eclipse.emf.ecore.EStructuralFeature) : Unit = eObject.eUnset( _feature )
		override def getEAnnotations() = eObject.getEAnnotations()
		override def getSource() = eObject.getSource()
		override def setSource(_EString : String) = eObject.setSource(_EString : String)
		override def getDetails() = eObject.getDetails()
		override def getEModelElement() = eObject.getEModelElement()
		override def setEModelElement(_EModelElement : org.eclipse.emf.ecore.EModelElement) = eObject.setEModelElement(_EModelElement : org.eclipse.emf.ecore.EModelElement)
		override def getContents() = eObject.getContents()
		override def getReferences() = eObject.getReferences()
		override def getInvariantsOrDefinitions() = eObject.getInvariantsOrDefinitions()
	}

