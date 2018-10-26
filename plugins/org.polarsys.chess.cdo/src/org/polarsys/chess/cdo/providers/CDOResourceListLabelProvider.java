/*******************************************************************************
 * Copyright (c) 2017, MDH 
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *   Irfan Sljivo <irfan.sljivo@mdh.se || irfan.sljivo@gmail.com>
 *   Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.cdo.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;

public class CDOResourceListLabelProvider extends LabelProvider {

	public Image getImage(Object element) {
		return null;
	}


	public String getText(Object element) {
		CDOResourceFolder resource = (CDOResourceFolder) element;
		return resource.getPath();
	}
}