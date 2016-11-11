/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.model.MyCircle;
import org.mu.model.MyRectangle;

public class Server implements Runnable {

    private final ServerSocket ss;

    Class[] clss = {MyRectangle.class, MyCircle.class};
    ExecutorService e = Executors.newCachedThreadPool();
    Collection<Future<Object>> clients = new ArrayList<>();

    public Server() throws IOException {
        ss = new ServerSocket(3333);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                LOG.info("waiting for client");
                Socket s = ss.accept();
            //    s.setSoTimeout(3000);
                clients.add(e.submit(new ClientTask(s)));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    private static final Logger LOG = Logger.getLogger(Server.class.getName());

}
