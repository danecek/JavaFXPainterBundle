/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import java.io.IOException;
import org.mu.richclient.PainterAction;
import org.mu.richclient.MyAlert;
import org.mu.utils.Messages;

/**
 *
 * @author Administrator
 */
public class DisconnectAction extends PainterAction {

    public static DisconnectAction INST = new DisconnectAction();

    private DisconnectAction() {
        super(Messages.Disconnect.getMess());
    }

    @Override
    public boolean checkDisable() {
        return !Connection.INST.isConnected();
    }

    @Override
    public void execute() {
        Connection.INST.disconnect();
    }

}
