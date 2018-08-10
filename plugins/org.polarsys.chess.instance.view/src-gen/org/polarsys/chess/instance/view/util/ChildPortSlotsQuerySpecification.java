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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.polarsys.chess.instance.view.ChildPortSlotsMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsMatcher;
import org.polarsys.chess.instance.view.internal.ClientServerPortHelperWithInterfaceQuerySpecification;
import org.polarsys.chess.instance.view.internal.PortHelperWithValueQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsMatcher
 * @see ChildPortSlotsMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsMatcher> {
  private ChildPortSlotsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsMatcher instantiate() throws ViatraQueryException {
    return ChildPortSlotsMatcher.create();
  }
  
  @Override
  public ChildPortSlotsMatch newEmptyMatch() {
    return ChildPortSlotsMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsMatch newMatch(final Object... parameters) {
    return ChildPortSlotsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Slot) parameters[1], (java.lang.String) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ChildPortSlotsQuerySpecification INSTANCE = new ChildPortSlotsQuerySpecification();
    
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
    private final static ChildPortSlotsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pChild = new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pSlot = new PParameter("slot", "org.eclipse.uml2.uml.Slot", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pChild, parameter_pSlot, parameter_pName);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlots";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","slot","name");
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
              PVariable var_child = body.getOrCreateVariableByName("child");
              PVariable var_slot = body.getOrCreateVariableByName("slot");
              PVariable var_name = body.getOrCreateVariableByName("name");
              PVariable var_port = body.getOrCreateVariableByName("port");
              PVariable var_csp = body.getOrCreateVariableByName("csp");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_child, parameter_pChild),
                 new ExportedParameter(body, var_slot, parameter_pSlot),
                 new ExportedParameter(body, var_name, parameter_pName)
              ));
              // 	//find swSystemChild2(child, _, _, _, _);	InstanceSpecification.slot(child, slot)
              new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_child, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "slot")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
              new Equality(body, var__virtual_0_, var_slot);
              // 	Slot.definingFeature(slot, port)
              new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_slot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuralFeature")));
              new Equality(body, var__virtual_1_, var_port);
              // 	Port.name(port,name)
              new TypeConstraint(body, Tuples.flatTupleOf(var_port), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_port, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_2_, var_name);
              // 		ClientServerPort.base_Port(csp, port)
              new TypeConstraint(body, Tuples.flatTupleOf(var_csp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort")));
              PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_csp, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort", "base_Port")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
              new Equality(body, var__virtual_3_, var_port);
              // 	neg find portHelperWithValue(slot,_)
              new NegativePatternCall(body, new FlatTuple(var_slot, var___0_), PortHelperWithValueQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find clientServerPortHelperWithInterface (csp, _)
              new PositivePatternCall(body, new FlatTuple(var_csp, var___1_), ClientServerPortHelperWithInterfaceQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("Item");
              annotation.addAttribute("item", new ParameterReference("slot"));
              annotation.addAttribute("hierarchy", "child");
              annotation.addAttribute("label", "$name$ ( Provided Port)");
              addAnnotation(annotation);
          }
          {
              PAnnotation annotation = new PAnnotation("ContainsItem");
              annotation.addAttribute("container", new ParameterReference("child"));
              annotation.addAttribute("item", new ParameterReference("slot"));
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
