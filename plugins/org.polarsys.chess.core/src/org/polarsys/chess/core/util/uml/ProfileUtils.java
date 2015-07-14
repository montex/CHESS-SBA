/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.core.util.uml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.profiles.MARTEProfileManager;

/**
 * This class contains a list of utility methods to manage UML Profiles.
 *
 */
public class ProfileUtils {

	
	/**
	 * @deprecated use {@link PackageUtil#loadPackage(URI, ResourceSet)} instead.
	 */
	@Deprecated
	public static Profile loadProfile(ResourceSet rs, String profileUri) {
		Profile p = (Profile) rs.getResource(URI.createURI(profileUri), true)
				.getContents().get(0);
		return p;
	}

	/**
	 * Recursively outputs the list of profiles to a {@link BufferedWriter} starting from the given package.
	 * 
	 * @param pkg
	 * @param f
	 * @throws IOException
	 */
	private static void writeProfileRecursively(Package pkg, BufferedWriter f)
			throws IOException {
		if (pkg instanceof Profile) {
			String name = ((Profile) pkg).getName();
			f.write(name);

			/*
			 * System.out.println("public static final String " + a +
			 * " = \""+name+"\";");
			 * 
			 * System.out.println("predefinedProfiles.add(MARTEProfileManager."
			 * + name + ");");
			 */
		}

		for (Package p : pkg.getNestedPackages()) {
			writeProfileRecursively(p, f);
		}
	}

	/**
	 * Writes the list of applied profile given a package to a file.
	 * 
	 * @param pkg
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeProfileRecursivelyToFile(Package pkg,
			String fileName) throws IOException {
		FileWriter f = null;

		f = new FileWriter(fileName);

		BufferedWriter o = new BufferedWriter(f);
		ProfileUtils.writeProfileRecursively(pkg, null);
		o.close();
	}

	/**
	 * @deprecated use directly {@link PackageUtil#applyProfile(Package, Profile, boolean)} instead.
	 */
	@Deprecated
	public static void applyProfileRecursively(Profile pkg, Package model) {
		PackageUtil.applyProfile(model, pkg, true);
	}

	/**
	 * Checks if the given profile is defined in the CHESS or MARTE profiles.
	 * 
	 * @param profile  the profile
	 * @return true if it is defined in CHESS or MARTE profiles
	 */
	public static boolean isPredefinedProfile(Object profile) {
		if (profile instanceof Profile) {
			Profile p = (Profile)profile;
			if (MARTEProfileManager.PREDEFINED_PROFILES.contains(p.getName()) || 
				CHESSProfileManager.PREDEFINED_PROFILES.contains(p.getName()))
				return true;
			return false;
		}
		return false;
	}

	/**
	 * Checks if the given stereotype represents a Design View. 
	 * 
	 * @param strt  the stereotype
	 * @return true if it is a Design View
	 */
	public static boolean isPredefinedStereotype(Object strt) {
		if (strt instanceof Stereotype) {
			if (CHESSProfileManager.CHESS_VIEWS_LIST.contains(((Stereotype) strt).getName()))
				return true;
			return false;
		}
		return false;
	}
}
