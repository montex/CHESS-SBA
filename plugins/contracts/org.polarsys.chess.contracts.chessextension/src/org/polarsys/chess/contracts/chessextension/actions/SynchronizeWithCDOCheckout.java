package org.polarsys.chess.contracts.chessextension.actions;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.internal.resources.File;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class SynchronizeWithCDOCheckout implements IObjectActionDelegate {
	
	private File sel = null;
	private String checkoutId = "0";

	@Override
	public void run(IAction action) {
				
		InputDialog dialog = new InputDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "SynchronizeWithCDOCheckout", "CDOCheckoutID", "", null);
		
		if (dialog.open() == Window.OK) {
			checkoutId = dialog.getValue();
	    } else {
	        return;
	    }
	   
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Document doc = dBuilder.parse(sel.getLocationURI().toString());
			doc.getDocumentElement().getElementsByTagName("Contract");
			if (doc.hasChildNodes()) {

				fixCDOCheckoutID(doc.getChildNodes());

			}
			
			
			// Use a Transformer for output
		    TransformerFactory tFactory =
		    TransformerFactory.newInstance();
		    Transformer transformer =  tFactory.newTransformer();

		    java.io.File jfile = new java.io.File(sel.getLocation().toString());
		    DOMSource source = new DOMSource(doc);
		    StreamResult result = new StreamResult(jfile);
		    transformer.transform(source, result);
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
		try{
			TreeSelection treeSel = (TreeSelection) selection;
			File file = (File) treeSel.getFirstElement();
			sel = file;
		}catch (Exception ex){
			
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}
	
	private void fixCDOCheckoutID(NodeList nodeList) {

	    for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
	
				if (tempNode.hasAttributes()) {
	
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					String value = "";
					for (int i = 0; i < nodeMap.getLength(); i++) {
	
						Node node = nodeMap.item(i);
						if (node.getNodeName().equals("href")){
							value = node.getNodeValue();
							if (value.contains("cdo.checkout")){
								value = value.replaceFirst("\\/\\/[0-9]", "//"+checkoutId);
								node.setNodeValue(value);
							}
						}
	
					}
				}
	
				if (tempNode.hasChildNodes()) {
	
					// loop again if has child nodes
					fixCDOCheckoutID(tempNode.getChildNodes());
	
				}
	
			}
	    }
	}
	

}
