package org.polarsys.chess.OSSImporter.utils;

import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeUtil {

//	private static final String INTEGER_TYPE =			"PrimitiveTypes::Integer";
//	private static final String REAL_TYPE =				"PrimitiveTypes::Real";	
//	private static final String BOOLEAN_TYPE =			"PrimitiveTypes::Boolean";
	
	public static final String CONTRACT =				"CHESSContract::Contract";
	public static final String CONTRACT_PROP =			"CHESSContract::ContractProperty";
	public static final String DELEGATION_CONST =		"CHESSContract::DelegationConstraint";
	public static final String CONTRACT_REFINEMENT =	"CHESSContract::ContractRefinement";
	public static final String SYSTEM =					"CHESSContract::System";
//	private static final String SUBSYSTEM = 			"CHESSContract::SubSystem";
//	private static final String COMPINST =				"CHESSContract::ComponentInstance";
//	private static final String FORMAL_PROP =			"CHESSContract::FormalProperty";
//	private static final String CHESS_CONTINUOUS_TYPE = "CHESSContract::DataTypes::Continuous";

//	private static final String SYSVIEW =				"CHESS::Core::CHESSViews::SystemView";
//	private static final String COMPVIEW =				"CHESS::Core::CHESSViews::ComponentView";
//	private static final String CHESS =					"CHESS::Core::CHESS";
	
	public static final String BLOCK =					"SysML::Blocks::Block";
	public static final String FLOWPORT =				"SysML::PortAndFlows::FlowPort";
	
	public static final String BOUNDED_TYPE = 			"MARTE::MARTE_Annexes::VSL::DataTypes::BoundedSubtype";
//	public static final String COLLECTIONTYPE = 		"MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType";
//	private static final String MARTE_BOOLEAN_TYPE = 	"MARTE_Library::MARTE_PrimitivesTypes::Boolean";
//	private static final String MARTE_REAL_TYPE = 		"MARTE_Library::MARTE_PrimitivesTypes::Real";
//	private static final String MARTE_INTEGER_TYPE = 	"MARTE_Library::MARTE_PrimitivesTypes::Integer";
	
	public static final String ENUMERATION_NAME = 		"Enumeration";
	public static final String SIGNAL_NAME = 			"Signal";
	
	
	
	
	 private static StereotypeUtil stereotypeUtil =
			 StereotypeUtil.getInstance();

			public static StereotypeUtil getInstance() {
				if (stereotypeUtil == null) {
					stereotypeUtil = new StereotypeUtil();
				}
				return stereotypeUtil;
			}
	
	
	
	
	
	// Stereotype objects needed to customize the elements
		public Stereotype contractPropertyStereotype;
		public Stereotype delegationConstraintStereotype;
		public Stereotype contractRefinementStereotype;
		public Stereotype flowPortStereotype;
		public Stereotype contractStereotype;
		public Stereotype boundedTypeStereotype;
		public Stereotype blockStereotype;
		public Stereotype systemStereotype;
	
		
		
		
		
	/**
	 * Collects the needed stereotypes from the given package.
	 * @param pkg the package in which to look for the stereotypes
	 */
	public void refreshStereotypes(Package pkg) {
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT_PROP)) {
			if (sub.getQualifiedName().equals(CONTRACT_PROP)) {
				contractPropertyStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, DELEGATION_CONST)) {
			if (sub.getQualifiedName().equals(DELEGATION_CONST)) {
				delegationConstraintStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT_REFINEMENT)) {
			if (sub.getQualifiedName().equals(CONTRACT_REFINEMENT)) {
				contractRefinementStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, BOUNDED_TYPE)) {
			if (sub.getQualifiedName().equals(BOUNDED_TYPE)) {
				boundedTypeStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, FLOWPORT)) {
			if (sub.getQualifiedName().equals(FLOWPORT)) {
				flowPortStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, BLOCK)) {
			if (sub.getQualifiedName().equals(BLOCK)) {
				blockStereotype = sub;
				break;
			}
		}

		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, SYSTEM)) {
			if (sub.getQualifiedName().equals(SYSTEM)) {
				systemStereotype = sub;
				break;
			}
		}
		
		for (Stereotype sub : UMLUtil.findSubstereotypes(pkg, CONTRACT)) {
			if (sub.getQualifiedName().equals(CONTRACT)) {
				contractStereotype = sub;
				break;
			}
		}
	}
	
}
