/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.view;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
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
        TableColumn<MyElement, Double> idCol = new TableColumn<>(Messages.Id.getMess());
        TableColumn<MyElement, Double> typeCol = new TableColumn<>(Messages.Type.getMess());
        TableColumn<MyElement, Double> xCol = new TableColumn<>(Messages.X.getMess());
        TableColumn<MyElement, Double> yCol = new TableColumn<>(Messages.Y.getMess());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("elementType"));
        xCol.setCellValueFactory(new PropertyValueFactory<>("refX"));
        yCol.setCellValueFactory(new PropertyValueFactory<>("refY"));
        tv.getColumns().addAll(idCol, typeCol, xCol, yCol);
        tv.setItems(elems);
        return tv;
    }

    @Override
    public void update(Observable o, Object o1) {
        try {
            Collection<MyElement> all = FacadeService.getService().all();
            elems.setAll(all);
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
    }

}
