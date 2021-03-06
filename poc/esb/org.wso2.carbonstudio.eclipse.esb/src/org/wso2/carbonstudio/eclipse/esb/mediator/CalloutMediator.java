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
package org.wso2.carbonstudio.eclipse.esb.mediator;

import org.wso2.carbonstudio.eclipse.esb.Mediator;
import org.wso2.carbonstudio.eclipse.esb.NamespacedProperty;
import org.wso2.carbonstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Callout Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getServiceURL <em>Service URL</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadType <em>Payload Type</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadRegistryKey <em>Payload Registry Key</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator()
 * @model
 * @generated
 */
public interface CalloutMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Service URL</b></em>' attribute.
	 * The default value is <code>"service_url"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service URL</em>' attribute.
	 * @see #setServiceURL(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_ServiceURL()
	 * @model default="service_url"
	 * @generated
	 */
	String getServiceURL();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getServiceURL <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service URL</em>' attribute.
	 * @see #getServiceURL()
	 * @generated
	 */
	void setServiceURL(String value);

	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * The default value is <code>"soap_action"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_SoapAction()
	 * @model default="soap_action"
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2xml</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2xml</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #setPathToAxis2xml(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_PathToAxis2xml()
	 * @model default=""
	 * @generated
	 */
	String getPathToAxis2xml();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #getPathToAxis2xml()
	 * @generated
	 */
	void setPathToAxis2xml(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2 Repository</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2 Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #setPathToAxis2Repository(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_PathToAxis2Repository()
	 * @model default=""
	 * @generated
	 */
	String getPathToAxis2Repository();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #getPathToAxis2Repository()
	 * @generated
	 */
	void setPathToAxis2Repository(String value);

	/**
	 * Returns the value of the '<em><b>Payload Type</b></em>' attribute.
	 * The default value is <code>"MESSAGE_ELEMENT"</code>.
	 * The literals are from the enumeration {@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutPayloadType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.CalloutPayloadType
	 * @see #setPayloadType(CalloutPayloadType)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_PayloadType()
	 * @model default="MESSAGE_ELEMENT"
	 * @generated
	 */
	CalloutPayloadType getPayloadType();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadType <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.CalloutPayloadType
	 * @see #getPayloadType()
	 * @generated
	 */
	void setPayloadType(CalloutPayloadType value);

	/**
	 * Returns the value of the '<em><b>Payload Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #setPayloadMessageXpath(NamespacedProperty)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_PayloadMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getPayloadMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #getPayloadMessageXpath()
	 * @generated
	 */
	void setPayloadMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Payload Registry Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Registry Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Registry Key</em>' containment reference.
	 * @see #setPayloadRegistryKey(RegistryKeyProperty)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_PayloadRegistryKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPayloadRegistryKey();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getPayloadRegistryKey <em>Payload Registry Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Registry Key</em>' containment reference.
	 * @see #getPayloadRegistryKey()
	 * @generated
	 */
	void setPayloadRegistryKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * The default value is <code>"MESSAGE_ELEMENT"</code>.
	 * The literals are from the enumeration {@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.CalloutResultType
	 * @see #setResultType(CalloutResultType)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_ResultType()
	 * @model default="MESSAGE_ELEMENT"
	 * @generated
	 */
	CalloutResultType getResultType();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.CalloutResultType
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(CalloutResultType value);

	/**
	 * Returns the value of the '<em><b>Result Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #setResultMessageXpath(NamespacedProperty)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_ResultMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getResultMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #getResultMessageXpath()
	 * @generated
	 */
	void setResultMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Result Context Property</b></em>' attribute.
	 * The default value is <code>"context_property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Context Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Context Property</em>' attribute.
	 * @see #setResultContextProperty(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.mediator.MediatorPackage#getCalloutMediator_ResultContextProperty()
	 * @model default="context_property_name"
	 * @generated
	 */
	String getResultContextProperty();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.mediator.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Context Property</em>' attribute.
	 * @see #getResultContextProperty()
	 * @generated
	 */
	void setResultContextProperty(String value);

} // CalloutMediator
