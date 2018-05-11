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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatch;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;

/**
 * Generated pattern matcher API of the org.polarsys.chess.instance.view.childPortSlotsOperation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ChildPortSlotsOperationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}ContainsItem(container = slot, item = operation)
 * pattern childPortSlotsOperation(slot, operation, nameC) {
 * 	find childPortSlots(child, slot, _);
 * 	Slot.definingFeature(slot, port);
 * 	ClientServerPort.base_Port(csp, port);
 * 	find clientServerPortHelperWithInterface (csp,interface);
 * 	Interface.ownedOperation(interface, operationI);
 * 	
 * 	//retrieve the same operation owned by the referred component
 * 
 * 	InstanceSpecification.classifier(child, component);
 * 	
 *     Component.ownedOperation(component, operation);
 *     Operation.name(operationI, nameI);
 *     Operation.name(operation, nameC);
 *     check(nameI.compareTo(nameC)==0);
 * }
 * </pre></code>
 * 
 * @see ChildPortSlotsOperationMatch
 *  @see ChildPortSlotsOperationProcessor
 * @see ChildPortSlotsOperationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ChildPortSlotsOperationMatcher extends BaseMatcher<ChildPortSlotsOperationMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ChildPortSlotsOperationMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ChildPortSlotsOperationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (ChildPortSlotsOperationMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static ChildPortSlotsOperationMatcher create() throws ViatraQueryException {
    return new ChildPortSlotsOperationMatcher();
  }
  
  private final static int POSITION_SLOT = 0;
  
  private final static int POSITION_OPERATION = 1;
  
  private final static int POSITION_NAMEC = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChildPortSlotsOperationMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ChildPortSlotsOperationMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return matches represented as a ChildPortSlotsOperationMatch object.
   * 
   */
  public Collection<ChildPortSlotsOperationMatch> getAllMatches(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return rawGetAllMatches(new Object[]{pSlot, pOperation, pNameC});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return a match represented as a ChildPortSlotsOperationMatch object, or null if no match is found.
   * 
   */
  public ChildPortSlotsOperationMatch getOneArbitraryMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return rawGetOneArbitraryMatch(new Object[]{pSlot, pOperation, pNameC});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return rawHasMatch(new Object[]{pSlot, pOperation, pNameC});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return rawCountMatches(new Object[]{pSlot, pOperation, pNameC});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Slot pSlot, final Operation pOperation, final String pNameC, final IMatchProcessor<? super ChildPortSlotsOperationMatch> processor) {
    rawForEachMatch(new Object[]{pSlot, pOperation, pNameC}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Slot pSlot, final Operation pOperation, final String pNameC, final IMatchProcessor<? super ChildPortSlotsOperationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSlot, pOperation, pNameC}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pNameC the fixed value of pattern parameter nameC, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ChildPortSlotsOperationMatch newMatch(final Slot pSlot, final Operation pOperation, final String pNameC) {
    return ChildPortSlotsOperationMatch.newMatch(pSlot, pOperation, pNameC);
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Slot> rawAccumulateAllValuesOfslot(final Object[] parameters) {
    Set<Slot> results = new HashSet<Slot>();
    rawAccumulateAllValues(POSITION_SLOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot() {
    return rawAccumulateAllValuesOfslot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final ChildPortSlotsOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final Operation pOperation, final String pNameC) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    null, 
    pOperation, 
    pNameC
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final ChildPortSlotsOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final Slot pSlot, final String pNameC) {
    return rawAccumulateAllValuesOfoperation(new Object[]{
    pSlot, 
    null, 
    pNameC
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfnameC(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAMEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC() {
    return rawAccumulateAllValuesOfnameC(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC(final ChildPortSlotsOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfnameC(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nameC.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfnameC(final Slot pSlot, final Operation pOperation) {
    return rawAccumulateAllValuesOfnameC(new Object[]{
    pSlot, 
    pOperation, 
    null
    });
  }
  
  @Override
  protected ChildPortSlotsOperationMatch tupleToMatch(final Tuple t) {
    try {
        return ChildPortSlotsOperationMatch.newMatch((Slot) t.get(POSITION_SLOT), (Operation) t.get(POSITION_OPERATION), (String) t.get(POSITION_NAMEC));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPortSlotsOperationMatch arrayToMatch(final Object[] match) {
    try {
        return ChildPortSlotsOperationMatch.newMatch((Slot) match[POSITION_SLOT], (Operation) match[POSITION_OPERATION], (String) match[POSITION_NAMEC]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected ChildPortSlotsOperationMatch arrayToMatchMutable(final Object[] match) {
    try {
        return ChildPortSlotsOperationMatch.newMutableMatch((Slot) match[POSITION_SLOT], (Operation) match[POSITION_OPERATION], (String) match[POSITION_NAMEC]);
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
  public static IQuerySpecification<ChildPortSlotsOperationMatcher> querySpecification() throws ViatraQueryException {
    return ChildPortSlotsOperationQuerySpecification.instance();
  }
}
