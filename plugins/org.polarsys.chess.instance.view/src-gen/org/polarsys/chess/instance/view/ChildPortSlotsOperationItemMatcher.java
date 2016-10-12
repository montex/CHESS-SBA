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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.Operation;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatch;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPortSlotsOperationItem pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPortSlotsOperationItemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = operation, hierarchy = "child", label = "$nameC$ (Operation)")
 * pattern childPortSlotsOperationItem(operation, nameC) {
 *     find childPortSlotsOperation(_, operation, nameC);
 * }
 * </pre></code>
 * 
 * @see ChildPortSlotsOperationItemMatch
 * @see ChildPortSlotsOperationItemProcessor
 * @see ChildPortSlotsOperationItemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPortSlotsOperationItemMatcher extends BaseMatcher<ChildPortSlotsOperationItemMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPortSlotsOperationItemMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildPortSlotsOperationItemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildPortSlotsOperationItemMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OPERATION = 0;
  
  private final static int POSITION_NAMEC = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildPortSlotsOperationItemMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public ChildPortSlotsOperationItemMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public ChildPortSlotsOperationItemMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return matches represented as a ChildPortSlotsOperationItemMatch object.
   * 
   */
  public Collection<ChildPortSlotsOperationItemMatch> getAllMatches(final Operation pOperation, final String pNameC) {
    return rawGetAllMatches(new Object[]{pOperation, pNameC});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return a match represented as a ChildPortSlotsOperationItemMatch object, or null if no match is found.
   * 
   */
  public ChildPortSlotsOperationItemMatch getOneArbitraryMatch(final Operation pOperation, final String pNameC) {
    return rawGetOneArbitraryMatch(new Object[]{pOperation, pNameC});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pOperation, final String pNameC) {
    return rawHasMatch(new Object[]{pOperation, pNameC});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pOperation, final String pNameC) {
    return rawCountMatches(new Object[]{pOperation, pNameC});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pOperation, final String pNameC, final IMatchProcessor<? super ChildPortSlotsOperationItemMatch> processor) {
    rawForEachMatch(new Object[]{pOperation, pNameC}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pOperation, final String pNameC, final IMatchProcessor<? super ChildPortSlotsOperationItemMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOperation, pNameC}, processor);
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
  public ChildPortSlotsOperationItemMatch newMatch(final Operation pOperation, final String pNameC) {
    return ChildPortSlotsOperationItemMatch.newMatch(pOperation, pNameC);
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final ChildPortSlotsOperationItemMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final String pNameC) {
    return rawAccumulateAllValuesOfoperation(new Object[]{
    null, 
    pNameC
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfnameC(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAMEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC() {
    return rawAccumulateAllValuesOfnameC(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC(final ChildPortSlotsOperationItemMatch partialMatch) {
    return rawAccumulateAllValuesOfnameC(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC(final Operation pOperation) {
    return rawAccumulateAllValuesOfnameC(new Object[]{
    pOperation, 
    null
    });
  }
  
  @Override
  protected ChildPortSlotsOperationItemMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildPortSlotsOperationItemMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_OPERATION), (java.lang.String) t.get(POSITION_NAMEC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPortSlotsOperationItemMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildPortSlotsOperationItemMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (java.lang.String) match[POSITION_NAMEC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPortSlotsOperationItemMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildPortSlotsOperationItemMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (java.lang.String) match[POSITION_NAMEC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ChildPortSlotsOperationItemMatcher> querySpecification() throws IncQueryException {
    return ChildPortSlotsOperationItemQuerySpecification.instance();
  }
}