/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.provider;


import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.FaultsGenerateErrors;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link DependabilityintermediateModel.FaultsGenerateErrors} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FaultsGenerateErrorsItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsGenerateErrorsItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSourcePropertyDescriptor(object);
			addDestinationPropertyDescriptor(object);
			addPropagationProbabilityPropertyDescriptor(object);
			addWeightPropertyDescriptor(object);
			addPropagationLogicStringFormatPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_Source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_Source_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Destination feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_Destination_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_Destination_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__DESTINATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Propagation Probability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropagationProbabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_PropagationProbability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_PropagationProbability_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Weight feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_Weight_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_Weight_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__WEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Propagation Logic String Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropagationLogicStringFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_PropagationLogicStringFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_PropagationLogicStringFormat_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FaultsGenerateErrors_Name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FaultsGenerateErrors_Name_feature", "_UI_FaultsGenerateErrors_type"),
				 DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY);
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FaultsGenerateErrors.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FaultsGenerateErrors"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FaultsGenerateErrors)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_FaultsGenerateErrors_type") :
			getString("_UI_FaultsGenerateErrors_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FaultsGenerateErrors.class)) {
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY:
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT:
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT:
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createExponential()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createGaussian()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createDeterministic()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createUniform()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createGamma()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY,
				 DependabilityintermediateModelFactory.eINSTANCE.createWeibull()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC,
				 DependabilityintermediateModelFactory.eINSTANCE.createFaultsExpressionAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC,
				 DependabilityintermediateModelFactory.eINSTANCE.createFaultsExpressionOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC,
				 DependabilityintermediateModelFactory.eINSTANCE.createFaultsExpressionFaultNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC,
				 DependabilityintermediateModelFactory.eINSTANCE.createFaultsExpressionNotNode()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return IM2EditPlugin.INSTANCE;
	}

}
