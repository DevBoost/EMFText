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
package org.emftext.language.java.sqljava.resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportsFactory;
import org.emftext.language.java.literals.LiteralsFactory;
import org.emftext.language.java.literals.NullLiteral;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.operators.Assignment;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.parameters.OrdinaryParameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.sqljava.Connection;
import org.emftext.language.java.sqljava.Query;
import org.emftext.language.java.sqljava.RegisterDriver;
import org.emftext.language.java.sqljava.SqlExpression;
import org.emftext.language.java.sqljava.SqljavaPackage;
import org.emftext.language.java.sqljava.resource.helper.ConvertSelectExpressionHelper;
import org.emftext.language.java.sqljava.resource.helper.ReferenceHelper;
import org.emftext.language.java.sqljava.resource.helper.ResolverHelper;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaOptionProvider;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaOptions;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaResourcePostProcessor;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaResourcePostProcessorProvider;
import org.emftext.language.java.sqljava.resource.sqljava.mopp.SqljavaResource;
import org.emftext.language.java.sqljava.resource.sqljava.util.SqljavaEObjectUtil;
import org.emftext.language.java.statements.CatchBlock;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.statements.TryBlock;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesFactory;


/**
 * Post processor that performs
 * <i>cast repair</i>,
 * <i>expression simplification</i> and
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class SqlJavaTransformPostProcessor implements ISqljavaOptionProvider, ISqljavaResourcePostProcessor, ISqljavaResourcePostProcessorProvider {

	LocalVariable connection = null;
	static SqljavaResource resource = null;

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ISqljavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final SqljavaResource resource) {

		Thread worker = new Thread(new Runnable(){
			public void run() {
				convert(resource);
			}
		});

		worker.start();
	}

	public ISqljavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public static SqljavaResource getResource() {
		return resource;
	}

	private void convert(SqljavaResource resource){

		SqlJavaTransformPostProcessor.resource = resource;

		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		JavaResource javaResource = (JavaResource)resource.getResourceSet().createResource(javaURI);

		//--

		convertRegisterDriver();
		convertConnection();
		convertSqlExpression();
		convertQuery();
		//--

		javaResource.getContents().addAll(resource.getContents());

		try {
			javaResource.save(null);
		} catch (IOException e) {}
	}



	private Method getMethod(ConcreteClassifier concreteClassifier, String methodName ){
		for(Member member : concreteClassifier.getMembers()){
			if(member instanceof Method){
				if(member.getName().equals(methodName))
					return (Method)member;
			}
		}
		for(ConcreteClassifier superConcreteClassifier :
			concreteClassifier.getAllSuperClassifiers()){ //TODO not work for every class
			return getMethod(superConcreteClassifier, methodName);
		}
		return null;
	}

	private void getResolvedImport(List<String> namespaces, String className, SqljavaResource resource){

		CompilationUnit complationUnit =
			(CompilationUnit)SqljavaEObjectUtil.findRootContainer(resource.getContents().get(0));

		boolean found = false;

		for(Import _import : complationUnit.getImports()){
			if(_import instanceof ClassifierImport){
				if(((ClassifierImport)_import).getClassifier().getName().equals(className)){
					found = true;
					break;
				}
			}
		}
		if(found)
			return;

		ClassifierImport classifierImport = ImportsFactory.eINSTANCE.createClassifierImport();
		complationUnit.getImports().add(classifierImport);
		classifierImport.setClassifier(
				(ConcreteClassifier)JavaClasspath.get(resource).getClassifier(className));
		classifierImport.getNamespaces().addAll(namespaces);
		ConcreteClassifier concreteClassifier =
			ResolverHelper.getResolvedClassifier(className, classifierImport);
		if(concreteClassifier==null)
			EcoreUtil.delete(classifierImport);
		else
			classifierImport.setClassifier(concreteClassifier);
	}

	protected void convertRegisterDriver(){

		Collection<RegisterDriver> drivers =
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getRegisterDriver());

		getResolvedImport(Arrays.asList("java","lang"), "Class", resource);

		for(RegisterDriver driver : drivers){


			TryBlock tryBlock =
				StatementsFactory.eINSTANCE.createTryBlock();
			EcoreUtil.replace(driver,tryBlock);

			ExpressionStatement expressionStatement =
				StatementsFactory.eINSTANCE.createExpressionStatement();
			tryBlock.getStatements().add(expressionStatement);

			IdentifierReference identifierReference =
				ReferencesFactory.eINSTANCE.createIdentifierReference();

			expressionStatement.setExpression(identifierReference);

			ConcreteClassifier concreteClassifier =
				(ConcreteClassifier)ResolverHelper.getResolvedElement("Class", identifierReference);
			if(concreteClassifier == null)
				continue;

			identifierReference.setTarget(concreteClassifier);

			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			Method method = getMethod(concreteClassifier, "forName");
			methodCall.setTarget(method);

			identifierReference.setNext(methodCall);

			methodCall.getArguments().add(
					ReferenceHelper.getNewStringReference(driver.getDriver()));

			getResolvedImport(Arrays.asList("java","lang"), "ClassNotFoundException", resource);
			createCatchBlock(tryBlock, "", "ClassNotFoundException", true);

		}
	}

	protected void convertConnection(){

		Collection<Connection> connections =
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getConnection());

		getResolvedImport(Arrays.asList("java","sql"), "DriverManager", resource);
		getResolvedImport(Arrays.asList("java","sql"), "Connection", resource);

		for(Connection connection : connections){

			LocalVariableStatement localVariableStatement = StatementsFactory.eINSTANCE.createLocalVariableStatement();
			ClassMethod superMethod = ((ClassMethod)connection.eContainer());
			EcoreUtil.replace(connection, localVariableStatement);

			LocalVariable localVariable = VariablesFactory.eINSTANCE.createLocalVariable();
			localVariable.setName(connection.getName());
			localVariableStatement.setVariable(localVariable);
			this.connection = localVariable;

			NullLiteral _null = LiteralsFactory.eINSTANCE.createNullLiteral();
			localVariable.setInitialValue(_null);

			NamespaceClassifierReference namespaceReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference();
			localVariable.setTypeReference(namespaceReference);

			ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
			namespaceReference.getClassifierReferences().add(reference);

			ConcreteClassifier connectionClass =
				ResolverHelper.getResolvedClassifier("Connection", reference);
			if(connectionClass == null)
				continue;
			reference.setTarget(connectionClass);

			ExpressionStatement expressionStatement =
				StatementsFactory.eINSTANCE.createExpressionStatement();
			TryBlock tryBlock =
				StatementsFactory.eINSTANCE.createTryBlock();
			tryBlock.getStatements().add(expressionStatement);
			superMethod.getStatements().add(2,tryBlock);

			AssignmentExpression assignmentExpression =
				ExpressionsFactory.eINSTANCE.createAssignmentExpression();
			expressionStatement.setExpression(assignmentExpression);

			Assignment assignment = OperatorsFactory.eINSTANCE.createAssignment();

			IdentifierReference c = ReferencesFactory.eINSTANCE.createIdentifierReference();
			c.setTarget(localVariable);

			assignmentExpression.setAssignmentOperator(assignment);
			assignmentExpression.setChild(c);

			IdentifierReference identifierReference =
				ReferencesFactory.eINSTANCE.createIdentifierReference();
			assignmentExpression.setValue(identifierReference);
			ConcreteClassifier driverManager =
				(ConcreteClassifier)ResolverHelper.getResolvedElement("DriverManager", identifierReference);
			if(driverManager == null)
				continue;
			identifierReference.setTarget(driverManager);

			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			identifierReference.setNext(methodCall);

			Method method = getMethod(driverManager, "getConnection");
			methodCall.setTarget(method);

			methodCall.getArguments().add(
					ReferenceHelper.getNewStringReference(connection.getConnectionString()));

			getResolvedImport(Arrays.asList("java","sql"), "SQLException", resource);
			createCatchBlock(tryBlock, "printStackTrace", "SQLException", false);
		}

	}

	protected void convertQuery(){

		Collection<Query> queries =
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getQuery());

		for(Query query : queries){

			//TODO
			IdentifierReference identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
			identifierReference.setTarget(this.connection);
			TryBlock tryBlock = null;

			if(query.eContainer() instanceof LocalVariable){
				LocalVariable localVariable = (LocalVariable)query.eContainer();
				LocalVariableStatement localVariableStatement =
					(LocalVariableStatement)localVariable.eContainer();

				NullLiteral _null = LiteralsFactory.eINSTANCE.createNullLiteral();
				localVariable.setInitialValue(_null);

				ExpressionStatement expressionStatement =
					StatementsFactory.eINSTANCE.createExpressionStatement();
				AssignmentExpression assignmentExpression =
					ExpressionsFactory.eINSTANCE.createAssignmentExpression();
				expressionStatement.setExpression(assignmentExpression);
				Assignment assignment = OperatorsFactory.eINSTANCE.createAssignment();

				IdentifierReference rs = ReferencesFactory.eINSTANCE.createIdentifierReference();
				rs.setTarget(localVariable);

				assignmentExpression.setAssignmentOperator(assignment);
				assignmentExpression.setChild(rs);
				assignmentExpression.setValue(identifierReference);

				tryBlock =
					StatementsFactory.eINSTANCE.createTryBlock();
				tryBlock.getStatements().add(expressionStatement);
				((ClassMethod)localVariableStatement.eContainer()).getStatements().add(tryBlock);
			}
			if(query.eContainer() instanceof AssignmentExpression){
				AssignmentExpression assignmentExpression =
					(AssignmentExpression)query.eContainer();
				ExpressionStatement expressionStatement =
					(ExpressionStatement)assignmentExpression.eContainer();

				tryBlock =
					StatementsFactory.eINSTANCE.createTryBlock();
				EcoreUtil.replace(expressionStatement,tryBlock);
				tryBlock.getStatements().add(expressionStatement);

				assignmentExpression.setValue(identifierReference);
			}


			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			identifierReference.setNext(methodCall);
			Method createStatement = (Method)ResolverHelper.getResolvedElement("createStatement", methodCall);
			methodCall.setTarget(createStatement);

			MethodCall methodCall2 = ReferencesFactory.eINSTANCE.createMethodCall();
			methodCall.setNext(methodCall2);

			getResolvedImport(Arrays.asList("java","sql"), "Statement", resource);
			ReferenceableElement tempReferenceableElement =
				ResolverHelper.getResolvedElement("Statement", identifierReference);
			Method executeQuery = getMethod(
					(ConcreteClassifier)tempReferenceableElement, "executeQuery");
			methodCall2.setTarget(executeQuery);

			AdditiveExpression additiveExpression =
				ExpressionsFactory.eINSTANCE.createAdditiveExpression();
			methodCall2.getArguments().add(additiveExpression);

			List<Reference> references =
				ConvertSelectExpressionHelper.convertSelectExpression(query.getSqlString());
			additiveExpression.getChildren().addAll(references);
			for(int i=0;i<references.size()-1;i++){
				additiveExpression.getAdditiveOperators().add(
						OperatorsFactory.eINSTANCE.createAddition());
			}

			additiveExpression.getChildren().addAll(references);

			getResolvedImport(Arrays.asList("java","sql"), "SQLException", resource);
			createCatchBlock(tryBlock, "printStackTrace", "SQLException", false);

		}
	}

	protected void convertSqlExpression(){

		Collection<SqlExpression> sqlExpressions =
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getSqlExpression());

		for(SqlExpression sqlExpression : sqlExpressions){

			LocalVariableStatement localVariableStatement =
				StatementsFactory.eINSTANCE.createLocalVariableStatement();
			EcoreUtil.replace(sqlExpression,localVariableStatement);

			LocalVariable localVariable =
				VariablesFactory.eINSTANCE.createLocalVariable();
			localVariable.setName(sqlExpression.getName());
			localVariableStatement.setVariable(localVariable);

			NamespaceClassifierReference namespaceReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference();
			localVariable.setTypeReference(namespaceReference);

			ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
			namespaceReference.getClassifierReferences().add(reference);

			ConcreteClassifier string =
				ResolverHelper.getResolvedClassifier("String", reference);
			if(string == null)
				continue;
			reference.setTarget(string);

			AdditiveExpression additiveExpression =
				ExpressionsFactory.eINSTANCE.createAdditiveExpression();
			localVariable.setInitialValue(additiveExpression);

			List<Reference> references =
				ConvertSelectExpressionHelper.convertExpression(sqlExpression.getExpression());
			additiveExpression.getChildren().addAll(references);
			for(int i=0;i<references.size()-1;i++){
				additiveExpression.getAdditiveOperators().add(
						OperatorsFactory.eINSTANCE.createAddition());
			}

			additiveExpression.getChildren().addAll(references);

		}
	}

	private void createCatchBlock(
			TryBlock tryBlock,
			String methodName,
			String exceptionName,
			boolean isOnlyReturn){

		CatchBlock catchBlock =
			StatementsFactory.eINSTANCE.createCatchBlock();
		tryBlock.getCatcheBlocks().add(catchBlock);

		OrdinaryParameter ordinaryParameter =
			ParametersFactory.eINSTANCE.createOrdinaryParameter();
		catchBlock.setParameter(ordinaryParameter);
		ordinaryParameter.setName("e");

		NamespaceClassifierReference catchNamespaceReference =
			TypesFactory.eINSTANCE.createNamespaceClassifierReference();
		ordinaryParameter.setTypeReference(catchNamespaceReference);

		ClassifierReference catchReference = TypesFactory.eINSTANCE.createClassifierReference();
		catchNamespaceReference.getClassifierReferences().add(catchReference);

		ConcreteClassifier exception =
			ResolverHelper.getResolvedClassifier(exceptionName, catchReference);
		catchReference.setTarget(exception);

		if(isOnlyReturn){
			Return _return = StatementsFactory.eINSTANCE.createReturn();
			catchBlock.getStatements().add(_return);
		}
		else{

			ExpressionStatement expressionStatement =
				StatementsFactory.eINSTANCE.createExpressionStatement();
			catchBlock.getStatements().add(expressionStatement);

			IdentifierReference catchIdentifierReference =
				ReferencesFactory.eINSTANCE.createIdentifierReference();
			expressionStatement.setExpression(catchIdentifierReference);
			catchIdentifierReference.setTarget(ordinaryParameter);

			MethodCall catchMethodCall =
				ReferencesFactory.eINSTANCE.createMethodCall();
			catchIdentifierReference.setNext(catchMethodCall);
			Method method = getMethod(exception, methodName);
			catchMethodCall.setTarget(method);
		}
	}

	public void terminate() {
		// do nothing
	}
}
