/**
 */
package monitoringxml.tests;

import org.polarsys.chess.monitoring.monitoringxml.MeasuredValue;
import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlFactory;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Measured Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasuredValueTest extends TestCase {

	/**
	 * The fixture for this Measured Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasuredValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MeasuredValueTest.class);
	}

	/**
	 * Constructs a new Measured Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuredValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Measured Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MeasuredValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Measured Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasuredValue getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MonitoringxmlFactory.eINSTANCE.createMeasuredValue());
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

} //MeasuredValueTest
