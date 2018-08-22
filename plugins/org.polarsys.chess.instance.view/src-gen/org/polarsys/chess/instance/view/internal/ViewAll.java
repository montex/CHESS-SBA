/**
 * 
 *   Copyright (c) 2016 Budapest University of Technology and Economics, Intecs
 *  
 *      
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *  
 */
package org.polarsys.chess.instance.view.internal;

import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.chess.instance.view.internal.ClientServerPortHelperWithInterfaceQuerySpecification;
import org.polarsys.chess.instance.view.internal.PortHelperWithValueQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivateOperationsQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemRootQuerySpecification;

/**
 * A pattern group formed of all patterns defined in view.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package org.polarsys.chess.instance.view, the group contains the definition of the following patterns: <ul>
 * <li>swSystemCHGaResourcePlatform</li>
 * <li>swSystemRoot</li>
 * <li>swSystemChild2Item</li>
 * <li>swSystemChild2</li>
 * <li>childPortSlots</li>
 * <li>childPrivateOperations</li>
 * <li>childPortSlotsOperationItem</li>
 * <li>childPortSlotsOperation</li>
 * <li>childCHRTSpecItem</li>
 * <li>childCHRTSpec</li>
 * <li>childPrivCHRTSpecItem</li>
 * <li>childPrivCHRTSpec</li>
 * <li>portHelperWithValue</li>
 * <li>clientServerPortHelperWithInterface</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class ViewAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static ViewAll instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new ViewAll();
    }
    return INSTANCE;
  }
  
  private static ViewAll INSTANCE;
  
  private ViewAll() throws ViatraQueryException {
    querySpecifications.add(SwSystemCHGaResourcePlatformQuerySpecification.instance());
    querySpecifications.add(SwSystemRootQuerySpecification.instance());
    querySpecifications.add(SwSystemChild2ItemQuerySpecification.instance());
    querySpecifications.add(SwSystemChild2QuerySpecification.instance());
    querySpecifications.add(ChildPortSlotsQuerySpecification.instance());
    querySpecifications.add(ChildPrivateOperationsQuerySpecification.instance());
    querySpecifications.add(ChildPortSlotsOperationItemQuerySpecification.instance());
    querySpecifications.add(ChildPortSlotsOperationQuerySpecification.instance());
    querySpecifications.add(ChildCHRTSpecItemQuerySpecification.instance());
    querySpecifications.add(ChildCHRTSpecQuerySpecification.instance());
    querySpecifications.add(ChildPrivCHRTSpecItemQuerySpecification.instance());
    querySpecifications.add(ChildPrivCHRTSpecQuerySpecification.instance());
    querySpecifications.add(PortHelperWithValueQuerySpecification.instance());
    querySpecifications.add(ClientServerPortHelperWithInterfaceQuerySpecification.instance());
  }
}
