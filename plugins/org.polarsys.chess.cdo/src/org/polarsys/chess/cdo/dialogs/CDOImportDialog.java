package org.polarsys.chess.cdo.dialogs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.common.lob.CDOBlob;
import org.eclipse.emf.cdo.dawn.preferences.PreferenceConstants;
import org.eclipse.emf.cdo.dawn.util.connection.CDOConnectionUtil;
import org.eclipse.emf.cdo.eresource.CDOBinaryResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.chess.cdo.dialogs.utils.DialogUtil;
import org.polarsys.chess.cdo.providers.CDOResourceListLabelProvider;

public class CDOImportDialog extends TitleAreaDialog {
	
	private CDOView view;
	private CDOTransaction transaction;
	private ComboViewer cdoCHESSProjectsCombo;
	private Text projectNameText;
	
	private String newProjectName;
	private CDOResourceFolder selectedCHESSProjectCDO;

	public CDOImportDialog(Shell shell) {
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
        setTitle("Import CHESS project from CDO");
        setMessage("Select a CHESS project from the CDO repository. Enter the project name and click OK to perform the import", IMessageProvider.INFORMATION);
    }
	
	@Override
	protected Control createDialogArea(Composite parent) { 
		parent.setLayout(new GridLayout(2, false));
		
		Label chessModelsLabel = new Label(parent, SWT.NONE);
		chessModelsLabel.setText("Select a CHESS project: ");
		
		cdoCHESSProjectsCombo = new ComboViewer(parent, SWT.NONE);
		cdoCHESSProjectsCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		cdoCHESSProjectsCombo.setContentProvider(new ArrayContentProvider());
		cdoCHESSProjectsCombo.setLabelProvider(new CDOResourceListLabelProvider());
		ISelectionChangedListener listener = new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				String text = cdoCHESSProjectsCombo.getCombo().getText();
				text = text.substring(text.lastIndexOf(File.separator)+1);
				projectNameText.setText(text);
			}
		};
		
		cdoCHESSProjectsCombo.addSelectionChangedListener(listener);
		
		Label cdoFoldersLabel = new Label(parent, SWT.NONE);
		cdoFoldersLabel.setText("Enter the Project Name: ");
		projectNameText = new Text(parent, SWT.BORDER);
		projectNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		projectNameText.setText("");
		
		addCHESSProjectsFromCDORepository();
		
		return super.createDialogArea(parent);
	}
	
	private void addCHESSProjectsFromCDORepository() {
		List<CDOResourceFolder> folderList = DialogUtil.getAllFolders(view);
		List<CDOResourceFolder> chessProjectsCDO = new ArrayList<>();
		
		for(CDOResourceFolder folder : folderList){
//			System.out.println(folder.getName());
			EList<CDOResourceNode> nodes = folder.getNodes();
			for(CDOResourceNode node : nodes){
//				System.out.println("--> " + node.toString());
				if(node instanceof CDOBinaryResource && node.getName().equals(".project")){
					CDOBinaryResource projectRes = (CDOBinaryResource) node;
					CDOBlob contents = projectRes.getContents();
//					System.out.println("----> " + contents.toString());
					if(contents != null){
						try {
							InputStream is = contents.getContents();
							ByteArrayOutputStream result = new ByteArrayOutputStream();
							byte[] buffer = new byte[(int) contents.getSize()];
							int length;
							while ((length = is.read(buffer)) != -1) {
								result.write(buffer, 0, length);
							}
							String contentsAsString =  result.toString("UTF-8");
							//						System.out.println("------------> " + contentsAsString);
							if (contentsAsString.contains("org.polarsys.chess.CHESSNature")){
								chessProjectsCDO.add(folder);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		cdoCHESSProjectsCombo.setInput(chessProjectsCDO.toArray());
		cdoCHESSProjectsCombo.setComparator(new ViewerComparator() {
			public int compare(
					Viewer viewer, Object c1, Object c2) {
				return ((CDOResourceFolder) c1).getPath().compareToIgnoreCase(((CDOResourceFolder) c2).getPath());
			}
		});
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
    protected void okPressed() {
		CDOResourceFolder cdoCHESSFolder = (CDOResourceFolder)((IStructuredSelection)cdoCHESSProjectsCombo.getSelection()).getFirstElement();
		String projectName = projectNameText.getText();
		if(cdoCHESSFolder == null || projectName == null || projectName.isEmpty()){
			setMessage("Please select CHESS project (from CDO) and enter the name of the new project!", IMessageProvider.ERROR);
		}else{
			setNewProjectName(projectName);
			setSelectedCHESSProjectCDO(cdoCHESSFolder);
			super.okPressed();
		}
	}
	
	public CDOResourceFolder getSelectedCHESSProjectCDO() {
		return selectedCHESSProjectCDO;
	}

	public void setSelectedCHESSProjectCDO(CDOResourceFolder selectedCHESSProjectCDO) {
		this.selectedCHESSProjectCDO = selectedCHESSProjectCDO;
	}

	public String getNewProjectName() {
		return newProjectName;
	}

	public void setNewProjectName(String newProjectName) {
		this.newProjectName = newProjectName;
	}

	public CDOTransaction getTransaction() {
		return transaction;
	}

}
