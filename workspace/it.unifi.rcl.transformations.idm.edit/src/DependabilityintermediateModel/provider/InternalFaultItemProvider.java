/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.provider;


import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.InternalFault;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link DependabilityintermediateModel.InternalFault} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InternalFaultItemProvider
	extends FaultItemProvider
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
	public InternalFaultItemProvider(AdapterFactory adapterFactory) {
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

			addPermanentProbabilityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Permanent Probability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPermanentProbabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InternalFault_PermanentProbability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InternalFault_PermanentProbability_feature", "_UI_InternalFault_type"),
				 DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__PERMANENT_PROBABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
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
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE);
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION);
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
	 * This returns InternalFault.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InternalFault"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InternalFault)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InternalFault_type") :
			getString("_UI_InternalFault_type") + " " + label;
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

		switch (notification.getFeatureID(InternalFault.class)) {
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__PERMANENT_PROBABILITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__OCCURRENCE:
			case DependabilityintermediateModelPackage.INTERNAL_FAULT__TRANSIENT_DURATION:
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
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createExponential()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createGaussian()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createDeterministic()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createUniform()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createGamma()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE,
				 DependabilityintermediateModelFactory.eINSTANCE.createWeibull()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createExponential()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createGaussian()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createDeterministic()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createUniform()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createGamma()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION,
				 DependabilityintermediateModelFactory.eINSTANCE.createWeibull()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__OCCURRENCE ||
			childFeature == DependabilityintermediateModelPackage.Literals.INTERNAL_FAULT__TRANSIENT_DURATION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
