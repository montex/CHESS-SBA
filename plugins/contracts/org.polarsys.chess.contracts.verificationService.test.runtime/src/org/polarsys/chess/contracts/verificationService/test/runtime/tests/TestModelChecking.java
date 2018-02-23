package org.polarsys.chess.contracts.verificationService.test.runtime.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.verificationService.ui.services.ExecCommandService;
import org.junit.Assert;

public class TestModelChecking {

	private EntityUtil entityUtil = EntityUtil.getInstance();
	private ExecCommandService execCommandService = ExecCommandService.getInstance();
	
	private static final Logger logger = Logger.getLogger(TestModelChecking.class);
	
	private final String log4jFilePath = 
			//"log4j_noconsole.properties";
			"log4j.properties";
	
	private final String isProgrExecution = "true";
	private final String isDiscrete = "true";
	private final String projectPath="C:\\Users\\Alberto\\git\\CHESS_SystemArchitectureProjects\\WBS_SM_Multi_State";
	private final String projectName = "WBS_SM_Multi_State";
	private final String modelName = "WBS.uml";
	private final String property = "TRUE";
	private final String algorithm_type = "bmc";
	private final String check_type = "ltlspec";
	private final String resultFilePath = "C:\\Windows\\Temp\\amass\\result.xml";

	private String elementURI ;
	
	@Before
	public void setLog4jProps() throws MalformedURLException, URISyntaxException{
		BasicConfigurator.configure();
		File fileProp = new File(log4jFilePath);
		
	    PropertyConfigurator.configure( 
	    		//new URI(log4jFilePath).toURL());
	    		fileProp.toURI().toURL());
	}
	
	@Before
	public void loadModel() throws Exception {
		Model model = entityUtil.loadModel(projectName, modelName);
		elementURI = entityUtil.getSystemElementURIFragment(model);
		logger.debug("elementURI: " + elementURI);
	}

	@Test
	public void testModelChecking() throws Exception {		
		Assert.assertEquals(true, execCommandService.execModelChecking(isProgrExecution,isDiscrete, projectPath,projectName, modelName, elementURI, property, algorithm_type, check_type,resultFilePath));	
		}

	
	
	@After
	public void after(){
		logger.debug("after modelCheckingCommand");
	}

	
	
}
