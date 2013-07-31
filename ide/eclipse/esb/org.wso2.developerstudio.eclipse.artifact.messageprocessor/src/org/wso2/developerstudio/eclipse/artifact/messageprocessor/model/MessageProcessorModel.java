/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messageprocessor.model;

import static org.wso2.developerstudio.eclipse.platform.core.utils.Constants.ESB_PROJECT_NATURE;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.Activator;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

/**
 * The model class for message-processor artifact wizard specific objects.
 */

public class MessageProcessorModel extends ProjectDataModel {

	private String messageProcessorName;
	private String messageProcessorType;
	private String messageStore;
	private String retryInterval;
	private String configurationFilePath;
	private String cronExpression;
	private String pinnedServers;
	private String deliveryAttempts;
	private String clientRepository;
	private String axis2Configuration;
	private String replySequenceName;
	private String FaultSequenceName;
	private String sequence;
	private String classFQN;
	private IContainer saveLocation;
	private HashMap<String, String> customProcessorParameters = new HashMap<String, String>();
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private List<OMElement> availableProcessorlist;
	private List<OMElement> selectedProcessorList;

	public MessageProcessorModel() {
		availableProcessorlist = new ArrayList<OMElement>();
		selectedProcessorList = new ArrayList<OMElement>();
		messageProcessorType = "Scheduled Message Forwarding Processor";
		retryInterval = "1000";
		deliveryAttempts = "-1";
	}

	public String getMessageProcessorName() {
		return messageProcessorName;
	}

	public String getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(String messageStore) {
		this.messageStore = messageStore;
	}

	public void setMessageProcessorName(String messageProcessorName) {
		this.messageProcessorName = messageProcessorName;
	}

	public String getMessageProcessorType() {
		return messageProcessorType;
	}

	public void setMessageProcessorType(String messageProcessorType) {
		this.messageProcessorType = messageProcessorType;
	}

	public String getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(String retryInterval) {
		this.retryInterval = retryInterval;
	}

	public String getConfigurationFilePath() {
		return configurationFilePath;
	}

	public void setConfigurationFilePath(String configurationFilePath) {
		this.configurationFilePath = configurationFilePath;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getPinnedServers() {
		return pinnedServers;
	}

	public void setPinnedServers(String pinnedServers) {
		this.pinnedServers = pinnedServers;
	}

	public String getDeliveryAttempts() {
		return deliveryAttempts;
	}

	public void setDeliveryAttempts(String deliveryAttempts) {
		this.deliveryAttempts = deliveryAttempts;
	}

	public String getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(String clientRepository) {
		this.clientRepository = clientRepository;
	}

	public String getAxis2Configuration() {
		return axis2Configuration;
	}

	public void setAxis2Configuration(String axis2Configuration) {
		this.axis2Configuration = axis2Configuration;
	}

	public String getReplySequenceName() {
		return replySequenceName;
	}

	public void setReplySequenceName(String replySequenceName) {
		this.replySequenceName = replySequenceName;
	}

	public String getFaultSequenceName() {
		return FaultSequenceName;
	}

	public void setFaultSequenceName(String faultSequenceName) {
		FaultSequenceName = faultSequenceName;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getClassFQN() {
		return classFQN;
	}

	public void setClassFQN(String classFQN) {
		this.classFQN = classFQN;
	}

	public IContainer getSaveLocation() {
		return saveLocation;
	}

	public void setSaveLocation(IContainer saveLocation) {
		this.saveLocation = saveLocation;
	}

	public HashMap<String, String> getCustomProcessorParameters() {
		return customProcessorParameters;
	}

	public List<OMElement> getAvailableProcessorlist() {
		return availableProcessorlist;
	}

	public void setAvailableProcessorlist(List<OMElement> availableProcessorlist) {
		this.availableProcessorlist = availableProcessorlist;
	}

	public List<OMElement> getSelectedProcessorList() {
		return selectedProcessorList;
	}

	public void setSelectedProcessorList(List<OMElement> selectedProcessorList) {
		this.selectedProcessorList = selectedProcessorList;
	}

	@Override
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);

		if (modelPropertyValue == null) {
			if (key.equals("processor.name")) {
				modelPropertyValue = getMessageProcessorName();
			} else if (key.equals("processor.type")) {
				modelPropertyValue = getMessageProcessorType();
			} else if (key.equals("processor.stroe")) {
				modelPropertyValue = getMessageStore();
			} else if (key.equals("FS_processor.retry_interval")) {
				modelPropertyValue = getRetryInterval();
			} else if (key.equals("FS_processor.configuration_file_path")) {
				modelPropertyValue = getConfigurationFilePath();
			} else if (key.equals("FS_processor.cron_expression")) {
				modelPropertyValue = getCronExpression();
			} else if (key.equals("FS_processor.pinned_servers")) {
				modelPropertyValue = getPinnedServers();
			} else if (key.equals("Forwarding_processor.delivery_attempts")) {
				modelPropertyValue = getDeliveryAttempts();
			} else if (key.equals("Forwarding_processor.client_repository")) {
				modelPropertyValue = getClientRepository();
			} else if (key.equals("Forwarding_processor.axis2_configuration")) {
				modelPropertyValue = getAxis2Configuration();
			} else if (key.equals("Forwarding_processor.Reply_sequence_name")) {
				modelPropertyValue = getReplySequenceName();
			} else if (key.equals("Forwarding_processor.Fault_sequence_name")) {
				modelPropertyValue = getFaultSequenceName();
			} else if (key.equals("sampling_processor.sequence")) {
				modelPropertyValue = getSequence();
			} else if (key.equals("custom_processor.class_FQN")) {
				modelPropertyValue = getClassFQN();
			} else if (key.equals("save.location")) {
				modelPropertyValue = getSaveLocation();
			} else if (key.equals("available.processors")) {
				if (selectedProcessorList != null) {
					modelPropertyValue = selectedProcessorList.toArray();
				}
			}
		}

		return modelPropertyValue;
	}

	@Override
	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);

		if (key.equals("processor.name")) {
			setMessageProcessorName(data.toString());
		} else if (key.equals("processor.type")) {
			setMessageProcessorType(data.toString());
		} else if (key.equals("processor.stroe")) {
			setMessageStore(data.toString());
		} else if (key.equals("FS_processor.retry_interval")) {
			setRetryInterval(data.toString());
		} else if (key.equals("FS_processor.configuration_file_path")) {
			setConfigurationFilePath(data.toString());
		} else if (key.equals("FS_processor.cron_expression")) {
			setCronExpression(data.toString());
		} else if (key.equals("FS_processor.pinned_servers")) {
			setPinnedServers(data.toString());
		} else if (key.equals("Forwarding_processor.delivery_attempts")) {
			setDeliveryAttempts(data.toString());
		} else if (key.equals("Forwarding_processor.client_repository")) {
			setClientRepository(data.toString());
		} else if (key.equals("Forwarding_processor.axis2_configuration")) {
			setAxis2Configuration(data.toString());
		} else if (key.equals("Forwarding_processor.Reply_sequence_name")) {
			setReplySequenceName(data.toString());
		} else if (key.equals("Forwarding_processor.Fault_sequence_name")) {
			setFaultSequenceName(data.toString());
		} else if (key.equals("sampling_processor.sequence")) {
			setSequence(data.toString());
		} else if (key.equals("custom_processor.class_FQN")) {
			setClassFQN(data.toString());
		} else if (key.equals("create.esb.prj")) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell);
			if (esbProject != null) {
				setSaveLocation(esbProject);
			}
		} else if (key.equals("save.location")) {
			setSaveLocation((IContainer) data);
		} else if (key.equals("import.file")) {
			if (getImportFile() != null
					&& !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableProcessors = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
							SynapseEntryType.MESSAGE_PROCESSOR)) {
						availableProcessors = SynapseFileUtils
								.synapseFileProcessing(getImportFile()
										.getPath(),
										SynapseEntryType.MESSAGE_PROCESSOR);
						setAvailableProcessorlist(availableProcessors);
					} else {
						setAvailableProcessorlist(new ArrayList<OMElement>());
					}
					returnValue = false;
				} catch (OMException e) {
					log.error("Error reading object model", e);
				} catch (XMLStreamException e) {
					log.error("XML stream error", e);
				} catch (IOException e) {
					log.error("I/O error has occurred", e);
				} catch (Exception e) {
					log.error("An unexpected error has occurred", e);
				}
			}
		} else if (key.equals("available.processors")) {
			Object[] selectedStores = (Object[]) data;
			selectedProcessorList.clear();
			for (Object object : selectedStores) {
				if (object instanceof OMElement) {
					if (!selectedProcessorList.contains((OMElement) object)) {
						selectedProcessorList.add((OMElement) object);
					}
				}
			}
		}

		return returnValue;
	}

	@Override
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getSaveLocation() == null && absolutionPath != null) {
			IContainer newSaveLocation = getContainer(absolutionPath,
					ESB_PROJECT_NATURE);
			setSaveLocation(newSaveLocation);
		}
	}

	public static IContainer getContainer(File absolutionPath,
			String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString()
							.length();
					if (projectLocationLength > length
							&& projectLocationLength <= absolutionPath
									.toString().length()) {
						if (absolutionPath.toString().startsWith(
								projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				log.error("An unexpected error has occurred", e);
			}
		}
		IContainer newSaveLocation = null;
		if (currentSelection != null) {
			String path = absolutionPath.toString()
					.substring(
							currentSelection.getLocation().toFile().toString()
									.length());

			if (path.equals("")) {
				newSaveLocation = currentSelection;
			} else {
				newSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newSaveLocation;
	}

}
