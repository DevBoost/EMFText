package org.emftext.language.eocl.staticsemantics.impl

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


trait EOclAttributesImpl extends OclAttributes with EoclAttributeMaker with EcoreAttributeMaker {selfType : OclStaticSemantics =>

  abstract override def __context = {
    childAttr {
      case child => {
        case e : EClassifier => 
          !!(model.findType(e.getName.split("::")))
        case _ => super.__context(child)
      }
    }
  }
  
  abstract override def __sourceExpression : Attributable ==> Box[OclExpression] = {
    childAttr {
      case child => {
        case e : EClassifier => {
          (child->self).flatMap{self =>
          	Full(factory.createVariableExp(self))
          }
        } 
        case _ => super.__sourceExpression(child)
      }
    }
  }
  
  abstract override def __self = {
    childAttr {
      case child => {
        case e : EClassifier => {
          !!(model.findType(e.getName.split("::"))).flatMap{tipe =>
          	Full(factory.createVariable("self", tipe, null))
          }
        }
        case _ => super.__self(child)
      }
    }
  }
  
  abstract override def __variables = {
    childAttr {
      case child => {
        case e : EClassifier => {
          for (self <- child->self) yield (List(self), List())
        }
        case _ => super.__variables(child)
      }
    }
  }
  
  abstract override def __namespace = {
    childAttr {
      case child => {
        case e : EPackage => {
          !!(model.findNamespace(getReversedQualifiedName(e).reverse))
        }
        case _ => super.__namespace(child)
      }
    }
  }
  
  private def getReversedQualifiedName(ePackage : EPackage) : List[String] = {
    !!(ePackage.getESuperPackage) match {
      case Full(superPackage) => ePackage.getName::getReversedQualifiedName(superPackage)
      case _ => List(ePackage.getName)
    }
  }
  
}
