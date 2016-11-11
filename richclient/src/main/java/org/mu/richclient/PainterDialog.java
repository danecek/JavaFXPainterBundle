/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import java.util.Optional;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import org.mu.utils.PainterException;

public abstract class PainterDialog extends Dialog<ButtonType> {

    protected Label errorLabel = new Label();
    protected final BooleanProperty disableOkProperty;

    public PainterDialog() {
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        disableOkProperty = getDialogPane().lookupButton(ButtonType.OK).disableProperty();
        getDialogPane().setContent(createContent());
    }

    protected void setError(String mess) {
        errorLabel.setText(mess);
        disableOkProperty.set(true);
    }

    protected void clearError() {
        errorLabel.setText("");
        disableOkProperty.set(false);
    }

    public abstract Node createContent();

    public abstract void ok() throws PainterException;

    public void execute() {
        Optional<ButtonType> btn = showAndWait();
        if (btn.orElse(ButtonType.CANCEL) == ButtonType.OK) {
            try {
                ok();
            } catch (PainterException ex) {
                MyAlert.error(ex);
            }
        }
    }

    public abstract void validate();

}
