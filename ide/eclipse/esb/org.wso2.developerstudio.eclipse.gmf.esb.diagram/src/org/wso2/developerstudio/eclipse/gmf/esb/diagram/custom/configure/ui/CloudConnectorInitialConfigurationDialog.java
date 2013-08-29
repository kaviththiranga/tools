package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.sequence.model.SequenceModel;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.factory.SequenceFileCreator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CloudConnectorInitialConfigurationDialog extends Dialog {
    /**
     * Value type constant.
     */
	private static final String VALUE_TYPE = "Value";
	/**
	 * Expression type constant.
	 */
	private static final String EXPRESSION_TYPE = "Expression";
	/**
	 * Table for add/edit/remove parameters.
	 */
	private Table paramTable;
	
	protected static final OMFactory fac = OMAbstractFactory.getOMFactory();
	protected static final OMNamespace synNS = SynapseConstants.SYNAPSE_OMNAMESPACE;

	private static String connectorName="twilio";
	private static String operationName = "configure";
	
	private TableEditor paramTypeEditor;
	private TableEditor paramNameEditor;
	private TableEditor paramValueEditor;
	
	private Combo cmbParamType;
	private Text txtParamName;
	private PropertyText paramValue;
	
	private Text nameText;
	private Label configurationNameLabel;
	private String configName;
	private Collection<String> parameters;
	private Label saveOptionLabel;
	private Combo saveOptionCombo;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public CloudConnectorInitialConfigurationDialog(Shell parent,Collection<String> parameters) {
		super(parent);
		this.parameters=parameters;
		parent.setText("Cloud connector Configuration.");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		
		configurationNameLabel = new Label(container, SWT.NONE);
		{
			configurationNameLabel.setText("Name: ");
			FormData logCategoryLabelLayoutData = new FormData(80,SWT.DEFAULT);
			logCategoryLabelLayoutData.top = new FormAttachment(0, 10);
			logCategoryLabelLayoutData.left = new FormAttachment(0);
			configurationNameLabel.setLayoutData(logCategoryLabelLayoutData);
		}
		
		
		// Button for add new parameter.
		nameText = new Text(container, SWT.NONE);
		{
			FormData logCategoryLabelLayoutData = new FormData(160,SWT.DEFAULT);
			logCategoryLabelLayoutData.top = new FormAttachment(
					configurationNameLabel, 0, SWT.CENTER);
			logCategoryLabelLayoutData.left = new FormAttachment(
					configurationNameLabel, 5);
			nameText.setLayoutData(logCategoryLabelLayoutData);
		}
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				configName=nameText.getText();
			}
		});
		
		
		saveOptionLabel = new Label(container, SWT.NONE);
		{
			saveOptionLabel.setText("Save as : ");
			FormData logCategoryLabelLayoutData1 = new FormData(80,SWT.DEFAULT);
			logCategoryLabelLayoutData1.top = new FormAttachment(configurationNameLabel, 20);
			logCategoryLabelLayoutData1.left = new FormAttachment(0);
			saveOptionLabel.setLayoutData(logCategoryLabelLayoutData1);
		}
		
		saveOptionCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		{
			saveOptionCombo.add("Inline Config");
			saveOptionCombo.add("Sequence Config");
			saveOptionCombo.select(0);
			FormData logCategoryComboLayoutData = new FormData(160,SWT.DEFAULT);
			logCategoryComboLayoutData.top = new FormAttachment(
					saveOptionLabel, 0, SWT.CENTER);
			logCategoryComboLayoutData.left = new FormAttachment(
					saveOptionLabel, 5);
			saveOptionCombo.setLayoutData(logCategoryComboLayoutData);
		}

		// Table for show the parameters.
		paramTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn nameColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn typeColumn = new TableColumn(paramTable, SWT.LEFT);
		nameColumn.setText("Parameter Name");
		nameColumn.setWidth(150);
		valueColumn.setText("Value/Expression");
		valueColumn.setWidth(200);
		typeColumn.setText("Parameter Type");
		typeColumn.setWidth(150);

		paramTable.setHeaderVisible(true);
		paramTable.setLinesVisible(true);

		Listener tblPropertiesListener = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						editItem(item);
					}
				}
			}
		};

		paramTable.addListener(SWT.Selection, tblPropertiesListener);

		for (String param : parameters) {
			CallTemplateParameter callTemplateParameter=EsbFactory.eINSTANCE.createCallTemplateParameter();
			callTemplateParameter.setParameterName(param);
			callTemplateParameter.setParameterValue("");
			callTemplateParameter.setTemplateParameterType(RuleOptionType.VALUE);
			bindPram(callTemplateParameter);
		}

		//setupTableEditor(paramTable);

		FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
		logPropertiesTableLayoutData.top = new FormAttachment(saveOptionLabel, 20);
		logPropertiesTableLayoutData.left = new FormAttachment(0);
		logPropertiesTableLayoutData.bottom = new FormAttachment(100);
		paramTable.setLayoutData(logPropertiesTableLayoutData);

		return parent;
	}
	
	private TableItem bindPram(CallTemplateParameter param) {
		TableItem item = new TableItem(paramTable, SWT.NONE);
		if (param.getTemplateParameterType().getLiteral().equals(VALUE_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getParameterValue(),
					param.getTemplateParameterType().getLiteral() });
		}
		if (param.getTemplateParameterType().getLiteral()
				.equals(EXPRESSION_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getParameterExpression().getPropertyValue(),
					param.getTemplateParameterType().getLiteral()});
		}

		item.setData(param);
		item.setData("exp", EsbFactory.eINSTANCE.copyNamespacedProperty(param.getParameterExpression()));
		return item;
	}
	
	private TableEditor initTableEditor(TableEditor editor, Table table) {
		if (null != editor) {
			Control lastCtrl = editor.getEditor();
			if (null != lastCtrl) {
				lastCtrl.dispose();
			}
		}
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		return editor;
	}
	
	private void editItem(final TableItem item) {
		
		NamespacedProperty expression = (NamespacedProperty)item.getData("exp");
		
		paramNameEditor = initTableEditor(paramNameEditor, item.getParent());
		txtParamName = new Text(item.getParent(), SWT.NONE);
		txtParamName.setText(item.getText(0));
		paramNameEditor.setEditor(txtParamName, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtParamName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0,txtParamName.getText());
			}
		});
		
		paramTypeEditor = initTableEditor(paramTypeEditor,
				item.getParent());
		cmbParamType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbParamType.setItems(new String[] { VALUE_TYPE, EXPRESSION_TYPE });
		cmbParamType.setText(item.getText(2));
		paramTypeEditor.setEditor(cmbParamType, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		cmbParamType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(2, cmbParamType.getText());
			}
		});
		
		paramValueEditor = initTableEditor(paramValueEditor,
				item.getParent());
		
		paramValue = new PropertyText(item.getParent(), SWT.NONE, cmbParamType);
		paramValue.addProperties(item.getText(1),expression);
		paramValueEditor.setEditor(paramValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		paramValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(1,paramValue.getText());
				Object property = paramValue.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("exp",(NamespacedProperty)property);
				} 
			}
		});
	}
	
    private void serializeParams(OMElement invokeElem) {
    	OMElement connectorEl = fac.createOMElement(connectorName+"."+operationName,synNS);
    	for(int i=0;i<paramTable.getItems().length;++i){
    		TableItem tableItem=paramTable.getItems()[i];
    		CallTemplateParameter callTemplateParameter=(CallTemplateParameter) tableItem.getData();    		
            if (!"".equals(callTemplateParameter.getParameterName())) {
                OMElement paramEl = fac.createOMElement(callTemplateParameter.getParameterName(),
                                                        synNS);
                paramEl.setText(tableItem.getText(1));
               // new ValueSerializer().serializeValue(value, "value", paramEl);
                connectorEl.addChild(paramEl);
            }
        }
    	invokeElem.addChild(connectorEl);
    }
	
	
	@Override
	protected void okPressed() {
		
		SequenceModel sequenceModel=new SequenceModel();
        IContainer location = EditorUtils.getActiveProject().getFolder("src" + File.separator + "main"
				+ File.separator + "synapse-config" + File.separator
				+ "sequences");
		sequenceModel.setSequenceSaveLocation(location);
		sequenceModel.setSequenceName(configName);
		try {
			sequenceModel.setSelectedOption("");
			SequenceFileCreator sequenceFileCreator=new SequenceFileCreator(sequenceModel);
			String content="<?xml version=\"1.0\" encoding=\"UTF-8\"?><sequence xmlns=\"http://ws.apache.org/ns/synapse\" name=\""+configName+"\"/>";
			
			OMElement payload = AXIOMUtil.stringToOM(content); 
			serializeParams(payload);
			
			sequenceFileCreator.createSequenceFile(payload.toString());
		} catch (Exception e) {
			log.error("Error occured while creating the sequence file", e);
		}
		
		Display.getCurrent().asyncExec(new Runnable() {			
			public void run() {
				IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getEditorReferences();
				IEditorPart activeEditor=PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
				for (int i = 0; i < editorReferences.length; i++) {
					IEditorPart editor = editorReferences[i].getEditor(false);
					if ((editor instanceof EsbMultiPageEditor)) {
				        /*
				         * This must be altered. 'addDefinedSequences' and 'addDefinedEndpoints' methods should not exist inside EsbPaletteFactory class. 
				         * Creating new instance of 'EsbPaletteFactory' must be avoided.
				         */
						EsbPaletteFactory esbPaletteFactory=new EsbPaletteFactory();
						if(!editor.equals(activeEditor)){					        
					        //esbPaletteFactory.addDefinedSequences(((EsbMultiPageEditor) editor).getGraphicalEditor());
					        //esbPaletteFactory.addDefinedEndpoints(((EsbMultiPageEditor) editor).getGraphicalEditor());					        
						}else{
							esbPaletteFactory.addCloudConnectorOperations(((EsbMultiPageEditor) editor).getGraphicalEditor(),configName);
						}
					}
				}
			}
		});
		super.okPressed();
	}
	
}