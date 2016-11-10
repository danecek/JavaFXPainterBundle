/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import org.mu.richclient.MyObservable;

/**
 *
 * @author Administrator
 */
public abstract class PainterAction implements Observer {

    String name;
    private MenuItem mi;
    Button btn;

    public Button genButton() {
        btn = new Button(name);
        btn.setOnAction(event -> {
            execute();
        });
        return btn;
    }

    MenuItem genMenuItem() {
        mi = new MenuItem(name);
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
        boolean disable = checkDisable();
        if (mi != null) {
            mi.setDisable(disable);
        }
        if (btn != null) {
            btn.setDisable(disable);
        }

    }

}
