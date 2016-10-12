package org.polarsys.chess.core.extensionpoint;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;

public interface IAddProfile {

	/**
	 * Applies a profile to the given model and resourceset
	 * 
	 * @param owner
	 * @param resourceSet
	 */
	void addProfile(Model owner, ResourceSet resourceSet);

	/**
	 * Loads a profile for the given ResourceSet
	 * 
	 * @param resourceSet
	 */
	void loadProfile(ResourceSet resourceSet);

}
