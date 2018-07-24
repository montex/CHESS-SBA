package org.polarsys.chess.paramArchConfigurator.ui.dialog;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

import eu.fbk.tools.editor.contract.expression.validation.ProposalProvider.VariableType;

public class ConfigParameter {

	static String[] boolValues = { "true", "false" };

	private String fullName;
	private VariableType type;
	private String[] permittedValues;
	private String value;
	private VerifyListener verifyListener;

	public ConfigParameter(String fullName, VariableType type) {
		super();
		this.fullName = fullName;
		this.type = type;
		if (type == VariableType.BOOLEAN) {
			this.permittedValues = boolValues;

		} else if (type == VariableType.INTEGER) {
			this.verifyListener = new IntegerVerifyListener();
		} else if (type == VariableType.REAL) {
			this.verifyListener = new RealVerifyListener();
		}
	}

	public ConfigParameter(String fullName, VariableType type, String[] permittedValues) {
		this(fullName, type);
		this.permittedValues = permittedValues;
	}

	public String getFullName() {
		return fullName;
	}

	public VariableType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String[] getPermittedValues() {
		return permittedValues;
	}

	public VerifyListener getVerifyListener() {
		return verifyListener;
	}

	class IntegerVerifyListener implements VerifyListener {
		@Override
		public void verifyText(VerifyEvent e) {
			// allows cut (CTRL + x)
			if (e.text.isEmpty()) {
				e.doit = true;
			} else if (e.keyCode == SWT.ARROW_LEFT || e.keyCode == SWT.ARROW_RIGHT || e.keyCode == SWT.BS
					|| e.keyCode == SWT.DEL || e.keyCode == SWT.CTRL || e.keyCode == SWT.SHIFT) {
				e.doit = true;
			} else {
				boolean allow = false;
				for (int i = 0; i < e.text.length(); i++) {
					char c = e.text.charAt(i);
					allow = Character.isDigit(c);// ||
													// Character.isWhitespace(c);
					if (!allow) {
						break;
					}
				}
				e.doit = allow;
			}

		}
	}

	class RealVerifyListener implements VerifyListener {
		@Override
		public void verifyText(VerifyEvent e) {

			// allows cut (CTRL + x)
			if (e.text.isEmpty()) {
				e.doit = true;
			} else if (e.keyCode == SWT.ARROW_LEFT || e.keyCode == SWT.ARROW_RIGHT || e.keyCode == SWT.BS
					|| e.keyCode == SWT.DEL || e.keyCode == SWT.CTRL || e.keyCode == SWT.SHIFT) {
				e.doit = true;
			} else {

				boolean allow = false;
				for (int i = 0; i < e.text.length(); i++) {
					char c = e.text.charAt(i);
					allow = (Character.isDigit(c)
							|| ((c == '.') && (e.start != 0) && (dotIsAllowed(((Text) e.getSource()).getText()))));
					if (!allow) {
						break;
					}
				}

				e.doit = allow;
			}

		}

		private boolean dotIsAllowed(String text) {
			return (text.length() > 1) && !text.contains(".");
			// (StringUtils.countMatches(text, ".") <= 1);
		}

	}

}
