/* Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.carbonstudio.eclipse.ds;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.wso2.carbonstudio.eclipse.ds.Resource#getMethod <em>Method
 * </em>}</li>
 * <li>{@link org.wso2.carbonstudio.eclipse.ds.Resource#getPath <em>Path</em>}</li>
 * <li>{@link org.wso2.carbonstudio.eclipse.ds.Resource#getCallQuery <em>Call
 * Query</em>}</li>
 * <li>{@link org.wso2.carbonstudio.eclipse.ds.Resource#getCallQueryList <em>
 * Call Query List</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.wso2.carbonstudio.eclipse.ds.DsPackage#getResource()
 * @model extendedMetaData="name='resource_._type' kind='elementOnly'"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see org.wso2.carbonstudio.eclipse.ds.DsPackage#getResource_Method()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData
	 *        ="kind='attribute' name='method' namespace='##targetNamespace'"
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '
	 * {@link org.wso2.carbonstudio.eclipse.ds.Resource#getMethod
	 * <em>Method</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.wso2.carbonstudio.eclipse.ds.DsPackage#getResource_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData
	 *        ="kind='attribute' name='path' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '
	 * {@link org.wso2.carbonstudio.eclipse.ds.Resource#getPath <em>Path</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Call Query</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Call Query</em>' containment reference.
	 * @see #setCallQuery(CallQuery)
	 * @see org.wso2.carbonstudio.eclipse.ds.DsPackage#getResource_CallQuery()
	 * @model containment="true" extendedMetaData=
	 *        "kind='element' name='call-query' namespace='##targetNamespace'"
	 * @generated
	 */
	CallQuery getCallQuery();

	/**
	 * Sets the value of the '
	 * {@link org.wso2.carbonstudio.eclipse.ds.Resource#getCallQuery
	 * <em>Call Query</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Call Query</em>' containment
	 *            reference.
	 * @see #getCallQuery()
	 * @generated
	 */
	void setCallQuery(CallQuery value);

	/**
	 * Returns the value of the '<em><b>Call Query List</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query List</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Call Query List</em>' containment
	 *         reference.
	 * @see #setCallQueryList(CallQueryList)
	 * @see org.wso2.carbonstudio.eclipse.ds.DsPackage#getResource_CallQueryList()
	 * @model containment="true" extendedMetaData=
	 *        "kind='element' name='call-query-group' namespace='##targetNamespace'"
	 * @generated
	 */
	CallQueryList getCallQueryList();

	/**
	 * Sets the value of the '
	 * {@link org.wso2.carbonstudio.eclipse.ds.Resource#getCallQueryList
	 * <em>Call Query List</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Call Query List</em>' containment
	 *            reference.
	 * @see #getCallQueryList()
	 * @generated
	 */
	void setCallQueryList(CallQueryList value);

} // Resource
