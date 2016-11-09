/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.model;

public class MyRectangle extends MyElement {

    protected double width;
    protected double height;

    public MyRectangle(MyElementId id, double refX, double refY, double width, double height) {
        super(id, refX, refY);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("MyRectangle[%f, %f, %f, %f]", refX, refY, width, height);
    }

}
