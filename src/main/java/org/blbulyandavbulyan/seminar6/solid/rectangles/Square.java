package org.blbulyandavbulyan.seminar6.solid.rectangles;

public class Square extends AbstractRectangle {
    public void setSide(int a){
        super.setWidth(a);
        super.setHeight(a);
    }
}