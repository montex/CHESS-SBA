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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPrivCHRTSpec pattern,
 * to be used in conjunction with {@link ChildPrivCHRTSpecMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPrivCHRTSpecMatcher
 *  @see ChildPrivCHRTSpecProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPrivCHRTSpecMatch extends BasePatternMatch {
  private Comment fChrtspecComment;
  
  private BehavioralFeature fPrivoperation;
  
  private static List<String> parameterNames = makeImmutableList("chrtspecComment", "privoperation");
  
  private ChildPrivCHRTSpecMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    this.fChrtspecComment = pChrtspecComment;
    this.fPrivoperation = pPrivoperation;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("chrtspecComment".equals(parameterName)) return this.fChrtspecComment;
    if ("privoperation".equals(parameterName)) return this.fPrivoperation;
    return null;
  }
  
  public Comment getChrtspecComment() {
    return this.fChrtspecComment;
  }
  
  public BehavioralFeature getPrivoperation() {
    return this.fPrivoperation;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("chrtspecComment".equals(parameterName) ) {
        this.fChrtspecComment = (Comment) newValue;
        return true;
    }
    if ("privoperation".equals(parameterName) ) {
        this.fPrivoperation = (BehavioralFeature) newValue;
        return true;
    }
    return false;
  }
  
  public void setChrtspecComment(final Comment pChrtspecComment) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChrtspecComment = pChrtspecComment;
  }
  
  public void setPrivoperation(final BehavioralFeature pPrivoperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPrivoperation = pPrivoperation;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.childPrivCHRTSpec";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPrivCHRTSpecMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChrtspecComment, fPrivoperation};
  }
  
  @Override
  public ChildPrivCHRTSpecMatch toImmutable() {
    return isMutable() ? newMatch(fChrtspecComment, fPrivoperation) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"chrtspecComment\"=" + prettyPrintValue(fChrtspecComment) + ", ");
    result.append("\"privoperation\"=" + prettyPrintValue(fPrivoperation));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(fChrtspecComment, fPrivoperation);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof ChildPrivCHRTSpecMatch)) {
        ChildPrivCHRTSpecMatch other = (ChildPrivCHRTSpecMatch) obj;
        return Objects.equals(fChrtspecComment, other.fChrtspecComment) && Objects.equals(fPrivoperation, other.fPrivoperation);
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
  public ChildPrivCHRTSpecQuerySpecification specification() {
    try {
        return ChildPrivCHRTSpecQuerySpecification.instance();
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
  public static ChildPrivCHRTSpecMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPrivCHRTSpecMatch newMutableMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return new Mutable(pChrtspecComment, pPrivoperation);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPrivCHRTSpecMatch newMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return new Immutable(pChrtspecComment, pPrivoperation);
  }
  
  private static final class Mutable extends ChildPrivCHRTSpecMatch {
    Mutable(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
      super(pChrtspecComment, pPrivoperation);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPrivCHRTSpecMatch {
    Immutable(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
      super(pChrtspecComment, pPrivoperation);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
