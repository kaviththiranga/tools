package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EventTopicType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class EventMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {
		information.getParentSequence().addChild(
				createEventMediator(information, subject));
		// Transform the Event mediator output data flow path.
		doTransform(information, ((EventMediator) subject).getOutputConnector());

	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {

	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		sequence.addChild(createEventMediator(information, subject));
		doTransformWithinSequence(information, ((EventMediator) subject)
				.getOutputConnector().getOutgoingLink(), sequence);

	}

	private org.wso2.carbon.mediator.event.EventMediator createEventMediator(
			TransformationInfo information, EsbNode subject) throws Exception {
		// Check subject.
		Assert.isTrue(subject instanceof EventMediator, "Invalid subject.");
		EventMediator visualEvent = (EventMediator) subject;

		org.wso2.carbon.mediator.event.EventMediator eventMediator = new org.wso2.carbon.mediator.event.EventMediator();
		setCommonProperties(eventMediator, visualEvent);
		{
			if (visualEvent.getEventExpression() != null
					&& visualEvent.getEventExpression().getPropertyValue() != null) {
				SynapseXPath expression = new SynapseXPath(visualEvent
						.getEventExpression().getPropertyValue());

				if (visualEvent.getEventExpression().getNamespaces() != null) {
					Map<String, String> map = visualEvent.getEventExpression()
							.getNamespaces();
					Iterator<Map.Entry<String, String>> entries = map
							.entrySet().iterator();
					while (entries.hasNext()) {
						Map.Entry<String, String> entry = entries.next();
						expression.addNamespace(entry.getKey(),
								entry.getValue());
					}
				}
				eventMediator.setExpression(expression);
			}

			Value topic;

			if (visualEvent.getTopicType().compareTo(EventTopicType.STATIC) == 0) {

				topic = new Value(visualEvent.getStaticTopic());

			} else {

				SynapseXPath topicExpression = new SynapseXPath(visualEvent
						.getDynamicTopic().getPropertyValue());

				if (visualEvent.getDynamicTopic().getNamespaces() != null) {
					Map<String, String> map = visualEvent.getDynamicTopic()
							.getNamespaces();
					Iterator<Map.Entry<String, String>> entries = map
							.entrySet().iterator();
					while (entries.hasNext()) {
						Map.Entry<String, String> entry = entries.next();
						topicExpression.addNamespace(entry.getKey(),
								entry.getValue());
					}
				}

				topic = new Value(topicExpression);

			}

			eventMediator.setTopic(topic);

		}
		return eventMediator;
	}

}
