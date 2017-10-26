package org.polarsys.chess.contracts.chessextension.propertytab;

import java.util.Vector;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.impl.CDOResourceImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

public class Utils {

	static void selectCDOObjectInProjectExplorer(EObject obj){
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
		
		Object[] arr = getCDOTreeObject(obj);

		TreePath path = new TreePath(arr);
		TreeSelection tsel = new TreeSelection(path);
		
		((org.eclipse.ui.part.ISetSelectionTarget)view).selectReveal(tsel);
		
		for (int i=0;  i<arr.length; i++){
			selectObjectInProjectExplorer(obj);
		}
    }
	
	
	private static Object[] getCDOTreeObject(EObject obj){
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
		
		ProjectExplorer projectExplorer = (ProjectExplorer) view;
		
		Vector<Object> v = new Vector<Object>();
		
		v.add(0, getTreeObject(projectExplorer,obj));
		
		while (obj.eContainer() != null){
			v.add(0,getTreeObject(projectExplorer,obj.eContainer()));
			obj = obj.eContainer();
		}
		
		CDOResourceImpl cdores = ((CDOResourceImpl) (obj.eResource()));
		v.add(0,getTreeObject(projectExplorer,cdores));
		CDOResourceFolder folder = cdores.getFolder();
		v.add(0,getTreeObject(projectExplorer,folder));
		while (folder.getFolder() != null){
			folder = folder.getFolder();
			v.add(0,getTreeObject(projectExplorer,folder));
		}
		v.add(0, (folder.cdoDirectResource()).eAdapters().get(0));
		

		Object[] arr = new Object[v.size()];
		v.copyInto(arr);
		return arr;
		
	}
	
	private static void selectObjectInProjectExplorer(EObject obj){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
		
		Object[] arr = getCDOTreeObject(obj);

		TreePath path = new TreePath(arr);
		TreeSelection tsel = new TreeSelection(path);
		
		((org.eclipse.ui.part.ISetSelectionTarget)view).selectReveal(tsel);
		
    }
	
	private static Object getTreeObject(ProjectExplorer projectExplorer, EObject obj){
	    
		Tree tree = projectExplorer.getCommonViewer().getTree();
		TreeItem[] treeItem = tree.getItems();
		TreeItem item = null;
		Object obj2 = null;
		for (int i=0; i<treeItem.length; i++){
			item = treeItem[i];
			obj2= checkTreeItem(item, obj);
			if (obj2!= null)
				return obj2;
		}
		return obj;
    }
    
    private static Object checkTreeItem(TreeItem item, EObject obj){
    	if (item.getData()!= null && item.getData().toString().equals(obj.toString()))
			return item.getData();
    	TreeItem tempItem = null;
    	TreeItem[] temptreeItem = item.getItems();
    	Object tempObj = null;
    	for (int i=0; i<temptreeItem.length; i++){
    		tempItem = temptreeItem[i];
    		tempObj=checkTreeItem(tempItem, obj);
    		if (tempObj != null)
    			return tempObj;
		}
    	return null;
    }
	
    public static String getPathStringFor(EObject obj){
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						
		Vector<String> v = new Vector<String>();
		
		//v.add(0, obj.toString());
		
		
		while (obj.eContainer() != null){
			//v.add(0,obj.eContainer().toString());
			obj = obj.eContainer();
		}
		
		CDOResourceImpl cdores = ((CDOResourceImpl) (obj.eResource()));
		v.add(0,cdores.getName());
		CDOResourceFolder folder = cdores.getFolder();
		if (folder != null){
			v.add(0,folder.getName());
			while (folder.getFolder() != null){
				folder = folder.getFolder();
				v.add(0,folder.getName());
			}
		}
		
		String s = "";
		
		for (Object t : v.toArray()){
			s+="."+((String)t);
		}
		return s.substring(1);
    }
}
