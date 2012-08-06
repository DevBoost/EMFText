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
package org.emftext.language.company.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.company.Company;
import org.emftext.language.company.Department;
import org.emftext.language.company.Employee;
import org.emftext.language.company.resource.company.mopp.CompanyResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationsTest {

	private static Company company;
	
	@BeforeClass
	public static void setUp(){
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("company", new CompanyResourceFactory());
		File example = new File("../org.emftext.language.company/example/example.company");
		assertTrue(example.exists());
		URI uri = URI.createFileURI(example.getAbsolutePath());
		assertNotNull(uri);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull(resource);
		List<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertTrue(contents.get(0) instanceof Company);
		company = (Company) contents.get(0);
	}
	
	@Test
	public void testCutSalaries(){
		List<Double> oldSalaries = getSalaries(company);
		company.cutSalary();
		List<Double> newSalaries = getSalaries(company);
		for (int i = 0; i < oldSalaries.size(); i++) {
			double oldSalary = oldSalaries.get(i);
			double newSalary = newSalaries.get(i);
			assertEquals(oldSalary / 2, newSalary, 0.0);
		}
	}

	private List<Double> getSalaries(Company company) {
		TreeIterator<EObject> allContents = company.eAllContents();
		List<Double> salaries = new ArrayList<Double>();
		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();
			if(eObject instanceof Employee){
				Employee employee = (Employee) eObject;
				salaries.add(employee.getSalary());
			}
		}
		return salaries;
	}
	
	@Test
	public void testDepth(){
		List<Department> departments = company.getDepartments();
		for (Department department : departments) {
			int recursiveDepth = department.depth();
			int testDepth = getDepth(department);
			System.out.println("recursive depth: " + recursiveDepth + " test depth: " + testDepth);
			assertEquals(recursiveDepth, testDepth);
		}
	}
	
	private int getDepth(Department department){
		int depth = 1;
		Set<Department> departments = new HashSet<Department>();
		departments.add(department);
		TreeIterator<EObject> allContents = department.eAllContents();
		while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if(object instanceof Department){
				departments.add((Department) object);
				Department superDepartment = (Department) object.eContainer();
				List<Department> subDepartments = superDepartment.getSubDepartments();
				boolean foundAthThisLayer = false;
				for (Department department2 : subDepartments) {
					if(!object.equals(department2) && departments.contains(department2)){
						foundAthThisLayer = true;
					}
				}
				if(!foundAthThisLayer){
					depth++;
				}
			}
		}
		return depth;
	}
}
