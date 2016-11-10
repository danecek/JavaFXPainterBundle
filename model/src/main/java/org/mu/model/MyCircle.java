/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.model;

/**
 *
 * @author Administrator
 */
public class MyCircle extends MyElement {

    protected double radius;

    public MyCircle(MyElementId id, double refX, double refY, double radius) {
        super(id, ElementType.Circle, refX, refY);
        this.radius = radius;
    }

    public MyCircle(double refX, double refY, double radius) {
        super(ElementType.Circle, refX, refY);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

}
