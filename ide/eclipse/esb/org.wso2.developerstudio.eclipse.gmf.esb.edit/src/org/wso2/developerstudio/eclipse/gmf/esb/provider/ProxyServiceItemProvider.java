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
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProxyServiceItemProvider
	extends EsbElementItemProvider
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
	public ProxyServiceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		ProxyService proxy = (ProxyService) object;

		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}

		super.getPropertyDescriptors(object);

		if (!proxy.isMainSequence()) {
			addNamePropertyDescriptor(object);
			addPinnedServersPropertyDescriptor(object);
			addServiceGroupPropertyDescriptor(object);
			addTraceEnabledPropertyDescriptor(object);
			addStatisticsEnabledPropertyDescriptor(object);
			addTransportsPropertyDescriptor(object);
			addReliableMessagingEnabledPropertyDescriptor(object);
			addSecurityEnabledPropertyDescriptor(object);
			// addWsdlTypePropertyDescriptor(object);
			// WSDL Type.
			addWsdlTypePropertyDescriptor(object);
			switch (proxy.getWsdlType()) {
			case INLINE: {
				addWsdlXMLPropertyDescriptor(object);
				break;
			}

			case SOURCE_URL: {
				addWsdlURLPropertyDescriptor(object);
				break;
			}

			case REGISTRY_KEY: {
				addWsdlKeyPropertyDescriptor(object);
				break;
			}
			}
			if (proxy.getWsdlType() != ProxyWsdlType.NONE) {
				addWsdlResourcesPropertyDescriptor(object);
			}
			addInSequenceTypePropertyDescriptor(object);
			switch (proxy.getInSequenceType()) {
			case REGISTRY_REFERENCE: {
				addInSequenceKeyPropertyDescriptor(object);
				break;
			}
			case NAMED_REFERENCE: {
				addInSequenceNamePropertyDescriptor(object);
				break;
			}
			}
			addOutSequenceTypePropertyDescriptor(object);
			switch (proxy.getOutSequenceType()) {
			case REGISTRY_REFERENCE: {
				addOutSequenceKeyPropertyDescriptor(object);
				break;
			}
			case NAMED_REFERENCE: {
				addOutSequenceNamePropertyDescriptor(object);
				break;
			}
			}
			addFaultSequenceTypePropertyDescriptor(object);
			switch (proxy.getFaultSequenceType()) {
			case REGISTRY_REFERENCE: {
				addFaultSequenceKeyPropertyDescriptor(object);
				break;
			}
			case NAMED_REFERENCE: {
				addFaultSequenceNamePropertyDescriptor(object);
				break;
			}
			}
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_name_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Pinned Servers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPinnedServersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_pinnedServers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_pinnedServers_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__PINNED_SERVERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Service Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addServiceGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_serviceGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_serviceGroup_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__SERVICE_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTraceEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_traceEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_traceEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__TRACE_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Statistics Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addStatisticsEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_statisticsEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_statisticsEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__STATISTICS_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Transports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTransportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_transports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_transports_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__TRANSPORTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Basic",
				 null));
	}

	/**
	 * This adds a property descriptor for the Reliable Messaging Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addReliableMessagingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_reliableMessagingEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_reliableMessagingEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSecurityEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_securityEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_securityEnabled_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__SECURITY_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 "QoS",
				 null));
	}

	/**
	 * This adds a property descriptor for the Wsdl Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWsdlTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_wsdlType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_wsdlType_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__WSDL_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "WSDL",
				 null));
	}

	/**
	 * This adds a property descriptor for the Wsdl XML feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWsdlXMLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_wsdlXML_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_wsdlXML_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__WSDL_XML,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "WSDL",
				 null));
	}

	/**
	 * This adds a property descriptor for the Wsdl URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWsdlURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_wsdlURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_wsdlURL_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__WSDL_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "WSDL",
				 null));
	}	
	
	/**
	 * This adds a property descriptor for the Wsdl Resources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWsdlResourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_wsdlResources_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_wsdlResources_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 "WSDL",
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_inSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_inSequenceType_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_inSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_inSequenceKey_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the In Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_inSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_inSequenceName_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "In Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_outSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_outSequenceType_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_outSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_outSequenceKey_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	protected void addOutSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_outSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_outSequenceName_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Out Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_faultSequenceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_faultSequenceType_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_faultSequenceKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_faultSequenceKey_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_KEY,
				 true,
				 false,
				 false,
				 null,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFaultSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_faultSequenceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_faultSequenceName_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Fault Sequence",
				 null));
	}

	/**
	 * This adds a property descriptor for the Main Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMainSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProxyService_mainSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_mainSequence_feature", "_UI_ProxyService_type"),
				 EsbPackage.Literals.PROXY_SERVICE__MAIN_SEQUENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	protected void addWsdlKeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ProxyService_wsdlKey_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ProxyService_wsdlKey_feature", "_UI_ProxyService_type"),
                 EsbPackage.Literals.PROXY_SERVICE__WSDL_KEY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 "WSDL",
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
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__OUTPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__FAULT_INPUT_CONNECTOR);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__SERVICE_PARAMETERS);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__CONTAINER);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_KEY);
			childrenFeatures.add(EsbPackage.Literals.PROXY_SERVICE__WSDL_KEY);
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
	 * This returns ProxyService.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProxyService"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String getText(Object object) {
		String label = ((ProxyService)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ProxyService_type") :
			getString("_UI_ProxyService_type") + " " + label;
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

		switch (notification.getFeatureID(ProxyService.class)) {
			case EsbPackage.PROXY_SERVICE__NAME:
			case EsbPackage.PROXY_SERVICE__PINNED_SERVERS:
			case EsbPackage.PROXY_SERVICE__SERVICE_GROUP:
			case EsbPackage.PROXY_SERVICE__TRACE_ENABLED:
			case EsbPackage.PROXY_SERVICE__STATISTICS_ENABLED:
			case EsbPackage.PROXY_SERVICE__TRANSPORTS:
			case EsbPackage.PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED:
			case EsbPackage.PROXY_SERVICE__SECURITY_ENABLED:
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_TYPE:
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_NAME:
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_TYPE:
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_NAME:
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_TYPE:
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_NAME:
			case EsbPackage.PROXY_SERVICE__MAIN_SEQUENCE:
			case EsbPackage.PROXY_SERVICE__WSDL_TYPE:
			case EsbPackage.PROXY_SERVICE__WSDL_XML:
			case EsbPackage.PROXY_SERVICE__WSDL_URL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EsbPackage.PROXY_SERVICE__OUTPUT_CONNECTOR:
			case EsbPackage.PROXY_SERVICE__INPUT_CONNECTOR:
			case EsbPackage.PROXY_SERVICE__FAULT_INPUT_CONNECTOR:
			case EsbPackage.PROXY_SERVICE__SERVICE_PARAMETERS:
			case EsbPackage.PROXY_SERVICE__SERVICE_POLICIES:
			case EsbPackage.PROXY_SERVICE__CONTAINER:
			case EsbPackage.PROXY_SERVICE__IN_SEQUENCE_KEY:
			case EsbPackage.PROXY_SERVICE__OUT_SEQUENCE_KEY:
			case EsbPackage.PROXY_SERVICE__FAULT_SEQUENCE_KEY:
			case EsbPackage.PROXY_SERVICE__WSDL_KEY:
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
				(EsbPackage.Literals.PROXY_SERVICE__OUTPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createProxyOutputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createProxyInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__FAULT_INPUT_CONNECTOR,
				 EsbFactory.eINSTANCE.createProxyFaultInputConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__SERVICE_PARAMETERS,
				 EsbFactory.eINSTANCE.createProxyServiceParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES,
				 EsbFactory.eINSTANCE.createProxyServicePolicy()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__CONTAINER,
				 EsbFactory.eINSTANCE.createProxyServiceContainer()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));

		newChildDescriptors.add
			(createChildParameter
				(EsbPackage.Literals.PROXY_SERVICE__WSDL_KEY,
				 EsbFactory.eINSTANCE.createRegistryKeyProperty()));
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
			childFeature == EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.PROXY_SERVICE__OUT_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.PROXY_SERVICE__FAULT_SEQUENCE_KEY ||
			childFeature == EsbPackage.Literals.PROXY_SERVICE__WSDL_KEY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
