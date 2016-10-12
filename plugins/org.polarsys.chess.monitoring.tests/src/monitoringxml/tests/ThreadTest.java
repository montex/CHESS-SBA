/**
 */
package monitoringxml.tests;

import org.polarsys.chess.monitoring.monitoringxml.MonitoringxmlFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreadTest extends MonitoredResourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ThreadTest.class);
	}

	/**
	 * Constructs a new Thread test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Thread test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected org.polarsys.chess.monitoring.monitoringxml.Thread getFixture() {
		return (org.polarsys.chess.monitoring.monitoringxml.Thread)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MonitoringxmlFactory.eINSTANCE.createThread());
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

} //ThreadTest
