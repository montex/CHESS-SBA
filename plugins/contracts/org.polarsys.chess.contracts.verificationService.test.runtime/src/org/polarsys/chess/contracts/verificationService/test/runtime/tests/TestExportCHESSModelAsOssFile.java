package org.polarsys.chess.contracts.verificationService.test.runtime.tests;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.apache.commons.lang3.tuple.Pair;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSTranslatorServiceAPI;
import eu.fbk.eclipse.standardtools.xtextService.core.utils.XTextResourceUtil;
import eu.fbk.eclipse.standardtools.xtextService.core.utils.XTextValidation;
import eu.fbk.tools.adapter.ocra.CheckContractRefinement;
import eu.fbk.tools.adapter.ocra.CheckContractResultBuilder;
import eu.fbk.tools.adapter.ocra.OcraRunner;

public class TestExportCHESSModelAsOssFile {

	private EntityUtil entityUtil = EntityUtil.getInstance();
	private OSSTranslatorServiceAPI ossTranslatorServiceAPI = OSSTranslatorServiceAPI
			.getInstance(ChessSystemModel.getInstance());
	private XTextResourceUtil xTextResourceUtil = XTextResourceUtil.getInstance();
	private XTextValidation xtextValidation = XTextValidation.getInstance();
	private static final Logger logger = Logger.getLogger(TestModelChecking.class);

	private boolean temp_variable_is_discrete = false;
	private final String projectName = "WBS_SM_Multi_State";
	private final String modelName = "WBS.uml";
	private final String workspace = "C:\\Windows\\Temp\\amass\\";
	private final String resultFilePath = workspace+"exportedOSS.oss";
	private final String OCRAPath = "C:\\Users\\Alberto\\Downloads\\20180124_OpenCertCHESSClient_Win_x64\\amass_P1\\FBK_Tools\\OCRA\\ocra_win64.exe"; 

private final int timeout = 1000*60*5;

	EObject umlSelectedComponent;
	Resource componentResource;

	@Before
	public void setTestParameters() throws Exception {
		Model model = entityUtil.loadModel(projectName, modelName);
		String elementURI = entityUtil.getSystemElementURIFragment(model);
		umlSelectedComponent = entityUtil.getElement(model, elementURI);
		componentResource = umlSelectedComponent.eResource();
		logger.debug("elementURI: " + elementURI);
	}

	@Test
	public void testCheckContractRefinementOfCHESSComponent() throws Exception {

		System.out.println("Workspace: "+workspace);
		
		IProgressMonitor monitor = new NullProgressMonitor();

		Object ocraModel = ossTranslatorServiceAPI.exportRootComponentToOssModel(umlSelectedComponent,
				temp_variable_is_discrete, monitor);
		String fileName = ossTranslatorServiceAPI.getFileName(umlSelectedComponent);
		File ossFile = ossTranslatorServiceAPI.exportOSSModelToOSSFile(ocraModel,fileName,resultFilePath);
		
		XtextResource xTextResource = xTextResourceUtil.createOSSResourceFromFile(ossFile.getPath());
		List<Issue> issues = xtextValidation.xTextValidation(xTextResource);
		
		Assert.assertTrue("The generated file exists", ossFile.exists());
		Assert.assertTrue("No xText issues", issues.isEmpty());

		checkContractRefinement(ossFile);
	}
	
	
	private void checkContractRefinement(File contractFile){
		final CheckContractRefinement function = new CheckContractRefinement(contractFile.toURI());
		function.setTimeModel(eu.fbk.tools.adapter.ocra.OcraFunction.TimeModel.discrete);

		final OcraRunner runner = new OcraRunner(OCRAPath);
		runner.setWorkspaceDir(workspace);
		runner.setDebugMode(false);
		runner.setToolFunction(function);

		
		try
		{
			final Pair<String, String> output = runner.runTool(timeout);
			Assert.assertNotNull(output);
			Assert.assertTrue(!output.getLeft().isEmpty());
			Assert.assertTrue(output.getRight().isEmpty());

			final CheckContractResultBuilder resultBuilder = new CheckContractResultBuilder();
			Assert.assertNotNull(resultBuilder.unmarshalResult(runner.getResultFile()));

			System.out.println("done");
		}
		catch (TimeoutException e)
		{
			Assert.assertTrue("Timeout error checking model [" + contractFile.getName() + "]", false);
		}
		catch (Throwable t) {
		}
		
		runner.cleanSessionWorkspace();

	}
	
}
