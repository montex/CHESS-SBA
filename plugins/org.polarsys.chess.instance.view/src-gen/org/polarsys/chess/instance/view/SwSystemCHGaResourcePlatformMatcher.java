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
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatch;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SwSystemCHGaResourcePlatformMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = instSpec, hierarchy = "child", label = "$instSpec.name$ (Package)")
 * //{@literal @}ContainsItem(container = modelComponentView, item = instSpec)
 * pattern swSystemCHGaResourcePlatform(instSpec) {
 * 	//find modelComponentView(modelComponentView);
 * 	CHGaResourcePlatform.base_Package(_, instSpec);
 * }
 * </pre></code>
 * 
 * @see SwSystemCHGaResourcePlatformMatch
 *  @see SwSystemCHGaResourcePlatformProcessor
 * @see SwSystemCHGaResourcePlatformQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SwSystemCHGaResourcePlatformMatcher extends BaseMatcher<SwSystemCHGaResourcePlatformMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SwSystemCHGaResourcePlatformMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    SwSystemCHGaResourcePlatformMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (SwSystemCHGaResourcePlatformMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static SwSystemCHGaResourcePlatformMatcher create() throws ViatraQueryException {
    return new SwSystemCHGaResourcePlatformMatcher();
  }
  
  private final static int POSITION_INSTSPEC = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SwSystemCHGaResourcePlatformMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private SwSystemCHGaResourcePlatformMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return matches represented as a SwSystemCHGaResourcePlatformMatch object.
   * 
   */
  public Collection<SwSystemCHGaResourcePlatformMatch> getAllMatches(final org.eclipse.uml2.uml.Package pInstSpec) {
    return rawGetAllMatches(new Object[]{pInstSpec});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return a match represented as a SwSystemCHGaResourcePlatformMatch object, or null if no match is found.
   * 
   */
  public SwSystemCHGaResourcePlatformMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    return rawGetOneArbitraryMatch(new Object[]{pInstSpec});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    return rawHasMatch(new Object[]{pInstSpec});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Package pInstSpec) {
    return rawCountMatches(new Object[]{pInstSpec});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Package pInstSpec, final IMatchProcessor<? super SwSystemCHGaResourcePlatformMatch> processor) {
    rawForEachMatch(new Object[]{pInstSpec}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Package pInstSpec, final IMatchProcessor<? super SwSystemCHGaResourcePlatformMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInstSpec}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SwSystemCHGaResourcePlatformMatch newMatch(final org.eclipse.uml2.uml.Package pInstSpec) {
    return SwSystemCHGaResourcePlatformMatch.newMatch(pInstSpec);
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfinstSpec(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_INSTSPEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec() {
    return rawAccumulateAllValuesOfinstSpec(emptyArray());
  }
  
  @Override
  protected SwSystemCHGaResourcePlatformMatch tupleToMatch(final Tuple t) {
    try {
        return SwSystemCHGaResourcePlatformMatch.newMatch((org.eclipse.uml2.uml.Package) t.get(POSITION_INSTSPEC));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SwSystemCHGaResourcePlatformMatch arrayToMatch(final Object[] match) {
    try {
        return SwSystemCHGaResourcePlatformMatch.newMatch((org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SwSystemCHGaResourcePlatformMatch arrayToMatchMutable(final Object[] match) {
    try {
        return SwSystemCHGaResourcePlatformMatch.newMutableMatch((org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC]);
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
  public static IQuerySpecification<SwSystemCHGaResourcePlatformMatcher> querySpecification() throws ViatraQueryException {
    return SwSystemCHGaResourcePlatformQuerySpecification.instance();
  }
}
