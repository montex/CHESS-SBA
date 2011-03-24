/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.provider;


import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.SchedulingConditionExpressionAndNode;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link DependabilityintermediateModel.SchedulingConditionExpressionAndNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingConditionExpressionAndNodeItemProvider
	extends SchedulingConditionExpressionNodeItemProvider
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
	public SchedulingConditionExpressionAndNodeItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1);
			childrenFeatures.add(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2);
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
	 * This returns SchedulingConditionExpressionAndNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SchedulingConditionExpressionAndNode"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SchedulingConditionExpressionAndNode_type");
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

		switch (notification.getFeatureID(SchedulingConditionExpressionAndNode.class)) {
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1:
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2:
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
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionDetectionNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionFailedNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionNotNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionTrueNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionDetectionNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionFailedNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionNotNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionTrueNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2,
				 DependabilityintermediateModelFactory.eINSTANCE.createSchedulingConditionExpressionOrNode()));
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
			childFeature == DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1 ||
			childFeature == DependabilityintermediateModelPackage.Literals.SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
