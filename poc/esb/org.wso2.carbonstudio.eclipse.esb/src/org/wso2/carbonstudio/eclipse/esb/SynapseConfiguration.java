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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synapse Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.carbonstudio.eclipse.esb.SynapseConfiguration#getConfigurationElements <em>Configuration Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.carbonstudio.eclipse.esb.EsbPackage#getSynapseConfiguration()
 * @model
 * @generated
 */
public interface SynapseConfiguration extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Configuration Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.carbonstudio.eclipse.esb.ConfigurationElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Elements</em>' containment reference list.
	 * @see org.wso2.carbonstudio.eclipse.esb.EsbPackage#getSynapseConfiguration_ConfigurationElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConfigurationElement> getConfigurationElements();

} // SynapseConfiguration
