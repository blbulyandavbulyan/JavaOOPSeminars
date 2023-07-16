package org.blbulyandavbulyan.seminar6.solid.rectangles;

public abstract class AbstractRectangle {
    protected int width;
    protected int height;
    public int area() {
        return this.width * this.height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
