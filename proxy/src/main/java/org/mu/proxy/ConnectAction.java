/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import org.mu.richclient.PainterAction;
import org.mu.utils.Messages;

/**
 *
 * @author Administrator
 */
public class ConnectAction extends PainterAction {
    
    public static ConnectAction INST = new ConnectAction();

    private ConnectAction() {
        super(Messages.Connect.getMess());
    }

    @Override
    public boolean checkDisable() {
       return Connection.INST.isConnected();
    }

    @Override
    public void execute() {
        new ConnectDialog().execute();
    }

}
