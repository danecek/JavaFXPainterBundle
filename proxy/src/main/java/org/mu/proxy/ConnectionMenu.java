/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import javafx.scene.control.Menu;
import org.mu.utils.Messages;

/**
 *
 * @author Administrator
 */
public class ConnectionMenu extends Menu {

    public ConnectionMenu() {
        super(Messages.Connection.getMess());
        getItems().addAll(ConnectAction.INST.genMenuItem(),
                DisconnectAction.INST.genMenuItem());

    }

}
