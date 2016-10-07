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
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.childPortSlots pattern,
 * to be used in conjunction with {@link ChildPortSlotsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildPortSlotsMatcher
 * @see ChildPortSlotsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildPortSlotsMatch extends BasePatternMatch {
  private InstanceSpecification fChild;
  
  private Slot fSlot;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("child", "slot", "name");
  
  private ChildPortSlotsMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    this.fChild = pChild;
    this.fSlot = pSlot;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("child".equals(parameterName)) return this.fChild;
    if ("slot".equals(parameterName)) return this.fSlot;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getChild() {
    return this.fChild;
  }
  
  public Slot getSlot() {
    return this.fSlot;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("child".equals(parameterName) ) {
    	this.fChild = (org.eclipse.uml2.uml.InstanceSpecification) newValue;
    	return true;
    }
    if ("slot".equals(parameterName) ) {
    	this.fSlot = (org.eclipse.uml2.uml.Slot) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setChild(final InstanceSpecification pChild) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChild = pChild;
  }
  
  public void setSlot(final Slot pSlot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSlot = pSlot;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.childPortSlots";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildPortSlotsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChild, fSlot, fName};
  }
  
  @Override
  public ChildPortSlotsMatch toImmutable() {
    return isMutable() ? newMatch(fChild, fSlot, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
    
    result.append("\"slot\"=" + prettyPrintValue(fSlot) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    result = prime * result + ((fSlot == null) ? 0 : fSlot.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildPortSlotsMatch)) { // this should be infrequent
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
    ChildPortSlotsMatch other = (ChildPortSlotsMatch) obj;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    if (fSlot == null) {if (other.fSlot != null) return false;}
    else if (!fSlot.equals(other.fSlot)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public ChildPortSlotsQuerySpecification specification() {
    try {
    	return ChildPortSlotsQuerySpecification.instance();
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
  public static ChildPortSlotsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildPortSlotsMatch newMutableMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return new Mutable(pChild, pSlot, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildPortSlotsMatch newMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return new Immutable(pChild, pSlot, pName);
  }
  
  private static final class Mutable extends ChildPortSlotsMatch {
    Mutable(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
      super(pChild, pSlot, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildPortSlotsMatch {
    Immutable(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
      super(pChild, pSlot, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
