package org.polarsys.chess.contracts.verificationService.test.runtime.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	//TestApplyRecursively.class, 
	//TestApplyCHESSStereotype.class, 
	//TestCreateViews.class,
	//TestModelChecking.class
	TestCheckContractRefinementOfCHESSComponent.class
	})
public class AllTests {
}
