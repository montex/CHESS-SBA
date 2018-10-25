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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;

import eu.fbk.tools.adapter.ocra.CheckContractRefinement;

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
	
	/**
	 * Shows the detailed result displaying the result file in a different view.
	 * @param row the clicked row
	 */
	private void displayResult(Row row) {
		if (row.getAnalysisName() != null && row.getResultFilePath() != null) {
			AnalysisResultUtil.getInstance().showResult(CheckContractRefinement.FUNCTION_NAME, row.getResultFilePath());
		}
	}

	/**
	 * Creates the table viewer.
	 * @param parent the Composite parent
	 */
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
		
		// Add a listener to show the detailed results
	    viewer.addDoubleClickListener(new IDoubleClickListener() {
	        @Override
	        public void doubleClick(DoubleClickEvent event) {
	            final IStructuredSelection selection = (IStructuredSelection)event.getSelection();
	            if( selection == null ) {
	            	return;
	            }

	            final Object row = selection.getFirstElement();
	            if (row instanceof Row) {
	            	displayResult((Row) row);
	            }
	        }
	    });
	}
	
	/**
	 * Creates the columns given the labels.
	 * @param viewer the TableViewer
	 * @param labels the list of labels for the columns
	 */
	public void createColumns(TableViewer viewer, List<String> labels) {

		// Remove the existing columns, if any
		final TableColumn[] columns = viewer.getTable().getColumns();
		for (TableColumn tableColumn : columns) {
			tableColumn.dispose();
		}
		
		// Create the new columns
		createColumns(parent, viewer, labels);
	}
	
	/**
	 * Creates the columns given the labels.
	 * @param parent the parent Composite
	 * @param viewer the TableViewer
	 * @param labels the list of labels for the columns
	 */
	private void createColumns(final Composite parent, final TableViewer viewer, List<String> labels) {
		int columnNumber = 0;	// Counter for the columns
		
		for (String label : labels) {
			final TableViewerColumn col = createTableViewerColumn(viewer, label, columnNumber);		
			col.setLabelProvider(new IndexedColumnLabelProvider(columnNumber++));
		}
	}

	/**
	 * Creates a column given its label.
	 * @param viewer the TableViewer
	 * @param label the name of the column
	 * @param colNumber the number of the column
	 * @return
	 */
	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String label, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();

		column.setText(label);

		switch (colNumber) {
		case 0:
			column.setWidth(150);	// Configurations name
			break;
		case 1:
			column.setWidth(0);		// Hidden field for analysis name
			break;
		case 2:
			column.setWidth(0);		// Hidden field for file name
			break;
		default:
			column.setWidth(200);	// Contracts name
			break;
		}
		
		column.setResizable(true);
		column.setMoveable(true);
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
	 * the columns number.
	 * 
	 * @author cristofo
	 *
	 */
	private class IndexedColumnLabelProvider extends ColumnLabelProvider {
		private int columnNumber;
		Color redColor;
		Color greenColor;

		/**
		 * Creates a provider for the column and stores its number.
		 * @param columnNumber the number of the column
		 */
		public IndexedColumnLabelProvider(int columnNumber) {
			super();
			this.columnNumber = columnNumber;
			greenColor = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
		    redColor = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED);
		}
		
		@Override
		public Color getForeground(Object element) {
			final Row request = (Row) element;
			if (columnNumber > 2) {
				if (request.getResults().get(columnNumber - 3).equals("Success")) {
					return greenColor;
				} else if (request.getResults().get(columnNumber - 3).equals("NOT OK")) {
					return redColor;
				}
			}
			return super.getForeground(element);
		}

		@Override
		public String getText(Object element) {
			final Row request = (Row) element;
			if (columnNumber == 0) {
				return request.getRowName();
			} else if (columnNumber == 1) {
				return request.getAnalysisName();
			} else if (columnNumber == 2) {
				return request.getResultFilePath();
			} else if (columnNumber > 2){			
				return request.getResults().get(columnNumber - 3);
			} else {
				return null;
			}
		}
	}
	
	/**
	 * Class that represent a single line of the table.
	 * 
	 * @author cristofo
	 *
	 */
	public static class Row {
		private String rowName;
		private String analysisName;
		private String resultFilePath;
		private List<String> results;

		/**
		 * Constructs a new row with the given name (leftmost column).
		 * @param rowName the name of the row
		 */
		public Row(String rowName) {
			this.rowName = rowName;
			results = new ArrayList<String>();
		}
		
		public String getRowName() {
			return rowName;
		}

		public void setRowName(String rowName) {
			this.rowName = rowName;
		}

		public String getAnalysisName() {
			return analysisName;
		}

		public void setAnalysisName(String analysisName) {
			this.analysisName = analysisName;
		}

		public String getResultFilePath() {
			return resultFilePath;
		}

		public void setResultFilePath(String resultFilePath) {
			this.resultFilePath = resultFilePath;
		}

		public void addResult(String result) {
			results.add(result);
		}
		
		public List<String> getResults() {
			return results;
		}
	}	
}