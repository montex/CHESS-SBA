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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecMatch;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPrivCHRTSpec pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPrivCHRTSpecMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}ContainsItem(container = privoperation, item = chrtspecComment)
 * pattern childPrivCHRTSpec(chrtspecComment, privoperation) {
 * 		
 * 	//find childPortSlotsOperation(slot, operation, _);
 * 	CHRtPortSlot.base_InstanceSpecification(chrtportslot, instancespec);
 * 	CHRtPortSlot.cH_RtSpecification(chrtportslot, chrt);
 * 	CHRtSpecification.context(chrt, privoperation);
 * 	CHRtSpecification.base_Comment(chrt, chrtspecComment);
 * 
 * 	
 * }
 * </pre></code>
 * 
 * @see ChildPrivCHRTSpecMatch
 * @see ChildPrivCHRTSpecProcessor
 * @see ChildPrivCHRTSpecQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPrivCHRTSpecMatcher extends BaseMatcher<ChildPrivCHRTSpecMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPrivCHRTSpecMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildPrivCHRTSpecMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildPrivCHRTSpecMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CHRTSPECCOMMENT = 0;
  
  private final static int POSITION_PRIVOPERATION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildPrivCHRTSpecMatcher.class);
  
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
  public ChildPrivCHRTSpecMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ChildPrivCHRTSpecMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return matches represented as a ChildPrivCHRTSpecMatch object.
   * 
   */
  public Collection<ChildPrivCHRTSpecMatch> getAllMatches(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return rawGetAllMatches(new Object[]{pChrtspecComment, pPrivoperation});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return a match represented as a ChildPrivCHRTSpecMatch object, or null if no match is found.
   * 
   */
  public ChildPrivCHRTSpecMatch getOneArbitraryMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return rawGetOneArbitraryMatch(new Object[]{pChrtspecComment, pPrivoperation});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return rawHasMatch(new Object[]{pChrtspecComment, pPrivoperation});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return rawCountMatches(new Object[]{pChrtspecComment, pPrivoperation});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation, final IMatchProcessor<? super ChildPrivCHRTSpecMatch> processor) {
    rawForEachMatch(new Object[]{pChrtspecComment, pPrivoperation}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation, final IMatchProcessor<? super ChildPrivCHRTSpecMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChrtspecComment, pPrivoperation}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pPrivoperation the fixed value of pattern parameter privoperation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildPrivCHRTSpecMatch newMatch(final Comment pChrtspecComment, final BehavioralFeature pPrivoperation) {
    return ChildPrivCHRTSpecMatch.newMatch(pChrtspecComment, pPrivoperation);
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
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Comment> getAllValuesOfchrtspecComment(final ChildPrivCHRTSpecMatch partialMatch) {
    return rawAccumulateAllValuesOfchrtspecComment(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Comment> getAllValuesOfchrtspecComment(final BehavioralFeature pPrivoperation) {
    return rawAccumulateAllValuesOfchrtspecComment(new Object[]{
    null, 
    pPrivoperation
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BehavioralFeature> rawAccumulateAllValuesOfprivoperation(final Object[] parameters) {
    Set<BehavioralFeature> results = new HashSet<BehavioralFeature>();
    rawAccumulateAllValues(POSITION_PRIVOPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfprivoperation() {
    return rawAccumulateAllValuesOfprivoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfprivoperation(final ChildPrivCHRTSpecMatch partialMatch) {
    return rawAccumulateAllValuesOfprivoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for privoperation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfprivoperation(final Comment pChrtspecComment) {
    return rawAccumulateAllValuesOfprivoperation(new Object[]{
    pChrtspecComment, 
    null
    });
  }
  
  @Override
  protected ChildPrivCHRTSpecMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildPrivCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) t.get(POSITION_CHRTSPECCOMMENT), (org.eclipse.uml2.uml.BehavioralFeature) t.get(POSITION_PRIVOPERATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildPrivCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT], (org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_PRIVOPERATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildPrivCHRTSpecMatch.newMutableMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT], (org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_PRIVOPERATION]);
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
  public static IQuerySpecification<ChildPrivCHRTSpecMatcher> querySpecification() throws IncQueryException {
    return ChildPrivCHRTSpecQuerySpecification.instance();
  }
}
