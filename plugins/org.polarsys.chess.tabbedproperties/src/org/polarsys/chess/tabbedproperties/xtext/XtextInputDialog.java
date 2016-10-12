/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2015 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Nicholas Pacini nicholas.pacini@intecs.it
 -  
 - A multi-line string editor that allow the use of an X-Text grammar.
 ------------------------------------------------------------------------------*/

package org.polarsys.chess.tabbedproperties.xtext;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;

/**
 * A simple input dialog for soliciting an input string from the user.
 * <p>
 * This concrete dialog class can be instantiated as is, or further subclassed as
 * required.
 * </p>
 * <p>
 * This class is cloned from <code>org.eclipse.jface.dialogs.InputDialog</code>,
 * with minimal changes required to instantiate a Styled text control X-Text aware.
 * </p>
 */
public class XtextInputDialog extends Dialog {
    /**
     * The title of the dialog.
     */
    private String title;

    /**
     * The message to display, or <code>null</code> if none.
     */
    private String message;

    /**
     * The input value; the empty string by default.
     */
    private String value = "";//$NON-NLS-1$

    /**
     * The input validator, or <code>null</code> if none.
     */
    private IInputValidator validator;

    /**
     * OK button widget.
     */
    private Button okButton;

    /**
     * Input text widget.
     */
    private StyledText text;

    /**
     * Error message label widget.
     */
    private Text errorMessageText;
    
    /**
     * Error message string.
     */
    private String errorMessage;

    /**
     * a boolean flag that tells whether or not the text widget is xtext-enabled
     */
    private final boolean xtextEnabled;

    /**
     * Creates an input dialog with OK and Cancel buttons. Note that the dialog
     * will have no visual representation (no widgets) until it is told to open.
     * <p>
     * Note that the <code>open</code> method blocks for input dialogs.
     * </p>
     * 
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level
     *            shell
     * @param dialogTitle
     *            the dialog title, or <code>null</code> if none
     * @param dialogMessage
     *            the dialog message, or <code>null</code> if none
     * @param initialValue
     *            the initial input value, or <code>null</code> if none
     *            (equivalent to the empty string)
     * @param validator
     *            an input validator, or <code>null</code> if none
     */
    public XtextInputDialog(Shell parentShell, String dialogTitle,
            String dialogMessage, String initialValue, IInputValidator validator) {
        this(parentShell, dialogTitle, dialogMessage, initialValue, validator, true);
    }

    /**
     * Creates an input dialog with OK and Cancel buttons. Note that the dialog
     * will have no visual representation (no widgets) until it is told to open.
     * <p>
     * Note that the <code>open</code> method blocks for input dialogs.
     * </p>
     * 
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level
     *            shell
     * @param dialogTitle
     *            the dialog title, or <code>null</code> if none
     * @param dialogMessage
     *            the dialog message, or <code>null</code> if none
     * @param initialValue
     *            the initial input value, or <code>null</code> if none
     *            (equivalent to the empty string)
     * @param validator
     *            an input validator, or <code>null</code> if none
     * @param xtextEnabled
     *            a flag that tells whether or not the dialog is XText-enabled i.e.
     *            whether or not the dialog has XText auto-completion, coloring ... and so on
     *            (When the flag is true the edit has full XText capabilities, otherwise when
     *            the flag is false it is a normal edit, but it wraps its contents and so it makes
     *            easier to read and edit its contents)
     */
    public XtextInputDialog(Shell parentShell, String dialogTitle,
            String dialogMessage, String initialValue, IInputValidator validator, boolean xtextEnabled) {
        super(parentShell);

        setShellStyle(getShellStyle() | SWT.RESIZE);

        this.title = dialogTitle;
        message = dialogMessage;
        if (initialValue == null) {
			value = "";//$NON-NLS-1$
		} else {
			value = initialValue;
		}
        this.validator = validator;

        this.xtextEnabled = xtextEnabled;
    }

    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            value = text.getText();
        } else {
            value = null;
        }
        super.buttonPressed(buttonId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
			shell.setText(title);
		}
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        // create OK and Cancel buttons by default
        okButton = createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, false);
        //do this here because setting the text will set enablement on the OK
        // button
        text.setFocus();
        if (value != null) {
            text.setText(value);
            text.selectAll();
        }
    }


  @Override
  protected Control createDialogArea(Composite parent) {
      // create composite
      Composite composite = (Composite) super.createDialogArea(parent);
      // create message
      if (message != null) {
          Label label = new Label(composite, SWT.WRAP);
          label.setText(message);
          GridData data = new GridData(GridData.GRAB_HORIZONTAL
                  /* | GridData.GRAB_VERTICAL */ | GridData.HORIZONTAL_ALIGN_FILL
                  | GridData.VERTICAL_ALIGN_CENTER);
          data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
          label.setLayoutData(data);
          label.setFont(parent.getFont());
      }

      if( this.xtextEnabled ) {
          //
          // X-Text specific part
          //
    	  FLAExpressionsProvider tmp = new FLAExpressionsProvider();
    	  Injector injector = tmp.getInjector();

    	  text = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.WRAP);
    	  StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(injector);
    	  xtextAdapter.adapt(text);

          //
          // End of X-Text specific part
          //
      } else {
    	  //
    	  // shows a multi-line dialog that can wrap strings.
    	  //
    	  text = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.WRAP);
      }

      GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
      data.heightHint = 5 * text.getLineHeight();
      data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.ENTRY_FIELD_WIDTH);
      text.setLayoutData(data);
      text.addModifyListener(new ModifyListener() {
          public void modifyText(ModifyEvent e) {
              validateInput();
          }
      });
      errorMessageText = new Text(composite, SWT.READ_ONLY);
      errorMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
              | GridData.HORIZONTAL_ALIGN_FILL));
      errorMessageText.setBackground(errorMessageText.getDisplay()
              .getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
      // Set the error message text
      // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=66292
      setErrorMessage(errorMessage);

      applyDialogFont(composite);
      return composite;
  }

  /**
   * Returns the error message label.
   * 
   * @return the error message label
   * @deprecated use setErrorMessage(String) instead
   */
  @Deprecated
  protected Label getErrorMessageLabel() {
      return null;
  }

  /**
   * Returns the OK button.
   * 
   * @return the OK button
   */
  protected Button getOkButton() {
      return okButton;
  }

  /**
   * Returns the text area.
   * 
   * @return the text area
   */
  protected StyledText getText() {
      return text;
  }

  /**
   * Returns the validator.
   * 
   * @return the validator
   */
  protected IInputValidator getValidator() {
      return validator;
  }

  /**
   * Returns the string typed into this input dialog.
   * 
   * @return the input string
   */
  public String getValue() {
      return value;
  }

  /**
   * Validates the input.
   * <p>
   * The default implementation of this framework method delegates the request
   * to the supplied input validator object; if it finds the input invalid,
   * the error message is displayed in the dialog's message line. This hook
   * method is called whenever the text changes in the input field.
   * </p>
   */
  protected void validateInput() {
      String errorMessage = null;
      if (validator != null) {
          errorMessage = validator.isValid(text.getText());
      }
      // Bug 16256: important not to treat "" (blank error) the same as null
      // (no error)
      setErrorMessage(errorMessage);
  }

  /**
   * Sets or clears the error message.
   * If not <code>null</code>, the OK button is disabled.
   * 
   * @param errorMessage
   *            the error message, or <code>null</code> to clear
   * @since 3.0
   */
  public void setErrorMessage(String errorMessage) {
  	this.errorMessage = errorMessage;
  	if (errorMessageText != null && !errorMessageText.isDisposed()) {
  		errorMessageText.setText(errorMessage == null ? "" : errorMessage); //$NON-NLS-1$
  		errorMessageText.getParent().update();
  		// Access the OK button by id, in case clients have overridden button creation.
  		// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=113643
  		Control button = getButton(IDialogConstants.OK_ID);
  		if (button != null) {
  			button.setEnabled(errorMessage == null);
  		}
  	}
  }

}
