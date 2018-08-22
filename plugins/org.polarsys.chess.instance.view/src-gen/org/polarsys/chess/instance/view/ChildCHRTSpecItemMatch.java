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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecItemQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childCHRTSpecItem pattern,
 * to be used in conjunction with {@link ChildCHRTSpecItemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildCHRTSpecItemMatcher
 *  @see ChildCHRTSpecItemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildCHRTSpecItemMatch extends BasePatternMatch {
  private Comment fChrtspecComment;
  
  private static List<String> parameterNames = makeImmutableList("chrtspecComment");
  
  private ChildCHRTSpecItemMatch(final Comment pChrtspecComment) {
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
        this.fChrtspecComment = (Comment) newValue;
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
    return "org.polarsys.chess.instance.view.childCHRTSpecItem";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildCHRTSpecItemMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChrtspecComment};
  }
  
  @Override
  public ChildCHRTSpecItemMatch toImmutable() {
    return isMutable() ? newMatch(fChrtspecComment) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"chrtspecComment\"=" + prettyPrintValue(fChrtspecComment));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(fChrtspecComment);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof ChildCHRTSpecItemMatch)) {
        ChildCHRTSpecItemMatch other = (ChildCHRTSpecItemMatch) obj;
        return Objects.equals(fChrtspecComment, other.fChrtspecComment);
    } else {
        // this should be infrequent
        if (!(obj instanceof IPatternMatch)) {
            return false;
        }
        IPatternMatch otherSig  = (IPatternMatch) obj;
        return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
    }
  }
  
  @Override
  public ChildCHRTSpecItemQuerySpecification specification() {
    try {
        return ChildCHRTSpecItemQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
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
  public static ChildCHRTSpecItemMatch newEmptyMatch() {
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
  public static ChildCHRTSpecItemMatch newMutableMatch(final Comment pChrtspecComment) {
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
  public static ChildCHRTSpecItemMatch newMatch(final Comment pChrtspecComment) {
    return new Immutable(pChrtspecComment);
  }
  
  private static final class Mutable extends ChildCHRTSpecItemMatch {
    Mutable(final Comment pChrtspecComment) {
      super(pChrtspecComment);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildCHRTSpecItemMatch {
    Immutable(final Comment pChrtspecComment) {
      super(pChrtspecComment);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
