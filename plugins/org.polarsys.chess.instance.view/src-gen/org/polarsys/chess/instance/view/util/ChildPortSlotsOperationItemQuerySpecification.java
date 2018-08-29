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
package org.polarsys.chess.instance.view.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatcher;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsOperationItemMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsOperationItemMatcher
 * @see ChildPortSlotsOperationItemMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsOperationItemQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsOperationItemMatcher> {
  private ChildPortSlotsOperationItemQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsOperationItemQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsOperationItemMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsOperationItemMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsOperationItemMatcher instantiate() throws ViatraQueryException {
    return ChildPortSlotsOperationItemMatcher.create();
  }
  
  @Override
  public ChildPortSlotsOperationItemMatch newEmptyMatch() {
    return ChildPortSlotsOperationItemMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsOperationItemMatch newMatch(final Object... parameters) {
    return ChildPortSlotsOperationItemMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsOperationItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsOperationItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ChildPortSlotsOperationItemQuerySpecification INSTANCE = new ChildPortSlotsOperationItemQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPortSlotsOperationItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pOperation = new PParameter("operation", "org.eclipse.uml2.uml.Operation", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pNameC = new PParameter("nameC", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pOperation, parameter_pNameC);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlotsOperationItem";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("operation","nameC");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
          {
              PBody body = new PBody(this);
              PVariable var_operation = body.getOrCreateVariableByName("operation");
              PVariable var_nameC = body.getOrCreateVariableByName("nameC");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_operation, parameter_pOperation),
                 new ExportedParameter(body, var_nameC, parameter_pNameC)
              ));
              //     find childPortSlotsOperation(_, operation, nameC)
              new PositivePatternCall(body, new FlatTuple(var___0_, var_operation, var_nameC), ChildPortSlotsOperationQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("Item");
              annotation.addAttribute("item", new ParameterReference("operation"));
              annotation.addAttribute("hierarchy", "child");
              annotation.addAttribute("label", "$nameC$ (Operation)");
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
