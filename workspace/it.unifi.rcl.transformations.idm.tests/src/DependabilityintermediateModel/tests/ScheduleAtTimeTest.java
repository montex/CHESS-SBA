/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.tests;

import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.ScheduleAtTime;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Schedule At Time</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScheduleAtTimeTest extends SchedulingEventTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScheduleAtTimeTest.class);
	}

	/**
	 * Constructs a new Schedule At Time test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleAtTimeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Schedule At Time test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ScheduleAtTime getFixture() {
		return (ScheduleAtTime)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DependabilityintermediateModelFactory.eINSTANCE.createScheduleAtTime());
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

} //ScheduleAtTimeTest
