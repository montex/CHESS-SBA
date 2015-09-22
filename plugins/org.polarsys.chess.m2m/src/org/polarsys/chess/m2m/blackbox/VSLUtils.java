/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
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

package org.polarsys.chess.m2m.blackbox;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.validator.constraints.StringParser;


/**
 * MARTE VSL utility class for QVT-o transformation.
 */
public class VSLUtils {

	/**
	 * returns the 'pattern' data (MARTE).
	 * 
	 * <p>
	 * i.e. periodic(period=(value=0.6,unit=ms))
	 *
	 * @param context the QVT context
	 * @param self the VSL string to be analyzed
	 * @return the 'pattern' data, or null if no data was found
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static String getArrivalPatternType(IContext context, String self) {
		String regex = "(\\w*)\\s*\\((.*)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(self);
		if (matcher.find())
			return matcher.group(1).trim();
		context.getLog().log("No ArrivalPattern detected");
		return null;

	}// end parseArrivalPattern

	/**
	 * Checks if is real number.
	 *
	 * @param n the string to be parsed
	 * @return true, if is real number
	 */
	private static boolean isRealNumber(String n) {
		try {
			Double.parseDouble(n);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * VSL parsing: receives an NFP_Integer value and parses the selected
	 * property
	 * 
	 * <p>
	 * i.e. (value=6)
	 *
	 * @param context the context
	 * @param self the self
	 * @return the parsed value of the property
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static String normalizeNFPInteger(IContext context, String self) {

		if (self == null)
			return "(value = 0)";
		// If it is a shorthand notation, just the number (e.g. "1")
		try {
			return "(value = " + Integer.valueOf(self).toString() + ")";
		} catch (Exception e) {
			// continue with normal parsing
		}
		self = parseGetFirstValidVSL(self);
		if (self == null) {
			return "(value = 0)";
		}

		String regex = "\\(([^\\(\\)]*)\\)"; // same example -> 1:
												// value=2,statQ=min | 2:
												// value=3,statQ=max
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(self);

		if (!matcher.find()) {
			return "MALFORMED INPUT";
		}

		return "(value = " + parseInteger(matcher.group(1), "value") + ")";
	}

	/**
	 * Some properties can store multiple values. This method returns the fist
	 * valid one, in our case: the one with no statQ=calc
	 * 
	 * @param inputText
	 *            text to check
	 * 
	 * @return the first valid VSL expression
	 */
	private static String parseGetFirstValidVSL(String inputText) {
		// e.g. [ (statQ=calc) , ( value =2.0 ), (value= 3.8,statq=calc)] -> (
		// value =2.0 )

		Vector<String> splittedText = new Vector<String>();
		String outText = null;
		if (inputText == null) {
			return null;
		}
		// SPLIT
		String regex = "(\\(.*?\\))"; // ? -> non greedy
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputText);
		while (matcher.find()) {
			if (matcher.groupCount() > 0) {
				splittedText.add(matcher.group(1));
			}
		}
		// SELECT FIRST VALID
		if (splittedText == null || splittedText.size() == 0) {
			return null;
		}
		// check if there is one with no statQ=calc
		for (int i = 0; i < splittedText.size(); i++) {
			String inText = splittedText.get(i);
			String regexStatQ = "statQ\\s*=\\s*calc"; // ? -> non greedy
			pattern = Pattern.compile(regexStatQ);
			matcher = pattern.matcher(inText);
			if (!matcher.find()) {
				return inText;
			}
		}// no? -> then, take the first one with statQ=calc
		for (int i = 0; i < splittedText.size(); i++) {
			String inText = splittedText.get(i);
			String regexStatQ = "statQ\\s*=\\s*calc"; // ? -> non greedy
			pattern = Pattern.compile(regexStatQ);
			matcher = pattern.matcher(inText);
			if (matcher.find()) {
				return inText;
			}
		}
		// END
		splittedText.clear();
		return outText;
	}// parseGetFirstValidVSL

	/**
	 * VSL parsing: utility function used by parse_NFPInteger
	 * 
	 * <p>
	 * i.e. [0..34[
	 * 
	 * @param propertiesText
	 *            VSL formatted input string
	 * 
	 * @param propertyName
	 *            "value", "source", "statQ" ...
	 * 
	 * @return the parsed value of the property
	 */
	private static String parseInteger(String propertiesText,
			String propertyName) {

		if (propertiesText == null)
			return "MALFORMED INPUT";

		String regex; // example: value=2,statQ=min
		Pattern pattern;
		Matcher matcher;

		if (propertyName.equals("value")) {

			regex = "\\s*" + propertyName + "\\s*=\\s*(\\d+)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);

			if (!matcher.find()) {
				return "MALFORMED INPUT";
			}

			return matcher.group(1);

		} else if (propertyName.equals("source")) {

			regex = "\\s*source\\s*=\\s*(est|meas|calc|req)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);

			// if(matcher.groupCount()<2)return "NOT FOUND";
			if (!matcher.find()) {
				return "MALFORMED INPUT";
			}

			return matcher.group(1);

		} else if (propertyName.equals("statQ")) {

			regex = "\\s*statQ\\s*=\\s*(min|max)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);

			// if(matcher.groupCount()<2)return "NOT FOUND";
			if (!matcher.find()) {
				return "MALFORMED INPUT";
			}

			return matcher.group(1);

		} else {
			return "NOT IMPLEMENTED";
		}
	}

	/**
	 * VSL parsing: receives an NFP_Duration value and parses the property
	 * selected
	 * 
	 * <p>
	 * i.e. (value=0.6,unit=ms)
	 *
	 * @param context the context
	 * @param self            VSL formatted input string
	 * @param propertyName            property whose value we want
	 * @return the parsed value of the property
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static String parseNFPDuration(IContext context, String self,
			String propertyName) {

		if (self == null)
			return "MALFORMED INPUT";
		self = parseGetFirstValidVSL(self);
		if (self == null) {
			return "MALFORMED INPUT";
		}

		String regex = "\\((.*)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(self);
		if (!matcher.find()) {
			context.getLog().log("WARNING: can't parse NFP_Duration ");
			return "MALFORMED INPUT";
		}
		String propertiesText = matcher.group(1);

		if (propertyName.equals("source")) {

			regex = "\\s*source\\s*=\\s*([est|meas|calc|req])";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);

			// if(matcher.groupCount()<2)return "NOT FOUND";
			if (!matcher.find()) {
				context.getLog()
						.log("WARNING: NFP_Duration doesn't have a valid value for \"source\" ");
				return "MALFORMED INPUT";
			}

			return matcher.group(1);

		} else if (propertyName.equals("value") || propertyName.equals("best")
				|| propertyName.equals("worst")) {

			// Extract Value
			String theValue, theUnit;
			regex = "\\s*" + propertyName + "\\s*=\\s*(\\d+\\.*\\d*)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);

			// if(matcher.groupCount()<2)return "NOT FOUND";
			if (!matcher.find()) {
				context.getLog().log("WARNING: can't parse NFP_Duration ");
				return "MALFORMED INPUT";
			}

			theValue = matcher.group(1);

			// MAST needs a real value not an integer (if the VSL is correct it
			// should be a real anyway,
			// but I check in case it isn't correctly formed)
			regex = "\\s*" + propertyName + "\\s*=\\s*(\\d+\\.+\\d+)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);
			if (!matcher.find()) {
				theValue += ".0";
			}

			// Extract Units
			regex = "\\s*unit\\s*=\\s*(\\w+)";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(propertiesText);
			if (matcher.find()) {
				theUnit = matcher.group(1);
			} else {
				theUnit = "s";
			}

			if (theUnit.equals("s")) {
				return theValue;
			} else if (theUnit.equals("ms")) {
				return theValue + "E-3";
			} else if (theUnit.equals("us")) {
				return theValue + "E-6";
			} else if (theUnit.equals("ns")) {
				return theValue + "E-9";
			}

			context.getLog().log("WARNING: can't parse NFP_Duration ");
			return "MALFORMED INPUT";

		} else {
			context.getLog().log("WARNING: can't parse NFP_Duration ");
			return "NOT IMPLEMENTED";
		}

	}// end parseNFP_Duration

	/**
	 * Parses the nfp real.
	 *
	 * @param context the context
	 * @param self the self
	 * @param propertyName the property name
	 * @return the string
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static String parseNFPReal(IContext context, String self,
			String propertyName) {

		if (self == null) {
			return "MALFORMED INPUT";
		}
		// If it is a shorthand notation, just the number (e.g. "1.0")
		try {
			return Double.valueOf(self).toString();
		} catch (Exception e) {
			// continue with normal parsing
		}

		self = parseGetFirstValidVSL(self);
		if (self == null) {
			return "MALFORMED INPUT";
		}

		String regex = "\\((.*)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(self);
		if (!matcher.find()) {
			return "MALFORMED INPUT";
		}

		if (matcher.groupCount() < 1)
			return "";

		String propertiesText = matcher.group(1);

		regex = "\\s*" + propertyName + "\\s*=\\s*(\\d+\\.*\\d*)";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(propertiesText);

		if (!matcher.find()) {
			return "MALFORMED INPUT";
		}

		return matcher.group(1);

	}// end parseNFP_Real

	/**
	 * Sets the ceiling.
	 *
	 * @param context the context
	 * @param self the self
	 * @param ceiling the ceiling
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setCeiling(IContext context,
			org.eclipse.uml2.uml.Class self, String ceiling) {
		if (ceiling == null)
			return;
		if (ceiling.isEmpty())
			return;
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof SaSharedResource) {
				SaSharedResource s = (SaSharedResource) e;

				if (!isRealNumber(ceiling))
					ceiling = parseNFPReal(context, ceiling, "value");
				s.setCeiling(ceiling);
			}
			// else if (e instanceof SwMutualExclusionResource){
			// SwMutualExclusionResource s = (SwMutualExclusionResource) e;
			// if (isRealNumber(ceiling))
			// ceiling = "(value = "+ ceiling +" , source = req)";
			// else
			// ceiling = "(value = "+ parseNFPReal(context, ceiling, "value")
			// +" , source = req)";
			// s.setCeiling(ceiling);
			// }
		}
	}

	/**
	 * Sets the ceiling2.
	 *
	 * @param context the context
	 * @param self the self
	 * @param ceiling the ceiling
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setCeiling2(IContext context,
			org.eclipse.uml2.uml.Class self, String ceiling) {
		if (ceiling == null)
			return;
		if (ceiling.isEmpty())
			return;
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof SwMutualExclusionResource) {
				SwMutualExclusionResource s = (SwMutualExclusionResource) e;
				if (!isRealNumber(ceiling))
					ceiling = parseNFPReal(context, ceiling, "value");
				s.setCeiling(ceiling);
			}
		}
	}

	/**
	 * Sets the ceiling3.
	 *
	 * @param context the context
	 * @param self the self
	 * @param ceiling the ceiling
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setCeiling3(IContext context,
			org.eclipse.uml2.uml.Class self, String ceiling) {
		if (ceiling == null)
			return;
		if (ceiling.isEmpty())
			return;
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof MutualExclusionResource) {
				MutualExclusionResource s = (MutualExclusionResource) e;

				if (!isRealNumber(ceiling))	
					ceiling =parseNFPReal(context, ceiling, "value");
				s.setCeiling(ceiling);
			}
		}
	}

	/**
	 * Sets the protect kind.
	 *
	 * @param context the context
	 * @param self the self
	 * @param type the type
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setProtectKind(IContext context,
			org.eclipse.uml2.uml.Class self, String type) {
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof SaSharedResource) {
				SaSharedResource s = (SaSharedResource) e;
				ProtectProtocolKind a = ProtectProtocolKind.getByName(type);
				s.setProtectKind(a);
			}
			// else if (e instanceof SwMutualExclusionResource){
			// SwMutualExclusionResource s = (SwMutualExclusionResource) e;
			// ProtectProtocolKind a = ProtectProtocolKind.getByName(type);
			// s.setProtectKind(a);
			// }
		}

	}

	/**
	 * Sets the protect kind2.
	 *
	 * @param context the context
	 * @param self the self
	 * @param type the type
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setProtectKind2(IContext context,
			org.eclipse.uml2.uml.Class self, String type) {
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof SwMutualExclusionResource) {
				SwMutualExclusionResource s = (SwMutualExclusionResource) e;
				ProtectProtocolKind a = ProtectProtocolKind.getByName(type);
				s.setProtectKind(a);
			}
		}
	}

	/**
	 * Sets the protect kind3.
	 *
	 * @param context the context
	 * @param self the self
	 * @param type the type
	 */
	@Operation(kind = Kind.OPERATION, contextual = true, withExecutionContext = true)
	public static void setProtectKind3(IContext context,
			org.eclipse.uml2.uml.Class self, String type) {
		for (EObject e : self.getStereotypeApplications()) {
			if (e instanceof MutualExclusionResource) {
				MutualExclusionResource s = (MutualExclusionResource) e;
				ProtectProtocolKind a = ProtectProtocolKind.getByName(type);
				s.setProtectKind(a);
			}
		}
	}

	/**
	 * Port to slots by rule.
	 *
	 * @param context the context
	 * @param self the self
	 * @param onPort the on port
	 * @param rule the rule
	 * @return the e list
	 */
	@Deprecated	
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static EList<Slot> portToSlotsByRule(IContext context,
			org.eclipse.uml2.uml.InstanceSpecification self, org.eclipse.uml2.uml.Port onPort, org.eclipse.uml2.uml.Constraint rule) {
		EList<Slot> list = new BasicEList<Slot>();
		/*
		String values[] = rule.getSpecification().stringValue().trim().split(" ");
		ArrayList<int[]> boundsList = new ArrayList<int[]>();
		for (String value : values) {
			boundsList.add(getBounds(value));
		}
		
		for (Slot slot : self.getSlots()) {
			IdentifSlot id = getStereotypeApplication(slot, IdentifSlot.class);
			
			if (id != null && slot.getDefiningFeature() == onPort && isInBounds(id.getId(), boundsList)) {
				list.add(slot);
			}
			else if (slot.getDefiningFeature() == onPort) {
				list.add(slot);
			}
		}*/
		
		return list;
	}
	
	/**
	 * Gets the slot instances.
	 *
	 * @param context the context
	 * @param self the self
	 * @param inst the inst
	 * @param instFull the inst full
	 * @return the slot instances
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static EList<Slot> getSlotInstances(IContext context,
			org.eclipse.uml2.uml.Comment self,
			org.eclipse.uml2.uml.Package inst) {
		EList<Slot> list = new BasicEList<Slot>();

		Assign ass = getStereotypeApplication(self, Assign.class);
		Slot slotInst = extractFirstSlot(ass.getFrom());
		
		if (slotInst == null)
			return list;

		InstanceSpecification originatingInst = slotInst.getOwningInstance();

		if (!inst.allOwnedElements().contains(slotInst))
			return list;

		EList<Element> asslist = ass.getFrom();
		for (Element elem : asslist){
			list.add((Slot) elem);
		}
		
		return list;
		
		/*
		int[] bounds = getBounds(self);

		if (bounds != null) {
			for (Element el : instFull.allOwnedElements()) {

				IdentifInstance id = getStereotypeApplication(el,
						IdentifInstance.class);

				if (!(el instanceof InstanceSpecification && id != null))
					continue;
				InstanceSpecification y = (InstanceSpecification) el;

				if (isInBounds(id.getId(), bounds)
						&& id.getSourceInstanceSpec() == originatingInst) {

					Slot x = slotFromInstance(slotInst, y);
					if (x != null)
						list.add(x);
				}

			}
		} else {
			for (Element el : instFull.allOwnedElements()) {
				IdentifInstance id = getStereotypeApplication(el,
						IdentifInstance.class);

				if (!(el instanceof InstanceSpecification && id != null && id
						.getSourceInstanceSpec() == originatingInst))
					continue;
				InstanceSpecification y = (InstanceSpecification) el;

				Slot x = slotFromInstance(slotInst, y);
				if (x != null)
					list.add(x);
			}
		}
		return list;
		*/
	}

	/**
	 * Slot from instance.
	 *
	 * @param slotInst the slot inst
	 * @param el the el
	 * @return the slot
	 */
	private static Slot slotFromInstance(Slot slotInst,
			InstanceSpecification el) {
		for (Element e : el.getOwnedElements()) {
			if (!(e instanceof Slot)) continue;
			Slot slot = (Slot) e;
			if(slot.getDefiningFeature().equals(slotInst.getDefiningFeature())){
				return (Slot) e;
			}
		}
		return null;
	}
	
	/**
	 * Gets the instances.
	 *
	 * @param context the context
	 * @param self the self
	 * @param inst the inst
	 * @param instFull the inst full
	 * @return the instances
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static EList<InstanceSpecification> getInstances(IContext context,
			org.eclipse.uml2.uml.Comment self,
			org.eclipse.uml2.uml.Package inst) {
		EList<InstanceSpecification> list = new BasicEList<InstanceSpecification>();

		Assign ass = getStereotypeApplication(self, Assign.class);
		InstanceSpecification originatingInst = extractFirstInstance(ass.getFrom());
		
		if (originatingInst == null)
			return list;
		
//		if (!inst.allOwnedElements().contains(originatingInst))
//			return list;
		
		EList<Element> asslist = ass.getFrom();
		for (Element elem : asslist){
			list.add((InstanceSpecification) elem);
		}
		
		
		return list;
		
		/*
		int[] bounds = getBounds(self);
		
		if (bounds != null)
			for (Element el : instFull.allOwnedElements()) {
				
				IdentifInstance id = getStereotypeApplication(el,
						IdentifInstance.class);
				
				if (el instanceof InstanceSpecification && id != null) {
					if (isInBounds(id.getId(), bounds))
//							&& id.getSourceInstanceSpec() == originatingInst)
						list.add((InstanceSpecification) el);
				}
			}
		else
			for (Element el : instFull.allOwnedElements()) {
				IdentifInstance id = getStereotypeApplication(el,
						IdentifInstance.class);
				if (el instanceof InstanceSpecification && id != null){
//						&& id.getSourceInstanceSpec() == originatingInst) {
					list.add((InstanceSpecification) el);
				}
			}

		return list;*/
	}

//	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
//	public static EList<InstanceSpecification> getInstances(IContext context,
//			org.eclipse.uml2.uml.Comment self) {
//		EList<InstanceSpecification> list = new BasicEList<InstanceSpecification>();
//		if (!self.getAnnotatedElements().isEmpty()) {
//			// TODO assumption: one and only nfpConstrant
//			Constraint a = getNfpConstraint(self.getAnnotatedElements());
//			System.out.println(a.getSpecification().stringValue());
//		}
//
//		return list;
//	}
	
	/**
 * Extract first slot.
 *
 * @param from the from
 * @return the slot
 */
private static Slot extractFirstSlot(EList<Element> from) {
		for (Element element : from) {
			if (element instanceof Slot) {
				Slot sl = (Slot) element;
				return sl;
			}
		}
		return null;
	}
	
	/**
	 * Extract first instance.
	 *
	 * @param from the from
	 * @return the instance specification
	 */
	private static InstanceSpecification extractFirstInstance(EList<Element> from) {
		for (Element element : from) {
			if (element instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification) element;
				return is;
			}
		}
		return null;
	}

	/**
	 * Checks if is referring id.
	 *
	 * @param context the context
	 * @param self the self
	 * @param id the id
	 * @return the boolean
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public static Boolean isReferringId(IContext context,
			org.eclipse.uml2.uml.Comment self, Integer id) {
		
		int[] bounds = getBounds(self);
		
		//if there are no bounds the comment refers to all the instance ids
		if (bounds == null)
			return true;
		
		return isInBounds(id, bounds);
	}

	/**
	 * Checks if is in bounds.
	 *
	 * @param id the id
	 * @param bounds the bounds
	 * @return the boolean
	 */
	private static Boolean isInBounds(int id, int[] bounds) {
		return id >= bounds[0] && id <= bounds[1];
	}
	
	/**
	 * Checks if is in bounds.
	 *
	 * @param id the id
	 * @param bounds the bounds
	 * @return the boolean
	 */
	private static Boolean isInBounds(int id, java.util.List<int[]> bounds) {
		for (int[] b : bounds) {
			if (isInBounds(id, b))
				return true;
		}
		return false;
	}
	
	/**
	 * Gets the bounds.
	 *
	 * @param comment the comment
	 * @return the bounds
	 */
	private static int[] getBounds(Comment comment) {
		if (!comment.getAnnotatedElements().isEmpty()) {
			// TODO assumption: one and only nfpConstrant
			Constraint a = getNfpConstraint(comment.getAnnotatedElements());
			
			String value = a.getSpecification().stringValue();

			return getBounds(value);
			
		}

		return null;
	}

	//match all variants of "    [  1   ..   10   ]   " result: [1, 10]
	//match all variants of "    [  1   ]   		  " result: [1, 1]
	//match all variants of "      10   			  " result: [10, 10]
	/**
	 * Gets the bounds.
	 *
	 * @param value the value
	 * @return the bounds
	 */
	private static int[] getBounds(String value) {
		String regex = "\\s*\\[\\s*(\\d+)\\s*\\.*\\s*(\\d+)\\]\\s*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		int[] b = new int[2];

		if (matcher.find() && matcher.groupCount() == 2) {
			String begin_ = matcher.group(1);
			String end_ = matcher.group(2);
			b[0] = Integer.parseInt(begin_);
			b[1] = Integer.parseInt(end_);
			return b;
		}
		
		regex = "\\s*\\[\\s*(\\d+)\\s*\\]\\s*";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value);
		if (matcher.find() && matcher.groupCount() == 1) {
			String begin_ = matcher.group(1);
			b[0] = Integer.parseInt(begin_);
			b[1] = b[0];
			return b;
		}
		
		regex = "\\s*(\\d+)\\s*";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value);
		if (matcher.find() && matcher.groupCount() == 1) {
			String begin_ = matcher.group(1);
			b[0] = Integer.parseInt(begin_);
			b[1] = b[0];
			return b;
		}
		
		return null;
	}

	/**
	 * Gets the nfp constraint.
	 *
	 * @param list the list
	 * @return the nfp constraint
	 */
	private static Constraint getNfpConstraint(EList<Element> list) {
		for (Element element : list) {
			if (element instanceof Constraint) {
				if (getStereotypeApplication(element, NfpConstraint.class) != null)
					return (Constraint) element;
			}
		}
		return null;
	}
	
	/**
	 * Gets the wcet.
	 *
	 * @param context the context
	 * @param self the self
	 * @return the wcet
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static String getWCET(IContext context, Comment self) {
		CHRtSpecification chRtSpecification = getStereotypeApplication(self, CHRtSpecification.class);
		StringParser sp = new StringParser();
		double x = -1;
		String wcet = chRtSpecification.getLocalWCET();
		if(wcet!=null){
			x = sp.getValueNFP(wcet);
		}
		if(x != -1)
			return wcet;
		
		wcet = chRtSpecification.getWCET();
		
		if(wcet!=null){
			x = sp.getValueNFP(wcet);
		}
		if(x != -1)
			return wcet;
		return "ERROR!";
	}

	/**
	 * Gets the stereotype application.
	 *
	 * @param <T> the generic type
	 * @param element the element
	 * @param stereotypeClass the stereotype class
	 * @return the stereotype application
	 */
	@SuppressWarnings("unchecked")
	private static <T extends EObject> T getStereotypeApplication(
			Element element, Class<T> stereotypeClass) {
		for (EObject stereoApplication : element.getStereotypeApplications()) {
			if (stereotypeClass.isInstance(stereoApplication)) {
				return (T) stereoApplication;
			}
		}
		return null;
	}
	
	/**
	 * Gets the number of cores for a given CPU instance
	 *
	 * @param context the QVT context
	 * @param cpu the cpu instance
	 * @return the number of cores
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static Integer getNumberOfCores(IContext context, InstanceSpecification cpu) {
		Integer i = 1;
		CH_HwProcessor x = getStereotypeApplication(cpu, CH_HwProcessor.class);
		if(x == null || x.getNbCores() == null)
			return i;

		try {
			i = Integer.parseInt(x.getNbCores());
		} catch (NumberFormatException e) {
			//let it be 1...
		}
		return i;
	}
	
	
	/**
	 * Gets the core (as String) constraining the given <<Assign>> Comment.
	 *
	 * @param context the QVT context
	 * @param self the <<Assign>> Comment
	 * @return the core (as String)
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static String getCoreFromContraint(IContext context, Comment self) {
		try {
			Assign assign = getStereotypeApplication(self, Assign.class);
			for (NfpConstraint nfpc : assign.getImpliedConstraint()) {
				Constraint cc = nfpc.getBase_Constraint();
				ValueSpecification spec = cc.getSpecification();
				if(spec.getName().equalsIgnoreCase("core")){
					LiteralString value = (LiteralString) spec;
					return value.getValue();
				}
			}
		} catch (Exception e) {
			//TODO ugly piece of code I know....
		}
		return null;
	}
	
	/**
	 * Gets the context from constraint.
	 *
	 * @param context the context
	 * @param self the self
	 * @return the context from constraint
	 */
	@Operation(kind = Kind.HELPER, contextual = true, withExecutionContext = true)
	public  static String getContextFromContraint(IContext context, Comment self) {
		try {
			Assign assign = getStereotypeApplication(self, Assign.class);
			for (NfpConstraint nfpc : assign.getImpliedConstraint()) {
				Constraint cc = nfpc.getBase_Constraint();
				ValueSpecification spec = cc.getSpecification();
				if(spec.getName().equalsIgnoreCase("context")){
					LiteralString value = (LiteralString) spec;
					return value.getValue();
				}
			}
		} catch (Exception e) {
			//TODO ugly piece of code I know....
		}
		return null;
	}
}