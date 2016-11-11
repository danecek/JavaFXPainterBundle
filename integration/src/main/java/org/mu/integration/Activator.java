package org.mu.integration;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        ServiceTracker<DAOFactory, DAOFactory> st
                = new ServiceTracker<>(context, DAOFactory.class.getName(), null);
        st.open();  // !!!!!!!!
        DAOFactory.setSt(st);
        LOG.info("");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
