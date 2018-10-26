/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.preferences;

import java.io.Serializable;

import org.polarsys.chess.fla.launch.Activator;

public class FlaParameters implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String INIT_NO_FAILURE = "INIT_NO_FAILURE";
	public static final String PROPAGATE_UNMATCHED_FAILURES = "PROPAGATE_UNMATCHED_FAILURES";
	public static final String TREAT_UNMENTIONED_PORTS_AS_WILDCARDS = "TREAT_UNMENTIONED_PORTS_AS_WILDCARDS";
	
	private boolean initNoFailure = true;
	private boolean propagateUnmatchedFailures = true;
	private boolean treatUnmentionedPortsAsWildcards = true;
	
	public boolean getInitNoFailure() {
		return initNoFailure;
	}
	
	public void setInitNoFailure(boolean initNoFailure) {
		this.initNoFailure = initNoFailure;
	}
	
	public boolean getPropagateUnmatchedFailures() {
		return propagateUnmatchedFailures;
	}
	
	public void setPropagateUnmatchedFailures(boolean propagateUnmatchedFailures) {
		this.propagateUnmatchedFailures = propagateUnmatchedFailures;
	}
	
	public boolean getTreatUnmentionedPortsAsWildcards() {
		return this.treatUnmentionedPortsAsWildcards;
	}
	
	public void setTreatUnmentionedPortsAsWildcards(boolean treatUnmentionedPortsAsWildcards) {
		this.treatUnmentionedPortsAsWildcards = treatUnmentionedPortsAsWildcards;
	}
	
	public static FlaParameters getCurrentParameters() {
		FlaParameters params = new FlaParameters();
		params.setInitNoFailure(Activator.getDefault().getPreferenceStore().getBoolean(INIT_NO_FAILURE));
		params.setPropagateUnmatchedFailures(Activator.getDefault().getPreferenceStore().getBoolean(PROPAGATE_UNMATCHED_FAILURES));
		params.setTreatUnmentionedPortsAsWildcards(Activator.getDefault().getPreferenceStore().getBoolean(TREAT_UNMENTIONED_PORTS_AS_WILDCARDS));
		return params;
	}

	
}
