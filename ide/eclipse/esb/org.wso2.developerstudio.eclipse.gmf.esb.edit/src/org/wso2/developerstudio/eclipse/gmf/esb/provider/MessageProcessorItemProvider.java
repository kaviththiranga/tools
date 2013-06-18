/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageProcessorItemProvider
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
	public MessageProcessorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		MessageProcessor messageProcessor = (MessageProcessor)object;
		
		if (itemPropertyDescriptors != null) {
			itemPropertyDescriptors.clear();
		}
		
		super.getPropertyDescriptors(object);

		addProcessorNamePropertyDescriptor(object);
		addProcessorTypePropertyDescriptor(object);
		addMessageStorePropertyDescriptor(object);
		
		switch (messageProcessor.getProcessorType()) {
		case SCHEDULED_MSG_FORWARDING: {
			addRetryIntervalPropertyDescriptor(object);
			addMaxDeliveryAttemptsPropertyDescriptor(object);
			addAxis2ClientRepositoryPropertyDescriptor(object);
			addAxis2ConfigurationPropertyDescriptor(object);
			addReplySequenceNamePropertyDescriptor(object);
			addFaultSequenceNamePropertyDescriptor(object);
			addQuartzConfigFilePathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addPinnedServersPropertyDescriptor(object);
			break;
		}
		case MSG_SAMPLING: {
			addSequencePropertyDescriptor(object);
			addRetryIntervalPropertyDescriptor(object);
			addQuartzConfigFilePathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addPinnedServersPropertyDescriptor(object);
			break;
		}
		case CUSTOM: {
			addMessageProcessorProviderPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			break;
		}
		default:
			break;
		}
			
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Processor Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_processorName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_processorName_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Processor Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_processorType_feature"),
				 getString("_UI_MessageProcessor_processorType_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PROCESSOR_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Message Processor Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessageProcessorProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_messageProcessorProvider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_messageProcessorProvider_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Message Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessageStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_messageStore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_messageStore_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MESSAGE_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_sequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_sequence_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_basicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Retry Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRetryIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_retryInterval_feature"),
				 getString("_UI_MessageProcessor_retryInterval_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__RETRY_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Delivery Attempts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxDeliveryAttemptsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_maxDeliveryAttempts_feature"),
				 getString("_UI_MessageProcessor_maxDeliveryAttempts_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Axis2 Client Repository feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAxis2ClientRepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_axis2ClientRepository_feature"),
				 getString("_UI_MessageProcessor_axis2ClientRepository_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Axis2 Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAxis2ConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_axis2Configuration_feature"),
				 getString("_UI_MessageProcessor_axis2Configuration_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Reply Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReplySequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_replySequenceName_feature"),
				 getString("_UI_MessageProcessor_replySequenceName_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__REPLY_SEQUENCE_NAME,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Fault Sequence Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFaultSequenceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_faultSequenceName_feature"),
				 getString("_UI_MessageProcessor_faultSequenceName_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__FAULT_SEQUENCE_NAME,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Quartz Config File Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuartzConfigFilePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_quartzConfigFilePath_feature"),
				 getString("_UI_MessageProcessor_quartzConfigFilePath_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Cron Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCronExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_cronExpression_feature"),
				 getString("_UI_MessageProcessor_cronExpression_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__CRON_EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Pinned Servers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPinnedServersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_pinnedServers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MessageProcessor_pinnedServers_feature", "_UI_MessageProcessor_type"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PINNED_SERVERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MessageProcessor_parameters_feature"),
				 getString("_UI_MessageProcessor_parameters_description"),
				 EsbPackage.Literals.MESSAGE_PROCESSOR__PARAMETERS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_AdditionalParametersPropertyCategory"),
				 null));
	}

	/**
	 * This returns MessageProcessor.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MessageProcessor"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MessageProcessor)object).getProcessorName();
		return label == null || label.length() == 0 ?
			getString("_UI_MessageProcessor_type") :
			getString("_UI_MessageProcessor_type") + " " + label;
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

		switch (notification.getFeatureID(MessageProcessor.class)) {
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_NAME:
			case EsbPackage.MESSAGE_PROCESSOR__PROCESSOR_TYPE:
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_PROCESSOR_PROVIDER:
			case EsbPackage.MESSAGE_PROCESSOR__MESSAGE_STORE:
			case EsbPackage.MESSAGE_PROCESSOR__RETRY_INTERVAL:
			case EsbPackage.MESSAGE_PROCESSOR__MAX_DELIVERY_ATTEMPTS:
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CLIENT_REPOSITORY:
			case EsbPackage.MESSAGE_PROCESSOR__AXIS2_CONFIGURATION:
			case EsbPackage.MESSAGE_PROCESSOR__QUARTZ_CONFIG_FILE_PATH:
			case EsbPackage.MESSAGE_PROCESSOR__CRON_EXPRESSION:
			case EsbPackage.MESSAGE_PROCESSOR__PINNED_SERVERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
