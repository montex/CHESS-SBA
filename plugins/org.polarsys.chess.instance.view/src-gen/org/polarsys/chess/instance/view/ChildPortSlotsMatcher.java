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
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.instance.view.ChildPortSlotsMatch;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPortSlots pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPortSlotsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = slot, hierarchy = "child", label = "$name$ ( Provided Port)")
 * {@literal @}ContainsItem(container = child, item = slot)
 * pattern childPortSlots(child, slot, name) {
 * 	//find swSystemChild2(child, _, _, _, _);
 * 	InstanceSpecification.slot(child, slot);
 * 	Slot.definingFeature(slot, port);
 * 	Port.name(port,name);
 * 	
 * 	ClientServerPort.base_Port(csp, port);
 * 
 * 	neg find portHelperWithValue(slot,_);
 * 	find clientServerPortHelperWithInterface (csp, _);
 * }
 * </pre></code>
 * 
 * @see ChildPortSlotsMatch
 * @see ChildPortSlotsProcessor
 * @see ChildPortSlotsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPortSlotsMatcher extends BaseMatcher<ChildPortSlotsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPortSlotsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ChildPortSlotsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ChildPortSlotsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CHILD = 0;
  
  private final static int POSITION_SLOT = 1;
  
  private final static int POSITION_NAME = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ChildPortSlotsMatcher.class);
  
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
  public ChildPortSlotsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ChildPortSlotsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a ChildPortSlotsMatch object.
   * 
   */
  public Collection<ChildPortSlotsMatch> getAllMatches(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return rawGetAllMatches(new Object[]{pChild, pSlot, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a ChildPortSlotsMatch object, or null if no match is found.
   * 
   */
  public ChildPortSlotsMatch getOneArbitraryMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pChild, pSlot, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return rawHasMatch(new Object[]{pChild, pSlot, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return rawCountMatches(new Object[]{pChild, pSlot, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName, final IMatchProcessor<? super ChildPortSlotsMatch> processor) {
    rawForEachMatch(new Object[]{pChild, pSlot, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName, final IMatchProcessor<? super ChildPortSlotsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pChild, pSlot, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildPortSlotsMatch newMatch(final InstanceSpecification pChild, final Slot pSlot, final String pName) {
    return ChildPortSlotsMatch.newMatch(pChild, pSlot, pName);
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
  public Set<InstanceSpecification> getAllValuesOfchild(final ChildPortSlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfchild(final Slot pSlot, final String pName) {
    return rawAccumulateAllValuesOfchild(new Object[]{
    null, 
    pSlot, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Slot> rawAccumulateAllValuesOfslot(final Object[] parameters) {
    Set<Slot> results = new HashSet<Slot>();
    rawAccumulateAllValues(POSITION_SLOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot() {
    return rawAccumulateAllValuesOfslot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final ChildPortSlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final InstanceSpecification pChild, final String pName) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    pChild, 
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
  public Set<String> getAllValuesOfname(final ChildPortSlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final InstanceSpecification pChild, final Slot pSlot) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pChild, 
    pSlot, 
    null
    });
  }
  
  @Override
  protected ChildPortSlotsMatch tupleToMatch(final Tuple t) {
    try {
    	return ChildPortSlotsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) t.get(POSITION_CHILD), (org.eclipse.uml2.uml.Slot) t.get(POSITION_SLOT), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPortSlotsMatch arrayToMatch(final Object[] match) {
    try {
    	return ChildPortSlotsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_CHILD], (org.eclipse.uml2.uml.Slot) match[POSITION_SLOT], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ChildPortSlotsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ChildPortSlotsMatch.newMutableMatch((org.eclipse.uml2.uml.InstanceSpecification) match[POSITION_CHILD], (org.eclipse.uml2.uml.Slot) match[POSITION_SLOT], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<ChildPortSlotsMatcher> querySpecification() throws IncQueryException {
    return ChildPortSlotsQuerySpecification.instance();
  }
}
