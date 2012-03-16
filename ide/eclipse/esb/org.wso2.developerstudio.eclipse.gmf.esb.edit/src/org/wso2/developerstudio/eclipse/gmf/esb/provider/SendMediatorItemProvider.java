/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ReceivingSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.SendMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SendMediatorItemProvider
	extends MediatorItemProvider
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
	public SendMediatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		SendMediator sendMediator = (SendMediator) object;
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}	
		super.getPropertyDescriptors(object);	
		addReceivingSequenceTypePropertyDescriptor(object);
		switch (sendMediator.getReceivingSequenceType()) {
		case DEFAULT:
			break;
		case STATIC:
			addStaticReceivingSequencePropertyDescriptor(object);
			break;
		case DYNAMIC:
			addDynamicReceivingSequencePropertyDescriptor(object);
			break;
		}	
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the End Point feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndPointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_EndPoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_EndPoint_feature", "_UI_SendMediator_type"),
				 EsbPackage.Literals.SEND_MEDIATOR__END_POINT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Receiving Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReceivingSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_receivingSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_receivingSequenceType_feature", "_UI_SendMediator_type"),
				 EsbPackage.Literals.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	
	protected void addStaticReceivingSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_StaticReceivingSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_StaticReceivingSequence_feature", "_UI_SendMediator_type"),
				 EsbPackage.Literals.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}
	
	
	protected void addDynamicReceivingSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SendMediator_DynamicReceivingSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SendMediator_DynamicReceivingSequence_feature", "_UI_SendMediator_type"),
				 EsbPackage.Literals.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE,
				 true,
				 false,
				 true,
				 null,
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
	
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EsbPackage.Literals.SEND_MEDIATOR__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.SEND_MEDIATOR__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE);
			childrenFeatures.add(EsbPackage.Literals.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SendMediator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SendMediator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	
	public String getText(Object object) {
		SendMediator sendMediator = (SendMediator)object;
		return getString("_UI_SendMediator_type") + " " + sendMediator.isReverse();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SendMediator.class)) {
			case EsbPackage.SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.SEND_MEDIATOR__INPUT_CONNECTOR:
			case EsbPackage.SEND_MEDIATOR__OUTPUT_CONNECTOR:
			case EsbPackage.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE:
			case EsbPackage.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE:
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
	
	
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SEND_MEDIATOR__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createSendMediatorInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SEND_MEDIATOR__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createSendMediatorOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE,
				 EsbFactory.eINSTANCE.createNamespacedProperty()));
	}

}
