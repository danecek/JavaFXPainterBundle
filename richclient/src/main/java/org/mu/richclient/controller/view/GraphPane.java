/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller.view;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.TitledPane;
import javafx.scene.shape.Rectangle;
import org.mu.utils.Messages;

public class GraphPane extends TitledPane implements Observer{

    double refX;
    double refY;
    Rectangle s;

    public GraphPane() {
        setPrefSize(1000, 1000);
        setText(Messages.Graph.getMess());
        setOnMousePressed(event -> {
            refX = event.getX();
            refY = event.getY();
            s = new Rectangle(refX, refY, 1, 1);
            getChildren().add(s);
        });
        setOnMouseDragged(event -> {
            s.setWidth(event.getX() - refX);   // s.widthProperty().set(refX);
            s.setHeight(event.getY() - refY);
        });
    }

    @Override
    public void update(Observable o, Object o1) {
    }
    

}
