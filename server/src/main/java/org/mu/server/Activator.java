package org.mu.server;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
      LOG.info("");
      new Thread(new Server()).start();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
      LOG.info("");
    }
    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

}
