/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.transformations.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.fla.flamm.Expression;
import org.polarsys.chess.fla.flamm.Failure;
import org.polarsys.chess.fla.flamm.FlammFactory;
import org.polarsys.chess.fla.flamm.Port;
import org.polarsys.chess.fla.flamm.Rule;
import org.polarsys.chess.fla.flamm.SimpleComponent;
import org.polarsys.chess.fla.flamm.FailureTypes.FailureType;


public class UtilitiesLibrary {
	private static final String FLA_PREFIX = "FLA:";
	private static final String FPTC_SPECIFICATION_STEREOTYPE = "CHESS::Dependability::FailurePropagation::FPTCSpecification";

	
	@Operation(contextual=true)
	public static String aStringMethod(String s) {
		return s.toUpperCase();
	}

	@Operation(contextual=true)
	public static String getXmiId(Element umlElement) {
		Resource resource = umlElement.eResource();
		if (resource != null){
		    String id = resource.getURIFragment(umlElement);
		    return id;
		} else {
			return UUID.randomUUID().toString();
		}
	}
	
	@Operation(contextual=true)
	public static Element getElementWithXmiId(Element umlElement, String id) {
		if (id == null || umlElement == null) {
			return null;
		}
		
		for (Element element : umlElement.getOwnedElements()) {
			Resource resource = umlElement.eResource();
			if (resource != null && id.equals(resource.getURIFragment(umlElement))){
			    return element;
			}
		}
		return null;
	}
	
	@Operation(contextual=true) 
	public static Rule getRuleFromRulestring(String flaRulestring, SimpleComponent component) {
		String rulestring = flaRulestring;
		if (flaRulestring.startsWith(FLA_PREFIX)) {
			rulestring = flaRulestring.substring(FLA_PREFIX.length());
		}
		
		String[] expressions = rulestring.split("->");
		Rule rule = FlammFactory.eINSTANCE.createRule();
		
		rule.getInputExpression().addAll(string2Expressions(expressions[0], component.getInputPorts()));
		rule.getOutputExpression().addAll(string2Expressions(expressions[1], component.getOutputPorts()));
		
		try {
			validateRuleVariables(rule);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage() + " Component: " + component.getId());
		}
		return rule;
	}
	
	private static void validateRuleVariables(Rule rule) {
		Set<String> inputVariables = new HashSet<String>();
		Set<String> outputVariables = new HashSet<String>();

		for (Expression expression : rule.getInputExpression()) {
			inputVariables.addAll(getAllVariableNames(expression));
		}
		
		for (Expression expression : rule.getOutputExpression()) {
			outputVariables.addAll(getAllVariableNames(expression));
		}
		
		if (!inputVariables.containsAll(outputVariables)) {
			// TODO: Fix error handling
			outputVariables.removeAll(inputVariables);
			throw new RuntimeException("Unknown variable(s) in output expression! " +
					"(" + outputVariables + ")");
		}
		
		if (!outputVariables.contains(inputVariables)) {
			//TODO: Warning: input variable not used in output expression, consider using wildcard instead
		}
	}
	
	private static Set<String> getAllVariableNames(Expression expression) {
		Set<String> variables = new HashSet<String>();
		for (Failure failure : expression.getFailures()) {
			if (failure.getType() == FailureType.VARIABLE) {
				variables.add(failure.getId());
			}
		}
		return variables;
	}

	static List<Expression> string2Expressions(String str, List<Port> list) {
		List<Expression> expressions = new ArrayList<Expression>(); 
		for (String s : splitToExpressions(str)) {
			expressions.add(getExpression(s, list));
		}
		
		return expressions;
	}
	
	private static String[] splitToExpressions(String str) {
		return str.split(",");
	}

	private static Expression getExpression(String s, List<Port> list) {
		String[] parts = s.split("\\.");
		String portName = parts[0];
		String failureString = parts[1];
		Failure failure = getFailureFromString(failureString);
		
		Expression expr = FlammFactory.eINSTANCE.createExpression();
		expr.setPort(getPortByName(list, portName));
		expr.getFailures().add(failure);
		return expr;
	}
	
	static Failure getFailureFromString(String failureString) {
		Failure failure = FlammFactory.eINSTANCE.createFailure();
		if (failureString.equals("noFailure")) {
			failure.setType(FailureType.NO_FAILURE);
			
		} else if (failureString.equals("wildcard") || failureString.equals("_")) {
			failure.setType(FailureType.WILDCARD);
			
		} else if (isProperFailure(failureString)) {
			failure.setType(FailureType.FAILURE);
			
		} else {
			failure.setType(FailureType.VARIABLE);
		}
		
		failure.setId(failureString);
		return failure;
	}
	
	// Since CHESS-ML is using enumerated failure types, this is necessary to tell 
	// failure types and variable names apart.
	protected static boolean isProperFailure(String failure) {
		return org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FailurePropagationDataTypes.
				FailureType.get(failure) != null;
	}

	private static Port getPortByName(List<Port> list, String portName) {
		portName = portName.trim();
		for(Port port : list) {
			if (port.getName().equals(portName)) {
				return port;
			}
		}
		return null;
	}

	@Operation(contextual=true)
	public static void toRuleExpression(String ruleString, Expression expression) {
		String portId = ruleString.substring(0, ruleString.indexOf('.'));
		expression.setPort(getPortById(portId));
		
		expression.getFailures().add(null);
	}
	
	private static Port getPortById(String portId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Operation(contextual=true)
	public static String rule2String(Rule rule) {
		String result = "";
		result += expressionList2string(rule.getInputExpression());
		result += "->";
		result += expressionList2string(rule.getOutputExpression());
		return result;
	}
	
	protected static String expressionList2string(List<Expression> list) {
		String result = "";
		for (Expression expression : list) {
			result += expression.getPort().getName() + "." + failureList2String(expression.getFailures()) + ",";
		}
		if (result.endsWith(",")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
	
	protected static String failureList2String(List<Failure> list) {
		if (list == null || list.isEmpty()) {
			return "";
			
		} else if (list.size() == 1) {
			return failure2string(list.get(0));
			
		} else {
			String result = "{";
			for (int i = 0; i < list.size(); i++) {
				result += failure2string(list.get(i));
				if (i < list.size() - 1) {
					result += ",";
				}
			}
			result += "}";
			return result;
		}
	}
	
	/*
	 * Only FPTC for now
	 */
	protected static String failure2string(Failure failure) {
		return failure.getId();
	}
	
	@Operation(contextual=true)
	public static boolean blackboxApplyStereotype(Element element, String stereotypeQName) {
		Stereotype stereotype = element.getApplicableStereotype(stereotypeQName);
		Object returnValue = null;
		if (stereotype != null) {
			returnValue = element.applyStereotype(stereotype);
		}
		return returnValue != null;
	}
	
	@Operation(contextual=true)
	public static Comment blackboxCreateFptcComment(Element owner, NamedElement annotated, Property partWithPort) {
		Comment comment = owner.createOwnedComment();
		comment.getAnnotatedElements().add(annotated);
		comment.applyStereotype(comment.getApplicableStereotype(FPTC_SPECIFICATION_STEREOTYPE));
		Stereotype s = comment.getAppliedStereotype(FPTC_SPECIFICATION_STEREOTYPE);
		comment.setValue(s, "partWithPort", partWithPort);
		String commentBody = "FLA: " + getName(partWithPort);
		if (partWithPort != annotated) {
			commentBody += "." + getName(annotated);
		}
		comment.setBody(commentBody);
		return comment;
	}
	
	protected static String getName(NamedElement element) {
		if (element != null && element.getName() != null) {
			return element.getName();
		} else {
			return "";
		}
	}
	
//	@Operation(contextual=true)
//	public static Set<Port> getConnectedPorts(CompositeComponent component) {
//		Set<Port> ports = new HashSet<Port>();
//		for (Port port : component.getInputPorts()) {
//			
//		}
//	}
}
