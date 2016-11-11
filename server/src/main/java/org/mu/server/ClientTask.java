/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.business.FacadeService;
import org.mu.protocol.Command;
import org.mu.protocol.Logout;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class ClientTask implements Callable<Object> {

    private static final Logger LOG = Logger.getLogger(ClientTask.class.getName());
    Socket s;

    public ClientTask(Socket s) {
        this.s = s;
    }

    @Override
    public Object call() throws Exception {
        try (Socket s = this.s;
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream())) {
            for (;;) {
                LOG.info("waiting for command");
                Command c = (Command) ois.readObject();
                LOG.info("command:" + c);
                if (c instanceof Logout)
                    break;

                try {
                    Object result = c.execute(FacadeService.getService());
                    oos.writeObject(result);
                } catch (PainterException ex) {
                    oos.writeObject(ex);
                }
                oos.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
