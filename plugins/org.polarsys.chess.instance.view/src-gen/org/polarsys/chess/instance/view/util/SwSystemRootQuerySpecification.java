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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.polarsys.chess.instance.view.SwSystemRootMatch;
import org.polarsys.chess.instance.view.SwSystemRootMatcher;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate SwSystemRootMatcher in a type-safe way.
 * 
 * @see SwSystemRootMatcher
 * @see SwSystemRootMatch
 * 
 */
@SuppressWarnings("all")
public final class SwSystemRootQuerySpecification extends BaseGeneratedEMFQuerySpecification<SwSystemRootMatcher> {
  private SwSystemRootQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemRootQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemRootMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemRootMatcher.on(engine);
  }
  
  @Override
  public SwSystemRootMatch newEmptyMatch() {
    return SwSystemRootMatch.newEmptyMatch();
  }
  
  @Override
  public SwSystemRootMatch newMatch(final Object... parameters) {
    return SwSystemRootMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Package) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static SwSystemRootQuerySpecification INSTANCE = make();
    
    public static SwSystemRootQuerySpecification make() {
      return new SwSystemRootQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SwSystemRootQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.swSystemRoot";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("root","instSpec","name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("root", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("instSpec", "org.eclipse.uml2.uml.Package"),new PParameter("name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_root = body.getOrCreateVariableByName("root");
      	PVariable var_instSpec = body.getOrCreateVariableByName("instSpec");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_root, "root"),
      				
      		new ExportedParameter(body, var_instSpec, "instSpec"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_instSpec), SwSystemCHGaResourcePlatformQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_instSpec, var_root, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement"), "http://www.eclipse.org/uml2/5.0.0/UML/Package.packagedElement");
      	new TypeUnary(body, var_root, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification");
      	new TypeBinary(body, CONTEXT, var_root, var_name, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern swSystemRoot";
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
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("root"));
      	annotation.addAttribute("label", "$name$ (Instance)");
      	annotation.addAttribute("hierarchy", "root");
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
    boolean _not = (!_contains);
    return _not;
  }
}
