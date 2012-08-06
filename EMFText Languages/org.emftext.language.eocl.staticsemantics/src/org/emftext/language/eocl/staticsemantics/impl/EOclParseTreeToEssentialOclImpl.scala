package org.emftext.language.eocl.staticsemantics.impl


import tudresden.ocl20.pivot.language.ocl.staticsemantics._
import org.emftext.language.eocl.semantics.EoclAttributeMaker
import org.eclipse.emf.ecore.semantics.EcoreAttributeMaker

import tudresden.ocl20.pivot.language.ocl.staticsemantics._
import org.emftext.language.eocl.semantics.EoclAttributeMaker
import org.eclipse.emf.ecore.semantics.EcoreAttributeMaker

import org.eclipse.emf.ecore._
import org.eclipse.emf.ecore.util._
import tudresden.ocl20.pivot.pivotmodel._
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression
import factory._
import Box._

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp._

import tudresden.attributegrammar.integration.kiama.util.CollectionConverterS2J._
import tudresden.attributegrammar.integration.kiama.util.CollectionConverterJ2S._

import org.kiama.attribution.Attribution._


trait EOclParseTreeToEssentialOclImpl extends OclParseTreeToEssentialOcl with EoclAttributeMaker with EcoreAttributeMaker {selfType : OclStaticSemantics =>

  abstract override def __computeConstraints = {
    attr {
      case e : EPackage => {
        Full(e.getEClassifiers.flatMap{c =>
          c->computeConstraints
        }.flatten(i => i))
      }
      
      case e : EClassifier => {
        Full(e.getEAnnotations.flatMap{annotation =>
          annotation match {
            case o : OclAnnotation => o.getInvariantsOrDefinitions.flatMap{iad =>
             computeConstraint(iad)
            }
            case _ => Empty
          }
        })
      }
      
      case unknown => super.__computeConstraints(unknown)
    }
  }
  
}
