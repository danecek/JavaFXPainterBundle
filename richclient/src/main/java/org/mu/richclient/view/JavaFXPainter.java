/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.view;

import java.util.logging.Logger;
import javafxpainter.controller.PainterMenubar;
import javafxpainter.controller.PainterToolBar;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.mu.utils.Messages;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author Administrator
 */
public class JavaFXPainter extends Stage {

    public JavaFXPainter() {

        setOnCloseRequest(event -> {
            shutdownPlatform();
        });

        VBox root = new VBox(new PainterMenubar(), new PainterToolBar(),
                new SplitPane(new ScrollPane(new GraphPane()), new ElementTable()));

        Scene scene = new Scene(root, 1000, 600);

        setTitle(Messages.Painter.getMess());
        setScene(scene);
        System.out.println("JavaFXPainter");
        show();
        
    }

//    public static void main(String[] args) {
//        Application.launch(JavaFXPainter.class, args);
//    }
    BundleContext context;

    public void setContext(BundleContext context) {
        this.context = context;
    }

    private void shutdownPlatform() {
        Framework f = (Framework) context.getBundle(0);
        try {
            f.stop(1000);
        } catch (BundleException ex) {
            LOG.warning(ex.toString());
        }

    }
    private static final Logger LOG = Logger.getLogger(JavaFXPainter.class.getName());

}
