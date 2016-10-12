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
import org.eclipse.uml2.uml.Operation;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPortSlotsOperationItem pattern,
 * to be used in conjunction with {@link ChildPortSlotsOperationItemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPortSlotsOperationItemMatcher
 * @see ChildPortSlotsOperationItemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPortSlotsOperationItemMatch extends BasePatternMatch {
  private Operation fOperation;
  
  private String fNameC;
  
  private static List<String> parameterNames = makeImmutableList("operation", "nameC");
  
  private ChildPortSlotsOperationItemMatch(final Operation pOperation, final String pNameC) {
    this.fOperation = pOperation;
    this.fNameC = pNameC;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("operation".equals(parameterName)) return this.fOperation;
    if ("nameC".equals(parameterName)) return this.fNameC;
    return null;
  }
  
  public Operation getOperation() {
    return this.fOperation;
  }
  
  public String getNameC() {
    return this.fNameC;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("operation".equals(parameterName) ) {
    	this.fOperation = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("nameC".equals(parameterName) ) {
    	this.fNameC = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOperation(final Operation pOperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOperation = pOperation;
  }
  
  public void setNameC(final String pNameC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNameC = pNameC;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.childPortSlotsOperationItem";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPortSlotsOperationItemMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOperation, fNameC};
  }
  
  @Override
  public ChildPortSlotsOperationItemMatch toImmutable() {
    return isMutable() ? newMatch(fOperation, fNameC) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"operation\"=" + prettyPrintValue(fOperation) + ", ");
    
    result.append("\"nameC\"=" + prettyPrintValue(fNameC)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    result = prime * result + ((fNameC == null) ? 0 : fNameC.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildPortSlotsOperationItemMatch)) { // this should be infrequent
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
    ChildPortSlotsOperationItemMatch other = (ChildPortSlotsOperationItemMatch) obj;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    if (fNameC == null) {if (other.fNameC != null) return false;}
    else if (!fNameC.equals(other.fNameC)) return false;
    return true;
  }
  
  @Override
  public ChildPortSlotsOperationItemQuerySpecification specification() {
    try {
    	return ChildPortSlotsOperationItemQuerySpecification.instance();
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
  public static ChildPortSlotsOperationItemMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPortSlotsOperationItemMatch newMutableMatch(final Operation pOperation, final String pNameC) {
    return new Mutable(pOperation, pNameC);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPortSlotsOperationItemMatch newMatch(final Operation pOperation, final String pNameC) {
    return new Immutable(pOperation, pNameC);
  }
  
  private static final class Mutable extends ChildPortSlotsOperationItemMatch {
    Mutable(final Operation pOperation, final String pNameC) {
      super(pOperation, pNameC);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPortSlotsOperationItemMatch {
    Immutable(final Operation pOperation, final String pNameC) {
      super(pOperation, pNameC);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
