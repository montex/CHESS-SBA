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
import org.polarsys.chess.instance.view.ChildCHRTSpecItemMatch;
import org.polarsys.chess.instance.view.ChildCHRTSpecItemMatcher;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildCHRTSpecItemMatcher in a type-safe way.
 * 
 * @see ChildCHRTSpecItemMatcher
 * @see ChildCHRTSpecItemMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildCHRTSpecItemQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildCHRTSpecItemMatcher> {
  private ChildCHRTSpecItemQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildCHRTSpecItemQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildCHRTSpecItemMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildCHRTSpecItemMatcher.on(engine);
  }
  
  @Override
  public ChildCHRTSpecItemMatch newEmptyMatch() {
    return ChildCHRTSpecItemMatch.newEmptyMatch();
  }
  
  @Override
  public ChildCHRTSpecItemMatch newMatch(final Object... parameters) {
    return ChildCHRTSpecItemMatch.newMatch((org.eclipse.uml2.uml.Comment) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ChildCHRTSpecItemQuerySpecification INSTANCE = make();
    
    public static ChildCHRTSpecItemQuerySpecification make() {
      return new ChildCHRTSpecItemQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildCHRTSpecItemQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childCHRTSpecItem";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("chrtspecComment");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("chrtspecComment", "org.eclipse.uml2.uml.Comment"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_chrtspecComment = body.getOrCreateVariableByName("chrtspecComment");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_chrtspecComment, "chrtspecComment")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_chrtspecComment, var___0_), ChildCHRTSpecQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("chrtspecComment"));
      	annotation.addAttribute("label", "CHRtSpecification");
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
