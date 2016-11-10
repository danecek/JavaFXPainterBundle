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

    /**
     * @param id the id to set
     */
    public void setId(MyElementId id) {
        this.id = id;
    }

    /**
     * @return the elementType
     */
    public ElementType getElementType() {
        return elementType;
    }

    protected MyElementId id;
    protected final ElementType elementType;
    protected final double refX;
    protected final double refY;

    public MyElement(ElementType elementType, double refX, double refY) {
        this.elementType = elementType;
        this.refX = refX;
        this.refY = refY;
    }

    public MyElement(MyElementId id, ElementType elementType, double refX, double refY) {
        this(elementType, refX, refY);
        this.id = id;
    }

    public double getRefX() {
        return refX;
    }

    public double getRefY() {
        return refY;
    }

    public MyElementId getId() {
        return id;
    }

}
