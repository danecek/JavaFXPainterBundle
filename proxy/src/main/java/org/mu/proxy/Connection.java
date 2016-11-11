/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.protocol.Command;
import org.mu.protocol.Logout;
import org.mu.richclient.MyAlert;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class Connection {

    public static Connection INST = new Connection();

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket s;

    private Connection() {
    }

    public void connect(String ia, int port) throws IOException {
        s = new Socket(ia, port);
        s.setSoTimeout(3000);
        ois = new ObjectInputStream(s.getInputStream());
        oos = new ObjectOutputStream(s.getOutputStream());
    }
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    public void disconnect() {
        try (ObjectInputStream ois = this.ois;
                ObjectOutputStream oos = this.oos;
                Socket s = this.s) {
            sent(new Logout());
            this.s = null;
        } catch (PainterException ex) {
            MyAlert.error(ex);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isConnected() {
        return s != null;
    }

    public <T> T sent(Command command) throws PainterException {
        if (!isConnected()) {
            throw new PainterException(Messages.Not_connected.getMess());
        }
        try {
            oos.writeObject(command);
            oos.flush();
            T result = (T) ois.readObject();
            if (result instanceof Exception) {
                throw (PainterException) result;
            }
            return result;

        } catch (IOException ex) {
            Logger.getLogger(ProxyFacade.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new PainterException(ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProxyFacade.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

}
