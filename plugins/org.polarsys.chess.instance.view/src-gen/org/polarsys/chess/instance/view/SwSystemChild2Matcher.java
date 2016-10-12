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
import org.polarsys.chess.instance.view.SwSystemChild2Match;
import org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.swSystemChild2 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SwSystemChild2Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}ContainsItem(container = parent, item = child)
 * 
 * pattern swSystemChild2(child, instSpec, parent, name) {
 * 	find swSystemCHGaResourcePlatform(instSpec);
 * 	Package.packagedElement(instSpec, child);
 * 	InstanceSpecification(child);
 * 	InstanceSpecification.name(child, name);
 * 	
 * 	Package.packagedElement(instSpec, parent);
 * 	InstanceSpecification.name(parent, parentname);
 * 	child != parent;
 * 	check(name.startsWith(parentname) && !name.equalsIgnoreCase(parentname) && !name.substring(parentname.length+1).contains("."));
 * 	
 * }
 * </pre></code>
 * 
 * @see SwSystemChild2Match
 * @see SwSystemChild2Processor
 * @see SwSystemChild2QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SwSystemChild2Matcher extends BaseMatcher<SwSystemChild2Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SwSystemChild2Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SwSystemChild2Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SwSystemChild2Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CHILD = 0;
  
  private final static int POSITION_INSTSPEC = 1;
  
  private final static int POSITION_PARENT = 2;
  
  private final static int POSITION_NAME = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SwSystemChild2Matcher.class);
  
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
  public SwSystemChild2Matcher(final Notifier emfRoot) throws IncQueryException {
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
  public SwSystemChild2Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a SwSystemChild2Match object.
   * 
   */
  public Collection<SwSystemChild2Match> getAllMatches(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return rawGetAllMatches(new Object[]{pChild, pInstSpec, pParent, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a SwSystemChild2Match object, or null if no match is found.
   * 
   */
  public SwSystemChild2Match getOneArbitraryMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pChild, pInstSpec, pParent, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return rawHasMatch(new Object[]{pChild, pInstSpec, pParent, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return rawCountMatches(new Object[]{pChild, pInstSpec, pParent, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName, final IMatchProcessor<? super SwSystemChild2Match> processor) {
    rawForEachMatch(new Object[]{pChild, pInstSpec, pParent, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pInstSpec the fixed value of pattern parameter instSpec, or null if not bound.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName, final IMatchProcessor<? super SwSystemChild2Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChild, pInstSpec, pParent, pName}, processor);
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
  public SwSystemChild2Match newMatch(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return SwSystemChild2Match.newMatch(pChild, pInstSpec, pParent, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfchild(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_CHILD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild() {
    return rawAccumulateAllValuesOfchild(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final SwSystemChild2Match partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent, final String pName) {
    return rawAccumulateAllValuesOfchild(new Object[]{
    null, 
    pInstSpec, 
    pParent, 
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
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec(final SwSystemChild2Match partialMatch) {
    return rawAccumulateAllValuesOfinstSpec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for instSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfinstSpec(final InstanceSpecification pChild, final InstanceSpecification pParent, final String pName) {
    return rawAccumulateAllValuesOfinstSpec(new Object[]{
    pChild, 
    null, 
    pParent, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfparent(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_PARENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfparent() {
    return rawAccumulateAllValuesOfparent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfparent(final SwSystemChild2Match partialMatch) {
    return rawAccumulateAllValuesOfparent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfparent(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final String pName) {
    return rawAccumulateAllValuesOfparent(new Object[]{
    pChild, 
    pInstSpec, 
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
  public Set<String> getAllValuesOfname(final SwSystemChild2Match partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pChild, final org.eclipse.uml2.uml.Package pInstSpec, final InstanceSpecification pParent) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pChild, 
    pInstSpec, 
    pParent, 
    null
    });
  }
  
  @Override
  protected SwSystemChild2Match tupleToMatch(final Tuple t) {
    try {
    	return SwSystemChild2Match.newMatch((org.eclipse.uml2.uml.InstanceSpecification) t.get(POSITION_CHILD), (org.eclipse.uml2.uml.Package) t.get(POSITION_INSTSPEC), (org.eclipse.uml2.uml.InstanceSpecification) t.get(POSITION_PARENT), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SwSystemChild2Match arrayToMatch(final Object[] match) {
    try {
    	return SwSystemChild2Match.newMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_CHILD], (org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC], (org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_PARENT], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SwSystemChild2Match arrayToMatchMutable(final Object[] match) {
    try {
    	return SwSystemChild2Match.newMutableMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_CHILD], (org.eclipse.uml2.uml.Package) match[POSITION_INSTSPEC], (org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_PARENT], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<SwSystemChild2Matcher> querySpecification() throws IncQueryException {
    return SwSystemChild2QuerySpecification.instance();
  }
}
