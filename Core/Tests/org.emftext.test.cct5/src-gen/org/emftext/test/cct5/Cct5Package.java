/**
 */
package org.emftext.test.cct5;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.test.cct5.Cct5Factory
 * @model kind="package"
 * @generated
 */
public interface Cct5Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cct5";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/cct5";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cct5";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Cct5Package eINSTANCE = org.emftext.test.cct5.impl.Cct5PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.impl.NamedElementImpl
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.impl.FarmerImpl <em>Farmer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.impl.FarmerImpl
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getFarmer()
	 * @generated
	 */
	int FARMER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARMER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Diet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARMER__DIET = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Farmer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARMER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.impl.DietImpl <em>Diet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.impl.DietImpl
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getDiet()
	 * @generated
	 */
	int DIET = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIET__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Favorite Dish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIET__FAVORITE_DISH = 1;

	/**
	 * The number of structural features of the '<em>Diet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.impl.AnimalImpl <em>Animal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.impl.AnimalImpl
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getAnimal()
	 * @generated
	 */
	int ANIMAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Feeding Instruction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__FEEDING_INSTRUCTION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.impl.FarmImpl <em>Farm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.impl.FarmImpl
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getFarm()
	 * @generated
	 */
	int FARM = 4;

	/**
	 * The feature id for the '<em><b>Animal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__ANIMAL = 0;

	/**
	 * The feature id for the '<em><b>Farmer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__FARMER = 1;

	/**
	 * The number of structural features of the '<em>Farm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.test.cct5.DietType <em>Diet Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.test.cct5.DietType
	 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getDietType()
	 * @generated
	 */
	int DIET_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link org.emftext.test.cct5.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.emftext.test.cct5.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.test.cct5.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.test.cct5.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.test.cct5.Farmer <em>Farmer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Farmer</em>'.
	 * @see org.emftext.test.cct5.Farmer
	 * @generated
	 */
	EClass getFarmer();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.test.cct5.Farmer#getDiet <em>Diet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diet</em>'.
	 * @see org.emftext.test.cct5.Farmer#getDiet()
	 * @see #getFarmer()
	 * @generated
	 */
	EReference getFarmer_Diet();

	/**
	 * Returns the meta object for class '{@link org.emftext.test.cct5.Diet <em>Diet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diet</em>'.
	 * @see org.emftext.test.cct5.Diet
	 * @generated
	 */
	EClass getDiet();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.test.cct5.Diet#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.emftext.test.cct5.Diet#getType()
	 * @see #getDiet()
	 * @generated
	 */
	EAttribute getDiet_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.test.cct5.Diet#getFavoriteDish <em>Favorite Dish</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favorite Dish</em>'.
	 * @see org.emftext.test.cct5.Diet#getFavoriteDish()
	 * @see #getDiet()
	 * @generated
	 */
	EAttribute getDiet_FavoriteDish();

	/**
	 * Returns the meta object for class '{@link org.emftext.test.cct5.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal</em>'.
	 * @see org.emftext.test.cct5.Animal
	 * @generated
	 */
	EClass getAnimal();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.test.cct5.Animal#getFeedingInstruction <em>Feeding Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feeding Instruction</em>'.
	 * @see org.emftext.test.cct5.Animal#getFeedingInstruction()
	 * @see #getAnimal()
	 * @generated
	 */
	EReference getAnimal_FeedingInstruction();

	/**
	 * Returns the meta object for class '{@link org.emftext.test.cct5.Farm <em>Farm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Farm</em>'.
	 * @see org.emftext.test.cct5.Farm
	 * @generated
	 */
	EClass getFarm();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.test.cct5.Farm#getAnimal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animal</em>'.
	 * @see org.emftext.test.cct5.Farm#getAnimal()
	 * @see #getFarm()
	 * @generated
	 */
	EReference getFarm_Animal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.test.cct5.Farm#getFarmer <em>Farmer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Farmer</em>'.
	 * @see org.emftext.test.cct5.Farm#getFarmer()
	 * @see #getFarm()
	 * @generated
	 */
	EReference getFarm_Farmer();

	/**
	 * Returns the meta object for enum '{@link org.emftext.test.cct5.DietType <em>Diet Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Diet Type</em>'.
	 * @see org.emftext.test.cct5.DietType
	 * @generated
	 */
	EEnum getDietType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Cct5Factory getCct5Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.impl.NamedElementImpl
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.impl.FarmerImpl <em>Farmer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.impl.FarmerImpl
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getFarmer()
		 * @generated
		 */
		EClass FARMER = eINSTANCE.getFarmer();

		/**
		 * The meta object literal for the '<em><b>Diet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARMER__DIET = eINSTANCE.getFarmer_Diet();

		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.impl.DietImpl <em>Diet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.impl.DietImpl
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getDiet()
		 * @generated
		 */
		EClass DIET = eINSTANCE.getDiet();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIET__TYPE = eINSTANCE.getDiet_Type();

		/**
		 * The meta object literal for the '<em><b>Favorite Dish</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIET__FAVORITE_DISH = eINSTANCE.getDiet_FavoriteDish();

		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.impl.AnimalImpl <em>Animal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.impl.AnimalImpl
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getAnimal()
		 * @generated
		 */
		EClass ANIMAL = eINSTANCE.getAnimal();

		/**
		 * The meta object literal for the '<em><b>Feeding Instruction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL__FEEDING_INSTRUCTION = eINSTANCE.getAnimal_FeedingInstruction();

		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.impl.FarmImpl <em>Farm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.impl.FarmImpl
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getFarm()
		 * @generated
		 */
		EClass FARM = eINSTANCE.getFarm();

		/**
		 * The meta object literal for the '<em><b>Animal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARM__ANIMAL = eINSTANCE.getFarm_Animal();

		/**
		 * The meta object literal for the '<em><b>Farmer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARM__FARMER = eINSTANCE.getFarm_Farmer();

		/**
		 * The meta object literal for the '{@link org.emftext.test.cct5.DietType <em>Diet Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.test.cct5.DietType
		 * @see org.emftext.test.cct5.impl.Cct5PackageImpl#getDietType()
		 * @generated
		 */
		EEnum DIET_TYPE = eINSTANCE.getDietType();

	}

} //Cct5Package
