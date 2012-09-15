package org.wso2.developerstudio.eclipse.artifact.brs.editor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.maven.project.MavenProject;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.w3c.dom.Document;
import org.wso2.carbon.rule.common.Operation;
import org.wso2.carbon.rule.common.Rule;
import org.wso2.carbon.rule.common.RuleService;
import org.wso2.carbon.rule.common.config.RuleServiceHelper;
import org.wso2.carbon.rule.common.exception.RuleConfigurationException;
import org.wso2.developerstudio.eclipse.artifact.brs.ui.dialog.OperationDialog;
import org.wso2.developerstudio.eclipse.artifact.brs.ui.dialog.RuleServiceDialog;
import org.wso2.developerstudio.eclipse.artifact.brs.utils.RuleServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*Creates the design view page*/

public class RuleServiceEditorPage extends FormPage {

	private RuleService ruleservice;
	private IFile rslFileRes;
	private File brsTemplateFile;
	private boolean pageDirty;
	private String serviceName = " ";
	private String targetNameSpace = " ";
	private String scope = " ";
	private Text txtServiceName;
	private Text txtTargetNameSpace;
	private TableViewer viewer;
	private TableViewer operationTableViewer;
	private Action refreshAction;
	private Action exportAction;
	private MavenProject parentPrj;
	private Table inputTable;
	private Table operationTable;
	private int tableIndex;
	private int operationTableIndex;
	private Combo comboScope;


	public RuleServiceEditorPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		ruleservice = new RuleService();
	}

	public void initContent() throws XMLStreamException, IOException, RuleConfigurationException {
		String outputFileLocation;
		rslFileRes = ((IFileEditorInput) (getEditor().getEditorInput()))
				.getFile();
		outputFileLocation=rslFileRes.getLocation().toFile().getAbsolutePath();
		brsTemplateFile=new File(outputFileLocation);
		ruleservice=readRSLFile(outputFileLocation);
	}

	@Override
	protected void createFormContent(final IManagedForm managedform) {
		FormToolkit toolkit;
		ScrolledForm form;
		Composite body;

		try {
			initContent();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuleConfigurationException e) {
			e.printStackTrace();
		}

		/*managedform.getForm().setImage(
		                               SWTResourceManager.getImage(this.getClass(),
		                            		   "/icons/brs-project-12.png"));*/

		toolkit = managedform.getToolkit();
		form = managedform.getForm();
		form.setText(RuleServiceArtifactConstants.FORM_NAME);
		form.getToolBarManager().add(getRefreshAction());
		form.getToolBarManager().add(getExportAction());
		body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		managedform.getForm().getBody().setLayout(new GridLayout(4, false));
		managedform.getToolkit().createLabel(managedform.getForm().getBody(),
		                                     "Service name", SWT.NONE);
		txtServiceName = managedform.getToolkit().createText(
		                                                     managedform.getForm().getBody(),
		                                                     ruleservice.getName(), SWT.NONE);
		setServiceName(ruleservice.getName());
		GridData gd_txtServiceName = new GridData(SWT.LEFT, SWT.CENTER, true,
		                                          false, 3, 1);
		gd_txtServiceName.widthHint = 460;
		txtServiceName.setLayoutData(gd_txtServiceName);
		txtServiceName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				setPageDirty(true);
				setServiceName(txtServiceName.getText().trim());
				updateDirtyState();
			}
		});

		managedform.getToolkit().createLabel(managedform.getForm().getBody(),
		                                     "Target Name Space", SWT.NONE);
		txtTargetNameSpace = managedform.getToolkit().createText(
		                                                         managedform.getForm().getBody(),
		                                                         ruleservice.getTargetNamespace(), SWT.NONE);
		setTargetNameSpace(ruleservice.getTargetNamespace());
		GridData gd_txtTargetNameSpace = new GridData(SWT.LEFT, SWT.CENTER,
		                                              true, false, 3, 1);
		gd_txtTargetNameSpace.widthHint = 460;
		txtTargetNameSpace.setLayoutData(gd_txtTargetNameSpace);
		txtTargetNameSpace.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				setPageDirty(true);
				setTargetNameSpace(txtTargetNameSpace.getText().trim());
				updateDirtyState();
			}
		});

		managedform.getToolkit().createLabel(managedform.getForm().getBody(),
		                                     "Scope", SWT.NONE);
		comboScope = new Combo(managedform.getForm().getBody(), SWT.READ_ONLY);
		comboScope.setItems(new String[] { "Request", "Transport Session", "Soap Session","Application"," "});
		setScope(ruleservice.getScope());
		GridData gd_txtScope = new GridData(SWT.LEFT, SWT.CENTER, true, false,
		                                    3, 1);
		gd_txtScope.widthHint = 465;
		comboScope.setLayoutData(gd_txtScope);
		String scope=ruleservice.getScope();

		if(scope!=null){
			comboScope.setText(ruleservice.getScope());
		}
		else
			comboScope.setText(" ");
		comboScope.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				setPageDirty(true);
				setScope(comboScope.getText().trim());
				updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		Label operationLabel=managedform.getToolkit().createLabel(managedform.getForm().getBody(), RuleServiceArtifactConstants.NEW_LINE, SWT.NONE);
		GridData operationData=new GridData();
		operationData.horizontalSpan=4;
		operationLabel.setLayoutData(operationData);

		Section sctnDependencies = managedform.getToolkit().createSection(
		                                                                  managedform.getForm().getBody(),
		                                                                  Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_sctnNewSection = new GridData(SWT.FILL, SWT.CENTER, true,
		                                          false, 4, 1);
		sctnDependencies.setText("Rules");
		sctnDependencies.setLayoutData(gd_sctnNewSection);
		sctnDependencies.setExpanded(true);
		Composite composite = managedform.getToolkit().createComposite(sctnDependencies, SWT.NONE);
		sctnDependencies.setClient(composite);
		composite.setLayout(new GridLayout(4, false));

		createInputTable(composite, managedform);

		GridData addButtonGridData=new GridData();
		addButtonGridData.horizontalSpan=1;
		addButtonGridData.verticalSpan=1;
		addButtonGridData.verticalIndent=20;
		addButtonGridData.widthHint=100;

		Button addButton=managedform.getToolkit().createButton(composite, RuleServiceArtifactConstants.ADD_BUTTON_LABEL, SWT.NONE);
		addButton.setLayoutData(addButtonGridData);

		GridData editButtonGridData=new GridData();
		editButtonGridData.horizontalSpan=1;
		editButtonGridData.verticalSpan=1;
		editButtonGridData.widthHint=100;

		Button editButton=managedform.getToolkit().createButton(composite, RuleServiceArtifactConstants.EDIT_BUTTON_LABEL, SWT.NONE);
		editButton.setLayoutData(editButtonGridData);

		GridData deleteButtonGridData=new GridData();
		deleteButtonGridData.horizontalSpan=1;
		deleteButtonGridData.verticalSpan=1;
		deleteButtonGridData.verticalIndent=-30;
		deleteButtonGridData.widthHint=100;

		Button deleteButton=managedform.getToolkit().createButton(composite, RuleServiceArtifactConstants.DELETE_BUTTON_LABEL, SWT.NONE);
		deleteButton.setLayoutData(deleteButtonGridData);

		addButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				RuleServiceDialog rDialog=new RuleServiceDialog(Display.getCurrent().getActiveShell(),ruleservice);
				rDialog.open();
				updateInputTable();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		editButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				RuleServiceDialog rDialog=new RuleServiceDialog(Display.getCurrent().getActiveShell(),ruleservice);
				editInputTable(rDialog);
				rDialog.open();
				updateInputTable();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		deleteButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				deleteInputTable();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		Label space2=managedform.getToolkit().createLabel(managedform.getForm().getBody(), RuleServiceArtifactConstants.NEW_LINE, SWT.NONE);
		GridData space2nData=new GridData();
		space2nData.horizontalSpan=4;
		space2.setLayoutData(space2nData);

		Section operationsctnDependencies = managedform.getToolkit().createSection(
		                                                                           managedform.getForm().getBody(),
		                                                                           Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_operationsctnNewSection = new GridData(SWT.FILL, SWT.CENTER, true,
		                                                   false, 4, 1);
		operationsctnDependencies.setText("Operation:");
		operationsctnDependencies.setLayoutData(gd_operationsctnNewSection);
		operationsctnDependencies.setExpanded(true);
		Composite opcomposite = managedform.getToolkit().createComposite(operationsctnDependencies, SWT.NONE);
		operationsctnDependencies.setClient(opcomposite);
		opcomposite.setLayout(new GridLayout(4, false));

		createOperationTable(opcomposite, managedform);

		GridData addOperationButtonGridData=new GridData();
		addOperationButtonGridData.horizontalSpan=3;
		addOperationButtonGridData.verticalSpan=1;
		addOperationButtonGridData.verticalIndent=20;
		addOperationButtonGridData.widthHint=100;

		Button addOperationButton=managedform.getToolkit().createButton(opcomposite, RuleServiceArtifactConstants.ADD_BUTTON_LABEL, SWT.NONE);
		addOperationButton.setLayoutData(addOperationButtonGridData);

		GridData editOperationButtonGridData=new GridData();
		editOperationButtonGridData.horizontalSpan=3;
		editOperationButtonGridData.verticalSpan=1;

		editOperationButtonGridData.widthHint=100;

		Button editOperationButton=managedform.getToolkit().createButton(opcomposite, RuleServiceArtifactConstants.EDIT_BUTTON_LABEL, SWT.NONE);
		editOperationButton.setLayoutData(editOperationButtonGridData);

		GridData deleteOperationButtonGridData=new GridData();
		deleteOperationButtonGridData.horizontalSpan=3;
		deleteOperationButtonGridData.verticalSpan=1;
		deleteOperationButtonGridData.verticalIndent=-30;
		deleteOperationButtonGridData.widthHint=100;


		Button deleteOperationButton=managedform.getToolkit().createButton(opcomposite, RuleServiceArtifactConstants.DELETE_BUTTON_LABEL, SWT.NONE);
		deleteOperationButton.setLayoutData(deleteOperationButtonGridData);

		addOperationButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				OperationDialog oDialog=new OperationDialog(Display.getCurrent().getActiveShell(),ruleservice);
				oDialog.open();
				updateOperationTable();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		editOperationButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				OperationDialog oDialog=new OperationDialog(Display.getCurrent().getActiveShell(),ruleservice);
				editOperationTable(oDialog);
				oDialog.open();
				updateOperationTable();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		deleteOperationButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				deleteOperationtable();
				setPageDirty(true);
				updateDirtyState();
			}
		});
	}

	@Override
	public boolean isDirty() {
		return isPageDirty();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

	public void saveRSL() throws
	IOException  {
		ruleservice.setScope(getScope());
		writeToSourceFile();
		setPageDirty(false);
		try {
			rslFileRes.getProject().refreshLocal(IResource.DEPTH_INFINITE,
			                                     new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeToSourceFile() throws
	IOException {
		String templateContent = ruleservice.toOM().toString();
		try {
			templateContent = format(templateContent);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		templateContent = templateContent.replace(
		                                          RuleServiceArtifactConstants.XML_ENCODING, "");
		FileUtils.writeContent(brsTemplateFile, templateContent);
	}

	private String format(String unformattedXML)
			throws SAXException, IOException {
		Document document = null;
		try {
			document = parseXMLFile(unformattedXML);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		OutputFormat outputFormat = new OutputFormat(document);
		outputFormat.setLineWidth(65);
		outputFormat.setIndenting(true);
		outputFormat.setIndent(2);
		Writer writer = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(writer, outputFormat);
		serializer.serialize(document);

		return writer.toString();
	}

	private Document parseXMLFile(String input)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		InputSource inputSource = new InputSource(new StringReader(input));
		return documentBuilder.parse(inputSource);
	}

	public void refreshForm() throws XMLStreamException,  IOException, RuleConfigurationException {
		initContent();

		txtServiceName.setText(ruleservice.getName());
		txtTargetNameSpace.setText(ruleservice.getTargetNamespace());
		comboScope.setText(ruleservice.getScope());
		viewer.setInput(ruleservice.getRuleSet().getRules().toArray());
		operationTableViewer.setInput(ruleservice.getOperations().toArray());
	}

	private RuleService readRSLFile(String path) throws XMLStreamException, IOException, RuleConfigurationException{

		File rslFile=new File(path);
		BufferedInputStream bufferedInputStream=null;
		OMElement ruleserviceOMElement=null;
		bufferedInputStream=new BufferedInputStream(new FileInputStream(rslFile));
		XMLStreamReader xmlStreamReader=XMLInputFactory.newInstance().createXMLStreamReader(bufferedInputStream);
		StAXOMBuilder staxOMBuilder=new StAXOMBuilder(xmlStreamReader);
		ruleserviceOMElement=staxOMBuilder.getDocumentElement();
		ruleserviceOMElement.build();
		bufferedInputStream.close();
		RuleService ruleserviceFromFile=RuleServiceHelper.getRuleService(ruleserviceOMElement);

		return ruleserviceFromFile;
	}

	public Action getRefreshAction() {

		if (refreshAction == null) {
			refreshAction = new Action("Refresh",
			                           ImageDescriptor.createFromImage(SWTResourceManager
			                                                           .getImage(this.getClass(), "/icons/refresh.png"))) {
				@Override
				public void run() {

					try {
						refreshForm();
					} catch (XMLStreamException e) {
						e.printStackTrace();
					} catch (FactoryConfigurationError e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (RuleConfigurationException e) {
						e.printStackTrace();
					}

					setPageDirty(false);
					updateDirtyState();
				};
			};
			refreshAction.setToolTipText("Refresh");
		}

		return refreshAction;
	}

	public Action getExportAction() {

		if (exportAction == null) {
			exportAction = new Action("Create Archive",
			                          ImageDescriptor.createFromImage(SWTResourceManager
			                                                          .getImage(this.getClass(), "/icons/car.png"))) {
				@Override
				public void run() {
					try {
						exportCar();
					} catch (Exception e) {

						e.printStackTrace();
					}
				};
			};
			exportAction.setToolTipText("Create Archive");
		}

		return exportAction;
	}

	public void exportCar() throws Exception {

		MessageBox exportMsg = new MessageBox(PlatformUI.getWorkbench()
		                                      .getActiveWorkbenchWindow().getShell(), SWT.ICON_INFORMATION);
		exportMsg.setText("Wso2 Platform BRS");
		String finalFileName = String.format("%s_%s.car", parentPrj.getModel()
		                                     .getArtifactId(), parentPrj.getVersion());
		saveRSL();
		IResource carbonArchive = ExportUtil.BuildCAppProject(rslFileRes
		                                                      .getProject());
		DirectoryDialog dirDlg = new DirectoryDialog(PlatformUI.getWorkbench()
		                                             .getActiveWorkbenchWindow().getShell());
		String dirName = dirDlg.open();
		if (dirName != null) {
			File destFileName = new File(dirName, finalFileName);

			FileUtils.copy(carbonArchive.getLocation().toFile(), destFileName);

		}

	}

	public void updateDirtyState() {
		((RuleServiceEditor) getEditor()).updateDirtyState();
	}

	public void createInputTable(Composite composite,IManagedForm managedform){

		final Table table=managedform.getToolkit().createTable(composite, SWT.MULTI | SWT.H_SCROLL
		                                                       | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER| SWT.VIRTUAL);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		inputTable=table;
		viewer=new TableViewer(table);
		table.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 3, 3));
		createColumns( viewer);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(ruleservice.getRuleSet().getRules().toArray());
		table.setItemCount(5);
	}

	private void createColumns(TableViewer viewer){

		TableViewerColumn descriptionColumn=new TableViewerColumn(viewer, SWT.NONE, 0);
		descriptionColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Rule rule=(Rule) element;

				if(rule!=null){
					return rule.getDescription();
				}
				else return " ";
			}
		});

		descriptionColumn.getColumn().setWidth(200);
		descriptionColumn.getColumn().setText("Description");

		TableViewerColumn resourceColumn=new TableViewerColumn(viewer, SWT.NONE, 1);
		resourceColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Rule rule=(Rule) element;

				if(rule!=null){
					return rule.getResourceType();
				}
				else return " ";
			}
		});
		resourceColumn.getColumn().setWidth(200);
		resourceColumn.getColumn().setText("Resource Type");

		TableViewerColumn sourceColumn=new TableViewerColumn(viewer, SWT.NONE, 2);
		sourceColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Rule rule=(Rule) element;

				if(rule!=null){
					return rule.getSourceType();
				}
				else return " ";
			}
		});
		sourceColumn.getColumn().setWidth(200);
		sourceColumn.getColumn().setText("Source Type");
	}

	public void createOperationTable(Composite composite,IManagedForm managedform){
		final Table table=managedform.getToolkit().createTable(composite, SWT.MULTI | SWT.H_SCROLL
		                                                       | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER| SWT.VIRTUAL);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		operationTable=table;
		operationTableViewer =new TableViewer(table);
		table.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 3));
		createOperationTableColumns(operationTableViewer);
		operationTableViewer.setContentProvider(new ArrayContentProvider());
		operationTableViewer.setInput(ruleservice.getOperations().toArray());
		table.setItemCount(5);
	}

	private void createOperationTableColumns(TableViewer operationtableviewer){
		TableViewerColumn nameColumn=new TableViewerColumn(operationtableviewer, SWT.NONE, 0);
		nameColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Operation operation=(Operation) element;

				if(operation!=null){
					return operation.getName();
				}
				else return " ";
			}
		});
		nameColumn.getColumn().setWidth(200);
		nameColumn.getColumn().setText("name");
	}

	private void updateInputTable(){
		viewer.setInput(ruleservice.getRuleSet().getRules().toArray());
		viewer.refresh();
	}

	private void editInputTable(RuleServiceDialog rdialog){
		tableIndex=inputTable.getSelectionIndex();
		rdialog.editEditorInputTable(tableIndex);
	}

	private void deleteInputTable(){
		int tableIndex;

		tableIndex=inputTable.getSelectionIndex();
		ruleservice.getRuleSet().getRules().remove(tableIndex);
		viewer.setInput(ruleservice.getRuleSet().getRules().toArray());
		viewer.refresh();
	}

	private void updateOperationTable(){
		operationTableViewer.setInput(ruleservice.getOperations().toArray());
		operationTableViewer.refresh();
	}

	private void editOperationTable(OperationDialog odialog){
		operationTableIndex=operationTable.getSelectionIndex();
		odialog.editEditorOperationTable(operationTableIndex);
	}

	private void deleteOperationtable(){
		operationTableIndex=operationTable.getSelectionIndex();
		ruleservice.getOperations().remove(operationTableIndex);
		operationTableViewer.setInput(ruleservice.getOperations().toArray());
		operationTableViewer.refresh();
	}

	public void setPageDirty(boolean isPageDirty) {
		this.pageDirty = isPageDirty;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getTargetNameSpace() {
		return targetNameSpace;
	}

	public String getScope() {
		return scope;
	}

	public void setServiceName(String servicename) {
		this.serviceName = servicename;

	}

	public void setTargetNameSpace(String targetnamespace) {
		this.targetNameSpace = targetnamespace;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}