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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.polarsys.chess.instance.view.ChildPrivateOperationsMatch;
import org.polarsys.chess.instance.view.util.ChildPrivateOperationsQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPrivateOperations pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPrivateOperationsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = privoperation, hierarchy = "child", label = "$name$ (Operation)")
 * {@literal @}ContainsItem(container = child, item = privoperation)
 * pattern childPrivateOperations(child, privoperation, name) {
 * 		
 * 	InstanceSpecification.classifier(child, component);
 * 	Component.ownedOperation(component, privoperation);
 * 	neg find childPortSlotsOperation(_, privoperation, _);
 * 	Operation.name(privoperation, name);
 * }
 * </pre></code>
 * 
 * @see ChildPrivateOperationsMatch
 *  @see ChildPrivateOperationsProcessor
 * @see ChildPrivateOperationsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPrivateOperationsMatcher extends BaseMatcher<ChildPrivateOperationsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPrivateOperationsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ChildPrivateOperationsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (ChildPrivateOperationsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ChildPrivateOperationsMatcher create() throws ViatraQueryException {
    return new ChildPrivateOperationsMatcher();
  }
  
  private final static int POSITION_CHILD = 0;
  
  private final static int POSITION_PRIVOPERATION = 1;
  
  private final static int POSITION_NAME = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChildPrivateOperationsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ChildPrivateOperationsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a ChildPrivateOperationsMatch object.
   * 
   */
  public Collection<ChildPrivateOperationsMatch> getAllMatches(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return rawGetAllMatches(new Object[]{pChild, pPrivoperation, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a ChildPrivateOperationsMatch object, or null if no match is found.
   * 
   */
  public ChildPrivateOperationsMatch getOneArbitraryMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pChild, pPrivoperation, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return rawHasMatch(new Object[]{pChild, pPrivoperation, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return rawCountMatches(new Object[]{pChild, pPrivoperation, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName, final IMatchProcessor<? super ChildPrivateOperationsMatch> processor) {
    rawForEachMatch(new Object[]{pChild, pPrivoperation, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName, final IMatchProcessor<? super ChildPrivateOperationsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChild, pPrivoperation, pName}, processor);
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
  public ChildPrivateOperationsMatch newMatch(final InstanceSpecification pChild, final Operation pPrivoperation, final String pName) {
    return ChildPrivateOperationsMatch.newMatch(pChild, pPrivoperation, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfchild(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_CHILD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild() {
    return rawAccumulateAllValuesOfchild(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final ChildPrivateOperationsMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final Operation pPrivoperation, final String pName) {
    return rawAccumulateAllValuesOfchild(new Object[]{
    null, 
    pPrivoperation, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfprivoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_PRIVOPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfprivoperation() {
    return rawAccumulateAllValuesOfprivoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfprivoperation(final ChildPrivateOperationsMatch partialMatch) {
    return rawAccumulateAllValuesOfprivoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfprivoperation(final InstanceSpecification pChild, final String pName) {
    return rawAccumulateAllValuesOfprivoperation(new Object[]{
    pChild, 
    null, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final ChildPrivateOperationsMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pChild, final Operation pPrivoperation) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pChild, 
    pPrivoperation, 
    null
    });
  }
  
  @Override
  protected ChildPrivateOperationsMatch tupleToMatch(final Tuple t) {
    try {
        return ChildPrivateOperationsMatch.newMatch((InstanceSpecification) t.get(POSITION_CHILD), (Operation) t.get(POSITION_PRIVOPERATION), (String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPrivateOperationsMatch arrayToMatch(final Object[] match) {
    try {
        return ChildPrivateOperationsMatch.newMatch((InstanceSpecification) match[POSITION_CHILD], (Operation) match[POSITION_PRIVOPERATION], (String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPrivateOperationsMatch arrayToMatchMutable(final Object[] match) {
    try {
        return ChildPrivateOperationsMatch.newMutableMatch((InstanceSpecification) match[POSITION_CHILD], (Operation) match[POSITION_PRIVOPERATION], (String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ChildPrivateOperationsMatcher> querySpecification() throws ViatraQueryException {
    return ChildPrivateOperationsQuerySpecification.instance();
  }
}
