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
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.instance.view.ChildCHRTSpecItemMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.childCHRTSpecItem pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildCHRTSpecItemProcessor implements IMatchProcessor<ChildCHRTSpecItemMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pChrtspecComment the value of pattern parameter chrtspecComment in the currently processed match
   * 
   */
  public abstract void process(final Comment pChrtspecComment);
  
  @Override
  public void process(final ChildCHRTSpecItemMatch match) {
    process(match.getChrtspecComment());
  }
}
