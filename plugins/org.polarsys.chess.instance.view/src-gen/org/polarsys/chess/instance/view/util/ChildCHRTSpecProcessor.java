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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.instance.view.ChildCHRTSpecMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.childCHRTSpec pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildCHRTSpecProcessor implements IMatchProcessor<ChildCHRTSpecMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pChrtspecComment the value of pattern parameter chrtspecComment in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * 
   */
  public abstract void process(final Comment pChrtspecComment, final BehavioralFeature pOperation);
  
  @Override
  public void process(final ChildCHRTSpecMatch match) {
    process(match.getChrtspecComment(), match.getOperation());
  }
}
