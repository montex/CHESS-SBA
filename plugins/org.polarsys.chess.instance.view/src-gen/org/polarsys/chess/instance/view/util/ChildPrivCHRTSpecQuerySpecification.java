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
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecMatch;
import org.polarsys.chess.instance.view.ChildPrivCHRTSpecMatcher;

/**
 * A pattern-specific query specification that can instantiate ChildPrivCHRTSpecMatcher in a type-safe way.
 * 
 * @see ChildPrivCHRTSpecMatcher
 * @see ChildPrivCHRTSpecMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPrivCHRTSpecQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPrivCHRTSpecMatcher> {
  private ChildPrivCHRTSpecQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPrivCHRTSpecQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPrivCHRTSpecMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildPrivCHRTSpecMatcher.on(engine);
  }
  
  @Override
  public ChildPrivCHRTSpecMatch newEmptyMatch() {
    return ChildPrivCHRTSpecMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPrivCHRTSpecMatch newMatch(final Object... parameters) {
    return ChildPrivCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) parameters[0], (org.eclipse.uml2.uml.BehavioralFeature) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ChildPrivCHRTSpecQuerySpecification INSTANCE = make();
    
    public static ChildPrivCHRTSpecQuerySpecification make() {
      return new ChildPrivCHRTSpecQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPrivCHRTSpecQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPrivCHRTSpec";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("chrtspecComment","privoperation");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("chrtspecComment", "org.eclipse.uml2.uml.Comment"),new PParameter("privoperation", "org.eclipse.uml2.uml.BehavioralFeature"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_chrtspecComment = body.getOrCreateVariableByName("chrtspecComment");
      	PVariable var_privoperation = body.getOrCreateVariableByName("privoperation");
      	PVariable var_chrtportslot = body.getOrCreateVariableByName("chrtportslot");
      	PVariable var_instancespec = body.getOrCreateVariableByName("instancespec");
      	PVariable var_chrt = body.getOrCreateVariableByName("chrt");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_chrtspecComment, "chrtspecComment"),
      				
      		new ExportedParameter(body, var_privoperation, "privoperation")
      	));
      	new TypeBinary(body, CONTEXT, var_chrtportslot, var_instancespec, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "base_InstanceSpecification"), "http://CHESS/Predictability/RTComponentModel/CHRtPortSlot.base_InstanceSpecification");
      	new TypeBinary(body, CONTEXT, var_chrtportslot, var_chrt, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "cH_RtSpecification"), "http://CHESS/Predictability/RTComponentModel/CHRtPortSlot.cH_RtSpecification");
      	new TypeBinary(body, CONTEXT, var_chrt, var_privoperation, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "context"), "http://CHESS/Predictability/RTComponentModel/CHRtSpecification.context");
      	new TypeBinary(body, CONTEXT, var_chrt, var_chrtspecComment, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "base_Comment"), "http://CHESS/Predictability/RTComponentModel/CHRtSpecification.base_Comment");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("privoperation"));
      	annotation.addAttribute("item", new ParameterReference("chrtspecComment"));
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
