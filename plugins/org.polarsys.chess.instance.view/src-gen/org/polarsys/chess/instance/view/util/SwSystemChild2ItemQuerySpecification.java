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
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
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
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemChild2ItemQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemChild2ItemMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemChild2ItemMatcher.on(engine);
  }
  
  @Override
  public SwSystemChild2ItemMatch newEmptyMatch() {
    return SwSystemChild2ItemMatch.newEmptyMatch();
  }
  
  @Override
  public SwSystemChild2ItemMatch newMatch(final Object... parameters) {
    return SwSystemChild2ItemMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (java.lang.String) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SwSystemChild2ItemQuerySpecification INSTANCE = make();
    
    public static SwSystemChild2ItemQuerySpecification make() {
      return new SwSystemChild2ItemQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SwSystemChild2ItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
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
      return Arrays.asList(new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("name", "java.lang.String"));
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
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_child, var___0_, var___1_, var_name), SwSystemChild2QuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_child, var_class, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification.classifier");
      	new TypeBinary(body, CONTEXT, var_class, var_classname, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern swSystemChild2Item";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("name");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String name = (java.lang.String) provider.getValue("name");
      			return evaluateExpression_1_1(name);
      		}
      
      },  null); 
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern swSystemChild2Item";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("classname");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String classname = (java.lang.String) provider.getValue("classname");
      			return evaluateExpression_1_2(classname);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("child"));
      	annotation.addAttribute("label", "$name$ (Instance)");
      	annotation.addAttribute("hierarchy", "child");
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
