package org.polarsys.chess.cdo.handlers;

import java.io.File;
import java.net.URI;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.spi.transfer.FileSystemTransferSystem;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transfer.CDOTransfer;
import org.eclipse.emf.cdo.transfer.CDOTransferElement;
import org.eclipse.emf.cdo.transfer.CDOTransferMapping;
import org.eclipse.emf.cdo.transfer.CDOTransferSystem;
import org.eclipse.emf.cdo.transfer.spi.repository.RepositoryTransferSystem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.cdo.dialogs.CDOImportDialog;
import org.polarsys.chess.core.util.CHESSProjectSupport;

public class CDOImportHandler extends AbstractHandler {
	
	private String errorMsg = "";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		if(window != null){
			Shell shell = window.getShell();
			
			//Show a dialog with a list of all the CHESS projects in the configured CDO. 
			//get the selected CDO project and the entered name for the project (default same name?)
			//perform the copy from CDO to workspace.
			CDOImportDialog dialog = null;
			try{
				dialog = new CDOImportDialog(shell);
			}catch (Exception e){
				MessageDialog.openError(shell, "Import CHESS Project from CDO", "Error: " + e.getMessage());
			}

			if(dialog != null && dialog.open() == Window.OK){
				CDOResourceFolder chessProjectCDO = dialog.getSelectedCHESSProjectCDO();
				String projectName = dialog.getNewProjectName();
				if(chessProjectCDO != null && projectName != null){

					//create new CHESS project (if not already there)
					try{
						IProject chessProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
						if(chessProject == null || !chessProject.exists()){
							IPath workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation();
							URI location = URI.create(workspaceLocation + "/" + projectName);
							chessProject=CHESSProjectSupport.createProject(projectName, null);
						}else if(!chessProject.isOpen()){
							chessProject.open(new NullProgressMonitor());
						}

						CDOTransaction transaction = dialog.getTransaction();
						
						String filepath = chessProject.getLocation().toString();
//						System.out.println(filepath.toString());
						//ugly workaround to get relative path -- TODO: will it ever work on windows as well?
						filepath = filepath.substring(System.getProperty("user.home").length()+1);
//						System.out.println(filepath.toString());
						
						CDOTransferSystem source = new RepositoryTransferSystem(transaction);
						CDOTransferElement target = FileSystemTransferSystem.INSTANCE.getElement(chessProject.getLocation());

						CDOTransfer transfer = new CDOTransfer(source, target.getSystem());

						for(CDOResourceNode node : chessProjectCDO.getNodes()){
							if(!node.getName().equals(".project")){
								CDOTransferMapping mapping = transfer.map(node.getPath(), new NullProgressMonitor());
								mapping.setRelativePath(filepath + File.separator + node.getName());
								transfer.perform();
							}
						}
						transaction.commit();
						transaction.close();
						
					} catch (Exception e) {
						e.printStackTrace();
						errorMsg = e.getMessage();
					}
				}
			}
			if(errorMsg != null && !errorMsg.isEmpty()){
				MessageDialog.openError(shell, "Import CHESS Project from CDO", "Error: " + errorMsg);
				errorMsg = "";
			}
		}
		return null;

	}
}
