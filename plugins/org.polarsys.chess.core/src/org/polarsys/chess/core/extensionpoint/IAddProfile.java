package org.polarsys.chess.core.extensionpoint;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;

public interface IAddProfile {

	/**
	 * used to add a profile for the given model
	 * @param owner
	 * @param resourceSet
	 */
	void addProfile(Model owner, ResourceSet resourceSet);
	
	/**
	 * used to load a profile to the given ResourceSet
	 * @param resourceSet
	 */
	void loadProfile(ResourceSet resourceSet);

}
