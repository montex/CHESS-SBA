/*
-----------------------------------------------------------------------
--                Ada infrastructural code generator                 -- 
--                  for the CHESS component model                    --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Marco Panunzio         panunzio@math.unipd.it             --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

/**
 * 2015/04/03 NP: fixed problem regarding ordering of slots in instances of connectors
 * in getBoundPIslot (slot 0 instead of slot1)
 */

package org.polarsys.chess.codegen.ada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.chessmlprofile.ComponentModel.ComponentImplementation;
import org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;

// TODO: Auto-generated Javadoc
/**
 * The Class UML2Service contains utility methods that are meant to be called from the Acceleo Transformation
 */
public class UML2Service {

	/** The Constant DOCSTEREO. */
	private static final String DOCSTEREO = "Papyrus::Documentation::Documentation";
	//	private static final String REQUIREMENT_EXTENSION = "requirement";
	//	private static final Object LINK = "#Link_to";

	/**
	 * Gets the provided interface from a Port (must be stereotyped as ClientServerPort)
	 *
	 * @param port the port
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the provided interface
	 */
	public Interface getProvidedInterface(Port port, String stName) {
		Stereotype clSvPortSt = port.getAppliedStereotype(stName);
		ClientServerPort clSvPort = (ClientServerPort) port.getStereotypeApplication(clSvPortSt);
		// Assumption : 1 PI per Port
		return clSvPort.getProvInterface().get(0);
	}

	/** 
	 * Gets the required interface from a Port (must be stereotyped as ClientServerPort)
	 *
	 * @param port the port
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the required interface
	 */
	public Interface getRequiredInterface(Port port, String stName) {
		Stereotype clSvPortSt = port.getAppliedStereotype(stName);
		ClientServerPort clSvPort = (ClientServerPort) port.getStereotypeApplication(clSvPortSt);
		// Assumption : 1 RI per Port
		return clSvPort.getReqInterface().get(0);
	}

	/**
	 * Checks if a specific port is a ClientServerPort which can provide interfaces.
	 *
	 * @param pt the port
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return true if the port is a ClientServerPort of kind PROVIDED, false otherwise
	 */
	public Boolean isProvidedPort(Port pt, String stName) {
		Stereotype st = pt.getAppliedStereotype(stName);
		ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
		if (csp != null)
			return csp.getKind().equals(ClientServerKind.PROVIDED);
		else
			return false;

	}

	/**
	 * Checks if a specific port is a ClientServerPort which can require interfaces.
	 *
	 * @param pt the port
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return true if the port is a ClientServerPort of kind REQUIRED, false otherwise
	 */
	public Boolean isRequiredPort(Port pt, String stName) {
		Stereotype st = pt.getAppliedStereotype(stName);
		ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
		if (csp != null)
			return csp.getKind().equals(ClientServerKind.REQUIRED);
		else
			return false;
	}

	/**
	 * Gets the list of the provided interfaces from a list of ClientServerPorts.
	 *
	 * @param portList the list of ports.
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return a list containing the provided interfaces.
	 */
	public List<Interface> getProvidedInterfaceList(List<Port> portList, String stName) {

		ArrayList<Interface> intList = new ArrayList<Interface>();
		Port pt = null;
		Stereotype st = null;
		ClientServerPort csp = null;

		for (int i=0; i <portList.size(); i++) {
			pt = portList.get(i);
			st = pt.getAppliedStereotype(stName);
			csp = (ClientServerPort) pt.getStereotypeApplication(st);

			if (csp!= null && csp.getKind().equals(ClientServerKind.PROVIDED)) {
				// Assumption: only 1 providedInterface x Port
				intList.add(csp.getProvInterface().get(0));
			}
		}  

		return intList;
	}
	
	/**
	 * Returns a String representing the names of the provided interfaces from a list of ClientServerPorts.
	 *
	 * @param portList the list of ports.
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the String representing the names of the provided interfaces
	 */
	public String getProvidedInterfaceListAsQualifiedString(List<Port> portList, String stName) {

		Port pt = null;
		Stereotype st = null;
		ClientServerPort csp = null;
		String piNameList = new String();
		String interfaceName = null;
		boolean firstWritten = false;

		for (int i=0; i <portList.size(); i++) {
			pt = portList.get(i);
			st = pt.getAppliedStereotype(stName);
			csp = (ClientServerPort) pt.getStereotypeApplication(st);

			if (csp != null && csp.getKind().equals(ClientServerKind.PROVIDED)) {
				// Assumption: only 1 providedInterface x Port
				interfaceName = csp.getProvInterface().get(0).getName();
				if (! firstWritten) {
					piNameList += interfaceName + "." + interfaceName;
					firstWritten = true;
				} else {
					piNameList += " and " + interfaceName + "." + interfaceName;
				}		   
			}
		}  

		return piNameList;
	}

	/**
	 * Checks if among the elements of a List of ClientServerPort, at least one can require ports.
	 *
	 * @param portList the list of ports.
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return true if a ClientServerPort of kind REQUIRED is found in the list, false otherwise.
	 */
	public Boolean hasRequiredInterface(List<Port> portList, String stName) {
		Port pt = null;
		Stereotype st = null;
		ClientServerPort csp = null;

		for (int i=0; i <portList.size(); i++) {
			pt = portList.get(i);
			st = pt.getAppliedStereotype(stName);
			csp = (ClientServerPort) pt.getStereotypeApplication(st);

			if (csp!= null && csp.getKind().equals(ClientServerKind.REQUIRED)) {
				return true;
			}
		}  

		return false;
	}


	/**
	 * Gets the list of the required interfaces from a list of ClientServerPorts.
	 *
	 * @param portList the list of ports.
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return a list containing the required interfaces.
	 */
	public List<Interface> getRequiredInterfaceList(List<Port> portList, String stName) {

		ArrayList<Interface> intList = new ArrayList<Interface>();
		Port pt = null;
		Stereotype st = null;
		ClientServerPort csp = null;

		for (int i=0; i <portList.size(); i++) {
			pt = portList.get(i);
			st = pt.getAppliedStereotype(stName);
			csp = (ClientServerPort) pt.getStereotypeApplication(st);

			if (csp != null && csp.getKind().equals(ClientServerKind.REQUIRED)) {
				// Assumption: only 1 requiredInterface x Port
				intList.add(csp.getReqInterface().get(0));
			}
		}  

		return intList;
	}

	/**
	 * Gets a String representing the operation signature.
	 *
	 * @param c the component containing the operation
	 * @param op the operation
	 * @return the operation signature as a String
	 */
	public String getOperationSignature(Component c, Operation op) {
		String opName = new String(c.getName() + "." + op.getName());
		//MODIFIED MP   WAS ELIST
		List<Parameter> lParam = op.getOwnedParameters();
		if (lParam.size() > 0) {
			opName += "(";
			opName += lParam.get(0).getType().getName();

			if (lParam.size() > 1) {

				for (int i=1; i < lParam.size(); i++) {
					opName += ", " + lParam.get(i).getType().getName();
				}
			}
			opName += ")";
		}
		return opName;
	}

	/**
	 * This is a method very specific to the Acceleo transformation (Ada code generation)
	 *
	 * @param slotList the slot list
	 * @param stName the st name
	 * @param st2Name the st2 name
	 * @return the package to with spec
	 */
	public List<String> getPackageToWithSpec(List<Object> slotList, String stName, String st2Name) {

		boolean cyclicRequired = false;
		boolean sporadicRequired = false;

		boolean pkgSystemAdded = false;
		boolean pkgRealTimeAdded = false;
		boolean pkgDataStructureAdded = false;
		boolean pkgContainerProtectionAdded = false;
		boolean pkgCyclicTaskAdded = false;

		Slot slot = null;
		CHRtPortSlot chrtPs = null;
		CHRtSpecification chrtSpec = null;
		List<CHRtSpecification> chRtSpecList = null;
		ArrayList<String> withPackageList = new ArrayList<String>();

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);

			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				chRtSpecList = chrtPs.getCH_RtSpecification();

				for (int j=0; j < chRtSpecList.size(); j++) {
					chrtSpec = chRtSpecList.get(j);
					String occKind = chrtSpec.getOccKind();

					if (occKind != null && ! occKind.equals("")) {

						if (occKind.startsWith("periodic") && ! cyclicRequired) {

							if (! pkgRealTimeAdded) {
								withPackageList.add("with Ada.Real_Time; use Ada.Real_Time;");
								pkgRealTimeAdded = true;
							}

							if (! pkgDataStructureAdded) {
								withPackageList.add("with Data_Structure;");
								pkgDataStructureAdded = true;
							}

							if (! pkgContainerProtectionAdded) {
								withPackageList.add("with Container_Protection; use Container_Protection;");
								pkgContainerProtectionAdded = true;
							}

							if (! pkgCyclicTaskAdded) {
								withPackageList.add("with Cyclic_Task;");
								pkgCyclicTaskAdded = true;
							}

							cyclicRequired = true;
						} else if (occKind.startsWith("sporadic") && ! sporadicRequired) {

							if (! pkgSystemAdded) {
								withPackageList.add("with System;");
								pkgSystemAdded = true;
							}

							if (! pkgRealTimeAdded) {
								withPackageList.add("with Ada.Real_Time; use Ada.Real_Time;");
								pkgRealTimeAdded = true;
							}

							if (! pkgDataStructureAdded) {
								withPackageList.add("with Data_Structure;");
								pkgDataStructureAdded = true;
							}    		 

							sporadicRequired = true;
						}

					} else if (chrtSpec.getProtection().equals(CallConcurrencyKind.GUARDED)) {// occKind is null or ""

						if (! pkgSystemAdded) {
							withPackageList.add("with System;");
							pkgSystemAdded = true;
						}

					}
				}

				if (cyclicRequired && sporadicRequired) {
					break;
				}
			}
		}
		return withPackageList;
	}

	/**
	 * Gets the "value" substring of a given VSL string.
	 * For example, from the VSL String (value=45.0,unit=ms) this method returns 45.0
	 *
	 * @param inputVSL the input VSL string
	 * @return the "value" substring
	 */
	public String getValue(String inputVSL) {
		int endOfValueIndex = inputVSL.indexOf(",unit");
		int startOfValueIndex = inputVSL.indexOf("value=") + 6;
		return inputVSL.substring(startOfValueIndex, endOfValueIndex);
	}

	/**
	 * Gets the "unit" substring of a given VSL string.
	 * For example, from the VSL String (value=45.0,unit=ms) this method returns ms
	 *
	 * @param inputVSL the input VSL string
	 * @return the "unit" substring
	 */
	public String getUnit(String inputVSL) {
		int startOfUnitIndex = inputVSL.indexOf("unit=") + 5;
		int endOfUnitIndex = inputVSL.indexOf("))");
		return inputVSL.substring(startOfUnitIndex, endOfUnitIndex);
	}

	/**
	 * Gets the Priority of an operation.
	 * Pre-condition : op is an operation marked as "cyclic" in some CHRtSpecification 
	 * 
	 * @param slotList the list of Slots in the model
	 * @param op the Operation
	 * @param stName unused
	 * @return the priority as String, or a message error
	 */
	public String getPriority(List<Object> slotList, Operation op, String stName) {
		Slot slot = null;

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			CHRtPortSlot chrtPs = null;

			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					if (CHRtSpecList.get(j).getContext().equals(op)) {
						return CHRtSpecList.get(j).getRelativePriority();
					}
				}
			}

		}
		//
		return "ERROR_PRIORITY_NOT_FOUND";
	}

	/**
	 * Gets the Period or minimum interarrival time (MIAT) of an operation.
	 * Pre-condition : op is an operation marked as "cyclic" or "sporadic" in some CHRtSpecification
	 *
	 * @param slotList the list of Slots in the model
	 * @param op the Operation
	 * @param stName unused
	 * @return the period (for a "cyclic" operation) or the MIAT (for a "sporadic" operation)
	 */
	public String getPeriodOrMIAT(List<Object> slotList, Operation op, String stName) {
		Slot slot = null;

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			CHRtPortSlot chrtPs = null;

			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					if (CHRtSpecList.get(j).getContext().equals(op)) {  

						String occKind = chrtPs.getCH_RtSpecification().get(0).getOccKind();
						String periodOrMIAT = getValue(occKind);
						if (periodOrMIAT.length() <= 5) {
							return periodOrMIAT.substring(0, periodOrMIAT.length()-2);
						} else {
							return periodOrMIAT.substring(0, periodOrMIAT.length()-5).concat("_").
									concat(periodOrMIAT.substring(periodOrMIAT.length()-5, periodOrMIAT.length()-2));
						}
					}
				}
			}
		}
		return "ERROR_PERIOD_OR_MIAT_NOT_FOUND";
	}

	/**
	 * Gets the Ceiling of an operation.
	 * Pre-condition : op is an operation marked as "cyclic", "sporadic" or "protected" in some CHRtSpecification 
	 * 
	 * @param slotList the list of Slots in the model
	 * @param op the Operation
	 * @param stName unused
	 * @return the Ceiling as String, or a message error
	 */
	public String getCeiling(List<Object> slotList, Operation op, String stName) {
		Slot slot = null;

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			CHRtPortSlot chrtPs = null;

			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					if (CHRtSpecList.get(j).getContext().equals(op)) {  

						return chrtPs.getCH_RtSpecification().get(j).getCeiling();
					}
				}
			}
		}
		return "ERROR_CEILING_NOT_FOUND";
	}

	/**
	 * Gets a list of cyclic operations from a list of slots.
	 *
	 * @param slotList the list of Slots in the model
	 * @param stName unused
	 * @return a list containing the cyclic operations 
	 */
	public List<Operation> getCyclicOperationList(List<Slot> slotList, String stName) {

		ArrayList<Operation> cyclicOpList = new ArrayList<Operation>();
		CHRtPortSlot chrtPs = null;
		Slot slot = null; 

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();

					if (occKind != null) {
						if (occKind.startsWith("periodic")) {
							cyclicOpList.add((Operation) CHRtSpecList.get(j).getContext());
						}   
					}
				}
			}
		}
		return cyclicOpList;
	}

	/**
	 * Gets a list of sporadic operations from a list of slots.
	 *
	 * @param slotList the list of Slots in the model
	 * @param stName unused
	 * @return a list containing the sporadic operations 
	 */
	public List<Operation> getSporadicOperationList(List<Slot> slotList, String stName) {

		ArrayList<Operation> sporadicOpList = new ArrayList<Operation>();
		CHRtPortSlot chrtPs = null;
		Slot slot = null; 

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();

					if (occKind != null) {
						if (occKind.startsWith("sporadic")) {
							sporadicOpList.add((Operation) CHRtSpecList.get(j).getContext());
						}   
					}
				}
			}
		}
		return sporadicOpList;
	}

	/**
	 * Gets a list of protected operations from a list of slots.
	 *
	 * @param slotList the list of Slots in the model
	 * @param stName unused
	 * @return a list containing the protected operations 
	 */
	public List<Operation> getProtectedOperationList(List<Slot> slotList, String stName) {

		ArrayList<Operation> protectedOpList = new ArrayList<Operation>();
		CHRtPortSlot chrtPs = null;
		Slot slot = null; 

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();

					// Sporadic kind is GUARDED and occKind => sporadic(...)
					if (CHRtSpecList.get(j).getProtection().equals(CallConcurrencyKind.GUARDED) &&
							(occKind == null || occKind.isEmpty())) {
						protectedOpList.add((Operation) CHRtSpecList.get(j).getContext());
					}
				}
			}
		}
		return protectedOpList;
	}


	/**
	 * Gets the Protected Operation from the given Slot
	 *
	 * @param sl the Slot
	 * @param stName unused
	 * @return the Protected Operation
	 */
	public List<Operation> getSlotProtectedOperation(Slot sl, String stName) {

		ArrayList<Operation> protectedOpList = new ArrayList<Operation>();
		CHRtPortSlot chrtPs = null;

		List<Stereotype> stList = sl.getAppliedStereotypes();
		if (! stList.isEmpty()) {
			chrtPs = (CHRtPortSlot) sl.getStereotypeApplication(stList.get(0));
			List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
			for (int j=0; j < CHRtSpecList.size(); j++) {
				String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();

				// Sporadic kind is GUARDED and occKind => sporadic(...)
				if (CHRtSpecList.get(j).getProtection().equals(CallConcurrencyKind.GUARDED) &&
						(occKind == null || occKind.isEmpty())) {
					protectedOpList.add((Operation) CHRtSpecList.get(j).getContext());
				}
			}
		}
		return protectedOpList;
	}


	/**
	 * Gets a list of unprotected operations from a list of slots.
	 *
	 * @param slotList the list of Slots in the model
	 * @param stName unused
	 * @return a list containing the unprotected operations 
	 */
	public List<Operation> getUnprotectedOperationList(List<Slot> slotList, String stName) {

		ArrayList<Operation> unprotectedOpList = new ArrayList<Operation>();
		CHRtPortSlot chrtPs = null;
		Slot slot = null; 

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();
					if (CHRtSpecList.get(j).getProtection().equals(CallConcurrencyKind.CONCURRENT) &&
							(occKind == null || occKind.isEmpty())) {
						unprotectedOpList.add((Operation) CHRtSpecList.get(j).getContext());
					}
				}
			}
		}
		return unprotectedOpList;
	}

	/**
	 * Gets the list of component instances from the list of the instances with multiplicity. (i.e package "_full" in the model)
	 *
	 * @param instList the list of the instances with multiplicity
	 * @param stName the name of the stereotype. Must be "CHESS::ComponentModel::ComponentImplementation"
	 * @return the list of the component instances
	 */
	public List<InstanceSpecification> getComponentInstanceList(List<InstanceSpecification> instList, String stName) {
		ArrayList<InstanceSpecification> componentInstanceList = new ArrayList<InstanceSpecification>();

		for (int i=0; i<instList.size(); i++) {
			List<Classifier> clList = instList.get(i).getClassifiers();

			if (clList.size() > 0) {
				Stereotype st = clList.get(0).getAppliedStereotype(stName);

				if (st != null && !instList.get(i).getNearestPackage().getName().endsWith("_full")) {
					componentInstanceList.add(instList.get(i));
				}
			}
		}

		return componentInstanceList;
	}

	/**
	 * Gets the list of slots that require an interface from a list of instances
	 *
	 * @param instList the list of instances
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the list of slots that require an interface
	 */
	public List<Slot> getRequiredInterfaceSlotList(List<InstanceSpecification> instList, String stName) {
		ArrayList<Slot> reqInterfaceSlotList = new ArrayList<Slot>();

		for (int i=0; i<instList.size(); i++) {
			List<Slot> slList = instList.get(i).getSlots();
			for (int j=0; j<slList.size(); j++) { 

				if (slList.get(j).getDefiningFeature() instanceof Port) {
					Port pt = (Port) slList.get(j).getDefiningFeature();
					Stereotype st = pt.getAppliedStereotype(stName);
					if (st != null) {
						ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
						if (csp.getKind() == ClientServerKind.REQUIRED) {
							reqInterfaceSlotList.add(slList.get(j));
						}
					}
				}
			}
		}

		// the list of all RI
		return reqInterfaceSlotList;
	}


	/**
	 * Gets the list of slots that require an interface from a single instance
	 *
	 * @param instList the InstanceSpecfication
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the list of slots that require an interface
	 */
	public List<Slot> getInstanceRequiredInterfaceSlotList(InstanceSpecification inst, String stName) {
		ArrayList<Slot> reqInterfaceSlotList = new ArrayList<Slot>();


		List<Slot> slList = inst.getSlots();
		for (int j=0; j<slList.size(); j++) { 

			if (slList.get(j).getDefiningFeature() instanceof Port) {
				Port pt = (Port) slList.get(j).getDefiningFeature();
				Stereotype st = pt.getAppliedStereotype(stName);
				if (st != null) {
					ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
					if (csp.getKind() == ClientServerKind.REQUIRED) {
						reqInterfaceSlotList.add(slList.get(j));
					}
				}
			}
		}

		// the list of all RI slots of the instance specification
		return reqInterfaceSlotList;
	}

	/**
	 * Gets the list of slots that provide an interface from a list of instances
	 *
	 * @param instList the list of instances
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the list of slots that provide an interface
	 */
	public List<Slot> getProvidedInterfaceSlotList(List<InstanceSpecification> instList, String stName) {
		ArrayList<Slot> provInterfaceSlotList = new ArrayList<Slot>();

		for (int i=0; i<instList.size(); i++) {
			List<Slot> slList = instList.get(i).getSlots();
			for (int j=0; j<slList.size(); j++) { 

				if (slList.get(j).getDefiningFeature() instanceof Port) {
					Port pt = (Port) slList.get(j).getDefiningFeature();
					Stereotype st = pt.getAppliedStereotype(stName);
					if (st != null) {
						ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
						if (csp.getKind() == ClientServerKind.PROVIDED) {
							provInterfaceSlotList.add(slList.get(j));
						}
					}
				}
			}
		}

		// the list of all RI
		return provInterfaceSlotList;
	}


	/**
	 * Gets the list of slots that provide an interface from a single instance
	 *
	 * @param instList the InstanceSpecfication
	 * @param stName the stereotype name. Must be "MARTE::MARTE_DesignModel::GCM::ClientServerPort"
	 * @return the list of slots that provide an interface
	 */
	public List<Slot> getInstanceProvidedInterfaceSlotList(InstanceSpecification inst, String stName) {
		ArrayList<Slot> provInterfaceSlotList = new ArrayList<Slot>();


		List<Slot> slList = inst.getSlots();
		for (int j=0; j<slList.size(); j++) { 

			if (slList.get(j).getDefiningFeature() instanceof Port) {
				Port pt = (Port) slList.get(j).getDefiningFeature();
				Stereotype st = pt.getAppliedStereotype(stName);
				if (st != null) {
					ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
					if (csp.getKind() == ClientServerKind.PROVIDED) {
						provInterfaceSlotList.add(slList.get(j));
					}
				}
			}
		}

		// the list of all RI slots of the instance specification
		return provInterfaceSlotList;
	}



	/**
	 * Gets the connector inst list.
	 *
	 * @param instList the inst list
	 * @param stName the st name
	 * @return the connector inst list
	 */
	public List<InstanceSpecification> getConnectorInstList(List<InstanceSpecification> instList, String stName) {
		ArrayList<InstanceSpecification> connectorInstList = new ArrayList<InstanceSpecification>();

		for (int i=0; i<instList.size(); i++) {
			if (instList.get(i).getClassifiers().size()==0) {
				List<Slot> slList = instList.get(i).getSlots();
				if (slList.size() > 0) {
					Port pt = (Port) slList.get(0).getDefiningFeature();
					Stereotype st = pt.getAppliedStereotype(stName);
					// check if the defining feature is a <<ClientServerPort>>
					if (st != null) {
						connectorInstList.add(instList.get(i));
					}
				}
			}
		}
		return connectorInstList;
	}



	/**
	 * Gets the component impl list.
	 *
	 * @param compList the comp list
	 * @param stName the st name
	 * @return the component impl list
	 */
	public List<Component> getComponentImplList(List<Component> compList, String stName) {
		ArrayList<Component> compImplList = new ArrayList<Component>();

		for (int i=0; i<compList.size(); i++) {
			Stereotype st = compList.get(i).getAppliedStereotype(stName);
			// check if it is a <<ComponentImplementation>>
			if (st != null) {
				compImplList.add(compList.get(i));
			}
		}
		return compImplList;
	}

	/**
	 * Gets the provided slot bounded to the given slot
	 *
	 * @param sl the given slot
	 * @param connectorInstList the list of connector instances
	 * @return the bounded provided slot
	 */
	public Slot getBoundPIslot(Slot sl, List<InstanceSpecification> connectorInstList) {

		// All methods based on equality between slot fail (indexOf, contains, etc..)
		// Check that definingFeature and owningInstance of the slot are matching

		for (int i=0; i<connectorInstList.size(); i++) {
			List<Slot> slotList = connectorInstList.get(i).getSlots();
			List<Slot> targetInstanceSlotList = null;
			Slot targetSlot = null;

			// 2 slots are included in the instance of the connecto.
			Slot slot0 = slotList.get(0);
			Slot slot1 = slotList.get(1);

			if (slot0.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot0.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					//slot1 is the slot in the instance of the connector
					//we must return the slot in the instance of the component instance!
					vsList = slot1.getValues();
					iv = (InstanceValue) vsList.get(0);
					InstanceSpecification targetIs =  iv.getInstance();
					targetInstanceSlotList = targetIs.getSlots();
					for (int j = 0; j < targetInstanceSlotList.size(); j++) {
						targetSlot = targetInstanceSlotList.get(j);
						if (targetSlot.getDefiningFeature().equals(slot1.getDefiningFeature())) {
							return targetSlot;
						}
					}	   

				}
			} else if (slot1.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot1.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					//slot0 is the slot in the instance of the connector
					//we must return the slot in the instance of the component instance!
					vsList = slot0.getValues();
					iv = (InstanceValue) vsList.get(0);
					InstanceSpecification targetIs =  iv.getInstance();
					targetInstanceSlotList = targetIs.getSlots();
					for (int j = 0; j < targetInstanceSlotList.size(); j++) {
						targetSlot = targetInstanceSlotList.get(j);
						if (targetSlot.getDefiningFeature().equals(slot0.getDefiningFeature())) {
							return targetSlot;
						}
					}	   

				}
			}
		}
		return sl;	   
	}

	/**
	 * Gets the required slots bounded to the given slot
	 *
	 * @param sl the given slot
	 * @param connectorInstList the list of connector instances
	 * @return the bounded required slots list
	 */
	public List<Slot> getBoundRIslotList(Slot sl, List<InstanceSpecification> connectorInstList) {
		List<Slot> boundRIslotList = new ArrayList<Slot>();

		// Check that definingFeature and owningInstance of the slot are matching

		for (int i=0; i<connectorInstList.size(); i++) {
			List<Slot> slotList = connectorInstList.get(i).getSlots();
			List<Slot> targetInstanceSlotList = null;
			Slot targetSlot = null;

			// 2 slots are included in the instance of the connector.
			Slot slot0 = slotList.get(0);
			Slot slot1 = slotList.get(1);

			if (slot0.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot0.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					//slot1 is the slot in the instance of the connector
					//we must return the corresponding slot in the instance of the component instance!
					vsList = slot1.getValues();
					iv = (InstanceValue) vsList.get(0);
					InstanceSpecification targetIs =  iv.getInstance();
					targetInstanceSlotList = targetIs.getSlots();
					for (int j = 0; j < targetInstanceSlotList.size(); j++) {
						targetSlot = targetInstanceSlotList.get(j);
						if (targetSlot.getDefiningFeature().equals(slot1.getDefiningFeature())) {
							boundRIslotList.add(targetSlot);
						}
					}	   

				}
			} else if (slot1.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot1.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					//slot0 is the slot in the instance of the connector
					//we must return the corresponding slot in the instance of the component instance!
					vsList = slot0.getValues();
					iv = (InstanceValue) vsList.get(0);
					InstanceSpecification targetIs =  iv.getInstance();
					targetInstanceSlotList = targetIs.getSlots();
					for (int j = 0; j < targetInstanceSlotList.size(); j++) {
						targetSlot = targetInstanceSlotList.get(j);
						if (targetSlot.getDefiningFeature().equals(slot0.getDefiningFeature())) {
							boundRIslotList.add(targetSlot);
						}
					}	   

				}
			}
		}
		return boundRIslotList;	   
	}

	/**
	 * Checks if the given operation is cyclic
	 *
	 * @param slotList the list of slots in the model
	 * @param op the operation
	 * @param stName unused
	 * @return true, if the operation cyclic
	 */
	public boolean isCyclicOperation(List<Slot> slotList, Operation op, String stName) {

		CHRtPortSlot chrtPs = null;
		Slot slot = null; 

		for (int i=0; i < slotList.size(); i++) {
			slot = (Slot) slotList.get(i);
			List<Stereotype> stList = slot.getAppliedStereotypes();
			if (! stList.isEmpty()) {
				chrtPs = (CHRtPortSlot) slot.getStereotypeApplication(stList.get(0));
				List<CHRtSpecification> CHRtSpecList = chrtPs.getCH_RtSpecification();
				for (int j=0; j < CHRtSpecList.size(); j++) {
					Operation myOp = (Operation) CHRtSpecList.get(j).getContext();

					if (myOp.equals(op)) {
						String occKind = chrtPs.getCH_RtSpecification().get(j).getOccKind();

						if (occKind != null) {
							if (occKind.startsWith("periodic")) {
								return true;
							}   
						}
					}
				}
			}
		}
		return false;
	}


	/**
	 * Gets the list of operations called by the given operation.
	 *
	 * @param op the given operation
	 * @return the list of called operations
	 */
	public List<CallOperationAction> getCalledOperation(Operation op) {
		ArrayList<CallOperationAction> coaList = new ArrayList<CallOperationAction>();
		List<Behavior> bhList = op.getMethods();

		if (bhList.size() > 0) {
			for (int i=0; i < bhList.size(); i++) {
				if (bhList.get(i) instanceof Activity) {

					List<ActivityNode> actNodeList = ((Activity) bhList.get(i)).getNodes();
					for (int j=0; j < actNodeList.size(); j++) {
						if (actNodeList.get(j) instanceof CallOperationAction) {
							coaList.add((CallOperationAction) actNodeList.get(j));
						}
					}
				}
			}
		}
		return coaList;
	}
	
	/**
	 * Checks if two operation are equal to each other according to the following criteria:
	 * name, visibility, size of parameter list
	 * type of parameters, name of parameters
	 * isAbstract is purposely not considered
	 * 
	 * @param op1 the first operation
	 * @param op2 the second operation
	 * @return true, two operation are equal to each other
	 */
	public boolean isSameOperation(Operation op1, Operation op2) {
		if (! op1.getName().equals(op2.getName())) {
			return false;
		}

		if (! op1.getVisibility().equals(op2.getVisibility())) {
			return false;
		}


		List<Parameter> paramList1 = op1.getOwnedParameters();
		List<Parameter> paramList2 = op2.getOwnedParameters();

		if (paramList1.size() != paramList2.size()) {
			return false;
		}

		for (int i = 0; i < paramList1.size(); i++) {
			Parameter par1 = paramList1.get(i);
			Parameter par2 = paramList2.get(i);

			//par1.getType().equals(par2.getType()) unexpectedly fails
			//replacing it with a very reliable check on names
			if (! par1.getType().getName().equals(par2.getType().getName())) {
				return false;
			}

			if (! par1.getName().equals(par2.getName())) {
				return false;
			}

			if (! par1.getDirection().equals(par2.getDirection())) {
				return false;
			}
		}
		return true;
	}


	/**
	 * Gets the interface containing the given operation searching in the list of provided interfaces
	 *
	 * @param op the given operation
	 * @param ptList the list of ports. Used to get the list of provided interfaces
	 * @param stName the stereotype name
	 * @return the interface containing the given operation
	 */
	public Interface getInterface(Operation op, List<Port> ptList, String stName) {

		List<Interface> interfaceList = getProvidedInterfaceList(ptList, stName);

		for (int i=0; i < interfaceList.size(); i++) {
			Interface myIf = interfaceList.get(i);
			List<Operation> opList = myIf.getOperations();

			for (int j=0; j < opList.size(); j++) {
				if ( isSameOperation(op, opList.get(j))) {
					return myIf;
				}
			}
		}

		return null;
	}

	/**
	 * Checks if is data type with required.
	 * Checks if the generated code requires a "with DataTypes;" clause
	 *
	 * @param aInt the Interface
	 * @return true, if "with DataTypes;" clause is required
	 */
	public boolean isDataTypeWithRequired(Interface aInt) {
		List<Operation> opList = aInt.getOwnedOperations();
		for (int i=0; i < opList.size(); i++) {
			List<Parameter> parList = opList.get(i).getOwnedParameters();

			for (int j=0; j < parList.size(); j++) {
				Parameter par = parList.get(j);
				if (! (par.getName().equals("Integer") || par.getName().equals("Float") ||
						par.getName().equals("Natural") )) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Gets the implementation language from a given ComponentImplementation.
	 *
	 * @param c the given ComponentImplementation
	 * @param stName the stereotype name
	 * @return the implementation language String
	 */
	public String getImplementationLanguage(Component c, String stName) {
		Stereotype cImplSt = c.getAppliedStereotype(stName);
		ComponentImplementation cImpl = (ComponentImplementation) c.getStereotypeApplication(cImplSt);

		String lang = cImpl.getLanguage();
		if (lang == null) {
			return "Ada";
		} else {
			return lang;
		}
	}

	/**
	 * Converts, if possible, an Ada data type to a C data type.
	 *
	 * @param type the Ada type
	 * @return the C type as String
	 */
	public String adaTypeToCtype(Type type) {
		if (type instanceof PrimitiveType && type.getName().equals("Integer")) {
			return "int";
		} else if (type instanceof PrimitiveType && type.getName().equals("Float")) {
			return "float";
		} else if (type instanceof PrimitiveType && type.getName().equals("Boolean")) {
			return "bool";
		} //else if (type instanceof Enumeration) {
		//  return "int";
		//}

		// assumes that the datatype have been defined in the datatype package
		return type.getName();
	}

	/**
	 * Checks if there is at least one ComponentImplementation with language equals to C or C++
	 *
	 * @param lComp the list of ComponentImplementation
	 * @param stName the stereotype name
	 * @return true if there is at least one ComponentImplementation with language equals to C or C++
	 */
	public Boolean hasCimplementation(List<Component> lComp, String stName) {
		for (int i=0; i < lComp.size(); i++) {
			Stereotype compImplSt = lComp.get(i).getAppliedStereotype(stName);
			if (compImplSt != null) {
				ComponentImplementation cImpl = (ComponentImplementation) lComp.get(i).getStereotypeApplication(compImplSt);
				if (cImpl.getLanguage().equals("C") || (cImpl.getLanguage().equals("C++"))) {
					return true;
				}
			}
		}
		// all component implementations are realized in Ada
		return false; 
	}

	/**
	 * Gets the list of called operation (CalledOperationAction) from the given Activity.
	 *
	 * @param act the Activity
	 * @return the list of called operations
	 */
	public List<CallOperationAction> getCalledOperationList(Activity act) {
		ArrayList<CallOperationAction> coaList = new ArrayList<CallOperationAction>();

		List<ActivityNode> actNodeList = act.getNodes();
		ActivityNode actNode = null;
		ControlFlow cf = null;
		boolean finalNodeFound = false;

		for (int j=0; j < actNodeList.size(); j++) {
			if (actNodeList.get(j) instanceof InitialNode) {
				actNode = (InitialNode) actNodeList.get(j);
				break;
			}
		}
		// iNode contains the initial node of a well-specified activity diagram
		while (! finalNodeFound) {
			cf = (ControlFlow) actNode.getOutgoings().get(0);
			if (cf.getTarget() instanceof CallOperationAction) {
				actNode = (CallOperationAction) cf.getTarget();
				coaList.add((CallOperationAction) actNode);
			} else if (cf.getTarget() instanceof ActivityFinalNode){
				finalNodeFound = true;
			} else {
				return null;
			}
		}

		return coaList;
	}

	/**
	 * Gets the the Intra-Component Binding (ICB) Activity of the given Operation
	 *
	 * @param op the operation
	 * @return the ICB Activity
	 */
	public Activity getICB(Operation op) {
		List<Behavior> bhList = op.getMethods();
		for (int i=0; i<bhList.size(); i++) {
			if (bhList.get(i) instanceof Activity) {
				return (Activity) bhList.get(i);
			}
		}

		return null;
	}

	/**
	 * Gets the component instance list.
	 *
	 * @param cImpl the c impl
	 * @param allIsList the all is list
	 * @return the component instance list
	 */
	public List<InstanceSpecification> getComponentInstanceList(Component cImpl, List<InstanceSpecification> allIsList) {
		ArrayList<InstanceSpecification> isList = new ArrayList<InstanceSpecification>();

		for (int i=0; i<allIsList.size(); i++) {
			if (allIsList.get(i).getClassifiers().get(0).equals(cImpl)) {
				isList.add(allIsList.get(i));
			}
		}

		return isList;
	}

	// Deployment related services


	/**
	 * Checks if the system is single node.
	 *
	 * @param allIsList the list of all the instances
	 * @param stName the stereotype name
	 * @return true if the system is single node, false if it is multi node (distributed) 
	 */
	public Boolean isSingleNodeSystem(List<InstanceSpecification> allIsList, String stName) {
		InstanceSpecification processingNode = null;
		Stereotype st = null;

		for (int i=0; i < allIsList.size(); i++) {
			st = allIsList.get(i).getAppliedStereotype(stName);

			if (st != null) {
				if (processingNode == null) {
					processingNode = allIsList.get(i);
				} else {
					if (! allIsList.get(i).equals(processingNode)) {
						return false; 
					}
				}
			}
		}

		return true;
	}


	/**
	 * Gets the list of processing nodes.
	 *
	 * @param allIsList the list of all the instances
	 * @param stName the the stereotype name
	 * @return the list of processing nodes.
	 */
	public List<InstanceSpecification> getProcessingNodeList(List<InstanceSpecification> allIsList, String stName) {
		ArrayList<InstanceSpecification> pnList = new ArrayList<InstanceSpecification>();
		Stereotype st = null;

		for (int i=0; i < allIsList.size(); i++) {
			st = allIsList.get(i).getAppliedStereotype(stName);

			if (st != null) {
				pnList.add(allIsList.get(i));
			}
		}

		return pnList;
	}

	/**
	 * Gets the instance specification deployed to the given instance specification hw node.
	 *
	 * @param node the given hw node
	 * @param commList the list of comments (assigns)
	 * @param stName the stereotype name
	 * @return list of instance specification deployed
	 */
	public List<InstanceSpecification> getNodeInstanceSpecification(InstanceSpecification node, List<Comment> commList, String stName) {

		ArrayList<InstanceSpecification> isList = new ArrayList<InstanceSpecification>();
		Stereotype st = null;
		Assign ass = null;

		for (int i=0; i < commList.size(); i++) {
			st = commList.get(i).getAppliedStereotype(stName);

			if (st != null) {
				ass = (Assign) commList.get(i).getStereotypeApplication(st);

				if (ass.getTo().get(0).equals(node)) {
					InstanceSpecification fromInst = (InstanceSpecification) ass.getFrom().get(0);
					if(!isList.contains(fromInst)){
						isList.add(fromInst);
					}
				}
			}
		}

		return isList;
	}

	/**
	 * Gets the list of component implementations from the given list of instance specifications.
	 * (it should be the list of deployed instances @see UML2Service.getNodeInstanceSpecification)
	 *
	 * @param isList the the list of instance specifications
	 * @param stName the stereotype name
	 * @return the list of component implementations
	 */
	public List<Component> getNodeComponentImplementationList(List<InstanceSpecification> isList, String stName) {

		ArrayList<Component> cImplList = new ArrayList<Component>();
		Component cImpl = null;

		for (int i=0; i < isList.size(); i++) {

			if (isList.get(i).getClassifiers().get(0) instanceof Component) {
				cImpl = (Component) isList.get(i).getClassifiers().get(0);
				if (cImpl.getAppliedStereotype(stName) != null) {
					cImplList.add(cImpl);		
				}


			}
		}

		return cImplList;		
	}

	/**
	 * Gets the list of component types from the given list of component implementations
	 *
	 * @param cImplList the list of component implementations
	 * @param stName the stereotype name
	 * @return the list of component types
	 */
	public List<Component> getNodeComponentTypeList(List<Component> cImplList, String stName) {

		ArrayList<Component> cTypeList = new ArrayList<Component>();
		Component cType = null;

		for (int i=0; i < cImplList.size(); i++) {

			if (cImplList.get(i).getClientDependencies().get(0).getSuppliers().get(0) instanceof Component) {
				cType = (Component) cImplList.get(i).getClientDependencies().get(0).getSuppliers().get(0);
				if (cType.getAppliedStereotype(stName) != null) {
					cTypeList.add(cType);		
				}
			}
		}

		return cTypeList;		
	}

	/**
	 * Gets the list of component types from the given list of component implementations
	 *
	 * @param cImplList the list of component implementations
	 * @param stName the stereotype name
	 * @return the list of component types
	 */
	public List<Component> getAllComponentTypeList(List<Component> allComponentList, String stName) {

		ArrayList<Component> cTypeList = new ArrayList<Component>();

		for (int i=0; i < allComponentList.size(); i++) {

			if (allComponentList.get(i).getAppliedStereotype(stName) != null) {
				cTypeList.add(allComponentList.get(i));		
			}
		}

		return cTypeList;		
	}

	/**
	 * Gets the list of interfaces from the given list of component types
	 *
	 * @param cImplList the list of component types
	 * @param stName the stereotype name
	 * @return the list of interfaces
	 */
	public List<Interface> getNodeInterfaceList(List<Component> cTypeList, String stName) {

		ArrayList<Interface> ifList = new ArrayList<Interface>();
		Stereotype st = null;

		for (int i=0; i < cTypeList.size(); i++) {
			List<Property> pList = cTypeList.get(i).getOwnedAttributes();
			ClientServerPort csp = null;

			if (pList != null) {

				for (int j=0; j < pList.size(); j++) {

					if (pList.get(j) instanceof Port) {
						st = pList.get(j).getAppliedStereotype(stName);
						if (st != null) {
							csp = (ClientServerPort) pList.get(j).getStereotypeApplication(st);
							if (csp.getKind().equals(ClientServerKind.PROVIDED)) {
								if (csp.getProvInterface().get(0) != null) {
									ifList.add(csp.getProvInterface().get(0));
								}
							} else if (csp.getKind().equals(ClientServerKind.REQUIRED)) {
								if (csp.getReqInterface().get(0) != null) {
									ifList.add(csp.getReqInterface().get(0));
								}
							}
						}
					}
				}
			}
		}

		return ifList;		
	}


	/**
	 * Gets the deployment processing node.
	 *
	 * @param sl the given slot
	 * @param commList the list of comments (Assigns)
	 * @param stName the stereotype name
	 * @return the deployment processing node
	 */
	public InstanceSpecification getDeploymentProcessingNode(Slot sl, List<Comment> commList, String stName) {

		Stereotype st = null;
		Assign assign = null;

		for (int i=0; i < commList.size(); i++) {
			st = commList.get(i).getAppliedStereotype(stName);

			if (st != null) {
				assign = (Assign) commList.get(i).getStereotypeApplication(st);

				if (assign.getFrom() != null && assign.getTo() != null) {

					if (assign.getTo().get(0) instanceof InstanceSpecification && 
							assign.getFrom().get(0) instanceof InstanceSpecification) {
						if (assign.getFrom().get(0).equals(sl.getOwningInstance())) {
							return (InstanceSpecification) assign.getTo().get(0);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Checks if the remote communication is necessary.
	 *
	 * @param slList the list of slots
	 * @param procNode the processing node (@see UML2Service.getDeploymentProcessingNode)
	 * @param commList the list of comments
	 * @param stName the stereotype name
	 * @return true if remote communication is necessary, false otherwise
	 */
	public Boolean isRemoteCommNecessary (List<Slot> slList, InstanceSpecification procNode,
			List<Comment> commList, String stName) {

		for (int i=0; i < slList.size(); i++) {
			if (! this.getDeploymentProcessingNode(slList.get(i), commList, stName).equals(procNode)){
				return true;
			}
		}

		return false;
	}

	/**
	 * Gets the provided operation list.
	 *
	 * @param cTypeList the list of component types
	 * @param stName the stereotype name
	 * @return the list of provided operations
	 */
	public List<Operation> getProvidedOperationList (List<Component> cTypeList, String stName) {
		ArrayList<Operation> opList = new ArrayList<Operation>();
		Stereotype st = null;
		Port pt = null;
		Interface myIf = null;

		for (int i=0; i < cTypeList.size(); i++) {
			List<Property> pList = cTypeList.get(i).getOwnedAttributes();

			for (int j=0; j < pList.size(); j++) {
				if (pList.get(j) instanceof Port) {
					pt = (Port) pList.get(j);
					st = pt.getAppliedStereotype(stName);
					ClientServerPort csp = (ClientServerPort) pt.getStereotypeApplication(st);
					if (csp == null) //flow-port case
						continue;
					if (csp.getKind().equals(ClientServerKind.PROVIDED)) {
						myIf = csp.getProvInterface().get(0);
						List<Operation> ifOpList = myIf.getOwnedOperations();
						for (int k=0; k < ifOpList.size(); k++) {
							opList.add(ifOpList.get(k));
						}
					}
				}
			}
		}

		return opList;
	}

	/**
	 * Gets the remote required slot list.
	 *
	 * @param riSlotList the required slot list
	 * @param procNode the processing node
	 * @param connectorInstList the connector instance list
	 * @param commList the list of comments
	 * @param assignStName the assign stereotype name
	 * @return the remote required slot list
	 */
	public List<Slot> getRemoteRIslotList(List<Slot> riSlotList, InstanceSpecification procNode, 
			List<InstanceSpecification> connectorInstList, List<Comment> commList, 
			String assignStName) {

		ArrayList<Slot> remoteRIslotList = new ArrayList<Slot>();
		Slot boundSlot = null;

		for (int i=0; i<riSlotList.size(); i++) {
			boundSlot = getBoundPIslot(riSlotList.get(i), connectorInstList);
			if (! getDeploymentProcessingNode(boundSlot, commList, assignStName).equals(procNode)) {

				if (! remoteRIslotList.contains(boundSlot)) {
					remoteRIslotList.add(boundSlot);
				}
			}
		}

		return remoteRIslotList;
	}

	/**
	 * Checks if remote msg client is necessary.
	 *
	 * @param riSlotList the required slot list
	 * @param procNode the processing node
	 * @param connectorInstList the connector instance list
	 * @param commList the list of comments
	 * @param assignStName the assign stereotype name
	 * @return true if remote msg client is necessary, false otherwise
	 */
	public Boolean isRemoteMsgClientNecessary(List<Slot> riSlotList, InstanceSpecification procNode, 
			List<InstanceSpecification> connectorInstList, List<Comment> commList, String assignStName) {

		Slot boundSlot = null;
		for (int i = 0; i < riSlotList.size(); i++) {
			boundSlot = getBoundPIslot(riSlotList.get(i), connectorInstList);
			if (!getDeploymentProcessingNode(boundSlot, commList, assignStName).equals(procNode)) {
				return true;
			}
		}
		// all RI slots are connected to PI of instances deployed on the same processor node

		return false;
	}


	/**
	 * Checks if remote msg server is necessary.
	 * 
	 * @param slList the slot list
	 * @param procNode the processing node
	 * @param connectorInstList the connector instance list
	 * @param commList the list of comments
	 * @param stName the  stereotype name
	 * @return true if remote msg server is necessary, false otherwise
	 */
	public Boolean isRemoteMsgServerNecessary (List<Slot> slList, InstanceSpecification procNode,
			List<InstanceSpecification> connectorInstList, List<Comment> commList, String stName) {

		List<Slot> boundSlotList = null;

		for (int i=0; i < slList.size(); i++) {

			boundSlotList = getBoundRIslotList(slList.get(i), connectorInstList);

			for (int j=0; j < boundSlotList.size(); j++) {
				if (! this.getDeploymentProcessingNode(boundSlotList.get(j), commList, stName).equals(procNode)){
					return true;
				}
			}
		}

		return false;
	}


	/**
	 * Check whether to use sequence id.
	 *
	 * @param sl the slot
	 * @param connectorInstList the list of connector instances
	 * @param connectorList the list of connectors
	 * @param stName the stereotype name
	 * @return true if sequence id is used, false otherwise
	 */
	public Boolean useSequenceID(Slot sl, List<InstanceSpecification> connectorInstList, 
			List<Connector> connectorList, String stName) {

		// Check that definingFeature and owningInstance of the slot are matching

		for (int i=0; i<connectorInstList.size(); i++) {
			List<Slot> slotList = connectorInstList.get(i).getSlots();

			// 2 slots are included in the instance of the connector.
			Slot slot0 = slotList.get(0);
			Slot slot1 = slotList.get(1);

			if (slot0.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot0.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					return isTransmissionWithSequenceID(slot0, slot1, connectorList, stName);

				}
			} else if (slot1.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot1.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					return isTransmissionWithSequenceID(slot0, slot1, connectorList, stName);
				}
			}
		}
		return false;	   
	}

	/**
	 * Checks if the connector has transmission with sequence id.
	 *
	 * @param slot0 the first slot
	 * @param slot1 the second slot
	 * @param connectorList the list of connectors
	 * @param stName the stereotype name
	 * @return true if the connector has transmission with sequence id, false otherwise
	 */
	public Boolean isTransmissionWithSequenceID(Slot slot0, Slot slot1, List<Connector> connectorList, String stName) {
		// assessing whether the connector has a "TransmissionWithProtocol" stereotype on it

		List<ConnectorEnd> ctEndList = null;

		for (int i=0; i < connectorList.size(); i++) {
			ctEndList = connectorList.get(i).getEnds();
			ConnectorEnd ce0 = ctEndList.get(0);
			ConnectorEnd ce1 = ctEndList.get(1);

			if ((ce0.getRole().equals(slot0.getDefiningFeature()) || ce1.getRole().equals(slot0.getDefiningFeature())) 
					&&
					(ce0.getRole().equals(slot1.getDefiningFeature()) || ce1.getRole().equals(slot1.getDefiningFeature()))) {

				Stereotype st = connectorList.get(i).getAppliedStereotype(stName);
				if (st == null) {
					return false;
				} else {
					TransmissionWithProtocol twp = (TransmissionWithProtocol) connectorList.get(i).getStereotypeApplication(st);
					return twp.isUseSeqID();
				}
			}
		}
		return false;
	}

	/**
	 * Gets the CRC library.
	 *
	 * @param sl the slot
	 * @param connectorInstList the list of connector instances
	 * @param connectorList the list of connectors
	 * @param stName the stereotype name
	 * @return the CRC library
	 */
	public String getCRClib(Slot sl, List<InstanceSpecification> connectorInstList, 
			List<Connector> connectorList, String stName) {

		// Check that definingFeature and owningInstance of the slot are matching

		for (int i=0; i<connectorInstList.size(); i++) {
			List<Slot> slotList = connectorInstList.get(i).getSlots();

			// 2 slots are included in the instance of the connector.
			Slot slot0 = slotList.get(0);
			Slot slot1 = slotList.get(1);

			if (slot0.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot0.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					return getTransmissionWithCRC(slot0, slot1, connectorList, stName);

				}
			} else if (slot1.getDefiningFeature().equals(sl.getDefiningFeature())) {
				List<ValueSpecification> vsList = slot1.getValues();
				InstanceValue iv = (InstanceValue) vsList.get(0);
				if (sl.getOwningInstance().equals(iv.getInstance())) {
					return getTransmissionWithCRC(slot0, slot1, connectorList, stName);
				}
			}
		}
		return "";	   
	}

	/**
	 * Gets the transmission with CRC.
	 *
	 * @param slot0 the first slot
	 * @param slot1 the second slot
	 * @param connectorList the list of connectors
	 * @param stName the stereotype name
	 * @return the transmission with CRC
	 */
	public String getTransmissionWithCRC(Slot slot0, Slot slot1, List<Connector> connectorList, String stName) {
		// assessing whether the connector has a "TransmissionWithProtocol" stereotype on it

		List<ConnectorEnd> ctEndList = null;

		for (int i=0; i < connectorList.size(); i++) {
			ctEndList = connectorList.get(i).getEnds();
			ConnectorEnd ce0 = ctEndList.get(0);
			ConnectorEnd ce1 = ctEndList.get(1);

			if ((ce0.getRole().equals(slot0.getDefiningFeature()) || ce1.getRole().equals(slot0.getDefiningFeature())) 
					&&
					(ce0.getRole().equals(slot1.getDefiningFeature()) || ce1.getRole().equals(slot1.getDefiningFeature()))) {

				Stereotype st = connectorList.get(i).getAppliedStereotype(stName);
				if (st == null) {
					return "";
				} else {
					TransmissionWithProtocol twp = (TransmissionWithProtocol) connectorList.get(i).getStereotypeApplication(st);
					return twp.getCRC();
				}
			}
		}
		return "";
	}

	/**
	 * Gets the Papyrus documentation of an element
	 *
	 * @param elem the Element
	 * @return the documentation as a String
	 */
	public String getDocumentation(NamedElement elem){
		String docString = "";
		EList<Comment> comments = elem.getOwnedComments();
		for (Comment comment : comments) {
			Stereotype documentation = comment.getAppliedStereotype(DOCSTEREO);
			if(documentation != null){
				docString =  comment.getBody();
			}
		}	
		String commented = "";
		Scanner scanner = new Scanner(docString);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			commented += ("-- " + line + System.getProperty("line.separator"));
		}
		scanner.close();
		return commented;		
	}

	/**
	 * Gets the tuple attributes of a MARTE's TupleType stereotype.
	 *
	 * @param dt the data type
	 * @param stereo the stereotype (TupleType)
	 * @return the list of proerties that are the tuple attributes
	 */
	public List<Property> getTupleAttributes(DataType dt, Stereotype stereo){
		TupleType tuple = (TupleType) dt.getStereotypeApplication(stereo);
		return tuple.getTupleAttrib() ;
	}

	/**
	 * checks if the operation generates a function in Ada.
	 * it's a function if there's one and only one parameter with direction "return"
	 *
	 * @param op the operation
	 * @return true if it's a function, false otherwise (it is a procedure)
	 */
	public Boolean isFunction(Operation op){
		Boolean res = false;
		int retCount = 0;
		for (Parameter par : op.getOwnedParameters()) {
			if(par.getDirection().toString().equals("return")){
				retCount++;
			}
		}
		if(retCount == 1){ 
			res = true;
		}
		return res;
	}

	/**
	 * Gets the return parameter of a given operation.
	 * The given operation must be a function (@see UML2Service.isFunction).
	 *
	 * @param op the given Operation
	 * @return the return parameter of the operation
	 */
	public Parameter getReturnParam(Operation op){
		Parameter param = null;
		for (Parameter par : op.getOwnedParameters()) {
			if(par.getDirection().toString().equals("return")) param = par;
		}
		return param;
	}
}
