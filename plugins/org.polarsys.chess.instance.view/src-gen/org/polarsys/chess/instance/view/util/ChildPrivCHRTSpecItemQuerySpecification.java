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
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecItemMatch;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecItemMatcher;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPrivCHRTSpecItemMatcher in a type-safe way.
 * 
 * @see ChildPrivCHRTSpecItemMatcher
 * @see ChildPrivCHRTSpecItemMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPrivCHRTSpecItemQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPrivCHRTSpecItemMatcher> {
  private ChildPrivCHRTSpecItemQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPrivCHRTSpecItemQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecItemMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPrivCHRTSpecItemMatcher.on(engine);
  }
  
  @Override
  public ChildPrivCHRTSpecItemMatcher instantiate() throws ViatraQueryException {
    return ChildPrivCHRTSpecItemMatcher.create();
  }
  
  @Override
  public ChildPrivCHRTSpecItemMatch newEmptyMatch() {
    return ChildPrivCHRTSpecItemMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPrivCHRTSpecItemMatch newMatch(final Object... parameters) {
    return ChildPrivCHRTSpecItemMatch.newMatch((org.eclipse.uml2.uml.Comment) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification (visibility: PUBLIC, simpleName: ChildPrivCHRTSpecItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification (visibility: PUBLIC, simpleName: ChildPrivCHRTSpecItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ChildPrivCHRTSpecItemQuerySpecification INSTANCE = new ChildPrivCHRTSpecItemQuerySpecification();
    
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
    private final static ChildPrivCHRTSpecItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pChrtspecComment = new PParameter("chrtspecComment", "org.eclipse.uml2.uml.Comment", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pChrtspecComment);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPrivCHRTSpecItem";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("chrtspecComment");
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
              PVariable var_chrtspecComment = body.getOrCreateVariableByName("chrtspecComment");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_chrtspecComment, parameter_pChrtspecComment)
              ));
              // 	//find childPortSlotsOperation(slot, operation, _);	find childPrivCHRTSpec(chrtspecComment, _)
              new PositivePatternCall(body, new FlatTuple(var_chrtspecComment, var___0_), ChildPrivCHRTSpecQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("Item");
              annotation.addAttribute("item", new ParameterReference("chrtspecComment"));
              annotation.addAttribute("hierarchy", "child");
              annotation.addAttribute("label", "CHRtSpecification");
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
