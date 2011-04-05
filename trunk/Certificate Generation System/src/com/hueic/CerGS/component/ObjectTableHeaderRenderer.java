package com.hueic.CerGS.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.table.TableCellRenderer;

/**
 * Object format cells' properties
 * @author nhchung
 */
public class ObjectTableHeaderRenderer extends JLabel implements TableCellRenderer {

    private boolean isOrderColumn = false;

    public ObjectTableHeaderRenderer() {
    }

    public ObjectTableHeaderRenderer(int alignment) {
        setSize(getSize().width, 50);
        setHorizontalAlignment(alignment);
        setFont(new Font("Tahoma", Font.PLAIN, 11));
        setHorizontalTextPosition(LEFT);
    }

    public ObjectTableHeaderRenderer(boolean isOrderColumn) {
        this.isOrderColumn = isOrderColumn;
        setSize(18, 22);
    }

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (this.isOrderColumn) {
            this.setText(null);
        } else {
            this.setText((String) value);
        }

        table.getTableHeader().setBackground(Color.WHITE);
        this.setFont(new Font("Tahoma", Font.PLAIN, 11));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
                Color.WHITE,
                Color.WHITE,
                new Color(51, 51, 51),
                Color.WHITE));

        return this;
    }
}
