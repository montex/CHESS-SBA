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
import org.polarsys.chess.instance.view.ChildCHRTSpecMatch;
import org.polarsys.chess.instance.view.ChildCHRTSpecMatcher;

/**
 * A pattern-specific query specification that can instantiate ChildCHRTSpecMatcher in a type-safe way.
 * 
 * @see ChildCHRTSpecMatcher
 * @see ChildCHRTSpecMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildCHRTSpecQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildCHRTSpecMatcher> {
  private ChildCHRTSpecQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildCHRTSpecQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildCHRTSpecMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildCHRTSpecMatcher.on(engine);
  }
  
  @Override
  public ChildCHRTSpecMatcher instantiate() throws ViatraQueryException {
    return ChildCHRTSpecMatcher.create();
  }
  
  @Override
  public ChildCHRTSpecMatch newEmptyMatch() {
    return ChildCHRTSpecMatch.newEmptyMatch();
  }
  
  @Override
  public ChildCHRTSpecMatch newMatch(final Object... parameters) {
    return ChildCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) parameters[0], (org.eclipse.uml2.uml.BehavioralFeature) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification (visibility: PUBLIC, simpleName: ChildCHRTSpecQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification (visibility: PUBLIC, simpleName: ChildCHRTSpecQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ChildCHRTSpecQuerySpecification INSTANCE = new ChildCHRTSpecQuerySpecification();
    
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
    private final static ChildCHRTSpecQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pChrtspecComment = new PParameter("chrtspecComment", "org.eclipse.uml2.uml.Comment", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pOperation = new PParameter("operation", "org.eclipse.uml2.uml.BehavioralFeature", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pChrtspecComment, parameter_pOperation);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childCHRTSpec";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("chrtspecComment","operation");
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
          PVariable var_chrtspecComment = body.getOrCreateVariableByName("chrtspecComment");
          PVariable var_operation = body.getOrCreateVariableByName("operation");
          PVariable var_chrtportslot = body.getOrCreateVariableByName("chrtportslot");
          PVariable var_slot = body.getOrCreateVariableByName("slot");
          PVariable var_chrt = body.getOrCreateVariableByName("chrt");
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_chrtspecComment, parameter_pChrtspecComment),
             new ExportedParameter(body, var_operation, parameter_pOperation)
          ));
          // 			//find childPortSlotsOperation(slot, operation, _);	CHRtPortSlot.base_Slot(chrtportslot, slot)
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrtportslot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrtportslot, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "base_Slot")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
          new Equality(body, var__virtual_0_, var_slot);
          // 	CHRtPortSlot.cH_RtSpecification(chrtportslot, chrt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrtportslot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrtportslot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "cH_RtSpecification")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification")));
          new Equality(body, var__virtual_1_, var_chrt);
          // 	CHRtSpecification.context(chrt, operation)
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrt, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "context")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
          new Equality(body, var__virtual_2_, var_operation);
          // 	CHRtSpecification.base_Comment(chrt, chrtspecComment)
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_chrt, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "base_Comment")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Comment")));
          new Equality(body, var__virtual_3_, var_chrtspecComment);
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("ContainsItem");
          annotation.addAttribute("container", new ParameterReference("operation"));
          annotation.addAttribute("item", new ParameterReference("chrtspecComment"));
          addAnnotation(annotation);
      }
      return bodies;
    }
  }
}
