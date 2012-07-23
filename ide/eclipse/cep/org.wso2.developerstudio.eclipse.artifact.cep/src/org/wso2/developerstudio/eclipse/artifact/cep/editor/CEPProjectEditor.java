package org.wso2.developerstudio.eclipse.artifact.cep.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.artifact.cep.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class CEPProjectEditor extends FormEditor {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private CEPProjectEditorPage cepProjectEditorPage;
	private StructuredTextEditor sourceEditor;
	private boolean dirty;
	private boolean sourceDirty;
	private int formEditorIndex;
	private int sourceEditorIndex;

	protected void addPages() {
		cepProjectEditorPage = new CEPProjectEditorPage(this,
				"org.wso2.developerstudio.eclipse.artifact.cep.project.editor",
				"Design");

		sourceEditor = new StructuredTextEditor();
		sourceEditor.setEditorPart(this);

		try {
			cepProjectEditorPage.initContent();
			formEditorIndex = addPage(cepProjectEditorPage);
			sourceEditorIndex = addPage(sourceEditor, getEditorInput());
			setPageText(sourceEditorIndex, "Source");

			getDocument().addDocumentListener(new IDocumentListener() {

				public void documentAboutToBeChanged(final DocumentEvent event) {
					// nothing to do
				}

				public void documentChanged(final DocumentEvent event) {
					sourceDirty = true;
					updateDirtyState();
				}
			});

			if (getFile() != null) {
				setTitle(getFile().toString().replaceFirst("^L/", ""));
			}

		} catch (PartInitException e) {
			log.error("Page init error has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

	}

	public void doSave(IProgressMonitor pm) {
		if (dirty) {
			try {
				updateSourceFromDesign();
				sourceDirty = false;
				dirty = false;
				updateDirtyState();
			} catch (Exception e) {
				log.error("An unexpected error has occurred", e);
			}
		} else if (sourceDirty) {
			sourceDirty = false;
			dirty = false;
			updateDesignFromSource();
			updateDirtyState();
		}
	}

	private IDocument getDocument() {
		final IDocumentProvider provider = sourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}

	protected void pageChange(int newPageIndex) {

		if ((newPageIndex == sourceEditorIndex)) {
			sourceDirty = false;
			dirty = false;
			updateSourceFromDesign();
			updateDirtyState();

		} else if ((newPageIndex == formEditorIndex && (sourceDirty))) {
			sourceDirty = false;
			dirty = false;
			updateDesignFromSource();
			updateDirtyState();

		}

		super.pageChange(newPageIndex);

		final IFormPage page = getActivePageInstance();
		if (page != null) {
			page.setFocus();
		}
	}

	private void updateSourceFromDesign() {
		String content;
		try {
			cepProjectEditorPage.saveConfigurationFile();
			content = new Scanner(getFile().getContents()).useDelimiter("\\A")
					.next();
			getDocument().set(content);

		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
	}

	private void updateDesignFromSource() {

		try {

			InputStream content = new ByteArrayInputStream(getDocument().get()
					.getBytes());
			getFile().setContents(content, true, true, null);
            content.close();
            cepProjectEditorPage.refreshForm();
		} catch (Exception e) {
			
			e.printStackTrace();
			MessageDialog.openError(null, "Error", "Syntax Error in Source File");
		}

	}

	private IFile getFile() {
		final IEditorInput input = getEditorInput();
		if (input instanceof FileEditorInput)
			return ((FileEditorInput) input).getFile();
		return null;
	}

	public StructuredTextEditor getSourceEditor() {
		return sourceEditor;
	}

	public void doSaveAs() {
		// nothing to do
	}

	public void updateDirtyState() {
		dirty = cepProjectEditorPage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();
	}

	public boolean isDirty() {
		return (dirty || sourceDirty);
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

}
