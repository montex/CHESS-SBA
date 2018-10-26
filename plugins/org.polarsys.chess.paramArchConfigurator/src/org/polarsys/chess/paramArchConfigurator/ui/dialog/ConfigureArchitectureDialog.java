/*******************************************************************************
 * Copyright (c) 2013-2015 Fondazione Bruno Kessler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 *     Pietro Braghieri - initial API and implementation
 *******************************************************************************/
package org.polarsys.chess.paramArchConfigurator.ui.dialog;

import java.util.ArrayList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * The Class ModelToDocumentDialog.
 *
 */
public class ConfigureArchitectureDialog extends Dialog {

	ArrayList<ConfigParameter> configParams = new ArrayList<ConfigParameter>();

	/** The go ahead. */
	private boolean goAhead = false;

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 *            the parent shell
	 */
	public ConfigureArchitectureDialog(Shell parentShell, ArrayList<ConfigParameter> configParams) {
		super(parentShell);
		setShellStyle(SWT.TITLE | SWT.RESIZE);
		this.configParams = configParams;

	}

	/** {@inheritDoc} */
	@Override
	protected void okPressed() {

		goAhead = true;

		super.okPressed();
	}

	/** {@inheritDoc} */
	@Override
	protected Control createDialogArea(Composite parent) {
		// parent.setToolTipText("");
		final Composite container = (Composite) super.createDialogArea(parent);
		this.getShell().setText("Configure Parameterized Architecture");

		ScrolledComposite sc = new ScrolledComposite(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		sc.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite containerConfigParams = new Composite(sc, SWT.NONE);

		final GridLayout gl = new GridLayout();
		gl.numColumns = 3;
		gl.makeColumnsEqualWidth = true;
		gl.verticalSpacing = 10;
		containerConfigParams.setLayout(gl);

		GridData gdName = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		GridData gdValue = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		for (ConfigParameter configParam : configParams) {

			Label paramNameLabel = new Label(containerConfigParams, SWT.CHECK);
			paramNameLabel.setAlignment(SWT.RIGHT);
			paramNameLabel.setText(configParam.getFullName() + ": " + configParam.getType().name());
			paramNameLabel.setToolTipText("Name of the parameter and its type");
			paramNameLabel.setLayoutData(gdName);

			if (configParam.getPermittedValues() == null) {
				Text paramLabelText = new Text(containerConfigParams, SWT.CHECK);
				paramLabelText.setToolTipText("Value of the parameter");
				paramLabelText.setLayoutData(gdValue);
				VerifyListener verListener;
				if ((verListener = configParam.getVerifyListener()) != null) {
					paramLabelText.addVerifyListener(verListener);
				}
			} else {
				Combo paramCombo = new Combo(containerConfigParams, SWT.NONE | SWT.READ_ONLY);
				paramCombo.setLayoutData(gdValue);
				paramCombo.add("");
				for (String value : configParam.getPermittedValues()) {
					paramCombo.add(value);
				}

			}

		}

		sc.setContent(containerConfigParams);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(containerConfigParams.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return container;
	}

	/** {@inheritDoc} */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/** {@inheritDoc} */
	@Override
	protected Point getInitialSize() {
		return new Point(350, 520);
	}

	/** Getter. */
	public boolean goAhead() {
		return goAhead;
	}

}
