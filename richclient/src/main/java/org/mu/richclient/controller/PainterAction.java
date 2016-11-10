/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import java.util.Observable;
import java.util.Observer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import org.mu.richclient.MyObservable;

public abstract class PainterAction implements Observer {

    String name;
 //   private MenuItem mi;
 //   Button btn;
    SimpleBooleanProperty disable = new SimpleBooleanProperty(false);

    public Button genButton() {
        Button btn = new Button(name);
        btn.setOnAction(event -> {
            execute();
        });
        btn.disableProperty().bind(disable);
        return btn;
    }

    public MenuItem genMenuItem() {
        MenuItem mi = new MenuItem(name);
        mi.disableProperty().bind(disable);
        mi.setOnAction(event -> {
            execute();
        });
        return mi;
    }

    abstract void execute();

    public PainterAction(String name) {
        this.name = name;
        MyObservable.INST.addObserver(this);
    }

    boolean checkDisable() {
        return false;
    }

    @Override
    public void update(Observable o, Object o1) {
        disable.setValue(checkDisable());
//        if (mi != null) {
//            mi.setDisable(disable);
//        }
//        if (btn != null) {
//            btn.setDisable(disable);
//        }

    }

}
