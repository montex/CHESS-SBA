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
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatch;
import org.polarsys.chess.instance.view.ChildPortSlotsOperationMatcher;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;
import org.polarsys.chess.instance.view.util.ClientServerPortHelperWithInterfaceQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate ChildPortSlotsOperationMatcher in a type-safe way.
 * 
 * @see ChildPortSlotsOperationMatcher
 * @see ChildPortSlotsOperationMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildPortSlotsOperationQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildPortSlotsOperationMatcher> {
  private ChildPortSlotsOperationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildPortSlotsOperationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildPortSlotsOperationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildPortSlotsOperationMatcher.on(engine);
  }
  
  @Override
  public ChildPortSlotsOperationMatch newEmptyMatch() {
    return ChildPortSlotsOperationMatch.newEmptyMatch();
  }
  
  @Override
  public ChildPortSlotsOperationMatch newMatch(final Object... parameters) {
    return ChildPortSlotsOperationMatch.newMatch((org.eclipse.uml2.uml.Slot) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static ChildPortSlotsOperationQuerySpecification INSTANCE = make();
    
    public static ChildPortSlotsOperationQuerySpecification make() {
      return new ChildPortSlotsOperationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildPortSlotsOperationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.polarsys.chess.instance.view.childPortSlotsOperation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("slot","operation","nameC");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("slot", "org.eclipse.uml2.uml.Slot"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("nameC", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_slot = body.getOrCreateVariableByName("slot");
      	PVariable var_operation = body.getOrCreateVariableByName("operation");
      	PVariable var_nameC = body.getOrCreateVariableByName("nameC");
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var_port = body.getOrCreateVariableByName("port");
      	PVariable var_csp = body.getOrCreateVariableByName("csp");
      	PVariable var_interface = body.getOrCreateVariableByName("interface");
      	PVariable var_operationI = body.getOrCreateVariableByName("operationI");
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var_nameI = body.getOrCreateVariableByName("nameI");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_slot, "slot"),
      				
      		new ExportedParameter(body, var_operation, "operation"),
      				
      		new ExportedParameter(body, var_nameC, "nameC")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_child, var_slot, var___0_), ChildPortSlotsQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_slot, var_port, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Slot", "definingFeature"), "http://www.eclipse.org/uml2/5.0.0/UML/Slot.definingFeature");
      	new TypeBinary(body, CONTEXT, var_csp, var_port, getFeatureLiteral("http://www.eclipse.org/papyrus/GCM/1", "ClientServerPort", "base_Port"), "http://www.eclipse.org/papyrus/GCM/1/ClientServerPort.base_Port");
      	new PositivePatternCall(body, new FlatTuple(var_csp, var_interface), ClientServerPortHelperWithInterfaceQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeBinary(body, CONTEXT, var_interface, var_operationI, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Interface", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Interface.ownedOperation");
      	new TypeBinary(body, CONTEXT, var_child, var_component, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InstanceSpecification", "classifier"), "http://www.eclipse.org/uml2/5.0.0/UML/InstanceSpecification.classifier");
      	new TypeUnary(body, var_component, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component"), "http://www.eclipse.org/uml2/5.0.0/UML/Component");
      	new TypeBinary(body, CONTEXT, var_component, var_operation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedOperation");
      	new TypeBinary(body, CONTEXT, var_operationI, var_nameI, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      	new TypeBinary(body, CONTEXT, var_operation, var_nameC, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern childPortSlotsOperation";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("nameC", "nameI");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String nameC = (java.lang.String) provider.getValue("nameC");
      			java.lang.String nameI = (java.lang.String) provider.getValue("nameI");
      			return evaluateExpression_1_1(nameC, nameI);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("slot"));
      	annotation.addAttribute("item", new ParameterReference("operation"));
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
  
  private static boolean evaluateExpression_1_1(final String nameC, final String nameI) {
    int _compareTo = nameI.compareTo(nameC);
    boolean _equals = (_compareTo == 0);
    return _equals;
  }
}
