package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class WSDLEndPointTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		
		SendMediator sendMediator = null;
		if (information.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) {
			 if(visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof org.wso2.developerstudio.eclipse.gmf.esb.Sequence){
				 sendMediator=(SendMediator)information.getCurrentReferredSequence().getList().get(information.getCurrentReferredSequence().getList().size()-1);
			}else{
			sendMediator = (SendMediator) information.getParentSequence().getList()
					.get(information.getParentSequence().getList().size() - 1);
			}
		} else {
			sendMediator = new SendMediator();
			information.getParentSequence().addChild(sendMediator);
		}		
		sendMediator.setEndpoint(create(visualEndPoint,null));	
		
		if(visualEndPoint.getOutputConnector().getOutgoingLink() !=null){
		if((!(visualEndPoint.getOutputConnector().getOutgoingLink().getTarget() instanceof SequenceInputConnector))||
				(!(((Sequence)visualEndPoint.getOutputConnector().getOutgoingLink().getTarget().eContainer()).getOutputConnector().getOutgoingLink().getTarget().eContainer() instanceof EndPoint))){
		information.setParentSequence(information.getOriginOutSequence());
		information.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
		}else if(visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence){
			information.setParentSequence(information.getCurrentReferredSequence());
		}
		}

		if(!information.isEndPointFound){
			information.isEndPointFound=true;
			information.firstEndPoint=visualEndPoint;
		}		
		
		// Transform endpoint output data flow.
		doTransform(information, visualEndPoint.getOutputConnector());

	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		
		Endpoint endPoint =(Endpoint)create(visualEndPoint,null);
		endPoints.add(endPoint);		
		//Next node may be a Failover endPoint. So that this should be edited to be compatible with that also.
		info.setParentSequence(info.getOriginOutSequence());
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);		
		// Transform endpoint output data flow.
		
		if(!info.isOutputPathSet){
		if(info.firstEndPoint instanceof FailoverEndPoint){
			try {
				doTransform(info, ((FailoverEndPoint)info.firstEndPoint).getWestOutputConnector());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(info.firstEndPoint instanceof LoadBalanceEndPoint){
			try {
				doTransform(info, ((LoadBalanceEndPoint)info.firstEndPoint).getWestOutputConnector());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info.isOutputPathSet=true;
		}

	}
	
	public WSDLEndpoint create(WSDLEndPoint visualEndPoint,String name){
		WSDLEndpoint synapseWSDLEP = new WSDLEndpoint();
		EndpointDefinition synapseEPDef = new EndpointDefinition();
		synapseWSDLEP.setWsdlURI(visualEndPoint.getWsdlUri());
		synapseWSDLEP.setServiceName(visualEndPoint.getService());
		synapseWSDLEP.setPortName(visualEndPoint.getPort());
		synapseWSDLEP.setName(name);
		
		if (visualEndPoint.isAddressingEnabled()) {
			synapseEPDef.setAddressingOn(true);
			synapseEPDef.setUseSeparateListener(visualEndPoint
					.isAddressingSeparateListener());
			synapseEPDef
					.setAddressingVersion((visualEndPoint
							.getAddressingVersion() == EndPointAddressingVersion.FINAL) ? "final"
							: "submission");
		}
		
		if (visualEndPoint.isReliableMessagingEnabled()) {
			synapseEPDef.setReliableMessagingOn(visualEndPoint
					.isReliableMessagingEnabled());
			
		}
		if (visualEndPoint.isSecurityEnabled()) {
			synapseEPDef.setSecurityOn(true);
			
		}		

		synapseEPDef.setRetryDurationOnTimeout((int) (visualEndPoint
				.getRetryDelay()));
		if (ValidationUtil.isInt(visualEndPoint.getRetryErrorCodes()))
			synapseEPDef.addRetryDisabledErrorCode(ValidationUtil
					.getInt(visualEndPoint.getRetryErrorCodes()));
		if (ValidationUtil.isInt(visualEndPoint.getSuspendErrorCodes()))
			synapseEPDef.addSuspendErrorCode(ValidationUtil
					.getInt(visualEndPoint.getSuspendErrorCodes()));
		
		synapseWSDLEP.setDefinition(synapseEPDef);
		
		return synapseWSDLEP;
	}

	

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
