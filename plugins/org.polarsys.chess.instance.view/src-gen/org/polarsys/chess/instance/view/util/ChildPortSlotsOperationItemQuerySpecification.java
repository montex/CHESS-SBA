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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationItemMatcher;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsOperationItemMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsOperationItemMatcher
 * @see ChildPortSlotsOperationItemMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsOperationItemQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsOperationItemMatcher> {
  private ChildPortSlotsOperationItemQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsOperationItemQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsOperationItemMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsOperationItemMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsOperationItemMatch newEmptyMatch() {
    return ChildPortSlotsOperationItemMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsOperationItemMatch newMatch(final Object... parameters) {
    return ChildPortSlotsOperationItemMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (java.lang.String) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ChildPortSlotsOperationItemQuerySpecification INSTANCE = make();
    
    public static ChildPortSlotsOperationItemQuerySpecification make() {
      return new ChildPortSlotsOperationItemQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPortSlotsOperationItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlotsOperationItem";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("operation","nameC");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("nameC", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_operation = body.getOrCreateVariableByName("operation");
      	PVariable var_nameC = body.getOrCreateVariableByName("nameC");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_operation, "operation"),
      				
      		new ExportedParameter(body, var_nameC, "nameC")
      	));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_operation, var_nameC), ChildPortSlotsOperationQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("operation"));
      	annotation.addAttribute("label", "$nameC$ (Operation)");
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
}
