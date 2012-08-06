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
package org.emftext.language.java.closures.resource.closure.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.closures.resource.closure.IClosureBuilder;

public class ClosureBuilder implements IClosureBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}

		return false;
	}
	
	public IStatus build(ClosureResource resource, IProgressMonitor monitor) {
		process(resource);
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
	private void process(final ClosureResource resource) {

		/*
		Thread workerThread = new Thread(new Runnable(){

			public void run() {
				convert(resource);
			}
			
		});
		
		workerThread.start();
		*/
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}

	/*
	private void convert(ClosureResource resource){
		
		if(resource.getURI().toString().contains("transformed"))
			return;
		
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		JavaResource javaResource = (JavaResource)resource.getResourceSet().createResource(javaURI);
		
		javaResource.getContents().clear();
		
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		// get all closures calls
		Collection<IdentifierReference> identifierReferences = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ReferencesPackage.eINSTANCE.getIdentifierReference());

		
		Map<IdentifierReference,Closure> memberClosures = 
			new HashMap<IdentifierReference,Closure>();
		Map<IdentifierReference,Closure> parameterClosures = 
			new HashMap<IdentifierReference,Closure>();
		List<Closure> methodClosures = new ArrayList<Closure>();
		List<Closure> argumentClosures = new ArrayList<Closure>();
		
		// at first it's important to replace all identifier references on closures
		// and remove this closures from resource
		
		Map<IdentifierReference,MethodCall> temporaries = 
			new HashMap<IdentifierReference,MethodCall>();
		
		for(IdentifierReference identifierReference : identifierReferences){
			
			if(identifierReference.getTarget() instanceof Closure){
				Closure closure = (Closure)identifierReference.getTarget();
				
				if(identifierReference.getNext() instanceof MethodCall){
					MethodCall next = (MethodCall) identifierReference.getNext();
			
					boolean found = false;
					
					if(closure.getValueType()!= null && 
							!closure.getStatements().isEmpty() && 
							closure.getMethodName() == null &&
							closure.getArguments().isEmpty()){
						
						found = true;
						memberClosures.put(identifierReference,closure);
					}
					if(closure.getValueType()!= null && 
							closure.getStatements().isEmpty() &&
							closure.getMethodName() == null &&
							closure.getArguments().isEmpty()){
						
						found = true;
						parameterClosures.put(identifierReference,closure);
					}
					
					// first only save the necessary method calls
					// do not set already the attributes into the closure
					// because an error would occur when a closure is called twice or more
					if(found)
						temporaries.put(identifierReference, next);

				}
			}
		}
		
		// after the search set the necessary parameters from the method calls
		// into the closures, now there is no problem after that
		for(IdentifierReference identifierReference : temporaries.keySet()){
			
			MethodCall methodCall = temporaries.get(identifierReference);
			
			Closure closure = memberClosures.get(identifierReference);
			if(closure == null)
				closure = parameterClosures.get(identifierReference);
			
			closure.getArguments().addAll(methodCall.getArguments());
			closure.setMethodName(ClosureBuilderHelper.get(closure.getName()));
		}
		
		
		
		// convert member closures
		convertMemberClosureCalls(javaResource, memberClosures);
		
		// convert parameter closures
		convertParameterClosureCall(javaResource, parameterClosures);
		
		// get all member closures calls
		Collection<Closure> closures = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosure  ());

		
		for(Closure closure : closures){
	
			if(closure.getValueType() != null && 
					!closure.getStatements().isEmpty() && 
					closure.getMethodName() !=null &&  
					closure.getArguments().isEmpty() &&
					(closure.eContainer() instanceof MethodCall ||
							closure.eContainer() instanceof NewConstructorCall)){
				
				argumentClosures.add(closure);
			}
			
			if(closure.getValueType() != null && 
					!closure.getStatements().isEmpty() && 
					closure.getMethodName() !=null &&
					!(closure.eContainer() instanceof MethodCall ||
							closure.eContainer() instanceof NewConstructorCall)){
				
				methodClosures.add(closure);
			}
		}
		
		// convert method closures
		convertMethodClosure(javaResource, methodClosures);
		
		//convert parameter closures
		convertParameterClosure(javaResource, argumentClosures);
		
		// get all closures which still are there
		// delete them because they are not called from any closure call
		
		// get all member closures calls again
		closures = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosure  ());
		
		for(Closure closure : closures){
			EcoreUtil.delete(closure);
		}
		
		// save java new resource
		try {
			javaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String firstToUpper(String string){
		
		if(string == null)
			return "";
		if(string.length() == 0)
			return "";
		if(string.length() == 1)
			return string.toUpperCase();
		else
			return string.substring(0, 1).toUpperCase().concat(string.substring(1));
	}
	private Classifier createInterface(
			AbstractClosure memberClosure, 
			Resource resource,
			String methodName, 
			String closureName, 
			TypeReference valueType){
		
			String interfaceName = firstToUpper(closureName);
			
			// new resource for interface
			URI javaResourceURI = resource.getURI().trimFileExtension().trimSegments(1);
			javaResourceURI = javaResourceURI.appendSegment(interfaceName).appendFileExtension("java");
			Resource javaResource = resource.getResourceSet().createResource(javaResourceURI);
			
			try {
				javaResource.load(null);
			} catch (Exception e) {}
			
			// new interface
			Interface _interface = ClassifiersFactory.eINSTANCE.createInterface();
			_interface.setName(interfaceName);
			
			// modifier
			_interface.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
			
			List<ClassifierImport> imports = new ArrayList<ClassifierImport>();
			
			// method for interface
			InterfaceMethod interfaceMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			
			// parameters
			for(Parameter parameter : memberClosure.getParameters()){
				Parameter parameterCopy = EcoreUtil.copy(parameter);
				interfaceMethod.getParameters().add(parameterCopy);
				// import
				ClassifierImport _import = getNecessaryImport(parameterCopy.getTypeReference(), resource);
				if (_import != null)
					imports.add(_import);
			}
			
			// name
			interfaceMethod.setName(methodName);
			
			// type reference
			interfaceMethod.setTypeReference(EcoreUtil.copy(valueType));
			
			// type reference array dimension
			interfaceMethod.getArrayDimensionsBefore().addAll(
					EcoreUtil.copyAll(memberClosure.getValueTypeArrayDimension()));
			
			// set modifiers
			if(memberClosure.getAnnotationsAndModifiers()!=null){
				
				boolean publicFound = false;
				boolean privateFound = false;
				boolean protectedFound = false;
				
				for(AnnotationInstanceOrModifier modifier : memberClosure.getAnnotationsAndModifiers()){
					
					if(modifier instanceof Public)
						publicFound = true;
					if(modifier instanceof Private)
						privateFound = true;
					if(modifier instanceof Protected)
						protectedFound = true;
					
					interfaceMethod.getAnnotationsAndModifiers().add(EcoreUtil.copy(modifier));
					
				}
				if(!publicFound && !privateFound && !protectedFound)
					interfaceMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
			
			}
			
			// import
			ClassifierImport _import = getNecessaryImport(valueType, resource);
			if (_import != null)
				imports.add(_import);
			
			// set method into interface
			_interface.getMembers().add(interfaceMethod);
			
			// set interface into resource
			CompilationUnit compilationUnit = ContainersFactory.eINSTANCE.createCompilationUnit();
			compilationUnit.setName(interfaceName);
			compilationUnit.getClassifiers().add(_interface);
			javaResource.getContents().clear();
			javaResource.getContents().add(compilationUnit);
			
			// namespace
			compilationUnit.getNamespaces().addAll(((CompilationUnit)resource.getContents().get(0)).getNamespaces());
			// imports
			compilationUnit.getImports().addAll(imports);
			
			// save
			if(!javaResource.getContents().isEmpty()){
				try {
					javaResource.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return _interface;
			
	}
	
	private ClassifierImport getNecessaryImport(TypeReference typeReference, Resource resource){
		
		if(typeReference instanceof PrimitiveType)
			return null;
		
		// get all imports
		Collection<ClassifierImport> imports = 
			JavaEObjectUtil.getObjectsByType(resource.getAllContents(), ImportsPackage.eINSTANCE.getClassifierImport());
		for(ClassifierImport _import : imports){
			if(_import.getClassifier().equals(typeReference.getTarget().getContainingConcreteClassifier())){
				return EcoreUtil.copy(_import);
			}
		}
		
		return null;
	}
	
	/*
	private ClassifierImport getNecessaryImport(String name, Resource resource) {
		
		if(name == null)
			return null;
		
		// get all imports
		Collection<ClassifierImport> imports = 
			JavaEObjectUtil.getObjectsByType(resource.getAllContents(), ImportsPackage.eINSTANCE.getClassifierImport());
		for(ClassifierImport _import : imports){
			if(_import.getClassifier().getName().equals(name)){
				return EcoreUtil.copy(_import);
			}
		}
		
		return null;
	}
	
	private MethodCall createAnonymousClass(
			AbstractClosureCall call,
			IdentifierReference identifierReference,
			String methodName,
			String closureName, 
			TypeReference type, 
			AbstractClosure closure, 
			Resource resource,
			boolean isMethodCall){
		
		if(closureName == null && closure.getTypeReference() == null)
			return null;
		
		// create a interface for anonymous class
		Classifier _interface = null;
		
		if(closure.getTypeReference() != null){
			try {
				closureName = closure.getTypeReference().getTarget().getContainingConcreteClassifier().getName();
			} catch (Exception e) {}
			// not necessary to build a new interface, it's already there 
			if(closureName != null)
				_interface = closure.getTypeReference().getTarget().getContainingConcreteClassifier();
		}	
		else{
			// we need a new interface, no interface or abstract class in classpath
			_interface = createInterface(closure, resource, methodName, closureName, type);
		}
		
		// set reference to interface
		if(_interface == null)
				return null;
		
		// create constructor call for interface
		NewConstructorCall newConstructorCall = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		NamespaceClassifierReference namespaceClassifierReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference();
		ClassifierReference classifierReference = TypesFactory.eINSTANCE.createClassifierReference();
		
	
		classifierReference.setTarget(_interface);
		namespaceClassifierReference.getClassifierReferences().add(classifierReference);
		newConstructorCall.setTypeReference(namespaceClassifierReference);
		
		// create anonymous class with a invoke class method
		AnonymousClass anonymousClass = ClassifiersFactory.eINSTANCE.createAnonymousClass();
		ClassMethod classMethod = MembersFactory.eINSTANCE.createClassMethod();
		
		// set parameters
		for(Parameter parameter : closure.getParameters()){
			Parameter parameterCopy = EcoreUtil.copy(parameter);
			classMethod.getParameters().add(parameterCopy);
		}
		
		// set modifiers
		if(closure.getAnnotationsAndModifiers()!=null){
			
			boolean publicFound = false;
			boolean privateFound = false;
			boolean protectedFound = false;
			
			for(AnnotationInstanceOrModifier modifier : closure.getAnnotationsAndModifiers()){
				
				if(modifier instanceof Public)
					publicFound = true;
				if(modifier instanceof Private)
					privateFound = true;
				if(modifier instanceof Protected)
					protectedFound = true;
				
				classMethod.getAnnotationsAndModifiers().add(EcoreUtil.copy(modifier));
				
			}
			if(!publicFound && !privateFound && !protectedFound)
				classMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
		
		}
		// name
		classMethod.setName(methodName);
		
		// type reference
		classMethod.setTypeReference(EcoreUtil.copy(type));
		
		// type reference array dimension
		classMethod.getArrayDimensionsBefore().addAll(
				EcoreUtil.copyAll(closure.getValueTypeArrayDimension()));
		
		
		// set all statements of closure into new method
		// attention to a return type, put return into method when necessary
		if(type instanceof org.emftext.language.java.types.Void){
			classMethod.getStatements().addAll(closure.getStatements());
		}
		else{

			Collection<Return> returns =
				ClosureEObjectUtil.getObjectsByType(
						EcoreUtil.getAllContents(closure.getStatements()), StatementsPackage.eINSTANCE.getReturn());
			
			// perhaps one or more returns already set in the statements of the closure ?
			if(returns.isEmpty()){
				for(int i=0;i<closure.getStatements().size();i++){
					if(i<closure.getStatements().size()-1)
						classMethod.getStatements().add(EcoreUtil.copy(closure.getStatements().get(i)));
					else{
						Return _return = StatementsFactory.eINSTANCE.createReturn();
						if(closure.getStatements().get(i) instanceof ExpressionStatement){
							ExpressionStatement expression = 
								(ExpressionStatement)closure.getStatements().get(i);
							_return.setReturnValue(EcoreUtil.copy(expression.getExpression())); 
						}
						else
						if(closure.getStatements().get(i) instanceof Statement){
							classMethod.getStatements().add(EcoreUtil.copy(closure.getStatements().get(i)));
						}
						
						classMethod.getStatements().add(_return);
					}
				}
			}
			else{
				classMethod.getStatements().addAll(closure.getStatements());
			}
		}
		
		// set invoke class method into anonymous class
		anonymousClass.getMembers().add(classMethod);
		
		// method call of inner method
		MethodCall methodCall = null;
		
		if(isMethodCall){
			
			// method call of inner invoke class method
			methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			methodCall.setTarget(classMethod);
			
			for(Expression expression : call.getArguments()){
				Expression expressionCopy = EcoreUtil.copy(expression);
				methodCall.getArguments().add(expressionCopy);
			}
			
			// call of the inner invoke method
			newConstructorCall.setNext(methodCall);
		}
		
		// call of new inner method
		if(closure.getNext() != null){
			if(isMethodCall)
				methodCall.setNext(EcoreUtil.copy(closure.getNext()));
			else if(_interface != null && classMethod != null){
				newConstructorCall.setNext(EcoreUtil.copy(closure.getNext()));
			}
		}
		
		// set anonymous class 
		newConstructorCall.setAnonymousClass(anonymousClass);
		
		if(identifierReference == null){
		
			if(call.eContainer() instanceof Method){
				// expression statement is necessary 		
				ExpressionStatement expressionStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
				expressionStatement.setExpression(newConstructorCall);
				
				// replace with new method call
				EcoreUtil.replace(call, expressionStatement);
			}
			else{
				// replace call with new constructor call
				EcoreUtil.replace(call, newConstructorCall);
			}
			
//			if(call.eContainer() instanceof LocalVariable || 
//					call.eContainer() instanceof MethodCall ||
//					call.eContainer() instanceof AssignmentExpression ||
//					call.eContainer() instanceof Return){
//				
//				// replace call with new constructor call
//				EcoreUtil.replace(call, newConstructorCall);
//			}
//			else{
//				// expression statement is necessary 		
//				ExpressionStatement expressionStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
//				expressionStatement.setExpression(newConstructorCall);
//				
//				// replace with new method call
//				EcoreUtil.replace(call, expressionStatement);
//			}
		}
		else{
			if(identifierReference.eContainer() instanceof ExpressionStatement){
				
				ExpressionStatement superExpression = 
					(ExpressionStatement) identifierReference.eContainer();
				
				// expression statement is necessary 		
				ExpressionStatement expressionStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
				expressionStatement.setExpression(newConstructorCall);
				
				// replace with new method call
				EcoreUtil.replace(superExpression, expressionStatement);
			}
			if(identifierReference.eContainer() instanceof AssignmentExpression ||
					identifierReference.eContainer() instanceof LocalVariable){
				// replace identifier with new constructor call
				EcoreUtil.replace(identifierReference, newConstructorCall);
			}
		}
		
		
		return methodCall;
	}
	
	private void convertMemberClosureCalls(
			JavaResource resource, 
			Map<IdentifierReference,Closure> memberClosures){
		
		List<Closure> oldClosures = new ArrayList<Closure>();
		
		// convert them into method calls
		for (IdentifierReference identifierReference : memberClosures.keySet()){
			
			Closure memberClosure = memberClosures.get(identifierReference);
		
			createAnonymousClass(
					memberClosure,
					identifierReference,
					memberClosure.getMethodName(), 
					memberClosure.getName(), 
					memberClosure.getValueType(), 
					memberClosure, 
					resource,
					true);			
		
			oldClosures.add(memberClosure); 
		}
		
		for(Closure closure : oldClosures){
			EcoreUtil.delete(closure);
		}

	}
	
	private void convertMethodClosure(
			JavaResource resource,
			List<Closure> methodClosures){

		
		int iCounter = 1;
		
		for (Closure methodClosure : methodClosures){
			
			String defaultName = "";
			
			if(methodClosure.getName() == null){
				
				for(int i = iCounter; i>0;i--){
					defaultName += "I";
				}
				iCounter++;
			}
			else
				defaultName = methodClosure.getName();
			
		
			createAnonymousClass(
					methodClosure,
					null,
					methodClosure.getMethodName(),
					defaultName, 
					methodClosure.getValueType(), 
					methodClosure, 
					resource,
					true);
		}
	}
	
private void convertParameterClosure(JavaResource resource, List<Closure> parameterClosures){
		
		for (Closure parameterClosure : parameterClosures){
			
			createAnonymousClass(
					parameterClosure,
					null,
					parameterClosure.getMethodName(),
					parameterClosure.getName(), 
					parameterClosure.getValueType(), 
					parameterClosure, 
					resource,
					false);
		}
	}
	
	private void convertParameterClosureCall(
			JavaResource resource, 
			Map<IdentifierReference,Closure> memberClosures){
		
		List<Closure> oldClosures = new ArrayList<Closure>();
		
		// convert them into method calls
		for (IdentifierReference identifierReference : memberClosures.keySet()){
			
			Closure parameterClosure = memberClosures.get(identifierReference);
			
			// get super class method of parameter closure
			EObject object = parameterClosure.eContainer();
			ClassMethod classMethod = null;
			
			if(object instanceof ClassMethod){
				classMethod = (ClassMethod)object;
			}
			
			if(classMethod == null)
				continue;
			
			int parameterCounter = 0;
			
			// search in parameters of class method the parameter closure
			for(Parameter parameter : classMethod.getParameters()){
				if(parameter.equals(parameterClosure))
					break;
				else
					parameterCounter++;
			}
			
			// find parameter closure assignment for this method in a method call
			Closure parameterClosureAssignment = null;
						
			Collection<MethodCall> methodCalls = 
				JavaEObjectUtil.getObjectsByType(resource.getAllContents(), ReferencesPackage.eINSTANCE.getMethodCall());

			MethodCall methodCall = null;
			
			// search not only for a parameter closure assignment
			// also the place on the parameter list in method call must be equal
			for(MethodCall mc : methodCalls){
				try{
				
					if(mc.getTarget().getName().equals(classMethod.getName())){
						methodCall = mc;
						int iCounter = 0;
						for(Expression argument : methodCall.getArguments()){
							if(argument instanceof Closure && iCounter == parameterCounter){
								parameterClosureAssignment =
									(Closure) argument;
							}
							else{
								iCounter++;
							}
						}
					}
				}
				catch(Exception e){}
			}
			
			if(parameterClosureAssignment == null)
				continue;
			
			// set statements from parameter closure assignment into parameter closure
			for(Statement statement : parameterClosureAssignment.getStatements()){
				parameterClosure.getStatements().add(EcoreUtil.copy(statement));
			}
			
			// set parameters from parameter closure assignment into parameter closure
			for(Parameter parameter : parameterClosureAssignment.getParameters()){
				Parameter parameterCopy = EcoreUtil.copy(parameter);
				parameterClosure.getParameters().add(parameterCopy);
			}
		
			// create the anonymous class with his interface
			MethodCall innerMethodCall = createAnonymousClass(
					parameterClosure,
					identifierReference,
					parameterClosure.getMethodName(),
					parameterClosure.getName(), 
					parameterClosure.getValueType(), 
					parameterClosure, 
					resource,
					true);
			
			if(innerMethodCall == null)
				continue;
			
			// still something to do...
			
			// set parameters of parameter closure assignment also into super class method
			for(Parameter parameter : parameterClosureAssignment.getParameters()){
				Parameter parameterCopy = EcoreUtil.copy(parameter);
				classMethod.getParameters().add(parameterCopy);
			}

			// delete parameter closure in parameters list of super class method
//			EcoreUtil.delete(parameterClosure); 
			
			// set arguments in method call of super class method
			for(Expression argument : parameterClosure.getArguments()){
				methodCall.getArguments().add(EcoreUtil.copy(argument));
			}
			
			// set in inner method call of invoke class method of anonymous class
			// identifier references to the parameters of the super class method
			innerMethodCall.getArguments().clear();

			for(Parameter parameter : parameterClosureAssignment.getParameters()){
				IdentifierReference identifierReference2 = ReferencesFactory.eINSTANCE.createIdentifierReference();
				identifierReference2.setTarget(parameter);
				innerMethodCall.getArguments().add(identifierReference2);
			}
			
			oldClosures.add(parameterClosure); 
			oldClosures.add(parameterClosureAssignment);
		}
		
		for(Closure closure : oldClosures){
			EcoreUtil.delete(closure);
		}
	}
	
	*/
}
