/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import java.util.Collection;
import org.mu.business.FacadeService;
import org.mu.model.MyElement;
import org.mu.protocol.AllCommand;
import org.mu.protocol.ClearAllCommand;
import org.mu.protocol.CreateCommand;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class ProxyFacade extends FacadeService {

    @Override
    public void create(MyElement elm) throws PainterException {
        Connection.INST.sent(new CreateCommand(elm));
    }

    @Override
    public Collection<MyElement> all() throws PainterException {
        return Connection.INST.sent(new AllCommand());
    }

    @Override
    public void clearAll() throws PainterException {
        Connection.INST.sent(new ClearAllCommand());
    }

    @Override
    public boolean isConnected() {
        return Connection.INST.isConnected();
    }

}
