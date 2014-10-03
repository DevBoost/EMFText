/**
 */
package org.emftext.test.cct5;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.test.cct5.Cct5Package
 * @generated
 */
public interface Cct5Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Cct5Factory eINSTANCE = org.emftext.test.cct5.impl.Cct5FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Farmer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Farmer</em>'.
	 * @generated
	 */
	Farmer createFarmer();

	/**
	 * Returns a new object of class '<em>Diet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diet</em>'.
	 * @generated
	 */
	Diet createDiet();

	/**
	 * Returns a new object of class '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animal</em>'.
	 * @generated
	 */
	Animal createAnimal();

	/**
	 * Returns a new object of class '<em>Farm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Farm</em>'.
	 * @generated
	 */
	Farm createFarm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Cct5Package getCct5Package();

} //Cct5Factory
