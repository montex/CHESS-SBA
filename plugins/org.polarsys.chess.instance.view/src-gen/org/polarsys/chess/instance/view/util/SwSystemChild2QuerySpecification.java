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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.polarsys.chess.instance.view.SwSystemChild2Match;
import org.polarsys.chess.instance.view.SwSystemChild2Matcher;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate SwSystemChild2Matcher in a type-safe way.
 * 
 * @see SwSystemChild2Matcher
 * @see SwSystemChild2Match
 * 
 */
@SuppressWarnings("all")
public final class SwSystemChild2QuerySpecification extends BaseGeneratedEMFQuerySpecification<SwSystemChild2Matcher> {
  private SwSystemChild2QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemChild2QuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemChild2Matcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SwSystemChild2Matcher.on(engine);
  }
  
  @Override
  public SwSystemChild2Matcher instantiate() throws ViatraQueryException {
    return SwSystemChild2Matcher.create();
  }
  
  @Override
  public SwSystemChild2Match newEmptyMatch() {
    return SwSystemChild2Match.newEmptyMatch();
  }
  
  @Override
  public SwSystemChild2Match newMatch(final Object... parameters) {
    return SwSystemChild2Match.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Package) parameters[1], (org.eclipse.uml2.uml.InstanceSpecification) parameters[2], (java.lang.String) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification (visibility: PUBLIC, simpleName: SwSystemChild2QuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification (visibility: PUBLIC, simpleName: SwSystemChild2QuerySpecification, identifier: org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.polarsys.chess.instance.view.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SwSystemChild2QuerySpecification INSTANCE = new SwSystemChild2QuerySpecification();
    
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
    private final static SwSystemChild2QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pChild = new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pInstSpec = new PParameter("instSpec", "org.eclipse.uml2.uml.Package", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pParent = new PParameter("parent", "org.eclipse.uml2.uml.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pChild, parameter_pInstSpec, parameter_pParent, parameter_pName);
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.swSystemChild2";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","instSpec","parent","name");
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
              PVariable var_instSpec = body.getOrCreateVariableByName("instSpec");
              PVariable var_parent = body.getOrCreateVariableByName("parent");
              PVariable var_name = body.getOrCreateVariableByName("name");
              PVariable var_parentname = body.getOrCreateVariableByName("parentname");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_child, parameter_pChild),
                 new ExportedParameter(body, var_instSpec, parameter_pInstSpec),
                 new ExportedParameter(body, var_parent, parameter_pParent),
                 new ExportedParameter(body, var_name, parameter_pName)
              ));
              // 	find swSystemCHGaResourcePlatform(instSpec)
              new PositivePatternCall(body, new FlatTuple(var_instSpec), SwSystemCHGaResourcePlatformQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Package.packagedElement(instSpec, child)
              new TypeConstraint(body, Tuples.flatTupleOf(var_instSpec), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_instSpec, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageableElement")));
              new Equality(body, var__virtual_0_, var_child);
              // 	InstanceSpecification(child)
              new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              // 	InstanceSpecification.name(child, name)
              new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_child, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_1_, var_name);
              // 		Package.packagedElement(instSpec, parent)
              new TypeConstraint(body, Tuples.flatTupleOf(var_instSpec), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_instSpec, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageableElement")));
              new Equality(body, var__virtual_2_, var_parent);
              // 	InstanceSpecification.name(parent, parentname)
              new TypeConstraint(body, Tuples.flatTupleOf(var_parent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification")));
              PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_parent, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
              new Equality(body, var__virtual_3_, var_parentname);
              // 	child != parent
              new Inequality(body, var_child, var_parent);
              // 	check(name.startsWith(parentname) && !name.equalsIgnoreCase(parentname) && !name.substring(parentname.length+1).contains("."))
              new ExpressionEvaluation(body, new IExpressionEvaluator() {
              
                  @Override
                  public String getShortDescription() {
                      return "Expression evaluation from pattern swSystemChild2";
                  }
                  
                  @Override
                  public Iterable<String> getInputParameterNames() {
                      return Arrays.asList("name", "parentname");}
              
                  @Override
                  public Object evaluateExpression(IValueProvider provider) throws Exception {
                      String name = (String) provider.getValue("name");
                      String parentname = (String) provider.getValue("parentname");
                      return evaluateExpression_1_1(name, parentname);
                  }
              },  null); 
              bodies.add(body);
          }
          {
              PAnnotation annotation = new PAnnotation("ContainsItem");
              annotation.addAttribute("container", new ParameterReference("parent"));
              annotation.addAttribute("item", new ParameterReference("child"));
              addAnnotation(annotation);
          }
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String name, final String parentname) {
    return ((name.startsWith(parentname) && (!name.equalsIgnoreCase(parentname))) && (!name.substring((parentname.length() + 1)).contains(".")));
  }
}
