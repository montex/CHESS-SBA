/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.m2m;


import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.polarsys.chess.core.util.CHESSProjectSupport;

@SuppressWarnings("restriction")
public class QVToTransformation {

	public static void launchCeilingAssignment(IFile model, IProgressMonitor monitor)
			throws Exception {

		launchTransformation(TransUtil.QVTO_CEILING, "CHESS_CEILING", false,
				model, monitor, new HashMap<String, String>());
	}
	
	public static void launchBuildMultiInstance(IFile model, IProgressMonitor monitor)
			throws Exception {

		launchTransformation(TransUtil.QVTO_MULTIINSTANCE, "BuildMultiInstance", false,
				model, monitor, new HashMap<String, String>());
	}
	
	public static void launchRemoveMultiInstance(IFile model, IProgressMonitor monitor)
			throws Exception {

		launchTransformation(TransUtil.QVTO_REMMULTIINSTANCE, "RemoveMultiInstance", false,
				model, monitor, new HashMap<String, String>());
	}
	
	
//	public static void launchPIM2PSMVERDE(IFile model, IProgressMonitor monitor,  Map<String, String> configProps) 
//			throws Exception {
//		
//		launchTransformation(TransUtil.QVTO_PIM2PSMVERDE, "CHESS_PIM2PSMVERDE", true,
//				model, monitor, configProps);
//	}
//	
//	public static void launchPIM2PSMEndToEnd(IFile model, IProgressMonitor monitor, Map<String, String> configProps) 
//			throws Exception {
//		
//		launchTransformation(TransUtil.QVTO_PIM2PSMVERDE, "CHESS_PIM2PSMEndToEnd", true,
//				model, monitor, configProps);
//	}

	public static void launchTransformation(String transURI, String transName,
			boolean generateTrace, IFile model, IProgressMonitor monitor, Map<String, String> configProps)
			throws Exception {
		String modelURIString = URI.createPlatformResourceURI(
				model.getFullPath().toString(), false).toString();
		String traceURIString = generateTrace ? modelURIString.substring(0,
				modelURIString.lastIndexOf('.') + 1) + "qvtotrace" : null;
		String transfURIString = transURI;
		// String marteURIString =
		// org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI;
	
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType c = manager
				.getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy instance = c.newInstance(null,
				transName);
	
		instance.setAttribute(IQvtLaunchConstants.CLEAR_CONTENTS + "1", true);
		instance.setAttribute(IQvtLaunchConstants.CLEAR_CONTENTS + "2", true);
		instance.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, configProps);
		instance.setAttribute(IQvtLaunchConstants.ELEM_COUNT, 2);
		instance.setAttribute(IQvtLaunchConstants.FEATURE_NAME + "1", "");
		instance.setAttribute(IQvtLaunchConstants.FEATURE_NAME + "2", "");
		instance.setAttribute(IQvtLaunchConstants.MODULE, transfURIString);
		instance.setAttribute(IQvtLaunchConstants.TARGET_MODEL + "1",
				modelURIString);
		// instance.setAttribute(IQvtLaunchConstants.TARGET_MODEL+"2",
		// marteURIString);
	
		instance.setAttribute(IQvtLaunchConstants.TARGET_TYPE + "1",
				"NEW_MODEL");
		// instance.setAttribute(IQvtLaunchConstants.TARGET_TYPE+"2",
		// "NEW_MODEL");
		if (generateTrace)
			instance.setAttribute(IQvtLaunchConstants.TRACE_FILE,
					traceURIString);
	
		instance.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, generateTrace);
	
		QvtTransformation qvtTransformation = new QvtInterpretedTransformation(
				QvtLaunchConfigurationDelegateBase.getQvtModule(instance));
		
		IStatus status = QvtLaunchConfigurationDelegateBase.validate(
				qvtTransformation, instance);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
	
		//EvaluationMonitor execMonitor = createMonitor();
		Context context = QvtLaunchUtil.createContext(instance);
	
		OutputStreamWriter s = new OutputStreamWriter(
				CHESSProjectSupport.CHESS_CONSOLE);
		context.setLog(new WriterLog(s));
		context.setProgressMonitor(monitor);
		
		QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation,
				instance, context);
		qvtTransformation.cleanup();
	}

//	private static EvaluationMonitor createMonitor() {
//		return new EvaluationMonitor() {
//			boolean fIsCanceled = false;
//
//			public void cancel() {
//				fIsCanceled = true;
//			}
//
//			public boolean isCanceled() {
//				return fIsCanceled;
//			}
//		};
//	}
}
