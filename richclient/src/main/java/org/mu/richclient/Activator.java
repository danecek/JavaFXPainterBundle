package org.mu.richclient;

import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.mu.richclient.controller.view.JavaFXPainter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        new JFXPanel(); // start FX platformy
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                JavaFXPainter main = new JavaFXPainter();
                main.setContext(context);
            }
        });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
