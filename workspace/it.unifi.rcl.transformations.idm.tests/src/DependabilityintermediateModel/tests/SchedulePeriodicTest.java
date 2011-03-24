/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.tests;

import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.SchedulePeriodic;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Schedule Periodic</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulePeriodicTest extends SchedulingEventTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SchedulePeriodicTest.class);
	}

	/**
	 * Constructs a new Schedule Periodic test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePeriodicTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Schedule Periodic test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SchedulePeriodic getFixture() {
		return (SchedulePeriodic)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DependabilityintermediateModelFactory.eINSTANCE.createSchedulePeriodic());
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

} //SchedulePeriodicTest
