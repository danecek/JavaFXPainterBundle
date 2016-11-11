/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.mu.richclient.controller.PainterMenubar;
import org.mu.richclient.controller.PainterToolBar;
import org.mu.richclient.view.ElementTable;
import org.mu.richclient.view.GraphPane;
import org.mu.utils.Messages;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author Administrator
 */
public class JavaFXPainter extends Stage {

    private static final Logger LOG = Logger.getLogger(JavaFXPainter.class.getName());
    public static JavaFXPainter INST;
    private final PainterMenubar pmb;
    private final PainterToolBar ptb;

    public void addMenu(Menu menu) {
        pmb.getMenus().add(menu);
    }

    public void addTools(Button... tools) {
        ptb.getItems().addAll(tools);
    }

    public JavaFXPainter() {
        INST = this;
        setOnCloseRequest(event -> {
            shutdownPlatform();
        });
        pmb = new PainterMenubar();
        ptb = new PainterToolBar();

        VBox root = new VBox(pmb, ptb,
                new SplitPane(new ScrollPane(new GraphPane()), new ElementTable()));

        Scene scene = new Scene(root, 1000, 600);

        setTitle(Messages.Painter.getMess());
        setScene(scene);
        show();
    }

    private static BundleContext context;

    public void setContext(BundleContext context) {
        this.context = context;
    }

    public static void shutdownPlatform() {
        Platform.exit();
        Framework f = (Framework) context.getBundle(0);
        try {
            f.stop(1000);
        } catch (BundleException ex) {
            LOG.warning(ex.toString());
        }
    }

}
