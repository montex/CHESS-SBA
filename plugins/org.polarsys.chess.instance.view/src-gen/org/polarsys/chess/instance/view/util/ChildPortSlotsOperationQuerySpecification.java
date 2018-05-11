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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatcher;
import org.polarsys.chess.instance.view.internal.ClientServerPortHelperWithInterfaceQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsOperationMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsOperationMatcher
 * @see ChildPortSlotsOperationMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsOperationQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsOperationMatcher> {
  private ChildPortSlotsOperationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsOperationQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsOperationMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return ChildPortSlotsOperationMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsOperationMatcher instantiate() throws ViatraQueryException {
    return ChildPortSlotsOperationMatcher.create();
  }
  
  @Override
  public ChildPortSlotsOperationMatch newEmptyMatch() {
    return ChildPortSlotsOperationMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsOperationMatch newMatch(final Object... parameters) {
    return ChildPortSlotsOperationMatch.newMatch((org.eclipse.uml2.uml.Slot) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (java.lang.String) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsOperationQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification (visibility: PUBLIC, simpleName: ChildPortSlotsOperationQuerySpecification, identifier: org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ChildPortSlotsOperationQuerySpecification INSTANCE = new ChildPortSlotsOperationQuerySpecification();
    
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
    private final static ChildPortSlotsOperationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pSlot = new PParameter("slot", "org.eclipse.uml2.uml.Slot", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pOperation = new PParameter("operation", "org.eclipse.uml2.uml.Operation", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pNameC = new PParameter("nameC", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pSlot, parameter_pOperation, parameter_pNameC);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlotsOperation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("slot","operation","nameC");
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
              PVariable var_slot = body.getOrCreateVariableByName("slot");
              PVariable var_operation = body.getOrCreateVariableByName("operation");
              PVariable var_nameC = body.getOrCreateVariableByName("nameC");
              PVariable var_child = body.getOrCreateVariableByName("child");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var_port = body.getOrCreateVariableByName("port");
              PVariable var_csp = body.getOrCreateVariableByName("csp");
              PVariable var_interface = body.getOrCreateVariableByName("interface");
              PVariable var_operationI = body.getOrCreateVariableByName("operationI");
              PVariable var_component = body.getOrCreateVariableByName("component");
              PVariable var_nameI = body.getOrCreateVariableByName("nameI");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_slot, parameter_pSlot),
                 new ExportedParameter(body, var_operation, parameter_pOperation),
                 new ExportedParameter(body, var_nameC, parameter_pNameC)
              ));
              // 	find childPortSlots(child, slot, _)
              new PositivePatternCall(body, new FlatTuple(var_child, var_slot, var___0_), ChildPortSlotsQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Slot.definingFeature(slot, port)
              new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_slot, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuralFeature")));
              new Equality(body, var__virtual_0_, var_port);
              // 	ClientServerPort.base_Port(csp, port)
              new TypeConstraint(body, Tuples.flatTupleOf(var_csp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_csp, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort", "base_Port")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
              new Equality(body, var__virtual_1_, var_port);
              // 	find clientServerPortHelperWithInterface (csp,interface)
              new PositivePatternCall(body, new FlatTuple(var_csp, var_interface), ClientServerPortHelperWithInterfaceQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Interface.ownedOperation(interface, operationI)
              new TypeConstraint(body, Tuples.flatTupleOf(var_interface), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Interface")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_interface, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Interface", "ownedOperation")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
              new Equality(body, var__virtual_2_, var_operationI);
              // 		//retrieve the same operation owned by the referred component	InstanceSpecification.classifier(child, component)
              new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_child, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier")));
              new Equality(body, var__virtual_3_, var_component);
              // 	    Component.ownedOperation(component, operation)
              new TypeConstraint(body, Tuples.flatTupleOf(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
              PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_component, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
              new Equality(body, var__virtual_4_, var_operation);
              //     Operation.name(operationI, nameI)
              new TypeConstraint(body, Tuples.flatTupleOf(var_operationI), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
              PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_operationI, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_5_, var_nameI);
              //     Operation.name(operation, nameC)
              new TypeConstraint(body, Tuples.flatTupleOf(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
              PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_operation, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_6_, var_nameC);
              //     check(nameI.compareTo(nameC)==0)
              new ExpressionEvaluation(body, new IExpressionEvaluator() {
              
                  @Override
                  public String getShortDescription() {
                      return "Expression evaluation from pattern childPortSlotsOperation";
                  }
                  
                  @Override
                  public Iterable<String> getInputParameterNames() {
                      return Arrays.asList("nameC", "nameI");}
              
                  @Override
                  public Object evaluateExpression(IValueProvider provider) throws Exception {
                      String nameC = (String) provider.getValue("nameC");
                      String nameI = (String) provider.getValue("nameI");
                      return evaluateExpression_1_1(nameC, nameI);
                  }
              },  null); 
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("ContainsItem");
              annotation.addAttribute("container", new ParameterReference("slot"));
              annotation.addAttribute("item", new ParameterReference("operation"));
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String nameC, final String nameI) {
    int _compareTo = nameI.compareTo(nameC);
    boolean _equals = (_compareTo == 0);
    return _equals;
  }
}
