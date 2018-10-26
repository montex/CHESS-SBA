package org.polarsys.chess.cdo.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.cdo.dawn.preferences.PreferenceConstants;
import org.eclipse.emf.cdo.dawn.util.connection.CDOConnectionUtil;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.chess.cdo.dialogs.utils.DialogUtil;
import org.polarsys.chess.cdo.providers.CDOResourceListLabelProvider;
import org.polarsys.chess.cdo.providers.CHESSProjectListLabelProvider;

public class CDOExportDialog extends TitleAreaDialog {
	
	private static final String CHESS_NATURE = "org.polarsys.chess.CHESSNature";
	private ComboViewer chessModelsCombo;
	private ComboViewer cdoFoldersCombo;
	private CDOView view;
	private CDOTransaction transaction;
	
	private IProject selectedCHESSProject;
	private CDOResourceFolder selectedCDOFolder;


	public CDOExportDialog(Shell shell) throws Exception{
		super(shell);
		CDOConnectionUtil.instance.init(
				//TODO These three lines should be kept if the preference page is available
				PreferenceConstants.getRepositoryName(),
				PreferenceConstants.getProtocol(),
				PreferenceConstants.getServerName()
//				"repo",
//				"tcp",
//				"localhost"
				);
		CDOSession session = CDOConnectionUtil.instance.openSession();
		transaction = CDOConnectionUtil.instance.openTransaction(session);
		view = CDOConnectionUtil.instance.openView(session);
	}
	
	
	@Override
    public void create() {
		setHelpAvailable(false);
        super.create();
        setTitle("Export CHESS project to CDO");
        setMessage("Select CHESS project and CDO folder and click OK to perform the export", IMessageProvider.INFORMATION);
    }
	
	@Override
	protected Control createDialogArea(Composite parent) { 
		parent.setLayout(new GridLayout(2, false));
		
		Label chessModelsLabel = new Label(parent, SWT.NONE);
		chessModelsLabel.setText("Select a CHESS project: ");
		
		chessModelsCombo = new ComboViewer(parent, SWT.NONE);
		chessModelsCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		chessModelsCombo.setContentProvider(new ArrayContentProvider());
		chessModelsCombo.setLabelProvider(new CHESSProjectListLabelProvider());
		
		
		Label cdoFoldersLabel = new Label(parent, SWT.NONE);
		cdoFoldersLabel.setText("Select the target CDO Folder: ");
		
		cdoFoldersCombo = new ComboViewer(parent, SWT.NONE);
		cdoFoldersCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		cdoFoldersCombo.setContentProvider(new ArrayContentProvider());
		cdoFoldersCombo.setLabelProvider(new CDOResourceListLabelProvider());
		
		addCHESSModelsFromWorkspace();
		addCDOFoldersFromRepository();
		
		return super.createDialogArea(parent);

	}
	
	private void addCDOFoldersFromRepository() {
		
		List<CDOResourceFolder> folderList = DialogUtil.getAllFolders(view);
		
		cdoFoldersCombo.setInput(folderList.toArray());
		cdoFoldersCombo.setComparator(new ViewerComparator() {
			public int compare(
					Viewer viewer, Object c1, Object c2) {
				return ((CDOResourceFolder) c1).getPath().compareToIgnoreCase(((CDOResourceFolder) c2).getPath());
			}
		});
	}


	private void addCHESSModelsFromWorkspace() {
		List<IProject> chessProjects = new ArrayList<>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(IProject project : projects){
			try {
				if(project.isOpen() && project.hasNature(CHESS_NATURE)){
					chessProjects.add(project);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		chessModelsCombo.setInput(chessProjects.toArray());
		chessModelsCombo.setComparator(new ViewerComparator() {
			public int compare(
					Viewer viewer, Object c1, Object c2) {
				return ((IProject) c1).getName().compareToIgnoreCase(((IProject) c2).getName());
			}
		});
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
    protected void okPressed() {
		IProject chessProject = (IProject)((IStructuredSelection)chessModelsCombo.getSelection()).getFirstElement();
		CDOResourceFolder cdoFolder = (CDOResourceFolder)((IStructuredSelection)cdoFoldersCombo.getSelection()).getFirstElement();
		if(chessProject == null || cdoFolder == null){
			setMessage("Please select CHESS model and CDO Folder!", IMessageProvider.ERROR);
		}else{
			setSelectedCHESSProject(chessProject);
			setSelectedCDOFolder(cdoFolder);
			super.okPressed();
		}
    }


	public IProject getSelectedCHESSProject() {
		return selectedCHESSProject;
	}


	public void setSelectedCHESSProject(IProject selectedCHESSProject) {
		this.selectedCHESSProject = selectedCHESSProject;
	}


	public CDOResourceFolder getSelectedCDOFolder() {
		return selectedCDOFolder;
	}


	public void setSelectedCDOFolder(CDOResourceFolder selectedCDOFolder) {
		this.selectedCDOFolder = selectedCDOFolder;
	}


	public CDOTransaction getTransaction() {
		return transaction;
	}

}
