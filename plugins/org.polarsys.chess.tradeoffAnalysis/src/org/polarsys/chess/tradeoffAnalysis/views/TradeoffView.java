/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.tradeoffAnalysis.views;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.polarsys.chess.tradeoffAnalysis.commands.TradeoffCommand.Row;

/**
 * A View that contains a table used to show trade-off results of a certain analysis.
 * 
 * @author cristofo
 *
 */
public class TradeoffView extends ViewPart {
	public static final String ID = "org.polarsys.chess.tradeoffAnalysis.views.TradeoffView";

	private TableViewer viewer;
	private Composite parent;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		final GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		createViewer(parent);
	}

	private void createViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(ArrayContentProvider.getInstance());
		getSite().setSelectionProvider(viewer);

		// Layout the viewer
		final GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
		
		table.addListener(SWT.MouseDoubleClick, new Listener(){
			@Override
	        public void handleEvent(Event event){
	            Point pt = new Point(event.x, event.y);
	            TableItem item = table.getItem(pt);
	            if(item != null) {
	                for (int col = 0; col < table.getColumnCount(); col++) {
	                    Rectangle rect = item.getBounds(col);
	                    if (rect.contains(pt)) {
	                        System.out.println("item clicked.");
	                        System.out.println("column is " + col);
	                    }
	                }
	            }
	        }
	    });
		
		
		table.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							System.out.println("Item " + index + "-" + i);
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});

	}
	
	public void createColumns(TableViewer viewer, List<String> labels) {

		// Remove the existing columns, if any
		final TableColumn[] columns = viewer.getTable().getColumns();
		for (TableColumn tableColumn : columns) {
			tableColumn.dispose();
		}
		
		// Create the new columns
		createColumns(parent, viewer, labels);
	}
	
	private void createColumns(final Composite parent, final TableViewer viewer, List<String> labels) {

		int index = 0;	// Counter for the columns
		
		for (String label : labels) {
			final TableViewerColumn col = createTableViewerColumn(viewer, label, 150, index);		
			col.setLabelProvider(new IndexedColumnLabelProvider(index++));
		}
	}

	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, 
			int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();

		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		//column.addSelectionListener(getSelectionAdapter(column, colNumber));
		return viewerColumn;
	}

	@Override
	public void setFocus() {
	}

	public TableViewer getViewer() {
		return viewer;
	}

	/**
	 * This is a new provider that returns different contents based on
	 * the columns index.
	 * 
	 * @author cristofo
	 *
	 */
	private class IndexedColumnLabelProvider extends ColumnLabelProvider {
		private int index;

		public IndexedColumnLabelProvider(int index) {
			this.index = index;
		}

		@Override
		public String getText(Object element) {
			Row request = (Row) element;
			if (index == 0) {
				return request.getContractName();
			} else if (index == 1) {
				return request.getConcerns();
			} else if (index > 1){			
				return request.getResults().get(index - 2).getCheckResult();
			} else {
				return null;
			}
		}
	}
}