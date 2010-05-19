package org.emftext.sdk.codegen.newproject.generators;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * Generates a simple concrete syntax for the meta model generated before.
 */
public class SyntaxGenerator extends ModelGenerator {

	private static final ConcretesyntaxFactory CS_FACTORY = ConcretesyntaxFactory.eINSTANCE;

	public SyntaxGenerator() {
		super();
	}

	@Override
	public EObject generateModel() {
		NewProjectParameters parameters = getContext().getParameters();

		ConcreteSyntax syntax = CS_FACTORY.createConcreteSyntax();
		syntax.setName(parameters.getSyntaxName());
		syntax.setPackage(getContext().getGenPackage());
		
		syntax.getRules().add(getShapeSetRule());
		syntax.getRules().add(getCircleRule());
		syntax.getRules().add(getRectangleRule());
		syntax.getStartSymbols().add(getContext().getGenPackage().getGenClasses().get(3));
		return syntax;
	}
	
	private Rule getShapeSetRule() {
		Rule rule = CS_FACTORY.createRule();
		GenClass shapeSetClass = getContext().getGenPackage().getGenClasses().get(3);
		rule.setMetaclass(shapeSetClass);
		CsString keyword = CS_FACTORY.createCsString();
		keyword.setValue("shapes");

		Containment shapesContainment = CS_FACTORY.createContainment();
		shapesContainment.setFeature(shapeSetClass.getGenFeatures().get(0));
		shapesContainment.setCardinality(CS_FACTORY.createPLUS());

		Sequence sequence = CS_FACTORY.createSequence();
		sequence.getChildren().add(keyword);
		sequence.getChildren().add(shapesContainment);

		rule.getChildren().add(sequence);
		return rule;
	}

	private Rule getRectangleRule() {
		Rule rule = CS_FACTORY.createRule();
		rule.setMetaclass(getContext().getGenPackage().getGenClasses().get(1));
		CsString keyword = CS_FACTORY.createCsString();
		keyword.setValue("rect");
		rule.getChildren().add(keyword);
		return rule;
	}

	private Rule getCircleRule() {
		Rule rule = CS_FACTORY.createRule();
		rule.setMetaclass(getContext().getGenPackage().getGenClasses().get(2));
		CsString keyword = CS_FACTORY.createCsString();
		keyword.setValue("circ");
		rule.getChildren().add(keyword);
		return rule;
	}

	@Override
	public String getModelPath() {
		return getFileInMetaModelFolder(getContext().getParameters().getSyntaxFile());
	}
}
