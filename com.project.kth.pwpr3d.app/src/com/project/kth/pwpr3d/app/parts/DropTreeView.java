package com.project.kth.pwpr3d.app.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;

import com.project.kth.pwpr3d.app.dragndrop.ContentProviderTree;
import com.project.kth.pwpr3d.app.drop.MyDropListener;
import com.project.kth.pwpr3d.app.drop.TreeContentProvider;
import com.project.kth.pwpr3d.app.drop.TreeLabelProvider;

public class DropTreeView {
	@PostConstruct
	  public void createPartControl(Composite parent) {
	
	    TreeViewer viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL);
	    int operations = DND.DROP_COPY | DND.DROP_MOVE;
	    Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
	    viewer.addDropSupport(operations, transferTypes, new MyDropListener(viewer));
	    viewer.setContentProvider(new TreeContentProvider());
	    viewer.setLabelProvider(new TreeLabelProvider());
	    viewer.setInput(ContentProviderTree.INSTANCE.getModelString());
	  }
}
