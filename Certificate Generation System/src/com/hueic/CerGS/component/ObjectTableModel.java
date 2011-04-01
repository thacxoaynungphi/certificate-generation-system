package com.hueic.CerGS.component;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * Get ObjectTableModel
 * @author Ngo Phuoc Thien
 */
public class ObjectTableModel extends AbstractTableModel {

    private JTable table;
    private ArrayList tableData;
    private ColumnData[] columns;
    private int headerTableSize = 22;

    /**
     * 
     * @param table the table where this model belong to
     * @param columns the columns of the table
     * @param tableData the ArrayList of entities need to display inside the table
     */
    public ObjectTableModel(JTable table, ColumnData[] columns, ArrayList tableData) {
        this.table = table;
        this.tableData = tableData;
        this.columns = columns;

        this.table.setFont(new Font("Tahoma", 0, 11));
        this.table.setRowHeight(18);
        this.table.setShowGrid(true);
        this.table.setModel(this);
        this.initTableColumns();
    }

    /**
     *
     * @param table the table where this model belong to
     * @param columns the columns of the table
     * @param tableData the ArrayList of entities need to display inside the table
     */
    public ObjectTableModel(JTable table, ColumnData[] columns, ArrayList tableData, int headerTableSize) {
        this.table = table;
        this.tableData = tableData;
        this.columns = columns;
        this.headerTableSize = headerTableSize;

        this.table.setFont(new Font("Tahoma", 0, 11));
        this.table.setRowHeight(18);
        this.table.setShowGrid(true);
        this.table.setModel(this);
        this.initTableColumns();
    }

    /**
     * Get the name of the column
     * @param index
     * @return String
     */
    @Override
    public String getColumnName(int index) {
        if (index == 0) {
            return "";
        }
        return " " + this.columns[index - 1].getTitle() + " ";
    }

    /**
     * Get number of the columns
     * @return int
     */
    public int getColumnCount() {
        return this.columns.length + 1;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        }
        Class cl = ((PropertyIndex) this.tableData.get(0)).getPropertyClass(this.getColumnPropertyIndex(columnIndex - 1));
        return cl;
    }

    /**
     * Get number of rows
     * @return int
     */
    public int getRowCount() {
        return this.tableData.size();
    }

    /**
     * Cell's Data
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return "" + (rowIndex + 1);
        }

        Object obj = ((PropertyIndex) this.tableData.get(rowIndex)).getPropertyValue(this.getColumnPropertyIndex(columnIndex - 1));
        return obj;
    }

    /**
     * Cell's Value
     * @param aValue
     * @param rowIndex
     * @param columnIndex
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (this.getColumnClass(columnIndex) == String.class) {
            super.setValueAt(aValue, rowIndex, columnIndex);
        } else {
            ((PropertyIndex) this.tableData.get(rowIndex)).setPropertyValue(this.getColumnPropertyIndex(columnIndex - 1), aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
        //TODO: ko cho chinh sua du lieu
        // return this.columns[columnIndex].isEditable();
    }

    private int getColumnPropertyIndex(int columnIndex) {
        return this.columns[columnIndex].getPropertyIndex();
    }

    public ArrayList getData() {
        return this.tableData;
    }

    private void initTableColumns() {
        if ((this.columns != null) & (this.columns.length > 0)) {
            for (int i = 0; i < this.columns.length; i++) {
                //doi tuong bieu dien thuoc tinh cot thu i, cot bat dau la 1
                TableColumn col = this.table.getColumnModel().getColumn(i + 1);
                ObjectTableCellRenderer cellRenderer = new ObjectTableCellRenderer();

                cellRenderer.setHorizontalAlignment(this.columns[i].getAlignment());
                col.setResizable(true);
                col.setMinWidth((this.columns[i]).getWidth());

                /**
                 * Set information for column i
                 */
                col.setCellRenderer(cellRenderer);

                /**
                 * Set information for column header
                 */
                ObjectTableHeaderRenderer headerRenderer = new ObjectTableHeaderRenderer(this.columns[i].getAlignment());
                col.setHeaderRenderer(headerRenderer);
            }

            /**
             * Delete identity column for main table
             */
            this.table.removeColumn(table.getColumnModel().getColumn(0));

            /**
             * Don't allow to change the order of column
             */
            this.table.getTableHeader().setReorderingAllowed(false);
        }
    }

    /**
     * 
     * @return the oder table (play the order column role) of the main table
     */
    public JTable getHeaderTable() {
        // Create a column model that will serve as our row header table. This
        // model picks a maximum width and only stores the first column.

        /**
         * Object control columns (header row)
         */
        TableColumnModel rowHeaderModel = new DefaultTableColumnModel() {

            boolean first = true;

            @Override
            public void addColumn(TableColumn tableColumn) {
                if (first) {
                    ObjectTableHeaderRenderer headerRenderer = new ObjectTableHeaderRenderer(true);
                    tableColumn.setHeaderRenderer(headerRenderer);

                    ObjectTableCellRenderer cellRenderer = new ObjectTableCellRenderer(true);
                    cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
                    tableColumn.setCellRenderer(cellRenderer);

                    tableColumn.setMaxWidth(headerTableSize);
                    super.addColumn(tableColumn);
                    first = false;
                }
            }
        };

        JTable headerTable = new JTable(ObjectTableModel.this, rowHeaderModel);
        this.table.setSelectionModel(headerTable.getSelectionModel());
        this.table.setFillsViewportHeight(true);
        headerTable.setFont(new Font("Tahoma", 0, 11));
        headerTable.setRowHeight(18);
        headerTable.setColumnSelectionAllowed(false);
        headerTable.setCellSelectionEnabled(false);
        headerTable.getTableHeader().setReorderingAllowed(false);
        headerTable.setShowGrid(true);

        return headerTable;
    }

    public void setObjects(ArrayList objects) {
        this.tableData = objects;
    }
}
