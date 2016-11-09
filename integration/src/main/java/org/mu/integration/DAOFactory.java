/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration;

import org.mu.integration.impl.DefaultDAOFactory;

public abstract class DAOFactory {

    static DAOFactory service;

    public static DAOFactory service() {
        if (service == null) {
            // todo lookup
            service = new DefaultDAOFactory();
        }
        return service;
    }

    public abstract ElementDAO getElementDAO();

}
