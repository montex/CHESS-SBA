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
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.instance.view.SwSystemRootMatch;
import org.polarsys.chess.instance.view.util.SwSystemRootQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.swSystemRoot pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SwSystemRootMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = root, hierarchy = "root", label = "$name$ (Instance)")
 * //{@literal @}ContainsItem(container = instSpec, item = root)
 * pattern swSystemRoot(root, instSpec, name) {
 * 	find swSystemCHGaResourcePlatform(instSpec);
 * 	Package.packagedElement(instSpec, root);
 * 	InstanceSpecification(root);
 * 	InstanceSpecification.name(root, name);
 * 	check(!name.contains("."));
 * }
 * </pre></code>
 * 
 * @see SwSystemRootMatch
 * @see SwSystemRootProcessor
 * @see SwSystemRootQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SwSystemRootMatcher extends BaseMatcher<SwSystemRootMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SwSystemRootMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SwSystemRootMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SwSystemRootMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ROOT = 0;
  
  private final static int POSITION_INSTSPEC = 1;
  
  private final static int POSITION_NAME = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SwSystemRootMatcher.class);
  
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
  public SwSystemRootMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SwSystemRootMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a SwSystemRootMatch object.
   * 
   */
  public Collection<SwSystemRootMatch> getAllMatches(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawGetAllMatches(new Object[]{pRoot, pInstSpec, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a SwSystemRootMatch object, or null if no match is found.
   * 
   */
  public SwSystemRootMatch getOneArbitraryMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pRoot, pInstSpec, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawHasMatch(new Object[]{pRoot, pInstSpec, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawCountMatches(new Object[]{pRoot, pInstSpec, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName, final IMatchProcessor<? super SwSystemRootMatch> processor) {
    rawForEachMatch(new Object[]{pRoot, pInstSpec, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRoot the fixed value of pattern parameter root, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName, final IMatchProcessor<? super SwSystemRootMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRoot, pInstSpec, pName}, processor);
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
  public SwSystemRootMatch newMatch(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return SwSystemRootMatch.newMatch(pRoot, pInstSpec, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfroot(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_ROOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfroot() {
    return rawAccumulateAllValuesOfroot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfroot(final SwSystemRootMatch partialMatch) {
    return rawAccumulateAllValuesOfroot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfroot(final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawAccumulateAllValuesOfroot(new Object[]{
    null, 
    pInstSpec, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfinstSpec(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_INSTSPEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec() {
    return rawAccumulateAllValuesOfinstSpec(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec(final SwSystemRootMatch partialMatch) {
    return rawAccumulateAllValuesOfinstSpec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec(final InstanceSpecification pRoot, final String pName) {
    return rawAccumulateAllValuesOfinstSpec(new Object[]{
    pRoot, 
    null, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final SwSystemRootMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pRoot, final org.eclipse.uml2.uml.Package pInstSpec) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pRoot, 
    pInstSpec, 
    null
    });
  }
  
  @Override
  protected SwSystemRootMatch tupleToMatch(final Tuple t) {
    try {
    	return SwSystemRootMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) t.get(POSITION_ROOT), (org.eclipse.uml2.uml.Package) t.get(POSITION_INSTSPEC), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SwSystemRootMatch arrayToMatch(final Object[] match) {
    try {
    	return SwSystemRootMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_ROOT], (org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SwSystemRootMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SwSystemRootMatch.newMutableMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_ROOT], (org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<SwSystemRootMatcher> querySpecification() throws IncQueryException {
    return SwSystemRootQuerySpecification.instance();
  }
}
