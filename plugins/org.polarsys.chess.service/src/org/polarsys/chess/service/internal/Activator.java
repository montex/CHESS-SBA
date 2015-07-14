/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2014                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it               --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.service.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.polarsys.chess.service"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static void error(String message, Throwable e) {
		String msg = null;
		if (message == null)
			msg = e.getMessage();
		else
			msg = String.format("%s: %s", message, e.getMessage());
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, msg, e);
		plugin.getLog().log(status);
	}
	
	public static void info(String message) {
		IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID, message);
		plugin.getLog().log(status);
	}
}
