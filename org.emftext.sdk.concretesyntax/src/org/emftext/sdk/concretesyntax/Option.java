/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Option#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Option#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption()
 * @model annotation="OCL This\040generation\040option\040is\040not\040allowed.='if(self.name=\'tokenspace\' or \r\n\tself.name = \'autofixSimpleLeftrecursion\' or \r\n\tself.name = \'forceEOF\' or \r\n\tself.name = \'standardTextTokenName\' or\r\n\tself.name = \'generateTestAction\' or\r\n\tself.name = \'generateGenModel\' or\r\n\tself.name = \'generatePrinterStubOnly\' or\r\n\r\n\tself.name = \'overridePluginXML\' or\r\n\tself.name = \'overrideManifest\' or\r\n\tself.name = \'overrideAntlrSpecification\' or\r\n\tself.name = \'overrideTokenResolvers\' or\r\n\tself.name = \'overrideReferenceResolvers\' or\r\n\tself.name = \'overrideTreeAnalyser\' or\r\n\tself.name = \'overrideTokenResolverFactory\' or\r\n\tself.name = \'overridePrinter\' or\r\n\tself.name = \'useDefaultTokens\')\r\n\tthen true\r\nelse\r\n\tfalse\r\nendif'"
 *        annotation="OCL Only\040positive\040integers\040are\040allowed.='if (self.name=\'tokenspace\') \r\n\tthen if( self.value.toInteger()>=0)\r\n\t\tthen true\r\n\t\telse false\r\n\tendif\t\r\n\telse true\r\nendif'"
 *        annotation="OCL Please\040provide\040a\040String\040with\040at\040least\040two\040letters.='if (self.name=\'standardTextTokenName\') \r\n\tthen if( self.value.size()<2)\r\n\t\tthen false\r\n\t\telse \r\n\t\t\ttrue\r\n\t\tendif\r\n\telse true\r\nendif'"
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Option#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Option#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Option
