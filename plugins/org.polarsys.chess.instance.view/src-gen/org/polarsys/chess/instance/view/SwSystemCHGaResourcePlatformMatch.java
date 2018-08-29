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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform pattern,
 * to be used in conjunction with {@link SwSystemCHGaResourcePlatformMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SwSystemCHGaResourcePlatformMatcher
 *  @see SwSystemCHGaResourcePlatformProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemCHGaResourcePlatformMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fInstSpec;
  
  private static List<String> parameterNames = makeImmutableList("instSpec");
  
  private SwSystemCHGaResourcePlatformMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    this.fInstSpec = pInstSpec;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("instSpec".equals(parameterName)) return this.fInstSpec;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getInstSpec() {
    return this.fInstSpec;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("instSpec".equals(parameterName) ) {
        this.fInstSpec = (org.eclipse.uml2.uml.Package) newValue;
        return true;
    }
    return false;
  }
  
  public void setInstSpec(final org.eclipse.uml2.uml.Package pInstSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstSpec = pInstSpec;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform";
  }
  
  @Override
  public List<String> parameterNames() {
    return SwSystemCHGaResourcePlatformMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInstSpec};
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatch toImmutable() {
    return isMutable() ? newMatch(fInstSpec) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"instSpec\"=" + prettyPrintValue(fInstSpec));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(fInstSpec);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof SwSystemCHGaResourcePlatformMatch)) {
        SwSystemCHGaResourcePlatformMatch other = (SwSystemCHGaResourcePlatformMatch) obj;
        return Objects.equals(fInstSpec, other.fInstSpec);
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
  public SwSystemCHGaResourcePlatformQuerySpecification specification() {
    try {
        return SwSystemCHGaResourcePlatformQuerySpecification.instance();
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
  public static SwSystemCHGaResourcePlatformMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SwSystemCHGaResourcePlatformMatch newMutableMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    return new Mutable(pInstSpec);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SwSystemCHGaResourcePlatformMatch newMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    return new Immutable(pInstSpec);
  }
  
  private static final class Mutable extends SwSystemCHGaResourcePlatformMatch {
    Mutable(final org.eclipse.uml2.uml.Package pInstSpec) {
      super(pInstSpec);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SwSystemCHGaResourcePlatformMatch {
    Immutable(final org.eclipse.uml2.uml.Package pInstSpec) {
      super(pInstSpec);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
