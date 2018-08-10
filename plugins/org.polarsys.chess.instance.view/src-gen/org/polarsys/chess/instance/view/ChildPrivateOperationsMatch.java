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
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.chess.instance.view.util.ChildPrivateOperationsQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPrivateOperations pattern,
 * to be used in conjunction with {@link ChildPrivateOperationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPrivateOperationsMatcher
 *  @see ChildPrivateOperationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPrivateOperationsMatch extends BasePatternMatch {
  private InstanceSpecification fChild;
  
  private Operation fPrivoperation;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("child", "privoperation", "name");
  
  private ChildPrivateOperationsMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    this.fChild = pChild;
    this.fPrivoperation = pPrivoperation;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("child".equals(parameterName)) return this.fChild;
    if ("privoperation".equals(parameterName)) return this.fPrivoperation;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getChild() {
    return this.fChild;
  }
  
  public Operation getPrivoperation() {
    return this.fPrivoperation;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("child".equals(parameterName) ) {
        this.fChild = (InstanceSpecification) newValue;
        return true;
    }
    if ("privoperation".equals(parameterName) ) {
        this.fPrivoperation = (Operation) newValue;
        return true;
    }
    if ("name".equals(parameterName) ) {
        this.fName = (String) newValue;
        return true;
    }
    return false;
  }
  
  public void setChild(final InstanceSpecification pChild) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChild = pChild;
  }
  
  public void setPrivoperation(final Operation pPrivoperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPrivoperation = pPrivoperation;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.childPrivateOperations";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPrivateOperationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChild, fPrivoperation, fName};
  }
  
  @Override
  public ChildPrivateOperationsMatch toImmutable() {
    return isMutable() ? newMatch(fChild, fPrivoperation, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
    result.append("\"privoperation\"=" + prettyPrintValue(fPrivoperation) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(fChild, fPrivoperation, fName);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof ChildPrivateOperationsMatch)) {
        ChildPrivateOperationsMatch other = (ChildPrivateOperationsMatch) obj;
        return Objects.equals(fChild, other.fChild) && Objects.equals(fPrivoperation, other.fPrivoperation) && Objects.equals(fName, other.fName);
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
  public ChildPrivateOperationsQuerySpecification specification() {
    try {
        return ChildPrivateOperationsQuerySpecification.instance();
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
  public static ChildPrivateOperationsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPrivateOperationsMatch newMutableMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return new Mutable(pChild, pPrivoperation, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPrivateOperationsMatch newMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return new Immutable(pChild, pPrivoperation, pName);
  }
  
  private static final class Mutable extends ChildPrivateOperationsMatch {
    Mutable(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
      super(pChild, pPrivoperation, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPrivateOperationsMatch {
    Immutable(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
      super(pChild, pPrivoperation, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
