package org.polarsys.chess.OSSImporter.utils;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.utils.OSSModelUtil;
import eu.fbk.tools.editor.basetype.baseType.BooleanType;
import eu.fbk.tools.editor.basetype.baseType.BoundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.ContinuousType;
import eu.fbk.tools.editor.basetype.baseType.EnumType;
import eu.fbk.tools.editor.basetype.baseType.EventType;
import eu.fbk.tools.editor.basetype.baseType.FixedSizeArrayType;
import eu.fbk.tools.editor.basetype.baseType.IntegerType;
import eu.fbk.tools.editor.basetype.baseType.RangeType;
import eu.fbk.tools.editor.basetype.baseType.RealType;
import eu.fbk.tools.editor.basetype.baseType.SignedWordType;
import eu.fbk.tools.editor.basetype.baseType.SimpleType;
import eu.fbk.tools.editor.basetype.baseType.UnboundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.UnsignedWordType;
import eu.fbk.tools.editor.basetype.baseType.WordArrayType;
import eu.fbk.tools.editor.basetype.baseType.WordType;
import eu.fbk.tools.editor.oss.oss.ComplexType;
import eu.fbk.tools.editor.oss.oss.ParameterizedArrayType;

public class OssTypeTranslator {

	private static final Logger logger = Logger.getLogger(OssTypeTranslator.class);

	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private OSSModelUtil ossModelUtil = OSSModelUtil.getInstance();
	private final StereotypeUtil stereotypeUtil = StereotypeUtil.getInstance();

	private static OssTypeTranslator ossTypeTranslatorInstance;

	public static OssTypeTranslator getInstance() {
		if (ossTypeTranslatorInstance == null) {
			ossTypeTranslatorInstance = new OssTypeTranslator();
		}
		return ossTypeTranslatorInstance;
	}

	public Type getOrCreateTypeFromOssComplexType(ComplexType dslType, Package pkg) {
		EObject type = dslType.getComplexType();
		if (type instanceof SimpleType) {
			return getOrCreateTypeFromOssSimpleType((SimpleType) type, pkg);
		} else if (type instanceof ParameterizedArrayType) {
			return getOrCreateTypeFromOssSimpleType(((ParameterizedArrayType) type).getType(), pkg);
		}
		return null;
	}

	/**
	 * Returns the correct Type given the DSL SimpleType.
	 * 
	 * @param dslType
	 *            the type from OSS
	 * @param pkg
	 *            the package where the types could be
	 * @return the UML Type
	 */
	public Type getOrCreateTypeFromOssSimpleType(SimpleType dslType, Package pkg) {

		if (dslType instanceof BooleanType) {
			logger.debug("BooleanType");
			return entityUtil.getPrimitiveType("Boolean");
		} else if (dslType instanceof IntegerType) {
			logger.debug("IntegerType");
			return entityUtil.getPrimitiveType("Integer");
		} else if (dslType instanceof RealType) {
			logger.debug("RealType");
			return entityUtil.getPrimitiveType("Real");
		} else if (dslType instanceof WordType) {
			logger.debug("WordType");
		} else if (dslType instanceof UnsignedWordType) {
			logger.debug("UnsignedWordType");
		} else if (dslType instanceof SignedWordType) {
			logger.debug("SignedWordType");
		} else if (dslType instanceof ContinuousType) {
			logger.debug("ContinuousType");
			return entityUtil.getContinuousType("Continuous");
		} else if (dslType instanceof EventType) {
			logger.debug("EventType");
			return entityUtil.getOrCreateSignalType(pkg);
		} else if (dslType instanceof RangeType) {
			logger.debug("RangeType");
			return entityUtil.getOrCreateBoundedSubType(ossModelUtil.getBoundariesFromOssRangeType((RangeType) dslType),
					pkg, stereotypeUtil.boundedTypeStereotype);
		} else if (dslType instanceof EnumType) {
			logger.debug("EnumType");
			return entityUtil.getOrCreateEnumerationType(ossModelUtil.getListValuesForEnumType((EnumType) dslType),
					pkg);
		} else if (dslType instanceof FixedSizeArrayType) {
			logger.debug("FixedSizeArrayType");
			return getOrCreateTypeFromOssSimpleType(((FixedSizeArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof BoundedArrayType) {
			logger.debug("BoundedArrayType");
			return getOrCreateTypeFromOssSimpleType(((BoundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof UnboundedArrayType) {
			logger.debug("UnboundedArrayType");
			return getOrCreateTypeFromOssSimpleType(((UnboundedArrayType) dslType).getType(), pkg);
		} else if (dslType instanceof WordArrayType) {
			logger.debug("WordArrayType");
		}
		logger.error("Not able to map the requested DSL type!");
		return null;
	}

	public EList<Type> getOrCreateTypesFromOssSimpleTypes(EList<SimpleType> parameters, Package nearestPackage) {

		EList<Type> types = new BasicEList<Type>();

		for (SimpleType parameterType : parameters) {
			types.add(getOrCreateTypeFromOssSimpleType(parameterType, nearestPackage));
		}
		return types;
	}

}
