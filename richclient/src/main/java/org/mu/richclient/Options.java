/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import javafx.beans.property.SimpleObjectProperty;
import org.mu.model.ElementType;

/**
 *
 * @author Administrator
 */
public class Options {

    public static Options INST = new Options();

    private SimpleObjectProperty<ElementType> elementType
            = new SimpleObjectProperty<>(ElementType.Rectangle);

    public SimpleObjectProperty<ElementType> elementTypeProperty() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType.set(elementType);
    }

    public ElementType getElementType() {
        return elementType.get();
    }

    private Options() {
    }

}
