package org.polarsys.chess.cdo;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.polarsys.chess.cdo"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log = new LogHelper();

	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// register the log helper
		log.setPlugin(plugin);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log = null;
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

}
