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
public class MyElement {

    private final MyElementId id;
    protected double refX;
    protected double refY;
    

    public MyElement(MyElementId id, double refX, double refY) {
        this.id = id;
        this.refX = refX;
        this.refY = refY;
    }

    public double getRefX() {
        return refX;
    }

    /**
     * @return the refY
     */
    public double getRefY() {
        return refY;
    }

    public MyElementId getId() {
        return id;
    }

}
