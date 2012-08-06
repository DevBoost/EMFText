package org.emftext.language.eocl.staticsemantics.impl

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp._
import tudresden.ocl20.pivot.language.ocl.staticsemantics._
import impl._

object EOclStaticSemanticsFactoryImplHelper {

  def createOclStaticSemantics(_resource : IOclResource) : OclStaticSemantics = {
    new OclStaticSemantics with OclAttributesImpl with OclParseTreeToEssentialOclImpl with EOclParseTreeToEssentialOclImpl with EOclAttributesImpl {
      val resource = _resource
    }
  }
  
}
