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
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate ClientServerPortHelperWithInterfaceMatcher in a type-safe way.
 * 
 * @see ClientServerPortHelperWithInterfaceMatcher
 * @see ClientServerPortHelperWithInterfaceMatch
 * 
 */
@SuppressWarnings("all")
final class ClientServerPortHelperWithInterfaceQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private ClientServerPortHelperWithInterfaceQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClientServerPortHelperWithInterfaceQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncQueryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  private static class LazyHolder {
    private final static ClientServerPortHelperWithInterfaceQuerySpecification INSTANCE = make();
    
    public static ClientServerPortHelperWithInterfaceQuerySpecification make() {
      return new ClientServerPortHelperWithInterfaceQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ClientServerPortHelperWithInterfaceQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.clientServerPortHelperWithInterface";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("csp","interf");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("csp", "org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort"),new PParameter("interf", "org.eclipse.uml2.uml.Interface"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_csp = body.getOrCreateVariableByName("csp");
      	PVariable var_interf = body.getOrCreateVariableByName("interf");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_csp, "csp"),
      				
      		new ExportedParameter(body, var_interf, "interf")
      	));
      	new TypeBinary(body, CONTEXT, var_csp, var_interf, getFeatureLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort", "provInterface"), "http://www.eclipse.org/papyrus/GCM/1/ClientServerPort.provInterface");
      	bodies.add(body);
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
