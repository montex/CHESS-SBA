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
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation and/or initial documentation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.xtext;

import org.polarsys.chess.xtext.FlaDslRuntimeModule;
import org.polarsys.chess.xtext.ui.FlaDslUiModule;
import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.ExtensionsActivator;

import com.google.inject.Module;



public class FLAExpressionsProvider extends AbstractExpressionsProvider implements IExpressionLanguageProvider{

	@Override
	protected Module getRuntimeModule() {
		return new FlaDslRuntimeModule();
	}

	//NP 2015-03-24 - FIX: cast to com.google.inject.Module seems necessary and sufficient.
	@Override
	protected Module getUIModule() {
		return (Module) new FlaDslUiModule(ExtensionsActivator.getDefault());
	}

}
