/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public enum Messages {

    Elements, Graph, Painter, Exit, File, Create_Rectangle, Invalid, Id, Type, X, Y, Clear_all, Not_connected, Connect, Disconnect, Connection, Host, Port, Invalid_host, Invalid_port;
    private static final Logger LOG = Logger.getLogger(Messages.class.getName());

    private static ResourceBundle rb = ResourceBundle.getBundle("org.mu.utils.bundle");

    public String getMess(Object... pars) {
        try {
            String mess = rb.getString(this.name());
            return MessageFormat.format(mess, pars);
        } catch (MissingResourceException ex) {
            //        LOG.log(Level.WARNING, "", ex);
            return name().replace('_', ' ');
        }
    }

}
