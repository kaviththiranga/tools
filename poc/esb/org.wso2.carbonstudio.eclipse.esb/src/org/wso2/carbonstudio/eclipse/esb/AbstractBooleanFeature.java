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
package org.wso2.carbonstudio.eclipse.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Boolean Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.AbstractBooleanFeature#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.AbstractBooleanFeature#isFeatureEnabled <em>Feature Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.carbonstudio.eclipse.esb.EsbPackage#getAbstractBooleanFeature()
 * @model abstract="true"
 * @generated
 */
public interface AbstractBooleanFeature extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * The default value is <code>"feature_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.wso2.carbonstudio.eclipse.esb.EsbPackage#getAbstractBooleanFeature_FeatureName()
	 * @model default="feature_name"
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.AbstractBooleanFeature#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Feature Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Enabled</em>' attribute.
	 * @see #setFeatureEnabled(boolean)
	 * @see org.wso2.carbonstudio.eclipse.esb.EsbPackage#getAbstractBooleanFeature_FeatureEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isFeatureEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.carbonstudio.eclipse.esb.AbstractBooleanFeature#isFeatureEnabled <em>Feature Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Enabled</em>' attribute.
	 * @see #isFeatureEnabled()
	 * @generated
	 */
	void setFeatureEnabled(boolean value);

} // AbstractBooleanFeature
