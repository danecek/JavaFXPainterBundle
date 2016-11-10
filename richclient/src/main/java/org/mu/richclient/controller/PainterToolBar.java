/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.controller;

import javafx.scene.control.ToolBar;
import org.mu.model.ElementType;
import org.mu.richclient.Options;
import org.mu.richclient.Utils;
import org.mu.richclient.controller.CreateRectangleAction;
import org.mu.richclient.controller.ExitAction;

/**
 *
 * @author Administrator
 */
public class PainterToolBar extends ToolBar {

    public PainterToolBar() {
        super(ExitAction.INST.genButton(),
                CreateRectangleAction.INST.genButton());
        getItems().addAll(Utils.genRadioButtons(Options.INST.elementTypeProperty(),
                ElementType.class, Options.INST.getElementType()));

    }
}
