/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
-- Intecs S.p.A., Italy                                              --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Leonardo Montecchi 	lmontecchi@unifi.it                          --
-- Nicholas Pacini		nicholas.pacini@intecs.it                    --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.polarsys.chess.statebased.daemon.ParameterList;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.polarsys.chess.statebased"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		ParameterList defParams = new ParameterList();
		
		store.setDefault("HOST", DEEMClient.HOST);
		store.setDefault("PORT", DEEMClient.PORT);
		store.setDefault("TIMEOUT", DEEMClient.TIMEOUT);
		store.setDefault("MINBATCHES", defParams.getMinimumBatches());
		store.setDefault("MAXBATCHES", defParams.getMaximumBatches());
		store.setDefault("CONFLEVEL", defParams.getConfidenceLevel());
		store.setDefault("CONFINTERVAL", defParams.getConfidenceInterval());
		store.setDefault("DISPUPDATE", defParams.getDisplayUpdateInterval());
		store.setDefault("MEASUPDATE", defParams.getMeasureUpdateInterval());
		store.setDefault("SEED", defParams.getSeed());
		
		store.setDefault("PARAMFILE", "parameters.txt");
		store.setDefault("RESULTFILE", "results.txt");
		store.setDefault("EXECPERIOD", 60);
		store.setDefault("RUNPERIODIC", false);
	}

}
