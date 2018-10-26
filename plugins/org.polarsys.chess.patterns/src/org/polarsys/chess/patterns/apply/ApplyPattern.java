package org.polarsys.chess.patterns.apply;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage;
import org.polarsys.chess.patterns.utils.PatternUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

public class ApplyPattern {
	
	private static final String PATTERN_APPLICATION = "PatternsProfile::PatternApplication";
	private static final String PATTERN_ROLE = "PatternsProfile::PatternRole";
	private Map<NamedElement, NamedElement> mappings;
	private Class modelCtx;
	private Pattern pattern;
	
	public ApplyPattern(Map<NamedElement, NamedElement> mappings, Pattern pattern, Class modelCtx) {
		this.mappings = mappings;
		this.pattern = pattern;
		this.modelCtx = modelCtx;
	}

	public void apply() {
		
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();

		//create the collaborationUse in the modelCtx
		//then create the dependencies from pattern element to model element
		//and set them as rolebindings of the collaborationUse
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			protected void doExecute() {
				
				//Apply PatternsProfile to model
				Model chessModel = modelCtx.getModel();
				Profile patternsProfile =  UMLResourcesUtil.getProfile(PatternsProfilePackage.eINSTANCE, chessModel);
				if(chessModel.getProfileApplication(patternsProfile) == null){
					PackageUtil.applyProfile(chessModel, patternsProfile, false);
				}
				
				CollaborationUse collUse = UMLFactory.eINSTANCE.createCollaborationUse();
				collUse.setType(pattern.getBase_Collaboration());
				String name = pattern.getBase_Collaboration().getName();
				name = name.substring(0, 1).toLowerCase() + name.substring(1);
				collUse.setName(name + "_Application");
				modelCtx.getCollaborationUses().add(collUse);
				Stereotype stereo = UMLUtils.applyStereotype(collUse, PATTERN_APPLICATION);
				if(stereo != null){
					PatternApplication pAppl = (PatternApplication) collUse.getStereotypeApplication(stereo);
					pAppl.setAppliedPattern(pattern.getPatternName());
				}

				Map<NamedElement, NamedElement> newMappings = new HashMap<>();
				
				for (NamedElement nelem : mappings.keySet()) {

					if(nelem instanceof Class){
						Class mappedClass = (Class) mappings.get(nelem);
						if(mappedClass == null){
							//create type (Class) inside modelCtx nearest package
							Package pkg = modelCtx.getNearestPackage();
							mappedClass = UMLFactory.eINSTANCE.createClass();
							mappedClass.setName(nelem.getName());
							pkg.getPackagedElements().add(mappedClass);
							PatternUtils.applyStereotypes(nelem, mappedClass);
							//save "new" mapping
							newMappings.put(nelem, mappedClass);
						}
						//apply patternRole stereotype to the mapped element
						stereo = UMLUtils.applyStereotype(mappedClass, PATTERN_ROLE);
						if(stereo != null){
							PatternRole pRole = (PatternRole) mappedClass.getStereotypeApplication(stereo);
							pRole.setAppliedPattern(pattern.getPatternName());
							pRole.setMappedRole(nelem.getQualifiedName());
						}
						//create rolebinding in collaborationUse
						Dependency dep = UMLFactory.eINSTANCE.createDependency();
						dep.getSuppliers().add(nelem);
						dep.getClients().add(mappedClass);
						dep.setName("rolebinding_" + nelem.getName() + "_" + mappedClass.getName());
						collUse.getRoleBindings().add(dep);
					}
				}
				//update mappings
				mappings.putAll(newMappings);
				newMappings.clear();

				for (NamedElement nelem : mappings.keySet()) {
					if(nelem instanceof Port){
						//create port inside mapped type
						Class patternClass = (Class) nelem.getOwner();
						Class mappedClass = (Class) mappings.get(patternClass);
						Port mappedPort = (Port) mappings.get(nelem);
						if(mappedPort == null){
							mappedPort = UMLFactory.eINSTANCE.createPort();
							mappedPort.setName(nelem.getName());
							mappedClass.getOwnedPorts().add(mappedPort);
							PatternUtils.applyStereotypes(nelem, mappedPort);
							//save "new" mapping
							newMappings.put(nelem, mappedPort);
						}
						//apply patternRole stereotype to the mapped element
						stereo = UMLUtils.applyStereotype(mappedPort, PATTERN_ROLE);
						if(stereo != null){
							PatternRole pRole = (PatternRole) mappedPort.getStereotypeApplication(stereo);
							pRole.setAppliedPattern(pattern.getPatternName());
							pRole.setMappedRole(nelem.getQualifiedName());
						}
						//create rolebinding in collaborationUse
						Dependency dep = UMLFactory.eINSTANCE.createDependency();
						dep.getSuppliers().add(nelem);
						dep.getClients().add(mappedPort);
						dep.setName("rolebinding_" + nelem.getName() + "_" + mappedPort.getName());
						collUse.getRoleBindings().add(dep);
					}
				}
				//update mappings
				mappings.putAll(newMappings);
				newMappings.clear();

				for (NamedElement nelem : mappings.keySet()) {
					if(nelem instanceof Property && !(nelem instanceof Port)){
						//create instance of mapped type in modelCtx
						Class patternClass = (Class) ((Property)nelem).getType();
						Class mappedClass = (Class) mappings.get(patternClass);
						Property mappedProperty = (Property) mappings.get(nelem);
						if(mappedProperty == null){
							mappedProperty = UMLFactory.eINSTANCE.createProperty();
							if(mappedClass != null){
								mappedProperty.setType(mappedClass);
							}
							mappedProperty.setName(nelem.getName());
							mappedProperty.setAggregation(AggregationKind.COMPOSITE_LITERAL);
							modelCtx.getOwnedAttributes().add(mappedProperty);
							//save "new" mapping
							newMappings.put(nelem, mappedProperty);
							//TODO create association (dnd not working with SysML... need annotation?)
							Association association = UMLFactory.eINSTANCE.createAssociation();
							Property prop = UMLFactory.eINSTANCE.createProperty(); //property on association
							prop.setType(modelCtx);
							prop.setOwningAssociation(association);
							prop.setName(modelCtx.getName().substring(0, 1).toLowerCase() + modelCtx.getName().substring(1));
							prop.setAggregation(AggregationKind.NONE_LITERAL);
							association.getMemberEnds().add(prop);
							association.getMemberEnds().add(mappedProperty);
							association.setName("A_" + mappedProperty.getName() + "_" + prop.getName());
							modelCtx.getNearestPackage().getPackagedElements().add(association);
						}
						//apply patternRole stereotype to the mapped element
						stereo = UMLUtils.applyStereotype(mappedProperty, PATTERN_ROLE);
						if(stereo != null){
							PatternRole pRole = (PatternRole) mappedProperty.getStereotypeApplication(stereo);
							pRole.setAppliedPattern(pattern.getPatternName());
							pRole.setMappedRole(nelem.getQualifiedName());
						}
						//create rolebinding in collaborationUse
						Dependency dep = UMLFactory.eINSTANCE.createDependency();
						dep.getSuppliers().add(nelem);
						dep.getClients().add(mappedProperty);
						dep.setName("rolebinding_" + nelem.getName() + "_" + mappedProperty.getName());
						collUse.getRoleBindings().add(dep);
					}
				}
				//update mappings
				mappings.putAll(newMappings);
				newMappings.clear();

				for (NamedElement nelem : mappings.keySet()) {
					if(nelem instanceof Connector){
						//create connector in modelCtx and set ends (role and partWithPort)
						Connector patternConnector = (Connector) nelem;
						if(patternConnector.getEnds().size() == 2){
							Port patternFirstPort = (Port) patternConnector.getEnds().get(0).getRole();
							Port patternSecondPort =(Port) patternConnector.getEnds().get(1).getRole();
							Property patternFirstProp = patternConnector.getEnds().get(0).getPartWithPort();
							Property patternSecondProp = patternConnector.getEnds().get(1).getPartWithPort();
							if(patternFirstPort != null && patternSecondPort != null && patternFirstProp != null && patternSecondProp != null){
								Connector mappedConnector = (Connector) mappings.get(patternConnector);
								if(mappedConnector == null){
									mappedConnector = UMLFactory.eINSTANCE.createConnector();
									mappedConnector.setName("c_" + patternFirstProp.getName() + "_" + patternFirstPort.getName() + "_" + patternSecondProp.getName() + "_" + patternSecondPort.getName());
									ConnectorEnd firstEnd = UMLFactory.eINSTANCE.createConnectorEnd();
									firstEnd.setRole((Port) mappings.get(patternFirstPort));
									firstEnd.setPartWithPort((Property) mappings.get(patternFirstProp));
									ConnectorEnd secondEnd = UMLFactory.eINSTANCE.createConnectorEnd();
									secondEnd.setRole((Port) mappings.get(patternSecondPort));
									secondEnd.setPartWithPort((Property) mappings.get(patternSecondProp));
									mappedConnector.getEnds().add(firstEnd);
									mappedConnector.getEnds().add(secondEnd);
									modelCtx.getOwnedConnectors().add(mappedConnector);
									//save "new" mapping
									newMappings.put(patternConnector, mappedConnector);
								}
								//apply patternRole stereotype to the mapped element
								stereo = UMLUtils.applyStereotype(mappedConnector, PATTERN_ROLE);
								if(stereo != null){
									PatternRole pRole = (PatternRole) mappedConnector.getStereotypeApplication(stereo);
									pRole.setAppliedPattern(pattern.getPatternName());
									pRole.setMappedRole(nelem.getQualifiedName());
								}
								//create rolebinding in collaborationUse
								Dependency dep = UMLFactory.eINSTANCE.createDependency();
								dep.getSuppliers().add(nelem);
								dep.getClients().add(mappedConnector);
								dep.setName("rolebinding_" + patternConnector.getName() + "_" + mappedConnector.getName());
								collUse.getRoleBindings().add(dep);
							}
						}
					}
				}
				//update mappings
				mappings.putAll(newMappings);
				newMappings.clear();
			}
		});
	}

}
