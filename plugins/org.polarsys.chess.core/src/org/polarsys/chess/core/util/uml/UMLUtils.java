/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.util.uml;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.DependencyImpl;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.core.views.ViewUtils;

/**
 * This class contains a list of utility methods to deal with UML models.
 *
 */
public class UMLUtils {
	
	/**
	 * Returns the XML ID (UUID) of a model element.
	 * It may be useful for external tools to precisely refer to a model element.
	 * 
	 * @param el  the model element
	 * @return  the UUID
	 */
	public static String getElementID(Element el){
		Resource resource = el.eResource();
		if(resource != null)
			return resource.getURIFragment(el);
		return null;
	}
	
	/**
	 * Checks if the given operation is public.
	 * 
	 * @param operation  the operation
	 * @return true if it is public
	 */
	public static boolean hasPublicVisibility(Operation operation) {
		if (operation.getVisibility().getValue() == VisibilityKind.PUBLIC)
			return true;
		return false;
	}

	/**
	 * Checks if two parameters are the same.
	 * 
	 * @param param  the source parameter
	 * @param aux  the target paramater 
	 * @return true if they are the same
	 */
	public static boolean areParametersEqual(Parameter param, Parameter aux) {
		// parameter's name
		if (!param.getName().equals(aux.getName()))
			return false;

		// parameter's direction
		if (param.getDirection().getValue() != aux.getDirection().getValue())
			return false;

		// parameter's visibility
		if (param.getVisibility().getValue() != aux.getVisibility().getValue())
			return false;

		if (param.isException() != aux.isException())
			return false;

		if (param.isMultivalued() != aux.isMultivalued())
			return false;

		if (param.isOrdered() != aux.isOrdered())
			return false;

		if (param.isSetDefault() != aux.isSetDefault())
			return false;

		if (param.isUnique() != aux.isUnique())
			return false;

		if (param.isStream() != aux.isStream())
			return false;

		if (param.getEffect().getValue() != aux.getEffect().getValue())
			return false;

		if (param.lowerBound() != aux.lowerBound())
			return false;

		if (param.upperBound() != aux.upperBound())
			return false;
		return true;
	}

	/**
	 * Copy the source operation data to the target operation.
	 * 
	 * @param source  the source operation
	 * @param target  the target operation
	 */
	public static void copyOperation(Operation source, Operation target) 
	{
		for (Parameter param : source.getOwnedParameters()) {
			Parameter p = target.createOwnedParameter(param.getName(), param.getType());
			p.setDirection(param.getDirection());
			p.setEffect(param.getEffect());
			p.setDefaultValue(param.getDefaultValue());
			p.setDefault(param.getDefault());
			p.setIsException(param.isException());
			p.setIsOrdered(param.isOrdered());
			p.setIsStream(param.isStream());
			p.setIsUnique(param.isUnique());
			p.setLower(param.getLower());
			p.setLowerValue(param.getLowerValue());
			p.setTemplateParameter(param.getTemplateParameter());
			p.setUpper(param.getUpper());
			p.setUpperValue(param.getUpperValue());
			p.setVisibility(param.getVisibility());
		}
		target.setVisibility(source.getVisibility());
		target.setConcurrency(source.getConcurrency());
		target.setIsQuery(source.isQuery());
		target.setIsLeaf(source.isLeaf());
		target.setIsStatic(source.isStatic());
		//target.getRedefinedOperations().add(source);
	}
	
/*	public static boolean isOperationEquals(Operation source, Operation target) {
		// check the parameters
		Parameter param, aux;
		EList<Parameter> targetList = target.getOwnedParameters();
		// check their order
		if (targetList.size() != source.getOwnedParameters().size())
			return false;

		if (source.getVisibility().getValue() != target.getVisibility()
				.getValue())
			return false;

		if (source.isQuery() != target.isQuery())
			return false;

		if (source.isLeaf() != target.isLeaf())
			return false;

		if (source.isStatic() != target.isStatic())
			return false;

		if (source.getConcurrency().getValue() != target.getConcurrency()
				.getValue())
			return false;

		for (int i = 0; i < targetList.size(); i++) {
			param = targetList.get(i);
			aux = source.getOwnedParameter(param.getName(), param.getType());
			if (aux == null)
				return false;
			// aux = targetList.get(i);
			if (param != null && aux != null) {
				if (!isParameterEquals(param, aux))
					return false;
			}
		}

		return true;
	}*/
	
	
	/**
	 * If parameter 'p' is null checks if the operations are the same, that is if they have the same signature.
	 * If parameter 'p' is not null returns true only if the target operation plus 'p' has the same signature of the source operation.
	 * 
	 * 
	 * @param source  the source operation
	 * @param target  the target operation
	 * @param p  the parameter
	 * @return true if the operations are equal
	 */
	public static boolean areOperationsEqual(Operation source, Operation target, Parameter p)
	{
		
		if ( !source.getName().equalsIgnoreCase(target.getName()))
			return false;
		
		// check the parameters
		Parameter param, aux;
		EList<Parameter> targetList = target.getOwnedParameters();
		EList<Parameter> sourceList = source.getOwnedParameters();
		// check their order
		
		
		if ( p == null )
		{
			if (targetList.size() != sourceList.size())
				return false;
		}
		else 
			if (targetList.size() + 1 != sourceList.size())
				return false;

		if (source.getVisibility().getValue() != target.getVisibility()
				.getValue())
			return false;

		if (source.isQuery() != target.isQuery())
			return false;

		if (source.isLeaf() != target.isLeaf())
			return false;

		if (source.isStatic() != target.isStatic())
			return false;

		if (source.getConcurrency().getValue() != target.getConcurrency()
				.getValue())
			return false;

		for (int i = 0; i < targetList.size(); i++) {
			param = targetList.get(i);
			aux = source.getOwnedParameter(param.getName(), param.getType());
			if (aux == null)
				return false;
			// aux = targetList.get(i);
			if (param != null && aux != null) {
				if (!areParametersEqual(param, aux))
					return false;
			}
		}

		return true;
	}
	
	
	/**
	 * Checks if the list of parameters of two operations are equal.
	 * If 'p' is not null returns true only if source operation deprived of 'p' has the same list of parameters
	 * of the target operation.
	 * 
	 * @param source  the source operation
	 * @param target  the target operation
	 * @param p  the parameter
	 * @return  true if the operation parameters are equal
	 */
	public static boolean areParametersEquals(Operation source, Operation target, Parameter p)	{
		EList<Parameter> targetList = target.getOwnedParameters();

		if (targetList.size() != source.getOwnedParameters().size())
			return false;

		for (Parameter param : targetList) {
			if (p != null && p.getName().equalsIgnoreCase(param.getName()))
				continue;
			Parameter aux = source.getOwnedParameter(param.getName(),
					param.getType());
			if (aux == null)
				return false;
			if (!areParametersEqual(param, aux))
				return false;
		}
		return true;
	}
	
	/**
	 * Checks if the parameters of two operations are the same.
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean areParametersEquals(Operation source, Operation target)
	{
		return areParametersEquals(source,target,null);
	}
	
	/**
	 * Checks if two operations are equal.
	 * 
	 * @param source  one operation
	 * @param target  the other
	 * @return true if they are equal
	 */
	public static boolean isOperationEquals(Operation source, Operation target) {
		return UMLUtils.areOperationsEqual(source, target, null);
			}

	/**
	 * Checks if there given Component offers an operation that is equal
	 * of the operation given.
	 * 
	 * @param component  the component
	 * @param operation  the operation
	 * @return true if there is an operation that equals the given one
	 */
	public static boolean isOperationContained(Classifier component,
			Operation operation) {
		for (Operation op : component.getOperations()) {
			// check the name
			if (op.getName().equals(operation.getName())) {
				if (isOperationEquals(op, operation))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Retrieves all the clients of a given {@link Interface}.
	 * 
	 * @param interfce  the interface
	 * @return the list of clients
	 */
	public static EList<NamedElement> getInterfaceClients(Interface interfce){
		EList<NamedElement> relationships = new BasicEList<NamedElement>();
		for (Relationship rel : interfce.getRelationships()) {
			if (rel instanceof InterfaceRealization) {
				InterfaceRealization intRel = (InterfaceRealization) rel;
				relationships.addAll(intRel.getClients());
			}
		}
		return relationships;
	}

	/**
	 * Retrieves all the {@link ComponentImplementation} of a given Component.
	 * 
	 * @param comp  the component
	 * @return the list of {@link ComponentImplementation}
	 */
	public static EList<Component> getComponentImplementations(Component comp){
		EList<Component> list = new BasicEList<Component>();
		//DONE using comp.getNearestPackage() is NOT SAFE, use a recursive search on the ViewUtils.getView(comp)
		EList<Component> compImpls = retrieveComponentImplementations(ViewUtils.getView(comp));
		for (Component el : compImpls) {	
			for (Dependency dep : el.getClientDependencies()) {
				if (dep instanceof Realization) {
					if (dep.getSupplier(comp.getName()) != null)
						list.add(el);
				}
			}
		}
		return list;
	}

	/**
	 * Retrieves all the {@link ComponentImplementation} of a given Package
	 * 
	 * @param pkg  the package
	 * @return all the {@link ComponentImplementation}
	 */
	private static EList<Component> retrieveComponentImplementations(Package pkg) {
		EList<Component> comps = new BasicEList<Component>();
		for (Element el : pkg.getOwnedElements()) {
			if (el instanceof Component && isComponentImplementation(el)){
				comps.add((Component) el);
			}
			if (el instanceof Package){
				EList<Component> list = retrieveComponentImplementations((Package) el); 
				if (!list.isEmpty())
					comps.addAll(list);
			}
		}
		return comps;
	}

	/**
	 * Checks if the given object is a {@link ComponentType}.
	 * 
	 * @param el  the element
	 * @return true if it is a {@link ComponentType}
	 */
	public static boolean isComponentType(Object el) {
		if (el instanceof Component && ((Element) el).getAppliedStereotype("CHESS::ComponentModel::ComponentType") != null)
			return true;
		return false;
	}
	
	/**
	 * Checks if the given object is a {@link ComponentImplementation}.
	 * 
	 * @param el  the element
	 * @return true if it is a {@link ComponentImplementation}
	 */
	public static boolean isComponentImplementation(Object el) {
		if (el instanceof Component && ((Element) el).getAppliedStereotype("CHESS::ComponentModel::ComponentImplementation") != null)
			return true;
		return false;
	}
	
	
	/**
	 * Retrieves the list of {@link ClientServerPort} of a given Component.
	 * 
	 * @param component  the component
	 * @return the list of {@link ClientServerPort}
	 */
	public static EList<ClientServerPort> getComponentClientServerPorts(final Component component) {
		EList<ClientServerPort> ports = new BasicEList<ClientServerPort>();
		for (Element e : component.getOwnedElements()) {
			if (e instanceof Port) {
				Port p = (Port) e;
				for (EObject st : p.getStereotypeApplications()) {
					if (st instanceof ClientServerPort){
						ClientServerPort csp = (ClientServerPort) st;
						ports.add(csp);
					}
				}
			}
		}
		return ports;
	}

	/**
	 * Retrieves all the {@link Dependency} of a given Component.
	 * 
	 * @param comp the component
	 * @return the list of {@link Dependency}
	 */
	public static EList<Dependency> computeDependenciesToRemove(Component comp) {
		EList<Dependency> cDependencies = comp.getClientDependencies();
		EList<Interface> cDependentInterfaces = new BasicEList<Interface>();
		Map<Interface, Dependency> cDependenciesToRemoveMap = new HashMap<Interface, Dependency>();
		for (Dependency dependency : cDependencies) {
			//it MUST BE exactly a Dependency since a InterfaceRealization is a subtype of Dependency :(
			if (dependency.getClass().equals(DependencyImpl.class)){
				for (NamedElement el : dependency.getSuppliers()) {
					//There's MUST be one and only interface per dependency relationship
					if (el instanceof Interface){
						cDependentInterfaces.add((Interface)el);
						cDependenciesToRemoveMap.put((Interface)el, dependency);
					}
					
				}
			}
		}
		
		EList<ClientServerPort> ports = UMLUtils.getComponentClientServerPorts(comp);
		
		EList<Interface>  portInts = new BasicEList<Interface>();
		for (ClientServerPort csp : ports) {
			if (csp.getKind() == ClientServerKind.REQUIRED || csp.getKind() == ClientServerKind.PROREQ) {
				portInts.addAll(csp.getReqInterface());
			}
		}
		
		if (portInts != null)
			cDependentInterfaces.removeAll(portInts);
		EList<Dependency> cDependenciesToRemove = new BasicEList<Dependency>();
		for (Interface el : cDependentInterfaces) {
				Dependency dep = cDependenciesToRemoveMap.get(el);
				if (dep != null){
					cDependenciesToRemove.add(dep);
				}
		}
		return cDependenciesToRemove;
	}

	/**
	 * Retrieves all the {@link InterfaceRealization} of a given Component
	 * 
	 * @param comp  the component
	 * @return the list of {@link InterfaceRealization}
	 */
	public static EList<InterfaceRealization> computeRealizationsToRemove(
			Component comp) {
		EList<InterfaceRealization> cRealizations = comp.getInterfaceRealizations();
		EList<Interface> cRealizedInterfaces = new BasicEList<Interface>();
		Map<Interface, InterfaceRealization> cRealizationsToRemoveMap = new HashMap<Interface, InterfaceRealization>();
		for (InterfaceRealization ir : cRealizations) {
			//it MUST BE exactly a Dependency since a InterfaceRealization is a subtype of Dependency :(
				cRealizedInterfaces.add(ir.getContract());
				cRealizationsToRemoveMap.put(ir.getContract(), ir);
		}
		
        EList<ClientServerPort> ports = UMLUtils.getComponentClientServerPorts(comp);
		
		EList<Interface>  portInts = new BasicEList<Interface>();
		for (ClientServerPort csp : ports) {
			if (csp.getKind() == ClientServerKind.PROVIDED || csp.getKind() == ClientServerKind.PROREQ) {
				portInts.addAll(csp.getProvInterface());
			}
		}
		
		if (portInts != null)
			cRealizedInterfaces.removeAll(portInts);
		EList<InterfaceRealization> cRealizationsToRemove = new BasicEList<InterfaceRealization>();
		for (Interface el : cRealizedInterfaces) {
			InterfaceRealization dep = cRealizationsToRemoveMap.get(el);
				if (dep != null){
					cRealizationsToRemove.add(dep);
				}
		}
		return cRealizationsToRemove;
	}

	/**
	 * Checks if the given object represents a Client/Server port.
	 * 
	 * @param el  the element
	 * @return true if the object is a Client/Server port
	 */
	public static boolean isClientServerPort(final Object el) {
		if(el instanceof Port && ((Element) el).getAppliedStereotype("MARTE::MARTE_DesignModel::GCM::ClientServerPort") != null)
			return true;
		return false;
	}
	
	/**
	 * Returns the CHRtSpecification of the given element.
	 * Returns null if the element is not a the comment
	 * 
	 * @param el  the element
	 * @return the CHRtSpecification application
	 */
	public static Stereotype getCHRtSpecification(final Object el) {
		if(el instanceof Comment)
			return ((Element) el).getAppliedStereotype("CHESS::Predictability::RTComponentModel::CHRtSpecification");
		return null;
	}

	/**
	 * Retrieves all the CHRTSpecification {@link Comment}s given a Package and a Port.
	 * If the Port is not given it retrieves all the comments.
	 * 
	 * @param pkg  the package
	 * @param portFilter  the port, can be null
	 * @return the list of comments
	 */
	public static EList<Comment> getCHRtSpecificationComments(Package pkg, Port portFilter) {
		EList<Comment> chrtspecs = new BasicEList<Comment>();
		for (Element el : pkg.getOwnedElements()) {
			
			if (!(el instanceof Component)) continue;
			
			for (Comment comm : el.getOwnedComments()) {
				Stereotype chrtspecification;
				if ((chrtspecification = getCHRtSpecification(comm)) != null) {
					if (portFilter!=null){
						if (comm.getValue(chrtspecification, "partWithPort") != null
								&& comm.getValue(chrtspecification,	"partWithPort").equals(portFilter)) {
							chrtspecs.add(comm);
						}
					} else {
						chrtspecs.add(comm);
					}
				}
			}
			
		}
		return chrtspecs;
	}
	
	/**
	 * Returns the stereotype object given the stereotype class and the model element.
	 *  
	 * @param element  the element
	 * @param stereotypeClass the stereotype class
	 * @return  the stereotype object
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getStereotypeApplication(
			final Element element, final Class<T> stereotypeClass) {
		for (EObject stereoApplication : element.getStereotypeApplications()) {
			if (stereotypeClass.isInstance(stereoApplication)) {
				return (T) stereoApplication;
			}
		}
		return null;
	}

	/**
	 * Retrieves all the {@link Component} implementing the given interface
	 * 
	 * @param interfce the {@link Interface}
	 * @return the list of Components or an empty list
	 */
	public static EList<Component> getAllInterfaceComponents(final Interface interfce) {
		EList<Component> list = new BasicEList<Component>();
		for (NamedElement el : getInterfaceClients(interfce)) {
			if (el instanceof Component && isComponentType(el)) {
				list.add((Component) el);
				EList<Component> compList = getComponentImplementations((Component) el);
				if (!compList.isEmpty())
					list.addAll(compList);
			}
			
		};
		return list;
	}

	/**
	 * Returns the {@link Stereotype} of a given element based on the qualified name, or null.
	 * 
	 * @param element  the element
	 * @param qualifiedName  the qualified name
	 * @return the stereotype or null
	 */
	public static Stereotype getStereotype(final Element element,
			final String qualifiedName) {
		Stereotype str = element.getApplicableStereotype(qualifiedName);
		return str;
	}

	/**
	 * Applies the {@link Stereotype} to a given element based on the qualified name.
	 * It returns the applied stereotype or null.
	 * 
	 * @param element  the element
	 * @param qualifiedName  the qualified name
	 * @return the stereotype applied or null
	 */
	public static Stereotype applyStereotype(final Element element,
			final String qualifiedName) {
		Stereotype str = getStereotype(
				element,
				qualifiedName);
		if (str != null)
			element.applyStereotype(str);
		return str;
	}

}
