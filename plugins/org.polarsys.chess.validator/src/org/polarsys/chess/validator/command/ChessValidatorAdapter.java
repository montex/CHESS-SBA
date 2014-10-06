package org.polarsys.chess.validator.command;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.emf.validation.service.ModelValidationService;

public class ChessValidatorAdapter extends EObjectValidator{ 
	
	private final IBatchValidator batchValidator;

	public ChessValidatorAdapter(IConstraintFilter constraintFilter) {
		super();

		this.batchValidator = (IBatchValidator) ModelValidationService.getInstance()
				.newValidator(EvaluationMode.BATCH);
		this.batchValidator.setIncludeLiveConstraints(true);
		this.batchValidator.setReportSuccesses(false);
		this.batchValidator.addConstraintFilter(constraintFilter);
	}

	@Override
	public boolean validate(final EObject eObject,
			final DiagnosticChain diagnostics,
			final Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}
	
	@Override
	public boolean validate(final EClass eClass, final EObject eObject,
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        super.validate(eClass, eObject, diagnostics, context);
        
        IStatus status = Status.OK_STATUS;
        
        if (diagnostics != null) {
            if (!hasProcessed(eObject, context)) {
                status = this.batchValidator.validate(
                    eObject,
                    new NullProgressMonitor());
                
                processed(eObject, context, status);
                
                appendDiagnostics(status, diagnostics);
            }
        }
        
        return status.isOK();
    }

	private void processed(final EObject eObject,
			final Map<Object, Object> context, final IStatus status) {
        if (context != null) {
            context.put(eObject, status);
        }
    }
    
	private boolean hasProcessed(final EObject eObject,
			final Map<Object, Object> context) {
        boolean result = false;
        EObject currentEObject = eObject;
        if (context != null) {
            while (currentEObject != null) {
                if (context.containsKey(currentEObject)) {
                    result = true;
                    currentEObject = null;
                } else {
                    currentEObject = currentEObject.eContainer();
                }
            }
        }
        
        return result;
    }
    
	private void appendDiagnostics(final IStatus status,
			final DiagnosticChain diagnostics) {
        if (status.isMultiStatus()) {
            IStatus[] children = status.getChildren();
            
            for (int i = 0; i < children.length; i++) {
                appendDiagnostics(children[i], diagnostics);
            }
        } else if (status instanceof IConstraintStatus) {
            diagnostics.add(new BasicDiagnostic(
                status.getSeverity(),
                status.getPlugin(),
                status.getCode(),
                status.getMessage(),
                ((IConstraintStatus) status).getResultLocus().toArray()));
        }
    }


}
