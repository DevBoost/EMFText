package org.emftext.language.eocl.semantics

trait EoclAttributeMaker extends tudresden.attributegrammar.integration.kiama.AttributeMaker {
	self : tudresden.attributegrammar.integration.kiama.AttributeMaker =>
	
	protected abstract override def registeredAttributables : PartialFunction[org.eclipse.emf.ecore.EObject, tudresden.attributegrammar.integration.kiama.AttributableEObject] = {
		case s : org.emftext.language.eocl.OclAnnotation => new {val attributeMaker = self; val eObject = s} with OclAnnotationAttributable
		case source => super.registeredAttributables(source)
	}
}
