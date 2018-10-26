package org.polarsys.chess.cdo.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
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
import org.polarsys.chess.cdo.dialogs.CDOExportDialog;

public class CDOExportHandler extends AbstractHandler {
	
	private String errorMsg = "";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		if(window != null){
			Shell shell = window.getShell();
			
			//Show a dialog with a list of all the CHESS projects in the workspace and 
			//and a list of the CDO folders (from the configured CDO repo).
			//get the selected project and CDO folder and perform the copy from workspace to CDO.
			CDOExportDialog dialog = null;
			try{
				dialog = new CDOExportDialog(shell);
			}catch (Exception e){
				MessageDialog.openError(shell, "Export CHESS Project to CDO", "Error: " + e.getMessage());
			}

			if(dialog != null && dialog.open() == Window.OK){
				CDOResourceFolder cdoFolder = dialog.getSelectedCDOFolder();
				IProject chessProject = dialog.getSelectedCHESSProject();
				if(cdoFolder != null && chessProject != null){
					CDOTransaction transaction = dialog.getTransaction();
					try{
						String filepath = chessProject.getLocation().toString();
						CDOTransferElement source = FileSystemTransferSystem.INSTANCE.getElement(new Path(filepath));

						CDOTransferSystem target = new RepositoryTransferSystem(transaction);
						CDOTransfer transfer = new CDOTransfer(source.getSystem(), target);

						CDOTransferMapping mapping = transfer.map(filepath, new NullProgressMonitor());
						mapping.setRelativePath(cdoFolder.getPath() + "/" + chessProject.getName());
						transfer.perform();

						transaction.commit();
						transaction.close();
					} catch (Exception e) {
						e.printStackTrace();
						errorMsg = e.getMessage();
					}
				}
			}
			if(errorMsg != null && !errorMsg.isEmpty()){
				MessageDialog.openError(shell, "Export CHESS Project to CDO", "Error: " + errorMsg);
				errorMsg = "";
			}
		}
		return null;
	}

}
