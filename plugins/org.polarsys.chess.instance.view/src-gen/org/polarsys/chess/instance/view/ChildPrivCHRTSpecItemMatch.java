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

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPrivCHRTSpecItem pattern,
 * to be used in conjunction with {@link ChildPrivCHRTSpecItemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPrivCHRTSpecItemMatcher
 * @see ChildPrivCHRTSpecItemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPrivCHRTSpecItemMatch extends BasePatternMatch {
  private Comment fChrtspecComment;
  
  private static List<String> parameterNames = makeImmutableList("chrtspecComment");
  
  private ChildPrivCHRTSpecItemMatch(final Comment pChrtspecComment) {
    this.fChrtspecComment = pChrtspecComment;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("chrtspecComment".equals(parameterName)) return this.fChrtspecComment;
    return null;
  }
  
  public Comment getChrtspecComment() {
    return this.fChrtspecComment;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("chrtspecComment".equals(parameterName) ) {
    	this.fChrtspecComment = (org.eclipse.uml2.uml.Comment) newValue;
    	return true;
    }
    return false;
  }
  
  public void setChrtspecComment(final Comment pChrtspecComment) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChrtspecComment = pChrtspecComment;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.childPrivCHRTSpecItem";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPrivCHRTSpecItemMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChrtspecComment};
  }
  
  @Override
  public ChildPrivCHRTSpecItemMatch toImmutable() {
    return isMutable() ? newMatch(fChrtspecComment) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"chrtspecComment\"=" + prettyPrintValue(fChrtspecComment)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fChrtspecComment == null) ? 0 : fChrtspecComment.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildPrivCHRTSpecItemMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ChildPrivCHRTSpecItemMatch other = (ChildPrivCHRTSpecItemMatch) obj;
    if (fChrtspecComment == null) {if (other.fChrtspecComment != null) return false;}
    else if (!fChrtspecComment.equals(other.fChrtspecComment)) return false;
    return true;
  }
  
  @Override
  public ChildPrivCHRTSpecItemQuerySpecification specification() {
    try {
    	return ChildPrivCHRTSpecItemQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static ChildPrivCHRTSpecItemMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPrivCHRTSpecItemMatch newMutableMatch(final Comment pChrtspecComment) {
    return new Mutable(pChrtspecComment);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPrivCHRTSpecItemMatch newMatch(final Comment pChrtspecComment) {
    return new Immutable(pChrtspecComment);
  }
  
  private static final class Mutable extends ChildPrivCHRTSpecItemMatch {
    Mutable(final Comment pChrtspecComment) {
      super(pChrtspecComment);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPrivCHRTSpecItemMatch {
    Immutable(final Comment pChrtspecComment) {
      super(pChrtspecComment);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
