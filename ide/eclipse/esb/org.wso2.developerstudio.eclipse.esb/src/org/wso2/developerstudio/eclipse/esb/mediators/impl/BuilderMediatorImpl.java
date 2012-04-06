/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Builder Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.BuilderMediatorImpl#getMessageBuilders <em>Message Builders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BuilderMediatorImpl extends MediatorImpl implements BuilderMediator {
	/**
	 * The cached value of the '{@link #getMessageBuilders() <em>Message Builders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageBuilders()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageBuilder> messageBuilders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuilderMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		loadObjects(self, "messageBuilder", MessageBuilder.class, new ObjectHandler<MessageBuilder>() {
			public void handle(MessageBuilder object) {
				getMessageBuilders().add(object);
			}			
		});	
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "builder");
		
		// Message builders.
		for (MessageBuilder messageBuilder : getMessageBuilders()) {
			messageBuilder.save(self);
		}
		if(description!=null)
			description.save(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.BUILDER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageBuilder> getMessageBuilders() {
		if (messageBuilders == null) {
			messageBuilders = new EObjectContainmentEList<MessageBuilder>(MessageBuilder.class, this, MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS);
		}
		return messageBuilders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS:
				return ((InternalEList<?>)getMessageBuilders()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS:
				return getMessageBuilders();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS:
				getMessageBuilders().clear();
				getMessageBuilders().addAll((Collection<? extends MessageBuilder>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS:
				getMessageBuilders().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.BUILDER_MEDIATOR__MESSAGE_BUILDERS:
				return messageBuilders != null && !messageBuilders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	public Map<String, ObjectValidator> validate() {
		return new HashMap<String, ObjectValidator>();
	}

} //BuilderMediatorImpl
