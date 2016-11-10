/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import org.mu.model.ElementType;
import org.mu.richclient.Options;
import org.mu.richclient.Utils;

/**
 *
 * @author Administrator
 */
public class PainterToolBar extends ToolBar {

    public PainterToolBar() {
        super(ExitAction.INST.genButton(),
                CreateRectangleAction.INST.genButton(), ClearAllAction.INST.genButton());
        getItems().add(new Separator());
        getItems().addAll(Utils.genRadioButtons(Options.INST.elementTypeProperty(),
                ElementType.class, Options.INST.getElementType()));

    }
}
