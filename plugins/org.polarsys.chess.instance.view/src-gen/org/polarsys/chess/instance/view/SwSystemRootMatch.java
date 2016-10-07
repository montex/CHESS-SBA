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
import org.polarsys.chess.instance.view.util.SwSystemRootQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.swSystemRoot pattern,
 * to be used in conjunction with {@link SwSystemRootMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SwSystemRootMatcher
 * @see SwSystemRootProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemRootMatch extends BasePatternMatch {
  private InstanceSpecification fRoot;
  
  private org.eclipse.uml2.uml.Package fInstSpec;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("root", "instSpec", "name");
  
  private SwSystemRootMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    this.fRoot = pRoot;
    this.fInstSpec = pInstSpec;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("root".equals(parameterName)) return this.fRoot;
    if ("instSpec".equals(parameterName)) return this.fInstSpec;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getRoot() {
    return this.fRoot;
  }
  
  public org.eclipse.uml2.uml.Package getInstSpec() {
    return this.fInstSpec;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("root".equals(parameterName) ) {
    	this.fRoot = (org.eclipse.uml2.uml.InstanceSpecification) newValue;
    	return true;
    }
    if ("instSpec".equals(parameterName) ) {
    	this.fInstSpec = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRoot(final InstanceSpecification pRoot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRoot = pRoot;
  }
  
  public void setInstSpec(final org.eclipse.uml2.uml.Package pInstSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstSpec = pInstSpec;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.swSystemRoot";
  }
  
  @Override
  public List<String> parameterNames() {
    return SwSystemRootMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRoot, fInstSpec, fName};
  }
  
  @Override
  public SwSystemRootMatch toImmutable() {
    return isMutable() ? newMatch(fRoot, fInstSpec, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"root\"=" + prettyPrintValue(fRoot) + ", ");
    
    result.append("\"instSpec\"=" + prettyPrintValue(fInstSpec) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRoot == null) ? 0 : fRoot.hashCode());
    result = prime * result + ((fInstSpec == null) ? 0 : fInstSpec.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SwSystemRootMatch)) { // this should be infrequent
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
    SwSystemRootMatch other = (SwSystemRootMatch) obj;
    if (fRoot == null) {if (other.fRoot != null) return false;}
    else if (!fRoot.equals(other.fRoot)) return false;
    if (fInstSpec == null) {if (other.fInstSpec != null) return false;}
    else if (!fInstSpec.equals(other.fInstSpec)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public SwSystemRootQuerySpecification specification() {
    try {
    	return SwSystemRootQuerySpecification.instance();
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
  public static SwSystemRootMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SwSystemRootMatch newMutableMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return new Mutable(pRoot, pInstSpec, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SwSystemRootMatch newMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return new Immutable(pRoot, pInstSpec, pName);
  }
  
  private static final class Mutable extends SwSystemRootMatch {
    Mutable(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
      super(pRoot, pInstSpec, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SwSystemRootMatch {
    Immutable(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
      super(pRoot, pInstSpec, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
