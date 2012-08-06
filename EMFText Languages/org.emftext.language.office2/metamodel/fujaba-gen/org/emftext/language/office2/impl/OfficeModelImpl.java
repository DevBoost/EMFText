/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 */
package org.emftext.language.office2.impl;


import java.util.*;
import org.emftext.language.office2.OfficeElement;
import org.emftext.language.office2.Office2Factory;
import org.emftext.language.office2.Employee;
import org.emftext.language.office2.Office;
import java.util.ArrayList;
import org.emftext.language.office2.LeisureRoom;


/**
 * @generated
 **/
public class OfficeModelImpl extends NamedElement
{


   public void assignToOffice (){
      boolean fujaba__Success = false;
      Iterator<OfficeElement> fujaba__IterThisToEmployeeWithoutOffice = null;
      Object _TmpObject = null;
      Employee employeeWithoutOffice = null;
      Office newOffice = null;

      // story pattern storypatternwiththis
      try
      {
         fujaba__Success = false;

         // iterate to-many link elements from this to employeeWithoutOffice
         fujaba__Success = false;
         fujaba__IterThisToEmployeeWithoutOffice = this.getElements().iterator ();

         while ( !(fujaba__Success) && fujaba__IterThisToEmployeeWithoutOffice.hasNext () )
         {
            try
            {
               _TmpObject =  fujaba__IterThisToEmployeeWithoutOffice.next ();

               // ensure correct type and really bound of object employeeWithoutOffice
               if (!( _TmpObject instanceof Employee )) {throw new Exception("SDMException");};
               employeeWithoutOffice = (Employee) _TmpObject;

               // negative check for link worksIn from employeeWithoutOffice
               if (!( employeeWithoutOffice.getWorksIn () == null)) {throw new Exception("SDMException");};

               fujaba__Success = true;
            }
            catch ( Exception fujaba__InternalException )
            {
               fujaba__Success = false;
            }
         }
         if (!(fujaba__Success)) {throw new Exception("SDMException");};
         // create object
         newOffice = Office2Factory.eINSTANCE.createOffice();
         // assign statement
         newOffice.setName ("OfficeOf" + employeeWithoutOffice.getName());
         // create link
         newOffice.setOfficeModel(this);

         // create link
         employeeWithoutOffice.setWorksIn(newOffice);

         fujaba__Success = true;
      }
      catch ( Exception fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      return ;

   }


   public void relocate (){
      boolean fujaba__Success = false;
      Iterator<OfficeElement> fujaba__IterThisToSomeEmployee = null;
      Object _TmpObject = null;
      Employee someEmployee = null;
      Iterator<OfficeElement> fujaba__IterThisToLunchPlace = null;
      LeisureRoom lunchPlace = null;
      Office myOffice = null;

      // story pattern storypatternwiththis
      try
      {
         fujaba__Success = false;

         // attribute condition
         if (!( this.getCurrentTime () < 12.30 )) {throw new Exception("SDMException");};

         // attribute condition
         if (!( this.getCurrentTime () > 11.30 )) {throw new Exception("SDMException");};

         fujaba__Success = true;
      }
      catch ( Exception fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      if (fujaba__Success)
      {
         // story pattern storypatternwiththis
         try
         {
            fujaba__Success = false;

            // iterate to-many link elements from this to lunchPlace
            fujaba__Success = false;
            fujaba__IterThisToLunchPlace = new ArrayList<OfficeElement>(this.getElements()).iterator ();

            while ( fujaba__IterThisToLunchPlace.hasNext () )
            {
               try
               {
                  _TmpObject =  fujaba__IterThisToLunchPlace.next ();

                  // ensure correct type and really bound of object lunchPlace
                  if (!( _TmpObject instanceof LeisureRoom )) {throw new Exception("SDMException");};
                  lunchPlace = (LeisureRoom) _TmpObject;

                  // iterate to-many link elements from this to someEmployee
                  fujaba__Success = false;
                  fujaba__IterThisToSomeEmployee = new ArrayList<OfficeElement>(this.getElements()).iterator ();

                  while ( fujaba__IterThisToSomeEmployee.hasNext () )
                  {
                     try
                     {
                        _TmpObject =  fujaba__IterThisToSomeEmployee.next ();

                        // ensure correct type and really bound of object someEmployee
                        if (!( _TmpObject instanceof Employee )) {throw new Exception("SDMException");};
                        someEmployee = (Employee) _TmpObject;

                        // attribute condition
                        if (!( "Mensa".equals(lunchPlace.getName ()) )) {throw new Exception("SDMException");};

                        // create link
                        someEmployee.setCurrentlyIn(lunchPlace);


                        fujaba__Success = true;
                     }
                     catch ( Exception fujaba__InternalException )
                     {
                        fujaba__Success = false;
                     }
                  }
                  if (!(fujaba__Success)) {throw new Exception("SDMException");};

                  fujaba__Success = true;
               }
               catch ( Exception fujaba__InternalException )
               {
                  fujaba__Success = false;
               }
            }
            if (!(fujaba__Success)) {throw new Exception("SDMException");};
            fujaba__Success = true;
         }
         catch ( Exception fujaba__InternalException )
         {
            fujaba__Success = false;
         }

         return ;

      }
      else
      {
         // story pattern storypatternwiththis
         try
         {
            fujaba__Success = false;

            // iterate to-many link elements from this to someEmployee
            fujaba__Success = false;
            fujaba__IterThisToSomeEmployee = new ArrayList<OfficeElement>(this.getElements()).iterator ();

            while ( fujaba__IterThisToSomeEmployee.hasNext () )
            {
               try
               {
                  _TmpObject =  fujaba__IterThisToSomeEmployee.next ();

                  // ensure correct type and really bound of object someEmployee
                  if (!( _TmpObject instanceof Employee )) {throw new Exception("SDMException");};
                  someEmployee = (Employee) _TmpObject;

                  // bind object
                  myOffice = someEmployee.getWorksIn ();

                  // check object myOffice is really bound
                  if (!( myOffice != null )) {throw new Exception("SDMException");};

                  // create link
                  someEmployee.setCurrentlyIn(myOffice);



                  fujaba__Success = true;
               }
               catch ( Exception fujaba__InternalException )
               {
                  fujaba__Success = false;
               }
            }
            if (!(fujaba__Success)) {throw new Exception("SDMException");};
            fujaba__Success = true;
         }
         catch ( Exception fujaba__InternalException )
         {
            fujaba__Success = false;
         }

         return ;

      }

   }


   public void removeYou()
   {
      this.getElements().clear();
super.removeYou ();   }
}


