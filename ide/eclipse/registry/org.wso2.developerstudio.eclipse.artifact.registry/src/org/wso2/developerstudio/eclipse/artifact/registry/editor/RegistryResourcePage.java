package org.wso2.developerstudio.eclipse.artifact.registry.editor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class RegistryResourcePage extends FormPage {

	private Table artifactListTable;
	private Map<Integer,RegistryElement> itemMap;
    private GeneralProjectArtifact generalProjectArtifact;
    private boolean isSave;
    private GridData listGridData;
    private Table table;
    private FormToolkit toolkit;
    private TableEditor artifactNameEditor;
    private TableEditor registryPathEditor;
    private TableEditor mediaTypeEditor;
    private GridData tableGridData;
    private ScrolledForm form;
    private static final int INDEX_COLUMN = 0;
    private static final int ARTIFACT_NAME_COLUMN = 1;
    private static final int EDITABLE_COLUMN = 2;
    private static final int MEDIATYPE_COLUMN = 3;
    
	public RegistryResourcePage(String id, String title) {
		super(id, title);
	}

	public RegistryResourcePage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		form.setText("Registry Resource Editor");

		GridLayout layout = new GridLayout(); // layout for the form body
        layout.numColumns = 1;
        layout.marginWidth = 10;
        form.getBody().setLayout(layout);
        
        Section listSection = toolkit.createSection(form.getBody(), Section.EXPANDED |  Section.TITLE_BAR);
        listSection.setText("Artifact List");
        listSection.setBounds(40, 20, 220,100);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        listSection.setLayoutData(gd);
		
		Composite comp = toolkit.createComposite(listSection);
		GridLayout glcomp = new GridLayout(2,false);
		comp.setLayout(glcomp);
		listSection.setClient(comp);
		
		artifactListTable = toolkit.createTable(comp,  SWT.MULTI|SWT.FULL_SELECTION);
		artifactListTable.setBackground(SWTResourceManager.getColor(255, 255, 224));
		artifactListTable.setBounds(4, 2, 22, 10);
		 TableColumn tc1 = new TableColumn(artifactListTable, SWT.CENTER);
		    TableColumn tc2 = new TableColumn(artifactListTable, SWT.LEFT);
	        tc1.setResizable(false);
		    tc2.setText("Artifact List");
		    tc1.setWidth(0);
		    tc2.setWidth(1000);
//		    artifactListTable.setHeaderVisible(true);
		    
		    artifactNameEditor = new TableEditor(artifactListTable);
		    artifactNameEditor.setEditor(new Text(artifactListTable, SWT.BORDER));
		    artifactNameEditor.horizontalAlignment = SWT.LEFT;
		    artifactNameEditor.grabHorizontal = true;
		    artifactNameEditor.minimumWidth = 50;
		    
		    
			listGridData = new GridData(GridData.FILL_BOTH);
			listGridData.heightHint = 206;
			artifactListTable.setLayoutData(listGridData);
			new Label(comp, SWT.NONE);
			toolkit.paintBordersFor(comp);

		
	    Section tableSection = toolkit.createSection(form.getBody(), Section.EXPANDED |  Section.TITLE_BAR);
		tableSection.setText("Registry Resources' Deploy Paths");
		tableSection.setBounds(40, 20, 220,100);
	    tableSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Composite comp2 = toolkit.createComposite(tableSection);
		GridLayout glcomp2 = new GridLayout(3,false);
		comp2.setLayout(glcomp2);
		tableSection.setClient(comp2);
		createTable(comp2);
		new Label(comp2, SWT.NONE);
		addArtifactListListener();
		addTableListener();
		editorMain();
	}

	private void createTable(Composite comp){
		table = new Table(comp, SWT.MULTI|SWT.FULL_SELECTION);
		table.setSize(200, 200);
	    TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    TableColumn tc4 = new TableColumn(table, SWT.LEFT);
	    tc1.setText("index");
        tc1.setResizable(false);
	    tc2.setText("Resource Name");
	    tc3.setText("Resource Deploy Path");
	    tc4.setText("Media Type");
	    tc1.setWidth(0);
	    tc2.setWidth(200);
	    tc3.setWidth(250);
	    tc4.setWidth(200);
	    table.setHeaderVisible(true);
	    registryPathEditor = new TableEditor(table);
	    registryPathEditor.horizontalAlignment = SWT.LEFT;
	    registryPathEditor.grabHorizontal = true;
	    registryPathEditor.minimumWidth = 50;
	    
	    mediaTypeEditor = new TableEditor(table);
	    mediaTypeEditor.horizontalAlignment = SWT.LEFT;
	    mediaTypeEditor.grabHorizontal = true;
	    mediaTypeEditor.minimumWidth = 50;
	    
		listGridData = new GridData(GridData.FILL_BOTH);
		listGridData.heightHint = 206;
		table.setLayoutData(listGridData);
		new Label(comp, SWT.NONE);
		toolkit.paintBordersFor(comp);
		new Label(comp, SWT.NONE);
	}
	
	private void addArtifactListListener(){
		
		artifactListTable.addSelectionListener(new SelectionListener() {
		      public void widgetSelected(SelectionEvent event) {
		       addResourcesPath1();	  
             }
		      public void widgetDefaultSelected(SelectionEvent event) {
		        widgetSelected(event);
		      }
		    });
		
		artifactListTable.addListener(SWT.MouseDown, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				 // Clean up any previous editor control
		        Control oldEditor = artifactNameEditor.getEditor();
		        if (oldEditor != null){
		          oldEditor.dispose();  
		        }
		        TableItem[] selection = artifactListTable.getSelection();
		        
		        if(selection==null){
		        	return;
		        }
		        if(selection.length == 0 || selection.length>1){
		        	return;
		        }
		        TableItem item =selection[0];
		        if (item == null){
		        	  return;
		        }
		        final String olderText=item.getText(ARTIFACT_NAME_COLUMN);
		        Text newEditor = new Text(item.getParent(), SWT.NONE);
		        
		        newEditor.addKeyListener(new KeyListener() {
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						if(e.keyCode==SWT.CR){
							Control oldEditor = artifactNameEditor.getEditor();
					        if (oldEditor != null){
					          oldEditor.dispose();  
					        }
						}
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		        String newPath =item.getText(ARTIFACT_NAME_COLUMN);
		        final Integer index = Integer.parseInt(item.getText(INDEX_COLUMN));
		        newEditor.setText(newPath);
		        newEditor.addModifyListener(new ModifyListener() {
			          public void modifyText(ModifyEvent me) {
			        	setSave(true);  
			            Text text = (Text) artifactNameEditor.getEditor();
			            artifactNameEditor.getItem().setText(ARTIFACT_NAME_COLUMN, text.getText());
			            RegistryArtifact artifact = (RegistryArtifact)artifactListTable.getData(olderText);
			            artifact.setName(text.getText());
			            artifactListTable.setData(text.getText(), artifact);
//			            Control oldEditor = artifactNameEditor.getEditor();
//				        if (oldEditor != null){
//				          oldEditor.dispose();  
//				        }
				        artifactListTable.update();
				        artifactListTable.layout();
				        artifactListTable.redraw();
			            updateDirtyState();
			          }
			        });
		        
		        newEditor.selectAll();
		        newEditor.setFocus();
		        artifactNameEditor.setEditor(newEditor, item, ARTIFACT_NAME_COLUMN);
		        artifactListTable.redraw();
			}
		});

	}
	
	
	private void addResourcesPath1(){
		 table.removeAll();
	      if(registryPathEditor.getEditor() instanceof Text){
	         Text t =(Text)registryPathEditor.getEditor();
	         t.dispose();
	      } 
	      
	      if(mediaTypeEditor.getEditor() instanceof Text){
		         Text t =(Text)mediaTypeEditor.getEditor();
		         t.dispose();
		      } 

//	      String key = artifactList.getItem(artifactList.getSelectionIndex());
	      if(artifactListTable.getSelectionIndex()==-1){
	    	  return;
	      }
	      
	      TableItem selectionItem = artifactListTable.getItem(artifactListTable.getSelectionIndex());
	      String key = selectionItem.getText(ARTIFACT_NAME_COLUMN);
	      
	      RegistryArtifact artifact =(RegistryArtifact)artifactListTable.getData(key);
	      java.util.List<RegistryElement> elements = artifact.getAllRegistryItems();
	      itemMap = new HashMap<Integer, RegistryElement>();
	      int i=0;
	      for (RegistryElement registryElement : elements) {
	    	  i++;
	    	  String path = registryElement.getPath();
	    	  String name ="";
	    	  String mediaType=null;
	    	  if(registryElement instanceof RegistryItem){
	    		  name = ((RegistryItem)registryElement).getFile();
	    		  mediaType = ((RegistryItem)registryElement).getMediaType();
	    	  }else if(registryElement instanceof RegistryDump){
	    		  name = ((RegistryDump)registryElement).getFile();
	    	  }else{
	    		  name = ((RegistryCollection)registryElement).getDirectory();
	    	  }
	    	  TableItem item = new TableItem(table, SWT.NONE);
	    	  String index =""+i;
	          item.setText(new String[] {index, name, path, mediaType });
	      	
	  		final Color red = form.getDisplay().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT);
	     	final  Color blue = form.getDisplay().getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT);
	          if(i%2 == 0){
	        	  item.setBackground(red);
	          }else {
	        	  item.setBackground(blue);
	          } 

            table.layout();
	          itemMap.put(i, registryElement);
		}

	}

	private void addTableListener(){
		
		  table.addListener(SWT.MouseUp, new Listener() {
				
				public void handleEvent(Event event) {
					
					 // Clean up any previous editor control
			        Control oldEditor = registryPathEditor.getEditor();
			        Control oldEditor1 = mediaTypeEditor.getEditor();
			        if (oldEditor != null){
			          oldEditor.dispose();  
			        }
			        if (oldEditor1 != null){
			        	oldEditor1.dispose();  
				        }
			        TableItem[] selection = table.getSelection();
			        
			        if(selection==null){
			        	return;
			        }
			        if(selection.length == 0 || selection.length>1){
			        	return;
			        }
			        TableItem item =selection[0];
			        if (item == null){
			        	  return;
			        }
			        Text newEditor = new Text(table, SWT.NONE);
			        String newPath =item.getText(EDITABLE_COLUMN);
			        Text newMTEditor = new Text(table, SWT.NONE);
			        String newMediatype =item.getText(MEDIATYPE_COLUMN);
			        final Integer index = Integer.parseInt(item.getText(INDEX_COLUMN));
			        newEditor.setText(newPath);
			        newEditor.addModifyListener(new ModifyListener() {
				          public void modifyText(ModifyEvent me) {
				        	setSave(true);  
				            Text text = (Text) registryPathEditor.getEditor();
				            registryPathEditor.getItem().setText(EDITABLE_COLUMN, text.getText());
				            RegistryElement registryElement = itemMap.get(index);
				            registryElement.setPath(text.getText());
				            updateDirtyState();
				          }
				        });
			        
			        newMTEditor.setText(newMediatype);
			        newMTEditor.addModifyListener(new ModifyListener() {
				          public void modifyText(ModifyEvent me) {
				        	setSave(true);  
				            Text text = (Text) mediaTypeEditor.getEditor();
				            mediaTypeEditor.getItem().setText(MEDIATYPE_COLUMN, text.getText());
				            RegistryElement registryElement = itemMap.get(index);
				            if(registryElement instanceof RegistryItem){
				            	((RegistryItem)registryElement).setMediaType(text.getText());
				            	updateDirtyState();
				            }
				          }
				        });
			        newEditor.selectAll();
			        newEditor.setFocus();
			        registryPathEditor.setEditor(newEditor, item, EDITABLE_COLUMN);
			        newMTEditor.selectAll();
			        newMTEditor.setFocus();
			        mediaTypeEditor.setEditor(newMTEditor, item, MEDIATYPE_COLUMN);
			        table.redraw();
				}
			}); 
	}
	
	public void editorMain(){
		   try {
			    FileEditorInput fileInput = (FileEditorInput)getEditorInput();
			    fileInput.getFile().getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			    File artifactXml =  fileInput.getFile().getLocation().toFile();
                generalProjectArtifact=new GeneralProjectArtifact();
			    generalProjectArtifact.fromFile(artifactXml);
			    java.util.List<RegistryArtifact> regArtifact = generalProjectArtifact.getAllArtifacts();
			    int i=0;
			    for (RegistryArtifact artifact : regArtifact) {
			    	i++;
			    	 TableItem item = new TableItem(artifactListTable, SWT.NONE);
			    	  String index =""+i;
			          item.setText(new String[] {index, artifact.getName() });
			          artifactListTable.setData(artifact.getName(), artifact);
		    	}
		      } catch (Exception e) {
			  e.printStackTrace();
		  }
	   }
  
	public void doPageSave(){
		try {
			generalProjectArtifact.toFile();
			setSave(false);
			((ResourceFormEditor)getEditor()).setDirty(false);
			updateDirtyState();
			addResourcesPath1();
			((FileEditorInput) getEditorInput()).getFile().getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		 } catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public void updateDirtyState() {
		ResourceFormEditor editor = (ResourceFormEditor)getEditor();
		editor.setDirty(isSave());
		firePropertyChange(PROP_DIRTY);
		editor.editorDirtyStateChanged();	    
    }
	
	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}

	public boolean isSave() {
		return isSave;
	}
	
}
