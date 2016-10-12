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
import org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.swSystemChild2Item pattern,
 * to be used in conjunction with {@link SwSystemChild2ItemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SwSystemChild2ItemMatcher
 * @see SwSystemChild2ItemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemChild2ItemMatch extends BasePatternMatch {
  private InstanceSpecification fChild;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("child", "name");
  
  private SwSystemChild2ItemMatch(final InstanceSpecification pChild, final String pName) {
    this.fChild = pChild;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("child".equals(parameterName)) return this.fChild;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getChild() {
    return this.fChild;
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
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.swSystemChild2Item";
  }
  
  @Override
  public List<String> parameterNames() {
    return SwSystemChild2ItemMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChild, fName};
  }
  
  @Override
  public SwSystemChild2ItemMatch toImmutable() {
    return isMutable() ? newMatch(fChild, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SwSystemChild2ItemMatch)) { // this should be infrequent
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
    SwSystemChild2ItemMatch other = (SwSystemChild2ItemMatch) obj;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public SwSystemChild2ItemQuerySpecification specification() {
    try {
    	return SwSystemChild2ItemQuerySpecification.instance();
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
  public static SwSystemChild2ItemMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SwSystemChild2ItemMatch newMutableMatch(final InstanceSpecification pChild, final String pName) {
    return new Mutable(pChild, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SwSystemChild2ItemMatch newMatch(final InstanceSpecification pChild, final String pName) {
    return new Immutable(pChild, pName);
  }
  
  private static final class Mutable extends SwSystemChild2ItemMatch {
    Mutable(final InstanceSpecification pChild, final String pName) {
      super(pChild, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SwSystemChild2ItemMatch {
    Immutable(final InstanceSpecification pChild, final String pName) {
      super(pChild, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
