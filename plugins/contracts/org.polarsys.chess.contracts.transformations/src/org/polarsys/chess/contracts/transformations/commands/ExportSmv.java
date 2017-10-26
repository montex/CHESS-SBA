package org.polarsys.chess.contracts.transformations.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentType;
import org.polarsys.chess.contracts.transformations.main.GenerateErrorModel;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;

public class ExportSmv extends AbstractHandler{

	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell activeShell = window.getShell();

		final Class selected = getSelection(window);
		if(selected != null){

			FileDialog dialog = new FileDialog(activeShell,SWT.SAVE);
			dialog.setFilterNames(new String[] { "SMV" });
			dialog.setFilterExtensions(new String[] { "*.smv" }); 
	                                   
			String dir = dialog.open();
			if(dir != null){
				final File targetDir = (new File(dialog.getFilterPath()));

				String systemQN = selected.getQualifiedName();
				final List<String> args = new ArrayList<String>();
				args.add(systemQN);
				String systemName = systemQN.substring(systemQN.lastIndexOf("::")+2);
				args.add(systemName);
				args.add(dialog.getFileName().replaceFirst(".smv", ""));

				Job job = new Job("Exporting to SMV"){

					@Override
					protected IStatus run(IProgressMonitor monitor) {

						monitor.beginTask("operation in progress ...", 3);
						try{
							monitor.subTask("transforming...");

							GenerateErrorModel gen = new GenerateErrorModel(selected, targetDir, args);
							gen.doGenerate(null);
							monitor.worked(1);

						}catch (IOException e) {
							e.printStackTrace();
						} 
						monitor.done();
						if (monitor.isCanceled())
							return Status.CANCEL_STATUS;
						return Status.OK_STATUS;
					}
				};

				job.setUser(true);
				job.setPriority(Job.SHORT);
				job.schedule();
			}else{
				return null;
			}
		}
		ResourceNotification.showOk("Element exported correctly");
		return null;

	}

	private Class getSelection(IWorkbenchWindow window ) {
		ISelectionService selectionService = window.getSelectionService();
		ISelection selectionX = selectionService.getSelection();
		if (!(selectionX instanceof ITreeSelection)){
			ResourceNotification.showOk("Selection not valid: select a single resource on the ModelExplorer");
			return null;
		}
		ITreeSelection treesel = (ITreeSelection)selectionX;
		if (treesel.getPaths().length == 0 ||  treesel.getPaths().length > 1){
			ResourceNotification.showError("Selection not valid: select a single resource on the ModelExplorer");
			return null;
		}

		Object obj = treesel.getFirstElement();
		if (!(obj instanceof EObjectTreeElement)){
			ResourceNotification.showError("Selection not valid: select a single resource on the ModelExplorer");
		}
		EObject eobj = ((EObjectTreeElement) obj).getEObject();
		final Package view = ViewUtils.getView(eobj);

		//		final Model umlModel = view.getModel();
		final Class umlClass = (Class) eobj;

		if (!ViewUtils.isDesignView(view, CHESSProfileManager.SYSTEM_VIEW) &&
				!ViewUtils.isDesignView(view, CHESSProfileManager.COMPONENT_VIEW)) {
			ResourceNotification.showError("Selection not valid: please select a resource of the SystemView or of the ComponentView");
			return null;
		}

		if (ViewUtils.isDesignView(view, CHESSProfileManager.COMPONENT_VIEW)){
			if (UMLUtils.getStereotypeApplication(umlClass, ComponentType.class)!= null){
				ResourceNotification.showError("Selection not valid: ComponentType");
				return null;
			}
		}

		return umlClass;
	}

}
