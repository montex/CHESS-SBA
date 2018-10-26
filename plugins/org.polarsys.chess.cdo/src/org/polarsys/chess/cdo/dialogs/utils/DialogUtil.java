package org.polarsys.chess.cdo.dialogs.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;

public class DialogUtil {

	public static List<CDOResourceFolder> getAllFolders(CDOView view) {
		
		List<CDOResourceFolder> folderList = new ArrayList<>();
		
		CDOResourceNode[] cdoElements = view.getElements(); 
		for(CDOResourceNode cdoElem : cdoElements){
			if(cdoElem instanceof CDOResourceFolder){
				CDOResourceFolder cdoFolder = (CDOResourceFolder)cdoElem;
				folderList.add(cdoFolder);
				//check for subfolders
				EList<CDOResourceNode> subNodes = cdoFolder.getNodes();
				folderList = getSubFolders(subNodes,folderList);
			}
		}
		
		return folderList;
	}

	private static List<CDOResourceFolder> getSubFolders(EList<CDOResourceNode> nodes, List<CDOResourceFolder> folderList) {
		for(CDOResourceNode cdoElem : nodes){
			if(cdoElem instanceof CDOResourceFolder){
				CDOResourceFolder cdoFolder = (CDOResourceFolder)cdoElem;
				folderList.add(cdoFolder);
				//check for subfolders
				EList<CDOResourceNode> subNodes = cdoFolder.getNodes();
				folderList = getSubFolders(subNodes,folderList);
			}
		}
		return folderList;
	}
}
