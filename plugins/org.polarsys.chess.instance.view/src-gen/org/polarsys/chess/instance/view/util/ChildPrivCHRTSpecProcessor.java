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
package org.polarsys.chess.instance.view.util;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.childPrivCHRTSpec pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPrivCHRTSpecProcessor implements IMatchProcessor<ChildPrivCHRTSpecMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pChrtspecComment the value of pattern parameter chrtspecComment in the currently processed match
   * @param pPrivoperation the value of pattern parameter privoperation in the currently processed match
   * 
   */
  public abstract void process(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation);
  
  @Override
  public void process(final ChildPrivCHRTSpecMatch match) {
    process(match.getChrtspecComment(), match.getPrivoperation());
  }
}
