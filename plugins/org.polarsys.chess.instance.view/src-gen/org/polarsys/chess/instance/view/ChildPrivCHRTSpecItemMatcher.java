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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecItemMatch;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPrivCHRTSpecItem pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPrivCHRTSpecItemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = chrtspecComment, hierarchy = "child", label = "CHRtSpecification")
 * pattern childPrivCHRTSpecItem(chrtspecComment) {
 * 	//find childPortSlotsOperation(slot, operation, _);
 * 	find childPrivCHRTSpec(chrtspecComment, _);
 * }
 * </pre></code>
 * 
 * @see ChildPrivCHRTSpecItemMatch
 *  @see ChildPrivCHRTSpecItemProcessor
 * @see ChildPrivCHRTSpecItemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPrivCHRTSpecItemMatcher extends BaseMatcher<ChildPrivCHRTSpecItemMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPrivCHRTSpecItemMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ChildPrivCHRTSpecItemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (ChildPrivCHRTSpecItemMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ChildPrivCHRTSpecItemMatcher create() throws ViatraQueryException {
    return new ChildPrivCHRTSpecItemMatcher();
  }
  
  private final static int POSITION_CHRTSPECCOMMENT = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChildPrivCHRTSpecItemMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ChildPrivCHRTSpecItemMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return matches represented as a ChildPrivCHRTSpecItemMatch object.
   * 
   */
  public Collection<ChildPrivCHRTSpecItemMatch> getAllMatches(final Comment pChrtspecComment) {
    return rawGetAllMatches(new Object[]{pChrtspecComment});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChrtspecComment the fixed value of pattern parameter chrtspecComment, or null if not bound.
   * @return a match represented as a ChildPrivCHRTSpecItemMatch object, or null if no match is found.
   * 
   */
  public ChildPrivCHRTSpecItemMatch getOneArbitraryMatch(final Comment pChrtspecComment) {
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
  public void forEachMatch(final Comment pChrtspecComment, final IMatchProcessor<? super ChildPrivCHRTSpecItemMatch> processor) {
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
  public boolean forOneArbitraryMatch(final Comment pChrtspecComment, final IMatchProcessor<? super ChildPrivCHRTSpecItemMatch> processor) {
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
  public ChildPrivCHRTSpecItemMatch newMatch(final Comment pChrtspecComment) {
    return ChildPrivCHRTSpecItemMatch.newMatch(pChrtspecComment);
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Comment> rawAccumulateAllValuesOfchrtspecComment(final Object[] parameters) {
    Set<Comment> results = new HashSet<Comment>();
    rawAccumulateAllValues(POSITION_CHRTSPECCOMMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for chrtspecComment.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Comment> getAllValuesOfchrtspecComment() {
    return rawAccumulateAllValuesOfchrtspecComment(emptyArray());
  }
  
  @Override
  protected ChildPrivCHRTSpecItemMatch tupleToMatch(final Tuple t) {
    try {
        return ChildPrivCHRTSpecItemMatch.newMatch((Comment) t.get(POSITION_CHRTSPECCOMMENT));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecItemMatch arrayToMatch(final Object[] match) {
    try {
        return ChildPrivCHRTSpecItemMatch.newMatch((Comment) match[POSITION_CHRTSPECCOMMENT]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecItemMatch arrayToMatchMutable(final Object[] match) {
    try {
        return ChildPrivCHRTSpecItemMatch.newMutableMatch((Comment) match[POSITION_CHRTSPECCOMMENT]);
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
  public static IQuerySpecification<ChildPrivCHRTSpecItemMatcher> querySpecification() throws ViatraQueryException {
    return ChildPrivCHRTSpecItemQuerySpecification.instance();
  }
}
