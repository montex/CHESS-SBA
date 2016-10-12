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
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.instance.view.SwSystemChild2Match;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.swSystemChild2 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemChild2Processor implements IMatchProcessor<SwSystemChild2Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pChild the value of pattern parameter child in the currently processed match
   * @param pInstSpec the value of pattern parameter instSpec in the currently processed match
   * @param pParent the value of pattern parameter parent in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName);
  
  @Override
  public void process(final SwSystemChild2Match match) {
    process(match.getChild(), match.getInstSpec(), match.getParent(), match.getName());
  }
}
