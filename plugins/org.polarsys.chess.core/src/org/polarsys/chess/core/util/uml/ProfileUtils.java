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

public class ProfileUtils {

	
	/**
	 * @deprecated use PackageUtil.loadPackage
	 */
	@Deprecated
	public static Profile loadProfile(ResourceSet rs, String profileUri) {
		Profile p = (Profile) rs.getResource(URI.createURI(profileUri), true)
				.getContents().get(0);
		return p;
	}

	public static void writeProfileRecursively(Package pkg, BufferedWriter f)
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

	public static void writeProfileRecursivelyToFile(Package pkg,
			String fileName) throws IOException {
		FileWriter f = null;

		f = new FileWriter(fileName);

		BufferedWriter o = new BufferedWriter(f);
		ProfileUtils.writeProfileRecursively(pkg, null);
		o.close();
	}

	/**
	 * @deprecated use directly org.eclipse.papyrus.uml.tools.utils.PackageUtil.applyProfile
	 */
	@Deprecated
	public static void applyProfileRecursively(Profile pkg, Package model) {
		PackageUtil.applyProfile(model, pkg, true);
	}

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

	public static boolean isPredefinedStereotype(Object strt) {
		if (strt instanceof Stereotype) {
			if (CHESSProfileManager.CHESS_VIEWS_LIST.contains(((Stereotype) strt).getName()))
				return true;
			return false;
		}
		return false;
	}
}
