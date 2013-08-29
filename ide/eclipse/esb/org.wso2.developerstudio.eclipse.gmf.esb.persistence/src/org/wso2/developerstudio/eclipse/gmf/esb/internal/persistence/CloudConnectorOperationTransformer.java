/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map.Entry;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class CloudConnectorOperationTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject) throws Exception {
		Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
		CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
		information.getParentSequence().addChild(
				createCloudConnectorOperation(information, visuaCloudConnectorOperation));
		doTransform(information, visuaCloudConnectorOperation.getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws Exception {
		Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
		CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
		sequence.addChild(createCloudConnectorOperation(information, visuaCloudConnectorOperation));
		doTransformWithinSequence(information, visuaCloudConnectorOperation.getOutputConnector()
				.getOutgoingLink(), sequence);
		
	}
	
	private CloudConnectorOperationExt createCloudConnectorOperation(
			TransformationInfo information, CloudConnectorOperation visuaCloudConnectorOperation) throws Exception {
		
		CloudConnectorOperationExt cloudConnectorOperation=new CloudConnectorOperationExt();
		cloudConnectorOperation.setConnector("twilio");
		cloudConnectorOperation.setOperation("configure");
		cloudConnectorOperation.setConfigRef(visuaCloudConnectorOperation.getConfigRef());
		
		for (CallTemplateParameter param : visuaCloudConnectorOperation.getConnectorParameters()) {
			if (param.getParameterName() != null && !param.getParameterName().isEmpty()) {
				if (param.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
					
					NamespacedProperty namespacedExpression = param.getParameterExpression();
					String xpathValue = namespacedExpression.getPropertyValue();

						SynapseXPath paramExpression = new SynapseXPath(xpathValue);
						for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {;
							paramExpression.addNamespace(entry.getKey(), entry.getValue());
						}
						cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(paramExpression));
				} else {
					cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(), new Value(param.getParameterValue()));
				}
			}
		}
		return cloudConnectorOperation;
	}

}