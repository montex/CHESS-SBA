package org.polarsys.chess.contracts.chessextension.propertytab;

import org.eclipse.emf.cdo.transfer.ui.TransferDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.opencert.sam.arg.arg.Claim;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
/**
 * Supports dropping gadgets into a tree viewer.
 */
public class ClaimTreeDropAdapter extends TransferDropAdapter {
	
	private Class contract;
	private Constraint constraint;
	private TreeSelection myselection;
	
   public ClaimTreeDropAdapter(TableViewer claimViewer) {
      super(claimViewer);
   }
   
   public void setContractClass(Class contract){
	   this.contract = contract;
   }
   
   public void setConstraint(Constraint constraint){
	   this.constraint = constraint;
   }
   
  
   protected boolean performDrop(Object data, Object target){
	   super.performDrop(data, target);
	return false;
	   
   }
   
   
   public TreeSelection getMySelection(){
	   return myselection;
   }
   
   /**
    * Method declared on ViewerDropAdapter
    */
   public boolean performDrop(Object data) {
	   
	   Object selection = ((TreeSelection) data).getPaths()[0].getLastSegment();
	   myselection = (TreeSelection) data;
	   
	   if (!(selection instanceof Claim))
		   return false;
	   final Claim claim = (Claim) selection;
	   
	   
	   PapyrusMultiDiagramEditor editor = BlockEditPartOpenCertSection.getEditor();
		if (editor != null){ 

				TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						if (contract != null) {
							Stereotype stereo = contract.getAppliedStereotype(BlockEditPartSection.CONTRACT);
							Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
							contractStereo.getClaim().add(claim);
						}
						if (constraint != null){
							Stereotype stereo =constraint.getAppliedStereotype(FormalPropertyEditPartSection.FORMAL_PROP);
							FormalProperty formalPropStereo = (FormalProperty) constraint.getStereotypeApplication(stereo);
							formalPropStereo.getClaim().add(claim);
						}

					}
					
				});
		}
	  ((TableViewer) this.getViewer()).add(claim);
      return true;
   }
   /**
    * Method declared on ViewerDropAdapter
    */
   public boolean validateDrop(Object target, int op, TransferData type) {
      return true;
   }
}