/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mu.richclient.JavaFXPainter;
import org.mu.richclient.JavaFXPainter;
import org.mu.utils.Messages;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author Administrator
 */
public class PainterApplication extends Application {
    
    public static PainterApplication INST;

    protected BundleContext context;
    private static final Logger LOG = Logger.getLogger(PainterApplication.class.getName());

    public void setContext(BundleContext aContext) {
        context = aContext;
    }

    public PainterApplication() {
        INST = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new JavaFXPainter(), 1000, 600);
        primaryStage.setTitle(Messages.Painter.getMess());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){//shutdownPlatform() {
        Framework f = (Framework) context.getBundle(0);
        try {
            f.stop(1000);
        } catch (BundleException ex) {
            LOG.warning(ex.toString());
        }
    }

}
