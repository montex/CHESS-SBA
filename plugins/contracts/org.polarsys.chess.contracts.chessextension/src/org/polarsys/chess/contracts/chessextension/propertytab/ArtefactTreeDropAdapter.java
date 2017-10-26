package org.polarsys.chess.contracts.chessextension.propertytab;


import org.eclipse.emf.cdo.transfer.ui.TransferDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.opencert.evm.evidspec.evidence.Artefact;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
/**
 * Supports dropping gadgets into a tree viewer.
 */
public class ArtefactTreeDropAdapter extends TransferDropAdapter {
	
	private Class contract;
	
	public static int SUPPORTEDBY = 0;
	public static int INCONTEXTOF = 1;
	
	private int feature = -1;
	
   public ArtefactTreeDropAdapter(TableViewer claimViewer, int feature) {
      super(claimViewer);
      this.feature = feature;
   }
   
   public void setContractClass(Class contract){
	   this.contract = contract;
   }
   
  
   protected boolean performDrop(Object data, Object target){
	   super.performDrop(data, target);
	return false;
	   
   }
   
   
   /**
    * Method declared on ViewerDropAdapter
    */
   public boolean performDrop(Object data) {
	   
	   Object selection = ((TreeSelection) data).getPaths()[0].getLastSegment();
	   
	   if (!(selection instanceof Artefact))
		   return false;
	   final Artefact artefact = (Artefact) selection;
	   
	   
	   PapyrusMultiDiagramEditor editor = BlockEditPartOpenCertSection.getEditor();
		if (editor != null){ 

				TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						Stereotype stereo = contract.getAppliedStereotype(BlockEditPartSection.CONTRACT);
					   Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
					   if (feature == SUPPORTEDBY)
						   contractStereo.getSupportedBy().add(artefact);

					}
					
				});
		}
	  ((TableViewer) this.getViewer()).add(artefact);
      return true;
   }
   /**
    * Method declared on ViewerDropAdapter
    */
   public boolean validateDrop(Object target, int op, TransferData type) {
      return true;
   }
}