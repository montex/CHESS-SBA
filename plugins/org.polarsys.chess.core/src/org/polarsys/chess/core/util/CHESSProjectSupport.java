/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2015                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.MessageConsoleStream;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.internal.util.InternalCHESSProjectSupport;
import org.polarsys.chess.core.internal.util.InternalConsoleUtil;

/**
 * This class contains a list of utility methods to deal with the Eclipse project.
 *
 */
public class CHESSProjectSupport {

	/**
	 * The CHESS console name used to output information.
	 */
	public static String CHESS_CONSOLE_NAME = "CHESS notification console";

	private static final boolean isConsoleEnabled = true;

	/**
	 * The CHESS console.
	 */
	public static final MessageConsoleStream CHESS_CONSOLE = InternalConsoleUtil
			.findCHESSconsole();
	/**
	 * The CHESS console stream.
	 */
	public static final PrintStream CHESS_CONSOLE_STREAM = new PrintStream(
			CHESS_CONSOLE);

	/**
	 * Print a message to the CHESS Console.
	 * 
	 * @param message
	 */
	public static void printlnToCHESSConsole(final String message) {
		if (isConsoleEnabled)
			CHESS_CONSOLE.println(message);
	}

	/**
	 * Create an Eclipse Project given a name and a location. This method
	 * automatically add the CHESS nature.
	 * 
	 * @param projectName
	 *            The name of the project
	 * @param location
	 *            The location where to create the project
	 * @return the project created (IProject)
	 */
	public static IProject createProject(final String projectName, final URI location) {
		IProject project = InternalCHESSProjectSupport.createBaseProject(
				projectName, location);
		try {
			InternalCHESSProjectSupport.addNature(project);
		} catch (CoreException e) {
			Activator.error("Create project error", e);
		}
		return project;
	}

	/**
	 * Create folders. The typical use is: <code>
	 * myNewFolders = myProject.getFolder("folders/to/create/");
	 * createFolder(myNewFolders);
	 * </code>
	 * 
	 * @param folder
	 *            the IFolder instance to create
	 * @throws CoreException
	 *             Exceptions during the folder creation are not handled by this
	 *             method.
	 */
	public static void createFolder(final IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent);
		}

		if (!folder.exists()) {
			folder.create(true, true, null);
		}
	}

	/**
	 * This method converts a Resource to a IFile. This allows to use IFile
	 * manipulation utilities provided by this library.
	 * 
	 * @param inResource
	 *            the resource to converto to IFile
	 * @return the IFile converted or null in case the resource is not valid.
	 */
	public static/* @Nullable */IFile resourceToFile(final Resource inResource) {
		java.net.URI inputJURI = null;
		if (inResource.getURI().isPlatformResource()) {
			inputJURI = java.net.URI.create(inResource.getURI()
					.toPlatformString(false).toString());
			IPath path = InternalCHESSProjectSupport.toPath(inputJURI);
			IFile inputFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(path);
			return inputFile;
		}
		return null;
	}

	/**
	 * Copy an IFile to a folder and rename it. If a copy  exists already then overwrite it.
	 * 
	 * @param inputFile the IFile to copy
	 * @param newLocation a String to specify the location to copy the file
	 * @param outputName the name of the copy
	 * @return the IFile created
	 * @throws Exception when the file cannot be copied or the old copy cannot be overwritten.
	 */
	public static IFile copyFile(final IFile inputFile, final String newLocation,
			final String outputName) throws Exception {
		IFile inputCopy = inputFile.getProject().getFile(
				newLocation + File.separator + outputName);
		try {
			inputCopy.delete(true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new Exception("Unable to make a copy of the model");
		}
		try {
			inputFile.copy(inputCopy.getFullPath(), true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new Exception("Unable to make a copy of the model");
		}
		return inputCopy;
	}

	/**
	 * Replace the content of the 'out' IFile  with the content of the 'in' IFile.
	 * 
	 * @param in the new IFile content
	 * @param out the old IFile content to be replaced
	 * @throws CoreException when the contents of the IFiles cannot be manipulated
	 * @throws IOException when the stream used to transfer the content cannot be closed
	 */
	public static void fileReplace(final IFile in, final IFile out) throws CoreException,
			IOException {
		InputStream ins = in.getContents(true);
		out.setContents(ins, true, true, null);
		ins.close();
	}

	
	/**
	 * Copies the content of a plug-in to a project. Useful to copy predefined source code libraries to a project during the code generation.
	 * 
	 * @param pluginID the ID of the plugin where the files to be copied reside, not used
	 * @param plugin the plugin where the files to be copied reside
	 * @param pluginPath the path to the folder where the file to be copied reside
	 * @param currentProject the project to copy the files
	 * @param projectPath the path of the project where the file will be copied
	 * @param includeBundleFolder whether to copy the root folder where the files reside or not
	 * @throws IOException when the operation cannot be performed
	 */
	public static void bundleToProjectCopy(final String pluginID, final Plugin plugin,
			final String pluginPath,final  IProject currentProject, final String projectPath,
			boolean includeBundleFolder) throws IOException {
		List<String> collectedPaths = new ArrayList<String>();
		InternalCHESSProjectSupport.getBundleContents(plugin, pluginPath,
				collectedPaths);

		IPath workingDir = currentProject.getFolder(projectPath).getLocation();

		for (String collectedPath : collectedPaths) {
			Path path = new Path(collectedPath);
			URL u = FileLocator.find(plugin.getBundle(), path, null);

			if (!includeBundleFolder)
				collectedPath = collectedPath
						.substring(pluginPath.length() + 1);

			try {
				InputStream in = u.openStream();
				File f = new File(workingDir + "/" + collectedPath);

				f.getParentFile().mkdirs();
				FileOutputStream o = new FileOutputStream(f);
				InternalCHESSProjectSupport.fileCopy(in, o);
			} catch (IOException e) {
				Activator.error("Unable to copy the content of the plug-in", e);
				throw e;
			}	
		}
	}

	/**
	 * Deletes a folder.
	 * 
	 * @param folder the IFolder to delete
	 * @throws CoreException when the folder cannot be deleted
	 */
	public static void deleteFolder(final IFolder folder) throws CoreException {
		if (folder.exists()) {
			folder.delete(true, null);
		}
	}

}
