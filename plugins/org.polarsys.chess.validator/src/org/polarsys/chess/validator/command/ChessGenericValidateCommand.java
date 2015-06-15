package org.polarsys.chess.validator.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;
import org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.chess.validator.command.util.ChessGenericDiagnostician;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessGenericValidateCommand.
 * @see org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand
 */
public class ChessGenericValidateCommand extends AbstractValidateCommand {
	
	/** The plugin ids. */
	public Collection<String> pluginIds;
	
	/**
	 * Instantiates a new ChessGenericValidateCommand.
	 *
	 * @param label the label
	 * @param pluginId the plugin id
	 * @param selectedElement the selected element
	 */
	public ChessGenericValidateCommand(String label, String pluginId, EObject selectedElement) {
		super(label, TransactionUtil.getEditingDomain (selectedElement), selectedElement);
		this.pluginIds = new ArrayList<String>();
		this.pluginIds.add(pluginId);
	}

	/**
	 * Instantiates a new ChessGenericValidateCommand.
	 *
	 * @param label the label
	 * @param pluginIds the list of plugin ids
	 * @param selectedElement the selected element
	 */
	public ChessGenericValidateCommand(String label,
			Collection<String> pluginIds, EObject selectedElement) {
		super(label, TransactionUtil.getEditingDomain (selectedElement), selectedElement);
		this.pluginIds = new ArrayList<String>();
		
		for (String id : pluginIds) {
			this.pluginIds.add(id);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
		IAdaptable arg1) throws ExecutionException {

		//System.err.println("ChessGenericValidationCommand : doExecuteWithResult");
	
		// replace selection by model instead of current selection
		while (selectedElement.eContainer() != null) {
			selectedElement = selectedElement.eContainer ();
		}
	
		runValidation (selectedElement);
	
		// Try to retrieve all markers on the file
		Resource resource = selectedElement.eResource();
		if (resource != null) {
		
			IPath path = new Path(resource.getURI().toPlatformString (false));
			IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = wsRoot.getFile(path);
		
			try {
				processMarkers(file);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	
		return null;
	}

	/**
	 * This simply execute the command.
	 *
	 * @param progressMonitor the progress monitor
	 * @param validateElement the validate element
	 * @return the diagnostic
	 */
	@Override
	protected Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement)
	{
		//System.err.println("This is the ChessGenericValidationCommand Override for validate(IProgressMonitor,EObject) from AbstractValidateCommand");
		
		int count = 0;
		for (Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
			++count;
		}

		progressMonitor.beginTask("", count);

		// validate only error severity and worse
		IConstraintFilter constraintFilter = new IConstraintFilter() {
			@Override
			public boolean accept(IConstraintDescriptor constraint, EObject target) {
				// Check only constraints defined in the plugin using this generic command
				//System.err.println("Evaluating constraint " + constraint.getName()+ " provided by " + constraint.getPluginId());
				return pluginIds.contains(constraint.getPluginId());
			}
		};
		
		AdapterFactory adapterFactory = 
			domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
		ChessGenericDiagnostician diagnostician = createChessGenericDiagnostician(adapterFactory, progressMonitor, constraintFilter);
	    
		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
		Map<Object, Object> context = diagnostician.createDefaultContext();
		
		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object [] {diagnostician.getObjectLabel(validateElement)}));
		diagnostician.validate(validateElement, diagnostic, context);
		
		return diagnostic;
	}

	
	//@Override
	/**
	 * Creates the ChessGenericDiagnostician.
	 *
	 * @param adapterFactory the adapter factory
	 * @param progressMonitor the progress monitor
	 * @param filter the filter
	 * @return the ChessGenericDiagnostician
	 */
	protected ChessGenericDiagnostician createChessGenericDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor, final IConstraintFilter filter)
	{
		return new ChessGenericDiagnostician(filter) {
			@Override
	        public String getObjectLabel(EObject eObject) {
				if (adapterFactory != null && !eObject.eIsProxy())
				{
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if (itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}
	  
		};
		
		
	}

	
	/**
	 * Process the markers
	 *
	 * @param resource the resource
	 * @throws CoreException the core exception
	 */
	static protected void processMarkers(IResource resource) throws CoreException {
		
		//System.err.println("processMarkers for resource " + resource.getName());
		
    	IMarker[] markers = resource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
    	Collection<IMarker> markersToDelete = new ArrayList<IMarker>();
    	
    	
    	for (int index = 0; index < markers.length; index++ ) {
    		
    		IMarker currentMarker = markers[index];
    		//String currentMessage = ((String) currentMarker.getAttribute("message")).replace("\n", "");
    		//System.err.println("message:" + currentMessage);
    		
    		if (currentMarker.getAttributes().containsKey("relatedURIs")) {
    			markersToDelete.add(currentMarker);
    		}
    	}
    	
    	for (IMarker marker : markersToDelete) {
    		marker.delete();
       	}
    	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand#handleDiagnostic(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.emf.common.util.Diagnostic, org.eclipse.emf.ecore.EObject, org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void handleDiagnostic(IProgressMonitor monitor, Diagnostic diagnostic, final EObject validateElement, final Shell shell){
		Resource resource = getValidationResource();
		if (resource != null) {
			if (selectedElement != null) {
				ValidationTool vt = new ValidationTool(selectedElement);
				vt.deleteSubMarkers();
			}
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				// We have to filter on the source
				if (pluginIds.contains(childDiagnostic.getSource())) {
					MarkerListenerUtils.eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
					//if we create at least one marker report it
				}
			}
		}
	}
	
}
