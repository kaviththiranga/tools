/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class Connector extends AbstractXMLDoc{

	private List<Dependency> componentDependencies=new ArrayList<Dependency>();
	
	public List<Dependency> getComponentDependencies() {
		return componentDependencies;
	}

	public void setComponentDependencies(List<Dependency> componentDependencies) {
		this.componentDependencies = componentDependencies;
	}

	@Override
	protected void deserialize(OMElement documentElement) throws Exception {		
		List<OMElement> component = getChildElements(documentElement, "component");
		for (OMElement omElement : component) {
			List<OMElement> artifactElements = getChildElements(omElement, "dependency");			
			for (OMElement omElement2 : artifactElements) {				
				Dependency artifactDependency=new Dependency(omElement2.getAttributeValue(new QName("component"))); 
				componentDependencies.add(artifactDependency);
			}
        }
		
	}

	@Override
	protected String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDefaultName() {
		// TODO Auto-generated method stub
		return null;
	}

}
