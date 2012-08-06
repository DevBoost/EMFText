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
package org.emftext.language.java.sqljava.resource.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.AdditiveExpressionChild;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.operators.Addition;
import org.emftext.language.java.operators.AdditiveOperator;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.resource.java.util.JavaEObjectUtil;
import org.emftext.language.java.sqljava.EmbeddedExpression;
import org.emftext.language.java.sqljava.resource.SqlJavaTransformPostProcessor;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesPackage;
import org.emftext.language.sql.select.SelectExpression;
import org.emftext.language.sql.select.column.ColumnOperation;
import org.emftext.language.sql.select.column.ColumnOperationAvg;
import org.emftext.language.sql.select.column.ColumnOperationCount;
import org.emftext.language.sql.select.column.ColumnOperationEvery;
import org.emftext.language.sql.select.column.ColumnOperationMax;
import org.emftext.language.sql.select.column.ColumnOperationMin;
import org.emftext.language.sql.select.column.ColumnOperationSome;
import org.emftext.language.sql.select.column.ColumnOperationSum;
import org.emftext.language.sql.select.column.SingleColumnExpression;
import org.emftext.language.sql.select.condition.BetweenCondition;
import org.emftext.language.sql.select.condition.Condition;
import org.emftext.language.sql.select.condition.ConditionOperation;
import org.emftext.language.sql.select.condition.ConditionOperationEqual;
import org.emftext.language.sql.select.condition.ConditionOperationGreatEqual;
import org.emftext.language.sql.select.condition.ConditionOperationGreater;
import org.emftext.language.sql.select.condition.ConditionOperationLessEqual;
import org.emftext.language.sql.select.condition.ConditionOperationLesser;
import org.emftext.language.sql.select.condition.ConditionOperationUnEqual;
import org.emftext.language.sql.select.condition.ConditionOperationUnEqual2;
import org.emftext.language.sql.select.condition.ExistsCondition;
import org.emftext.language.sql.select.condition.InCondition;
import org.emftext.language.sql.select.condition.IsNullCondition;
import org.emftext.language.sql.select.condition.LikeCondition;
import org.emftext.language.sql.select.condition.OperationCondition;
import org.emftext.language.sql.select.condition.SimpleCondition;
import org.emftext.language.sql.select.expression.Expression;
import org.emftext.language.sql.select.expression.ExpressionOperation;
import org.emftext.language.sql.select.expression.ExpressionOperationAnd;
import org.emftext.language.sql.select.expression.ExpressionOperationNot;
import org.emftext.language.sql.select.expression.ExpressionOperationOr;
import org.emftext.language.sql.select.expression.SimpleExpression;
import org.emftext.language.sql.select.from.JoinOperation;
import org.emftext.language.sql.select.from.JoinOperationInner;
import org.emftext.language.sql.select.from.JoinOperationLeft;
import org.emftext.language.sql.select.from.JoinOperationOuter;
import org.emftext.language.sql.select.from.JoinOperationRight;
import org.emftext.language.sql.select.from.JoinTableExpression;
import org.emftext.language.sql.select.from.TableExpression;
import org.emftext.language.sql.select.from.TableListExpression;
import org.emftext.language.sql.select.limit.LimitExpression;
import org.emftext.language.sql.select.orderBy.OrderByAliasExpression;
import org.emftext.language.sql.select.orderBy.OrderByColumnExpression;
import org.emftext.language.sql.select.orderBy.OrderByParameter;
import org.emftext.language.sql.select.orderBy.OrderByParameterAsc;
import org.emftext.language.sql.select.orderBy.OrderByParameterDesc;
import org.emftext.language.sql.select.orderBy.OrderBySelectExpression;
import org.emftext.language.sql.select.parameter.SelectParameter;
import org.emftext.language.sql.select.parameter.SelectParameterAll;
import org.emftext.language.sql.select.parameter.SelectParameterDistinct;
import org.emftext.language.sql.select.set.SetExpression;
import org.emftext.language.sql.select.set.SetOperation;
import org.emftext.language.sql.select.set.SetOperationExcept;
import org.emftext.language.sql.select.set.SetOperationIntersect;
import org.emftext.language.sql.select.set.SetOperationMinus;
import org.emftext.language.sql.select.set.SetOperationUnion;
import org.emftext.language.sql.select.term.BooleanTerm;
import org.emftext.language.sql.select.term.BooleanTermFalse;
import org.emftext.language.sql.select.term.BooleanTermTrue;
import org.emftext.language.sql.select.term.ColumnTerm;
import org.emftext.language.sql.select.term.CountStarTerm;
import org.emftext.language.sql.select.term.NullTerm;
import org.emftext.language.sql.select.term.SimpleTerm;
import org.emftext.language.sql.select.term.SimpleTermChar;
import org.emftext.language.sql.select.term.SimpleTermString;
import org.emftext.language.sql.select.term.StarTerm;
import org.emftext.language.sql.select.term.Term;
import org.emftext.language.sql.select.value.ConditionValue;
import org.emftext.language.sql.select.value.FunctionValue;
import org.emftext.language.sql.select.value.SimpleValue;
import org.emftext.language.sql.select.value.Value;
import org.emftext.language.sql.select.value.ValueFrontOperationMinus;
import org.emftext.language.sql.select.value.ValueFrontOperationPlus;
import org.emftext.language.sql.select.value.ValueOperation;
import org.emftext.language.sql.select.value.ValueOperationDivide;
import org.emftext.language.sql.select.value.ValueOperationMultiply;
import org.emftext.language.sql.select.value.ValueOperationParallel;

public class ConvertSelectExpressionHelper {

	public static Reference convertSelectParameter(SelectParameter selectParameter){
		if(selectParameter instanceof SelectParameterAll){
			return ReferenceHelper.getNewStringReference("ALL");
		}
		if(selectParameter instanceof SelectParameterDistinct){
			return ReferenceHelper.getNewStringReference("DISTINCT");
		}
		return null;
	}
	
	public static List<Reference> convertSelectExpression(SelectExpression selectExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		
		
		references.add(ReferenceHelper.getNewStringReference("SELECT"));
		
		// parameter
		if(selectExpression.getParameter() != null)
			references.add(convertSelectParameter(selectExpression.getParameter()));
		
		// columns
		for(SingleColumnExpression singleColumnExpression : selectExpression.getColumns().getColumnExpressions()){
			references.addAll(convertColumnExpression(singleColumnExpression));
			references.add(ReferenceHelper.getNewStringReference(","));
		}
		references.remove(references.size()-1); // delete last ','
		
		references.add(ReferenceHelper.getNewStringReference("FROM"));
		
		// from
		for(TableListExpression tableListExpression : selectExpression.getFrom().getTables()){
			references.addAll(convertTableListExpression(tableListExpression));
			references.add(ReferenceHelper.getNewStringReference(","));
		}
		references.remove(references.size()-1); // delete last ','
		
		// where
		if(selectExpression.getWhere() != null){
			references.add(ReferenceHelper.getNewStringReference("WHERE"));
			references.addAll(convertExpression(selectExpression.getWhere().getExpression()));
		}
		// group by
		if(selectExpression.getGroupBy() != null){
			references.add(ReferenceHelper.getNewStringReference("GROUP BY"));
			for(Expression expression : selectExpression.getGroupBy().getExpression()){
				references.addAll(convertExpression(expression));
				references.add(ReferenceHelper.getNewStringReference(","));
			}
			references.remove(references.size()-1); // delete last ','
		}

		// having
		if(selectExpression.getHaving() != null){
			references.add(ReferenceHelper.getNewStringReference("HAVING"));
			references.addAll(convertExpression(selectExpression.getHaving().getExpression()));
		}
		
		// set
		if(selectExpression.getSet() != null){
			references.addAll(convertSetExpression(selectExpression.getSet()));
		}

		// order by
		if(selectExpression.getOrderBy() != null){
			references.add(ReferenceHelper.getNewStringReference("ORDER BY"));
			references.addAll(convertOrderByExpression(selectExpression.getOrderBy().getParameter()));
		}
		
		// limit
		if(selectExpression.getLimit() != null){
			references.add(ReferenceHelper.getNewStringReference("LINIT"));
			references.addAll(convertLimitExpression(selectExpression.getLimit()));
		}

		return references;
	}

	public static List<Reference> convertColumnExpression(SingleColumnExpression singleColumnExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		if(singleColumnExpression.getOperation() != null){
			references.add(convertColumnOperation(singleColumnExpression.getOperation()));
			
			references.add(ReferenceHelper.getNewStringReference("("));
			
			if(singleColumnExpression.getParameter() != null)
				references.add(convertSelectParameter(singleColumnExpression.getParameter()));
				
			if(singleColumnExpression.getExpression() != null)
				references.addAll(convertExpression(singleColumnExpression.getExpression()));
			
			references.add(ReferenceHelper.getNewStringReference(")"));
		}
		else{
			if(singleColumnExpression.getExpression() != null)
				references.addAll(convertExpression(singleColumnExpression.getExpression()));
		}
		
		if(singleColumnExpression.getAlias() != null){
			references.add(ReferenceHelper.getNewStringReference("AS"));
			references.add(ReferenceHelper.getNewStringReference(singleColumnExpression.getAlias()));
		}
		
		return references;
	}
	
	public static Reference convertColumnOperation(ColumnOperation columnOperation){
		
		if(columnOperation instanceof ColumnOperationCount){
			return ReferenceHelper.getNewStringReference("COUNT");
		}
		if(columnOperation instanceof ColumnOperationMin){
			return ReferenceHelper.getNewStringReference("MIN");
		}
		if(columnOperation instanceof ColumnOperationMax){
			return ReferenceHelper.getNewStringReference("MAX");
		}
		if(columnOperation instanceof ColumnOperationSum){
			return ReferenceHelper.getNewStringReference("SUM");
		}
		if(columnOperation instanceof ColumnOperationAvg){
			return ReferenceHelper.getNewStringReference("AVG");
		}
		if(columnOperation instanceof ColumnOperationEvery){
			return ReferenceHelper.getNewStringReference("EVERY");
		}
		if(columnOperation instanceof ColumnOperationSome){
			return ReferenceHelper.getNewStringReference("SOME");
		}
		return null;
	}
	
	public static List<Reference> convertTableListExpression(TableListExpression tableListExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		references.addAll(convertTableExpression(tableListExpression.getTable()));
		
		if(tableListExpression.getJoinTable() != null){
			references.addAll(convertJoinTableExpression(tableListExpression.getJoinTable()));
		}
		
		return references;
	}
	
	public static List<Reference> convertTableExpression(TableExpression tableExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		if(tableExpression.getSelectExpression() != null){
			references.addAll(convertSelectExpression(tableExpression.getSelectExpression()));
			if(tableExpression.getLabel() != null){
				references.add(ReferenceHelper.getNewStringReference("AS"));
				references.add(ReferenceHelper.getNewStringReference(tableExpression.getLabel()));
			}
		}
		else{
			references.add(ReferenceHelper.getNewStringReference(tableExpression.getTable().getName()));
		}
		return references;
	}
	
	public static List<Reference> convertJoinTableExpression(JoinTableExpression joinTableExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		references.add(convertJoinOperation(joinTableExpression.getJoin()));
		references.addAll(convertTableExpression(joinTableExpression.getJoinTable()));
		references.add(ReferenceHelper.getNewStringReference("ON"));
		references.addAll(convertExpression(joinTableExpression.getExpression()));
		return references;
	}
	
	public static Reference convertJoinOperation(JoinOperation joinOperation){
		
		if(joinOperation instanceof JoinOperationInner){
			return ReferenceHelper.getNewStringReference("INNER JOIN");
		}
		if(joinOperation instanceof JoinOperationLeft){
			return ReferenceHelper.getNewStringReference("LEFT OUTER JOIN");
		}
		if(joinOperation instanceof JoinOperationRight){
			return ReferenceHelper.getNewStringReference("RIGHT OUTER JOIN");
		}
		if(joinOperation instanceof JoinOperationOuter){
			return ReferenceHelper.getNewStringReference("OUTER JOIN");
		}
		return null;
	}
	
	public static List<Reference> convertSetExpression(SetExpression setExpression){

		List<Reference> references = new ArrayList<Reference>();
		references.addAll(convertSetOperation(setExpression.getSetOperation()));
		references.addAll(convertSelectExpression(setExpression.getSelectExpression()));
		return references;
	}
	
	public static List<Reference> convertSetOperation(SetOperation setOperation){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(setOperation instanceof SetOperationUnion){
			references.add(ReferenceHelper.getNewStringReference("UNION"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationMinus){
			references.add(ReferenceHelper.getNewStringReference("MINUS"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationExcept){
			references.add(ReferenceHelper.getNewStringReference("EXCEPT"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationIntersect){
			references.add(ReferenceHelper.getNewStringReference("INTERSECT"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		return null;
	}
	
	public static List<Reference> convertOrderByExpression(OrderByParameter orderByParameter){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(orderByParameter instanceof OrderByColumnExpression){
			references.add(ReferenceHelper.getNewStringReference(
					((OrderByColumnExpression)orderByParameter).getColumnReference().getName()));
			references.add(convertOrderByParameter(((OrderByColumnExpression) orderByParameter).getParameter()));
		}
		if(orderByParameter instanceof OrderByAliasExpression){
			references.add(ReferenceHelper.getNewStringReference(
					((OrderByAliasExpression)orderByParameter).getAlias()));
			references.add(convertOrderByParameter(((OrderByAliasExpression) orderByParameter).getParameter()));
		}
		if(orderByParameter instanceof OrderBySelectExpression){
			references.addAll(convertSelectExpression(
					((OrderBySelectExpression)orderByParameter).getSelectExpression()));
			references.add(convertOrderByParameter(((OrderBySelectExpression) orderByParameter).getParameter()));
		}
		return references;
	}
	
	public static Reference convertOrderByParameter(OrderByParameter orderByParameter){
		
		if(orderByParameter instanceof OrderByParameterAsc){
			return ReferenceHelper.getNewStringReference("ASC");
		}
		if(orderByParameter instanceof OrderByParameterDesc){
			return ReferenceHelper.getNewStringReference("DESC");
		}
		return null;
	}
	
	public static List<Reference> convertLimitExpression(LimitExpression limitExpression) {
		
		List<Reference> references = new ArrayList<Reference>();
		references.add(ReferenceHelper.getNewStringReference(limitExpression.getLimit()));
		
		if(limitExpression.getOffset() != null){
			references.add(ReferenceHelper.getNewStringReference("OFFSET"));
			references.add(ReferenceHelper.getNewStringReference(limitExpression.getOffset()));
		}
		return references;
	}
	
	public static List<Reference> convertExpression(Expression expression){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(((SimpleExpression)expression).getNotOperation() != null){
			references.add(convertExpressionOperation(((SimpleExpression)expression).getNotOperation()));
		}
		
		if(((SimpleExpression)expression).getOperations() != null){
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(0)));
			references.add(convertExpressionOperation(((SimpleExpression)expression).getOperations()));
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(1)));
		}
		else{
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(0)));
		}
		
		return references;
	}
	
	public static Reference convertExpressionOperation(ExpressionOperation expressionOperation){
		
		if(expressionOperation instanceof ExpressionOperationNot){
			return ReferenceHelper.getNewStringReference("NOT");
		}
		if(expressionOperation instanceof ExpressionOperationAnd){
			return ReferenceHelper.getNewStringReference("AND");
		}
		if(expressionOperation instanceof ExpressionOperationOr){
			return ReferenceHelper.getNewStringReference("OR");
		}
		return null;
	}
	
	public static List<Reference> convertCondition(Condition condition){
	
		List<Reference> references = new ArrayList<Reference>();
		
		if(condition instanceof OperationCondition){
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			references.add(convertConditionOperation(((OperationCondition)condition).getOperation()));
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(1)));
			return references;
		}
		if(condition instanceof IsNullCondition){
			references.addAll(convertValue(((IsNullCondition)condition).getValues().get(0)));
			references.add(ReferenceHelper.getNewStringReference("IS"));
			if(((IsNullCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((IsNullCondition)condition).getOperationNot()));
			references.add(ReferenceHelper.getNewStringReference("NULL"));
			return references;
		}
		if(condition instanceof ExistsCondition){
			references.add(ReferenceHelper.getNewStringReference("EXISTS"));
			references.add(ReferenceHelper.getNewStringReference("("));
			references.addAll(convertSelectExpression((((ExistsCondition)condition).getSelectExpression())));
			references.add(ReferenceHelper.getNewStringReference(")"));
			return references;
		}
		if(condition instanceof BetweenCondition){
			references.addAll(convertValue(((BetweenCondition)condition).getValues().get(0)));
			references.add(ReferenceHelper.getNewStringReference("BETWEEN"));
			references.addAll(convertValue(((BetweenCondition)condition).getValues().get(1)));
			references.add(ReferenceHelper.getNewStringReference("AND"));
			references.addAll(convertValue(((BetweenCondition)condition).getValues().get(2)));
			return references;
		}
		if(condition instanceof InCondition){
			
			references.addAll(convertValue(((InCondition)condition).getValues().get(0)));
			if(((InCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((InCondition)condition).getOperationNot()));
			references.add(ReferenceHelper.getNewStringReference("IN"));
			
			if(((InCondition)condition).getSelectExpression() != null){
				references.addAll(convertSelectExpression(((InCondition)condition).getSelectExpression()));
			}
			else{
				boolean wasFirst = false;
				for(Value value : ((OperationCondition)condition).getValues()){
					if(wasFirst){
						references.addAll(convertValue(value));
						wasFirst = true;
					}
				}
			}
			return references;
		}
		if(condition instanceof LikeCondition){
			references.addAll(convertValue(((LikeCondition)condition).getValues().get(0)));
			if(((LikeCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((LikeCondition)condition).getOperationNot()));
			references.add(ReferenceHelper.getNewStringReference("LIKE"));
			references.addAll(convertValue(((LikeCondition)condition).getValues().get(1)));
			return references;
		}
		if(condition instanceof SimpleCondition){
			for(Value value : ((SimpleCondition)condition).getValues()){
				references.addAll(convertValue(value));
			}
		}
//		if(condition instanceof SqlExpression){
//			
//		}
		return references;
		
	}
	
	public static Reference convertConditionOperation(ConditionOperation conditionOperation){
		if(conditionOperation instanceof ConditionOperationEqual){
			return ReferenceHelper.getNewStringReference("=");
		}
		if(conditionOperation instanceof ConditionOperationLesser){
			return ReferenceHelper.getNewStringReference("<");
		}
		if(conditionOperation instanceof ConditionOperationLessEqual){
			return ReferenceHelper.getNewStringReference("<=");
		}
		if(conditionOperation instanceof ConditionOperationGreater){
			return ReferenceHelper.getNewStringReference(">");
		}
		if(conditionOperation instanceof ConditionOperationGreatEqual){
			return ReferenceHelper.getNewStringReference(">=");
		}
		if(conditionOperation instanceof ConditionOperationUnEqual){
			return ReferenceHelper.getNewStringReference("<>");
		}
		if(conditionOperation instanceof ConditionOperationUnEqual2){
			return ReferenceHelper.getNewStringReference("!=");
		}
		return null;
	}
	
	public static List<Reference> convertValue(Value value){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(value instanceof SimpleValue){
			if(((SimpleValue)value).getFrontOperation() != null)
				references.add(convertValueOperation(((SimpleValue)value).getFrontOperation()));
			references.addAll(convertTerm(((SimpleValue)value).getTerms().get(0)));
			if(((SimpleValue)value).getOperations() != null){
				references.add(convertValueOperation(((SimpleValue)value).getOperations()));
				references.addAll(convertTerm(((SimpleValue)value).getTerms().get(1)));
			}
		}
		if(value instanceof ConditionValue){
			references.add(ReferenceHelper.getNewStringReference("("));
			references.addAll(convertCondition(((ConditionValue)value).getCondition()));
			references.add(ReferenceHelper.getNewStringReference(")"));
		}
		if(value instanceof FunctionValue){
			references.add(ReferenceHelper.getNewStringReference(((FunctionValue)value).getFunctionName()));
			references.add(ReferenceHelper.getNewStringReference("("));
			for(Value parameter : ((FunctionValue)value).getParameters()){
				references.addAll(convertValue(parameter));
				references.add(ReferenceHelper.getNewStringReference(","));
			}
			references.remove(references.size()-1); // delete last ','
			references.add(ReferenceHelper.getNewStringReference(")"));
		}
		if(value instanceof EmbeddedExpression){
			org.emftext.language.java.expressions.Expression expression = 
				((EmbeddedExpression)value).getExpression();
			references.addAll(convertJavaExpression(expression));
		}
		
		return references;
		
	}
	
	public static List<Reference> convertJavaExpression(org.emftext.language.java.expressions.Expression expression){
		
		List<Reference> references = new ArrayList<Reference>(); 
	
		if(expression instanceof NestedExpression){
			if(((NestedExpression)expression).getExpression() instanceof AdditiveExpression){
				AdditiveExpression additiveExpression =
					(AdditiveExpression)((NestedExpression)expression).getExpression();
				int i=0;
				for(AdditiveExpressionChild child : additiveExpression.getChildren()){
					if(child instanceof StringReference)
						references.add((StringReference)child);
					if(i<additiveExpression.getAdditiveOperators().size()){
						AdditiveOperator additiveOperator = 
							additiveExpression.getAdditiveOperators().get(i);
						if(additiveOperator instanceof Addition)
							references.add(ReferenceHelper.getNewStringReference("+"));
					}
					i++;
				}
			}
		}
		
		return references;
	}
	
	public static List<Reference> convertTerm(Term term){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(term instanceof BooleanTerm){
			references.add(convertBooleanTerm((BooleanTerm)term));
		}
		if(term instanceof NullTerm){
			references.add(ReferenceHelper.getNewStringReference("NULL"));
		}
		if(term instanceof ColumnTerm){
			references.addAll(convertColumnTerm((ColumnTerm)term));
		}
		if(term instanceof SimpleTerm){
			references.add(convertSimpleTerm((SimpleTerm)term));
		}
		if(term instanceof CountStarTerm){
			references.add(ReferenceHelper.getNewStringReference("COUNT(*)"));
		}
		if(term instanceof StarTerm){
			references.add(ReferenceHelper.getNewStringReference("*"));
		}
		return references;
	}
	
	public static Reference convertBooleanTerm(BooleanTerm booleanTerm){
		
		if(booleanTerm instanceof BooleanTermTrue){
			return ReferenceHelper.getNewStringReference("TRUE");
		}
		if(booleanTerm instanceof BooleanTermFalse){
			return ReferenceHelper.getNewStringReference("FALSE");
		}
		return null;
	}
	
	public static List<Reference> convertColumnTerm(ColumnTerm columnTerm){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(columnTerm.getTableReference() != null){
			references.add(ReferenceHelper.getNewStringReference(columnTerm.getTableReference().getName()));
			references.add(ReferenceHelper.getNewStringReference("."));
		}
		if(columnTerm.getColumn() != null){
			//TODO

			Collection<LocalVariable> localVariables =
				JavaEObjectUtil.getObjectsByType(SqlJavaTransformPostProcessor.getResource().getAllContents(), VariablesPackage.eINSTANCE.getLocalVariable());
			boolean found = false;
			for(LocalVariable localVariable : localVariables){
				if(localVariable.getName().equals(columnTerm.getColumn().getName())){
					found = true;
					references.add(ReferenceHelper.getNewIdentifierReference(localVariable));
					break;
				}
					
			}
			if(!found)
				references.add(ReferenceHelper.getNewStringReference(columnTerm.getColumn().getName())); 
		}
		else{
			references.add(ReferenceHelper.getNewStringReference(columnTerm.getColumnReference().getName()));
		}
		
		return references;
	}
	
	public static Reference convertSimpleTerm(SimpleTerm simpleTerm){
		
		if(simpleTerm instanceof SimpleTermString){
			return ReferenceHelper.getNewStringReference("\""+simpleTerm.getValue()+"\"");
		}
		if(simpleTerm instanceof SimpleTermChar){
			return ReferenceHelper.getNewStringReference("'"+simpleTerm.getValue()+"'");
		}
		else{
			return ReferenceHelper.getNewStringReference(simpleTerm.getValue());
		}
	}
	
	
	public static Reference convertValueOperation(ValueOperation valueOperation){
		if(valueOperation instanceof ValueFrontOperationPlus){
			return ReferenceHelper.getNewStringReference("+");
		}
		if(valueOperation instanceof ValueFrontOperationMinus){
			return ReferenceHelper.getNewStringReference("-");
		}
		if(valueOperation instanceof ValueOperationMultiply){
			return ReferenceHelper.getNewStringReference("*");
		}
		if(valueOperation instanceof ValueOperationDivide){
			return ReferenceHelper.getNewStringReference("/");
		}
		if(valueOperation instanceof ValueOperationParallel){
			return ReferenceHelper.getNewStringReference("||");
		}
		return null;
	}
}
