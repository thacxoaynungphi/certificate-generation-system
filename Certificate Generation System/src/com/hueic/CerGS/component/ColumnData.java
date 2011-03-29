package com.hueic.CerGS.component;

import javax.swing.SwingConstants;

/**
 * Set Columns for the display table
 * @author Ngo Phuoc Thien
 */
public class ColumnData implements SwingConstants {
    private static byte DEFAULT_RENDERER = 0;
    private static byte BOOLEAN_RENDERER = 1;
    
    private String title;
    private int width;
    private int alignment;
    private byte renderer = DEFAULT_RENDERER;
    private int propertyIndex;
    private boolean editable;
    private String tooltip;

    /**
     * Parameters Constructor
     * @param title
     * @param width
     * @param alignment
     * @param propertyIndex
     */
    public ColumnData(String title, int width, int alignment, int propertyIndex) {
        this.setTitle(title);
        this.setWidth(width);
        this.setAlignment(alignment);
        this.setPropertyIndex(propertyIndex);
        this.setEditable(false);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the alignment
     */
    public int getAlignment() {
        return alignment;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    /**
     * @return the renderer
     */
    public byte getRenderer() {
        return renderer;
    }

    /**
     * @param renderer the renderer to set
     */
    public void setRenderer(byte renderer) {
        this.renderer = renderer;
    }

    /**
     * @return the propertyIndex
     */
    public int getPropertyIndex() {
        return propertyIndex;
    }

    /**
     * @param propertyIndex the propertyIndex to set
     */
    public void setPropertyIndex(int propertyIndex) {
        this.propertyIndex = propertyIndex;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the tooltip
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * @param tooltip the tooltip to set
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }    
}
