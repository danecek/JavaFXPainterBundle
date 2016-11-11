/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import org.mu.richclient.controller.PainterMenubar;
import org.mu.richclient.controller.PainterToolBar;
import org.mu.richclient.view.ElementTable;
import org.mu.richclient.view.GraphPane;
import org.osgi.framework.BundleContext;

/**
 *
 * @author Administrator
 */
public class JavaFXPainter extends VBox {

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
        pmb = new PainterMenubar();
        ptb = new PainterToolBar();
        getChildren().addAll(pmb, ptb,
                new SplitPane(new ScrollPane(new GraphPane()), new ElementTable()));
    }

}
