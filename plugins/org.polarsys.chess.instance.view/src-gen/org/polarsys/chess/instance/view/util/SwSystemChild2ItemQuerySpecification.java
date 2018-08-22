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
import org.polarsys.chess.instance.view.SwSystemChild2ItemMatch;
import org.polarsys.chess.instance.view.SwSystemChild2ItemMatcher;
import org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification;

/**
 * A pattern-specific query specification that can instantiate SwSystemChild2ItemMatcher in a type-safe way.
 * 
 * @see SwSystemChild2ItemMatcher
 * @see SwSystemChild2ItemMatch
 * 
 */
@SuppressWarnings("all")
public final class SwSystemChild2ItemQuerySpecification extends BaseGeneratedEMFQuerySpecification<SwSystemChild2ItemMatcher> {
  private SwSystemChild2ItemQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemChild2ItemQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemChild2ItemMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemChild2ItemMatcher.on(engine);
  }
  
  @Override
  public SwSystemChild2ItemMatcher instantiate() throws ViatraQueryException {
    return SwSystemChild2ItemMatcher.create();
  }
  
  @Override
  public SwSystemChild2ItemMatch newEmptyMatch() {
    return SwSystemChild2ItemMatch.newEmptyMatch();
  }
  
  @Override
  public SwSystemChild2ItemMatch newMatch(final Object... parameters) {
    return SwSystemChild2ItemMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification (visibility: PUBLIC, simpleName: SwSystemChild2ItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification (visibility: PUBLIC, simpleName: SwSystemChild2ItemQuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SwSystemChild2ItemQuerySpecification INSTANCE = new SwSystemChild2ItemQuerySpecification();
    
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
    private final static SwSystemChild2ItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pChild = new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pChild, parameter_pName);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.swSystemChild2Item";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","name");
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
              PVariable var_name = body.getOrCreateVariableByName("name");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
              PVariable var_class = body.getOrCreateVariableByName("class");
              PVariable var_classname = body.getOrCreateVariableByName("classname");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_child, parameter_pChild),
                 new ExportedParameter(body, var_name, parameter_pName)
              ));
              // 		find  swSystemChild2(child, _,  _, name)
              new PositivePatternCall(body, new FlatTuple(var_child, var___0_, var___1_, var_name), SwSystemChild2QuerySpecification.instance().getInternalQueryRepresentation());
              // 	//check(name.startsWith(parentname) && !name.equalsIgnoreCase(parentname) && !name.substring(parentname.length+1).contains("."));	InstanceSpecification.classifier(child, class)
              new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_child, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier")));
              new Equality(body, var__virtual_0_, var_class);
              // 	Classifier.name(class, classname)
              new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_class, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_1_, var_classname);
              // 		check(name.contains("."))
              new ExpressionEvaluation(body, new IExpressionEvaluator() {
              
                  @Override
                  public String getShortDescription() {
                      return "Expression evaluation from pattern swSystemChild2Item";
                  }
                  
                  @Override
                  public Iterable<String> getInputParameterNames() {
                      return Arrays.asList("name");}
              
                  @Override
                  public Object evaluateExpression(IValueProvider provider) throws Exception {
                      String name = (String) provider.getValue("name");
                      return evaluateExpression_1_1(name);
                  }
              },  null); 
              // 	check(!classname.empty)
              new ExpressionEvaluation(body, new IExpressionEvaluator() {
              
                  @Override
                  public String getShortDescription() {
                      return "Expression evaluation from pattern swSystemChild2Item";
                  }
                  
                  @Override
                  public Iterable<String> getInputParameterNames() {
                      return Arrays.asList("classname");}
              
                  @Override
                  public Object evaluateExpression(IValueProvider provider) throws Exception {
                      String classname = (String) provider.getValue("classname");
                      return evaluateExpression_1_2(classname);
                  }
              },  null); 
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("Item");
              annotation.addAttribute("item", new ParameterReference("child"));
              annotation.addAttribute("hierarchy", "child");
              annotation.addAttribute("label", "$name$ (Instance)");
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String name) {
    boolean _contains = name.contains(".");
    return _contains;
  }
  
  private static boolean evaluateExpression_1_2(final String classname) {
    boolean _isEmpty = classname.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
}
