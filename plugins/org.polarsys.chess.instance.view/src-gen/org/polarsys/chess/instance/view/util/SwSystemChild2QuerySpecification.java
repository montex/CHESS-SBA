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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
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
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemChild2QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemChild2Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemChild2Matcher.on(engine);
  }
  
  @Override
  public SwSystemChild2Match newEmptyMatch() {
    return SwSystemChild2Match.newEmptyMatch();
  }
  
  @Override
  public SwSystemChild2Match newMatch(final Object... parameters) {
    return SwSystemChild2Match.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Package) parameters[1], (org.eclipse.uml2.uml.InstanceSpecification) parameters[2], (java.lang.String) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static SwSystemChild2QuerySpecification INSTANCE = make();
    
    public static SwSystemChild2QuerySpecification make() {
      return new SwSystemChild2QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SwSystemChild2QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
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
      return Arrays.asList(new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("instSpec", "org.eclipse.uml2.uml.Package"),new PParameter("parent", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("name", "java.lang.String"));
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
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_instSpec, "instSpec"),
      				
      		new ExportedParameter(body, var_parent, "parent"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_instSpec), SwSystemCHGaResourcePlatformQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_instSpec, var_child, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement"), "http://www.eclipse.org/uml2/5.0.0/UML/Package.packagedElement");
      	new TypeUnary(body, var_child, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification");
      	new TypeBinary(body, CONTEXT, var_child, var_name, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      	new TypeBinary(body, CONTEXT, var_instSpec, var_parent, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement"), "http://www.eclipse.org/uml2/5.0.0/UML/Package.packagedElement");
      	new TypeUnary(body, var_parent, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification");
      	new TypeBinary(body, CONTEXT, var_parent, var_parentname, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      	new Inequality(body, var_child, var_parent);
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern swSystemChild2";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("name", "parentname");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String name = (java.lang.String) provider.getValue("name");
      			java.lang.String parentname = (java.lang.String) provider.getValue("parentname");
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
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String name, final String parentname) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _startsWith = name.startsWith(parentname);
    if (!_startsWith) {
      _and_1 = false;
    } else {
      boolean _equalsIgnoreCase = name.equalsIgnoreCase(parentname);
      boolean _not = (!_equalsIgnoreCase);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _length = parentname.length();
      int _plus = (_length + 1);
      String _substring = name.substring(_plus);
      boolean _contains = _substring.contains(".");
      boolean _not_1 = (!_contains);
      _and = _not_1;
    }
    return _and;
  }
}
