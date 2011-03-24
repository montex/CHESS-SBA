/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.provider;


import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.SchedulePeriodic;

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
 * This is the item provider adapter for a {@link DependabilityintermediateModel.SchedulePeriodic} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulePeriodicItemProvider
	extends SchedulingEventItemProvider
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
	public SchedulePeriodicItemProvider(AdapterFactory adapterFactory) {
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

			addBeforePropertyDescriptor(object);
			addAfterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Before feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBeforePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulePeriodic_Before_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulePeriodic_Before_feature", "_UI_SchedulePeriodic_type"),
				 DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__BEFORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the After feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAfterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchedulePeriodic_After_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchedulePeriodic_After_feature", "_UI_SchedulePeriodic_type"),
				 DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__AFTER,
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
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION);
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
	 * This returns SchedulePeriodic.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SchedulePeriodic"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		SchedulePeriodic schedulePeriodic = (SchedulePeriodic)object;
		return getString("_UI_SchedulePeriodic_type") + " " + schedulePeriodic.getBefore();
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

		switch (notification.getFeatureID(SchedulePeriodic.class)) {
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__BEFORE:
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__AFTER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC__DISTRIBUTION:
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
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createExponential()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createGaussian()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createDeterministic()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createUniform()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createGamma()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULE_PERIODIC__DISTRIBUTION,
				 DependabilityintermediateModelFactory.eINSTANCE.createWeibull()));
	}

}
