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
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.polarsys.chess.instance.view.SwSystemChild2ItemMatch;
import org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.swSystemChild2Item pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SwSystemChild2ItemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = child, hierarchy = "child", label = "$name$ (Instance)")
 * pattern swSystemChild2Item(child, name) {
 * 	
 * 	find  swSystemChild2(child, _,  _, name);
 * 	//check(name.startsWith(parentname) && !name.equalsIgnoreCase(parentname) && !name.substring(parentname.length+1).contains("."));
 * 	InstanceSpecification.classifier(child, class);
 * 	Classifier.name(class, classname);
 * 	
 * 	check(name.contains("."));
 * 	check(!classname.empty);
 * 	
 * }
 * </pre></code>
 * 
 * @see SwSystemChild2ItemMatch
 *  @see SwSystemChild2ItemProcessor
 * @see SwSystemChild2ItemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SwSystemChild2ItemMatcher extends BaseMatcher<SwSystemChild2ItemMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SwSystemChild2ItemMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    SwSystemChild2ItemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (SwSystemChild2ItemMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static SwSystemChild2ItemMatcher create() throws ViatraQueryException {
    return new SwSystemChild2ItemMatcher();
  }
  
  private final static int POSITION_CHILD = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SwSystemChild2ItemMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private SwSystemChild2ItemMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a SwSystemChild2ItemMatch object.
   * 
   */
  public Collection<SwSystemChild2ItemMatch> getAllMatches(final InstanceSpecification pChild, final String pName) {
    return rawGetAllMatches(new Object[]{pChild, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a SwSystemChild2ItemMatch object, or null if no match is found.
   * 
   */
  public SwSystemChild2ItemMatch getOneArbitraryMatch(final InstanceSpecification pChild, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pChild, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pChild, final String pName) {
    return rawHasMatch(new Object[]{pChild, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pChild, final String pName) {
    return rawCountMatches(new Object[]{pChild, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pChild, final String pName, final IMatchProcessor<? super SwSystemChild2ItemMatch> processor) {
    rawForEachMatch(new Object[]{pChild, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pChild, final String pName, final IMatchProcessor<? super SwSystemChild2ItemMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChild, pName}, processor);
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
  public SwSystemChild2ItemMatch newMatch(final InstanceSpecification pChild, final String pName) {
    return SwSystemChild2ItemMatch.newMatch(pChild, pName);
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
  public Set<InstanceSpecification> getAllValuesOfchild(final SwSystemChild2ItemMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final String pName) {
    return rawAccumulateAllValuesOfchild(new Object[]{
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
  public Set<String> getAllValuesOfname(final SwSystemChild2ItemMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pChild) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pChild, 
    null
    });
  }
  
  @Override
  protected SwSystemChild2ItemMatch tupleToMatch(final Tuple t) {
    try {
        return SwSystemChild2ItemMatch.newMatch((InstanceSpecification) t.get(POSITION_CHILD), (String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SwSystemChild2ItemMatch arrayToMatch(final Object[] match) {
    try {
        return SwSystemChild2ItemMatch.newMatch((InstanceSpecification) match[POSITION_CHILD], (String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SwSystemChild2ItemMatch arrayToMatchMutable(final Object[] match) {
    try {
        return SwSystemChild2ItemMatch.newMutableMatch((InstanceSpecification) match[POSITION_CHILD], (String) match[POSITION_NAME]);
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
  public static IQuerySpecification<SwSystemChild2ItemMatcher> querySpecification() throws ViatraQueryException {
    return SwSystemChild2ItemQuerySpecification.instance();
  }
}
