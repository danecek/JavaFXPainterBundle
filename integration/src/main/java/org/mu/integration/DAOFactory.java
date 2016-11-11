/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration;

import org.mu.integration.impl.DefaultDAOFactory;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public abstract class DAOFactory {

    /**
     * @param aSt the st to set
     */
    public static void setSt(ServiceTracker<DAOFactory, DAOFactory> aSt) {
        st = aSt;
    }

    static DAOFactory service;
    protected static ServiceTracker<DAOFactory, DAOFactory> st;

    public static DAOFactory service() {
        if (service == null) {
            service = st.getService();
            if (service == null) {
                service = new DefaultDAOFactory();
            }
        }
        return service;
    }

    public abstract ElementDAO getElementDAO();

}
