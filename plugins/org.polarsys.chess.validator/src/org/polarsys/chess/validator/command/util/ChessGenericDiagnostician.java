package org.polarsys.chess.validator.command.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.service.IConstraintFilter;


// TODO: Auto-generated Javadoc
/**
 * The Class ChessGenericDiagnostician.
 * 
 * @see package org.eclipse.emf.ecore.util.Diagnostician
 */
public class ChessGenericDiagnostician extends Diagnostician {

	/** The eChessValidatorAdapter. */
	private ChessValidatorAdapter eChessValidatorAdapter;
	
	/**
	 * Instantiates a new chess generic diagnostician.
	 *
	 * @param filter the filter
	 */
	public ChessGenericDiagnostician(IConstraintFilter filter) {
		this.eChessValidatorAdapter = new ChessValidatorAdapter(filter);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.Diagnostician#validate(org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EObject, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
		//progressMonitor.worked(1);
		//System.err.println("This is the ChessCheckerDiagnostician override of Diagnostician.validate(EClass, EObject,diagnostics,context)");
			    
	    boolean circular = context.get(EObjectValidator.ROOT_OBJECT) == eObject;
	    @SuppressWarnings("null")
	    boolean result = eChessValidatorAdapter.validate(eClass, eObject, diagnostics, context);
	    if ((result || diagnostics != null) && !circular)
	    {
	      result &= doValidateContents(eObject, diagnostics, context);
	    }
	    return result;
	  }
}
