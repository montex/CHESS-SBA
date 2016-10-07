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
import org.polarsys.chess.instance.view.ChildCHRTSpecMatch;
import org.polarsys.chess.instance.view.ChildCHRTSpecMatcher;

/**
 * A pattern-specific query specification that can instantiate ChildCHRTSpecMatcher in a type-safe way.
 * 
 * @see ChildCHRTSpecMatcher
 * @see ChildCHRTSpecMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildCHRTSpecQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildCHRTSpecMatcher> {
  private ChildCHRTSpecQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildCHRTSpecQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildCHRTSpecMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildCHRTSpecMatcher.on(engine);
  }
  
  @Override
  public ChildCHRTSpecMatch newEmptyMatch() {
    return ChildCHRTSpecMatch.newEmptyMatch();
  }
  
  @Override
  public ChildCHRTSpecMatch newMatch(final Object... parameters) {
    return ChildCHRTSpecMatch.newMatch((org.eclipse.uml2.uml.Comment) parameters[0], (org.eclipse.uml2.uml.BehavioralFeature) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ChildCHRTSpecQuerySpecification INSTANCE = make();
    
    public static ChildCHRTSpecQuerySpecification make() {
      return new ChildCHRTSpecQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildCHRTSpecQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childCHRTSpec";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("chrtspecComment","operation");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("chrtspecComment", "org.eclipse.uml2.uml.Comment"),new PParameter("operation", "org.eclipse.uml2.uml.BehavioralFeature"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_chrtspecComment = body.getOrCreateVariableByName("chrtspecComment");
      	PVariable var_operation = body.getOrCreateVariableByName("operation");
      	PVariable var_chrtportslot = body.getOrCreateVariableByName("chrtportslot");
      	PVariable var_slot = body.getOrCreateVariableByName("slot");
      	PVariable var_chrt = body.getOrCreateVariableByName("chrt");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_chrtspecComment, "chrtspecComment"),
      				
      		new ExportedParameter(body, var_operation, "operation")
      	));
      	new TypeBinary(body, CONTEXT, var_chrtportslot, var_slot, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "base_Slot"), "http://CHESS/Predictability/RTComponentModel/CHRtPortSlot.base_Slot");
      	new TypeBinary(body, CONTEXT, var_chrtportslot, var_chrt, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtPortSlot", "cH_RtSpecification"), "http://CHESS/Predictability/RTComponentModel/CHRtPortSlot.cH_RtSpecification");
      	new TypeBinary(body, CONTEXT, var_chrt, var_operation, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "context"), "http://CHESS/Predictability/RTComponentModel/CHRtSpecification.context");
      	new TypeBinary(body, CONTEXT, var_chrt, var_chrtspecComment, getFeatureLiteral("http://CHESS/Predictability/RTComponentModel", "CHRtSpecification", "base_Comment"), "http://CHESS/Predictability/RTComponentModel/CHRtSpecification.base_Comment");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("operation"));
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
