/*******************************************************************************
 *                  CHESS monitoring plugin
 *
 *               Copyright (C) 2015-2016
 *            Malardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package org.polarsys.chess.monitoring.monitoringxml.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.monitoring.monitoringxml.util.MonitoringxmlResourceImpl
 * @generated
 */
public class MonitoringxmlResourceFactoryImpl extends ResourceFactoryImpl {
	
		/**
		 * Creates an instance of the resource factory.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public MonitoringxmlResourceFactoryImpl() {
			super();
		}

		/**
		 * Creates an instance of the resource.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Resource createResource(URI uri) {
			XMIResource result = new MonitoringxmlResourceImpl(uri);
			result.getDefaultSaveOptions().put(XMIResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			result.getDefaultLoadOptions().put(XMIResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

			result.getDefaultSaveOptions().put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			result.getDefaultLoadOptions().put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			result.getDefaultSaveOptions().put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);

			result.getDefaultLoadOptions().put(XMIResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
			return result;
		}

}
