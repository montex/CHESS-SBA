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

package org.polarsys.chess.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.natures.CHESSNature;

public class CHESSProjectSupport {
	
	private static String CHESS_CONSOLE_NAME = "CHESS notification console";

	private static final boolean isConsoleEnabled = true;
	
	public static final MessageConsoleStream CHESS_CONSOLE = findCHESSconsole();
	public static final PrintStream CHESS_CONSOLE_STREAM = new PrintStream(CHESS_CONSOLE);
	
	public static void printlnToCHESSConsole(String s){
		if (isConsoleEnabled )
			CHESS_CONSOLE.println(s);
	}
	
	public static IProject createProject(String projectName, URI location) {
		IProject project = createBaseProject(projectName, location);
		try {
			addNature(project);
//			String[] paths = { "functional view", //$NON-NLS-1$
//					"extrafunctional view", //$NON-NLS-1$
//					"deplyment view" //$NON-NLS-1$
//			};
//			addToProjectStructure(project, paths);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return project;
	}
	
	

	private static IProject createBaseProject(String projectName, URI location) {
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		if (!newProject.exists()) {
			URI projectLocation = location;
			IProjectDescription desc = newProject.getWorkspace()
					.newProjectDescription(newProject.getName());
			if (location != null
					&& ResourcesPlugin.getWorkspace().getRoot()
							.getLocationURI().equals(location)) {
				projectLocation = null;
			}
			desc.setLocationURI(projectLocation);
			try {
				newProject.create(desc, null);
				if (!newProject.isOpen()) {
					newProject.open(null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return newProject;
	}

	public static void createFolder(IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent);
		}

		if (!folder.exists()) {
			folder.create(true, true, null);
		}
	}

	@SuppressWarnings("unused")
	private static void addToProjectStructure(final IProject newProject,
			final String[] paths) throws CoreException {
		for (String path : paths) {
			IFolder etcFolder = newProject.getFolder(path);
			createFolder(etcFolder);
		}
	}

	private static void addNature(IProject project) throws CoreException {
		if (!project.hasNature(CHESSNature.NATURE_ID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = CHESSNature.NATURE_ID;
			description.setNatureIds(newNatures);
            project.setDescription(description, null);
		}
	}
	
	
	private static MessageConsole findConsole(final String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});
	      return myConsole;
	   }
	
	public static MessageConsoleStream findCHESSconsole(){
		MessageConsole myConsole = findConsole(CHESS_CONSOLE_NAME);
		return myConsole.newMessageStream();
	}
	
	
	public static IFile resourceToFile(Resource inResource) {
		java.net.URI inputJURI = null;
		if (inResource.getURI().isPlatformResource()){
			inputJURI = java.net.URI.create(inResource.getURI().toPlatformString(false).toString());
	//		else
	//			inputJURI = java.net.URI.create(inResource.getURI().toString());
	//		IFile input = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(inputJURI.toString());
			IPath path = FileUtil.toPath(inputJURI);
			IFile inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);//project.getFile(p);
			return inputFile;
		}
		return null;
	}
	
	public static String getPluginInstallLocation(String pluginId) throws Exception {
		Bundle bundle = Platform.getBundle(pluginId);
		URL locationUrl = FileLocator.find(bundle,new Path("/"), null);
		URL fileUrl = FileLocator.toFileURL(locationUrl);
		return fileUrl.getFile();
	}



	public static String getNameWithoutExtension(IFile inputFile) {
		String inputName = inputFile.getName();
		int extensionIndex = inputName.lastIndexOf('.');
		if (extensionIndex != -1)
			inputName = inputName.substring(0, extensionIndex);
		return inputName;
	}



//	public static IFile copyFileBySuffix(IFile inputFile, String folder, String suffix)
//			throws Exception {
//		String inputName = getNameWithoutExtension(inputFile);
//	
//		IFile inputCopy = inputFile.getProject().getFile(
//				folder + File.separator + inputName + suffix);
//		try {
//			inputCopy.delete(true, null);
//		} catch (CoreException e) {
//			e.printStackTrace();
//			throw new Exception("Unable to make a copy of the model");
//		}
//		try {
//			// inputFile.copy(FileUtil.toPath(java.net.URI.create(transDirURI.appendSegment("input.uml").toPlatformString(false).toString())),
//			// true, null);
//			inputFile.copy(inputCopy.getFullPath(), true, null);
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//		return inputCopy;
//	}
	
	public static IFile copyFile(IFile inputFile, String folder, String outputName)
			throws Exception {
		IFile inputCopy = inputFile.getProject().getFile(folder + File.separator + outputName);
		try {
			inputCopy.delete(true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new Exception("Unable to make a copy of the model");
		}
		try {
			// inputFile.copy(FileUtil.toPath(java.net.URI.create(transDirURI.appendSegment("input.uml").toPlatformString(false).toString())),
			// true, null);
			inputFile.copy(inputCopy.getFullPath(), true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new Exception("Unable to make a copy of the model");
		}
		return inputCopy;
	}

	public static void fileCopy(InputStream in, FileOutputStream out) throws IOException {
		byte[] buf = new byte[8192];
	    while (true) {
	      int length = in.read(buf);
	      if (length < 0)
	        break;
	      out.write(buf, 0, length);
	    }
	
	    try {
	      in.close();
	    } catch (IOException ignore) {
	    }
	    try {
	      out.close();
	    } catch (IOException ignore) {
	    }
	}
	
	
	public static void fileReplace(IFile in, IFile out) throws CoreException, IOException{
		InputStream ins = in.getContents(true);
		out.setContents(ins, true, true, null);
		ins.close();
	}
	
	private static void getBundleContents(Plugin activator, String path, List<String> collectedPaths) {
		Enumeration<?> enums = activator.getBundle()
				.getEntryPaths(path);
	
		while (enums.hasMoreElements()) {
			Object object = enums.nextElement();
			Enumeration<?> tmpEnum = activator.getBundle()
					.getEntryPaths(object.toString());
			if (tmpEnum != null)
				getBundleContents(activator, object.toString(), collectedPaths);
			else {
				collectedPaths.add(object.toString());
			}
		}
	}
	
	
	public static void writeLog(String s) throws FileNotFoundException{
		FileOutputStream out = new FileOutputStream(getEclipseInstallLocation()+"CHESSLOG");
		PrintStream p = new PrintStream(out);
		p.println(s);
		p.close();
	}
	
	
	public static String getEclipseInstallLocation(){
		if(System.getProperty("os.name").equals("Linux"))
			return System.getProperties().get("osgi.install.area").toString().substring(5);
		else
			return System.getProperties().get("osgi.install.area").toString().substring(6);
	}
	
	//copy linux and windows version of MAST inside this plugin to the eclipse folder
	public static void installMAST() {
		String eclipseLocation = getEclipseInstallLocation();
		
		if (new Path(eclipseLocation+java.io.File.separator+"mast").toFile().exists()){
			CHESSProjectSupport.CHESS_CONSOLE.println("MAST is already installed");
			return;//already installed
		}
		URL mastDir = FileLocator.find(Activator.getDefault().getBundle(), new Path("/mast"), null);
		
		Activator.getDefault().getBundle().getEntryPaths("/mast");
		
		List<String> collectedPaths = new ArrayList<String>();
		CHESSProjectSupport.getBundleContents(Activator.getDefault(), "/mast", collectedPaths);
		
		for (String p : collectedPaths) {
			Path pa = new Path(p);
			URL u = FileLocator.find(Activator.getDefault().getBundle(), pa, null);
			  try {
				InputStream in = u.openStream();
				File f = new File(eclipseLocation+p);
				if (f.setExecutable(true)){
					CHESSProjectSupport.CHESS_CONSOLE.println("Exec permission set for " + f.getName());
				}
				f.getParentFile().mkdirs();
				FileOutputStream o = new FileOutputStream(f);
				CHESSProjectSupport.fileCopy(in, o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void bundleToProjectCopy(String pluginID, Plugin plugin, String pluginPath, IProject currentProject, String projectPath, boolean includeBundleFolder){
		List<String> collectedPaths = new ArrayList<String>();
		CHESSProjectSupport.getBundleContents(plugin, pluginPath, collectedPaths);
		
		IPath workingDir = currentProject.getFolder(projectPath).getLocation();
		
		for (String collectedPath : collectedPaths) {
			Path path = new Path(collectedPath);
			URL u = FileLocator.find(plugin.getBundle(), path, null);
			
			if (!includeBundleFolder)
				collectedPath = collectedPath.substring(pluginPath.length() + 1);
			
			try {
				InputStream in = u.openStream();
				File f = new File(workingDir + "/" + collectedPath);
				
//				if (f.exists())
//					continue;
				
				f.getParentFile().mkdirs();
				FileOutputStream o = new FileOutputStream(f);
				CHESSProjectSupport.fileCopy(in, o);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static IFile getIFileFromAbsolutePath(String path){
		IPath location= Path.fromOSString(path);
		return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
	}
//	   IConsole myConsole = ...;//your console instance
//	   IWorkbenchPage page = ...;//obtain the active page
//	   String id = IConsoleConstants.ID_CONSOLE_VIEW;
//	   IConsoleView view = (IConsoleView) page.showView(id);
//	   view.display(myConsole);

	public static void deleteFolder(IFolder folder) throws CoreException {
		if (folder.exists()) {
			folder.delete(true, null);
		}
	}

}
