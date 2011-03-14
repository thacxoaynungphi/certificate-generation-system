package com.hueic.CerGS.component;




import javax.swing.SwingConstants;


public class ColumnData implements SwingConstants {

    public static byte DEFAULT_RENDERER = 0;
    public static byte BOOLEAN_RENDERER = 1;
    private String title;
    private int width;
    private int alignment;
    private byte renderer = DEFAULT_RENDERER;
    private int propertyIndex;
    private boolean editable;
    private String tooltip;

    public ColumnData(String title, int width, int alignment, int propertyIndex) {
        this.setTitle(title);
        this.setWidth(width);
        this.setAlignment(alignment);
        this.setPropertyIndex(propertyIndex);
        this.setEditable(false);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public int getPropertyIndex() {
        return propertyIndex;
    }

    public void setPropertyIndex(int propertyIndex) {
        this.propertyIndex = propertyIndex;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public byte getRenderer() {
        return renderer;
    }

    public void setRenderer(byte renderer) {
        this.renderer = renderer;
    }
}
