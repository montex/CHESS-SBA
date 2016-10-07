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
import org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.chess.instance.view.swSystemChild2 pattern,
 * to be used in conjunction with {@link SwSystemChild2Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SwSystemChild2Matcher
 * @see SwSystemChild2Processor
 * 
 */
@SuppressWarnings("all")
public abstract class SwSystemChild2Match extends BasePatternMatch {
  private InstanceSpecification fChild;
  
  private org.eclipse.uml2.uml.Package fInstSpec;
  
  private InstanceSpecification fParent;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("child", "instSpec", "parent", "name");
  
  private SwSystemChild2Match(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    this.fChild = pChild;
    this.fInstSpec = pInstSpec;
    this.fParent = pParent;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("child".equals(parameterName)) return this.fChild;
    if ("instSpec".equals(parameterName)) return this.fInstSpec;
    if ("parent".equals(parameterName)) return this.fParent;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getChild() {
    return this.fChild;
  }
  
  public org.eclipse.uml2.uml.Package getInstSpec() {
    return this.fInstSpec;
  }
  
  public InstanceSpecification getParent() {
    return this.fParent;
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
    if ("instSpec".equals(parameterName) ) {
    	this.fInstSpec = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("parent".equals(parameterName) ) {
    	this.fParent = (org.eclipse.uml2.uml.InstanceSpecification) newValue;
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
  
  public void setInstSpec(final org.eclipse.uml2.uml.Package pInstSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstSpec = pInstSpec;
  }
  
  public void setParent(final InstanceSpecification pParent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParent = pParent;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.chess.instance.view.swSystemChild2";
  }
  
  @Override
  public List<String> parameterNames() {
    return SwSystemChild2Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fChild, fInstSpec, fParent, fName};
  }
  
  @Override
  public SwSystemChild2Match toImmutable() {
    return isMutable() ? newMatch(fChild, fInstSpec, fParent, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
    
    result.append("\"instSpec\"=" + prettyPrintValue(fInstSpec) + ", ");
    
    result.append("\"parent\"=" + prettyPrintValue(fParent) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    result = prime * result + ((fInstSpec == null) ? 0 : fInstSpec.hashCode());
    result = prime * result + ((fParent == null) ? 0 : fParent.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SwSystemChild2Match)) { // this should be infrequent
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
    SwSystemChild2Match other = (SwSystemChild2Match) obj;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    if (fInstSpec == null) {if (other.fInstSpec != null) return false;}
    else if (!fInstSpec.equals(other.fInstSpec)) return false;
    if (fParent == null) {if (other.fParent != null) return false;}
    else if (!fParent.equals(other.fParent)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public SwSystemChild2QuerySpecification specification() {
    try {
    	return SwSystemChild2QuerySpecification.instance();
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
  public static SwSystemChild2Match newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SwSystemChild2Match newMutableMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return new Mutable(pChild, pInstSpec, pParent, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SwSystemChild2Match newMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return new Immutable(pChild, pInstSpec, pParent, pName);
  }
  
  private static final class Mutable extends SwSystemChild2Match {
    Mutable(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
      super(pChild, pInstSpec, pParent, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SwSystemChild2Match {
    Immutable(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
      super(pChild, pInstSpec, pParent, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
