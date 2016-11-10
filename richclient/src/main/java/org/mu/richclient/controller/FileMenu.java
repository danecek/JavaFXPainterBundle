/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import javafx.scene.control.Menu;
import org.mu.model.ElementType;
import org.mu.richclient.Options;
import org.mu.richclient.Utils;
import org.mu.utils.Messages;

/**
 *
 * @author Administrator
 */
public class FileMenu extends Menu {

    public FileMenu() {
        super(Messages.File.getMess());
        getItems().addAll(ExitAction.INST.genMenuItem(),
                CreateRectangleAction.INST.genMenuItem());
        getItems().addAll(Utils.genRadioMenuItems(Options.INST.elementTypeProperty(),
                ElementType.class, Options.INST.getElementType()));
    }

}
