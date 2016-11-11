package org.mu.proxy;

import java.util.logging.Logger;
import javafx.application.Platform;
import org.mu.business.FacadeService;
import org.mu.richclient.JavaFXPainter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        context.registerService(FacadeService.class, new ProxyFacade(), null);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                JavaFXPainter.INST.addMenu(new ConnectionMenu());
                JavaFXPainter.INST.addTools(ConnectAction.INST.genButton(),
                        DisconnectAction.INST.genButton());
            }
        });
        LOG.info("");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
