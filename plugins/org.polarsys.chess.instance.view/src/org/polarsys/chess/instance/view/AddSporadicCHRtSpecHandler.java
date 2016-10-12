/*****************************************************************************
 * Copyright (c) 2016 Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.polarsys.chess.instance.view;

public class AddSporadicCHRtSpecHandler extends AddCHRtSpecHandler {
	
	/* (non-Javadoc)
	 * @see org.polarsys.chess.instance.view.AddCHRtSpecHandler#getOccKind()
	 * @return  default value for sporadic CHRtSpecification occKind property
	 */
	@Override
	protected String getOccKind(){
		return "sporadic(minInterarrival=(value=xxx,unit=ms))";
	}

}
