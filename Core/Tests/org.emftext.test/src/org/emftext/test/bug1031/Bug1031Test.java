package org.emftext.test.bug1031;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;
import org.junit.Before;
import org.junit.Test;

public class Bug1031Test {

	private final String packageDirectory = File.separator + "src" + File.separator + Bug1031Test.class.getPackage().getName().replace(".", File.separator) + File.separator;

	@Before
	public void setUp() {
		new CsMetaInformation().registerResourceFactory();
		ConcreteSyntaxTestHelper.registerResourceFactories();
		ConcreteSyntaxTestHelper.registerEcoreGenModel();
	}

	@Test
	public void testNoStackoverflow() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + packageDirectory + "left.cs";
		CsResource resource = CsResourceUtil.getResource(new File(path).getAbsoluteFile());
		assertNotNull(resource);
		CsResourceUtil.resolveAll(resource);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error: " + error);
		}
		assertFalse("Resource must not contain errors.", CsResourceUtil.containsErrors(resource));
		
		ExpectationComputer expectationComputer = new ExpectationComputer();
		ConcreteSyntax syntax = (ConcreteSyntax) resource.getContents().get(0);
		Rule rule1 = syntax.getRules().get(0);
		expectationComputer.computeFirstSet(syntax, rule1);
	}
}
