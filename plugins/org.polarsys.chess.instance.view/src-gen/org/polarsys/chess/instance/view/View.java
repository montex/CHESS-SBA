/*******************************************************************************
 *
 *  * Copyright (c) 2016 Budapest University of Technology and Economics, Intecs
 *  *
 *  *    
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *******************************************************************************/

package org.polarsys.chess.instance.view;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.polarsys.chess.instance.view.ChildCHRTSpecItemMatcher;
import org.polarsys.chess.instance.view.ChildCHRTSpecMatcher;
import org.polarsys.chess.instance.view.ChildPortSlotsMatcher;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatcher;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatcher;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecItemMatcher;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecMatcher;
import org.polarsys.chess.instance.view.ChildPrivateOperationsMatcher;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatcher;
import org.polarsys.chess.instance.view.SwSystemChild2ItemMatcher;
import org.polarsys.chess.instance.view.SwSystemChild2Matcher;
import org.polarsys.chess.instance.view.SwSystemRootMatcher;
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
 * A pattern group formed of all patterns defined in view.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file view.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
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
public final class View extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static View instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new View();
    }
    return INSTANCE;
  }
  
  private static View INSTANCE;
  
  private View() throws IncQueryException {
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
  }
  
  public SwSystemCHGaResourcePlatformQuerySpecification getSwSystemCHGaResourcePlatform() throws IncQueryException {
    return SwSystemCHGaResourcePlatformQuerySpecification.instance();
  }
  
  public SwSystemCHGaResourcePlatformMatcher getSwSystemCHGaResourcePlatform(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemCHGaResourcePlatformMatcher.on(engine);
  }
  
  public SwSystemRootQuerySpecification getSwSystemRoot() throws IncQueryException {
    return SwSystemRootQuerySpecification.instance();
  }
  
  public SwSystemRootMatcher getSwSystemRoot(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemRootMatcher.on(engine);
  }
  
  public SwSystemChild2ItemQuerySpecification getSwSystemChild2Item() throws IncQueryException {
    return SwSystemChild2ItemQuerySpecification.instance();
  }
  
  public SwSystemChild2ItemMatcher getSwSystemChild2Item(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemChild2ItemMatcher.on(engine);
  }
  
  public SwSystemChild2QuerySpecification getSwSystemChild2() throws IncQueryException {
    return SwSystemChild2QuerySpecification.instance();
  }
  
  public SwSystemChild2Matcher getSwSystemChild2(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemChild2Matcher.on(engine);
  }
  
  public ChildPortSlotsQuerySpecification getChildPortSlots() throws IncQueryException {
    return ChildPortSlotsQuerySpecification.instance();
  }
  
  public ChildPortSlotsMatcher getChildPortSlots(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsMatcher.on(engine);
  }
  
  public ChildPrivateOperationsQuerySpecification getChildPrivateOperations() throws IncQueryException {
    return ChildPrivateOperationsQuerySpecification.instance();
  }
  
  public ChildPrivateOperationsMatcher getChildPrivateOperations(final IncQueryEngine engine) throws IncQueryException {
    return ChildPrivateOperationsMatcher.on(engine);
  }
  
  public ChildPortSlotsOperationItemQuerySpecification getChildPortSlotsOperationItem() throws IncQueryException {
    return ChildPortSlotsOperationItemQuerySpecification.instance();
  }
  
  public ChildPortSlotsOperationItemMatcher getChildPortSlotsOperationItem(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsOperationItemMatcher.on(engine);
  }
  
  public ChildPortSlotsOperationQuerySpecification getChildPortSlotsOperation() throws IncQueryException {
    return ChildPortSlotsOperationQuerySpecification.instance();
  }
  
  public ChildPortSlotsOperationMatcher getChildPortSlotsOperation(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsOperationMatcher.on(engine);
  }
  
  public ChildCHRTSpecItemQuerySpecification getChildCHRTSpecItem() throws IncQueryException {
    return ChildCHRTSpecItemQuerySpecification.instance();
  }
  
  public ChildCHRTSpecItemMatcher getChildCHRTSpecItem(final IncQueryEngine engine) throws IncQueryException {
    return ChildCHRTSpecItemMatcher.on(engine);
  }
  
  public ChildCHRTSpecQuerySpecification getChildCHRTSpec() throws IncQueryException {
    return ChildCHRTSpecQuerySpecification.instance();
  }
  
  public ChildCHRTSpecMatcher getChildCHRTSpec(final IncQueryEngine engine) throws IncQueryException {
    return ChildCHRTSpecMatcher.on(engine);
  }
  
  public ChildPrivCHRTSpecItemQuerySpecification getChildPrivCHRTSpecItem() throws IncQueryException {
    return ChildPrivCHRTSpecItemQuerySpecification.instance();
  }
  
  public ChildPrivCHRTSpecItemMatcher getChildPrivCHRTSpecItem(final IncQueryEngine engine) throws IncQueryException {
    return ChildPrivCHRTSpecItemMatcher.on(engine);
  }
  
  public ChildPrivCHRTSpecQuerySpecification getChildPrivCHRTSpec() throws IncQueryException {
    return ChildPrivCHRTSpecQuerySpecification.instance();
  }
  
  public ChildPrivCHRTSpecMatcher getChildPrivCHRTSpec(final IncQueryEngine engine) throws IncQueryException {
    return ChildPrivCHRTSpecMatcher.on(engine);
  }
}
