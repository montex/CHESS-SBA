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

package org.polarsys.chess.instance.view.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.polarsys.chess.instance.view.ChildPrivateOperationsMatch;
import org.polarsys.chess.instance.view.ChildPrivateOperationsMatcher;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPrivateOperationsMatcher in a type-safe way.
 * 
 * @see ChildPrivateOperationsMatcher
 * @see ChildPrivateOperationsMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPrivateOperationsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPrivateOperationsMatcher> {
  private ChildPrivateOperationsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPrivateOperationsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPrivateOperationsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildPrivateOperationsMatcher.on(engine);
  }
  
  @Override
  public ChildPrivateOperationsMatch newEmptyMatch() {
    return ChildPrivateOperationsMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPrivateOperationsMatch newMatch(final Object... parameters) {
    return ChildPrivateOperationsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static ChildPrivateOperationsQuerySpecification INSTANCE = make();
    
    public static ChildPrivateOperationsQuerySpecification make() {
      return new ChildPrivateOperationsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPrivateOperationsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPrivateOperations";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","privoperation","name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("privoperation", "org.eclipse.uml2.uml.Operation"),new PParameter("name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_privoperation = body.getOrCreateVariableByName("privoperation");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_privoperation, "privoperation"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_child, var_component, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification.classifier");
      	new TypeUnary(body, var_component, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component"), "http://www.eclipse.org/uml2/5.0.0/UML/Component");
      	new TypeBinary(body, CONTEXT, var_component, var_privoperation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedOperation");
      	new NegativePatternCall(body, new FlatTuple(var___0_, var_privoperation, var___1_), ChildPortSlotsOperationQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_privoperation, var_name, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("privoperation"));
      	annotation.addAttribute("label", "$name$ (Operation)");
      	annotation.addAttribute("hierarchy", "child");
      	addAnnotation(annotation);
      }
      {
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("child"));
      	annotation.addAttribute("item", new ParameterReference("privoperation"));
      	addAnnotation(annotation);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
