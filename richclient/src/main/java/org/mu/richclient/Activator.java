package org.mu.richclient;

import org.mu.richclient.controller.PainterApplication;
import java.util.logging.Logger;
import javafx.application.Application;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        Application.launch(PainterApplication.class);
        PainterApplication.INST.setContext(context);
//        new JFXPanel(); // start FX platformy
//        Platform.runLater(new Runnable() {
//
//            @Override
//            public void run() {
//                JavaFXPainter main = new JavaFXPainter();
//                main.setContext(context);
//              //  MyObservable.INST.changed();
//            }
//        });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
