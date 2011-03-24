/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.tests;

import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.FailureMode;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Failure Mode</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FailureModeTest extends ThreatTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FailureModeTest.class);
	}

	/**
	 * Constructs a new Failure Mode test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureModeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Failure Mode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FailureMode getFixture() {
		return (FailureMode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DependabilityintermediateModelFactory.eINSTANCE.createFailureMode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //FailureModeTest
