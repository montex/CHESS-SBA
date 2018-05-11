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
package org.polarsys.chess.instance.view;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
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
 * A pattern group formed of all public patterns defined in view.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file view.vql,
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
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static View instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new View();
    }
    return INSTANCE;
  }
  
  private static View INSTANCE;
  
  private View() throws ViatraQueryException {
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
  
  public SwSystemCHGaResourcePlatformQuerySpecification getSwSystemCHGaResourcePlatform() throws ViatraQueryException {
    return SwSystemCHGaResourcePlatformQuerySpecification.instance();
  }
  
  public SwSystemCHGaResourcePlatformMatcher getSwSystemCHGaResourcePlatform(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemCHGaResourcePlatformMatcher.on(engine);
  }
  
  public SwSystemRootQuerySpecification getSwSystemRoot() throws ViatraQueryException {
    return SwSystemRootQuerySpecification.instance();
  }
  
  public SwSystemRootMatcher getSwSystemRoot(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemRootMatcher.on(engine);
  }
  
  public SwSystemChild2ItemQuerySpecification getSwSystemChild2Item() throws ViatraQueryException {
    return SwSystemChild2ItemQuerySpecification.instance();
  }
  
  public SwSystemChild2ItemMatcher getSwSystemChild2Item(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemChild2ItemMatcher.on(engine);
  }
  
  public SwSystemChild2QuerySpecification getSwSystemChild2() throws ViatraQueryException {
    return SwSystemChild2QuerySpecification.instance();
  }
  
  public SwSystemChild2Matcher getSwSystemChild2(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemChild2Matcher.on(engine);
  }
  
  public ChildPortSlotsQuerySpecification getChildPortSlots() throws ViatraQueryException {
    return ChildPortSlotsQuerySpecification.instance();
  }
  
  public ChildPortSlotsMatcher getChildPortSlots(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsMatcher.on(engine);
  }
  
  public ChildPrivateOperationsQuerySpecification getChildPrivateOperations() throws ViatraQueryException {
    return ChildPrivateOperationsQuerySpecification.instance();
  }
  
  public ChildPrivateOperationsMatcher getChildPrivateOperations(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPrivateOperationsMatcher.on(engine);
  }
  
  public ChildPortSlotsOperationItemQuerySpecification getChildPortSlotsOperationItem() throws ViatraQueryException {
    return ChildPortSlotsOperationItemQuerySpecification.instance();
  }
  
  public ChildPortSlotsOperationItemMatcher getChildPortSlotsOperationItem(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsOperationItemMatcher.on(engine);
  }
  
  public ChildPortSlotsOperationQuerySpecification getChildPortSlotsOperation() throws ViatraQueryException {
    return ChildPortSlotsOperationQuerySpecification.instance();
  }
  
  public ChildPortSlotsOperationMatcher getChildPortSlotsOperation(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsOperationMatcher.on(engine);
  }
  
  public ChildCHRTSpecItemQuerySpecification getChildCHRTSpecItem() throws ViatraQueryException {
    return ChildCHRTSpecItemQuerySpecification.instance();
  }
  
  public ChildCHRTSpecItemMatcher getChildCHRTSpecItem(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildCHRTSpecItemMatcher.on(engine);
  }
  
  public ChildCHRTSpecQuerySpecification getChildCHRTSpec() throws ViatraQueryException {
    return ChildCHRTSpecQuerySpecification.instance();
  }
  
  public ChildCHRTSpecMatcher getChildCHRTSpec(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildCHRTSpecMatcher.on(engine);
  }
  
  public ChildPrivCHRTSpecItemQuerySpecification getChildPrivCHRTSpecItem() throws ViatraQueryException {
    return ChildPrivCHRTSpecItemQuerySpecification.instance();
  }
  
  public ChildPrivCHRTSpecItemMatcher getChildPrivCHRTSpecItem(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPrivCHRTSpecItemMatcher.on(engine);
  }
  
  public ChildPrivCHRTSpecQuerySpecification getChildPrivCHRTSpec() throws ViatraQueryException {
    return ChildPrivCHRTSpecQuerySpecification.instance();
  }
  
  public ChildPrivCHRTSpecMatcher getChildPrivCHRTSpec(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPrivCHRTSpecMatcher.on(engine);
  }
}
