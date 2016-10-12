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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatch;
import org.polarsys.chess.instance.view.SwSystemCHGaResourcePlatformMatcher;

/**
 * A pattern-specific query specification that can instantiate SwSystemCHGaResourcePlatformMatcher in a type-safe way.
 * 
 * @see SwSystemCHGaResourcePlatformMatcher
 * @see SwSystemCHGaResourcePlatformMatch
 * 
 */
@SuppressWarnings("all")
public final class SwSystemCHGaResourcePlatformQuerySpecification extends BaseGeneratedEMFQuerySpecification<SwSystemCHGaResourcePlatformMatcher> {
  private SwSystemCHGaResourcePlatformQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SwSystemCHGaResourcePlatformQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SwSystemCHGaResourcePlatformMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SwSystemCHGaResourcePlatformMatcher.on(engine);
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatch newEmptyMatch() {
    return SwSystemCHGaResourcePlatformMatch.newEmptyMatch();
  }
  
  @Override
  public SwSystemCHGaResourcePlatformMatch newMatch(final Object... parameters) {
    return SwSystemCHGaResourcePlatformMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SwSystemCHGaResourcePlatformQuerySpecification INSTANCE = make();
    
    public static SwSystemCHGaResourcePlatformQuerySpecification make() {
      return new SwSystemCHGaResourcePlatformQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SwSystemCHGaResourcePlatformQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.swSystemCHGaResourcePlatform";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("instSpec");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("instSpec", "org.eclipse.uml2.uml.Package"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_instSpec = body.getOrCreateVariableByName("instSpec");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_instSpec, "instSpec")
      	));
      	new TypeBinary(body, CONTEXT, var___0_, var_instSpec, getFeatureLiteral("http://CHESS/Core", "CHGaResourcePlatform", "base_Package"), "http://CHESS/Core/CHGaResourcePlatform.base_Package");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("instSpec"));
      	annotation.addAttribute("label", "$instSpec.name$ (Package)");
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
