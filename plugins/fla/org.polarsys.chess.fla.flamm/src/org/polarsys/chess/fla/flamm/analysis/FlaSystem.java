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
package org.polarsys.chess.fla.flamm.analysis;

import java.util.LinkedList;
import java.util.List;

import org.polarsys.chess.fla.flamm.*;

public class FlaSystem {
	Component rootComponent;
	boolean propagateUnmatchedFailures = true;
	boolean treatUnmentionedPortsAsWildcards = true;
	boolean initToNoFailure = true;
	
	public Component getRootComponent() {
		return rootComponent;
	}

	protected void setRootComponent(Component rootComponent) {
		this.rootComponent = rootComponent;
	}
	
	public FlaSystem() {
		// Default constructor
	}
	
	public FlaSystem(Component rootComponent) {
		this.rootComponent = rootComponent;
	}
	
	/**
	 * Should all connections (input ports) be initialized with a noFailure token?<br/>
	 * Default: <code>true</code>
	 * @param initToNoFailure
	 */
	public void initializeNoFailure(boolean initToNoFailure) {
		this.initToNoFailure = initToNoFailure;
	}
	
	/**
	 * Should unmatched errors be propagated to all output ports?<br/>
	 * Default: <code>true</code>
	 * @param propagateUnmatchedFailures
	 */
	public void propagateUnmatchedFailures(boolean propagateUnmatchedFailures) {
		this.propagateUnmatchedFailures = propagateUnmatchedFailures;
	}
	
	/**
	 * Should unmatched errors be propagated to all output ports?<br/>
	 * Default: <code>true</code>
	 * @param propagateUnmatchedFailures
	 */
	public void treatUnmentionedPortsAsWildcards(boolean treatUnmentionedPortsAsWildcards) {
		this.treatUnmentionedPortsAsWildcards = treatUnmentionedPortsAsWildcards;
	}
	
	public void performAnalysis(FlaLogger logger) {
		FlaSystem.staticPropagateUnmatchedFailures = this.propagateUnmatchedFailures;
		FlaSystem.staticTreatUnmentionedPortsAsWildcards = this.treatUnmentionedPortsAsWildcards;
		FlaSystem.staticInitToNoFailure = this.initToNoFailure;
		
		rootComponent.initialize(this.initToNoFailure);
		addUpdatedComponent(rootComponent);

		while (!updatedComponents.isEmpty()) {
			Component updatedComponent = updatedComponents.remove(0);
			updatedComponent.propagateFailures();
		}
	}
	
	/* Static methods */
	
	private static List<Component> updatedComponents = new LinkedList<Component>();
	private static boolean staticPropagateUnmatchedFailures;
	private static boolean staticTreatUnmentionedPortsAsWildcards;
	private static boolean staticInitToNoFailure;
	
	/**
	 * Should all connections (input ports) be initialized with a noFailure token?<br/>
	 * Default: <code>true</code>
	 * @param initToNoFailure
	 */
	public static boolean initializeNoFailure() {
		return FlaSystem.staticInitToNoFailure;
	}
	
	/**
	 * Should unmatched errors be propagated to all output ports?<br/>
	 */
	public static boolean propagateUnmatchedFailures() {
		return FlaSystem.staticPropagateUnmatchedFailures;
	}
	
	/**
	 * Should unmatched errors be propagated to all output ports?<br/>
	 */
	public static boolean treatUnmentionedPortsAsWildcards() {
		return FlaSystem.staticTreatUnmentionedPortsAsWildcards;
	}
	
	/**
	 * Add an updated component to the list to be analyzed.<br/>
	 * @param updatedComponent updated component.
	 */
	public static void addUpdatedComponent(Component updatedComponent) {
		if (!updatedComponents.contains(updatedComponent)) {
			updatedComponents.add(updatedComponent);
		}
	}
	
}
