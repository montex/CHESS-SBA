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
 
package org.polarsys.chess.instance.view.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemCHGaResourcePlatformProcessor implements IMatchProcessor<SwSystemCHGaResourcePlatformMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInstSpec the value of pattern parameter instSpec in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pInstSpec);
  
  @Override
  public void process(final SwSystemCHGaResourcePlatformMatch match) {
    process(match.getInstSpec());
  }
}
