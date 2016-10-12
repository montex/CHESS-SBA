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
import org.polarsys.chess.instance.view.ChildCHRTSpecMatch;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childCHRTSpec pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildCHRTSpecMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}ContainsItem(container = operation, item = chrtspecComment)
 * pattern childCHRTSpec(chrtspecComment, operation) {
 * 		
 * 	//find childPortSlotsOperation(slot, operation, _);
 * 	CHRtPortSlot.base_Slot(chrtportslot, slot);
 * 	CHRtPortSlot.cH_RtSpecification(chrtportslot, chrt);
 * 	CHRtSpecification.context(chrt, operation);
 * 	CHRtSpecification.base_Comment(chrt, chrtspecComment);
 * 
 * 	
 * }
 * </pre></code>
 * 
 * @see ChildCHRTSpecMatch
 * @see ChildCHRTSpecProcessor
 * @see ChildCHRTSpecQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildCHRTSpecMatcher extends BaseMatcher<ChildCHRTSpecMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildCHRTSpecMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildCHRTSpecMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildCHRTSpecMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CHRTSPECCOMMENT = 0;
  
  private final static int POSITION_OPERATION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildCHRTSpecMatcher.class);
  
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
  public ChildCHRTSpecMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ChildCHRTSpecMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return matches represented as a ChildCHRTSpecMatch object.
   * 
   */
  public Collection<ChildCHRTSpecMatch> getAllMatches(final Comment pChrtspecComment, final BehavioralFeature pOperation) {
    return rawGetAllMatches(new Object[]{pChrtspecComment, pOperation});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return a match represented as a ChildCHRTSpecMatch object, or null if no match is found.
   * 
   */
  public ChildCHRTSpecMatch getOneArbitraryMatch(final Comment pChrtspecComment, final BehavioralFeature pOperation) {
    return rawGetOneArbitraryMatch(new Object[]{pChrtspecComment, pOperation});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Comment pChrtspecComment, final BehavioralFeature pOperation) {
    return rawHasMatch(new Object[]{pChrtspecComment, pOperation});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Comment pChrtspecComment, final BehavioralFeature pOperation) {
    return rawCountMatches(new Object[]{pChrtspecComment, pOperation});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Comment pChrtspecComment, final BehavioralFeature pOperation, final IMatchProcessor<? super ChildCHRTSpecMatch> processor) {
    rawForEachMatch(new Object[]{pChrtspecComment, pOperation}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Comment pChrtspecComment, final BehavioralFeature pOperation, final IMatchProcessor<? super ChildCHRTSpecMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChrtspecComment, pOperation}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildCHRTSpecMatch newMatch(final Comment pChrtspecComment, final BehavioralFeature pOperation) {
    return ChildCHRTSpecMatch.newMatch(pChrtspecComment, pOperation);
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
  public Set<Comment> getAllValuesOfchrtspecComment(final ChildCHRTSpecMatch partialMatch) {
    return rawAccumulateAllValuesOfchrtspecComment(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Comment> getAllValuesOfchrtspecComment(final BehavioralFeature pOperation) {
    return rawAccumulateAllValuesOfchrtspecComment(new Object[]{
    null, 
    pOperation
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BehavioralFeature> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<BehavioralFeature> results = new HashSet<BehavioralFeature>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfoperation(final ChildCHRTSpecMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfoperation(final Comment pChrtspecComment) {
    return rawAccumulateAllValuesOfoperation(new Object[]{
    pChrtspecComment, 
    null
    });
  }
  
  @Override
  protected ChildCHRTSpecMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) t.get(POSITION_CHRTSPECCOMMENT), (org.eclipse.uml2.uml.BehavioralFeature) t.get(POSITION_OPERATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildCHRTSpecMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT], (org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_OPERATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildCHRTSpecMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildCHRTSpecMatch.newMutableMatch((org.eclipse.uml2.uml.Comment) match[POSITION_CHRTSPECCOMMENT], (org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_OPERATION]);
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
  public static IQuerySpecification<ChildCHRTSpecMatcher> querySpecification() throws IncQueryException {
    return ChildCHRTSpecQuerySpecification.instance();
  }
}