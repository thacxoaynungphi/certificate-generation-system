package com.hueic.CerGS.component;



/*
 * GridCellRenderer.java
 *
 * Created on October 27, 2006, 9:59 AM
 */

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
//doi tuong hien thi o trong bang
public class ObjectTableCellRenderer extends DefaultTableCellRenderer {

    protected Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);
    protected Border focusBorder = UIManager.getBorder("Table.focusCellHighlightBorder");
    private Color cellFocused = Color.WHITE;
    boolean isOrderCell = false;

    /** Creates a new instance of GridCellRenderer */
    public ObjectTableCellRenderer() {
    }

    public ObjectTableCellRenderer(boolean isOrderCell) {
        this.isOrderCell = isOrderCell;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component component = super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);

        if (table != null) {
            if (isSelected) {
                if (hasFocus && table.isCellEditable(row, column)) {
                    this.setBorder(focusBorder);
                } else {
                    this.setBorder(noFocusBorder);
                }
                if (this.isOrderCell) {
                    this.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                    this.setBackground(this.cellFocused);
                }
            } else {
                if (this.isOrderCell) {
                    this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                            Color.WHITE,
                            Color.WHITE,
                            new Color(51, 51, 51),
                            Color.WHITE));
                    this.setSize(this.getMaximumSize());
                }
                this.setBackground(this.cellFocused);
            }
        }
        //them vao se bi loi, kiem tra lai
        //((JLabel) component).setText(" " + value.toString());

        if (value instanceof Boolean) {
            if (((Boolean) value).booleanValue()) {
                // Xu ly check box
            } else {
                // Xu ly checkbox
            }
        }
        if (value instanceof String) {
            // Cột số thứ tự thì ga'n ten cot
            if (this.isOrderCell) {
                ((JLabel) component).setBackground(this.cellFocused);
                ((JLabel) component).setText(value.toString());
            }
        }

        return component;
    }
}