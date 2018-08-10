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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatch;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatcher;

/**
 * A pattern-specific query specification that can instantiate SwSystemCHGaResourcePlatformMatcher in a type-safe way.
 * 
 * @see SwSystemCHGaResourcePlatformMatcher
 * @see SwSystemCHGaResourcePlatformMatch
 * 
 */
@SuppressWarnings("all")
public final class SwSystemCHGaResourcePlatformQuerySpecification extends BaseGeneratedEMFQuerySpecification<SwSystemCHGaResourcePlatformMatcher> {
  private SwSystemCHGaResourcePlatformQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemCHGaResourcePlatformQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemCHGaResourcePlatformMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemCHGaResourcePlatformMatcher.on(engine);
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatcher instantiate() throws ViatraQueryException {
    return SwSystemCHGaResourcePlatformMatcher.create();
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatch newEmptyMatch() {
    return SwSystemCHGaResourcePlatformMatch.newEmptyMatch();
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatch newMatch(final Object... parameters) {
    return SwSystemCHGaResourcePlatformMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification (visibility: PUBLIC, simpleName: SwSystemCHGaResourcePlatformQuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification (visibility: PUBLIC, simpleName: SwSystemCHGaResourcePlatformQuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SwSystemCHGaResourcePlatformQuerySpecification INSTANCE = new SwSystemCHGaResourcePlatformQuerySpecification();
    
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
    private final static SwSystemCHGaResourcePlatformQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pInstSpec = new PParameter("instSpec", "org.eclipse.uml2.uml.Package", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pInstSpec);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("instSpec");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      {
          PBody body = new PBody(this);
          PVariable var_instSpec = body.getOrCreateVariableByName("instSpec");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_instSpec, parameter_pInstSpec)
          ));
          // 	//find modelComponentView(modelComponentView);	CHGaResourcePlatform.base_Package(_, instSpec)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Core", "CHGaResourcePlatform")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://CHESS/Core", "CHGaResourcePlatform", "base_Package")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
          new Equality(body, var__virtual_0_, var_instSpec);
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("Item");
          annotation.addAttribute("item", new ParameterReference("instSpec"));
          annotation.addAttribute("hierarchy", "child");
          annotation.addAttribute("label", "$instSpec.name$ (Package)");
          addAnnotation(annotation);
      }
      return bodies;
    }
  }
}
