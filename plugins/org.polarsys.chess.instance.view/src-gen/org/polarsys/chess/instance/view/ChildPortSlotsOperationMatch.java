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
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPortSlotsOperation pattern,
 * to be used in conjunction with {@link ChildPortSlotsOperationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPortSlotsOperationMatcher
 * @see ChildPortSlotsOperationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPortSlotsOperationMatch extends BasePatternMatch {
  private Slot fSlot;
  
  private Operation fOperation;
  
  private String fNameC;
  
  private static List<String> parameterNames = makeImmutableList("slot", "operation", "nameC");
  
  private ChildPortSlotsOperationMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    this.fSlot = pSlot;
    this.fOperation = pOperation;
    this.fNameC = pNameC;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("slot".equals(parameterName)) return this.fSlot;
    if ("operation".equals(parameterName)) return this.fOperation;
    if ("nameC".equals(parameterName)) return this.fNameC;
    return null;
  }
  
  public Slot getSlot() {
    return this.fSlot;
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
    if ("slot".equals(parameterName) ) {
    	this.fSlot = (org.eclipse.uml2.uml.Slot) newValue;
    	return true;
    }
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
  
  public void setSlot(final Slot pSlot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSlot = pSlot;
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
    return "org.polarsys.chess.instance.view.childPortSlotsOperation";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPortSlotsOperationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSlot, fOperation, fNameC};
  }
  
  @Override
  public ChildPortSlotsOperationMatch toImmutable() {
    return isMutable() ? newMatch(fSlot, fOperation, fNameC) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"slot\"=" + prettyPrintValue(fSlot) + ", ");
    
    result.append("\"operation\"=" + prettyPrintValue(fOperation) + ", ");
    
    result.append("\"nameC\"=" + prettyPrintValue(fNameC)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSlot == null) ? 0 : fSlot.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    result = prime * result + ((fNameC == null) ? 0 : fNameC.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildPortSlotsOperationMatch)) { // this should be infrequent
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
    ChildPortSlotsOperationMatch other = (ChildPortSlotsOperationMatch) obj;
    if (fSlot == null) {if (other.fSlot != null) return false;}
    else if (!fSlot.equals(other.fSlot)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    if (fNameC == null) {if (other.fNameC != null) return false;}
    else if (!fNameC.equals(other.fNameC)) return false;
    return true;
  }
  
  @Override
  public ChildPortSlotsOperationQuerySpecification specification() {
    try {
    	return ChildPortSlotsOperationQuerySpecification.instance();
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
  public static ChildPortSlotsOperationMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPortSlotsOperationMatch newMutableMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return new Mutable(pSlot, pOperation, pNameC);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPortSlotsOperationMatch newMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return new Immutable(pSlot, pOperation, pNameC);
  }
  
  private static final class Mutable extends ChildPortSlotsOperationMatch {
    Mutable(final Slot pSlot, final Operation pOperation, final String pNameC) {
      super(pSlot, pOperation, pNameC);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPortSlotsOperationMatch {
    Immutable(final Slot pSlot, final Operation pOperation, final String pNameC) {
      super(pSlot, pOperation, pNameC);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
