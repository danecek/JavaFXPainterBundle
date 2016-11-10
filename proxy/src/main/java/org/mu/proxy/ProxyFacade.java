/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.business.FacadeService;
import org.mu.model.MyElement;
import org.mu.protocol.AllCommand;
import org.mu.protocol.ClearAllCommand;
import org.mu.protocol.Command;
import org.mu.protocol.CreateCommand;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class ProxyFacade extends FacadeService {

    ObjectInputStream ois;
    ObjectOutputStream oos;

    @Override
    public void create(MyElement elm) throws PainterException {
        sent(new CreateCommand(elm));
    }

    @Override
    public Collection<MyElement> all() throws PainterException {
        return (Collection<MyElement>) sent(new AllCommand());
    }

    @Override
    public void clearAll() throws PainterException {
        sent(new ClearAllCommand());
    }

    private Object sent(Command command) throws PainterException {
        try {
            oos.writeObject(command);
            oos.flush();
            Object result = ois.readObject();
            if (result instanceof Exception) {
                throw (PainterException) result;
            }
            return result;
        } catch (IOException ex) {
            Logger.getLogger(ProxyFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new PainterException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProxyFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

}
