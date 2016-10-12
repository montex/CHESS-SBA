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
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.instance.view.ChildCHRTSpecItemMatch;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecItemQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childCHRTSpecItem pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildCHRTSpecItemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = chrtspecComment, hierarchy = "child", label = "CHRtSpecification")
 * pattern childCHRTSpecItem(chrtspecComment) {
 * 	//find childPortSlotsOperation(slot, operation, _);
 * 	find childCHRTSpec(chrtspecComment, _);
 * }
 * </pre></code>
 * 
 * @see ChildCHRTSpecItemMatch
 * @see ChildCHRTSpecItemProcessor
 * @see ChildCHRTSpecItemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildCHRTSpecItemMatcher extends BaseMatcher<ChildCHRTSpecItemMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildCHRTSpecItemMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildCHRTSpecItemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildCHRTSpecItemMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CHRTSPECCOMMENT = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildCHRTSpecItemMatcher.class);
  
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
  public ChildCHRTSpecItemMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ChildCHRTSpecItemMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return matches represented as a ChildCHRTSpecItemMatch object.
   * 
   */
  public Collection<ChildCHRTSpecItemMatch> getAllMatches(final Comment pChrtspecComment) {
    return rawGetAllMatches(new Object[]{pChrtspecComment});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return a match represented as a ChildCHRTSpecItemMatch object, or null if no match is found.
   * 
   */
  public ChildCHRTSpecItemMatch getOneArbitraryMatch(final Comment pChrtspecComment) {
    return rawGetOneArbitraryMatch(new Object[]{pChrtspecComment});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Comment pChrtspecComment) {
    return rawHasMatch(new Object[]{pChrtspecComment});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Comment pChrtspecComment) {
    return rawCountMatches(new Object[]{pChrtspecComment});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Comment pChrtspecComment, final IMatchProcessor<? super ChildCHRTSpecItemMatch> processor) {
    rawForEachMatch(new Object[]{pChrtspecComment}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Comment pChrtspecComment, final IMatchProcessor<? super ChildCHRTSpecItemMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChrtspecComment}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildCHRTSpecItemMatch newMatch(final Comment pChrtspecComment) {
    return ChildCHRTSpecItemMatch.newMatch(pChrtspecComment);
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Comment> rawAccumulateAllValuesOfchrtspecComment(final Object[] parameters) {
    Set<Comment> results = new HashSet<Comment>();
    rawAccumulateAllValues(POSITION_CHRTSPECCOMMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Comment> getAllValuesOfchrtspecComment() {
    return rawAccumulateAllValuesOfchrtspecComment(emptyArray());
  }
  
  @Override
  protected ChildCHRTSpecItemMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildCHRTSpecItemMatch.newMatch((org.eclipse.uml2.uml.Comment) t.get(POSITION_CHRTSPECCOMMENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildCHRTSpecItemMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildCHRTSpecItemMatch.newMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildCHRTSpecItemMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildCHRTSpecItemMatch.newMutableMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT]);
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
  public static IQuerySpecification<ChildCHRTSpecItemMatcher> querySpecification() throws IncQueryException {
    return ChildCHRTSpecItemQuerySpecification.instance();
  }
}
