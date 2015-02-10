/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.views;

import static org.polarsys.chess.core.views.permissions.EntryId.ANY;
import static org.polarsys.chess.core.views.permissions.EntryId.NONE;
import static org.polarsys.chess.core.views.permissions.EntryId.anyEntry;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.views.permissions.EntryId;
import org.polarsys.chess.core.views.permissions.PermissionEntry;
import org.polarsys.chess.core.views.permissions.PermissionList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author Alessandro Zovi
 *
 */
public class ViewPermissions {
	
	static HashMap<String, HashMap<String, PermissionList>> permissions = new HashMap<String, HashMap<String, PermissionList>>();	
	
	static PermissionList componentViewPL;
	static PermissionList extraFunctionalViewPL;
	static PermissionList deploymentViewPL;
	static PermissionList analysisViewPL;
	static PermissionList requirementViewPL;
	static PermissionList RTAnalysisViewViewPL;
	static PermissionList DependabilityAnalysisViewPL;
	static PermissionList DependabilityViewPL;
	static PermissionList SystemViewPL;
	static PermissionList PSMView;
	
	static PermissionEntry allowAll = new PermissionEntry(anyEntry, false, true, true);
	static void initializeLists(){
		/*componentViewPL = new PermissionList();
		extraFunctionalViewPL = new PermissionList();
		deploymentViewPL = new PermissionList();
		analysisViewPL = new PermissionList();
		requirementViewPL = new PermissionList();
		RTAnalysisViewViewPL = new PermissionList();
		DependabilityAnalysisViewPL = new PermissionList();
		DependabilityViewPL = new PermissionList();
		SystemViewPL = new PermissionList();
		PSMView = new PermissionList();*/
		
//		permissions.put(CHESSProfileManager.COMPONENT_VIEW,
//				ViewPermissions.componentViewPL);
//		permissions.put(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW,
//				ViewPermissions.extraFunctionalViewPL);
//		permissions.put(CHESSProfileManager.ANALYSIS_VIEW,
//				ViewPermissions.analysisViewPL);
//		permissions.put(CHESSProfileManager.DEPLOYMENT_VIEW,
//				ViewPermissions.deploymentViewPL);
//		permissions.put(CHESSProfileManager.REQUIREMENT_VIEW,
//				ViewPermissions.requirementViewPL);
//		permissions.put(CHESSProfileManager.RT_ANALYSIS_VIEW,
//				ViewPermissions.RTAnalysisViewViewPL);
//		permissions.put(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW,
//				ViewPermissions.DependabilityAnalysisViewPL);
		
		permissions.put(CHESSProfileManager.COMPONENT_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.ANALYSIS_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.DEPLOYMENT_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.REQUIREMENT_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.RT_ANALYSIS_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.DEPENDABILITY_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.RAILWAY_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.SYSTEM_VIEW,
				new HashMap<String, PermissionList>());
		permissions.put(CHESSProfileManager.PSM_VIEW,
				new HashMap<String, PermissionList>());
	}	
	
	static{
		initializeLists();
		CHESSProjectSupport.printlnToCHESSConsole("Load permissions...");
		readXMLPermissions();
		CHESSProjectSupport.printlnToCHESSConsole("Permissions loaded.");
//		//The allowAll policy should last until a list of actual permission is specified
//		componentViewPL.add(allowAll);
//		extraFunctionalViewPL.add(allowAll);
//		deploymentViewPL.add(allowAll);
//		analysisViewPL.add(allowAll);
//		requirementViewPL.add(allowAll);
//		RTAnalysisViewViewPL.add(allowAll);
//		DependabilityAnalysisViewPL.add(allowAll);
//		
//		//Examples
//		componentViewPL.add(new PermissionEntry(new EntryId("Package", ANY, ANY), true, true, true));
//		componentViewPL.add(new PermissionEntry(new EntryId(ANY, ANY, ANY), true, true, true));
//		componentViewPL.add(new PermissionEntry(new EntryId(ANY, ANY, "Operation"), true, true, true));
//		componentViewPL.add(new PermissionEntry(new EntryId(ANY, ANY, "Property"), true, true, true));
//		componentViewPL.add(new PermissionEntry( new EntryId(ANY, "CHRtSpecification", "relativePriority"), true, false, true));
	}
	
	
	static void readXMLPermissions(){
	    try {

	    	URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path("permissions.xml"), null);
	    	url = FileLocator.toFileURL(url);
	    	URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), null);
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(uri));

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            NodeList listOfViews = doc.getElementsByTagName("view");

            for(int s=0; s<listOfViews.getLength() ; s++){
                Node view = listOfViews.item(s);
                if(view.getNodeType() == Node.ELEMENT_NODE){
                    parseViewNode(view);
                }
            }

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(' ' + err.getMessage());
			
			CHESSProjectSupport.printlnToCHESSConsole("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			CHESSProjectSupport.printlnToCHESSConsole(' ' + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace(CHESSProjectSupport.CHESS_CONSOLE_STREAM);
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace(CHESSProjectSupport.CHESS_CONSOLE_STREAM);
			t.printStackTrace();
		}
	}


	private static void parseViewNode(Node view) {
		
		NodeList permList = ((Element)view).getElementsByTagName("diagram");
		String viewName = ((Element)view).getAttribute("name");
		for (int i=0; i<permList.getLength(); i++){
			Node dg = permList.item(i);
			if(dg.getNodeType() == Node.ELEMENT_NODE){
				PermissionList list = parseDiagramNode(dg);
//				PermissionEntry p = createPermission((Element) perm);
//				permissions.get(((Element)view).getAttribute("name")).add(p);
				
				String dgName = ((Element)dg).getAttribute("name");
				addDiagramPermissions(viewName, dgName, list);
			}
		}
//		NodeList permList = ((Element)view).getElementsByTagName("perm");
//		for (int i=0; i<permList.getLength(); i++){
//			Node perm = permList.item(i);
//			if(perm.getNodeType() == Node.ELEMENT_NODE){
//				PermissionEntry p = createPermission((Element) perm);
//				permissions.get(((Element)view).getAttribute("name")).add(p);
//			}
//		}
	}
	
	private static void addDiagramPermissions(String view, String dg,
			PermissionList list) {
		permissions.get(view).put(dg, list);
	}


	private static PermissionList parseDiagramNode(Node dg) {
		NodeList permList = ((Element)dg).getElementsByTagName("perm");
		PermissionList list = new PermissionList();
		for (int i=0; i<permList.getLength(); i++){
			Node perm = permList.item(i);
			if(perm.getNodeType() == Node.ELEMENT_NODE){
				PermissionEntry p = createPermission((Element) perm);
				list.add(p);
//				permissions.get(((Element)view).getAttribute("name")).add(p);
			}
		}
		return list;
	}

	private static PermissionEntry createPermission(Element perm) {
		String id1 = parseIdValue(perm.getAttribute(EntryId.TYPE_ATR));
		String id2 = parseIdValue(perm.getAttribute(EntryId.STEREOTYPE_ATR));
		String id3 = parseIdValue(perm.getAttribute(EntryId.FEATURE_ATR));
		EntryId id = new EntryId(id1, id2, id3);
		boolean o = parsePermissionRight(perm.getAttribute(PermissionEntry.OWNER_ATR));
		boolean w = parsePermissionRight(perm.getAttribute(PermissionEntry.WRITE_ATR));
		boolean v = parsePermissionRight(perm.getAttribute(PermissionEntry.VISIBLE_ATR));
		
		return new PermissionEntry(id, o, w, v);
	}

	private static boolean parsePermissionRight(String attr) {
		if (attr.equalsIgnoreCase("true"))
			return true;
		// if (attr.isEmpty() || attr.equalsIgnoreCase("false"))
		return false;
	}

	private static String parseIdValue(String attr) {
		if (attr.equals("-"))
			return NONE;
		if (attr.isEmpty() || attr.equals("*"))
			return ANY;
		return attr;
	}
}
