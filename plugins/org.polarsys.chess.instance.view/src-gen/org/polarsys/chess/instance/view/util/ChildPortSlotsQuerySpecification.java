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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.polarsys.chess.instance.view.ChildPortSlotsMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsMatcher;
import org.polarsys.chess.instance.view.util.ClientServerPortHelperWithInterfaceQuerySpecification;
import org.polarsys.chess.instance.view.util.PortHelperWithValueQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsMatcher
 * @see ChildPortSlotsMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsMatcher> {
  private ChildPortSlotsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsMatch newEmptyMatch() {
    return ChildPortSlotsMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsMatch newMatch(final Object... parameters) {
    return ChildPortSlotsMatch.newMatch((org.eclipse.uml2.uml.InstanceSpecification) parameters[0], (org.eclipse.uml2.uml.Slot) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static ChildPortSlotsQuerySpecification INSTANCE = make();
    
    public static ChildPortSlotsQuerySpecification make() {
      return new ChildPortSlotsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPortSlotsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlots";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","slot","name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("child", "org.eclipse.uml2.uml.InstanceSpecification"),new PParameter("slot", "org.eclipse.uml2.uml.Slot"),new PParameter("name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_slot = body.getOrCreateVariableByName("slot");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	PVariable var_port = body.getOrCreateVariableByName("port");
      	PVariable var_csp = body.getOrCreateVariableByName("csp");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_slot, "slot"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_child, var_slot, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "slot"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification.slot");
      	new TypeBinary(body, CONTEXT, var_slot, var_port, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature"), "http://www.eclipse.org/uml2/5.0.0/UML/Slot.definingFeature");
      	new TypeBinary(body, CONTEXT, var_port, var_name, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      	new TypeBinary(body, CONTEXT, var_csp, var_port, getFeatureLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort", "base_Port"), "http://www.eclipse.org/papyrus/GCM/1/ClientServerPort.base_Port");
      	new NegativePatternCall(body, new FlatTuple(var_slot, var___0_), PortHelperWithValueQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_csp, var___1_), ClientServerPortHelperWithInterfaceQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("slot"));
      	annotation.addAttribute("label", "$name$ ( Provided Port)");
      	annotation.addAttribute("hierarchy", "child");
      	addAnnotation(annotation);
      }
      {
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("child"));
      	annotation.addAttribute("item", new ParameterReference("slot"));
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
