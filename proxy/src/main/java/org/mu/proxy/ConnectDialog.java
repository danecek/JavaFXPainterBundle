/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.mu.richclient.PainterDialog;
import org.mu.richclient.ValidationTF;
import org.mu.richclient.MyAlert;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class ConnectDialog extends PainterDialog {

    ValidationTF host;
    ValidationTF port;
    private int portNo;

    public ConnectDialog() {
        setTitle(Messages.Connect.getMess());
       // validate();
    }

    @Override
    public Node createContent() {
        GridPane content = new GridPane();
        content.add(new Label(Messages.Host.getMess() + ':'), 0, 0);
        content.add(host = new ValidationTF(this, "127.0.0.1"), 1, 0);
        content.add(new Label(Messages.Port.getMess() + ':'), 0, 1);
        content.add(port = new ValidationTF(this, "3333"), 1, 1);
        return content;
    }

    @Override
    public void ok() throws PainterException {
        try {
            Connection.INST.connect(host.getText(), portNo);
        } catch (IOException ex) {
            MyAlert.error(ex);
        }
    }

    @Override
    public void validate() {
        errorLabel.setText("");
        disableOkProperty.setValue(false);
        if (host.getText().isEmpty()) {
            errorLabel.setText(Messages.Invalid_host.getMess());
            disableOkProperty.setValue(true);
        }
        try {
            portNo = Integer.parseInt(port.getText());
        } catch (NumberFormatException ex) {
            errorLabel.setText(Messages.Invalid_port.getMess());
            disableOkProperty.setValue(true);
        }
    }
}
