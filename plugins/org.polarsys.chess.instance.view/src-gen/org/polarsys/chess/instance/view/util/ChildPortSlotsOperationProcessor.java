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

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.childPortSlotsOperation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPortSlotsOperationProcessor implements IMatchProcessor<ChildPortSlotsOperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSlot the value of pattern parameter slot in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pNameC the value of pattern parameter nameC in the currently processed match
   * 
   */
  public abstract void process(final Slot pSlot, final Operation pOperation, final String pNameC);
  
  @Override
  public void process(final ChildPortSlotsOperationMatch match) {
    process(match.getSlot(), match.getOperation(), match.getNameC());
  }
}
