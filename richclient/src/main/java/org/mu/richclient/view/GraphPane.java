/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.view;

import org.mu.richclient.MyAlert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.mu.business.FacadeService;
import static org.mu.model.ElementType.Circle;
import org.mu.model.MyCircle;
import org.mu.model.MyElement;
import org.mu.model.MyRectangle;
import org.mu.richclient.MyObservable;
import org.mu.richclient.Options;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

public class GraphPane extends TitledPane implements Observer {

    Shape s;

    public GraphPane() {
        MyObservable.INST.addObserver(this);
        setPrefSize(1000, 1000);
        setText(Messages.Graph.getMess());
        setOnMousePressed(event -> {
            press(event);

        });
        setOnMouseDragged(event -> {
            drag(event);
        });
        setOnMouseReleased((event) -> {
            released(event);
        });
    }

    @Override
    public void update(Observable o, Object o1) {
        try {
            getChildren().setAll(createShapes());
        } catch (PainterException ex) {
            Logger.getLogger(GraphPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Collection<Shape> createShapes() throws PainterException {
        Collection<Shape> shapes = new ArrayList<>();
        for (MyElement me : FacadeService.getService().all()) {
            switch (me.getElementType()) {
                case Circle: {
                    MyCircle c = (MyCircle) me;
                    shapes.add(new Circle(me.getRefX(), me.getRefY(), c.getRadius()));
                    break;

                }
                case Rectangle: {
                    MyRectangle r = (MyRectangle) me;
                    shapes.add(new Rectangle(me.getRefX(), me.getRefY(),
                            r.getWidth(), r.getHeight()));
                    break;
                }
            }
        }
        return shapes;
    }

    private void press(MouseEvent me) {
        double refX = me.getX();
        double refY = me.getY();
        switch (Options.INST.getElementType()) {
            case Rectangle: {
                s = new Rectangle(refX, refY, 1, 1);
                break;
            }
            case Circle: {
                s = new Circle(refX, refY, 1);
                break;
            }
        }
        getChildren().add(s);
    }

    private void drag(MouseEvent me) {
        switch (Options.INST.getElementType()) {
            case Rectangle: {
                Rectangle r = (Rectangle) s;
                r.setWidth(me.getX() - r.getX());
                r.setHeight(me.getY() - r.getY());
                break;
            }
            case Circle: {
                Circle c = (Circle) s;
                double dx = me.getX() - c.getCenterX();
                double dy = me.getY() - c.getCenterY();
                c.setRadius(Math.sqrt(dx * dx + dy * dy));
                break;
            }
        }
    }

    private void released(MouseEvent event) {
        MyElement me = null;
        switch (Options.INST.getElementType()) {
            case Rectangle: {
                Rectangle r = (Rectangle) s;
                me = new MyRectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
                break;
            }
            case Circle: {
                Circle c = (Circle) s;
                me = new MyCircle(c.getCenterX(), c.getCenterY(), c.getRadius());
                break;
            }
        }
        try {
            FacadeService.getService().create(me);
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
        MyObservable.INST.changed();
    }

}
