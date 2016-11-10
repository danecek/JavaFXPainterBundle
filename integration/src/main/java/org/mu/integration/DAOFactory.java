/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration;

import org.mu.integration.impl.DefaultDAOFactory;
import org.osgi.framework.BundleContext;

public abstract class DAOFactory {

    static DAOFactory service;
    static BundleContext context;

    public static DAOFactory service() {
        if (service == null) {
            service = context.getService(context.getServiceReference(DAOFactory.class));
            if (service == null) {
                service = new DefaultDAOFactory();
            }
        }
        return service;
    }

    static void setContext(BundleContext context) {
        DAOFactory.context = context;
    }

    public abstract ElementDAO getElementDAO();

}
