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

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.polarsys.chess.instance.view.ChildPrivateOperationsMatch;

/**
 * A match processor tailored for the org.polarsys.chess.instance.view.childPrivateOperations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPrivateOperationsProcessor implements IMatchProcessor<ChildPrivateOperationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pChild the value of pattern parameter child in the currently processed match
   * @param pPrivoperation the value of pattern parameter privoperation in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName);
  
  @Override
  public void process(final ChildPrivateOperationsMatch match) {
    process(match.getChild(), match.getPrivoperation(), match.getName());
  }
}
