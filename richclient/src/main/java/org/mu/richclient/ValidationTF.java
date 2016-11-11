/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Administrator
 */
public class ValidationTF extends TextField {

    public ValidationTF(PainterDialog crd) {
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                crd.validate();
            }
        });
    }

    public ValidationTF(PainterDialog crd, String text) {
        this(crd);
        setText(text);
    }

}
