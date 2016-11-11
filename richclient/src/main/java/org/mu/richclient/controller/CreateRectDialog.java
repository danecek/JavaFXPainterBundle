/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import org.mu.richclient.ValidationTF;
import org.mu.richclient.PainterDialog;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.mu.business.FacadeService;
import org.mu.model.MyElementId;
import org.mu.model.MyRectangle;
import org.mu.richclient.MyObservable;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

public class CreateRectDialog extends PainterDialog {

    ValidationTF xtf;
    ValidationTF ytf;
    ValidationTF widthtf;
    ValidationTF heighttf;
    private double x;
    private double y;
    private double w;
    private double h;

    @Override
    public Node createContent() {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(5));
        gp.setHgap(5);
        gp.setVgap(5);
        gp.add(xtf = new ValidationTF(this), 0, 0);
        gp.add(ytf = new ValidationTF(this), 0, 1);
        gp.add(widthtf = new ValidationTF(this), 0, 2);
        gp.add(heighttf = new ValidationTF(this), 0, 3);
        return gp;
    }

    public CreateRectDialog() {
        setTitle(Messages.Create_Rectangle.getMess());
        getDialogPane().setContent(new VBox(createContent(), errorLabel));
        validate();
    }

    @Override
    public void ok() throws PainterException {
        FacadeService.getService().create(new MyRectangle(new MyElementId(0), x, y, w, h));
        MyObservable.INST.changed();
    }


    @Override
    public void validate() {
        this.clearError();
        try {
            x = Double.parseDouble(xtf.getText());
            y = Double.parseDouble(ytf.getText());
            h = Double.parseDouble(heighttf.getText());
            w = Double.parseDouble(widthtf.getText());
        } catch (NumberFormatException nfe) {
            setError(Messages.Invalid.getMess());
        }
    }

}
