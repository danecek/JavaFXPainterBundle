package org.mu.derby;

import java.util.logging.Logger;
import org.mu.integration.DAOFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        context.registerService(DAOFactory.class,
                new DerbyDAOFactory(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
