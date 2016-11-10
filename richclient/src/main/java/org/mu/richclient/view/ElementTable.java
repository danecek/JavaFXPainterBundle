/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.view;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mu.business.FacadeService;
import org.mu.model.MyElement;
import org.mu.richclient.MyObservable;
import org.mu.richclient.view.MyAlert;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

public class ElementTable extends TitledPane implements Observer {
    
    ObservableList<MyElement> elems = FXCollections.observableArrayList();
    
    public ElementTable() {
        MyObservable.INST.addObserver(this);
        setText(Messages.Elements.getMess());
        setContent(createContent());
    }
    
    private Node createContent() {
        TableView tv = new TableView();
        TableColumn<MyElement, Double> xCol = new TableColumn<>("X");
        TableColumn<MyElement, Double> yCol = new TableColumn<>("Y");
        xCol.setCellValueFactory(new PropertyValueFactory<>("refX"));
        yCol.setCellValueFactory(new PropertyValueFactory<>("refY"));
        tv.getColumns().addAll(xCol, yCol);
        tv.setItems(elems);
        return tv;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        try {
            Collection<MyElement> all = FacadeService.getService().all();
            System.out.println(all);
            elems.setAll(all);
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
    }
    
}
