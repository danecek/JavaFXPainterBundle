/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import org.mu.business.FacadeService;
import org.mu.model.MyElement;
import org.mu.model.MyElementId;
import org.mu.model.MyRectangle;
import org.mu.utils.PainterException;

public class Presenter {

    ObservableList<Node> ol;
    private Rectangle newRect;
    static int counter;

    public Presenter(ObservableList<Node> ol) {
        this.ol = ol;
    }

    void createRect(double refX, double refY) {
        newRect = new Rectangle(refX, refY, 1, 1);
        ol.add(newRect);
    }

    Rectangle gr(MyRectangle mr) {
        return new Rectangle(mr.getRefX(), mr.getRefY(), mr.getWidth(), mr.getHeight());
    }

    void finish() {
        try {
        FacadeService.getService().create(new MyRectangle(new MyElementId(counter++),
                newRect.getX(), newRect.getY(), newRect.getWidth(),
                newRect.getArcHeight()
        ));
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
    }

    void setDim(double x, double y) {
        double width = x - newRect.getX();
        double height = y - newRect.getY();
        newRect.setWidth(width);
        newRect.setHeight(height);
    }

    void refresh() {
        try {
            ol.clear();
            for (MyElement me : FacadeService.getService().all()) {
                ol.add(gr((MyRectangle) me));
            }
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
    }

}
